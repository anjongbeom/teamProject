<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="/WEB-INF/views/include/header.jsp"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script>
$(document).ready(function() {
	$("#cbx_chkAll").click(function() {
		if($("#cbx_chkAll").is(":checked")) $("input[name=chk]").prop("checked", true);
		else $("input[name=chk]").prop("checked", false);
	});
	
	$("input[name=chk]").click(function() {
		var total = $("input[name=chk]").length;
		var checked = $("input[name=chk]:checked").length;
		
		if(total != checked) $("#cbx_chkAll").prop("checked", false);
		else $("#cbx_chkAll").prop("checked", true); 
	});


$("#selectDelete_btn").click(function(){
 var confirm_val = confirm("정말 삭제하시겠습니까?");
 
 if(confirm_val) {
  var checkArr = new Array();
  
  $("input[name='chk']:checked").each(function(){
   checkArr.push($(this).attr("data-cart_id"));
  });
   
  $.ajax({
   url : "/cart/deleteCart",
   type : "post",
   data : { chk : checkArr },
   success : function(result){
	   if(result == 1){
		   location.href = "/cart/orderList";
	   } else {
		   alert("삭제 실패")
	   }
    
   }
  });
 } 
});
});
</script>

			<div class="col-lg-12">
				<div class="mb-4">
					<h2 class="card-title" style="text-align: center; margin-top: 40px;">장바구니</h2>
					
					
				
		<div class="row">
			<div class="col-md-1">
			</div>
				<div class="col-md-10">
					<div class="small text-muted">VAT 별도</div>
					<div class="delete"><button type="button"  id="selectDelete_btn"
						class="btn btn-warning delete_btn" style="float: right; margin-right: 10px; margin-bottom: 20px;"
					 	data-cart_id="${CartDto.cart_id}">선택삭제</button></div>
					<table class="table table-sm">
		
						<thead>
							<tr>
								<th scope="row" width="10%">
								<input type="checkbox" id="cbx_chkAll"
								name="item" value="productVo">전체선택</th>
								<th scope="row" colspan="1" width="20%" style="text-align: center">상품정보</th>
								<th scope="row" colspan="1" width="20%" style="text-align: center">상품이름</th>
								<th scope="row"  width="20%" style="text-align: center">판매자</th>
								<th scope="row"  width="8%" style="text-align: center">수량</th>
								<th scope="row"  width="7%" style="text-align: center">적립</th>
								<th scope="row"  width="30%" style="text-align: center">상품금액</th>
							</tr>
								
						</thead>
					
		
						<tbody class="table-group-divider">
						<!-- 		흥건히 젖었다			foreach 쓸것 -->
						<c:forEach items="${orderList}" var="CartDto" varStatus="status">
							<tr>
								<td style="vertical-align:middle; text-align: center;"><input type="checkbox"
								name="chk" value="productVo" data-cart_id="${CartDto.cart_id}"></td>
								<td>
									<img class="card-img-top" src="/product/displayImage?filename=${CartDto.product_image}"  
									alt="..." style="display:block; margin:auto; width: 122px; height: 182px;" />
								</td>
<!-- 								Math.floor(param.totalPrice*0.05) -->
								<td style="vertical-align:middle; text-align: center;">${CartDto.product_kor_name} </td>
								<td style="vertical-align:middle; text-align: center;">KA 주류교육원</td>
								<td style="vertical-align:middle; text-align: center;">${CartDto.product_amount} 개</td>
								<td style="vertical-align:middle; text-align: center;">Point</td>
								<td style="vertical-align:middle; text-align: center; font-size: 15px; color: #CF492C;" 
									>${CartDto.total_price} Point</td>
								 
							</tr>
						</c:forEach>
					<!-- 					foreach 쓸것 -->
						</tbody>
					</table>
			<div class="col-md-1">
				</div>
		</div>	
					
					
					
					
							<div class="col-md-12">
								<div class="row">
									<div class="col-md-2">
									</div>
									<div class="col-md-8">
										<table class="table table-bordered">
											<tbody>
												<tr>
													<td style="text-align: center;">
														총 적립금액 :
													</td>
													<td style="text-align: center;">
														${totalSummary.sum_point_earned}Point
													</td>
												</tr>
												<tr>
													<td style="text-align: center;">
														총 개수 :
													</td>
													<td style="text-align: center;">
														${totalSummary.sum_product_amount} 개
													</td>
												</tr>
												<tr>
													<td style="text-align: center;">
														총 합계 포인트
													</td>
													<td style="text-align: center;">
														${totalSummary.sum_total_price}Point
													</td>
													</tr>
											</tbody>
										</table>
									</div>
									<div class="col-md-2">
									</div>
								</div>
							</div>
						
					
							<div class="row">
								<div class="col-md-12 ">
<!-- 					구매하기 할때 정보를 넘기는데 넘겨야할 정보는  -->
					<a style="float:right; margin-right:30px;" class="btn btn-primary text-align-right"
						href="/product/purchase">구매하기
					</a>
					</div>
					</div>
				</div>
			</div>
		</div>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
