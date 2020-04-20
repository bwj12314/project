<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Cute+Font|Jua|Poor+Story&display=swap&subset=korean" rel="stylesheet">
<style>
	body{font-size:12px;min-width:1000px;}
	
	ul{list-style:none}
	a{color:#000; text-decoration:none}
	.gnb{
		height:55px; margin:auto; margin-top:0;min-width:1000px;}
	/*메인메뉴*/
	.gnb>ul{text-align:center; height:55px; background:#3EB1B0; padding:0;}
	.gnb>ul>li{display:inline-block; width:150px; height:50px; margin-top:0; position:relative;}
	.gnb>ul>li>a{
		display:block; width:100%; font: bold 25px/30px 'Jua', sans-serif;
		text-align:center; color:#fff; background:#3EB1B0;padding:10px;margin-top:3px; 
	}
	.gnb ul li a:hover{color:#fff; background:#3EB1B0}
	/*서브영역*/
	.gnb ul ul{display:none}
	.gnb ul li:hover ul{display:block;position:absolute;z-index:100;}
	.gnb li li{width:150px; height:36px; background-color:#3EB1B0; text-align:center; float:left;margin-left:8px;}
	.gnb li li a{display:block; width:100%; color:white; height:100%; font:bold 20px/25px 'Poor Story', cursive; margin-top:5px;}
	.gnb li li a:hover{color:black; background:none;}
</style>
</head>
<body>
	<div class="gnb">
		<ul>
			<li><a href="#">로그인</a>
				<ul>
					<%if(session.getAttribute("riderid")==null){ %>
					<li><a href="<%=request.getContextPath() %>/rider/loginForm.jsp">로그인하기</a></li>
					<li><a href="<%=request.getContextPath()%>/joinForm.ridermem">회원가입</a></li>
					<%}else{ %>
					<li><a href="<%=request.getContextPath() %>/logout.riderlog">로그아웃</a></li>
					<%} %>
				</ul></li>
				
			<li><a href="#">내 정보</a>
				<ul>
					<li><a href="<%=request.getContextPath() %>/riderInfo.ridermem?Option=see">내 정보 보기</a></li>
				</ul></li>
			
			<li><a href="#">배달 정보</a>
				<ul>
					<li><a href="<%=request.getContextPath() %>/deliveryInfo.ridermem">배달 목록</a>
					<li><a href="<%=request.getContextPath() %>/deliverySuccessInfo.ridermem">배달 완료 목록</a>
				</ul></li>
			
		</ul>
	</div>
</body>
</html>