package com.tyut.servlet;

import com.tyut.utils.DBUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String jugde="SELECT username FROM user WHERE username ='"+username+"'";
        ResultSet ifExist=null;
        ifExist=DBUtil.executeQuery(jugde);
        try {
            if(ifExist.next()){
                response.sendRedirect("jsp/registerError.jsp");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String birthday = request.getParameter("birthday");
        String introduction = request.getParameter("introduction");
        String[] hobbies = request.getParameterValues("hobby");
        String telephone = request.getParameter("telephone");
        String hobby="";
        for(int i=0;i<hobbies.length;i++){
            hobby=hobby+" "+hobbies[i];
        }
        String sql="INSERT INTO user(username,password,gender,birthday,hobby,email,telephone,introduction)" +
                "VALUE(?,?,?,?,?,?,?,?)";
        int result=0;
        try{
            PreparedStatement ps=DBUtil.executePreparedStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,gender);
            ps.setString(4,birthday);
            ps.setString(5,hobby);
            ps.setString(6,email);
            ps.setString(7,telephone);
            ps.setString(8,introduction);
            result=ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        if(result>0){
            response.sendRedirect("jsp/registerSucc.jsp");
        }
        return;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
        return;
    }
}
