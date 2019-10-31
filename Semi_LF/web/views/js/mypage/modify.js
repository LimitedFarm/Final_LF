$(function() {
	$(".mypageMenu li:nth-child(1)").addClass("active");
	
});

function execDaumPostcode() {
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
            } 

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('address1').value = data.zonecode;
            document.getElementById("address2").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("address3").focus();
        }
    }).open();
}

// sweetalert (알림창 디자인) 중요함 잘 알아놓기
$(".deleteBtn").on("click", function(){
	swal({
		title: '취소하시겠습니까?',
		icon: 'warning',
		buttons: [true, "OK"]	
	}).then(function(willDelete){
		if(willDelete){
			location.href="./myConfirm.bo"
		}
	});
	
});


$('.modifyBtn').on( 'click', function() {
	// 각 검사
	var pwd = $('.pwd1').val();
	var pwd2 = $('.pwd2').val(); 
	var num = $('.num').val();
	var email = $('.mail').val();
	var address = $('.address1').val();
	var address3 = $('.address3').val();
	var address2 = $('.address2').val();
	
	
	if(num.length < 1) {
		warningSwal("전화번호를 입력하세요.");
		return false;
	} else if(email.length < 1) {
		warningSwal("이메일을 입력하세요.");
		email.focus();
		return false;
	} else if(address.length < 1){
		warningSwal("우편번호 찾기를 해주세요.");
		return false;
	} else if(address2.length < 1){
		warningSwal("우편번호 찾기를 해주세요.");
		return false;
	} else if(pwd.length < 1){
		warningSwal("비밀번호를 입력하세요.");
		return false;
	} else if(pwd2.length < 1){
		warningSwal("비밀번호 확인을 입력해주세요.");
		return false;
	} else if(pwd != pwd2) {
		warningSwal("비밀번호가 틀립니다.");
		return false;
	}
	
	
	/*if(pwd == '' || pwd == null ) {
		alert('비밀번호를 입력하세요');
		return false;
	}else if(num == '' || num == null){
		alert('전화번호를 입력하세요');
		return false;
	}else if(email == '' || email == null){
		alert('이메일을 입력하세요');
		return false;
	}else if(address == '' || address == null) {
		alert('주소를 입력하세요');
		return false;
	}else if(address3 == '' || address3 == null){
		alert("주소를 입력하세요");
		return false;
	}else if(address2 == '' || address2 == null){
		alert("상세주소를 입력하세요");
		return false;
	}else{
		modifyOk(pwd, address, address2, address3, num, email, 1);
	}*/
});

function warningSwal(message) {
	swal(message, "", "warning");
}


/*var modifyOk = function(pwd, address, address2, address3, phone, email, cid) {
	$.ajax({
		url: './modifyok.bo',
		type: "get",
		data:{
			pwd:pwd,
			address:address,
			address2:address2,
			address3:address3,
			phone:phone,
			email:email,
			cid:cid
		},
		dataType: 'JSON',
		success: function( json ) {
			results = json.results;
			
			$( results ).each( function() {
				var flag = this.flag;
				
				if( flag == 0 ) {
					// 성공
					alert('수정되었습니다.');
				} else {
					//실패
					alert('수정에 실패하였습니다.');
				}
			});
		}
	});
}
*/









