package com.tyut.servlet;

import com.mysql.cj.Session;
import com.tyut.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String inputPassword = request.getParameter("password");
        String jugde="SELECT password,type FROM user WHERE username ='"+username+"'";
        ResultSet ifExist=null;
        ifExist= DBUtil.executeQuery(jugde);
        try {
            if(!ifExist.next()){
                response.sendRedirect("jsp/loginError.jsp");
                return;
            }else {
                String DBpassword=ifExist.getString("password");
                Integer userType=ifExist.getInt("type");
                if(DBpassword.equals(inputPassword)){
                    request.getSession().setAttribute("username",username);
                    if(userType==0){
                        response.sendRedirect("jsp/loginedMain.jsp");
                    }

                    else
                        response.sendRedirect("jsp/AdminLoginMain.jsp");
                }else {
                    response.sendRedirect("jsp/loginError.jsp");
                }
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
        return;
    }
}
