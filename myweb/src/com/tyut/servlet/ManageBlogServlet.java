package com.tyut.servlet;

import com.tyut.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ManageBlogServlet")
public class ManageBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deleteMid=request.getParameter("mid");
        System.out.println(deleteMid);
        String sql = "delete from message WHERE mid ='"+deleteMid+"'";
        Integer result=0;
        result= DBUtil.executeUpdate(sql);
        if(result>0)
            response.sendRedirect("jsp/ManageBlog.jsp");
        return;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
        return;
    }
}
