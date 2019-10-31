$(function() {
   $(".mypageMenu li:nth-child(4)").addClass("active");
   pageBtnEvent();
   reviewModal();
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
   
   $(".reviewListContent").on("click", function() {
      modal.style.display = "block";
      
      var reid = $(this).attr("data-reid");
      $(".modalDeleteBtn").attr("data-reid", reid);
      $(".modal-content .reid").val(reid);
      
      var pName = $(this).find(".pName").text();
      $(".modal-pname").text(pName);
      
      var reContent = $(this).find(".reContent").text();
      $(".modal-content .reContent").text(reContent);
      
      
      grade = $(this).attr("data-grade");
      $(".modalTitleArea .starArea").attr("data-grade", grade);
      $(".starArea .starPoint").not(".always").removeClass("on");
      
      setStarPoint(grade);
      
   });

   
   $(".modal-content .close").on("click", function() {
      modal.style.display = "none";
      $(".modalCancelBtn").trigger("click");
   });

   window.onclick = function(event) {
      if (event.target == modal) {
         modal.style.display = "none";
         $(".modalCancelBtn").trigger("click");
      }
   }
   
   $(".modalDeleteBtn").on("click", function() {
      var reid = $(this).attr("data-reid");
          var currentPage = $(".currentPage").val();
      
      swal({
            title: "정말 삭제하시겠습니까?",
            /*text: "You will not be able to recover this imaginary file!",*/
            icon: "warning",
            buttons: [
              '아니오',
              '예'
            ],
            dangerMode: true,
          }).then(function(isConfirm) {
            if (isConfirm) {
               location.href = "./myReviewDelete.bo?reid="+reid+"&currentPage="+currentPage;
            }
          })
   });
   
   // 수정하기 버튼 클릭
   $(".modalModifyBtn").on("click", function() {
      // 수정폼, 수정완료버튼, 취소 버튼 보여주기
      $(".reviewContent .reContentModify, .modalModifyProBtn, .modalCancelBtn").show();
      
      // 기존 리뷰내용, 수정버튼, 삭제버튼 hide
      $(".reviewContent .reContent, .modalModifyBtn, .modalDeleteBtn").hide();
      
      // 기존 내용을 가져와 textarea 에 값 넣어주기
      var reContent = $(".modal-content .reviewContent .reContent").text();
      $(".reContentModify").val(reContent);
      
      $(".starArea .starPoint").addClass("modify");
      
      $(".starArea .starPoint").click(function() {
         
         if($(this).hasClass("modify")) {
            $(this).parent().children("li").removeClass("on");
            $(this).addClass("on").prevAll("li").addClass("on");
         }
         return false;
      });
      
   });
   
   // 수정-취소 버튼 클릭
   $(".modalCancelBtn").on("click", function() {
      // 수정폼, 수정완료버튼, 취소 버튼 hide
      $(".reviewContent .reContentModify, .modalModifyProBtn, .modalCancelBtn").hide();
      
      // 기존 리뷰내용, 수정버튼, 삭제버튼 show
      $(".reContent, .modalModifyBtn, .modalDeleteBtn").show();
      
      $(".starArea .starPoint").removeClass("modify");
      
      var grade = $(".modalTitleArea .starArea").attr("data-grade");
      console.log("grade :: " + grade);
      setStarPoint(grade);
      
   });
   
}


function setStarPoint(grade) {
   
   $(".starPoint:not(.always)").removeClass("on");
   
   $(".starArea .starPoint").each(function(index, item) {
      if(grade == index) {
         return false;
      } else {
         $(item).addClass("on");
      }
   });
}

function modifyReview() {
   
   if($.trim($(".reContentModify").val()).length < 1) {
      swal("리뷰내용을 입력해주세요", "", "warning");
      return false;
   } else {
      var grade = $(".starPoint.on").length;
      
      console.log("grade : " + grade);
      
      $(".review_grade").val(grade);
      return true;
   }
}


function alertFlag() {
   var type = $(".reviewType").val();
   
   if(type == 'modify') {
      swal("리뷰 수정이 완료되었습니다.", "", "success");
   } else if(type == 'delete') {
      swal("리뷰 삭제가 완료되었습니다.", "", "success");
   }
}