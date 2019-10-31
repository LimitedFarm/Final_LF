<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="https://fonts.googleapis.com/css?family=Noto+Serif+KR:200,300&display=swap&subset=korean" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../css/buttons.css" />
<meta charset="UTF-8">
<title>결제 페이지</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>

<form action="<%=request.getContextPath()%>/PaySuccess.bo" method="post" id="submit">

<input type="hidden" id="pid" name="pid">
<input type="hidden" id="sid" name="sid">
<input type="hidden" id="cid" name="cid">
<input type="hidden" id="mCount" name="mCount">

<input type="hidden" id="cInput4" name="Cname">	<!-- 이름 -->
<input type="hidden" id="cInput5" name ="Cphone">	<!-- 연락처1 -->
<input type="hidden" id="cInput6" name ="Cphone">	<!-- 연락처2 -->
<input type="hidden" id="cInput7" name ="Cphone">	<!-- 연락처3 -->
<input type="hidden" id ="phone" name="phone"> <!-- 연락처 합친거 -->
<input type="hidden" id="cInput8" name="Cadd">	<!-- 주소1 -->
<input type="hidden" id="cInput8" name="Cadd" value=" "> <!-- 주소구분 공백 -->
<input type="hidden" id="cInput9" name="Cadd">	<!-- 주소2 -->
<input type="hidden" id="cInput8" name="Cadd" value=" "> <!-- 주소구분 공백 -->
<input type="hidden" id="cInput10" name="Cadd">	<!-- 주소3 -->
<input type="hidden" id ="address" name="address"> <!-- 주소 합친거 -->
<input type="hidden" id="cInput11" name="pPlz">	<!-- 배송 요청사항  -->
<input type="hidden" id="cInput12" name ="pCount">	<!-- 수량 -->

<input type="hidden" id="cInput">	<!-- 결제수단 -->
<input type="hidden" id="cInput2" name ="Pname">	<!-- 상품명 -->
<input type="hidden" id="cInput3" name ="pPrice">	<!-- 가격 -->
</form>
	<script type="text/javascript">

		window.onload = function () {
		
		document.getElementById("pid").value = opener.document.getElementById("pid").value;
		document.getElementById("sid").value = opener.document.getElementById("sid").value;
		document.getElementById("cid").value = opener.document.getElementById("cid").value;
		document.getElementById("mCount").value = opener.document.getElementById("mCount").value;
			
		document.getElementById("cInput").value = opener.document.getElementById("throw").value;
		document.getElementById("cInput2").value = opener.document.getElementById("throw2").value;
		document.getElementById("cInput3").value = opener.document.getElementById("throw3").value;
		
		document.getElementById("cInput4").value = opener.document.getElementById("name").value;
		document.getElementById("cInput5").value = opener.document.getElementById("phone1").value;
		document.getElementById("cInput6").value = opener.document.getElementById("phone2").value;		
		document.getElementById("cInput7").value = opener.document.getElementById("phone3").value;
		document.getElementById("cInput8").value = opener.document.getElementById("sample6_address").value;
		document.getElementById("cInput9").value = opener.document.getElementById("sample6_detailAddress").value;
		document.getElementById("cInput10").value = opener.document.getElementById("sample6_extraAddress").value;
		document.getElementById("cInput11").value = opener.document.getElementById("selbox").value;
		document.getElementById("cInput12").value = opener.document.getElementById("throw4").value;
		var result='';
		$('input[name=Cphone]').map(function(){
			result +=$(this).val();
		});
		var result1='';
		$('input[name=Cadd]').map(function(){
			result1 +=$(this).val();
		});
		
		
	document.getElementById("phone").value = result; // 전화번호 합친거
	document.getElementById("address").value = result1; // 주소 합친거
		
	var payee = document.getElementById("cInput").value;
	var pname = document.getElementById("cInput2").value;
	var pprice = document.getElementById("cInput3").value;
	var name2 = document.getElementById("cInput4").value;
	
	var IMP = window.IMP; // 생략가능
	IMP.init('imp62749039'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
	IMP.request_pay({
	    pg : 'html5_inicis', // version 1.1.0부터 지원.
	    pay_method : payee,
	    merchant_uid : 'merchant_' + new Date().getTime(),
	    name : pname,
	    amount : pprice,
	    buyer_email : 'iamport@siot.do',
	    buyer_name : name2,
	    buyer_tel : '010-1234-5678',
	    buyer_addr : '서울특별시 강남구 삼성동',
	    buyer_postcode : '123-456',
	    m_redirect_url : 'https://www.naver.com'
	}, function(rsp) {
	    if ( rsp.success ) {
	    	var msg = name2 + '님의 결제가 완료되었습니다.\n';
	        msg += '결제 금액 ' + rsp.paid_amount + "원";
	        document.getElementById('submit').submit();
	        opener.location.replace('/Semi_LF/myOrder.bo');
	        window.close();
			
	    } else {
	        var msg = '결제에 실패하였습니다.';
	        msg += '에러내용 : ' + rsp.error_msg;
	        window.close();
	    }
	    alert(msg);
	});
	}
	</script>
</body>
</html>