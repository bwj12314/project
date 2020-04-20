<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기업 멤버 회원 가입 페이지</title>
<style type="text/css">
	body{
		padding:0;
		margin:0;
		background:#3EB1B0;
	}
	.sub_box{
		position:absolute;
		top:50%;left:50%;
		width:500px;height:850px;
		margin:-220px 0px 100px -250px;
		background:white;
		box-shadow:5px 5px 10px #333333;
		padding-top:5px;
	}
	table{
		margin-left:85px;
		width:500px;
		border:0;
	}
	.inputbox{
		height:40px;
		width:300px;
		padding-left:10px;
		font-size:15px;
		border:0;
		background:rgb(245,245,245);
	}
</style>
</head>
<script>
var chkId=false;
var idcheck;
function chkForm(f){
	if(f.company_id.value.trim()==""){
		alert('기업아이디(기업코드)를 입력하세요.');
		f.company_id.focus();
		return false;
	}if(!chkId || idcheck!=f.company_memberid.value.trim()){
		alert("아이디 중복확인을 하세요");
		return false;
	}
	if(f.company_memberpass.value.trim()==""){
		alert("비밀번호를 입력하세요.");
		f.company_memberpass.focus();
		return false;
	}if(f.company_membername.value.trim()==""){
		alert('이름을 입력하세요.');
		f.company_membername.focus();
		return false;
	}if(f.company_memberemail.value.trim()==""){
		alert('이메일을 입력하세요.');
		f.company_memberemail.focus();
		return false;
	}if(f.company_membertel.value.trim()==""){
		alert('전화번호를 입력하세요.');
		f.company_membertel.focus();
		return false;
	}
	f.submit();
}
</script>
<body>
<div class="sub_box">
	<div style="padding-left:115px">
	<a href="<%=request.getContextPath() %>/company_main.jsp"><img src="<%=request.getContextPath() %>/image/logo.png"></a></div><br><br>
<form name="joinform" action="memberjoinProcess.memb" method="post" onsubmit="return chkForm(this);">
<table>
	<tr>
		<td style="padding-top:20px;"><label for="company_id">기업아이디 (기업코드): </label></td>
	</tr>
	<tr>
		<td><input type="text" name="company_id" id="company_id" class="inputbox"></td>
	</tr>
	<tr>
		<td style="padding-top:20px;"><label for ="company_memberid">사용아이디 : </label></td>
	</tr>
	<tr>
		<td><input type="text" name="company_memberid" id="company_memberid" required class="inputbox"/>
		<input type="button" name = "idCheck" value="아이디 중복확인" id="idCheck" 
		onclick="window.open('idCheck.jsp?openInit=true','','width=500, height=300')" class="inputbox" style="background:#3EB1B0;margin-top:5px;color:white;width:310px;height:43px;cursor:pointer"></td>	
	</tr>
	<tr>
		<td style="padding-top:20px;"><label for ="company_memberpass">비밀번호 : </label></td>
	</tr>
	<tr>
		<td><input type="password" name="company_memberpass" id="company_memberpass" class="inputbox"/></td>
	</tr>
	<tr>
		<td style="padding-top:20px;"><label for ="company_membername">이름 : </label></td>
	</tr>
	<tr>
		<td><input type="text" name="company_membername" id="company_membername" class="inputbox"/></td>
	</tr>
	<tr>
		<td style="padding-top:20px;"><label for ="company_memberemail">이메일 주소 : </label></td>
	</tr>
	<tr>
		<td><input type="text" name="company_memberemail" id="company_memberemail" class="inputbox"/></td>
	</tr>
	<tr>
		<td style="padding-top:20px;"><label for = "company_membertel">전화번호 : </label></td>
	</tr>
	<tr>
		<td><input type="text" name="company_membertel" id="company_membertel" placeholder="하이픈(-)을 제외하고 입력" class="inputbox"/></td>
	</tr>
	<tr>
		<td style="padding-top:40px">
				<input type="button" value="회원가입" onclick="javascript:chkForm(joinform)" style="width:150px;background:#3EB1B0;color:white;height:40px;cursor:pointer;border:0;font-size:20px"/>
				<input type="button" onclick="javascript:joinform.reset()" value="다시 작성" style="width:150px;background:#3EB1B0;color:white;height:40px;cursor:pointer;margin-left:5px;border:0;font-size:20px"/>
		</td>
	</tr>
</table>
</form>
</div>
</body>
</html>