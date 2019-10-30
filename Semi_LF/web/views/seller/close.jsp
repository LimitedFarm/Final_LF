<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
	<h1 align="center"><%= msg %></h1>
	<button id="goMain">메인 페이지로 이동</a>
	
<script>

$(function() {
    $("#goMain").on("click", function() {
    	window.opener.location.href="<%=request.getContextPath() %>/views/common/menubar.jsp";
        self.close();
    });
});

//팝업창 종료 시 
$(window).on('beforeunload', function() {
    var ua  = navigator.userAgent.toLowerCase();
    if ((navigator.appName == 'Netscape' && ua.indexOf('trident') != -1) || (ua.indexOf("msie") != -1)){
    	//오프너는 menubar로 이동, 팝업창은 종료
    	window.opener.location.href="<%=request.getContextPath() %>/views/Main/MainPage.jsp";
   		self.close();
    }else{
    	window.opener.location.href="<%=request.getContextPath() %>/views/Main/MainPage.jsp";
        self.close();
    }
});





</script>

</body>
</html>