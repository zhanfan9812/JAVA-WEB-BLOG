

$(function () {
    var content = "";
    $.ajax({
        url:"/myblogServlet",
        success:function (data) {
            var list = new Array();
            list = data.split("}");
            for (var i=0;i<list.length-1;i++) {
                var message = new Array();
                message = list[i].split("*");
                content = content+"     <div>\n" +
                    "                <h2>"+message[1]+"</h2>\n" +
                    "                <h5>"+message[2]+"</h5>\n" +
                    "                <p>"+message[3]+"</p>\n" +
                    "                <a href='/DeleteMessageServlet?mid="+message[0]+"'>删除</a>"+
                    "                <br>  \n" +
                    "            </div>";
            }
            $(".showMessage").append(content);
        }
    });

})