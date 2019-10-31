<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.container {
	border: 1px solid black;
	width: 1280px;
	min-width: 1280px;
	margin:0 auto;
	min-height: 800px;
	padding-bottom: 100px;
}

.confirm_area {
    /* border: 1px solid black; */
    width: 500px;
    height: 500px;
    /* margin: 0 auto; */
    margin-left: 470px;
    text-align: center;
}

.confirm_area h2 {
	margin-top: 180px;
	font-size: 30px;
	color: #3e3e3e;
}

.confirm_area h3 {
	color: #888888;
    margin-top: 15px;
    font-size: 18px;
}

.confirm_area h4 {
	color: #888888;
    margin-top: 15px;
    font-size: 18px;
    display: none;
}


.emailInput {
	min-width: 330px;
    height: 30px;
    margin-top: 20px;
    display: none;
}

.confirmBtn {
	background: #3030e4;
    border: none;
    color: white;
    font-weight: bold;
    width: 100px;
    height: 36px;
    margin-left: -3px;
    margin-top: 20px;
    cursor:pointer;
    display: none;
}

.emailText {
	min-width: 330px;
    height: 30px;
    margin-top: 50px;
}

.sendConfirmMail {
	background: #3030e4;
    border: none;
    color: white;
    font-weight: bold;
    width: 100px;
    height: 36px;
    margin-left: -3px;
    margin-top: 50px;
    cursor: pointer;
}
	
</style>
</head>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/views/css/mypage/confirm.css" />


<body>
	
	<div class="container">
		<%@ include file="menubar.jsp" %>
		
		<div class="confirm_area">
		
			<h2>이메일 인증</h2>
			<h3>개인정보 보호를 위해 이메일 인증을 해주세요.</h3>
			
			<input type="text" class="emailText" readonly="readonly" value="${email }"/>
			<input type="button" class="sendConfirmMail" value="인증메일전송" />
			
			<input type="text" class="emailInput" placeholder="인증번호를 입력해주세요."/>
			<input type="button" value="확인" class="confirmBtn"/>
		
		</div>

	</div>
</body>

<script src="${pageContext.request.contextPath }/views/js/mypage/confirm.js" ></script>
</html>