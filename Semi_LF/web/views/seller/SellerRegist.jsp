<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="LF.member.model.vo.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>판매자 회원 신청 및 사업자 인증 페이지</title>
<style>
	#idCheck{
			background:orangered;
			border-radius:5px;
			width:80px;
			height:25px;
			text-align:center;
		}
	
	.outer{
	position: absolute;
   	margin-top: 130px;
    width: 800px;
    height: 500px;
    display: inline-block;
    /* text-align: center; */
	}
	h1{
	text-align:left;
	}
	#MyPageMenu{
		margin-top : 130px;
		width: 200px; 
		height: 500px;	
		display:inline-block;
		text-align:center;
	}
</style>
</head>
<body>
<%-- 
	 일반 사용자 계정 로그인 된 상태에서만 판매자 회원 신청 가능
	 로그인 되어있지 않으면 로그인 페이지를 먼저 띄워주고 그 뒤에 신청하도록 함
	 
   --%>
   
   <%@ include file="../mypage/menubar.jsp" %>
	
	<div class="outer">
	<h1 id="subject">판매자 회원 신청</h1>
		<br>
		
 		<form id="joinForm" action="<%=request.getContextPath() %>/sellerRegist.selr" method="post"  encType="multipart/form-data">	 
			<table>
			<input type="hidden" id="cid" name="cid" value="<%=loginUser.getCid() %>">
			<%System.out.println(loginUser.getCid()); %>
				<tr>
					<td width="200px">사업자 이름  </td>
					<td><input type="text" maxlength="13" name="bName" required></td>
				</tr>
				<tr>
					<td width="200px">사업자 등록번호</td>
					<td><input type="text" maxlength="10" name="bNum" id="bNum" required><br><div></div></td>
					</td>
				</tr>
				<tr>
					<td width="200px">법인 번호</td>
					<td><input type="text" maxlength="13" name="cpNum" required><br><div></div></td>
				</tr>
				<tr>
					<td width="200px">입금계좌 은행명</td>
					<td><select id="bankName" name="bankName">
							<option value="">----</option>
							<option value="sh">신한은행</option>		<!-- 11,2자리 -->
							<option value="nh">농협은행</option>		<!-- 11,2자리 -->
							<option value="nhLocal">지역농협</option>		<!-- 13,4자리 -->
							<option value="kb">국민은행</option>		<!-- 14자리 -->
							<option value="wr">우리은행</option>		<!-- 13자리 -->
							<option value="ibk">기업은행</option>		<!-- 14자리 -->
							<option value="keb">하나은행</option>		<!-- 14자리 -->
						</select>
				</tr>
				<tr>
					<td width="200px">입금계좌 계좌번호</td>
					<td><input type="text" maxlength="14" name="acNum" required></td>
				</tr>
				<tr>
					<td width="200px">예금주</td>
					<td><input type="text" maxlength="13" name="acName" required></td>
				</tr>
				<tr>
					<td width="200px">사업자 등록증</td>
					<td><input type="file" id="sellerReg" name="sellerReg" onchange="LoadImg(this);" required></td>
				</tr>
				<tr>
					<td width="200px"></td>
					<td><div><img id="regImg" width="120" height="100"></div></td>
				</tr>
			</table>
			
			<div class="btns" align="center">
				
				<button id="joinBtn" type="submit" onclick="check();">신청하기</button>	<!-- submit 버튼으로 만들어서 실행해야 input태그들의required가 발동함 -->
				
				<!-- SellerRegistServlet으로 이동 -->
			</div>
		</form>
	</div>
	
	<script>
	//사진 등록
 	$(function(){
		/* $("#selReg").hide(); */
		
		$("#regImg").click(function(){
			$("#sellerReg").click();
		});
	});
	
	 function LoadImg(value){
		if(value.files[0]!=undefined){
			var reader = new FileReader();
			
			reader.onload = function(e){
				$("#regImg").attr("src",e.target.result);
			}
			reader.readAsDataURL(value.files[0]);
		}
	}
	
	//사업자 등록번호 체크
	function check(){
		alert("button click");
		
		//사업자 등록번호 체크
		var bNum = $("#joinForm input[name='bNum']").val();
		console.log(bNum);
		
		if((bNum = (bNum+'').match(/\d{1}/g)).length != 10){
			alert("사업자 등록번호가 잘못되었습니다.");
			focus("$joinForm input[name='bNum']");
			return false;
		}
		
		var sum = 0, key = [1,3,7,1,3,7,1,3,5];
		
		for(var i=0; i<9; i++){
			sum += (key[i]*Number(bNum[i]));
		}
		
		console.log(((10 - ((sum + Math.floor(key[8] * Number(bNum[8])/10)) % 10)) % 10) == Number(bNum[9]));
		
		
		
		//법인번호 체크
		var cpNum = $("#joinForm input[name='cpNum']").val();
		var re = /-/g;
		cpNum = cpNum.replace('-','');
		
		if(cpNum.length != 13){
			alert(false);
			return false;
		}
		
		var arr_regno  = cpNum.split("");
		var arr_wt   = new Array(1,2,1,2,1,2,1,2,1,2,1,2);
		var iSum_regno  = 0;
		var iCheck_digit = 0;
		
		for(i=0 ; i<12 ; i++){
			iSum_regno += eval(arr_regno[i]) * eval(arr_wt[i]);
		}
		
		iCheck_digit = 10 - (iSum_regno % 10);
		iCheck_digit = iCheck_digit % 10;
		
		if( iCheck_digit != arr_regno[12]){
			alert(false);
			return false;
		}else{
			console.log(true);
		}
		
		
		//은행 선택 여부
		var bankName = $("#joinForm select[name='bankName']").val();
		
		if(bankName == ""){
			alert("항목을 선택해주세요.");
			return false;
		}else{
			console.log(true);
			var acNum = $("#joinForm input[name='acNum']").val();
			acNum = ((acNum+'').match(/\d{1}/g));
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
					console.log(true);
					return true;
				}
			}else if(bankName == "wr"){
				if(acNum.length != 13){
					alert("계좌번호가 잘못되었습니다.");
					}else{
					console.log(true);
					return true;
				}
			}else{
				if(acNum.length != 14){
					alert("계좌번호가 잘못되었습니다.");
					}else{
					console.log(true);
					return true;
				}
			}
			
			//Seller + Pattachment에 각각 값 입력.
		}
		
		
		
	


	 
	
	}
	 
	</script>

</body>
</html>