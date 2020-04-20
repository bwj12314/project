<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="rider.vo.OrderList"%>
    <%@ page import="java.util.*"%>
    <%
    	ArrayList<OrderList> detailarraylist=(ArrayList<OrderList>)session.getAttribute("detailarraylist");
    	int riderstate=0;
    if(session.getAttribute("riderstate")!=null){
    	riderstate=(Integer)session.getAttribute("riderstate");
    	}else{
    		riderstate=0;
    	}
   
    %>
   	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FOODELIVER 배달원 : 배달 상세</title>
<style>
	body{
		min-width:1300px;margin:0;padding:0;
	}
	table{	
		width:450px;
		float:left;height:400px;font-size:16px;
		border-collapse:collapse;
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
		min-width:1300px;
	}
	hr{
		border:1px solid rgb(230,230,230);
		
	}
	.buttonbox{
		height:50px;
		width:245px;
		font-size:25px;
		background:#3EB1B0;
		cursor:pointer;
		border:0;
		color:white;
		border:1px solid #3EB1B0;
		border-radius:5px/5px;
	}
	
</style>
<script>
	function orderSelect(){
		var accept;
		accept=confirm('해당 주문을 배달하시겠습니까?');
		
		if(accept){
			location.href='<%=request.getContextPath() %>/orderFinal.ridermem?Order_num=<%=detailarraylist.get(0).getOrder_num() %>&rider_id=<%=session.getAttribute("riderid")%>';            
		}
	}
	function orderSuccess(){
		var accept;
		accept=confirm('배달을 확실하게 완료하셨습니까?');
		
		if(accept){
			location.href='<%=request.getContextPath() %>/deliverySuccess.ridermem?Order_num=<%=detailarraylist.get(0).getOrder_num() %>';
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
</head>
<body onload="initTmap()">
	<div style="min-width:1300px;margin:auto;padding-top:20px">
	<div style="width:270px;margin:auto;">
	<a href="<%=request.getContextPath() %>/riderMain.jsp"><img src="<%=request.getContextPath() %>/rider_image/logo.png"/></a></div></div>
	<div style="min-width:1300px;margin:auto">
	<div style="min-width:1300px;margin:auto">
	<span style=" margin-left:77%;font-size:25px;display:inline-block;height:40px;font-family: 'Jua', sans-serif;" onmouseover="viewmenu(true)" onmouseout="viewmenu(false)">전체 메뉴</span>
	</div></div>
	<div id="menu_content" style="position:absolute; z-index:1; width:400px; height:200px;background:white;border:2px solid #c0c0c0;margin-left:70%; display:none" onmouseover="viewmenu(true)" onmouseout="viewmenu(false)">
	
	<ul style="list-style-type:none;padding-left:30px;float:left;">
		<li><img src="<%=request.getContextPath() %>/rider_image/logo2.png"></li>
		<li style="padding:10px 0px 20px 0px;font-size:20px;">로그인</li>
		<%if(session.getAttribute("riderid")==null){ %>
		<li><a href="<%=request.getContextPath() %>/rider/loginForm.jsp">로그인하기</a></li>
		<li style="padding-bottom:5px"></li>
		<li><a href="<%=request.getContextPath() %>/joinForm.ridermem">회원가입</a></li>
		<%}else{ %>
		<li><a href="<%=request.getContextPath()%>/logout.riderlog">로그아웃</a>
		<%} %>
	</ul>
	<div style="border-left: 2px solid #f0f0f0;height: 200px;float:left;margin-left:30px"></div>
	<ul style="list-style-type:none;padding-left:30px;float:left;">
		<li><img src="<%=request.getContextPath() %>/rider_image/logo3.png"></li>
		<li style="padding:10px 0px 20px 0px;font-size:20px;">내 정보</li>
		<li><a href="<%=request.getContextPath() %>/riderInfo.ridermem?Option=see">내 정보 보기</a></li>
		<li style="padding-bottom:5px"></li>
	</ul>
	<div style="border-left: 2px solid #f0f0f0;height:200px;float:left;margin-left:30px"></div>
	<ul style="list-style-type:none;padding-left:30px;float:left;">
		<li style="padding-left:10px;"><img src="<%=request.getContextPath() %>/rider_image/logo4.png"></li>
		<li style="padding:10px 0px 20px 0px;font-size:20px;">배달 정보</li>
		<li><a href="<%=request.getContextPath() %>/deliveryInfo.ridermem">배달 목록</a></li>
		<li style="padding-bottom:5px"></li>
		<li><a href="<%=request.getContextPath() %>/deliverySuccessInfo.ridermem">배달 완료 목록</a></li>
	</ul>
</div>
	
	<div style="clear:both;"></div>
	<div style="padding-top:12px;"></div>
	<jsp:include page="../menu_top4.jsp"/>
	
	<div style="padding-top:70px;width:1300px;margin:auto;" >
		<div style="float:left;margin-left:50px;"><img src="<%=request.getContextPath()%>/rider_image/logo11.png"></div>
		<div style="padding-top:50px"><span style="font-size:30px;font-weight:700;padding-left:30px;">배달 상세 정보</span><br><br><br><br></div>
		<hr>
	</div>
	<br><br><br><br>
	<div style="width:951px;margin:auto;">
	<table>
		<tr>
			<td style="border-top:0px;" colspan="2"><span style="font-size:25px;font-weight:bold">주 문</span></td>
		</tr>
		<tr>
			<th style="width:100px;">주문 번호</th>
			<td colspan=<%=detailarraylist.size() %>><%=detailarraylist.get(0).getOrder_num() %></td>
		</tr>
		<tr>
			<th>주문 날짜</th>
			<td colspan=<%=detailarraylist.size() %>><%=detailarraylist.get(0).getOrder_date() %></td>
		</tr>
		<tr>
			<th>메뉴 이름</th>
			
			<%for(int i=0;i<detailarraylist.size();i++){ %>
			<td style="padding-left:30px;">
			<%=detailarraylist.get(i).getOrder_name() %>
			</td>
			<%} %>
			
		</tr>	
		<tr>	
			<th>메뉴 수량</th>
			<%for(int i=0;i<detailarraylist.size();i++){ %>
			
		
			<td>
			<%=detailarraylist.get(i).getOrder_quantity() %>
			
			</td>
			<%} %>
			
		</tr>
		<tr>	
			<th>메뉴 가격</th>
			<%for(int i=0;i<detailarraylist.size();i++){ %>
			<td>
			<%=detailarraylist.get(i).getOrder_price() %>
			
			</td>
			<%} %>
		</tr>
		<tr>
			<th>총가격</th>
			<%for(int i=0;i<detailarraylist.size();i++){
				
			}
			%>
			<td colspan=<%=detailarraylist.size() %>><%=detailarraylist.get(0).getTotalmoney() %></td>
		</tr>
		</table>
		
		<table style="margin-left:50px;">
		<tr>
			<td style="border-top:0px" colspan="2"><span style="font-size:25px;font-weight:bold">가게, 고객</span></td>
		</tr>
		<tr>
			<th>가게 이름</th>
			<td><%=detailarraylist.get(0).getCompany_name() %></td>
		</tr>
		<tr>	
			<th>가게 전화번호&nbsp;&nbsp;</th>
			<td><%=detailarraylist.get(0).getCompany_tel() %></td>
		</tr>
		<tr>	
			<th rowspan="2">가게 주소&nbsp;&nbsp;</th>
			<%if(detailarraylist.get(0).getCompany_address4()!=null){ %>
			<td><%=detailarraylist.get(0).getCompany_address2().concat(" "+detailarraylist.get(0).getCompany_address4()) %></td>
			<%}else{ %>
			<td><%=detailarraylist.get(0).getCompany_address2() %></td>
			<%} %>
		</tr>
		<tr>	
			<%if(detailarraylist.get(0).getCompany_address3()==null || detailarraylist.get(0).getCompany_address3().equals("")){ %>
			<td style="height:50px">상세 정보 없음</td>
			
			<%}else{ %>
			<td><%=detailarraylist.get(0).getCompany_address3() %></td>
			<%} %>
		</tr>
		<tr>	
			<th>고객 전화번호&nbsp;&nbsp;</th>
			<td><%=detailarraylist.get(0).getMember_tel() %>
		</tr>
		<tr>	
			<th rowspan="2">고객 주소&nbsp;&nbsp;</th>
			
			<td><%=detailarraylist.get(0).getMember_address1() %></td>
			
			
			
		</tr>
		<tr>
			<%if(detailarraylist.get(0).getMember_address2().equals("")){ %>
			<td style="height:50px;">상세 주소 없음</td>
			<%}else{ %>
			<td><%=detailarraylist.get(0).getMember_address2() %></td>
			<%} %>
		</tr>
	</table>
	</div>
	<div style="clear:both;"></div>
	<br>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://api2.sktelecom.com/tmap/js?version=1&format=javascript&appKey=l7xx93b7c527952f4d53a46c0c1fba3a37ce"></script>
        <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=80987fa3b69721c11605fe407c3f3135&libraries=services"></script>



        <script type="text/javascript">
        var lat=0;
    	var lon=0;
    	
        function initTmap(){
        	
        	     
        	        
        	        var map = new Tmap.Map({
        				div:'map_div',
        				width : "500px",
        				height : "400px",
        			});
                	
                    // 경로 탐색 출발지점과 도착 지점의 좌표
                    // 구글 지도에서 나오는 좌표의 x, y를 바꾸면 된다.
                   	var startY = <%=session.getAttribute("lat")%>;
                    var startX = <%=session.getAttribute("lon")%>;
                    var endY = <%=detailarraylist.get(0).getCompany_address_lat()%>;
                    var endX = <%=detailarraylist.get(0).getCompany_address_lng()%>;
                    var passList = null;
                    var prtcl;
                    var headers = {};
        			var totalDistance='';
                    headers["appKey"]="l7xx93b7c527952f4d53a46c0c1fba3a37ce"; // 발급받은 인증키를 넣어야 한다
                    $.ajax({
                        method:"POST",
                        headers : headers,
                        url:"https://api2.sktelecom.com/tmap/routes?version=1&format=xml",
                        async:false,
                        data:{
                            startX : startX,
                            startY : startY,
                            endX : endX,
                            endY : endY,
                            passList : passList,
                            reqCoordType : "WGS84GEO",
                            resCoordType : "EPSG3857",
                            angle : "172",
                            searchOption : "0",
                            trafficInfo : "Y" //교통정보 표출 옵션입니다.
                        },
						
                        success:function(response){ //API가 제대로 작동할 경우 실행될 코드
                            prtcl = response;
                            // 결과 출력 부분 - 여기는 잘 모르겠음.
                            var innerHtml ="";
                            var prtclString = new XMLSerializer().serializeToString(prtcl);//xml to String
                            xmlDoc = $.parseXML( prtclString ),
                            $xml = $( xmlDoc ),
                            $intRate = $xml.find("Document");
							
                            var tDistance = " 총 거리 : "+($intRate[0].getElementsByTagName("tmap:totalDistance")[0].childNodes[0].nodeValue/1000).toFixed(1)+"km,";
                            totalDistance=totalDistance+tDistance;
                            var tTime = " 총 시간 : "+($intRate[0].getElementsByTagName("tmap:totalTime")[0].childNodes[0].nodeValue/60).toFixed(0)+"분";

                            $("#result").text(tDistance+tTime);
                            // 실시간 교통정보 추가
                            var trafficColors = {
                                extractStyles:true,
                                /* 실제 교통정보가 표출되면 아래와 같은 Color로 Line이 생성됩니다. */
                                trafficDefaultColor:"#000000", //Default
                                trafficType1Color:"#009900", //원활
                                trafficType2Color:"#8E8111", //지체
                                trafficType3Color:"#FF0000", //정체
                            };    
                            var kmlForm = new Tmap.Format.KML(trafficColors).readTraffic(prtcl);
                            routeLayer = new Tmap.Layer.Vector("vectorLayerID"); //백터 레이어 생성
                            routeLayer.addFeatures(kmlForm); //교통정보를 백터 레이어에 추가   

                            map.addLayer(routeLayer); // 지도에 백터 레이어 추가

                            // 경로탐색 결과 반경만큼 지도 레벨 조정
                            map.zoomToExtent(routeLayer.getDataExtent());
                        },
                        error:function(request,status,error){ // API가 제대로 작동하지 않을 경우
                        console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
                        }
                    });
                    
                    var map = new Tmap.Map({
        				div:'map_div2',
        				width : "500px",
        				height : "400px",
        			});
                    // 경로 탐색 출발지점과 도착 지점의 좌표
                    // 구글 지도에서 나오는 좌표의 x, y를 바꾸면 된다.
                   	startY = <%=detailarraylist.get(0).getCompany_address_lat()%>;
                    startX = <%=detailarraylist.get(0).getCompany_address_lng()%>;
                    endY = <%=detailarraylist.get(0).getMember_address_lat() %>;
                    endX = <%=detailarraylist.get(0).getMember_address_lng() %>;
                    passList = null;
                    prtcl;
                    headers = {};

                    headers["appKey"]="l7xx93b7c527952f4d53a46c0c1fba3a37ce"; // 발급받은 인증키를 넣어야 한다
                    $.ajax({
                        method:"POST",
                        headers : headers,
                        url:"https://api2.sktelecom.com/tmap/routes?version=1&format=xml",
                        async:false,
                        data:{
                            startX : startX,
                            startY : startY,
                            endX : endX,
                            endY : endY,
                            passList : passList,
                            reqCoordType : "WGS84GEO",
                            resCoordType : "EPSG3857",
                            angle : "172",
                            searchOption : "0",
                            trafficInfo : "Y" //교통정보 표출 옵션입니다.
                        },

                        success:function(response){ //API가 제대로 작동할 경우 실행될 코드
                            prtcl = response;

                            // 결과 출력 부분 - 여기는 잘 모르겠음.
                            var innerHtml ="";
                            var prtclString = new XMLSerializer().serializeToString(prtcl);//xml to String
                            xmlDoc = $.parseXML( prtclString ),
                            $xml = $( xmlDoc ),
                            $intRate = $xml.find("Document");
                            var tDistance = " 총 거리 : "+($intRate[0].getElementsByTagName("tmap:totalDistance")[0].childNodes[0].nodeValue/1000).toFixed(1)+"km,";
                            var tTime = " 총 시간 : "+($intRate[0].getElementsByTagName("tmap:totalTime")[0].childNodes[0].nodeValue/60).toFixed(0)+"분";
        					totalDistance=totalDistance+tDistance;
                            $("#result2").text(tDistance+tTime);
                            // 실시간 교통정보 추가
                            var trafficColors = {
                                extractStyles:true,
                                /* 실제 교통정보가 표출되면 아래와 같은 Color로 Line이 생성됩니다. */
                                trafficDefaultColor:"#000000", //Default
                                trafficType1Color:"#009900", //원활
                                trafficType2Color:"#8E8111", //지체
                                trafficType3Color:"#FF0000", //정체
                            };    
                            var kmlForm = new Tmap.Format.KML(trafficColors).readTraffic(prtcl);
                            routeLayer = new Tmap.Layer.Vector("vectorLayerID"); //백터 레이어 생성
                            routeLayer.addFeatures(kmlForm); //교통정보를 백터 레이어에 추가   

                            map.addLayer(routeLayer); // 지도에 백터 레이어 추가

                            // 경로탐색 결과 반경만큼 지도 레벨 조정
                            map.zoomToExtent(routeLayer.getDataExtent());
                        },
                        error:function(request,status,error){ // API가 제대로 작동하지 않을 경우
                        console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
                        }
                    });
                	
        	     
        	    
        	
        	
        	
        	
        }
        
</script>
<div style="margin-top:50px;"></div>
<div style="width:1000px;margin:auto;">
<span style="font-size:25px;font-weight:bold;padding-left:100px;">현재 위치 -> 가게</span>
<span style="font-size:25px;font-weight:bold;padding-left:380px;">가게 -> 고객 </span>
</div>
<br>
<div style="width:1300px;margin:auto;">
<div style="width:1100px;margin:auto;">
<div style="display:inline-block;margin-left:20px;"></div>
<div id="map_div" style="display: inline-block;width:500px;">
</div>
<div style="display:inline-block;margin-left:50px;"></div>
<div id="map_div2" style="display: inline-block;margin-left:50px;width:500px;">
</div>
</div>
</div>

<br>
<div style="width:1300px;margin:auto;">
<div style="width:1100px;margin:auto;">
<div id="result" style="display:inline-block;font-size:25px;font-weight:bold;margin-left:100px;"></div>
<div style="margin-left:20%;display:inline-block"></div>
<div id="result2" style="display:inline-block;font-size:25px;font-weight:bold"></div>
</div>
</div>
 
<div style="min-width:1300px;margin:auto">
<div style="width:520px;margin:auto;margin-top:20px">
<div style="margin-top:30px">
<a href="https://map.naver.com/v5/directions/-/-/-/car?c=14317419.7680963,4281983.2152785,11,0,0,0,dh" target="_blank"
 style="width:300px;height:50px;font-size:25px;font-weight:bold;margin-left:210px;">길찾기</a></div></div></div>
<br><br><br>
	
			<%if(riderstate==0){ %>
			<div style="min-width:1300px;margin:auto">
			<div style="width:520px;margin:auto;">
			<input type="button" onclick="orderSelect()" value="주문 배달하기" class="buttonbox" style="font-family: 'Jua', sans-serif;">&nbsp;&nbsp;&nbsp;
			<input type="button" onclick="javascript:location.href='<%=request.getContextPath() %>/deliveryInfo.ridermem'"
			 value="목록으로 돌아가기" class="buttonbox" style="font-family: 'Jua', sans-serif;">
			</div></div>
			<%}else{ %>
			<div style="min-width:1300px;margin:auto">
			<div style="width:260px;margin:auto;">
			<input type="button" onclick="orderSuccess()" 
			value="주문 배달 완료" class="buttonbox" style="font-family: 'Jua', sans-serif;">
			</div></div>
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


