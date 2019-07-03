/*<script type ="text/javascript">*/
function checkGender() {
    var genderNum=document.getElementsByName("gender");
    var gender="";
    for(var i=0;i<genderNum.length;++i){
        if(genderNum[i].checked)
            gender=genderNum[i].value;
    }
    if(gender==""){
        document.getElementById("tips_gender").innerHTML="<em style='color: red'>请选择一项</em>"
        return false;
    }else{
        document.getElementById("tips_gender").innerHTML="<em style='color: green'>OK</em>"
        return true;
    }
}
function checkUsername() {
    if(document.getElementById("username").value.length<6||
        document.getElementById("username").value.length>18){
        document.getElementById("tips_username").innerHTML="<em style='color: red'>用户名由6-18位字符组成</em>"
        return false;
    }else{
        document.getElementById("tips_username").innerHTML="<em style='color: green'>OK</em>"
        return true;
    }
}

function checkPassword() {
    var reg=/[^A-Za-z0-9_]+/;
    if(document.getElementById("password").value.length<6||
        document.getElementById("password").value.length>18||
        reg.test(document.getElementById("password").value)){
        document.getElementById("tips_password").innerHTML=
            "<em style='color: red'>密码由6-18位字符组成，且必须由数字、下划线和字母组成</em>"
        return false;
    }else{
        document.getElementById("tips_password").innerHTML="<em style='color: green'>OK</em>"
        return true;
    }
}

function checkPwdrepeat() {
    if(document.getElementById("pwdrepeat").value==""){
        document.getElementById("tips_pwdrepeat").innerHTML= "<em style='color: red'>密码为空，请输入密码</em>"
        return false;
    }else if(document.getElementById("pwdrepeat").value!=document.getElementById("password").value){
        document.getElementById("tips_pwdrepeat").innerHTML= "<em style='color: red'>两次输入密码不一致</em>"
        return false;
    }else{
        document.getElementById("tips_pwdrepeat").innerHTML="<em style='color: green'>OK</em>"
        return true;
    }
}

function checkDate() {
    if(document.getElementById("birthday").value==""){
        document.getElementById("tips_birthday").innerHTML= "<em style='color: red'>生日为空，请选择一个日期作为生日</em>"
        return false;
    }else{
        document.getElementById("tips_birthday").innerHTML="<em style='color: green'>OK</em>"
        return true;
    }
}

function checkHobby() {
    var hobby=0;
    var objNum=document.getElementsByName("hobby");
    for(var i=0;i<objNum.length;++i){
        if(objNum[i].checked)
            hobby++;
    }
    if(hobby>=1){
        document.getElementById("tips_hobby").innerHTML="<em style='color: green'>OK</em>"
        return true;
    }else{
        document.getElementById("tips_hobby").innerHTML="<em style='color: red'>请至少选择一项</em>"
        return false;
    }
}

function checkTelephone() {
    var reg=/[^0-9]+/;
    if(document.getElementById("telephone").value.length!=11|| reg.test(document.getElementById("telephone").value)){
        document.getElementById("tips_telephone").innerHTML= "<em style='color: red'>手机号由11位数字组成</em>"
        return false;
    }else{
        document.getElementById("tips_telephone").innerHTML="<em style='color: green'>OK</em>"
        return true;
    }
}

function checkEmail() {
    var reg=/^[a-zA-Z0-9#_]+@[a-zA-Z0-9]+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
    if(!reg.test(document.getElementById("email").value)||document.getElementById("email").value==""){
        document.getElementById("tips_email").innerHTML= "<em style='color: red'>Email不合法</em>"
        return false;
    }else{
        document.getElementById("tips_email").innerHTML="<em style='color: green'>OK</em>"
        return true;
    }
}

function checkForm() {
    checkGender();
    checkUsername();
    checkPassword();
    checkPwdrepeat();
    checkDate();
    checkHobby();
    checkTelephone();
    checkEmail();
    if(!checkGender()||!checkUsername()||!checkPassword()||!checkPwdrepeat()|| !checkDate()||
        !checkHobby()||!checkTelephone()||!checkEmail()){
        return false;
    }
    alert("信息填写完毕，正在核查!");
    return true;
}