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

@WebServlet("/LeaveMessageServlet")
public class LeaveMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nowUsername = (String) request.getSession().getAttribute("username");
        /*是否被冻结*/
        String query="SELECT freeze FROM user WHERE username ='"+nowUsername+"'";
        ResultSet ifFreeze=DBUtil.executeQuery(query);
        try{
            while(ifFreeze.next()){
                Integer key = ifFreeze.getInt("freeze");
                if(key==1){
                    response.sendRedirect("jsp/leaveMessageError.jsp");
                    return;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        /*是否被冻结*/
        String nowTitle= request.getParameter("title");
        String nowContent= request.getParameter("content");
        String sql="INSERT INTO message(username,title,content)" +
                "VALUE(?,?,?)";
        int result=0;
        try{
            PreparedStatement ps= DBUtil.executePreparedStatement(sql);
            ps.setString(1,nowUsername);
            ps.setString(2,nowTitle);
            ps.setString(3,nowContent);
            result=ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        if(result>0){
            response.sendRedirect("jsp/leaveMessageSucc.jsp");
        }
        return;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
        return;
    }
}
