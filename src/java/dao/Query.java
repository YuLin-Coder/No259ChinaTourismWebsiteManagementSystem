package dao;


import dao.db.Builder;
import util.Info;
import util.StringUtil;

import java.sql.*;
import java.util.*;

/**
 * 操作数据库链式执行
 * 目前只实现了部分方法，之后会继续完善该代码,让其支持实体类的数据获取
 * 使用方法：Query.make("表名称").where("字段名" , "条件符号","条件值").select()
 *
 */
public class Query {
    protected String mName = "";
    protected HashMap mOption = null;
    protected String pk = "id";
    protected HashMap mData = null;
    protected Builder builder = null;


    public static HashMap tableFields = new HashMap();


    public Query()
    {
        reset();
    }
    /**
     * 构造Query
     * @param name
     */
    public Query(String name)
    {
        reset();
        setName(name);
    }
    /**
     * 重置并初始化数据
     * @return
     */
    protected Query reset()
    {
        mName = "";
        mOption = null;
        mOption = new HashMap();
        mData = new HashMap();
        builder = Builder.make(new CommDAO().getConn());

        if(tableFields == null)
        {
            tableFields = new HashMap();
        }
        return this;
    }
    /**
     * 设置一个字段自增
     * @param field
     * @param step
     * @return
     */
    public Query inc(String field , int step)
    {
        if(step<1)step = 1;
        ArrayList list = new ArrayList();
        list.add("inc");
        list.add(step);
        mData.put(field , list);
        return this;
    }
    /**
     * 设置一个字段自减
     * @param field
     * @param step
     * @return
     */
    public Query dec(String field , int step)
    {
        if(step<1)step = 1;
        ArrayList list = new ArrayList();
        list.add("dec");
        list.add(step);
        mData.put(field , list);
        return this;
    }
    /**
     * 马上更新数据字段自增1
     * @param field
     * @return
     */
    public boolean setInc(String field)
    {
        return setInc(field ,1);
    }
    /**
     * 马上更新数据字段自增step
     * @param field
     * @param step
     * @return
     */
    public boolean setInc(String field , String step)
    {
        return inc(field , Integer.valueOf(step).intValue()).update();
    }
    /**
     * 马上更新数据字段自增step
     * @param field
     * @param step
     * @return
     */
    public boolean setInc(String field , int step)
    {
        return inc(field , step).update();
    }
    /**
     * 马上更新数据字段自减1
     * @param field
     * @return
     */
    public boolean setDec(String field )
    {
        return setDec(field , 1);
    }
    /**
     * 马上更新数据字段自减step
     * @param field
     * @param step
     * @return
     */
    public boolean setDec(String field , String step)
    {
        return dec(field , Integer.valueOf(step).intValue()).update();
    }
    /**
     * 马上更新数据字段自减step
     * @param field
     * @param step
     * @return
     */
    public boolean setDec(String field , int step)
    {
        return dec(field , step).update();
    }
    /**
     * 设置某字段为某个值，并更新
     * @param field
     * @param step
     * @return
     */
    public boolean setField(String field , Object step)
    {
        mData.put(field , step);
        return update();
    }
    /**
     * 获取当前写入的data
     * @return
     */
    public HashMap getData()
    {
        return mData;
    }
    /**
     * 更新当前数据
     * @return
     */
    public boolean update()
    {
        return update(null);
    }
    /**
     * 更新当前数据加写入的data
     * @param updateData
     * @return
     */
    public boolean update( HashMap updateData )
    {
        if(updateData != null){
            mData.putAll(updateData);
        }
        String sql = builder.buildUpdate(this);
        executeInsert(sql);
        return true;
    }
    /**
     * 向query 写入data
     * @param data
     * @return
     */
    public Query data(Map data)
    {
        mData.putAll(data);
        return this;
    }
    /**
     * 向当前query 写入data
     * @param name
     * @param value
     * @return
     */
    public Query data(String name , String value)
    {
        mData.put(name , value);
        return this;
    }
    /**
     * 向当前query 写入data
     * @param name
     * @param value
     * @return
     */
    public Query data(String name , int value)
    {
        mData.put(name , value);
        return this;
    }
    /**
     * 向当前query 写入data
     * @param name
     * @param value
     * @return
     */
    public Query data(String name , long value)
    {
        mData.put(name , value);
        return this;
    }
    /**
     * 向当前query 写入data
     * @param name
     * @param value
     * @return
     */
    public Query data(String name , float value)
    {
        mData.put(name , value);
        return this;
    }
    /**
     * 向当前query 写入data
     * @param name
     * @param value
     * @return
     */
    public Query data(String name , double value)
    {
        mData.put(name , value);
        return this;
    }
    /**
     * 向当前query 写入data
     * @param name
     * @param value
     * @return
     */
    public Query data(String name , boolean value)
    {
        mData.put(name , value ? 1 : 0);
        return this;
    }

