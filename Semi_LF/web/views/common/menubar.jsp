<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="LF.member.model.vo.*"%>
<%
	Customer loginUser = (Customer)session.getAttribute("loginUser");
	Seller sellerUser = (Seller)session.getAttribute("sellerUser");
	Admin adminUser = (Admin)session.getAttribute("adminUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"  href="https://cdnjs.cloudflare.com/ajax/libs/lightslider/1.1.6/css/lightslider.min.css"/>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/lightslider/1.1.6/js/lightslider.min.js"></script>

<title>Insert title here</title>
<style type="text/css">
	.headerNavi{	
		display:inline-block;
		border-radius:5px;
		width:auto;
		height:auto;
	}
	.genric-btn {
  		display: inline-block;
  		outline: none;
  		line-height: 40px;
  		padding: 0 30px;
  		font-size: .8em;
  		text-align: center;
  		text-decoration: none;
  		font-weight: 500;
  		cursor: pointer;
  		-webkit-transition: all 0.3s ease 0s;
  		-moz-transition: all 0.3s ease 0s;
  		-o-transition: all 0.3s ease 0s;
  		transition: all 0.3s ease 0s;
	}
	.genric-btn.radius {
 		border-radius: 3px;
	}
	.genric-btn.medium {
  		line-height: 30px;
	}
	.genric-btn.info {
  		color: #fff;
  		background: #38a4ff;
  		border: 1px solid transparent;
	}
	.genric-btn.circle {
  		border-radius: 20px;
	}
	#menuBtn{
		background:url('<%=request.getContextPath()%>/images/menubtn.png') no-repeat;
		background-size: 80%; 
		background-repeat: no-repeat; 
		background-position: center;
		border: 0px;
		height: 75px;
		width : 75px;
	}
	#inlineUl li{
		display:inline;
	}
	#rightMenu{
		align:right;
	}
	#menu{
		width: 250px; 
		height:calc(100% - 110px); 
		position: fixed; 
		top: 110px; 
		left: -320px; 
		z-index: 1055;
		background-color: #eee; 
		font-size:1.2em;
		transition: All 0.2s ease;
		overflow-x:hidden;
	}
	
	#menu.open{
		left:0px;
	}
	.material-icons.md-25{
		color:black;
		font-size:25px;
		vertical-align:bottom;
	}
	.linkSpan{
		position: relative;
	    top: 1px;
	    display: inline-block;
	    font-style: normal;
   		font-weight: 400;
	    line-height: 1;
	}
	.linkC{
		padding: 12px 8px 12px 16px;
	    font-size: 1.1em;
	    text-decoration:none;
	    color: #333;
		display: block;
	    transition: .3s;
	}
	.aline{
		border-bottom: 1px solid #444;
	}
	.table-borderless td{
		margin-top:5px;
		margin-bottom:5px;
	}
	.modal-body td{
		text-align:left;
	}
	.btnSize{
		align:right; 
		max-width:120px; 
		max-height:42px;
		min-width:120px;
		min-height:42px;
	}
