<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FOODELIVER 아이디 찾기</title>
<style type="text/css">
	body{
		padding:0;
		margin:0;
		background:#3EB1B0;
	}
	.sub_box{
		position:absolute;
		top:50%;left:50%;
		width:400px;height:500px;
		margin:-250px 0px 0px -200px;
		background:white;
		box-shadow:5px 5px 10px #333333;
		padding-top:5px;
	}
	.inputbox{
		height:30px;
		width:210px;
		font-size:15px;
		padding-left:10px;
		border:1px solid #d0d0d0;
		margin-left:40px;
	}
	.buttonbox{
		margin-left:40px;height:30px;width:222px;margin-top:12px;
		background:white;border:1px solid black;cursor:pointer;
		font-size:15px;
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
function checkid() {
	var name = document.getElementById("checkname").value;
	var email = document.getElementById("checkemail").value;
	
	var url = "<%=request.getContextPath()%>/checkid.riderlog?" + "checkname=" + name + "&checkemail=" + email;
	window.open(url, '', 'width=700', 'height=500');
}
function Next(f){
	if(f.checkname.value.trim()==''){
		alert('이름을 입력하세요');
		return false;
	}
	if(f.checkemail.value.trim()==''){
		alert('이메일을 입력하세요');
		return false;
	}
	if(f.certifykeyEX.value.trim()==''){
		alert('인증 코드를 입력하세요');
		return false;
	}
	
	f.submit();
}
</script>

</head>
<body>
	
	<div class="sub_box"><div style="width:260px;margin:auto;">
	<a href="../riderMain.jsp"><img src="../rider_image/logo.png"></a></div><br>
	<div style="padding-left:50px;">
	<form action="<%=request.getContextPath() %>/checkidsuccess.riderlog" method="post" name="form1" onsubmit="return Next(this)">
		<div style="padding-left:100px;font-size:20px;font-weight:bold">아이디 찾기</div>
		<input type="text" name="checkname" id="checkname" class="inputbox" placeholder="이름" style="margin-top:5px" value=
		"${param.checkname==null?'':param.checkname }">
		<%System.out.println(request.getParameter("checkname")+"and "+request.getParameter("checkemail")); %>
		<input type="text" name="checkemail" id="checkemail" class="inputbox" placeholder="이메일" style="margin-top:12px" value=
		"${param.checkemail==null?'':param.checkemail }">
		<button type="button" onclick="checkid()" class="buttonbox">인증번호 받기</button>
		<div style="clear:both;"></div>
		<br><br>
		<input type="text" name="certifykeyEX" class="inputbox" placeholder="인증번호 숫자 입력" style="margin-left:40px;">
		<br>
		<button type="button" onclick="javascript:Next(document.form1)" class="buttonbox">다음</button>
		
		<br><br>
		
	</form>
		<span style="padding-left:23px;font-size:15px">
		<a href="loginForm.jsp">로그인</a> | <a href="<%=request.getContextPath() %>/riderMain.jsp">배달원 페이지</a> | <a href="checkpass.jsp">비밀번호 찾기</a>
		</span>
	</div>
	</div>
	
</body>
</html>