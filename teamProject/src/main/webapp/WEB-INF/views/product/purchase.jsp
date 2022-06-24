<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="/WEB-INF/views/include/header.jsp"%>

<!-- jquery 인식 안돼서 따로 가져옴 -->
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>

	<!-- Responsive navbar-->
<script>
$(document).ready(function() {


//	구매 버튼에도 이정보 넘겨줄것
$("#selectpurchase_btn").click(function(e) {
	e.preventDefault();
 	var product_id = "${productVo.product_id}";
 	var product_count = "${param.amount}" ;


	// AJAX로 장바구니 추가에 필요한 데이터 넘겨주기
	var sData = {
			"product_id"	: product_id,
			"product_count": product_count
	};
	console.log(sData);
	var url = "/product/sellProduct";
	$.get(url, sData, function(rData) {
//			console.log(rData);
		if (rData == "true") {
			alert("성공");
		}
	});
});

});
</script>
member_id : ${loginVo.member_id}
param.amount: ${param.amount}
	<!-- Page header with logo and tagline-->
	<header class="py-5 bg-light border-bottom mb-4">
		<div class="container">
			<div class="text-center my-5">
				<h1 class="fw-bolder"></h1>
			</div>
		</div>
	</header>
	
<%-- 	${productVo} --%>
<%-- 	${productVo.product_id} --%>
<%-- 	${amount} --%>
<%-- 	${param.amount} --%>
	
	
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
								<th scope="row" width="5%"></th>
								<th scope="row" colspan="1" width="20%" style="text-align: center">상품정보</th>
								<th scope="row" colspan="1" width="20%" style="text-align: center">상품이름</th>
								<th scope="row"  width="20%" style="text-align: center">판매자</th>
								<th scope="row"  width="8%" style="text-align: center">수량</th>
								<th scope="row"  width="7%" style="text-align: center">적립</th>
								<th scope="row"  width="30%" style="text-align: center">상품금액</th>
							</tr>
						</thead>
						
							
						<tbody class="table-group-divider">
							<tr>
								<td style="vertical-align:middle"><input type="checkbox" 
								name="chk" value="productVo" data-product_id="${productVo.product_id}" checked></td>
								<td>
									<img class="card-img-top" src="/product/displayImage?filename=${productVo.product_image}"  
									alt="..." style="display:block; margin:auto; width: 122px; height: 182px;" />
								</td>
								
								<td style="vertical-align:middle; text-align: center;">${productVo.product_kor_name}</td>
								<td style="vertical-align:middle; text-align: center;">KA 주류교육원</td>
								<td style="vertical-align:middle; text-align: center;">${param.amount} 개</td>
								<td style="vertical-align:middle; text-align: center;">${Math.floor(param.totalPrice*0.05)}Point</td>
								<td style="vertical-align:middle; text-align: center; font-size: 15px; color: #CF492C;" 
									>${param.totalPrice} Point</td>
							</tr>
						</tbody>
					</table>
					
					<br> 
					<br> 
					
					<a
						style="float: right; margin-right: 10px;" id="selectpurchase_btn" 
						class="btn btn-primary"
						href="/product/purchase">구매하기
					</a>
					
				</div>
			</div>
		
			
		</div> <!-- <div class="row">  -->
	</div> <!-- // Container -->


<%@ include file="/WEB-INF/views/include/footer.jsp"%>