</style>
</head>
<body>
	<!-- header역할을 하며 로그인, 회원가입, 메뉴바를 열수 있는 버튼을 생성 -->
	<div class="navbar navbar-expand-sm bg-light navbar-dark fixed-top row" id="headerDiv" style="min-width:1200px; max-height:100px; z-index:1055; float:top;" >
		<div class="headerNavi col-sm-1" align="left" >
			<input id="menuBtn" type="button">
		</div>
		<div class="headerNavi col-sm-8" align="center">
			<img id="logo" src="<%=request.getContextPath()%>/images/logo.png" height='75' width="300">
		</div>
		<div class="headerNavi col-sm-3" id="rightMenu" style="min-width:500px;">
			<% if(loginUser == null) {%>
				<ul id="inlineUl">
					<li><button id="loginBtn" class="genric-btn info circle btnSize" type="button"  data-toggle="modal" data-target="#loginModal">로그인</button></li>
					<li><button id="signUpBtn" class="genric-btn info circle btnSize" type="button" data-toggle="modal" data-target="#signupModal">회원가입</button></li>
				</ul>
			<%} else { %>
				<ul id="inlineUl">
					<li style="display:inline-block; vertical-align:middle"><%=loginUser.getUserName() %>님 환영합니다.</li>
					<li><button id="logoutBtn" class="genric-btn info circle btnSize" type="button">로그아웃</button></li>
				</ul>
			<%} %>
		</div>
		<hr>
	</div>
	
	<!-- 슬라이드 형식으로 버튼 클릭시 도출되는 메뉴바 -->
	<div id="menu">
		<a href="<%=request.getContextPath() %>/views/member/MainPag.jsp" class="linkC"><span class="linkSpan"><i class="material-icons md-25">home</i></span>&nbsp;&nbsp;Home</a>
		<% if(loginUser == null) {%>
		
		<a href="#loginBtn" class="linkC aline"><span class="linkSpan"><i class="material-icons md-25">account_circle</i></span>&nbsp;&nbsp;My Page</a>
		
		<%} else if(loginUser.getGroupNum().equals("1")) {%>
		
		<a href="/Semi_LF/myMain.bo" class="linkC aline"><span class="linkSpan"><i class="material-icons md-25">account_circle</i></span>&nbsp;&nbsp;My Page</a>
		
		<%} else if(loginUser.getGroupNum().equals("2")) {%>
		
		<a href="/Semi_LF/views/seller/sellerMain.jsp" class="linkC aline"><span class="linkSpan"><i class="material-icons md-25">account_circle</i></span>&nbsp;&nbsp;My Page</a>
		<%} else if(loginUser.getGroupNum().equals("3")){%>
		<a href="<%=request.getContextPath() %>/cuInfo.ad?currentPage=1" class="linkC aline"><span class="linkSpan"><i class="material-icons md-25">account_circle</i></span>&nbsp;&nbsp;Admin Page</a>
		<%}%>
		<a href="/Semi_LF/list.po?cate=0" class="linkC"><span class="linkSpan"><i class="material-icons md-25">add_shopping_cart</i></span>&nbsp;&nbsp;상품 게시판</a>
		<a href="/Semi_LF/myBasket.bo" class="linkC aline"><span class="linkSpan"><i class="material-icons md-25">shopping_basket</i></span>&nbsp;&nbsp;장바구니</a>
		<a href="/Semi_LF/list.fo" class="linkC"><span class="linkSpan"><i class="material-icons md-25">question_answer</i></span>&nbsp;&nbsp;고객센터</a>
	</div>
	
	
	
	<% if(loginUser == null) {%>
	<div class="modal fade" id="loginModal" tabindex="-1" role="dialog">
		<form id="loginForm" action="<%=request.getContextPath()%>/login.me" onsubmit="return loginValidate();" method="post">
		<div class="modal-dialog modal-dialog-centered" style="width: 400px;">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">로그인</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body" style="padding: 30px; text-align:center;">
					<!-- <form id="loginInfo"> -->
						<table class="table-borderless" style="display:inline-block">
							<tr>
								<td>아이디</td>
								<td><input type="text" class="form-control" id="loginId" name="loginId" required></td>
							</tr>
							<tr>
								<td>비밀번호</td>
								<td><input type="password" class="form-control" id="loginPwd" name="loginPwd" required></td>
							</tr>
							<tr>
								<td colspan=2 align="right"><a href="#">아이디/비밀번호 찾기</a></td>
							</tr>
						</table>
<!-- 					</form> -->
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button id="loginConnect" type="submit" class="btn btn-success">로그인</button>
					<button type="button" class="btn btn-success" data-dismiss="modal" id="closeLogin">닫기</button>
				</div>
			</div>
		</div>
		</form>
	</div>
	<%} %>
	
	<!-- 회원가입 모달 -->
	<% if(loginUser == null) {%>
	<div class="modal fade" id="signupModal" tabindex="-1" role="dialog" style="margin-top:30px;">
		<form id="signupForm" action="<%=request.getContextPath()%>/signup.me" onsubmit="return signValidate();" method="post">
		<div class="modal-dialog modal-dialog-centered modal-lg">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title" >회원가입</h4>
					<button type="button" class="close" id="closeSignup" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body" style="padding: 10px; text-align:center;">
						<table class="table-borderless"  style="display:inline-block;">
							<tr>
								<td>아이디</td>
								<td><input type="text" class="form-control" id="signupId" name="signupId" required></td>
								<td style="width:10px;"></td>
								<td><button type="button" onclick="idCheck();">중복체크</button></td>
								<td width="100px"></td>
							</tr>
							<tr>
								<td>비밀번호</td>
								<td><input type="password" class="form-control" id="signupPwd" name="signupPwd" required></td>
							</tr>
							<tr>
								<td>비밀번호 재확인&nbsp;</td>
								<td><input type="password" class="form-control" id="signupPwd2" name="signupPwd2" required></td>
								<td></td>
								<td colspan=2 style="font-size:11px; vertical-align:bottom;"><p style="margin-top:10px;" id="matchingPwd"></p></td>
							</tr>
							<tr>
								<td>이름</td>
								<td><input type="text" class="form-control" id="userName" name="userName" required></td>
							</tr>
							<tr>
								<td>주소</td>
								<td><input type="text" class="form-control" id="address1" name="address1" placeholder="우편번호" readonly></td>
								<td></td>
								<td><button type="button" onclick="addressFind()">주소 검색</button>
							</tr>
							<tr>
								<td></td>
								<td colspan=4><input type="text" class="form-control" id="address2" name="address2" placeholder="주소" required></td>
							</tr>
							<tr>
								<td></td>
								<td colspan=4><input type="text" class="form-control" id="address3" name="address3" placeholder="상세주소" required></td>
							</tr>
							<tr>
								<td>휴대전화</td>
								<td><input type="text" class="form-control" id="phoneNum" name="phoneNum" required></td>
							</tr>
							<tr>
								<td>이메일</td>
								<td><input type="text" class="form-control" id="emailAddress" name="emailAddress" required></td>
								<td>@</td>
								<!-- <td id="hiddenEmail"></td> -->
								<td style="display:inline-block">
									<select name="emailLog" id="emailLog" class="custom-select">
										<option value="" selected>-- 선택 --</option>
										<option value="naver.com">naver.com</option>
										<option value="hanmail.net">hanmail.net</option>
										<option value="gmail.com">gmail.com</option>
									</select>
							</tr>
						</table>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button id="signupConnect" type="submit" class="btn btn-success">가입</button>
					<button type="button" class="btn btn-success" data-dismiss="modal" id="closeSign">닫기</button>
				</div>

			</div>
		</div>
		</form>
	</div>
	<%} %>

	<script>
		$(function() {
			$("#signupId").focus();
			
			/* 메뉴바 버튼 */
			$("#menuBtn").click(function() {
				if ($("#menu").hasClass("open")) { //class에 open이 없을 시 open클래스 추가 있을 시 삭제
					$("#menu").removeClass("open");
					
				} else {
					$("#menu").addClass("open");
				}
			});

			// 일반회원 버튼
			
			// 판매자 버튼
			
			// 관리자 버튼
			$("#adminPage").click(function(){
				location.href="../admin/adminMainPage.jsp"
			});
			
			/* 로그인 기능 */
			// validate() 함수 작성하기(form태그가 submit되었을 때 실행 됨)
			function loginValidate(){
				if($("#userId").val().trim().length==0){
					alert("아이디를 입력하세요");
					$("#userId").focus();
					
					return false;	// return값이 false면 submit이 되지 않는다.
				}
				if($("#userPwd").val().trim().length==0){
					alert("비밀번호를 입력하세요");
					$("#userPwd").focus();
					
					return false;
				}
				
				return true;
			}
			// 회원가입 기능
			function signValidate(){
				if($("#signupId").val().trim().length<=3){
					alert("아이디를 4자 이상입력하세요");
					$("#signupId").focus();
					
					return false;	// return값이 false면 submit이 되지 않는다.
				}
				if(!$("#signupId").is("readonly")){
					alert("아이디 중복검사를 해주세요");
					
					return false;
				}
				if($("#signupPwd").val().trim().length<=3){
					alert("비밀번호를 입력하세요");
					$("#signupPwd").focus();
					
					return false;
				}
				
				return true;
			}
			
			// 로그인을 안했을 시 MyPage를 누르면 로그인창이 열림
			$("#MyPage").click(function(){
				$("#loginBtn").click();
				$("#menu").removeClass("open");
			});
			
			// 로그인, 회원가입중 하나가 열려 있을 시 발동 (다른 모달 및 메뉴바를 없앤다.)
			$("#loginBtn").click(function(){
				if($("#menu").hasClass("open")){
					$("#menu").removeClass("open");
				}
				if($("#signupModal").hasClass("show")){
					$("#signupModal").modal('hide');
				}
			});
			
			$("#signupBtn").click(function(){
				if($("#menu").hasClass("open")){
					$("#menu").removeClass("open");
				}
				if($("#loginModal").hasClass("show")){
					$("#loginModal").modal('hide');
				}
			});
			
		});
		$("#matchingPwd").hide();
		
		// 아이디 중복 체크
		function idCheck(){
			var checkid = $("#signupId").val();
			console.log(checkid);
			if(checkid == "" || checkid.length <4){
				alert("아이디를 4글자 이상으로 적어주세요");				
			}else{
				$.ajax({
					url : "/Semi_LF/checkid.me",
					type : "post",
					data : {checkid : checkid},
					success : function(data) {
						if(data == 1){
							alert("이미 사용중인 아이디입니다.");
							$("#signupId").val("");
							$("#signupId").focus();
						}else{
							alert("사용 가능한 아이디입니다.");
							$("#signupId").attr("readonly", "true");
						}
					}
				});	
			}
			
		};
		
		// 비밀번호 일치 기능
		$("#signupPwd2").keyup(function(){
			var pwd1 = $("#signupPwd").val();
			var pwd2 = $("#signupPwd2").val();
			
			if(pwd1 != "" || pwd2 != ""){
                if(pwd1 == pwd2){
                    $("#matchingPwd").text("비밀번호가 일치합니다.").css("color","blue");
                    $("#matchingPwd").show();
                }else{
                    $("#matchingPwd").text("비밀번호가 일치하지 않습니다.").css("color","red");;
                	$("#matchingPwd").show();
                }
			}
			if(pwd1<=3){
				$("#matchingPwd").text("비밀번호를 4자 이상으로 적어주세요").css("color","red");;
            	$("#matchingPwd").show();
			}
		});
		
		
		
		$(document).click(function(event) { // 메뉴바를 제외한 부분 클릭시 메뉴바 닫힘
				if (!($("#menu").is(event.target)|| $("#menuBtn").is(event.target)
					|| $("#menu").children().is(event.target) || $(
						"#childsBtn").children().is(event.target))) {
						if ($("#menu").hasClass("open")) { //class에 open이 없을 시 open클래스 추가 있을 시 삭제
							$("#menu").removeClass("open");
						}
					}
		});
		
		$("#logoutBtn").click(function(){
			location.href = "<%=request.getContextPath()%>/logout.me";	
		});
	</script>
	<script>
		//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
		function addressFind() {
			new daum.Postcode(
					{
						oncomplete : function(data) {
							// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

							// 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
							// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
							var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
							var extraRoadAddr = ''; // 도로명 조합형 주소 변수

							// 법정동명이 있을 경우 추가한다. (법정리는 제외)
							// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
							if (data.bname !== ''
									&& /[동|로|가]$/g.test(data.bname)) {
								extraRoadAddr += data.bname;
							}
							// 건물명이 있고, 공동주택일 경우 추가한다.
							if (data.buildingName !== ''
									&& data.apartment === 'Y') {
								extraRoadAddr += (extraRoadAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
							if (extraRoadAddr !== '') {
								extraRoadAddr = ' (' + extraRoadAddr + ')';
							}
							// 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
							if (fullRoadAddr !== '') {
								fullRoadAddr += extraRoadAddr;
							}

							// 우편번호와 주소 정보를 해당 필드에 넣는다.
							document.getElementById('address1').value = data.zonecode; //5자리 새우편번호 사용
							document.getElementById('address2').value = fullRoadAddr;
							
						}
					}).open();
		}
	</script>
</body>
</html>