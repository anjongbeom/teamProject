<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="/WEB-INF/views/include/header.jsp"%>

<!-- jquery 인식 안돼서 따로 가져옴 -->
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>

<script>
$(document).ready(function() {
	
	//입력한 개수 표시용 span
	var amount_result = document.getElementById("amount_result");
	// 입력 개수 * 금액 표시용 span
	var total_count = document.getElementById("total_count");

	showPrice();
	
	$("#btn_plus").click(function() {
		var amount = Number(document.getElementById("amount").value);
		amount += 1;
		document.getElementById("amount").value = amount;
		showPrice();
	});
	
	$("#btn_minus").click(function() {
		var amount = Number(document.getElementById("amount").value);
		if (amount > 1) {
			amount -= 1;
		}
		document.getElementById("amount").value = amount;
		showPrice();

	});
	
	
// 	const form = {
// 			member_id : '${memberVo.member_id}',
// 			product_id : '${productVo.product_id}',
// 			product_count : ''
// 	};
	
	
// 	$("#btn_cart").on("click", function(e){
		
// 		form.product_count = $("#amount").val();
		
// 		$.ajax({
// 			url: '/cart/add',
// 			type: 'POST',
// 			data: form,
// 			success: function(result){
// 					 cartAlert(result);
// 			}
// 		});
// 	});
	
	/* 추후 삭제 */
// 	function cartAlert(result){
// 		if(result == '0'){
// 			alert("장바구니에 추가를 하지 못하였습니다.")
// 		} else if(result == '1'){
// 			alert("장바구니에 추가되었습니다.");
// 		} else if(result == '2'){
// 			alert("장바구니에 이미 추가되어져 있습니다.");
// 		} else if(result == '5'){
// 			alert("로그인이 필요합니다.");	
// 		}
// 	};
	
	
	$("#btn_purchase").click(function(e) {
	 	var amount = $("#amount").val();
	 	var price = ${productVo.product_price};
	 	var product_id = "${productVo.product_id}";
	 	
	 	location.href = "/product/purchase?product_id=" + product_id + "&amount=" + amount + "&totalPrice=" + (amount * price);
	});
	
	
	$("#btn_cart").click(function(e) {
		e.preventDefault();
		var loginVo = "${loginVo}";
// 		console.log("loginVo: ", loginVo);
		if(loginVo == null || loginVo == ""){
			console.log("loginVo: ", loginVo);
			window.location.href = "/member/loginForm";
		} else {
	// 		var login_id = "${loginVo.member_id}";
		 	var product_id = "${productVo.product_id}";
	// 	 	var price = ${productVo.product_price};
		 	var product_count = $("#amount").val();
	
			// AJAX로 장바구니 추가에 필요한 데이터 넘겨주기
			var sData = {
					"product_id"	: product_id,
					"product_count": product_count
			};
			console.log(sData);
			var url = "/cart/addCart";
			$.get(url, sData, function(rData) {
			// console.log(rData);
				if (rData == "true") {
					alert("장바구니에 물품이 담겼습니다.");
				}
			});
		}
	});
	
	
});

//개수 입력 input(number)
function showPrice() {
	var amount = document.getElementById("amount").value;
	var price = ${productVo.product_price};
	total_count.innerHTML = ": " + (amount * price);
	amount_result.innerHTML = ": " + (amount);
};


</script>
<%@ include file="/WEB-INF/views/include/order.jsp"%>


	<!-- Responsive navbar-->
	
	<!-- Page header with logo and tagline-->
	<header class="py-5 bg-light border-bottom mb-4">
		<div class="container">
			<div class="text-center my-5">
				<h1 class="fw-bolder"></h1>
			</div>
		</div>
	</header>
	
	<%--         ${productVo} --%>
	
	<!-- Page content-->
	<div class="container">
		<div class="row">
			<!-- Blog entries-->
			<div class="col-lg-6">
				<!-- Featured blog post-->
				<div class="card mb-4">
					<a href="#!">
						<img class="card-img-top"
							src="/product/displayImage?filename=${productVo.product_image}"
							alt="..." style="display: block; margin: auto; width: 282px; height: 382px;" />
					</a>
				</div>
			</div>
			
			<!-- Side widgets-->
			<div class="col-lg-6">
				<!-- Side widget-->
				<div class="mb-4">
	
					<!--  <div class="card-header">Side Widget</div> -->
					<h2 class="card-title">${productVo.product_kor_name}</h2>
					<div style="margin-left: 10px;" class="small text-muted">VAT 별도</div>
	
					<table class="table table-sm">
						<colgroup>
							<col style="width: 35%">
							<col style="width: 65%">
						</colgroup>
						<thead>
						</thead>
						<tbody class="table-group-divider">
							<tr><th scope="row">원산지</th>
								<td>${productVo.product_origin}</td>
							</tr>
							<tr><th scope="row">용량</th>
								<td>${productVo.product_capacity}ml</td>
							</tr>
							<tr><th scope="row">알콜도수</th>
								<td>${productVo.product_alcohol_degree}%</td>
							</tr>
							<tr><th scope="row">소비자가격</th>
								<td>.-Point</td>
							</tr>
							<tr><th scope="row" style="vertical-align: middle;">판매가격</th>
								<td style="font-size: 25px; color: #CF492C;">${productVo.product_price}
									Point
									</td>
							</tr>
							<tr><th scope="row" style="vertical-align: middle;">적립 포인트 :</th>
								<td style="font-size: 18px;
								 color: blue;">${Math.floor(productVo.product_price*0.2)}Point</td>
							</tr>
						</tbody>
					</table>
					
					<button class="btn btn-danger" id="btn_minus"
					 style="width:40px; display:block; float:left;">-</button>
					
					<input class="form-control" type="number" min='1' max='1000'
							style="width:80px; display:block; float:left;" placeholder="" value="1"
							id="amount" oninput="showPrice()">
						
					<button class="btn btn-primary" id="btn_plus" 
					style="width:40px; display:block; float:left;">+</button>
				
					<span id="amount_result" style="display:block; float:right;"></span>
					<span style="display:block; float:right;">구매 개수</span>
					<br>
					
					<span id="total_count" style="display:block; float:right;"></span>
					<span style="display:block; float:right;">총 금액</span>
					<br>
					
					
					<a id="btn_cart" style="float: right;" class="btn btn-danger"
							href="#">
						<span>장바구니에 담기</span>
					</a> 
					
					<a style="float: right; margin-right: 10px;" id="btn_purchase"
						class="btn btn-primary" href="#">구매하기			
						
<%-- 						/product/purchase?product_id=${productVo.product_id}&amount= --%>
					</a>
					
				</div>
			</div>
		</div>
		
		<div class="content">
			<span style="font-size: 25px;
			 color: #433406;">${productVo.product_descript}</span>
		</div>
	</div>
	




<%@ include file="/WEB-INF/views/include/footer.jsp"%>

