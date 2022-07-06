<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="/WEB-INF/views/include/header.jsp"%>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<%@ include file="/WEB-INF/views/include/manager_paging.jsp" %>


<script>
$(document).ready(function() {
	var frmApproval = $("#frmApproval");
	$("#submitConfirm").click(function(e){
		e.preventDefault();
		alert("주문 요청이 승인되었습니다.");
		frmApproval.submit();
	});
	
	
	$("#btn_return").click(function() {
		
	});
	
	
});
</script>
	
	<!-- Page content-->
	<div class="container">
		<div class="row">

			<!-- Side widgets-->
			<div class="col-lg-12">
				<!-- Side widget-->
				<div class="mb-4">
		
				<form action="/manager/orderApproval" method="get" id="frmApproval">
					<!--  <div class="card-header">Side Widget</div> -->
					<h2 class="card-title">주문한 품목</h2>
					<div style="margin-left: 10px;" class="small text-muted"></div>
<!-- 					<a href="/manager/orderedList" class="btn btn-success">목록으로 이동</a> -->
		
					<table class="table table-sm">
						<thead>
							<tr>
								<th scope="row" width="5%"></th>
								<th scope="row" colspan="1" width="10%" style="text-align: center">상세 주문 번호</th>
								<th scope="row" colspan="1" width="10%" style="text-align: center">주문 날짜</th>
								<th scope="row" colspan="1" width="15%" style="text-align: center">상품 이미지</th>
								<th scope="row" width="20%" style="text-align: center">상품명</th>
								<th scope="row" width="10%" style="text-align: center">주문 수량</th>
<!-- 								<th scope="row" width="20%" style="text-align: center">주문자 아이디</th> -->
								<th scope="row" width="20%" style="text-align: center">주문 상태</th>
								<th scope="row" width="15%" style="text-align: center">반품  신청</th>
								
							</tr>
						</thead>
						
						<tbody class="table-group-divider">
						<c:forEach items="${sessionScope.my_ordered_detail_List}" var="orderedDto">
							<tr>
						
								<td style="vertical-align:middle">
									<input type="checkbox" name="checked_list" value="${orderedDto.order_detail_no}" 
										data-order_detail_no="${orderedDto.order_detail_no}" checked></td>
								<td style="vertical-align:middle; text-align: center;">${orderedDto.order_detail_no}</td>
								<td style="vertical-align:middle; text-align: center;">${orderedDto.order_date}</td>
								
								
								<td>
									<img class="card-img-top" src="/product/displayImage?filename=${orderedDto.product_image}"  
									alt="..." style="display:block; margin:auto; width: 122px; height: 182px;" />
								</td>
								<td style="vertical-align:middle; text-align: center;">${orderedDto.product_kor_name}</td>
								<td style="vertical-align:middle; text-align: center;">${orderedDto.order_product_amount}</td>
<%-- 								<td style="vertical-align:middle; text-align: center;">${orderedDto.member_id}</td> --%>
								<td style="vertical-align:middle; text-align: center; font-size: 15px; color: #CF492C;" 
																					>${orderedDto.order_detail_status_descript}</td>
								<td style="vertical-align: middle;">
									<div>
										<button type="button" id="btn_return" 
										 class="btn btn-danger"  
										data-oid="${orderedDto.order_detail_no}">반품 신청</button>
									</div>
									
								</td>
																													
							</tr>
						</c:forEach>
						</tbody>
					</table>
					
<!-- 					<button type="button" style="float: right; margin-right: 10px;" id="submitConfirm" -->
<!-- 						class="btn btn-primary">체크된 항목 승인</button> -->
					
				</form>
					
				<br> 
				<br> 
					
				</div>
			</div>
		
			
		</div> <!-- <div class="row">  -->
	</div> <!-- // Container -->


<%@ include file="/WEB-INF/views/include/footer.jsp"%>