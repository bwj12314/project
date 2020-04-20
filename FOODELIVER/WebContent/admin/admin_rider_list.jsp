<%@page import="rider.vo.PageInfo"%>
<%@page import="rider.vo.Rider"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link href="https://fonts.googleapis.com/css?family=Cute+Font|Jua&display=swap&subset=korean" rel="stylesheet">
<title>Foodeliver</title>
<style>
	body{
		min-width:1000px;
		margin:0;
		padding:0;
	}
	table{
		width:620px;
		border-collapse:collapse;
		font-size:20px;
	}
	td,th{
		border-top:1px solid rgb(220,220,220);
		text-align:center;
	}
	.footer{
		width:100%;
		height:200px;
		background:rgb(250,250,250);
		margin-top:200px;	
		min-width:1000px;
	}
	hr{
		border:1px solid rgb(230,230,230);
		
	}
	.buttonbox{
		height:50px;
		width:70px;
		background:black;
		cursor:pointer;
		color:white;
	}
	.buttonbox2{
		height:40px;
		width:80px;
		background:white;
		cursor:pointer;
		color:black;
		border:1px solid black;
		font-size:18px;
	}
	@media screen and (max-width: 2000px) {
  		.totalmenu{
  			margin-left:55%;
  		}
	}
	@media screen and (max-width: 1200px) {
  		.totalmenu{
  			margin-left:35%;
  		}
	}
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
</script>
</head>

<body>
		<div style="min-width:1000px;margin:auto;padding-top:20px">
	<div style="width:270px;margin:auto;">
	<a href="<%=request.getContextPath() %>/adminMain.jsp"><img src="<%=request.getContextPath() %>/rider_image/logo.png"/></a></div></div>
	<div style="min-width:1000px;margin:auto;">
	<div style="min-width:1000px;margin:auto;">
	<span style="margin-left:77%;font-size:25px;display:inline-block;height:40px;font-family: 'Jua', sans-serif;" onmouseover="viewmenu(true)" onmouseout="viewmenu(false)">전체 메뉴</span>
	</div></div>
		<div id="menu_content" class="totalmenu" style="position:absolute; z-index:1; width:550px; height:200px;background:white;border:2px solid #c0c0c0; display:none" onmouseover="viewmenu(true)" onmouseout="viewmenu(false)">
			
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
<br>
	<%
	ArrayList<Rider> riderList=(ArrayList<Rider>)request.getAttribute("riderList");
    PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	if(pageInfo!=null){
    int listCount=pageInfo.getListCount();
	int nowPage=pageInfo.getPage(); //jsp에서는 page쓸수 없다.**
	int maxPage=pageInfo.getMaxPage();
	int startPage=pageInfo.getStartPage();
	int endPage=pageInfo.getEndPage();
	String Option=(String)request.getAttribute("Option");
	String Value=(String)request.getAttribute("Value");
	int no=0;
	%>
	
	<div style="padding-top:70px;width:1000px;margin:auto;" >
		<div style="float:left;margin-left:50px;">
		<img src="<%=request.getContextPath()%>/rider_image/logo15.png"></div>
		<div style="padding-top:30px"><span style="font-size:30px;font-weight:700;padding-left:30px;">배달 회원 목록</span><span style="padding-left:35%;font-size:20px;font-weight:bold">
		<a href="<%=request.getContextPath()%>/admin/admin_rider_certifykey.jsp">배달원 <span style="color:#3EB1B0"> 인증키</span>  추가하기</a></span></div><br><br>
		<hr>
	</div>
	<br><br><br><br>
	<% if(maxPage!=0){%>
	<div style="width:620px;margin:auto;">
	<table>
		<tr>
			<td style="border-top:0px;text-align:center;font-size:25px;font-weight:bold;padding-bottom:50px;" colspan="3">아이디 목록</td>
		</tr>
		<tr>
			
			<td style="width:420px;height:80px;">
				<a href="riderInfo.adm?id=<%=riderList.get(0).getRider_id() %>">
				<%=riderList.get(0).getRider_id() %></a>
			</td>
			<td>
				<button onclick="location.href='riderMod.adm?id=<%=riderList.get(0).getRider_id() %>'" class="buttonbox2">수정</button>
			</td>
			<td>
				<button onclick="location.href='riderDelete.adm?id=<%=riderList.get(0).getRider_id() %>'" class="buttonbox2">삭제</button>
			</td>
		</tr>
		<%for(int i=1;i<riderList.size();i++){ %>
		<tr>
			
			<td style="height:80px;">
				<a href="riderInfo.adm?id=<%=riderList.get(i).getRider_id() %>">
				<%=riderList.get(i).getRider_id() %></a>
			</td>
			<td>
				<button onclick="location.href='riderMod.adm?id=<%=riderList.get(i).getRider_id() %>'" class="buttonbox2">수정</button>
			</td>
			<td>
				<button onclick="location.href='riderDelete.adm?id=<%=riderList.get(i).getRider_id() %>'" class="buttonbox2">삭제</button>
			</td>
		</tr>
	
		
		<%} %>
		
		</table>
		</div>
	<%
    }else{
    	no=1;
%>
	<div style="width:450px;margin:auto;">
		<img src="<%=request.getContextPath() %>/rider_image/logo7.png"><br>
		<div style="width:450px;margin:auto;font-size:20px;font-weight:bold;margin-left:100px;">검색하신 결과 목록이 없습니다.</div>
		</div>
<%} %>
		<div style="width:290px;margin:auto;margin-top:100px;">
		<%if(nowPage<=1){ %>
		<%if(no==0){ %>
		<span style="margin-right:50px;font-size:20px;">[이전]</span>
		<%} %>
		<%}else{ %>
		<a href="getRiderList.adm?page=<%=nowPage-1 %>&Option=<%=Option%>&Value=<%=Value%>" style="font-size:20px;margin-right:50px;">[이전]</a>
		<%} %>

		<%for(int a=startPage;a<=endPage;a++){
				if(a==nowPage){%>
		<span style="font-size:20px;margin-right:5px;margin-left:5px">[<%=a %>]</span>
		<%}else{ %>
		<a href="getRiderList.adm?page=<%=a %>&Option=<%=Option%>&Value=<%=Value%>" style="margin-left:5px;margin-right:5px;font-size:22px">[<%=a %>]
		</a>
		<%} %>
		<%} %>

		<%if(nowPage>=maxPage){ %>
		<%if(no==0){ %>
		<span style="margin-left:50px;font-size:20px;">[다음]</span>
		<%} %>
		<%}else{ %>
		<a href="getRiderList.adm?page=<%=nowPage+1 %>&Option=<%=Option%>&Value=<%=Value%>" style="font-size:20px;margin-left:50px;">[다음]</a>
		<%} %>
		</div>
		
		<div style="width:400px;margin:auto;margin-top:40px;">
		<form action="<%=request.getContextPath() %>/getRiderList.adm" name="f" method="post">
		<select id="Option" name="Option" style="width:100px;height:30px;font-size:15px;">
			<option value="id" ${Option eq 'id' ? 'selected':'' }>아이디</option>
			<option value="tel" ${Option eq 'tel' ? 'selected':'' }>전화번호</option>
		</select>
		<input type="text" name="Value" id="Value" style="height:30px;width:200px;border-radius:5px/5px;margin-left:5px;">
		<button onclick="javascript:f.submit()" class="buttonbox" style="border:0px;height:35px;font-size:17px;">검색</button>
		</form>
		</div>
		<%} %>
		
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