<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{
		min-width:1000px;
		margin:0;
		padding:0;
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
		width:100px;height:40px;font-size:20px;background:white;border:1px solid black;cursor:pointer;
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
<script>
		var Q=1;
		var oTbl;
		function insRow(){ //행 추가
			Q++;
			oTbl=document.getElementById("addTable");
			var oRow=oTbl.insertRow();
			oRow.onmouseover=function(){oTbl.clickedRowIndex=this.rowIndex};//클릭한 행의 위치를 확인
			
			var oCell1=oRow.insertCell();
			
			//삽입될 Form Tag
			var frmTag1="<div style='padding-top:10px;'><span style='font-size:20px;font-weight:bold;padding-top:10px;'>회원 연락처</span>"+
			"<input type='text' name='tel' id='tel' style='height:30px;font-size:17px;padding-left:10px;margin-left:24px;border-radius:5px/5px;' placeholder='휴대폰 번호 입력' size='15'>"+
			"<button type='button' onClick='removeRow()' style='cursor:hand;margin-left:14px;width:120px;height:33px;font-size:16px;border:1px solid black;background:white;'>삭제</button></div>";
			
			
			document.getElementById('totalrow').innerHTML=Q;
			oCell1.innerHTML=frmTag1;
			
			
		}
		function removeRow(){
			oTbl.deleteRow(oTbl.clickedRowIndex);
			Q--;
			document.getElementById('totalrow').innerHTML=Q;
		}
		function frmCheck(){
			var frm=document.form; //form 은 form 태그의 name form 을 가리킨다.
			for(var i=0;i<=frm.elements.length-1;i++){
				if(frm.elements[i].name.indexOf("tel")>-1){
					if(!frm.elements[i].value){
						alert("연락처를 입력하세요");
						frm.elements[i].focus();
						return false;
					}
				}
			}
		}
</script>
<script>
	
	function start(){
		
		document.getElementById('totalrow').innerHTML=1;
		
		
		
	}
</script>
</head>
<body onload="start()">
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
		
		<div style="padding-top:70px;width:1000px;margin:auto;" >
		<div style="float:left;margin-left:50px;">
		<img src="<%=request.getContextPath()%>/rider_image/logo15.png"></div>
		<div style="padding-top:30px"><span style="font-size:30px;font-weight:700;padding-left:30px;">배달 회원 인증키 추가</span>
		</div><br><br>
		<hr>
		</div>
		
		<div style="width:700px;margin:auto;background:rgb(250,250,250);margin-top:80px;padding:50px 0 50px 0;">
			<form method="post" action="<%=request.getContextPath() %>/insertCertifyKey.adm" name="form" onsubmit="return frmCheck()" id="form">
			<table style="margin:auto;">
				<tr><td>
				<table id="addTable">
					<tr>
						<td style="padding-top:20px;">
							<label for="tel" style="font-size:20px;font-weight:bold;">회원 연락처</label>
							<input type="text" name="tel" id="tel" style="height:30px;font-size:17px;padding-left:10px;margin-left:20px;border-radius:5px/5px" placeholder="휴대폰 번호 입력" size="15">
							<button type="button" name="addButton" style="cursor:hand;margin-left:10px;width:120px;height:33px;font-size:16px;border:1px solid black;background:white;" onclick="insRow()">연락처 추가</button>
						</td>
					</tr>
						
				</table>
				</td></tr>
				<tr><td style="text-align:center;padding-top:50px;font-size:20px;">행의 수 : <span id="totalrow"></span></td></tr>
			</table>
			</form>
		</div>
		
		<div style="width:230px;margin:auto;margin-top:50px;">
			
			<button type="submit" form="form" class="buttonbox">추가</button>
			<button onclick="history.back();" style="margin-left:20px;" class="buttonbox">
				취소
			</button>
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