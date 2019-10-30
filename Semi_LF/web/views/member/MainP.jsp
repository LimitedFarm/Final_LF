<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet"  href="https://cdnjs.cloudflare.com/ajax/libs/lightslider/1.1.6/css/lightslider.min.css"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/lightslider/1.1.6/js/lightslider.min.js"></script>
<title>메인 페이지</title>
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
	width:900px;
	height:450px;
	background:white;
	margin-top:250px;
	padding:10px;
}
#galleryDiv{
	display:inline-block;
	margin-top:200px;
}
ul{
    list-style: none outside none;
    padding-left: 0;
    margin: 0;
}
.slide-content .slide-content{
    margin-bottom: 60px;
}
.slider li{
    text-align: center;
    color: #FFF;
    background-size:cover;
    background-position: center;
}
.slider h3 {
    margin: 0;
    padding: 100px 0;
    height:250px;
}
.slide-content{
    width: 100%;
    height:300px;
}
.item1{background-image:url('http://han3283.cafe24.com/images/apple.jpg');}
.item2{background-image:url('http://han3283.cafe24.com/images/cherry.jpg');}
.item3{background-image:url('http://han3283.cafe24.com/images/strawberry.jpg');}
.item4{background-image:url('http://han3283.cafe24.com/images/grape.jpg');}
.item5{background-image:url('http://han3283.cafe24.com/images/lemon.jpg');}
.item6{background-image:url('http://han3283.cafe24.com/images/grapefruit.jpg');}
	
</style>
</head>
<body>
	<div class="headbanner">
		<div id="slideDiv">
			<div class="slide-wrap">
				<div class="slide-content">
					<ul id="slider" class="slider">
						<li class="item1">
							<h3>사과</h3>
						</li>
						<li class="item2">
							<h3>체리</h3>
						</li>
						<li class="item3">
							<h3>딸기</h3>
						</li>
						<li class="item4">
							<h3>포도</h3>
						</li>
						<li class="item5">
							<h3>레몬</h3>
						</li>
						<li class="item6">
							<h3>자몽</h3>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			slider();
		});
		
		function slider(){
			$("#slider").lightSlider({
				mode : 'slide', // 이미지가 표시되는 형식 (fade / slide)
				loop : true, // 무한반복 할 것인지
				auto : true, // 자동 슬라이드
				pager : false, // 페이지 표시
				speed : 1000, // 슬라이드 되는 속도
				pause : 3000
			});
		}
		
		$(document).mouseup(function(){
			slider();
		});
	</script>
</body>
</html>