<%--
  Created by IntelliJ IDEA.
  User: 詹帆
  Date: 2019/6/16
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>博客论坛</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
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
                <li class="active"><a href="#">主页</a></li>
                <li><a href="ManageBlog.jsp">管理博客</a></li>
                <li><a href="ManageUser.jsp">管理用户</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-sm-4">
            <h3>管理员用户名</h3>
            <p><span><%= request.getSession().getAttribute("username")%></span></p>
            <ul class="nav nav-pills nav-stacked">
                <li class="active"><a href="#">已登录</a></li>
                <li><a href="../html/register.html">注册</a></li>
                <li><a href="unloginMain.jsp">注销</a></li>
            </ul>
            <hr class="hidden-sm hidden-md hidden-lg">
        </div>
        <div class="col-sm-8">
            <span class="showMessage">
            </span>
        </div>
    </div>
</div>

<div class="jumbotron text-center" style="margin-bottom:0">
    <p>已经到底啦</p>
</div>

</body>
</html>
