<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="LF.faq.model.vo.Faq,java.util.ArrayList"%>

<%
	ArrayList<Faq> flist = (ArrayList<Faq>)request.getAttribute("flist");
	%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>Insert title here</title>
<style>
.accordion {
	background-color: #eee;
	color: #444;
	cursor: pointer;
	align: center;
	padding: 18px;
	width: 650px;
	border: none;
	text-align: left;
	outline: none;
	font-size: 15px;
	transition: 0.4s;
}

.active, .accordion:hover {
	background-color: #ccc;
}

.accordion:after {
	content: '\002B';
	color: #777;
	font-weight: bold;
	float: right;
	margin-left: 5px;
}


.active:after {
	content: "\2212";
}

.panel {
	padding: 0 18px;
	background-color: white;
	max-height: 0;
	overflow: hidden;
	transition: max-height 0.3s ease-out;
}

.FAQbox {
	margin: 0 Auto;
	width: 650px;
}

.uibutton1 {
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

.uibutton2 {
	margin-left: 3px;
	color: white;
	background-color: #4279ff;
	cursor: pointer;
	border: none;
	padding: 5px;
	float: right;
	border-radius: 5px;
	outline: none;
	 margin-bottom: 3px;
}

.uibutton3 {
	margin-left: 3px;
	color: white;
	background-color: #ff0511;
	cursor: pointer;
	border: none;
	padding: 5px;
	float: right;
	border-radius: 5px;
	outline: none;
	  margin-bottom: 3px;
}
.uibutton1:hover {
	background-color: #024bff;
}
.uibutton2:hover {
	background-color: #024bff;
}
.uibutton3:hover {
	background-color: #ee0030;
}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp"%>
	<div style="margin-top: 130px;">
		<h2 align="center">FAQ</h2>
	</div>
	<hr>
	<br>

	<div class="FAQbox">
		<% if(flist.size() == 0) {%>
		<button class="accordion">질문이 없습니다.</button>
		<br>
		<% } else { %>
		<%for(Faq f : flist) {%>
		<button class="accordion"><%=f.getfTitle()%></button>
				
		<div class="panel">
			<br>
			<div>
			<p>
				<%=f.getfContent()%>
			</p>
			<%if (loginUser==null){ %>
			 <%}else if (loginUser.getGroupNum().equals("3")){ %>
				<button class="uibutton3">FAQ 삭제하기</button>
				
				<button class="uibutton2">FAQ 수정하기</button>
				
				<input type="hidden" value="<%=f.getfId() %>">
			<%} %>
				<br>
			</div>
		</div>
		<%} %>
		<%} %>
	
		<br>
		<%if (loginUser==null){ %>
		<%} else if(loginUser.getGroupNum().equals("1") || loginUser.getGroupNum().equals("2")){%>
		<button id="OboMove" class="uibutton1" onclick="insertObo();">1:1문의하기</button>
		<%}else if (loginUser.getGroupNum().equals("3")){ %>
		
		<button class="uibutton1" value="FAQ 작성하기" onclick="insertFaq();">FAQ 작성하기</button>
	
		<%} %>
	</div>

<script>
	var acc = document.getElementsByClassName("accordion");
	var i;

	for (i = 0; i < acc.length; i++) {
  		acc[i].addEventListener("click", function() {  //아코디언 메뉴 클릭하면 
    
	this.classList.toggle("active");
  
    var panel = this.nextElementSibling;

    if (panel.style.maxHeight) {
    	  panel.style.maxHeight = null;
   		 } else {
  	    panel.style.maxHeight = panel.scrollHeight + "px";
  	  	
  	  }
  	});
}
</script>

<script>  //faq 수정하기
	$(document).on('click', ".panel .uibutton2", function() {
		var fid = $(this).parent().find("input").val()
		
		location.href = "<%=request.getContextPath()%>/modi.co?fid="+fid; 
				});

</script>

<script> //faq 삭제하기
	$(document).on('click', ".panel .uibutton3", function() {
		var fid = $(this).parent().find("input").val();
	
		
		location.href = "<%=request.getContextPath()%>/del.fd?fid="+fid; 
				});

</script>

<script> //1:1문의 보내는 펑션
 function insertObo(){
	 location.href="views/FAQ/Onebyone.jsp"
 }
</script>

<script>	//faq 추가 평션
	function insertFaq(){
		location.href="views/FAQ/FaqInsert.jsp"
	}
</script>


</body>
</html>