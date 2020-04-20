<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="rider.vo.Admin" %>
    <%Admin admin=(Admin)session.getAttribute("admin"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Foodeliver</title>
</head>
<style>
	body{
		min-width:1300px;padding:0;margin:0;
	}
	.footer{
		width:100%;
		height:200px;
		background:rgb(250,250,250);
		margin-top:100px;	
		min-width:1300px;
	}
	hr{
		border:1px solid rgb(230,230,230);
		
	}
	table{
		width:600px;font-size:20px;
		border-collapse:collapse;
		height:400px;
	}
	td,th{
		border-top:1px solid rgb(220,220,220);
		text-align:center;
</style>
<script>
function viewmenu(opt) {
	  if(opt) {
		  menu_content.style.display = "block";
	  }
	  else {
		  menu_content.style.display = "none";
	  }
	
}
function chkForm(f){
	if(f.tel.value==''){
		alert('휴대폰 번호를 입력하세요');
		return false;
	}
	if(f.email.value==''){
		alert('이메일 주소를 입력하세요');
		return false;
	}
	
	
	f.submit();
} //아이디 받아서 널이거나 빈값이면 



</script>
<body>
	<div style="min-width:1300px;margin:auto;padding-top:20px">
	<div style="width:270px;margin:auto;">
	<a href="<%=request.getContextPath() %>/adminMain.jsp"><img src="<%=request.getContextPath() %>/rider_image/logo.png"/></a></div></div>
	<div style="min-width:1300px;margin:auto">
	<div style="min-width:1300px;margin:auto">
	<span style=" margin-left:77%;font-size:25px;display:inline-block;height:40px;font-family: 'Jua', sans-serif;" onmouseover="viewmenu(true)" onmouseout="viewmenu(false)">전체 메뉴</span>
	</div></div>
	<div id="menu_content" style="position:absolute; z-index:1; width:550px; height:200px;background:white;border:2px solid #c0c0c0;margin-left:60%; display:none" onmouseover="viewmenu(true)" onmouseout="viewmenu(false)">
	
	<ul style="list-style-type:none;padding-left:30px;float:left;">
		<li><img src="<%=request.getContextPath() %>/rider_image/logo2.png"></li>
		<li style="padding:10px 0px 20px 0px;font-size:20px;">로그인</li>
		<%if((String)session.getAttribute("adminid")==null){ %>
		<li><a href="<%=request.getContextPath() %>/admin/loginForm.jsp">로그인하기</a></li>
		<li style="padding-bottom:5px"></li>
		<%}else{ %>
		<li style="padding-left:5px;"><a href="<%=request.getContextPath()%>/logout.adm">로그아웃</a>
		<%} %>
	</ul>
	<div style="border-left: 2px solid #f0f0f0;height: 200px;float:left;margin-left:30px"></div>
	<ul style="list-style-type:none;padding-left:30px;float:left;">
		<li><img src="<%=request.getContextPath() %>/rider_image/logo3.png"></li>
		<li style="padding:10px 0px 20px 0px;font-size:20px;">내 정보</li>
		<li><a href="<%=request.getContextPath() %>/adminInfo.adm?Option=see">내 정보 보기</a></li>
		<li style="padding-bottom:5px"></li>
	</ul>
	<div style="border-left: 2px solid #f0f0f0;height:200px;float:left;margin-left:30px"></div>
	<ul style="list-style-type:none;padding-left:30px;float:left;">
		<li style="padding-left:15px;padding-top:10px;"><img src="<%=request.getContextPath() %>/rider_image/logo12.png"></li>
		<li style="padding:10px 0px 20px 0px;font-size:20px;">회원 관리</li>
		<li style="padding-left:15px;"><a href="<%=request.getContextPath() %>/getRiderList.adm">배달 회원</a></li>
		<li style="padding-left:15px;"><a href="<%=request.getContextPath()%>/companylist.comadm">기업 목록</a></li>
		<li style="padding-bottom:5px"></li>
	</ul>
	<div style="border-left: 2px solid #f0f0f0;height:200px;float:left;margin-left:30px"></div>
	<ul style="list-style:none;padding-left:30px;float:left;">
		<li style="padding-left:10px;padding-top:5px"><img src="<%=request.getContextPath() %>/rider_image/logo13.png"></li>
		<li style="padding:10px 0px 20px 0px;font-size:20px;">기업 관리</li>
		<li style="padding-left:15px;"><a href="#">가게 목록</a></li>
	</ul>
</div>
<div style="clear:both;"></div>
<br>
<jsp:include page="../menu_top_admin.jsp" />
	
	<div style="padding-top:70px;width:1000px;margin:auto;" >
		<div style="float:left">
		<img src="<%=request.getContextPath() %>/rider_image/logo14.png"></div>
		<div style="padding-top:20px;">
		<span style="font-size:30px;font-weight:700;padding-left:30px;">관리자 정보 수정</span></div><br><br>
		<hr>
	</div>
	<div style="width:600px;margin:auto;margin-top:50px;">
	<form name="modifycheck" action="adminModPro.adm" method="post" onsubmit="return chkForm(this)">
	<table>
		
		<tr>
			<td style="border-top:0px">아이디</td>
			<td style="border-top:0px"><%=admin.getAdmin_id() %>
			<input type="hidden" value="<%=admin.getAdmin_id()%>" name="id" readonly>
			</td>
		</tr>
		
		<tr>
			<td><label for="tel"></label>휴대폰번호</td>
			<td>
				<input type="text" name="tel" id="tel" value="<%=admin.getAdmin_tel() %>" style="width:200px;height:30px;font-size:15px;padding-left:20px;border-radius:2px/2px">
			</td>
		</tr>
		<tr>
			<td><label for="email">이메일 주소</label></td>
			<td><input type="text" name="email" id="email"
			value="<%=admin.getAdmin_email()%>" style="width:200px;height:30px;font-size:15px;padding-left:20px;border-radius:2px/2px">
			</td>
		</tr>
		
		<tr>
			<td colspan="2">
				<a onclick="javascript:chkForm(document.modifycheck)" style="cursor:pointer;font-weight:bold;font-size:25px;">수정</a>
				<a href="admin/admin_info.jsp" style="cursor:pointer;font-weight:bold;margin-left:30px;font-size:25px;">취소</a>
			</td>
		</tr>	
	</table>
	</form>
	</div>
	
	<div class="footer">
		<div style="padding-left:10%;padding-top:20px">
			<span style="font-size:17px;">(유)푸딜리버리</span><br><br>
			<p>대구광역시 수성구 국채보상로 924 동우빌딩 2층 (유)푸딜리버리 &nbsp;&nbsp;&nbsp;&nbsp;
			|&nbsp;&nbsp;&nbsp;&nbsp; 대표자 : kbe &nbsp;&nbsp;&nbsp;&nbsp;
			| &nbsp;&nbsp;&nbsp;&nbsp;사업자 등록번호 : 311-41-564245</p><br>
			<span style="font-size:18px;font-weight:bold">배달원 문의 : 1577-8282</span>
		</div>
	</div>
</body>
</html>