    /**
     * 插入数据
     * @param insertData
     * @return
     */
    public int insert(HashMap insertData ){ return insert(insertData , false); }
    /**
     * 插入数据
     * @param insertData
     * @param replace
     * @return
     */
    public int insert(HashMap insertData , boolean replace)
    {
        if(insertData != null){
            mData.putAll(insertData);
        }
        String sql = builder.buildInsert(this , replace);
        return executeInsert(sql);
    }
    /**
     * 获取当前自增字段名称
     * @return
     */
    public String getPk() {
        return pk;
    }
    /**
     * 设置自增字段名
     * @param pk
     */
    public void setPk(String pk) {
        this.pk = pk;
    }
    /**
     * 尚未实现该代码，获取表的数据
     */
    protected void finalize()
    {

        //Statement st = conn.createStatement();
        //System.out.print(sql);
        //ResultSet rs
        //super.finalize();

        free();
    }

    /**
     * 释放资源
     */
    public void free()
    {
        // 释放rs
        for(int i=0;i<resultSetList.size();i++){
            Object os = resultSetList.get(i);
            try{
                if(os instanceof Statement){
                    Statement st = ((Statement) os);
                    st.close();
                }else if(os instanceof ResultSet){
                    ((ResultSet) os).close();
                }
            }catch (SQLException e){
            }
        }
        resultSetList.clear();
    }
    /**
     * 设置表名称
     * @param name
     * @return
     */
    public Query setName(String name)
    {
        mName = name;
        return this;
    }

    /**
     * 获取表名称
     * @return
     */
    public String getName()
    {
        return mName;
    }

