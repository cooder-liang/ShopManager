package com.honour.dao;

import com.honour.entity.User;
import com.honour.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * 功能  [用户数据库操作类]
 * 作者：梁洋 on 2017/10/10 0010 23:01
 * 邮箱：m18513333561@163.com
 */
public class UserDao {

    /**
     * 登录
     *
     * @param user
     * @return
     * @throws SQLException
     */
    public User login(User user) throws SQLException {
        QueryRunner runner = new QueryRunner(JdbcUtils.dataSource);
        String sql = "select * from user where username=? and pwd=?";
        return runner.query(sql, new BeanHandler<User>(User.class), user.getUsername(), user.getPwd());
    }
}
