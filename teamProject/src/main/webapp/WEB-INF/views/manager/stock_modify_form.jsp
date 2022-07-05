<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/include/manager_header.jsp"%>      


<div class="container-fluid px-4">
	<div class="row">
		<div class="col-md-7">
		
		
		<h2>제품 수정</h2>
		<form role="form" action="stockCreation" method="get">
		<table class="table">
				<tr>
					<td><label for="product_id">제품 아이디(PRODUCT_ID)</label><td>
					<td><input type="text" class="form-control" 
						id="product_id" name="product_id" value="${productVo.product_id}"
						 style="width:100%;"><td>
				</tr>
				<tr>
					<td><label>제품 이름(PRODUCT_NAME)</label><td>
					<td><input type="text" class="form-control" value="${productVo.product_name}"
						id="product_name" name="product_name"><td>
				</tr>
			
				<tr>
					<td><label>제품 가격(PRODUCT_PRICE)</label><td>
					<td><input type="text" class="form-control" value="${productVo.product_price}"
						id="product_price" name="product_price"><td>
				</tr>
			
				<tr>
					<td><label>제품 수량(PRODUCT_STOCK)</label><td>
					<td><input type="text" class="form-control" value="${productVo.product_stock}"
						id="product_stock" name="product_stock"><td>
				</tr>
		
				<tr>
					<td><label>제품 용량(PRODUCT_CAPACITY)</label><td>
					<td><input type="text" class="form-control" value="${productVo.product_capacity}"
						id="product_capacity" name="product_capacity"><td>
				</tr>
			
				<tr>
					<td><label>제품 도수(PRODUCT_ALCOHOL_DEGREE)</label><td>
					<td><input type="text" class="form-control" value="${productVo.product_alcohol_degree}"
						id="product_alcohol_degree" name="product_alcohol_degree"><td>
				</tr>
		
				<tr>
					<td><label>제품 유효기간(PRODUCT_EXPIRATION_DATE)</label><td>
					<td><input type="text" class="form-control" value="${productVo.product_expiration_date}"
						id="product_expiration_date" name="product_expiration_date"><td>
				</tr>
			
				<tr>
					<td><label>제품 원산지(PRODUCT_ORIGIN)</label><td>
					<td><input type="text" class="form-control" value="${productVo.product_origin}"
						id="product_origin" name="product_origin"><td>
				</tr>
			
				<tr>
					<td><label>제품 이미지(PRODUCT_IMAGE)</label><td>
					<td><input type="text" class="form-control" value="${productVo.product_image}"
						id="product_image" name="product_image"><td>
				</tr>
			
				<tr>
					<td><label>제품 설명(PRODUCT_DESCRIPT)</label><td>
					<td><input type="text" class="form-control" value="${productVo.product_descript}"
						id="product_descript" name="product_descript"><td>
				</tr>
			
				<tr>
					<td><label>제품 할인가(PRODUCT_DISCOUNT)</label><td>
					<td><input type="text" class="form-control" value="${productVo.product_discount}"
						id="product_discount" name="product_discount"><td>
				</tr>
			
				<tr>
					<td><label>제품 카테고리(CATE_CODE)</label><td>
					<td><input type="text" class="form-control" value="${productVo.cate_code}"
						id="cate_code" name="cate_code"><td>
				</tr>
			
				<tr>
					<td><label>제품 한국 이름(PRODUCT_KOR_NAME)</label><td>
					<td><input type="text" class="form-control" value="${productVo.product_kor_name}"
						id="product_kor_name" name="product_kor_name"><td>
				</tr>
			
				<tr>
					<td colspan="2"><button type="submit" class="btn btn-primary"
							>수정</button></td>
					
				</tr>
			</table>
			</form>	
			
		</div> <!-- col-md-12 -->
		<div class="col-md-5"></div>
	</div>
</div>


<%@ include file="/WEB-INF/views/include/manager_footer.jsp"%>      