<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>관리자 메뉴바</title>
<style>
.headerLine {
	margin-top: 98px;
	height:calc(100% - 98px); 
	display:inline-block;
	float:left;
	width:250px;
	margin-right:10px;
}
#adminMenu{
	display:inline-block;
	width:250px;
	height:calc(100% - 98px); 
	position: fixed; 
	top: 98px;
	background-color: #eee;
	font-size:1.2em;
	border:1px solid black;
	vertical-align: top;
}
#adminMenu nav{
	height:100%;
	padding-bottom:100px;
}
span {
	padding-left:20px;
	margin-top: 2px;
	color:black;
	font-size:18px;
}
.nav-item hr{
	border: solid 1px black; 
	opacity: 0.3;
}
.navbar-nav li{
	width:180px;
}
</style>
</head>
<body id="page-top">
	<%@ include file="../common/menubar.jsp"%>
	<div class="headerLine">
		<!-- Sidebar -->

		<div id="adminMenu">
			<nav class="navbar bg-light">

				<!-- Links -->
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath() %>/cuInfo.ad?currentPage=1"><span>회원
								관리</span></a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath() %>/selInfo.ad?currentPage=1"><span>판매자
								관리</span></a>
						<hr></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath() %>/selList.ad?currentPage=1"><span>판매 물품 관리</span></a>
						<hr></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath() %>/orderPList.ad?currentPage=1"><span>주문 물품 관리</span></a>
						<hr></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath() %>/question.ad?currentPage=1"><span>1대1 문의</span></a>
						<hr></li>
				</ul>
			</nav>
		</div>
	</div>

</body>
</html>