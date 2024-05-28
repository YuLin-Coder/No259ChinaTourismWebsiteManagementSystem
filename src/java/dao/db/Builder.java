package dao.db;

import dao.Query;
import util.Info;
import util.StringUtil;

import java.sql.*;
import java.util.*;

/**
 * SQL语句解析基类
 * 构建Query 的数据
 * 将Query类设置的信息生成为真实的sql语句
 */
abstract public class Builder {

    protected String selectSql = "SELECT%DISTINCT% %FIELD% FROM %TABLE%%FORCE%%JOIN%%WHERE%%GROUP%%HAVING%%ORDER%%LIMIT% %LOCK%";
    protected String updateSql = "UPDATE %TABLE% SET %SET%%JOIN%%WHERE% %LOCK%";
    protected String insertSql = "%INSERT% INTO %TABLE% (%FIELD%) VALUES (%DATA%)";
    protected String deleteSql = "DELETE FROM %TABLE%%JOIN%%WHERE%%ORDER%%LIMIT% %LOCK%";

    private boolean isPage = false;

    protected Connection conn;
    public Builder(Connection connect)
    {
        this.conn = connect;
    }


    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }



    static protected Builder content = null;

    /**
     * 构建Builder ，也只能使用这个来生成,会自动判断当前连接的是sqlserver 还是 mysql
     * @param connect
     * @return
     */
    static public Builder make(Connection connect)
    {
        if(content == null){
            String str = connect.toString();
            if(str.indexOf("com.mysql") != -1){
                content = new Mysql(connect);
            }else{
                content = new SqlServer(connect);
            }
        }
        return content;
    }

    /**
     * 获取尚未构建的查询语句，子类可以替换他
     * @return
     */
    protected String getSelectSql()
    {
        return selectSql;
    }

    /**
     * 构建查询语句
     * @param query
     * @return
     */
    public String buildSelect(Query query)
    {
        String sql = getSelectSql();

        return sql.replace("%DISTINCT%" , parseDistinct(query))
                .replace("%FIELD%" , parseField(query))
                .replace("%TABLE%" , parseTable(query))
                .replace("%FORCE%" , parseForce(query))
                .replace("%JOIN%" , parseJoin(query))
                .replace("%WHERE%" , parseWhere(query))
                .replace("%HAVING%" , parseHaving(query))
                .replace("%GROUP%" , parseGroup(query))
                .replace("%ORDER%" , parseOrder(query))
                .replace("%LIMIT%" , parseLimit(query))
                .replace("%LOCK%" , parseLock(query))
                ;
    }

    /**
     * 构建ifnull 代码
     * @param func
     * @param str
     * @return
     */
    public String parseIfNull(String func , String str)
    {
        return "IFNULL("+func+" , "+str+")";
    }

    /**
     * 获取MAP 的所有键
     * @param map
     * @return
     */
    protected ArrayList getHashMapKeys(HashMap map)
    {
        Set keys = map.keySet();
        ArrayList result = new ArrayList();
        Iterator iter = keys.iterator();
        while(iter.hasNext()){
            result.add((String)iter.next());
        }
        return result;
    }

    /**
     * 构建插入语句
     * @param query
     * @param replace
     * @return
     */
    public String buildInsert(Query query , boolean replace)
    {
        HashMap data = query.getData();
        if(data.isEmpty()){
            return "";
        }
        // 没数据不允许插入
        HashMap formatData = parseData(query,data,true);
        // 经过格式化的数据
        ArrayList fields = getHashMapKeys(formatData);
        Collection values = formatData.values();
        //insertSql = "%INSERT% INTO %TABLE% (%FIELD%) VALUES (%DATA%)";
        return insertSql.replace("%INSERT%" , replace?"REPLACE":"INSERT")
                .replace("%TABLE%" , parseTable(query))
                .replace("%FIELD%" , StringUtil.join(" , " , fields))
                .replace("%DATA%" , StringUtil.join(" , ",values))
                ;
    }

    /**
     * 构建删除语句
     * @param query
     * @return
     */
    public String buildDelete(Query query)
    {
        //protected String deleteSql = "DELETE FROM %TABLE%%JOIN%%WHERE%%ORDER%%LIMIT% %LOCK%";

        return deleteSql.replace("%TABLE%" , parseTable(query))
                .replace("%JOIN%" , parseJoin(query))
                .replace("%WHERE%" , parseWhere(query))
                .replace("%ORDER%" , parseOrder(query))
                .replace("%LIMIT%" , parseLimit(query))
                .replace("%LOCK%" , parseLock(query))
                ;
    }

    /**
     * 构建更新语句
     * @param query
     * @return
     */
    public String buildUpdate( Query query )
    {
        HashMap data = query.getData();
        if(data.isEmpty()){
            return "";
        }
        HashMap formatData = parseData(query,data,false);
        Set keys = formatData.keySet();
        ArrayList set = new ArrayList(keys.size());
        Iterator iter = keys.iterator();
        while(iter.hasNext()){
            String key = (String)iter.next();
            String val = (String)formatData.get(key);
            set.add(key + "="+val);
        }
        //protected String updateSql = "UPDATE %TABLE% SET %SET%%JOIN%%WHERE%%ORDER%%LIMIT% %LOCK%";
        return updateSql.replace("%TABLE%" , parseTable(query))
                .replace("%SET%" , StringUtil.join(" , " , set))
                .replace("%JOIN%" , parseJoin(query))
                .replace("%WHERE%" , parseWhere(query))
                .replace("%LOCK%" , parseLock(query))
                ;
    }


    /**
     * 根据字段类型获取对应的默认数据
     * @param type
     * @return
     */
    protected String getFieldDefault(String type)
    {
        String t = type.toUpperCase();
        if(t.equals("DATE")){
            return "'0000-00-00'";
        }else if(t.equals("DATETIME")){
            return "'0000-00-00 00:00:00'";
        }else if(t.equals("TIME")){
            return "'00:00:00'";
        }else if(t.equals("TIMESTAMP")){
            return "'"+ Info.getDateStr()+"'";
        }else if(t.equals("FLOAT") || t.equals("DOUBLE") || t.equals("DECIMAL") || t.indexOf("INT")!=-1){
            return "0";
        }
        return "''";
    }

    /**
     * 获取字段的值
     * @param type
     * @param value
     * @return
     */
    protected String getFieldValue(String type , String value)
    {
        String t = type.toUpperCase();
        if(value == null || value.equals("")){
            // 等于空值，就写入默认值
            return getFieldDefault(type);
        }
        if(t.equals("FLOAT") || t.equals("DOUBLE") || t.equals("DECIMAL") || t.indexOf("INT")!=-1){
            return value;
        }
        return "'"+value.replace("'" , "\\'")+"'";
    }

    /**
     * 获取表字段信息
     * @param name
     * @return
     */
    protected String getTableFind(String name)
    {
        return String.format("SELECT * FROM %s WHERE 1=1 LIMIT 1" , name);
    }

    /**
     * 解析data数据
     * @param query
     * @param data
     * @param isInsert
     * @return
     */
    protected HashMap parseData(Query query , HashMap data , boolean isInsert)
    {
        HashMap result = new HashMap();
        // 分析数据
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(getTableFind(parseTable(query)));
            ResultSetMetaData rsmd = rs.getMetaData();
            int len = rsmd.getColumnCount();

            for (int j = 1; j <= len; j++) {
                String col =rsmd.getColumnName(j);
                if (col.toLowerCase().equals("id")) continue;
                String type = rsmd.getColumnTypeName(j);
                if(data.containsKey(col)){
                    // 数据存在
                    Object content = data.get(col);
                    // 判断他的内容
                    if(content instanceof List){
                        List var = (List)content;
                        if(var.get(0).equals("inc")){
                            result.put(col , col +"+"+ String.valueOf( var.get(1) ));
                        }else if(var.get(0).equals("dec")){
                            result.put(col , col +"-"+ String.valueOf( var.get(1) ));
                        }
                    }else{
                        result.put(col , getFieldValue(type,String.valueOf(content)));
                    }
                    //result.put(col , getFieldValue(type , data.get(col)));
                }else{
                    // 插入的时候才将所有字段弄过去
                    if(isInsert){
                        result.put(col , getFieldDefault(type));
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }



    /**
     * 解析锁表
     * @param query
     * @return
     */
    protected String parseLock(Query query)
    {
        String lock = (String) query.getOption().get("lock");
        if(lock == null){
            return "";
        }
        return lock;
    }


    /**
     * 解析获取的行数
     * @param query
     * @return
     */
    protected String parseLimit(Query query)
    {
        HashMap limit = (HashMap) query.getOption().get("limit");
        if(limit == null || limit.isEmpty()){
            return "";
        }
        Object offset = limit.get("offset");
        Object pagesize  = limit.get("limit");
        if(offset == null){
            return " LIMIT "+pagesize+" ";
        }
        return " LIMIT "+offset+","+pagesize+" ";
    }


    /**
     * 解析字段
     * @param query
     * @return
     */
    protected String parseField(Query query)
    {
        ArrayList list = (ArrayList) query.getOption().get("field");
        if(list == null || list.size() == 0){
            return "*";
        }
        return StringUtil.join("," , list);
    }
    /**
     * 解析是否强制使用索引
     * @param query
     * @return
     */
    protected String parseForce(Query query)
    {
        ArrayList list = (ArrayList) query.getOption().get("force");
        if(list == null || list.size() == 0){
            return "";
        }
        return String.format(" FORCE INDEX ( %s ) " , StringUtil.join("," , list));
    }

    /**
     * 解析去重复
     * @param query
     * @return
     */
    protected String parseDistinct(Query query)
    {
        if(query.getOption().containsKey("distinct")){
            return " DISTINCT ";
        }
        return "";
    }

    /**
     * 解析Having
     * @param query
     * @return
     */
    protected String parseHaving(Query query)
    {
        if(query.getOption().containsKey("having")){
            return " HAVING "+query.getOption().get("having");
        }
        return "";
    }

    /**
     * 获取Query的某个属性
     * @param query
     * @param key
     * @return
     */
    protected String getOptionValue(Query query , String key)
    {
        String val = ( String )query.getOption().get(key);
        if(val == null){
            return "";
        }
        return val+" ";
    }

    /**
     * 解析表
     * @param query
     * @return
     */
    public String parseTable(Query query)
    {
        String name = query.getName();
        ArrayList list = (ArrayList) query.getOption().get("table");
        if(list == null || list.size() == 0){
            return name+" "+ getOptionValue(query ,"alias");
        }
        return StringUtil.join("," , list)+" ";
    }

    /**
     * 解析json 连接
     * @param query
     * @return
     */
    public String parseJoin(Query query)
    {
        ArrayList list = (ArrayList) query.getOption().get("join");
        if(list == null || list.size() == 0){
            return "";
        }
        return " "+ StringUtil.join(" " , list)+" ";
    }

    /**
     * 解析分组
     * @param query
     * @return
     */
    public String parseGroup(Query query)
    {
        ArrayList orderList = (ArrayList) query.getOption().get("group");
        if(orderList == null || orderList.size() == 0){
            return "";
        }
        StringBuffer buffer = new StringBuffer(" GROUP BY ");
        buffer.append(StringUtil.join(",",orderList)).append(" ");
        return buffer.toString();
    }

    /**
     * 解析排序
     * @param query
     * @return
     */
    public String parseOrder(Query query)
    {
        ArrayList orderList = (ArrayList) query.getOption().get("order");
        if(orderList == null || orderList.size() == 0){
            return "";
        }
        StringBuffer buffer = new StringBuffer(" ORDER BY ");
        buffer.append(StringUtil.join(",",orderList)).append(" ");
        return buffer.toString();
    }

    /**
     * 解析条件
     * @param query
     * @return
     */
    public String parseWhere( Query query )
    {
        ArrayList whereList = (ArrayList) query.getOption().get("where");
        if(whereList == null || whereList.size() == 0){
            return "";
        }
        StringBuffer buffer = new StringBuffer(" WHERE ");

        for(int i=0;i<whereList.size();i++)
        {
            HashMap map = (HashMap) whereList.get(i);
            if(i!=0){
                // 每一个的连接符
                buffer.append(" ");
                buffer.append(map.get("connect") == null ? " AND " : map.get("connect"));
                buffer.append(" ");
            }
            String where = (String) map.get("where");
            if(where != null){
                buffer.append(" ").append(where).append(" ");
            }else{
                String key = (String) map.get("name");
                String exp = (String) map.get("exp");
                Object val = map.get("value");

                if(-1 != key.indexOf("|")){
                    String[] keys = key.split("\\|");
                    buffer.append("(");
                    for(int j=0;j<keys.length;j++){
                        if(j!=0){
                            buffer.append(" OR ");
                        }
                        parseWhereItem(buffer , keys[j] , exp , val);
                    }
                    buffer.append(")");
                }else{
                    parseWhereItem(buffer , key , exp , val);
                }
            }
        }
        return buffer.toString();
    }

    /**
     * 格式化字符串
     * @param val
     * @return
     */
    protected String formatString( String val)
    {
        return "'"+val.replace("'" , "\\'")+"'";
    }

    /**
     * 解析条件子语句
     * @param buffer
     * @param key
     * @param exp
     * @param val
     */
    protected void parseWhereItem(StringBuffer buffer , String key , String exp , Object val)
    {
        List<String> exps = Arrays.asList("eq,neq,lt,elt,gt,egt".split(","));
        int index = exps.indexOf(exp);
        String[] exps2 = "=,!=,<,<=,>,=>".split(",");
        if(index != -1){
            exp = exps2[index];
        }
        exp = exp.toLowerCase().trim();
        if(exp.equals("in") || exp.equals("not in")){
            List inArrayList = getParseWhereValueArray(val);

            buffer.append(" ");
            buffer.append(key);
            buffer.append(" "+exp+"("+ StringUtil.join("," , inArrayList)+") ");

        }else if(exp.equals("between") || exp.equals("not between")){
            buffer.append(" ").append(key).append(" ").append(exp).append(" ");
            if(val instanceof String){
                buffer.append(val);
            }else{
                List str = getParseWhereValueArray(val);
                buffer.append( str.get(0) ).append(" AND ").append( str.get(1));
            }
        }else{
            buffer.append(" "+key);
            buffer.append(" "+exp+" ");
            buffer.append(formatString(String.valueOf( val)));
            buffer.append(" ");
        }
    }

    /**
     * 解析条件为数组 或者 list 的时候
     * @param val
     * @return
     */
    protected List getParseWhereValueArray(Object val)
    {
        ArrayList inArrayList = new ArrayList();
        if(val instanceof String || val instanceof String[]){
            String[] inList = val instanceof String ? ((String)val).split(",") : (String[]) val;
            for (int i=0;i<inList.length;i++){
                inArrayList.add(formatString(inList[i]));
            }
        }else if(val instanceof List) {
            for (int i=0;i<((List) val).size();i++)
            {
                inArrayList.add(formatString((String)((List) val).get(i)));
            }
        }else if(val instanceof int[]) {
            for (int i=0;i<((int[]) val).length;i++)
            {
                inArrayList.add(((int[]) val)[i]);
            }
        }else if(val instanceof float[]) {
            for (int i=0;i<((float[]) val).length;i++)
            {
                inArrayList.add(((float[]) val)[i]);
            }
        }else if(val instanceof double[]) {
            for (int i=0;i<((double[]) val).length;i++)
            {
                inArrayList.add(((double[]) val)[i]);
            }
        }else if(val instanceof long[]) {
            for (int i=0;i<((long[]) val).length;i++)
            {
                inArrayList.add(((long[]) val)[i]);
            }
        }else if(val instanceof Iterable)
        {
            Iterator it = ((Iterable)val).iterator();
            while(it.hasNext()){
                Object str = it.next();
                inArrayList.add(formatString(String.valueOf(str)));
            }
        }else if(val instanceof Map){
            Map var = (Map) val;
            Iterator entries = var.entrySet().iterator();

            while (entries.hasNext()) {
                Map.Entry entry = (Map.Entry) entries.next();
                Object value = entry.getValue();
                inArrayList.add(formatString(String.valueOf(value)));
            }
        }
        return inArrayList;
    }
    /**
     * 当前Query 是否为分页
     * @return
     */
    public boolean isPage() {
        return isPage;
    }

    /**
     * 设置为分页
     * @param page
     */
    public void setPage(boolean page) {
        isPage = page;
    }
}
