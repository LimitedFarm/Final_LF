<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.io.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<style>
* {
	box-sizing: border-box;
}

input[type=text], select, textarea {
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 6px;
	resize: vertical;
}

label {
	padding: 12px 12px 12px 0;
	display: inline-block;
}

input[type=submit] {
	background-color: #2a6fff;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	float: right;
	width: 100%;
	transition: 0.5s;
}

input[type=submit]:hover {
	background-color: #004dee;
}

.OboContainer {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
	width: 770px;
	height: 900px;
	margin-top: 120px;
	margin: 0 auto;
}

.col-25 {
	
}

.col-75 {
	float: left;
	width: 75%;
	margin-top: 6px;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

.btn {
	background-color: DodgerBlue;
	border: none;
	color: white;
	padding: 12px 16px;
	font-size: 16px;
	cursor: pointer;
	transition: 0.5s;
}

.btn:hover {
	background-color: RoyalBlue;
}
.imgfiles{

    margin-top: 1px;
    margin-bottom: 1px;

}
</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp"%>
	<%
	String[] email = loginUser.getEmail().split("@");
	
	String pN = loginUser.getPhone();
	
	String midPn = null;
	String endPn = null;
	/*number= 123123123*/
	
	/*start = 012345678*/
	
	/*end   = 123456789*/
	if(pN.length()==9){
		midPn = pN.substring(3,6);
		endPn = pN.substring(6,9);
	};
	
	%>
	<div style="margin-top: 120px; margin-bottom: 20px;">
		<div class="OboContainer">
			<h3 align="center">1 : 1 문 의</h3>
			<hr>
				<br>
		<form action = "<%=request.getContextPath()%>/Oboinsert.oi" method="post"
		 encType="multipart/form-data">
			<table width="650px" height="700px" align="center">
				<tr>
					<td width="85px">
						<p>아이디</p>
					</td>
					<td width="380px">
						<p><%=loginUser.getUserId()%></p>
						<input type = "hidden" name = "cid" value = "<%=loginUser.getCid()%>">
					</td>
					<td><select id="inquiryType" name = "inquiryType">
							<option value="1">상품문의</option>
							<option value="2">결제문의</option>
							<option value="3">배송문의</option>
							<option value="4">교환반품문의</option>
							<option value="5">취소환불문의</option>
							<option value="6">기타</option>
					</select></td>
				</tr>
				<tr>
					<td><label>E-MAIL</label></td>
					<td colspan="2">
					<input type="text" value ="<%=email[0]%>" name = "emailId"> @ 
					<input type="text" name="selfdomain" id="selfdomain" title="이메일 도메인 직접입력" style="width: 120px;"/> 
						<select id="sampledomin" name="sampledomin" style="vertical-align: middle;">
							<option value="">선택</option>
							<option value="naver.com" selected>naver.com</option>
							<option value="gmail.com">gmail.com</option>
							<option value="daum.net">daum.net</option>
							<option value="hotmail.com">hotmail.com</option>
							<option value="empas.com">empas.com</option>
							<option value="yahoo.co.kr">yahoo.co.kr</option>
							<option value="nate.com">nate.com</option>
							<option value="self1">직접입력</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><label>전화번호</label></td>
					<td><select id = "firPnum" name = "firPnum" style="width: 70px">
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="016">016</option>
							<option value="017">017</option>
							<option value="018">018</option>
							<option value="019">019</option>
					</select> - <input type="text" id = "midPnum" name = "midPnum" style="width: 90px" value ="<%=midPn%>" maxlength="4"> -
								<input type="text" id = "endPnum" name = "endPnum"  style="width: 90px" value ="<%=endPn%>" maxlength="4"></td>
				</tr>
				<tr>
					<td><label>제목</label></td>
					<td colspan="2"><input type="text" name = "title" style="width: 400px;">
					</td>
				</tr>
				<tr>
					<td><label>문의내용</label></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><textarea rows="10" cols="60" name = "content"
							style="resize: none; width: 100%"></textarea></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><label>첨부파일</label></td>

					<td colspan="2"
						style="height: 110px; padding-left: 10px; padding-top: 6px; background: white; border-radius: 5px;">
						<div>
							<input type="file" class="imgfiles" multiple="multiple" id = "img1" name = "img1" onchange="checkFile(this)">
					
							<input type="file" class="imgfiles" multiple="multiple" id = "img2" name = "img2" onchange="checkFile(this)">
						
							<input type="file" class="imgfiles" multiple="multiple" id = "img3" name = "img3" onchange="checkFile(this)">
						</div>
					</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><br> <input type="submit" value="보내기"></td>
				</tr>
			</table>
		</form>
		</div>
	</div>
	
<script>
	/*이메일 직접입력 선택시 text박스 show하기*/
	$(function(){
		$("#selfdomain").hide();
			
			$("#sampledomin").change(function(){
				if($("#sampledomin").val() == "self1") {
					$("#selfdomain").show();
				
				}else{
					$("#selfdomain").val("");
					$("#selfdomain").hide();
				};
				
			});
	});
	
	/*이미지 파일만 걸러내는 필터 */
	function checkFile(f){
		
		var file = f.files;
		//file[0]은 파일명
		//정규식으로 확장자 체크하기
		if (!/\.(jpg|jpeg|png)$/i.test([file[0].name])) alert('jpg, jpeg, png 파일만 업로드 가능합니다')
	
		
		//체크 통과햇으면 종료
		else return;
		
		//확장자가 다르면 내용 취소처리를 해야한다.
		//하지만 파일선택 폼의 내용은 스크립트로 컨트롤 불가능
		//폼을 새로 써주는 방식으로 초기화한다.
		f.outerHTML = f.outerHTML;
		
	}
	
	
</script>

</body>
</html>