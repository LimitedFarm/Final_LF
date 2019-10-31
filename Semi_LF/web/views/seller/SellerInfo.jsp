<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="LF.member.model.vo.*, LF.seller.model.vo.*, java.sql.*"%>

<% pAttachment img = (pAttachment)request.getAttribute("image"); %> 
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


<title>Insert title here</title>
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
   	margin-top: 250px;
   	pading-top:50px;
   	top: 150px;
   	left: 220px;
    width: 1280;
    min-width: 1280px;
    min-height: 800px;
    display: inline-block; 
    pading-left:300px;
	
	margin:0 auto;
	
	}
	h1{
	text-align:left;
	}
</style>
</head>
<body>
<!-- 사업자 인증이 완료된 경우에만 사업자 정보 확인 가능 -->
<!-- 사업자 정보 페이지는 사업자 등록정보만 확인 가능 -->
<!-- 전화번호, 이메일, 주소, 비밀번호, 비밀번호 확인 등의 계정 정보 수정은 마이페이지에서 수정 -->
<!-- 사업자 등록 진행상황(미신청, 대기, 완료), 사업자 등록번호, 판매승인여부,  -->
	<%@ include file="../seller/sellerMain.jsp" %>
	
	<div class="outer">
	<h1>사업자 정보 확인</h1>
	<div class="SellerInfoArea">
	<!-- memberJoinForm.jsp에 있는 table을 복사해서 쓰자 -->
<%-- 	<form id="updateForm" action="<%=request.getContextPath() %>/selregist.me" method="post"> --%>
		<form id = "bChange" >
		<table>
			<tr>
				<td width="150px" align="left">	사업자명   </td>
				<td> <%=sellerUser.getbName() %></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td width="150px">	사업자 등록번호   </td>
				<td> <%=sellerUser.getbNum() %> </td>
			</tr>
			<tr>
				<td width="150px">	법인 번호   </td>
				<td> <%=sellerUser.getCpNum() %> </td>
			</tr>
		</table>
		</form>
		<table>	
			<tr>
				<td width="150px" align="left">판매 권한 승인 여부   </td>
				<td> <%=sellerUser.getbStatus() %> </td>
			</tr>
			<tr>
				<td width="150px">	입금계좌  </td>
				<td> <%=sellerUser.getBankName() %> / <%=sellerUser.getAcNum() %> <%=sellerUser.getAcName() %> </td>
				<td><button id="bankAccount" onclick="acPopup();">입금계좌 변경</button></td>
				<input type="hidden" id="sid" value="<%=sellerUser.getSid() %>">
				<input type="hidden" id="bankName" value="<%=sellerUser.getBankName() %>">
				<input type="hidden" id="acNum" value="<%=sellerUser.getAcNum() %>">
				<input type="hidden" id="acName" value="<%=sellerUser.getAcName() %>">
			</tr>
			<tr>
				<td width="150px">사업자등록증  </td>
			</tr>
			<tr>
				<td colspan="2"><div><div width="300px" height="300px"><img id="regImg" src="<%=request.getContextPath() %>/sellerImg/<%=img.getChangeName()%>" width="300px" height="300px"></div></div></td>
			</tr>
				
			</table>
			<br>
			<div class="btns" align="center">
				<button id="goMain" onclick="goMain();">메인으로</button>
			</div>
		</div>
	</form>
	</div>
	<script>
		function goMain(){
			 location.href="<%=request.getContextPath()%>/views/Main/MainPage.jsp";
		}
		function acPopup(){
			var url = "<%=request.getContextPath()%>/views/seller/acpopup.jsp";
            var name = "popup test";
            var option = "width = 500, height = 500, top = 100, left = 200, location = no"
            winObj = window.open(url, name, option);
		}
		/* 
		$("#bNameChange").click(function(){
			var bName = prompt("변경할 사업자명 입력 : ");
			
			$.ajax({
				url:"/LimitedF/bnc.do",		//SellerBNCServlet
				data:{bName:bname},
				type:"post",
				success:function(data){
					window.alert("사업자명 변경 완료");
				},
				error:function(data){
					window.alert("에러");
				}
			}); 
		});*/
	</script>

</body>
</html>