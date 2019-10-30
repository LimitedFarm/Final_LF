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
	min-width:1200px;
	height:700px;
	background:lightgray;
	margin-top:110px;
	margin-bottom:0;
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
}
#vertical img{
	width:750px;
	height:440px;
	margin:0;
	padding:0;
}
.secondMainDiv{
	height:100%;
	margin-top:20px;
	min-width:1100px;
	min-height:1000px;
	text-align:center;
}
#newProduct{
	display:inline-block;
	width:1200px;
	height:620px;
	border:1px solid black;
}
#reviewSlide{
	display:inline-block;
	margin-top:10px;
	margin-bottom:10px;
	width:900px;
	height:500px;
	text-align:center;
	padding:20px;
	border: 1px solid black;
	border-radius: 3%;
}
.card.cardSize{
	width:250px;
	height:400px;
}
</style>
</head>
<body>
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
	<div class="secondMainDiv">
		<div id="newProduct" style="position:relative">
		<div style="position:absolute; top:0px; left:0px;">
		<iframe width="1200px" height="620px" src="https://www.kamis.or.kr/customer/main/main.do" align="top"  scrolling="no" frameborder="0" ></iframe>
		</div>
		</div>
		<div id="reviewSlide">
			<ul id="reviewSlider">
				<% for(int i=1; i<=5 ;i++) {%>
					<li>
						<div class="card cardSize" >
							<div class="card-header" id="mReview<%=i%>">평점</div>
							<div class="card-body" id="reContent<%=i%>">Content</div>
						</div>
					</li>
				<%} %>
			</ul>
		</div>
	</div>
	<script>
	$(document).ready(function() {
		verticalSlider();
		reviewSliderFn();
	});
	
	function verticalSlider(){
		$("#vertical").lightSlider({
			gallery:true,
			item:1,
			loop:true,
			vertical:true,
			verticalHeight:450,
			vThumbWidth:150,
			thumbItem:4,
			thumbMargin:4,
			enableDrag: false,
			auto : true, // 자동 슬라이드
			speed : 2000, // 슬라이드 되는 속도
			pause : 5000,
			slideMargin:0
		});
	}
	function reviewSliderFn(){
		$("#reviewSlider").lightSlider({
			item:3,
			mode:'slide',
			loop:true,
			enableDrag: false,
			auto : true, // 자동 슬라이드
			speed : 2000, // 슬라이드 되는 속도
			pause : 5000,
			slideMargin:0
		});
	}
	$(function(){
		/* mTimer = setInterval(function() {
			$.ajax({
				url:"/Semi_LF/mReview.me"
				type:"post",
				success:function(data){
					if(data.length == 0){
						var i = 1;
						for(var key in data){
							var grade = $("#mReview"+i).html("");
							var content = $("#reContent"+i).html("");
							grade.html(data[key].grade);
							content.html(data[key].reContent);
							i = i+1;
						}
					}
				}
			});
		}, 30000); */
		
	});
	
	</script>
</body>
</html>