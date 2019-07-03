<%@ page import="java.util.List" %>
<%@ page import="com.tyut.pojo.Message" %><%--
  Created by IntelliJ IDEA.
  User: 詹帆
  Date: 2019/6/16
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="utf-8">
    <title>博客论坛</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../css/start.css"/>
    <script src="../js/jquery-2.1.0.min.js"></script>
    <script src="../js/loginedMain.js"></script>
</head>
<body>
<div class="jumbotron text-center" style="margin-bottom:0">
    <h1>欢迎来到本论坛！</h1>
    <p>你可以在论坛中发表你的观点与看法</p>
</div>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">功能导航:</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="loginedMain.jsp">主页</a></li>
                <li><a href="myblog.jsp">我的博客</a></li>
                <li class="active"><a href="#">博客查询</a></li>
                <li><a href="leaveMessage.jsp">发表博客</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-sm-4">
            <h3>用户名</h3>
            <p><span><%= request.getSession().getAttribute("username")%></span></p>
            <ul class="nav nav-pills nav-stacked">
                <li class="active"><a href="#">已登录</a></li>
                <li><a href="../html/register.html">注册</a></li>
                <li><a href="unloginMain.jsp">注销</a></li>
            </ul>
            <hr class="hidden-sm hidden-md hidden-lg">
        </div>
        <div class="col-sm-8">
            <form action="/SelectMessageServlet">
                <table class="nav nav-pills nav-stacked">
                    <tr>
                        <td></td>
                        <td><input name="select1" type="text" placeholder="按用户名查找" class="login_button2"/></td>
                    </tr>
                    <tr>
                        <td class="selectWhite">-</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input name="select2" type="text" placeholder="按博客名查找" class="login_button2"/></td>
                    </tr>
                    <tr>
                        <td class="selectWhite">-</td>
                    </tr>
                    <tr>
                        <td class="selectWhite">-</td>
                    </tr>
                    <tr>
                        <td class="selectWhite">-</td>
                        <td class="selectFont">请每次只输入一行</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit"name="submit" value="查询" class="login_button1"/>
                        </td>
                    </tr>
                </table>
            </form>
            <div class="col-sm-8">
                     <c:forEach items="${list}" var="message">
                         <div>
                             <h2>${message.title}</h2>
                             <h5>${message.username}</h5>
                             <p>${message.content}</p>
                         </div>
                     </c:forEach>
            </div>
        </div>
    </div>
</div>

<div class="jumbotron text-center" style="margin-bottom:0">
    <p>已经到底啦</p>
</div>

</body>
</html>
