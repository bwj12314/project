<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=80987fa3b69721c11605fe407c3f3135&libraries=services"></script>
<script>
if (navigator.geolocation) {
    
    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
    navigator.geolocation.getCurrentPosition(function(position) {
        
        var lat = position.coords.latitude, // 위도
            lon = position.coords.longitude; // 경도
            location.href='<%=request.getContextPath()%>/rider/deliveryInfoSecondDetail.jsp?lat='+lat+'&lon='+lon;
            
      });
    
} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
    
    alert('geolocation을 사용할 수 없습니다.');
}
</script>
</body>
</html>