$(function() {
	buttonEvent();
});

function buttonEvent() {
	
	$(".mypageMenu li:nth-child(2)").addClass("active");
	
	$(".sendConfirmMail").on("click", function() {
		
		
		var data = {
			"email" : $(".emailText").val()
		};
		
		$.ajax({
			url:"./mySendMail.bo",
			type:"post",
			dataType: "json",
			data: data,
			success:function(data){
				var confirmNum = data;
				
				swal({
					text: '해당 이메일로 인증번호를 전송하였습니다.',
					icon: 'success'
				});
				
				$(".emailInput").show();
				$(".confirmBtn").show();
				
				$(".confirmBtn").on("click", function() {
					
					var inputNum = $(".emailInput").val();
					
					if(inputNum.length < 1) {
						swal("인증번호를 입력해주세요.", "", "warning");
						$(".emailInput").focus();
						return false;
					}
					
					if(confirmNum != inputNum) {
						swal({
							text: '인증번호가 틀렸습니다.',
							icon: 'warning'
						})
						return false;
					} else {
						swal({
							text: '인증되었습니다.',
							icon: 'success'
						}).then( function(ok) {
							if(ok) {
								location.href = "./myModify.bo";
							}
						});
					}
				});
			}
		});
	});
}

	