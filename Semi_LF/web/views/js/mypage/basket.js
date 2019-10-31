$(function() {
	$(".mypageMenu li:nth-child(3)").addClass("active");
	
	checkboxEvent();
	
	numberBtnEvent();
	
	alertFlag();
	
	allDeleteBtn();
});

function checkboxEvent() {
	$(".allCheck").change(function() {
		if($(this).is(":checked")) {
			$(".selCheck").prop("checked", true);
		} else {
			$(".selCheck").prop("checked", false);
		}
	});
}

function numberBtnEvent() {
	
	$(".amountBtn").on("click", function() {
		
		var price = $(this).attr("data-price");
		
		if($(this).hasClass("plusBtn")) {
			$(this).siblings(".amount").val(Number($(this).siblings(".amount").val())+1);
			var amount = $(this).siblings(".amount").val();
			$(this).closest("td").siblings(".listTotalPrice").text(price*amount);
			
		} else {
			if(Number($(this).siblings(".amount").val()) < 2) {
				swal("최소개수는 1개입니다.", "", "warning");
			} else {
				$(this).siblings(".amount").val(Number($(this).siblings(".amount").val())-1);
				var amount = $(this).siblings(".amount").val();
				$(this).closest("td").siblings(".listTotalPrice").text(price*amount);
			}
		}
	});
}

function validateSubmit() {
	if($(".selCheck:checked").length < 1) {
		swal("삭제할 품목을 한가지 이상 선택하세요.", "", "warning");
		return false;
	}
}

function allDeleteBtn() {
	$(".allDltBtn").on("click", function() {
		$(".selCheck").prop("checked", true);
		$(".basketDltForm .deleteType").val("all");
		
		$(".basketDltForm").submit();
	});
}

function alertFlag() {
	var type = $(".flag").val();
	
	if(type == 'select') {
		swal("선택한 품목이 삭제되었습니다.", "", "success");
	} else if(type == 'all' ) {
		swal("전체 품목이 삭제되었습니다.", "", "success");
	}
}
