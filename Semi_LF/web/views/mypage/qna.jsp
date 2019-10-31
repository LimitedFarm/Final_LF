<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/views/css/mypage/qna.css" />
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

.qnaTable{
	border: 1px solid black;
    position: relative;
    top: 70px;
    left: 40px;
    width: 840px;
    height: 470px;
}

.qnaTitle{
	border-bottom: 1px solid black;
}

.qnaText{
	border-bottom: 1px solid black;
}

.qnaTopic{
	border-bottom: 1px solid black;
	vertical-align: middle;
    text-align: center;
    height: 90px;
    width: 100px;
    border-right: 1px solid black;
    
}

.qnatype{
	border-right: 1px solid black;
	vertical-align: middle;
    text-align: center;
}

.text{
    position: relative;
    left: 40px;
    top: 50px;
    width: 250px;
    height: 30px;
}

.typeBtn{
	position: relative;
    left: 50px;
    top: 50px;
    background: #3333e8;
    height: 37px;
    color: white;
    border: none;
    cursor: pointer;
}

.listType{
	position: relative;
    top: 110px;
    right: 290px;
    height: 50px;
    width: 255px;
}

.submitBtn{
	position: relative;
    top: 400px;
    width: 100px;
    height: 50px;
    background: #3333e8;
    cursor: pointer;
    color: white;
    border: none;
    right: 80px;
}

.deleteBtn{
	position: relative;
    top: 350px;
    width: 100px;
    height: 50px;
    background: #3333e8;
    cursor: pointer;
    color: white;
    border: none;
    left: 637px;
}

.qnaName{
	width: 737px;
    height: 90px;
    border: none;
}






	
</style>
</head>
<body>
		<div class="container">
		<%@ include file="menubar.jsp" %>
		
		<table border= "1" class="qnaTable">
			<tr class="qnaTitle">
				<td class="qnaTopic">문의제목</td>
				<td class="qnaText"><input type="text" class="qnaName"></td>
			</tr>
			<tr>
				<td class="qnatype">질문유형</td>
				<td><input type="text" class="text">
				<input type="submit" class="typeBtn" value="유형추가">
			<select class="listType">
			<option>상품문의</option>
			<option>결제문의</option>
			<option>배송문의</option>
			<option>교환반품문의</option>
			<option>취소환불문의</option>
			<option>기타</option>
			</select>
			
			<input type="submit" class="submitBtn" value="등록">
			<input type="submit" class="deleteBtn" value="취소">
				
				
				</td>
			
			</tr>
		</table>
		</div>
</body>
<script src="${pageContext.request.contextPath }/views/js/mypage/qna.js" ></script>
</html>