    /**
     * 设置属性
     * @param name
     * @param value
     * @return
     */
    public Query setAttribute(String name , Object value)
    {
        getOptionHashMap("data").put(name , value);
        return this;
    }
    /**
     * 获取属性
     * @param name
     * @return
     */
    public Object getAttribute(String name)
    {
        return getOptionHashMap("data").get(name);
    }
    /**
     * 设置字段为 获取所有字段
     * @return
     */
    public Query field()
    {
        return field("*");
    }
    /**
     * 设置字段，可以用","逗号隔开多个
     * @param field
     * @return
     */
    public Query field(String field)
    {
        getOptionArrayList("field").add(field);
        return this;
    }
    /**
     * 设置表
     * @param nTable
     * @return
     */
    public Query table(String nTable)
    {
        getOptionArrayList("table").add(nTable);
        return this;
    }
    /**
     * 设置表
     * @param nTable
     * @return
     */
    public Query table(String nTable , String alias)
    {
        getOptionArrayList("table").add(nTable+" "+alias);
        return this;
    }
    /**
     * 设置行数
     * @param nLimit
     * @return
     */
    public Query limit(int nLimit)
    {
        //getOptionHashMap("limit").put("limit" , String.valueOf(nLimit));
        return limit(String.valueOf(nLimit));
    }
    /**
     * 设置起始行和行数
     * @param offset
     * @param nLimit
     * @return
     */
    public Query limit(int offset , int nLimit)
    {
        return limit(String.valueOf(offset) , String.valueOf(nLimit));
    }
    /**
     * 设置是否锁表
     * @param lock
     * @return
     */
    public Query lock(boolean lock )
    {
        return this.lock(lock ? " FOR UPDATE " : "");
    }
    /**
     * 设置锁表代码
     * @param lock
     * @return
     */
    public Query lock(String lock)
    {
        getOption().put("lock" , lock);
        return this;
    }
    /**
     * 设置行数，字符串形式
     * @param nLimit
     * @return
     */
    public Query limit(String nLimit)
    {
        if(nLimit.indexOf(",") != -1){
            String[] list = nLimit.split(",");
            return limit(list[0] , list[1]);
        }
        getOptionHashMap("limit").put("limit" , nLimit);
        return this;
    }
    /**
     * 设置起始行和行数
     * @param offset
     * @param nLimit
     * @return
     */
    public Query limit(String offset , String nLimit)
    {
        HashMap map = getOptionHashMap("limit");
        map.put("limit" , nLimit);
        map.put("offset" , offset);
        return this;
    }
    /**
     * 根据ID 获取一行数据
     * @param id
     * @return
     */
    public HashMap find(int id)
    {
        where(pk , String.valueOf(id));
        return find();
    }
    /**
     * 根据ID 获取一行数据
     * @param id
     * @return
     */
    public HashMap find(String id)
    {
        where(pk , id);
        return find();
    }
    /**
     * 根据当前条件获取一行数据
     * @return
     */
    public HashMap find()
    {
        //limit(1);
        String sql = builder.buildSelect(this);
        ResultSet rs = query(sql);
        QueryData data = fetch(rs);
        return data;
    }
    /**
     * 生成统计计算语句
     * @param f
     * @param func
     * @return
     */
    protected double total(String f , String func)
    {
        String ifnull = builder.parseIfNull(func+"("+f+")" , "0");
        String field = ifnull+" count";
        if(mOption.containsKey("field")){
            getOptionArrayList("field").clear();
        }
        getOptionArrayList("field").add(field);
        HashMap data = find();
        if(data.containsKey("count")){
            String count = data.get("count").toString();
            return Double.valueOf(count).doubleValue();
        }
        return 0;
    }
    /**
     * 求某字段和
     * @param field
     * @return
     */
    public double sum(String field)
    {
        return total(field , "SUM");
    }
    /**
     * 求某字段的平均值
     * @param field
     * @return
     */
    public double avg(String field)
    {
        return total(field , "AVG");
    }
    /**
     * 求最大值
     * @param field
     * @return
     */
    public double max(String field){
        return total(field , "MAX");
    }
    /**
     * 求最小值
     * @param field
     * @return
     */
    public double min(String field)
    {
        return total(field , "MIN");
    }
    /**
     * 求数据行数
     * @return
     */
    public long count()
    {
        return count(null);
    }
    /**
     * 根据字段名求数据行数
     * @return
     */
    public long count( String field )
    {
        if(field == null){
            if(mOption.containsKey("alias")){
                field = "count("+mOption.get("alias")+".id) count";
            }else{
                field = "count(*) count";
            }
        }else{
            field = "count("+field+") count";
        }
        if(mOption.containsKey("field")){
            mOption.put("field" , new ArrayList());
            //getOptionArrayList("field").clear();
        }
        if(mOption.containsKey("order")){
            mOption.remove("order");
        }
        getOptionArrayList("field").add(field);
        HashMap data = find();
        if(data.containsKey("count")){
            return Long.valueOf((String)data.get("count")).longValue();
        }
        return 0;
    }
    /**
     * 根据列表id 删除数据
     * @param ids
     * @return
     */
    public long delete(List ids)
    {
        where(getPk() , "in" , ids);
        return delete();
    }
    /**
     * 根据id 删除数据
     * @param id
     * @return
     */
    public long delete(int id)
    {
        where(getPk() , id);
        return delete();
    }
    /**
     * 根据id 删除数据
     * @param id
     * @return
     */
    public long delete(String id)
    {
        if(id.indexOf(",")!=-1){
            where(getPk() , "in" , id);
        }else{
            where(getPk() , id);
        }
        return delete();
    }
    /**
     * 根据当前条件删除数据，如果没有条件则不执行删除
     * @return
     */
    public long delete()
    {
        if(!mOption.containsKey("where")){
            return -1;
        }
        String sql = this.builder.buildDelete(this);
        return executeUpdate(sql);
    }

    /**
     * 根据当前条件获取数据集
     * @return
     */
    public ArrayList select()
    {
        ArrayList result = new ArrayList();
        String sql = builder.buildSelect(this);

        ResultSet rs = query(sql);
        if (rs == null) {
            return result;
        }
        QueryData data = null;
        while( !((data = fetch(rs)).isEmpty()) ){
            result.add(data);
        }
        return result;
    }

