<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String openInit="false";
    	if(request.getParameter("openInit")!=null){
    		openInit="true";
    	}
    %>
    <!-- request.getContextPath() 프로젝트 경로가 나온다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 검사</title>
<style>
	.sub_box{
		position:absolute;
		top:50%;left:50%;
		width:500px;height:300px;
		margin:-160px 0px 0px -250px;
		background:white;
		padding-top:5px;
	}
	.inputbox{
		height:40px;
		width:250px;
		padding-left:10px;
		font-size:15px;
		border:0;
		background:rgb(230,230,230);
	}
	a{
		text-decoration:none;
		color:black;
	}
	a:hover{
		color:#3EB1B0;
	}
</style>
</head>
<script>
	function init(){
		if(<%=openInit%>){
			document.getElementById("id").value=opener.document.getElementById("id").value;
		}
	}
	function ok(v){
		opener.idcheck=v.trim();
		opener.document.getElementById("id").value=v;
		opener.chkId=true;
		window.close();
	}
	function chkForm(f){
		 for (var i = 0; i < document.f.id.value.length; i++) {
	            var ch = document.f.id.value.charAt(i);
	            if (!(ch >= '0' && ch <= '9') && !(ch >= 'a' && ch <= 'z')) {
	                alert("아이디는 영문 소문자, 숫자만 입력가능합니다")
	                document.f.id.focus();
	                document.f.id.select()
	                return false;
	            }
	        }
		 if (document.f.id.value.length<4 || document.f.id.value.length>12) {
	            alert("아이디는 4~12자 가능합니다")
	            document.f.id.focus();
	            document.f.id.select();
	            return false;
	        }
		 
		 
		f.submit();
	}
</script>
	<!-- 서블릿은 절대경로가 프로젝트밑의 /다음부터 html,jsp는 절대 경로가 프로젝트 포함 -->
<body onload="init()">
<div class="sub_box">
<div style="padding-left:115px;padding-top:50px;">
<form action="<%=request.getContextPath() %>/riderlogincheck.ridermem" method="post" name="f" onsubmit="return chkForm(this)">
	<input type="text" name="id" id="id" class="inputbox"><br>
	<input type="button" onclick="javascript:chkForm(document.f)" value="중복 확인" style="width:260px;height:40px;margin-top:10px;background:#3EB1B0;color:white;border:0px;cursor:pointer">
</form>
	<%
		request.setCharacterEncoding("UTF-8");
		
		
		
		if(request.getAttribute("chk_id")!=null){
			String chk_id=(String)request.getAttribute("chk_id");
			
			String usable=(String)request.getAttribute("usable");
			System.out.println(chk_id);
			if(usable.equals("yes")){
			out.println(chk_id+"는 사용 가능한 아이디입니다.");%><br><br>
		
		<div style="margin-left:90px"><a href='#' onclick="ok('<%=chk_id %>')">사용하기</a></div>
		<% }
			else{
				out.println(chk_id+"는 사용 불가능한 아이디입니다.<br>다시 검색하세요");
			}
			}
	%>
	</div>
	</div>
</body>
</html>