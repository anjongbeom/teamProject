<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="/WEB-INF/views/include/header.jsp"%>

<!-- 이상없음 -->

loginVo :  ${loginVo}<br>



cartList: ${cartList }


<!-- 			<div class="col-lg-12"> -->
<!-- 				<div class="mb-4"> -->
		
<!-- 					<h2 class="card-title">장바구니</h2> -->
<!-- 					<div style="margin-left: 10px;" class="small text-muted">VAT 별도</div> -->
		
<!-- 					<table class="table table-sm"> -->
		
<!-- 						<thead> -->
<!-- 							<tr> -->
<!-- 								<th scope="row" width="5%"></th> -->
<!-- 								<th scope="row" colspan="1" width="20%" style="text-align: center">상품정보</th> -->
<!-- 								<th scope="row" colspan="1" width="20%" style="text-align: center">상품이름</th> -->
<!-- 								<th scope="row"  width="20%" style="text-align: center">판매자</th> -->
<!-- 								<th scope="row"  width="8%" style="text-align: center">수량</th> -->
<!-- 								<th scope="row"  width="7%" style="text-align: center">적립</th> -->
<!-- 								<th scope="row"  width="30%" style="text-align: center">상품금액</th> -->
<!-- 							</tr> -->
<!-- 						</thead> -->
						
<!-- 						<tbody class="table-group-divider"> -->
<!-- 							<tr> -->
<!-- 								<td style="vertical-align:middle"><input type="checkbox"  -->
<!-- 								name="item" value="productVo" checked></td> -->
<!-- 								<td> -->
<%-- 									<img class="card-img-top" src="/product/displayImage?filename=${productVo.product_image}"   --%>
<!-- 									alt="..." style="display:block; margin:auto; width: 122px; height: 182px;" /> -->
<!-- 								</td> -->
								
<%-- 								<td style="vertical-align:middle; text-align: center;">${productVo.product_name}</td> --%>
<!-- 								<td style="vertical-align:middle; text-align: center;">KA 주류교육원</td> -->
<%-- 								<td style="vertical-align:middle; text-align: center;">${param.amount} 개</td> --%>
<%-- 								<td style="vertical-align:middle; text-align: center;">${Math.floor(param.totalPrice*0.05)}Point</td> --%>
<!-- 								<td style="vertical-align:middle; text-align: center; font-size: 15px; color: #CF492C;"  -->
<%-- 									>${param.totalPrice} Point</td> --%>
<!-- 							</tr> -->
<!-- 						</tbody> -->
<!-- 					</table> -->
					
<!-- 					<br>  -->
<!-- 					<br>  -->
<!-- 					<a -->
<!-- 						style="float: right; margin-right: 10px;" class="btn btn-primary" -->
<!-- 						href="/product/purchase">구매하기 -->
<!-- 					</a> -->
					
<!-- 				</div> -->
<!-- 			</div> -->

<%@ include file="/WEB-INF/views/include/footer.jsp"%>
