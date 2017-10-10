package com.honour.service;

import com.honour.dao.UserDao;
import com.honour.entity.User;

import java.sql.SQLException;

/**
 * 功能  [用户服务类]
 * 作者：梁洋 on 2017/10/10 0010 23:01
 * 邮箱：m18513333561@163.com
 */
public class UserService {

    public User login(User user) throws SQLException {
        UserDao dao=new UserDao();
        return dao.login(user);
    }
}
