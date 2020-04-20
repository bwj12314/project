<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>FOODELIVER 배달원 : 로그인</title>
<style>
	body{
		padding:0;
		margin:0;
		background:#3EB1B0;
	}
	.sub_box{
		position:absolute;
		top:50%;left:50%;
		width:400px;height:380px;
		margin:-250px 0px 0px -200px;
		background:white;
		box-shadow:5px 5px 10px #333333;
		padding-top:5px;
	}
	.inputbox{
		height:40px;
		width:250px;
		font-size:15px;
		padding-left:10px;
		border:1px solid #d0d0d0;
		margin-left:40px;
		background:rgb(245,245,245);
		border:rgb(250,250,250);
	}
	a{
		text-decoration:none;
		color:black;
	}
	a:hover{
		color:#3EB1B0;
	}
</style>
<script>
function checkform(f){
	if(f.id.value==null||f.id.value.trim()==""){
		alert("아이디를 입력하세요");
		f.id.focus();
		return false;
	}
	if(f.pass.value==null||f.pass.value.trim()==""){
		alert("비밀번호를 입력하세요");
		f.pass.focus();
		return false;
	}
}
</script>
<script>
$(document).ready(function(){
	 
    // 저장된 쿠키값을 가져와서 ID 칸에 넣어준다. 없으면 공백으로 들어감.
    var key = getCookie("key");
    $("#id").val(key); 
     
    if($("#id").val() != ""){ // 그 전에 ID를 저장해서 처음 페이지 로딩 시, 입력 칸에 저장된 ID가 표시된 상태라면,
        $("#idSaveCheck").attr("checked", true); // ID 저장하기를 체크 상태로 두기.
    }
     
    $("#idSaveCheck").change(function(){ // 체크박스에 변화가 있다면,
        if($("#idSaveCheck").is(":checked")){ // ID 저장하기 체크했을 때,
            setCookie("key", $("#id").val(), 7); // 7일 동안 쿠키 보관
        }else{ // ID 저장하기 체크 해제 시,
            deleteCookie("key");
        }
    });
     
    // ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 이럴 때도 쿠키 저장.
    $("#id").keyup(function(){ // ID 입력 칸에 ID를 입력할 때,
        if($("#idSaveCheck").is(":checked")){ // ID 저장하기를 체크한 상태라면,
            setCookie("key", $("#id").val(), 7); // 7일 동안 쿠키 보관
        }
    });
});
 
function setCookie(cookieName, value, exdays){
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + exdays);
    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
    document.cookie = cookieName + "=" + cookieValue;
}
 
function deleteCookie(cookieName){
    var expireDate = new Date();
    expireDate.setDate(expireDate.getDate() - 1);
    document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
}
 
function getCookie(cookieName) {
    cookieName = cookieName + '=';
    var cookieData = document.cookie;
    var start = cookieData.indexOf(cookieName);
    var cookieValue = '';
    if(start != -1){
        start += cookieName.length;
        var end = cookieData.indexOf(';', start);
        if(end == -1)end = cookieData.length;
        cookieValue = cookieData.substring(start, end);
    }
    return unescape(cookieValue);
}
</script>
</head>
<body>
	<div class="sub_box"><div style="width:260px;margin:auto;">
	<a href="<%=request.getContextPath() %>/riderMain.jsp"><img src="<%=request.getContextPath() %>/rider_image/logo.png"></a></div><br>
	<div style="padding-left:30px">
		<form name="loginform" action="<%=request.getContextPath() %>/login.riderlog" method="post" onsubmit="return checkform(this)">
			<input type="text" name="id" id="id" class="inputbox" placeholder="아이디" style="margin-top:5px">
			<input type="password" name="pass" id="pass" class="inputbox" placeholder="비밀번호" style="margin-top:12px">
			<input type="submit" value="로그인" style="margin-top:12px;width:260px;height:40px;font-size:20px;margin-left:40px;background:#3EB1B0;color:white;border:0;cursor:pointer">
		</form>
		<div style="float:right;margin-right:20%;font-size:15px;">
		<input type="checkbox" id="idSaveCheck"><label for="idSaveCheck">아이디 기억하기</label></div>
		<br><br>
		<span style="padding-left:35px;font-size:15px">
		<a href="<%=request.getContextPath() %>/rider/checkid.jsp">아이디 찾기</a> | <a href="<%=request.getContextPath() %>/rider/checkpass.jsp">비밀번호 찾기</a> | <a href="<%=request.getContextPath() %>/rider/joinForm.jsp">회원가입</a>
		</span>
	</div>
	</div>
	
</body>
</html>