package com.tyut.servlet;

import com.tyut.pojo.Message;
import com.tyut.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/SelectMessageServlet")
public class SelectMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        boolean judge=true;
        String inputUsername = request.getParameter("select1");
        String inputTitle = request.getParameter("select2");
        if(inputUsername=="" || inputUsername==null){
            judge=false;
        }
        String sql="";
        if(judge){
             sql="SELECT * FROM message WHERE username LIKE'%"+inputUsername+"%'";
        }
        else{
             sql="SELECT * FROM message WHERE title LIKE'%"+inputTitle+"%'";
        }
        System.out.println(sql);
        ResultSet rs = DBUtil.executeQuery(sql);
        try {
            if (!rs.next()) {
                response.sendRedirect("jsp/selectError.jsp");
                return;
            }else {
                rs.previous();
                List<Message> list = new ArrayList<>();
                while(rs.next()){
                    String  username = rs.getString("username");
                    String  title = rs.getString("title");
                    String  content = rs.getString("content");
                    Message message = new Message(title,username,content);
                    list.add(message);
                }
                request.getSession().setAttribute("list",list);
                System.out.println(list.toString());
                response.sendRedirect("jsp/selectSucc.jsp");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       /* String data = "";
        try{
            while(rs.next()){
                String  username = rs.getString("username");
                String  title = rs.getString("title");
                String  content = rs.getString("content");
                data = data+title+"*"+username+"*"+content+"}";
            }
            response.getWriter().write(data);
        }catch (Exception e){
            e.printStackTrace();
        }*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
        return;
    }
}
