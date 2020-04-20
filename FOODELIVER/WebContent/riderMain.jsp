<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%String riderid=(String)session.getAttribute("riderid"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="data/style.css?after">
<link href="https://fonts.googleapis.com/css?family=Jua&display=swap&subset=korean" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath() %>/data/packed.js?v=<%=System.currentTimeMillis() %>"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>FOODELIVER 배달원</title>
<style>
	body{
		min-width:1000px;
		margin:0;
		padding:0;
	}
	table{
		width:1000px;
		text-align:center;
	}
	.inputbox{
		height:30px;
		width:230px;
		font-size:15px;
		padding-left:10px;
		
	}
	
	.buttonbox{
		height:50px;
		width:245px;
		font-size:15px;
		background:#3EB1B0;
		cursor:pointer;
		border:0;
		color:white;
	}
	.footer{
		width:100%;
		height:200px;
		background:rgb(250,250,250);
		margin-top:200px;	
		min-width:1000px;
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
function view(opt) {
  if(opt) {
	  document.getElementById("sliderbutton").style.display="block";
	  document.getElementById("sliderbutton2").style.display="block";
  }
  else {
	  sliderbutton.style.display="none";
	  sliderbutton2.style.display="none";
  }
}
function viewmenu(opt) {
	  if(opt) {
		  menu_content.style.display = "block";
	  }
	  else {
		  menu_content.style.display = "none";
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
<div style="position:relative;min-width:1000px;">
<div style="margin-left:13%;float:left;"><a href="<%=request.getContextPath() %>/riderMain.jsp"><img src="rider_image/logo.png"></a></div>
<div style="padding-top:50px;font-family: 'Jua', sans-serif;font-size:40px">
<span style="color:#3EB1B0">배달원</span> 페이지

<span style="margin-left:37%;font-size:25px;display:inline-block;height:40px;" onmouseover="viewmenu(true)" onmouseout="viewmenu(false)">전체 메뉴</span>
</div>
</div>
<div id="menu_content" style="position:absolute; z-index:1; width:400px; height:200px;background:white;border:2px solid #c0c0c0;margin-left:60%; display:none" onmouseover="viewmenu(true)" onmouseout="viewmenu(false)">
	
	<ul style="list-style-type:none;padding-left:30px;float:left;">
		<li><img src="rider_image/logo2.png"></li>
		<li style="padding:10px 0px 20px 0px;font-size:20px;">로그인</li>
		<%if(riderid==null){ %>
		<li><a href="<%=request.getContextPath() %>/rider/loginForm.jsp">로그인하기</a></li>
		<li style="padding-bottom:5px"></li>
		<li><a href="<%=request.getContextPath() %>/joinForm.ridermem">회원가입</a></li>
		<%}else{ %>
		<li><a href="<%=request.getContextPath()%>/logout.riderlog">로그아웃</a>
		<%} %>
	</ul>
	<div style="border-left: 2px solid #f0f0f0;height: 200px;float:left;margin-left:30px"></div>
	<ul style="list-style-type:none;padding-left:30px;float:left;">
		<li><img src=rider_image/logo3.png></li>
		<li style="padding:10px 0px 20px 0px;font-size:20px;">내 정보</li>
		<li><a href="<%=request.getContextPath() %>/riderInfo.ridermem?Option=see">내 정보 보기</a></li>
		<li style="padding-bottom:5px"></li>
	</ul>
	<div style="border-left: 2px solid #f0f0f0;height:200px;float:left;margin-left:30px"></div>
	<ul style="list-style-type:none;padding-left:30px;float:left;">
		<li style="padding-left:10px"><img src="rider_image/logo4.png"></li>
		<li style="padding:10px 0px 20px 0px;font-size:20px;">배달 정보</li>
		<li><a href="<%=request.getContextPath() %>/deliveryInfo.ridermem">배달 목록</a></li>
		<li style="padding-bottom:5px"></li>
		<li><a href="<%=request.getContextPath() %>/deliverySuccessInfo.ridermem">배달 완료 목록</a></li>
	</ul>
</div>
<div style="clear:both;"></div>
<br><br>
<jsp:include page="menu_top.jsp" />

	<br><br>
	<table style="min-width:1000px;margin-left:auto;margin-right:auto">
	<tr><td>
	<div id="wrapper" style="margin-left:5%;">
	

		<div id="slider" onmouseover="view(true)" onmouseout="view(false)">
			<ul>
				<li><img src="rider_image/delivery1.png"/></li>
				<li><img src="rider_image/delivery2.png"/></li>
				<li><img src="rider_image/delivery3.png"/></li>
				<li><img src="rider_image/delivery5.png"/></li>
			</ul>
		</div>
		<div id="sliderbutton" style="display:none;"  onmouseover="view(true)" onmouseout="view(false)"><img src="data/left.gif" width="32" height="38" alt="Previous" onclick="slideshow.move(-1)"/></div>
		<div id="sliderbutton2" style="display:none;"  onmouseover="view(true)" onmouseout="view(false)"><img src="data/right.gif" width="32" height="38" alt="Next" onclick="slideshow.move(1)"/></div>
		<ul id="pagination" class="pagination">
		<li onclick="slideshow.pos(0)"></li>
		<li onclick="slideshow.pos(1)"></li>
		<li onclick="slideshow.pos(2)"></li>
		<li onclick="slideshow.pos(3)"></li>
	</ul>
</div>
<script type="text/javascript">
var slideshow=new TINY.slider.slide('slideshow',{
	id:'slider',
	auto:3,
	resume:true,
	vertical:false,
	navid:'pagination',
	activeclass:'current',
	position:0
});	
</script>	
	<div style="float:left;margin-left:2%;padding-top:50px;">
	<%if(riderid==null){ %>
	<form name="loginform" action="<%=request.getContextPath() %>/login.riderlog" method="post" onsubmit="return checkform(this)">
	<table style="width:300px">
		<tr><td><br></td></tr>
		<tr>
			<td><input type="text" name="id" id="id" placeholder="아이디" class="inputbox" style="border-radius:5px/5px"></td>
		</tr>
		
		<tr>
			<td style="padding-top:3px;"><input type="password" name="pass" id="pass" placeholder="비밀번호" class="inputbox" style="border-radius:5px/5px"></td>
		</tr>
		<tr>
			<td style="float:right;margin-right:10%;"><input type="checkbox" id="idSaveCheck"><label for="idSaveCheck">아이디 기억하기</label></td>
		</tr>
		<tr>
			<td style="font-size:15px;padding-top:10px;">
			<a href="<%=request.getContextPath() %>/rider/checkid.jsp">아이디 찾기</a> /
			<a href="<%=request.getContextPath() %>/rider/checkpass.jsp">비밀번호 찾기</a>
			</td>
		</tr>
		<tr>
			<td style="padding-top:10px;">
			<input type="submit" value="로그인" class="buttonbox" style="font-family: 'Jua', sans-serif;font-size:30px;">
			<br><br>
			<input type="button" onclick="location.href='<%=request.getContextPath() %>/joinForm.ridermem'" value="회원가입" class="buttonbox" style="background:#a0a0a0;font-family: 'Jua', sans-serif;font-size:30px;">
			<br>	
			<div style="text-align:left;padding-top:5px;font-weight:600;padding-left:10%;">회원가입을 하실 분들은 신청서가 승인된 상태에서 본인의 인증키를 알고 계셔야 합니다.</div>
			<br><br>
			<a href="<%=request.getContextPath() %>/main.jsp" style="font-size:14px;font-family: 'Jua', sans-serif;display:inline-block;"><img src="rider_image/logo1.png"><br>고객&nbsp; 페이지</a>
			</td>
		</tr>
		
	</table>
	</form>
	
	<%}else{%>
		<div style="padding-top:30px;margin-left:20%;width:200px;">
		<span style="font-size:19px;">${ridername }님 환영합니다</span><br><br>
		<a href="<%=request.getContextPath() %>/riderInfo.ridermem?Option=see" style="font-size:13px;text-decoration:none;">내 정보</a>
		&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath() %>/logout.riderlog" style="font-size:13px;text-decoration:none;">로그아웃</a><br><br>
		<button class="buttonbox" style="font-family: 'Jua', sans-serif;font-size:25px;width:200px;" onclick="javascript:location.href='<%=request.getContextPath()%>/deliveryInfo.ridermem'">
		배달 목록
		</button><br>
		<button class="buttonbox" style="font-family: 'Jua', sans-serif;font-size:25px;width:200px;margin-top:10px;background:#a0a0a0;" onclick="javascript:location.href='<%=request.getContextPath() %>/deliverySuccessInfo.ridermem'">
		배달 완료 목록
		</button><br><br>
		<a href="<%=request.getContextPath() %>/main.jsp" style="font-size:14px;text-align:center;margin-top:20px;margin-left:20px;font-family: 'Jua', sans-serif;display:inline-block;">
		<img src="rider_image/logo1.png"><br>고객&nbsp; 페이지
		</a>
		</div>
	<% } %>
	</div>
	</td></tr>
	</table>
	<div style="clear:both;"></div>
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