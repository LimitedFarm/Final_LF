<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "LF.board.model.vo.*, java.util.*"%>
    
<%
	Board buyList = (Board)request.getAttribute("board");
	int mCount = (Integer)request.getAttribute("mCount");
	String pathImg = (String)request.getAttribute("pathImg");
	int cid = (int)request.getAttribute("cid");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="https://fonts.googleapis.com/css?family=Noto+Serif+KR:200,300&display=swap&subset=korean" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../css/buttons.css" />
<meta charset="UTF-8">
<title>결제 페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<style>

		
	.info{
		border: 1px solid;
		border-color: #ddd #ddd #CACACA;
		width: 1000px;
    	height: 360px;
    	margin-left:auto;
        margin-right:auto;
        margin-top:50px;
	}
	.PList{
		border: 1px solid;
		border-color: #ddd #ddd #CACACA;
		width: 1000px;
    	height: 360px;
    	margin-left:auto;
        margin-right:auto;
        margin-top:10px;
	}
	.infotable{
		border: 0px solid;
		border-color: #ddd #ddd #CACACA;
		width: 900px;
    	height: 230px;
    	margin-top: 5%;
	}
	.thmo{
		width: 110px; 
		height: 50px;
	}
	.pay{
		border: 1px solid;
		border-color: #ddd #ddd #CACACA;
		width: 1000px;
    	height: 100%;
    	margin-left:auto;
        margin-right:auto;
        margin-top:5px;
	}
	#payinfo1{
		width: 487px;
    	height: 350px;

	}
	#payinfo2{
		width: 502px;
    	height: 350px;

	}
	.payui1{
	border: 1px solid;
		width: 460px; 
		height: 100px;
	}
	.payui2{
		width: 460px; 
		height: 250px;
	}
	.payui3{
		width: 460px; 
		height: 150px;
	}
	#aaa:visited{
		background: red;
		color: green;
	}
	#bbb:visited{
		background-color: red;
	}
	#ccc:visited{
		background: red;
	}
	
	input[type="radio"] {
    display:none;
}

	input[type="radio"] {
	    color:#f2f2f2;
	    font-family:Arial, sans-serif;
	}
	
	input[type="radio"] + label span {
	    display:inline-block;
	    width:19px;
	    height:19px;
	    margin:-2px 10px 0 0;
	    vertical-align:middle;
	    background:url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/210284/check_radio_sheet.png) -38px top no-repeat;
	    cursor:pointer;
	}
	
	input[type="radio"]:checked + label span {
	    background:url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/210284/check_radio_sheet.png) -57px top no-repeat;
	}
	body {
    font-family: Arial, sans-serif;
    position:relative;
	}
	

</style>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }
				
                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>

	<script type="text/javascript">
		function paygo(){
			var name = document.getElementById("name").value;
			var phone2 = document.getElementById("phone2").value;
			var phone3 = document.getElementById("phone3").value;
			var add1 = document.getElementById("sample6_address").value;
			var add2 = document.getElementById("sample6_detailAddress").value;
			var add3 = document.getElementById("sample6_extraAddress").value;
			
			if(name == "" || phone2 == "" || phone3 == "" || add1 == "" || add2 == ""){
				alert("배송 정보를 모두 기입해주세요!");
			}else{
		    window.name = "Payment";
		    // window.open("open할 window", "자식창 이름", "팝업창 옵션");
		    openWin = window.open("views/Board/PaymentA.jsp",
		            "PaymentA", "width=850, height=700, resizable = no, scrollbars = no");
			}
		}
		
	</script>


<script>
		function onlyNumber(event){
			event = event || window.event;
			var keyID = (event.which) ? event.which : event.keyCode;
			if ( (keyID >= 48 && keyID <= 57) || (keyID >= 96 && keyID <= 105) || keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 ) 
				return;
			else
				return false;
		}
		function removeChar(event) {
			event = event || window.event;
			var keyID = (event.which) ? event.which : event.keyCode;
			if ( keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 ) 
				return;
			else
				event.target.value = event.target.value.replace(/[^0-9]/g, "");
		}
	</script>





