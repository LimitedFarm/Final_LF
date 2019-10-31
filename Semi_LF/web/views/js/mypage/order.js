$(function() {
   $(".mypageMenu li:nth-child(2)").addClass("active");

   pageBtnEvent();

   
   reviewModal();
   
   refundEvent();
   
   alertFlag();
});

function pageBtnEvent() {
   $(".pageNum").on("click", function() {
      if ($(this).hasClass("prevPage") && $(this).hasClass("false")) {
         swal("첫번째 페이지 입니다.", "", "warning");
      }

      if ($(this).hasClass("nextPage") && $(this).hasClass("false")) {
         swal("마지막 페이지 입니다.", "", "warning");
      }
   });
}

function reviewModal() {

   var modal = document.getElementById('myModal');

   $(".reviewBtn").on("click", function() {
      modal.style.display = "block";
      $(".starPoint:not(.always)").removeClass("on");
      
      $sId = $(this).attr("data-sId");
      var pName = $(this).parents().siblings("td").find(".pName").text();
      $(".modal-pname").text(pName);
      $(".review_sId").val($sId);
      
      $(".reContent").val("");
      
   });
   
   $(".modalCancelBtn").on("click", function() {
      modal.style.display = "none";
   });
   
   $(".modal-content .close").on("click", function() {
      modal.style.display = "none";
   });

   // When the user clicks anywhere outside of the modal, close it
   window.onclick = function(event) {
      if (event.target == modal) {
         modal.style.display = "none";
      }
   }

   $('.starPoint').click(function() {
      $(this).parent().children('li').removeClass('on');
      $(this).addClass('on').prevAll('li').addClass('on');
      return false;
   });
}


function insertReview() {
   if($.trim($(".reContent").val()).length < 1) {
      swal("리뷰내용을 작성해주세요.", "", "warning");
      return false;
   } else {
      var grade = $(".starPoint.on").length;
      
      console.log("grade : " + grade);
      
      $(".review_grade").val(grade);
      return true;
   }
   return false;
}

function refundEvent() {
   $(".refundBtn").on("click", function() {
      var sId = $(this).attr("data-sId");
      var currentPage = $(".currentPage").val();
      
      location.href="./myOrderRefund.bo?sId="+sId+"&type=refund&currentPage="+currentPage;
   });
}

function alertFlag() {
   var type = $(".flagType").val();
   
  console.log("type :: " + type);
   
   if(type == 'refund') {
	   swal("환불신청이 완료되었습니다.", "", "success");
   } else if(type == 'reviewInsert') {
	   swal("구매후기가 등록되었습니다.", "", "success");
   }
   
}