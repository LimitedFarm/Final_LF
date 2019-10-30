<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="LF.faq.model.vo.Faq"%>
<%
	Faq modifaq = (Faq)request.getAttribute("modifaq");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.Container {
	border-radius: 5px;
	background-color: #f2f2f2;
	width: 770px;
	height: 650px;
	margin: 0 auto;
}

.smBtn {
	margin-left: 3px;
	color: white;
	background-color: #4279ff;
	cursor: pointer;
	border: none;
	padding: 10px;
	float: right;
	border-radius: 5px;
	outline: none;
}

input[type=submit] {
	background-color: #2a6fff;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	float: right;
	width: 150px;
	transition: 0.5s;
}

input[type=submit]:hover {
	background-color: #004dee;
}

input[type=text], select, textarea {
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 6px;
	resize: vertical;
}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp"%>
	<div style="margin-top: 150px; margin-bottom: 20px;">
		<div class="Container">
			<br>
			<h3 align="center">FAQ 수정하기</h3>
			<hr>
			<br>
			
			<form action="<%=request.getContextPath()%>/insertmodi.fo"
				method="post">
				<input type = "hidden"  name = "fId" value = "<%=modifaq.getfId()%>">
				<table width="650px" height="450px" align="center">
					<tr>
						<td>제목</td>
						<td><input type="text" name = "title" style="width: 450px;" value="<%=modifaq.getfTitle()%>"></td>
					</tr>
					<tr>
						<td>작성자 :</td>
						<td colspan="2"><%=loginUser.getUserName()%></td>
						<td><input type = "hidden" name = "fWriter" id = "fWriter" value = "<%=adminUser.getAid()%>"></td>
						
					</tr>
					<tr>
						<td>내용</td>
						<td colspan="2"><textarea rows="10" cols="60" name="content"
								style="resize: none; width: 100%"><%=modifaq.getfContent() %></textarea></td>
					</tr>
					<tr>
						<td colspan="3"><input class="smBtn" type="submit"
							value="수정하기"></td>
					</tr>
				</table>
			</form>
		
		</div>
	</div>

</body>
</html>