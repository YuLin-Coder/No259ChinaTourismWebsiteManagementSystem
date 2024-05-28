package dao;

import util.Info;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.*;

/**
 * 数据库操作类
 */
public class CommDAO {
    protected static final String JDBC_FILE = "/jdbc.properties";

    public static String dbname = "";
    public static String dbtype = "";

    public static Connection conn = null;
    /**
     * 创建类时即连接数据库
     */
    public CommDAO() {
        conn = this.getConn();
    }

    /**
     * 根据表ID 获取数据
     * @param id   数值
     * @param table 表名称
     * @return
     */
    public HashMap getmap(String id, String table) {
        List<HashMap> list = new ArrayList();
        try {
            Statement st = conn.createStatement();
            //System.out.println("select * from "+table+" where id="+id);
            ResultSet rs = st.executeQuery("select * from " + table + " where id=" + id);
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                HashMap map = new HashMap();
                int i = rsmd.getColumnCount();
                for (int j = 1; j <= i; j++) {
                    if (!rsmd.getColumnName(j).equals("ID")) {
                        String str = rs.getString(j) == null ? "" : rs.getString(j);
                        if (str.equals("null")) str = "";
                        map.put(rsmd.getColumnName(j), str);
                    } else
                        map.put("id", rs.getString(j));
                }
                list.add(map);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list.get(0);
    }

    /**
     * 根据sql 语句获取一行数据
     * @param sql
     * @return
     */
    public HashMap find(String sql) {
        HashMap map = new HashMap();

        //List<HashMap> list = new ArrayList();
        try {
            Statement st = conn.createStatement();
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                //HashMap map = new HashMap();
                int i = rsmd.getColumnCount();
                for (int j = 1; j <= i; j++) {
                    if (!rsmd.getColumnName(j).equals("ID")) {
                        String str = rs.getString(j) == null ? "" : rs.getString(j);
                        if (str.equals("null")) str = "";
                        map.put(rsmd.getColumnName(j), str);
                    } else
                        map.put("id", rs.getString(j));
                }
                //list.add(map);
                break;
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            int code = e.getErrorCode();
            String message = e.getMessage();
            System.err.println("SQL execute Error");
            System.err.println("code:"+code);
            System.err.println("Message:"+message);
        }
        return map;
    }
    /**
     * 根据某字段的值获取一行数据
     * @param nzd  字段名称
     * @param zdz  条件值
     * @param table  表
     * @return
     */
    public HashMap getmaps(String nzd, String zdz, String table) {
        List<HashMap> list = new ArrayList();
        try {
            Statement st = conn.createStatement();
            //System.out.println("select * from "+table+" where "+nzd+"='"+zdz+"'");
            ResultSet rs = st.executeQuery("select * from " + table + " where " + nzd + "='" + zdz + "'");
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                HashMap map = new HashMap();
                int i = rsmd.getColumnCount();
                for (int j = 1; j <= i; j++) {
                    if (!rsmd.getColumnName(j).equals("ID")) {
                        String str = rs.getString(j) == null ? "" : rs.getString(j);
                        if (str.equals("null")) str = "";
                        map.put(rsmd.getColumnName(j), str);
                    } else
                        map.put("id", rs.getString(j));
                }
                list.add(map);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list.get(0);
    }

    /**
     * 获取前台提交的数据将数据写成Map<String , String> 形式，方便写入数据库
     * @param request
     * @return 返回值类型为Map<String, String>
     */
    public static HashMap getParameterStringMap(HttpServletRequest request) {
        Map<String, String[]> properties = request.getParameterMap();//把请求参数封装到Map<String, String[]>中
        HashMap returnMap = new HashMap<String, String>();
        String name = "";
        String value = "";
        for (Map.Entry<String, String[]> entry : properties.entrySet()) {
            name = entry.getKey();
            String[] values = entry.getValue();
            if (null == values) {
                value = "";
            } else if (values.length>1) {
                for (int i = 0; i < values.length; i++) { //用于请求参数中有多个相同名称
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length() - 1);
            } else {
                value = values[0];//用于请求参数中请求参数名唯一
            }
            returnMap.put(name, value);
        }
        return returnMap;
    }
    /**
     * 插入数据库
     * @param request
     * @param response
     * @param tablename
     * @param extmap
     * @param alert
     * @param reflush
     * @param tzurl
     * @return
     */
    public String insert(HttpServletRequest request, HttpServletResponse response, String tablename, HashMap extmap, boolean alert, boolean reflush, String tzurl) {

        extmap.put("addtime", Info.getDateStr());
        if(request.getParameter("f")!= null){
            Query query = new Query(tablename);
            HashMap post = getParameterStringMap(request);
            post.putAll(extmap);
            return query.add(post);
        }
        return "";
    }
    /**
     * 删除数据
     * @param request
     * @param tablename 表名称
     */
    public void delete(HttpServletRequest request, String tablename) {

        int i = 0;
        try {
            String did = request.getParameter("did");
            if (did == null) did = request.getParameter("scid");
            if (did == null) did = request.getParameter("id");
            if (did != null) {
                if (did.length() > 0) {
                    Statement st = conn.createStatement();
                    System.out.println("delete from " + tablename + " where id=" + did);
                    st.execute("delete from " + tablename + " where id=" + did);
                    st.close();
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            int code = e.getErrorCode();
            String message = e.getMessage();
            System.err.println("SQL execute Error");
            System.err.println("code:"+code);
            System.err.println("Message:"+message);
        }
    }


    /**
     * 更新数据
     * @param request
     * @param response
     * @param tablename
     * @param extmap
     * @param alert
     * @param reflush
     * @param tzurl
     * @return
     */
    public String update(HttpServletRequest request, HttpServletResponse response, String tablename, HashMap extmap,
                         boolean alert, boolean reflush, String tzurl) {
        extmap.put("addtime", Info.getDateStr());
        if(request.getParameter("f")!= null){
            Query query = new Query(tablename);
            HashMap post = getParameterStringMap(request);
            post.putAll(extmap);
            if(query.save(post)){
                return "1";
            }
        }
        return "";
    }

    /**
     * 连接数据库
     * @return
     */
    public Connection getConn() {

        try {
            if (conn == null || conn.isClosed()) {
                //org.springframework.jndi.JndiObjectFactoryBean
                Properties pro = new Properties();
                try{
                    pro.load(CommDAO.class.getResourceAsStream(JDBC_FILE));
                }catch (Exception e){
                    System.err.println("未找到配置文件！！！");
                }
                Class.forName(pro.getProperty("driver"));
                conn = DriverManager.getConnection(pro.getProperty("url"),pro.getProperty("username"),pro.getProperty("password"));
            }
        } catch (Exception e) {
            System.err.println("connect database error");
            System.err.println(e.getMessage());

            //e.printStackTrace();
        }
        return conn;
    }



    public long commOper(String sql) {
        System.out.println(sql);
        long autoInsertId = -1;
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(sql , Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys();

            while(rs.next()){
                autoInsertId = rs.getLong(1);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            int code = e.getErrorCode();
            String message = e.getMessage();
            System.err.println("SQL execute Error");
            System.err.println("code:"+code);
            System.err.println("Message:"+message);
        }
        return autoInsertId;
    }

    public List<HashMap> select(String sql) {
        System.out.println(sql);
        List<HashMap> list = new ArrayList();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()) {
                HashMap map = new HashMap();
                int i = rsmd.getColumnCount();
                for (int j = 1; j <= i; j++) {
                    if (!rsmd.getColumnName(j).equals("ID")) {
                        String str = rs.getString(j) == null ? "" : rs.getString(j);
                        if (str.equals("null")) str = "";
                        map.put(rsmd.getColumnName(j), str);
                    } else
                        map.put("id", rs.getString(j));
                }
                list.add(map);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block

            if (sql.equals("show tables"))
                list = select("select table_name from   INFORMATION_SCHEMA.tables");
            else{
                int code = e.getErrorCode();
                String message = e.getMessage();
                System.err.println("SQL execute Error");
                System.err.println("code:"+code);
                System.err.println("Message:"+message);
            }
                //e.printStackTrace();
        }
        return list;
    }


    public void close() {

    }

    /**
     * 执行一条查询sql,以 List<hashmap> 的形式返回查询的记录，记录条数，和从第几条开始，由参数决定，主要用于翻页
     * pageno 页码  rowsize 每页的条数
     */
    public List<HashMap> select(String sql, int pageno, int rowsize) {
        List<HashMap> list = new ArrayList<HashMap>();
        List<HashMap> mlist = new ArrayList<HashMap>();
        try {
            list = this.select(sql);
            int min = (pageno - 1) * rowsize;
            int max = pageno * rowsize;

            for (int i = 0; i < list.size(); i++) {

                if (!(i < min || i > (max - 1))) {
                    mlist.add(list.get(i));
                }
            }
        } catch (RuntimeException re) {
            re.printStackTrace();
            throw re;
        }
        return mlist;
    }


    public static void main(String[] args) {
    }
}


