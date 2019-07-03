package com.tyut.servlet;

import com.tyut.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet("/AdminBlogServlet")
public class AdminBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sql = "select * from message";
        /*System.out.println(sql+"\n");*/
        ResultSet rs = DBUtil.executeQuery(sql);
        String data = "";
        try{
            while(rs.next()){

                Integer mid = rs.getInt("mid");
                String  username = rs.getString("username");
                String  title = rs.getString("title");
                String  content = rs.getString("content");
                data = data+mid+"*"+title+"*"+username+"*"+content+"}";
            }
            /*System.out.println(data);*/
            response.getWriter().write(data);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
        return;
    }
}