    /**
     * 根据ResultSet 获取数据行
     * @param rs
     * @return
     */
    public QueryData fetch(ResultSet rs)
    {
        QueryData data = new QueryData();
        if(rs == null)return data;
        try {
            if(rs.next()){
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                for(int i=1;i<=columnCount;i++){
                    String name = rsmd.getColumnName(i);
                    String value = rs.getString(i);
                    if(value == null || value.toLowerCase().equals("null")){
                        value = "";
                    }
                    data.put(name , value);
                }
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }
        return data;
    }

    protected ArrayList resultSetList = new ArrayList();
    /**
     * 查询sql 语句并返回ResultSet，这个不需要释放，系统在释放时会自动释放
     * @param sql
     * @return
     */
    public ResultSet query(String sql)
    {
        try {
            Connection conn = this.getConn();
            Statement st = conn.createStatement();
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);

            resultSetList.add(rs);
            resultSetList.add(st);
            return rs;
        }catch (SQLException e){
            int code = e.getErrorCode();
            String message = e.getMessage();
            System.err.println("SQL execute Error");
            System.err.println("code:"+code);
            System.err.println("Message:"+message);
            //e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据当前条件获取一行数据中的某个字段的值
     * @param name
     * @return
     */
    public String value(String name)
    {
        if(!mOption.containsKey("field")){
            field(name);
        }
        HashMap data = find();
        if(data.isEmpty()){
            return "";
        }
        return String.valueOf(data.get(name));
    }

    /**
     * 设置SQL 分组
     * @param nGroup
     * @return
     */
    public Query group(String nGroup)
    {
        getOptionArrayList("group").add(nGroup);
        return this;
    }
    /**
     * 设置 SQL 排序字段
     * @param nOrder
     * @return
     */
    public Query order(String nOrder)
    {
        getOptionArrayList("order").add(nOrder);
        return this;
    }
    /**
     * 设置SQL语句使用全连接 会生成如下：INNER JOIN table t on cond 的形式
     * @param table
     * @param cond 条件
     * @return
     */
    public Query joinInner(String table , String cond)
    {
        return join(table , cond , "INNER");
    }
    /**
     * 设置sql 语句使用右连接 会生成如下：RIGHT JOIN table t on cond 的形式
     * @param table
     * @param cond
     * @return
     */
    public Query joinRight(String table , String cond)
    {
        return join(table , cond , "RIGHT");
    }
    /**
     * 设置sql 语句使用左连接 会生成如下：table t on cond 的形式
     * @param table
     * @param cond
     * @return
     */
    public Query joinLeft(String table , String cond)
    {
        return join(table , cond , "LEFT");
    }
    /**
     * 设置sql 语句使用右连接 会生成如下：type JOIN table t on cond 的形式
     * @param table
     * @param cond
     * @param type 跨不会类型
     * @return
     */
    public Query join(String table , String cond , String type)
    {
        StringBuffer buffer = new StringBuffer();
        buffer.append(" ").append(type).append(" JOIN ").append(table).append(" ON ").append(cond);

        getOptionArrayList("join").add(buffer.toString());
        return this;
    }
    /**
     * 设置当前表的别名
     * @param name
     * @return
     */
    public Query alias(String name)
    {
        mOption.put("alias" , name);
        return this;
    }

    /**
     * 获取设置参数
     * @param type
     * @return
     */
    private HashMap getOptionHashMap(String type)
    {
        if(mOption.containsKey(type)){
            return (HashMap) mOption.get(type);
        }
        HashMap map = new HashMap();
        mOption.put(type , map);
        return map;
    }
    /**
     * 获取设置参数
     * @param type
     * @return
     */
    private ArrayList getOptionArrayList(String type)
    {
        if(mOption.containsKey(type)){
            return (ArrayList) mOption.get(type);
        }
        ArrayList map = new ArrayList();
        mOption.put(type , map);
        return map;
    }
    /**
     * 设置SQL条件
     * @param name
     * @return
     */
    public Query where(String name)
    {
        HashMap list = new HashMap();
        list.put("where" , name);
        getOptionArrayList("where").add(list);
        return this;
    }
    /**
     * 设置SQL条件 会自动写成 and name='value' 这样的形式
     * @param name 字段名
     * @param value 条件值
     * @return
     */
    public Query where(String name , Object value)
    {
        return where(name , null , value ,null);
    }
    /**
     * 设置SQL条件 会自动写成 and name eq 'value' 这样的形式
     * @param name
     * @param eq   符号，可以写成：=、>、>=、<、<=、eq、neq、gt、egt、lt、elt
     * @param value
     * @return
     */
    public Query where(String name , String eq, Object value)
    {
        return where(name , eq , value ,null);
    }
    /**
     * 设置SQL条件 会自动写成 and name eq 'value' 这样的形式
     * @param name
     * @param eq   符号，可以写成：=、>、>=、<、<=、eq、neq、gt、egt、lt、elt
     * @param Value
     * @param connect  连接符默认为：and
     * @return
     */
    public Query where(String name , String eq , Object Value , String connect)
    {
        HashMap list = new HashMap();
        list.put("name",name);
        list.put("exp" , eq == null ? "=" : eq);
        list.put("value",Value == null ? "" : Value);
        list.put("connect",connect == null ? "and" : connect);

        getOptionArrayList("where").add(list);

        return this;
    }
    /**
     * 设置SQL条件 会自动写成 and field in(inArray) 这样的形式
     * @param field
     * @param inArray
     * @return
     */
    public Query whereIn(String field , String inArray)
    {
        String[] arr = inArray.split(",");
        return where(field , "in" , arr);
    }
    /**
     * 设置SQL条件 会自动写成 and field in(inArray1,inArray2) 这样的形式
     * @param field
     * @param inArray
     * @return
     */
    public Query whereIn(String field , Object inArray)
    {
        return where(field , "in" , inArray);
    }
    /**
     * 设置SQL条件 会自动写成 and field in(inArray1,inArray2) 这样的形式
     * @param field
     * @param inArray
     * @return
     */
    public Query whereInNot(String field , Object inArray)
    {
        return where(field , "not in" , inArray);
    }
    /**
     * 设置SQL条件 会自动写成 and field between inArray 这样的形式
     * @param field
     * @param inArray
     * @return
     */
    public Query whereBetween(String field , String inArray)
    {
        String[] arr = inArray.split(",");
        return where(field , "between" , arr);
    }
    /**
     * 设置SQL条件 会自动写成 and field between 'start' and 'end' 这样的形式
     * @param field
     * @param start
     * @param end
     * @return
     */
    public Query whereBetween(String field , String start , String end)
    {
        return where(field , "between" , "'"+start+"' AND '"+end+"'");
    }
    /**
     * 设置SQL条件 会自动写成 and field not between inArray 这样的形式
     * @param field
     * @param inArray
     * @return
     */
    public Query whereBetweenNot(String field , String inArray)
    {
        String[] arr = inArray.split(",");
        return where(field , "not between" , arr);
    }
    /**
     * 设置SQL条件 会自动写成 and field not between 'start' and 'end' 这样的形式
     * @param field
     * @param start
     * @param end
     * @return
     */
    public Query whereBetweenNot(String field , String start , String end)
    {
        return where(field , "not between" , "'"+start+"' AND '"+end+"'");
    }

    /**
     * 获取connection 连接
     * @return
     */
    protected Connection getConn()
    {
        return new CommDAO().getConn();
    }

    /**
     * 根据字段类型生成默认值
     * @param type
     * @return
     */
    protected String getFieldDefault(String type)
    {
        String t = type.toUpperCase();
        if(t.equals("DATE")){
            return "0000-00-00";
        }else if(t.equals("DATETIME")){
            return "0000-00-00 00:00:00";
        }else if(t.equals("TIME")){
            return "00:00:00";
        }else if(t.equals("TIMESTAMP")){
            return Info.getDateStr();
        }else if(t.equals("FLOAT") || t.equals("DOUBLE") || t.equals("DECIMAL") || t.indexOf("INT")!=-1){
            return "0";
        }
        return "''";
    }
    /**
     * 设置字段信息防止xxs 注入
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
     * @param table
     * @return
     */
    protected HashMap getTableField(String table )
    {
        if(table == null){
            table = mName;
        }

        if(tableFields.containsKey(table)){
            return (HashMap) tableFields.get(table);
        }

        HashMap result = new HashMap();
        try{
            Connection conn = this.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from " + table);
            ResultSetMetaData rsmd = rs.getMetaData();
            int i = rsmd.getColumnCount();
            for (int j = 1; j <= i; j++) {
                result.put(rsmd.getColumnName(j) , rsmd.getColumnTypeName(j));
            }
            rs.close();
            st.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 根据表字段生成键值 和 value值
     * @param map    数据
     * @param fields 空的字段信息
     * @param values 空的value 值 也就是要写入的值，不需要传值
     * @param isInsert  是否为插入，插入的话要写入默认值
     */
    protected void getFieldValueList(HashMap map , ArrayList fields , ArrayList values , boolean isInsert)
    {
        try{
            Connection conn = this.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from " + mName);

            ResultSetMetaData rsmd = rs.getMetaData();
            int i = rsmd.getColumnCount();
            for (int j = 1; j <= i; j++) {
                String col =rsmd.getColumnName(j);
                if (col.toLowerCase().equals("id")) continue;
                String type = rsmd.getColumnTypeName(j);
                if(map.containsKey(col)){
                    // 存在,就不理他了
                    fields.add(col);
                    values.add(getFieldValue(type ,String.valueOf(map.get(col))) );
                }else{
                    // 插入的时候才将所有字段弄过去
                    if(isInsert){
                        fields.add(col);
                        values.add(getFieldDefault(type));
                    }

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 添加数据
     * @param map
     * @return
     */
    public String add( HashMap map )
    {
        return String.valueOf(insert(map , false));
    }

    /**
     * 更新数据
     * @param map
     * @return
     */
    public boolean save(HashMap map)
    {
        return update(map);
    }

    /**
     * 执行插入语句
     * @param sql
     * @return
     */
    public int executeInsert(String sql)
    {
        try {
            Connection conn = this.getConn();
            Statement rs = conn.createStatement();
            System.out.println(sql);
            rs.executeUpdate(sql , Statement.RETURN_GENERATED_KEYS);
            ResultSet rsKey = rs.getGeneratedKeys();
            rsKey.next();
            int id = rsKey.getInt(1);
            rsKey.close();
            rs.close();
            return id;
        }catch (SQLException e)
        {
            int code = e.getErrorCode();
            String message = e.getMessage();
            System.err.println("SQL execute Error");
            System.err.println("code:"+code);
            System.err.println("Message:"+message);
            //e.printStackTrace();
        }
        return -1;
    }

    /**
     * 执行语句
     * @param sql
     * @return
     */
    public static int execute(String sql)
    {
        try {
            Connection conn = new CommDAO().getConn();
            Statement rs = conn.createStatement();
            System.out.println(sql);
            int id = rs.executeUpdate(sql , Statement.RETURN_GENERATED_KEYS);
            rs.close();
            return id;
        }catch (SQLException e)
        {
            int code = e.getErrorCode();
            String message = e.getMessage();
            System.err.println("SQL execute Error");
            System.err.println("code:"+code);
            System.err.println("Message:"+message);
            //e.printStackTrace();
        }
        return -1;
    }

    /**
     * 执行更新语句
     * @param sql
     * @return
     */
    public int executeUpdate(String sql)
    {
        try {
            Connection conn = this.getConn();
            Statement rs = conn.createStatement();
            System.out.println(sql);
            int id = rs.executeUpdate(sql , Statement.RETURN_GENERATED_KEYS);
            rs.close();
            return id;
        }catch (SQLException e)
        {
            int code = e.getErrorCode();
            String message = e.getMessage();
            System.err.println("SQL execute Error");
            System.err.println("code:"+code);
            System.err.println("Message:"+message);
            //e.printStackTrace();
        }
        return -1;
    }

    /**
     * 快速构建Query
     * @param name
     * @return
     */
    public static Query make(String name)
    {
        Query query = new Query();
        query.setName(name);
        return query;
    }

    /**
     * 获取一页数据，并生成分页代码
     * @param pagesize
     * @return
     */
    public Collect page(int pagesize )
    {
        Query c = new Query(getName());
        c.mOption.putAll(mOption);
        // 总长度
        long count = c.count();
        Collect result = new Collect( count , pagesize);
        this.limit(result.firstRow , result.listRows);
        builder.setPage(true);
        ArrayList list = select();
        builder.setPage(false);
        result.addAll(list);
        return result;
    }
    /**
     * 根据当前条件，获取一列的数据
     * @param field
     * @return
     */
    public List<String> getCol(String field)
    {
        List<String> result = new ArrayList<>();
        // 取某一列
        List<HashMap> list= select();
        for (HashMap map:list){
            result.add(map.get(field).toString());
        }
        return result;
    }
    /**
     * 根据当前条件获取列数据,健对值的关系
     * @param field
     * @param key
     * @return
     */
    public Map<String ,String> getColkey(String field , String key)
    {
        Map result = new LinkedHashMap();
        List<HashMap> list= select();
        for (HashMap map:list){
            result.put(map.get(key).toString(),map.get(field).toString());
        }
        return result;
    }

    public HashMap getOption() {
        return mOption;
    }
}
