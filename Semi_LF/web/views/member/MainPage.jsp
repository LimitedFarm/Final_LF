<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style>
	.headerUnder{
		margin-top:110px;
		width:800px;
      	height:500px;
      	background:#f3f3f2;
      	margin-left:auto;
      	margin-right:auto;
      	vertical-align:center;
	}
	
  	/* Make the image fully responsive */
  	.carousel-inner img {
   	   	width:100%;
   	   	height:400px;
  	}
  	#LF_Carousel{
  		display:inline-block;
  		width:100%;
   	   	height:400px;
   	   	vertical-align:middle;
   	   	text-align:center;
  	}
  	.carousel-inner{
  		display:inline-block;
  		text-align:center;
  	}
  	.carousel-item{
  		display:inline-block;
  		text-align:center;
  	}
  	
</style>
</head>
<body style="background-color:#f3f3f2;">
	<%@ include file="../common/menubar.jsp" %>
	
	<div  class="headerUnder container" >
		
		<div id="LF_Carousel" class="carousel slide" style="align:center; width:400px; data-ride="carousel">

			<!-- Indicators -->
			<ul class="carousel-indicators">
				<li data-target="#LF_Carousel" data-slide-to="0" class="active"></li>
				<li data-target="#LF_Carousel" data-slide-to="1"></li>
				<li data-target="#LF_Carousel" data-slide-to="2"></li>
			</ul>

			<!-- The slideshow -->
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="../../images/tomato.png" class="img-responsive center-block" alt="Los Angeles" style="opacity:0.7">
				</div>
				<div class="carousel-item">
					<img src="../../images/strawberry.png" class="img-responsive center-block" alt="strawberry" style="opacity:0.7">
				</div>
				<div class="carousel-item">
					<img src="../../images/cherry.png" class="img-responsive center-block" alt="New York" style="opacity:0.7">
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="carousel-control-prev" href="#LF_Carousel" data-slide="prev">
				<span class="carousel-control-prev-icon"></span>
			</a> <a class="carousel-control-next" href="#LF_Carousel" data-slide="next">
				<span class="carousel-control-next-icon"></span>
			</a>

		</div>


	</div>
</body>
</html>