var content = "";

$(function () {
  $.ajax({
      url:"/GetAllMessageServlet",
      success:function (data) {
          var list = new Array();
          list = data.split("}");
          for (var i=0;i<list.length-1;i++) {
           var message = new Array();
           message = list[i].split("*");
               content = content+"     <div>\n" +
                  "                <h2>"+message[0]+"</h2>\n" +
                  "                <h5>"+message[1]+"</h5>\n" +
                  "                <p>"+message[2]+"</p>\n" +
                  "                <br>  \n" +
                  "            </div>";
          }
          $(".showMessage").append(content);
      }
  });
})
/*
function selectMessage() {
    $.ajax({
        url:"/SelectMessageServlet",
        success:function (data) {
            alert("asd");
            content="";
            var list = new Array();
            list = data.split("}");
            for (var i=0;i<list.length-1;i++) {
                var message = new Array();
                message = list[i].split("*");
                content = content+"     <div>\n" +
                    "                <h2>"+message[0]+"</h2>\n" +
                    "                <h5>"+message[1]+"</h5>\n" +
                    "                <p>"+message[2]+"</p>\n" +
                    "                <br>  \n" +
                    "            </div>";
            }
            alert(content);
            $(".showMessage").append(content);
        }
    });
}*/
