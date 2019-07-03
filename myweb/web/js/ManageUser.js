

$(function () {
    var content = "<h2>用户状态:</h2>\n<p>用户类型1表示管理员，0表示普通用户</p>\n<p>锁定类型1表示被冻结，0表示用户正常</p>"+
    "\n <table class='user_table'> \n <tr><h3> \n <td>用户名</td> \n <td>用户类型</td> \n <td>锁定类型</td> \n </h3></tr> \n";
    $.ajax({
        url:"/ManageUserServlet",
        success:function (data) {
            var list = new Array();
            list = data.split("}");
            for (var i=0;i<list.length-1;i++) {
                var message = new Array();
                message = list[i].split("*");
                content = content+ "\n <tr><h3> \n <td>"+message[0]+"</td> \n" +
                    "                <td>"+message[1]+"</td> \n" +
                    "                <td>"+message[2]+"</td> \n" +
                    "                <td><a href='/FreezeUserServlet?username="+message[0]+"'>冻结</a></td> \n"+
                    "                <td><a href='/UnfreezeUserServlet?username="+message[0]+"'>恢复</a></td> \n"+
                    "</h3></tr>\n";
            }
            content=content+"\n </form>";
            /*alert(content);*/
            $(".showMessage").append(content);
        }
    });

})