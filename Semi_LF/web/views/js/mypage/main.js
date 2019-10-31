$(function() {
	increaseNumber(); // 숫자 증가 시켜주기
	
	bindLink();
	
	flagAlert();
	
	deleteBasket();
});


function increaseNumber() {
	$('.number').each(function() {
		var $this = $(this), countTo = $this.attr('data-count');

		$({
			countNum : $this.text()
		}).animate({
			countNum : countTo
		},

		{
			duration : 1500,
			easing : 'linear',
			step : function() {
				if($this.hasClass("comma")){
					$this.text(Math.floor(this.countNum).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
				} else {
					$this.text(Math.floor(this.countNum));
				}
			},
			complete : function() {
				if($this.hasClass("comma")) {
					$this.text(this.countNum.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
				} else {
					$this.text(this.countNum);
				}
				// alert('finished');
			}

		});

	});
	
}




function bindLink() {
	$(".infoArea ul li").on("click", function() {
		$class = $(this).attr("class");
		
		location.href = "./my"+$class+".bo";
	});
}

/* 추가 */
function deleteBasket() {
	$(".cartListArea .deleteBtn").on("click", function() {
		var basketId = $(this).attr("data-bId");
		location.href = "./myBasketMainDelete.bo?basketId="+basketId;
	});
}
/* 추가 */


/* 수정 */
function flagAlert() {
	if($(".flag").val() == 1) {
		swal("회원정보수정이 완료되었습니다.", "", "success");
	} else if($(".flag").val() == 2) {
		swal("장바구니 삭제가 완료되었습니다.", "", "success");
	}
}
/* 수정 */


