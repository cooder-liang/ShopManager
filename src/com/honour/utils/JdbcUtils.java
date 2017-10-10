package com.honour.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 功能  [数据库连接工具类]
 * 作者：梁洋 on 2017/10/10 0010 23:12
 * 邮箱：m18513333561@163.com
 */
public class JdbcUtils {

    //获取数据库连接池
    public static ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");
    //提供ThreadLocation用于在线程池中绑定
    public static ThreadLocal<Connection> local = new ThreadLocal<>();

    //获取链接
    public static Connection getConn() throws SQLException {
        Connection conn = local.get();
        if (conn == null) {
            conn = dataSource.getConnection();
            local.set(conn);
        }
        return local.get();
    }
}