</head>

<body>
<%@include file="../common/menubar.jsp" %>
<Br><Br><Br>
<jsp:include page="buttons.jsp" />
	<form>
			<div class="info">
				<input type="hidden" id="pid" name="pid" value="<%=buyList.getpId() %>">
				<input type="hidden" id="sid" name="sid" value="<%=buyList.getsId() %>">
				<input type="hidden" id="cid" name="cid" value="<%=cid %>">
				<input type="hidden" id="mCount" name="mCount" value="<%=mCount%>">
				<font  color="#5D5D5D" size="5" style="margin-left: 5%; font-weight:300;">배송 정보</font>
				<hr>
				<table class="infotable" style="margin-left: 5%; margin-right:5%;">
					<tr>
						<th class="thmo">이름</th>
						<td><input type="text" id="name" size="20" name="name" maxlength="20"></td>
						
					</tr>
					
					<tr>
						<th class="thmo">연락처</th>
						<td>
							<select id="phone1" style="width:66px;height:21.33px;">
								<option value="010">010</option>
								<option value="011">011</option>
								<option value="016">016</option>
								<option value="017">017</option>
								<option value="019">019</option>
							</select>
							
								- <input id="phone2" class="phone" type="text" size="5" maxlength="4" onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' >
								&nbsp;-&nbsp;
								<input id="phone3" class="phone" type="text" size="5" maxlength="4" onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)'>
						</td>
					</tr>
					
					
					
					<tr>
						<th class="thmo">주소</th>
						<td>
							<span><input type="text" id="sample6_address" placeholder="주소" size="46" readonly="readonly" style="height: 20px;"></span>
							<span><input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"></span><br>
							<input type="text" id="sample6_detailAddress" placeholder="상세주소" style="height: 20px;">
							<input type="text" id="sample6_extraAddress" placeholder="참고항목" readonly="readonly" style="height: 20px; width: 165px;">
						</td>
					</tr>
					<tr>
						<th class="thmo">배송 요청사항</th>
						<td>
							<select id="selbox" name="selbox" style="height:21.33px;">
								<option value="부재시 경비실에 맡겨주세요.">부재시 경비실에 맡겨주세요.</option>
								<option value="집 앞에 놓아주세요.">집 앞에 놓아주세요.</option>
								<option value="택배함에 넣어주세요.">택배함에 넣어주세요.</option>
								<!-- <option value="direct">직접입력</option> -->
							</select>
							<br>
							<div id="selfmessageinput">
							
							</div>
							
						</td>
						<tr>
					</tr>
				</table>
				
			</div>
			<div class="PList" style="width: 1000px; height: 400px;">
				<font  color="#5D5D5D" size="5" style="margin-left: 5%; font-weight:300;">주문상품 정보</font><br>
				<br>
				<table style="border: 1px solid; border-left:0px; border-right:0px; border-color: #ddd #ddd #CACACA; width: 1000px; height: 180px;">
					<tr>
						<td style="text-align: center; ">
							상품이미지
						</td>
						<td style="text-align: center;">
							상품명
						</td>
						<td style="text-align: center;">
							가격
						</td>
						<td style="text-align: center;">
							수량
						</td>
						<td style="text-align: center;">
							합계
						</td>
					</tr>
					<tr >
						<td style="text-align:center; width: 150px; border-top: 1px solid; border-color: #ddd #ddd #CACACA;">
							<img src="<%=pathImg%>" style="width:130px; height:130px;">
						</td>
						
						<td style="text-align: center; width: 350px; border-top: 1px solid; border-color: #ddd #ddd #CACACA;">
							<%=buyList.getpName()%>
						</td>
						<td style="text-align: center; border-top: 1px solid; border-color: #ddd #ddd #CACACA;">
							<%=buyList.getpPrice()%> 원
						</td>
						<td style="text-align: center; border-top: 1px solid; border-color: #ddd #ddd #CACACA;">
							<%=buyList.getpCount()%> 개
						</td>
						<td style="text-align: center; border-top: 1px solid; border-color: #ddd #ddd #CACACA;">
							<%=buyList.getpPrice()*buyList.getpCount()%> 원
						</td>
					</tr>
				</table>
			</div>
			
			<div class="PList" style="width: 1000px; height: 350px; border: 0px">
				<table>
							<tr>
								<td>
								<div id="payinfo1">
							<font  color="#5D5D5D" size="5" style="margin-left: 5%; font-weight:300;">결제 수단</font>
							<hr>
							<div>
								<div style="border: 1px solid; border-color: #ddd #ddd #CACACA; width: 485px; height: 250px;">
									<table style="margin-left:10%; margin-top: 10% ">
										<tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr>
										
										<tr>
											<td>
												<input type="radio" id="r1" name="check" onclick="document.getElementById('throw').value = this.value" value="card" checked="checked">
								    			<label for="r1"><span></span>신용카드</label>
											</td>
											<td>
												<input type="radio" id="r2" name="check" onclick="document.getElementById('throw').value = this.value" value="vbank">
								   				<label for="r2"><span></span>무통장 입금</label>
											</td>
											<td>
												 <input type="radio" id="r3" name="check" onclick="document.getElementById('throw').value = this.value" value="trans">
								    			<label for="r3"><span></span>실시간 계좌이체</label>
											</td>
										<tr>
										
										<tr>
											<td></td>
										</tr>
										<tr>
											<td></td>
										</tr>
										<tr>
											<td></td>
										</tr>
										
										<tr>
											<td>
												<input type="radio" id="r4" name="check" onclick="document.getElementById('throw').value = this.value" value="phone">
								 			    <label for="r4"><span></span>휴대폰 결제</label>
											</td>
											<td>
												<input type="radio" id="r5" name="check" onclick="document.getElementById('throw').value = this.value" value="samsung">
								    			<label for="r5"><span></span>삼성페이</label>
											</td>
											<td>
											
											</td>
										</tr>					
								    
									</table>
								</div>
							</div>
								
								
							</div>
								</td>
								
								<td>
							<div id="payinfo2">
							<font  color="#5D5D5D" size="5" style="margin-left: 5%; font-weight:300;">결제 금액</font>
							<hr>
							<div>
								<div id="payall" style="border: 1px solid; border-color: #ddd #ddd #CACACA; width: 500px; height: 250px;">
									<table>
										<tr>
											<td style="width: 150px; height:30px; text-align: center;">
												<font>상품 금액</font>
											</td>
											<td style="width:300px; text-align: center;">
											<%int a = buyList.getpPrice()*buyList.getpCount();%>
												<%=a%>원
											</td>
										</tr>
										
										<tr>
											<td style="width: 150px; height:30px; text-align: center;">
												<font>배송비</font>
											</td>
											<td style="text-align: center;">
												<%int b = 5000; %>
												<%=b %>원
											</td>
										</tr>
									</table>
									
									<div style="border-top: 1px solid; border-color: #ddd #ddd #CACACA; width: 500px; height: 100px;">
										<table>
											<tr>
												<td style="width:150px; height:50px; text-align: center;">
													<font>최종 결제금액 </font>
												</td>
											</tr>
											<tr>
												<td>
													
												</td>
												<td style="width: 300px; text-align: center;">
												 	<font size="5em" style="color: red;"><%=a+b%>원</font>
												</td>
											</tr>
										</table>
									</div>
									<div>
									<table>
										<tr>
											<td style="text-align: right; width: 280px;">
												<a class="button small green"  onclick="paygo()">결제하기</a>
											</td>
										</tr>
									</table>
										<!-- 결제 방법 -->
										<input type="hidden" id="throw" >
										
										<!-- 상품명 -->
										<input type="hidden" id="throw2" value="<%=buyList.getpName()%>">
										
										<!-- 결제금액 -->
										<input type="hidden" id="throw3" value=<%=a+b%>>
										
										<!-- 수량 -->
										<input type="hidden" id="throw4" value=<%=buyList.getpCount()%>>
										
									</div>
								</div>
							</div>
						</div>
								</td>
							</tr>
				</table>
			</div>
	</form>
	
	<br><br>
</body>
</html>