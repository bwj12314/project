<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Cute+Font|Jua|Poor+Story&display=swap&subset=korean" rel="stylesheet">
<title>Insert title here</title>
<style>
	body,div,ul,li{margin:0; padding:0}
	body{font-size:12px; font-family:"맑은 고딕",arial;}
	ul{list-style:none}
	a{color:#000; text-decoration:none}
	.gnb{
		height:55px; margin:auto; margin-top:0;min-width:1000px}
	/*메인메뉴*/
	.gnb>ul{text-align:center; height:55px; background:#3EB1B0; padding:0;}
	.gnb>ul>li{display:inline-block; width:150px; height:50px; margin-top:0; position:relative;}
	.gnb>ul>li>a{
		display:block; width:100%; font:bold 25px/30px 'Jua', sans-serif;
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
			
			<li style="margin-right:-10px;"><a href="#">로그인</a>
				<ul>
					<%if(session.getAttribute("adminid")==null){ %>
					<li><a href="<%=request.getContextPath() %>/loginForm.adm">로그인하기</a></li>
					
					<%}else{ %>
					<li><a href="<%=request.getContextPath() %>/logout.adm">로그아웃</a></li>
					<%} %>
				</ul></li>	
				
			<li style="margin-left:-10px;margin-right:-10px;"><a href="#">내 정보</a>
				<ul>
					<li><a href="<%=request.getContextPath() %>/adminInfo.adm?Option=see">관리자 정보보기</a></li>
					<li><a href="<%=request.getContextPath()%>/adminInfo.adm?Option=mod">관리자 정보수정</a></li>
					
					
				</ul></li>
			
			<li style="margin-left:-10px;margin-right:-10px;"><a href="#">회원 관리</a>
				<ul>
					<li><a href="<%=request.getContextPath() %>/member_admin_list.mem_admin">일반 회원</a></li>
					<li><a href="<%=request.getContextPath() %>/getRiderList.adm">배달 회원</a></li>
					<li><a href="<%=request.getContextPath() %>/companylist.comadm">기업 목록</a></li>
				</ul></li>
				
			<li style="margin-left:-10px;"><a href="#">기업 관리</a>
				<ul>
					<li><a href="<%=request.getContextPath() %>/companyaddform.comadm">기업 추가</a></li>
					
				</ul></li>
		</ul>
	</div>
</body>
</html>