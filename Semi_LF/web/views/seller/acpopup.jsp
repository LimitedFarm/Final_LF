<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="LF.member.model.vo.*, java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>Insert title here</title>
<!-- <style>
	.outer{
	position:absolute;
	z-index:1600;
	}
</style> -->
</head>
<body>

<div class="outer">
	<h1>사업자 정보 변경</h1>
	<form id="updateForm" action="<%=request.getContextPath() %>/sellerUpdate.selr" method="post">
		<table border:1px gray solid>
			<tr>
				<td width="200px">입금계좌 은행명</td>
				<td><select id="bName" name="bName" >
						<option value="">----</option>
						<option value="sh">신한은행</option>		<!-- 11,2자리 -->
						<option value="nh">농협은행</option>		<!-- 11,2자리 -->
						<option value="nhLocal">지역농협</option>	<!-- 13,4자리 -->
						<option value="kb">국민은행</option>		<!-- 14자리 -->
						<option value="wr">우리은행</option>		<!-- 13자리 -->
						<option value="ibk">기업은행</option>		<!-- 14자리 -->
						<option value="keb">하나은행</option>		<!-- 14자리 -->
					</select>
				</tr>
				<tr>
					<td width="200px">입금계좌 계좌번호</td>
					<td><input type="text" maxlength="14" id="acN" name="acN" required></td>
				</tr>
				<tr>
					<td width="200px">예금주</td>
					<td><input type="text" maxlength="13" id="acNa" name="acNa" required></td>
				</tr>
				<input type="hidden" id="sid" name="sid" value=" ">
			
			
			<%-- <input type="text" id="bank_code_std" value="<%=bank_code_std%>">
			<input type="text" id="account_num" value="<%=account_num%>">
			<input type="text" id="account_holder_info"
				value="<%=account_holder_info%>">
			<input type="text" id="tran_dtime" value="<%=tran_dtime%>"> --%>




		</table>
		<p id="demo"></p>
		<br>
		<div class="btns" align="center">
			<button type="button" id="maintain" onclick="clean();">값 불러오기</button>
			<button id="change" onclick="account();">변경하기</button>	
			<!-- SellerInfoUpdate -->
		</div>
	</div>

		<script>
		
		function clean(){
			$("#acN").empty();
			$("#acNa").empty();
			var bName = $("#bankName", opener.document).val();
			var acNum = $("#acNum", opener.document).val();
			var acName = $("#acName", opener.document).val();
			
			console.log(bName);
			console.log(acNum);
			console.log(acName);
			
			$("#bName").val(bName).prop("selected", true);
			$("#acN").val(acNum);
			$("#acNa").val(acName);
			
		}
		
		//은행 선택 여부
		function account(){
			//sid값 보내기
			var sid = $("#sid", opener.document).val();
			console.log(sid);
			$("#sid").val(sid);
			
			//은행 선택 여부
			var bankName = $("#updateForm select[name='bName']").val();
			
			if(bankName == ""){
				return false;
			}else{S
				console.log(true);
				
				var acNum = $("#updateForm input[name='acN']").val();
				acNum = ((acNum+'').match(/\d{1}/g));
				console.log(acNum);
				if(bankName == "sh" || bankName =="nh"){
					 if(acNum.length != 11 && acNum.length != 12){
							alert("계좌번호가 잘못되었습니다.");
							}else{
							console.log(true);
							return true;
							
					}
				}else if(bankName == "nhLocal"){
					if(acNum.length != 13 && acNum.length != 14){
						alert("계좌번호가 잘못되었습니다.");
						}else{
						console.log(true);alert("항목을 선택해주세요.");
						return true;
					}
				}else if(bankName == "wr"){
					if(acNum.length != 13){
						alert("계좌번호가 잘못되었습니다.");
						}else{
						console.log(true);alert("항목을 선택해주세요.");
						return true;
					}
				}else{
					if(acNum.length != 14){
						alert("계좌번호가 잘못되었습니다.");
						}else{
						console.log(true);alert("항목을 선택해주세요.");
						return true;
					}
				}
				
				//Seller + Pattachment에 각각 값 입력.
			}
		}
		</script>
</body>
</html>