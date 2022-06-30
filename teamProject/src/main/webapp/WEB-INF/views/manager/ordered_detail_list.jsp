<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="/WEB-INF/views/include/manager_header.jsp"%>

<!-- jquery 인식 안돼서 따로 가져옴 -->
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>

<%@ include file="/WEB-INF/views/include/manager_paging.jsp" %>


	
	<!-- Page content-->
	<div class="container">
		<div class="row">

			<!-- Side widgets-->
			<div class="col-lg-12">
				<!-- Side widget-->
				<div class="mb-4">
		
				<form action="/manager/orderApproval">
					<!--  <div class="card-header">Side Widget</div> -->
					<h2 class="card-title">요청 주문별  품목</h2>
					<div style="margin-left: 10px;" class="small text-muted"></div>
					<a href="/manager/orderedList" class="btn btn-success">목록으로 이동</a>
		
					<table class="table table-sm">
						<thead>
							<tr>
								<th scope="row" width="5%"></th>
								<th scope="row" colspan="1" width="10%" style="text-align: center">상세 주문 번호</th>
								<th scope="row" colspan="1" width="20%" style="text-align: center">상품 이미지</th>
								<th scope="row"  width="20%" style="text-align: center">상품명</th>
								<th scope="row"  width="10%" style="text-align: center">주문 수량</th>
								<th scope="row"  width="20%" style="text-align: center">주문자 아이디</th>
								<th scope="row"  width="20%" style="text-align: center">주문 상태</th>
							</tr>
						</thead>
						
						<tbody class="table-group-divider">
						<c:forEach items="${sessionScope.ordered_detail_List}" var="orderedDto">
							<tr>
						
								<td style="vertical-align:middle">
									<input type="checkbox" name="checked_list" value="${orderedDto.order_detail_no}" 
										data-order_detail_no="${orderedDto.order_detail_no}" checked></td>
								<td style="vertical-align:middle; text-align: center;">${orderedDto.order_detail_no}</td>
								<td>
									<img class="card-img-top" src="/product/displayImage?filename=${orderedDto.product_image}"  
									alt="..." style="display:block; margin:auto; width: 122px; height: 182px;" />
								</td>
								<td style="vertical-align:middle; text-align: center;">${orderedDto.product_kor_name}</td>
								<td style="vertical-align:middle; text-align: center;">${orderedDto.order_product_amount}</td>
								<td style="vertical-align:middle; text-align: center;">${orderedDto.member_id}</td>
								<td style="vertical-align:middle; text-align: center; font-size: 15px; color: #CF492C;" 
																					>${orderedDto.order_detail_status_descript}</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
					
					<button type="submit" style="float: right; margin-right: 10px;" 
						class="btn btn-primary">체크된 항목 승인</button>
					
				</form>
					
				<br> 
				<br> 
					
				</div>
			</div>
		
			
		</div> <!-- <div class="row">  -->
	</div> <!-- // Container -->


<%@ include file="/WEB-INF/views/include/manager_footer.jsp"%>
