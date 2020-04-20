<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="rider.vo.OrderList"%>
    <%@ page import="java.util.*"%>
    <%
    	ArrayList<OrderList> orderarraylist=(ArrayList<OrderList>)session.getAttribute("orderArrayList");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://api2.sktelecom.com/tmap/js?version=1&format=javascript&appKey=l7xx93b7c527952f4d53a46c0c1fba3a37ce"></script>
        <script type="text/javascript">
        var size=<%=orderarraylist.size()%>;		
        function initTmap(){
        	var totalDistance="";
        	if(size>0){
        	if (navigator.geolocation) {
        		
        		navigator.geolocation.getCurrentPosition(function(position) {
        			var lat = position.coords.latitude, // 위도
                     lon = position.coords.longitude; // 경도
           	var startY = lat;
            var startX = lon;
            var endY = <%=orderarraylist.get(0).getCompany_address_lat()%>;
            var endX = <%=orderarraylist.get(0).getCompany_address_lng()%>;
            var passList = null;
            var prtcl;
            var headers = {};

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
                    // 실시간 교통정보 추가
                    
                },
                error:function(request,status,error){ // API가 제대로 작동하지 않을 경우
                console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
                }
            });
        		
            // 경로 탐색 출발지점과 도착 지점의 좌표
            // 구글 지도에서 나오는 좌표의 x, y를 바꾸면 된다.
           	var startY = <%=orderarraylist.get(0).getCompany_address_lat()%>;
            var endX = <%=orderarraylist.get(0).getCompany_address_lng()%>;
            var endY = <%=orderarraylist.get(0).getMember_address_lat()%>;
            var endX = <%=orderarraylist.get(0).getMember_address_lng()%>;
            var passList = null;
            var prtcl;
            var headers = {};

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
					alert('엔터를 눌러주세요');
                    // 실시간 교통정보 추가
                    
                    location.href='<%=request.getContextPath()%>/distance/distance2.jsp?totalDistance='+totalDistance;
                },
                error:function(request,status,error){ // API가 제대로 작동하지 않을 경우
                console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
                }
            });
            
        	
            });//getCurrent
        }//navigator.geo(if)
        	}else{
        		location.href='<%=request.getContextPath()%>/distance/processDistance.jsp?totalDistance='+totalDistance;
        	}
        }//함수
		</script>
  <body onload="initTmap()">
  
    </body>
</html>