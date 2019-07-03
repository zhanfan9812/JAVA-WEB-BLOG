function checkTitle() {
    if(document.getElementById("title").value.length==""){
        document.getElementById("tips_title").innerHTML="<em style='color: red'>标题不能为空</em>"
        return false;
    }else{
        document.getElementById("tips_title").innerHTML="<em style='color: green'>OK</em>"
        return true;
    }
}