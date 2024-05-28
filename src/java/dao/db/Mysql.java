package dao.db;

import java.sql.Connection;

/**
 * MYSQL SQL语句构造器
 */
public class Mysql extends Builder {
    public Mysql(Connection connect)
    {
        super(connect);
    }
}
