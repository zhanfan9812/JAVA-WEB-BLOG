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
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        .fakeimg {
            height: 200px;
            background: #aaa;
        }
    </style>
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
                <li><a href="#">我的博客</a></li>
                <li><a href="#">发表博客</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-sm-4">
            <h3>用户名</h3>
            <p>请登录</p>
            <ul class="nav nav-pills nav-stacked">
                <li class="active"><a href="../html/login.html">登录</a></li>
                <li><a href="../html/register.html">注册</a></li>
                <li><a href="unloginMain.jsp">注销</a></li>
            </ul>
            <hr class="hidden-sm hidden-md hidden-lg">
        </div>
        <div class="col-sm-8">
            <h2>标题</h2>
            <h5>副标题</h5>
            <div class="fakeimg">图像</div>
            <p>一些文本..</p>
            <p>菜鸟教程，学的不仅是技术，更是梦想！！！</p>
            <br>
            <h2>标题</h2>
            <h5>副标题</h5>
            <div class="fakeimg">图像</div>
            <p>一些文本..</p>
            <p>菜鸟教程，学的不仅是技术，更是梦想！！！</p>
            <br>
            <h2>标题</h2>
            <h5>副标题</h5>
            <div class="fakeimg">图像</div>
            <p>一些文本..</p>
            <p>菜鸟教程，学的不仅是技术，更是梦想！！！</p>
        </div>
    </div>
</div>

<div class="jumbotron text-center" style="margin-bottom:0">
    <p>已经到底啦</p>
</div>

</body>
</html>
