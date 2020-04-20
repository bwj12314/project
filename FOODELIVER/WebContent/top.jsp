<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Cute+Font|Jua&display=swap&subset=korean" rel="stylesheet">
<style>
body{
min-width: 1206px;
margin: 0;
padding: 0;

}
.header{
	text-align: center;
}
body,div,ul,li{margin:0; padding:0}
	body{font-size:12px; font-family:"맑은 고딕",arial}
	ul{list-style:none}
	a{color:#000; text-decoration:none}
	.gnb{
		height:50px; margin:auto; margin-top:0; }
	/*메인메뉴*/
	.gnb>ul{text-align:center; height:50px; background:#3EB1B0; padding:0;}
	.gnb>ul>li{display:inline-block; width:150px; height:50px; margin-top:0; position:relative;}
	.gnb>ul>li>a{
		display:block; width:100%; font:bold 20px/30px 'Jua', sans-serif;
		text-align:center; color:#fff; background:#3EB1B0;padding:10px; 
	}
	.gnb ul li a:hover{color:#fff; background:#3EB1B0}
	/*서브영역*/
	.gnb ul ul{display:none}
	.gnb ul li:hover ul{display:block;position:absolute;z-index:10;}
	.gnb li li{width:150px; height:36px; background-color:#3EB1B0; text-align:center; float:left;}
	.gnb li li a{display:block; width:100%; color:white; height:100%; font:bold 20px/25px 'Cute Font', cursive; margin-top:5px;}
	.gnb li li a:hover{color:black; background:none;}
</style>
</head>
<body>
<div class="header">
   <a href="<%=request.getContextPath() %>/main.main"><img src="<%=request.getContextPath() %>/main_img/logo.png" width="150px"></a>
</div>
<div class="gnb">
		<ul>
			<li><a href="javascript:void(0)">로그인</a>
				<ul>
				<c:choose>
					<c:when test="${member_id==null }">
						<li><a href="<%=request.getContextPath() %>/login/loginForm.jsp">로그인하기</a></li>
						<li><a href="<%=request.getContextPath()%>/login/joinForm.jsp">회원가입</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="<%=request.getContextPath() %>/logout.mlog">로그아웃</a></li>
					</c:otherwise>
				</c:choose>
				</ul></li>
				
			<li><a href="javascript:void(0)">신청서</a>
				<ul>
					<li><a href="<%=request.getContextPath() %>/app/rider_app.jsp">라이더 지원하기</a></li>
					<li><a href="<%=request.getContextPath()%>/app/company_app.jsp">기업 제휴 신청하기</a></li>
					
				</ul></li>
			
			<li  style="font-family:font-family: 'Jua', sans-serif;"><a href="javascript:void(0)">주문표</a>
				<ul>
					<li><a href="<%=request.getContextPath() %>/order_list.main">주문 목록</a>
					<li><a href="<%=request.getContextPath() %>/order_list_com.main">주문완료 목록</a>
				</ul></li>
			
		</ul>
	</div>
</body>
</html>