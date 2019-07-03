package com.tyut.servlet;

import com.tyut.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FreezeUserServlet")
public class FreezeUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String freezeUsername=request.getParameter("username");
        System.out.println(freezeUsername);
        String sql = "update user set freeze=1 WHERE username ='"+freezeUsername+"'";
        Integer result=0;
        result= DBUtil.executeUpdate(sql);
        if(result>0)
            response.sendRedirect("jsp/ManageUser.jsp");
        return;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
        return;
    }
}
