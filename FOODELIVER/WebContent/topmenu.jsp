<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://fonts.googleapis.com/css?family=Cute+Font|Jua&display=swap&subset=korean"
	rel="stylesheet">
<style>
body, div, ul, li {
	margin: 0;
	padding: 0
}

body {
	font-size: 12px;
	font-family: "맑은 고딕", arial
}

ul {
	list-style: none
}

a {
	color: #000;
	text-decoration: none
}

.gnb {
	height: 70px;
	margin: auto;
	margin-top: 0;
}
/*메인메뉴*/
.gnb>ul {
	text-align: center;
	height: 50px;
	background: #3EB1B0;
	padding: 0;
}

.gnb>ul>li {
	display: inline-block;
	width: 150px;
	height: 50px;
	margin-top: 0;
	position: relative;
}

.gnb>ul>li>a {
	display: block;
	width: 100%;
	font: bold 20px/30px 'Jua', sans-serif;
	text-align: center;
	color: #fff;
	background: #3EB1B0;
	padding: 10px;
}

.gnb ul li a:hover {
	color: #fff;
	background: #3EB1B0
}
/*서브영역*/
.gnb ul ul {
	display: none
}

.gnb ul li:hover ul {
	display: block;
	position: absolute;
	z-index: 10;
}

.gnb li li {
	width: 150px;
	height: 36px;
	background-color: #3EB1B0;
	text-align: center;
	float: left;
}

.gnb li li a {
	display: block;
	width: 100%;
	color: white;
	height: 100%;
	font: bold 20px/25px 'Cute Font', cursive;
	margin-top: 5px;
}

.gnb li li a:hover {
	color: black;
	background: none;
}
</style>
</head>
<body>
	<div class="gnb">
		<ul>
			<li><a href="#">로그인</a>
				<ul>
					<%
						if (session.getAttribute("company_memberid") == null) {
					%>
					<li><a href="<%=request.getContextPath()%>/company_main.jsp">로그인하기</a></li>
					<li><a href="<%=request.getContextPath()%>/joinForm.memb">회원가입</a></li>
					<%
						} else {
					%>
					<li><a href="<%=request.getContextPath()%>/logout.login">로그아웃</a></li>
					<%
						}
					%>
				</ul></li>

			<li><a href="#">메뉴</a>
				<ul>
					<li><a href="<%=request.getContextPath()%>/company/menulist.menu">메뉴 리스트</a></li>
			</ul></li>
				
			<li><a href="#">회원정보</a>
				<ul>
					<li><a href="<%=request.getContextPath()%>/company/membermod.memb">내 정보 수정하기</a></li>
				</ul></li>

			<li style="font-family: font-family : 'Jua', sans-serif;"><a
				href="#">주문내역 보기</a>
				<ul>
					<li><a
						href="<%=request.getContextPath() %>/company/orderlist.menu?company_id=${company.company_id }">주문내역 보기</a>
				</ul></li>

		</ul>
	</div>
</body>
</html>