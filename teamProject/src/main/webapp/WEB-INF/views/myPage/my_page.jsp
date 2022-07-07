<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="/WEB-INF/views/include/header.jsp"%>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<%@ include file="/WEB-INF/views/include/manager_paging.jsp"%>

<style>

th {
	
	justify-content:center;
	align-items:center;
	text-align: center;
	line-height: middle;
	vertical-align: middle;
}


td {
	
	justify-content:center;
	align-items:center;
	text-align: center;
	line-height: middle;
	vertical-align: middle;
}


</style>

<script>
$(document).ready(function() {
	
	// 주문 목록 얻기
	function getOrderedList(){
		var loginVo_member_id = "${loginVo.member_id}";
		
		var url = "/myPage/getOrderedDetailList/";
		$.get(url, function(rData){
			$("#table_ordered_list tr:gt(0)").remove(); //
			$.each(rData, function(){
				var tr = $("#table_clone tr").clone();
				var tds = tr.find("td");
				tds.eq(0).text(this.order_detail_no);
				tds.eq(1).text(this.order_date);
// 				tds.eq(2).text(this.product_image);
				tds.eq(2).html
				('<img src="/product/displayImage?filename=' + this.product_image 
					+ '" alt="..." style="display: block; margin: auto; width: 122px; height: 182px;">');
				tds.eq(3).text(this.product_kor_name);
				tds.eq(4).text(this.order_product_amount);
				tds.eq(5).text(this.order_detail_status_descript);
				
				tds.find(".btnRequestReturn").attr("data-odn", this.order_detail_no);
				
				if (this.order_detail_status_descript == '반품요청') {
					
				} else {
					console.log("this.order_detail_status_descript" , this.order_detail_status_descript);
// 					tds.find(".btnRequestReturn").attr("disabled", "disabled");
				}
				
				$("#table_ordered_list").append(tr);
			});
		});
	}
	
	// 반품 신청 버튼
	$("#table_ordered_list").on("click", ".btnRequestReturn", function(){
		var that = $(this);
		var tr = $(this).parents("tr");
		var td = tr.find("td").eq(1);
		var input = td.find("input");
		var content = input.val();
		var odn = $(this).attr("data-odn");
		console.log("content:",content);
		var sData = {
				"order_detail_no"	  : odn
		};
		console.log("sData",sData)
		var url = "/myPage/requestReturn";
		$.post(url, sData, function(rData){
			console.log(rData);
			if (rData == "true"){
 				alert("반품 신청 완료");
 				var thatText = that.parent().prev().text();
 				alert("thatText: ", thatText);
//  				that.prop("disabled", true);
				getOrderedList();
			}
		})
	});
	
	getOrderedList();
	
});
</script>

<!-- Page content-->
<div class="container">
	<div class="row">

		<!-- Side widgets-->
		<div class="col-lg-12">
			<!-- Side widget-->
			<div class="mb-4">

				<form action="#" method="get" id="frm_my_page">
					<!--  <div class="card-header">Side Widget</div> -->
					<h2 class="card-title">주문한 품목</h2>
					<div style="margin-left: 10px;" class="small text-muted"></div>

					<!-- 클론 테이블 -->
					<div class="row" style="margin-top: 30px;">
					<div class="col-md-12" >
						<table style="display: none;" id="table_clone">
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>
									<button type="button" 
									class="btn btn-sm btn-danger btnRequestReturn">반품</button>
								</td>
							</tr>
						</table>
						<table class="table" id="table_ordered_list">
						
							<tr>
								<th>상세 주문 번호</th>
								<th>주문 날짜</th>
								<th>상품 이미지</th>
								<th>상품명</th>
								<th>주문 수량</th>
								<th>주문 상태</th>
								<th>반품 신청</th>
							</tr>
						</table>
					</div>
				</div>

				<!-- // 클론 테이블 -->
				</form>

				<br> <br>

			</div>
		</div>


	</div>
	<!-- <div class="row">  -->
</div>
<!-- // Container -->


<%@ include file="/WEB-INF/views/include/footer.jsp"%>
