package com.honour.login;

import com.honour.entity.User;
import com.honour.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/10/10 0010.
 */
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html;charset=utf-8");
            String username = req.getParameter("username");
            String passworld = req.getParameter("passworld");
            User user = new User();
            user.setUsername(username);
            user.setPwd(passworld);
            UserService service = new UserService();
            User existUser = service.login(user);
            if (existUser == null) {//登录失败
                //使用refresh响应头来设置
//                resp.getWriter().print("登录失败页面将在5秒钟以后进行跳转");
//                resp.setHeader("Refresh", "5;login_fail.html");
                //使用302来设置重定向
                resp.setStatus(302);
                resp.setHeader("Location", "login_fail.html");
            } else {//登录成功
                resp.getWriter().print("登录成功页面将在5秒钟以后进行跳转");
                resp.setHeader("Refresh", "5;index.html");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
