<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="/WEB-INF/views/include/header.jsp"%>

<!-- jquery 인식 안돼서 따로 가져옴 -->
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>

	<!-- Responsive navbar-->
	
	<!-- Page header with logo and tagline-->
	<header class="py-5 bg-light border-bottom mb-4">
		<div class="container">
			<div class="text-center my-5">
				<h1 class="fw-bolder"></h1>
			</div>
		</div>
	</header>
	
	<%-- ${productVo} --%>
	
	<!-- Page content-->
	<div class="container">
		<div class="row">
<!-- 			Blog entries -->
<!-- 			<div class="col-lg-6"> -->
<!-- 				Featured blog post -->
<!-- 				<div class="card mb-4"> -->
<!-- 					<a href="#!"> -->
<%-- 					<img class="card-img-top" src="/product/displayImage?filename=${productVo.product_image}"  --%>
<!-- 					alt="..." style="display:block; margin:auto; width: 282px; height: 382px;" /> -->
<!-- 					</a> -->
<!-- 				</div> -->
<!-- 			</div> -->
			
			<!-- Side widgets-->
			<div class="col-lg-12">
				<!-- Side widget-->
				<div class="mb-4">
		
					<!--  <div class="card-header">Side Widget</div> -->
					<h2 class="card-title">주문/결제</h2>
					<div style="margin-left: 10px;" class="small text-muted">VAT 별도</div>
		
					<table class="table table-sm">
	<%-- 					<colgroup> --%>
	<%-- 					<col style="width:85%"> --%>
	<%-- 					<col style="width:15%"> --%>
	<%-- 					</colgroup> --%>
		
						<thead>
							<tr>
								<th scope="row" colspan="2" width="30%">상품정보</th>
								<th scope="row"  width="20%">판매자</th>
								<th scope="row"  width="20%">수량</th>
								<th scope="row"  width="30%">상품금액</th>
							</tr>
						</thead>
						
							
						<tbody class="table-group-divider">
							<tr>
								<td>
									<img class="card-img-top" src="/product/displayImage?filename=${productVo.product_image}"  
									alt="..." style="display:block; margin:auto; width: 82px; height: 182px;" />
								</td>
								
								<td>${productVo.product_name}</td>
								<td>KA 주류교육원</td>
								<td>수량 개</td>
								<td style="font-size: 30px; color: #CF492C;">상품금액 Point</td>
							</tr>
						</tbody>
					</table>
					
					<br> 
					<br> 
					
					<a
						style="float: right; margin-right: 10px;" class="btn btn-primary"
						href="/product/purchase">구매하기
					</a>
					
				</div>
			</div>
		
			<div class="content">
				<span style="font-size: 25px; color: #433406;"> 배송지</span>
				<!--${content}-->
			</div>
			
			
		</div> <!-- <div class="row">  -->
	</div> <!-- // Container -->


<%@ include file="/WEB-INF/views/include/footer.jsp"%>
