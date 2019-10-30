<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>Insert title here</title>
<style>
.headbanner{
	width:100%;
	min-width:1100px;
	height:700px;
	background:lightgray;
	margin-top:110px;
	padding:0px;
	background:url('<%=request.getContextPath()%>/images/banner.jpg') no-repeat;
	background-size: cover; 
	background-repeat: no-repeat; 
	background-position: center;
	text-align:center;
	opacity:0.8;
}
#slideDiv{
	display:inline-block;
	min-width:900px;
	width:500px;
	height:450px;
	background:white;
	margin-top:250px;
	border:0.5px solid black;
}
#vertical img{
	width:500px;
	height:440px;
	margin:0;
	padding:0;
}
</style>
</head>
<body style="height:1500px">
	<%@ include file="../common/menubar.jsp" %>
	<div class="headbanner">
		<div id="slideDiv">
			<ul id="vertical">
				<li data-thumb="<%=request.getContextPath() %>/images/cherry.png"
					data-src="<%=request.getContextPath() %>/images/cherry.png">
			    <img src="<%=request.getContextPath() %>/images/cherry.png" />
			  </li>
			  <li data-thumb="<%=request.getContextPath() %>/images/applemango.jpg"
			  		data-src="<%=request.getContextPath() %>/images/applemango.jpg">
			    <img src="<%=request.getContextPath() %>/images/applemango.jpg" />
			  </li>
			  <li data-thumb="<%=request.getContextPath() %>/images/apple.png"
			  		data-src="<%=request.getContextPath() %>/images/apple.png">
			    <img src="<%=request.getContextPath() %>/images/apple.png" />
			  </li>
			  <li data-thumb="<%=request.getContextPath() %>/images/grape.jpg"
			  		data-src="<%=request.getContextPath() %>/images/grape.jpg">
			    <img src="<%=request.getContextPath() %>/images/grape.jpg" />
			  </li>
			  <li data-thumb="<%=request.getContextPath() %>/images/orange.jpg"
			  		data-src="<%=request.getContextPath() %>/images/orange.jpg">
			    <img src="<%=request.getContextPath() %>/images/orange.jpg" />
			  </li>
			</ul>
		</div>
		
	</div>
	<script>
	$(document).ready(function() {
		verticalSlider();
	});
	
	function verticalSlider(){
		$("#vertical").lightSlider({
			gallery:true,
			item:1,
			loop:true,
			verticalHeight:450,
			vThumbWidth:100,
			thumbItem:10,
			thumbMargin:4,
			enableDrag: false,
			auto : true, // 자동 슬라이드
			speed : 2000, // 슬라이드 되는 속도
			pause : 5000,
			slideMargin:0
		});
	}
	
	</script>
</body>
</html>