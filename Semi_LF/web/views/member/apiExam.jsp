<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>시험용</h1>
	
	<script>
		function({
			$.ajax({
				url:"http://www.kamis.co.kr/service/price/xml.do?action=dailySalesList&p_cert_key=648b698c-305a-4ac2-8f0f-a082a599eb80&p_cert_id=668&p_returntype=json",
				type:"POST",
				data:{},
				success:function(){
					
				}
				
			})
		});
	</script>
</body>
</html>