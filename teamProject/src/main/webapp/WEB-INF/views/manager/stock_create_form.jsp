<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<%@ include file="/WEB-INF/views/include/manager_header.jsp"%>      



<div class="container-fluid px-4">
	<div class="row">
		<div class="col-md-12">
		
		
		<h2>제품 등록</h2>
		<table class="form-control">
			<form role="form" action="stockCreation" method="get">
				<div class="form-group">
					<!--  -->
					<tr>
						<td><label for="product_id">제품 아이디(PRODUCT_ID)</label><td>
						<td><input type="text" class="form-control" id="product_id" name="product_id"
							 style="width:100%;"><td>
					</tr>
<!-- 				</div>	 -->
				<div class="form-group">
					<!--  -->
					<tr>
						<td><label>제품 이름(PRODUCT_NAME)</label><td>
						<td><input type="text" class="form-control" id="product_name" name="product_name"><td>
					</tr>
				</div>	
				<div class="form-group">	
					<!--  -->
					<tr>
						<td><label>제품 가격(PRODUCT_PRICE)</label><td>
						<td><input type="text" class="form-control" id="product_price" name="product_price""><td>
					</tr>
				</div>	
				<div class="form-group">	
					<!--  -->
					<tr>
						<td><label>제품 수량(PRODUCT_STOCK)</label><td>
						<td><input type="text" class="form-control" id="product_stock" name="product_stock""><td>
					</tr>
				</div>	
				<div class="form-group">	
					<!--  -->
					<tr>
						<td><label>제품 용량(PRODUCT_CAPACITY)</label><td>
						<td><input type="text" class="form-control" id="product_capacity" name="product_capacity"><td>
					</tr>
				</div>	
				<div class="form-group">	
					<!--  -->
					<tr>
						<td><label>제품 도수(PRODUCT_ALCOHOL_DEGREE)</label><td>
						<td><input type="text" class="form-control" id="product_alcohol_degree" name="product_alcohol_degree"><td>
					</tr>
				</div>	
				<div class="form-group">	
					<!--  -->
					<tr>
						<td><label>제품 유효기간(PRODUCT_EXPIRATION_DATE)</label><td>
						<td><input type="text" class="form-control" id="product_expiration_date" name="product_expiration_date"><td>
					</tr>
				</div>	
				<div class="form-group">	
					<!--  -->
					<tr>
						<td><label>제품 원산지(PRODUCT_ORIGIN)</label><td>
						<td><input type="text" class="form-control" id="product_origin" name="product_origin"><td>
					</tr>
				</div>	
				<div class="form-group">	
					<!--  -->
					<tr>
						<td><label>제품 이미지(PRODUCT_IMAGE)</label><td>
						<td><input type="text" class="form-control" id="product_image" name="product_image"><td>
					</tr>
				</div>	
				<div class="form-group">	
					<!--  -->
					<tr>
						<td><label>제품 설명(PRODUCT_DESCRIPT)</label><td>
						<td><input type="text" class="form-control" id="product_descript" name="product_descript"><td>
					</tr>
				</div>	
				<div class="form-group">	
					<!--  -->
					<tr>
						<td><label>제품 할인가(PRODUCT_DISCOUNT)</label><td>
						<td><input type="text" class="form-control" id="product_discount" name="product_discount"><td>
					</tr>
				</div>	
				<div class="form-group">	
					<!--  -->
					<tr>
						<td><label>제품 카테고리(CATE_CODE)</label><td>
						<td><input type="text" class="form-control" id="cate_code" name="cate_code"><td>
					</tr>
				</div>
				<div class="form-group">	
					<!--  -->
					<tr>
						<td><label>제품 한국 이름(PRODUCT_KOR_NAME)</label><td>
						<td><input type="text" class="form-control" id="product_kor_name" name="product_kor_name"><td>
					</tr>
				</div>
				
<!-- 				<div class="form-group">	 -->
					<!--  -->
					<tr>
						<td></td>
						<td colspan="2">
							<button type="submit" class="btn btn-primary">등록</button>
						</td>
					</tr>
<!-- 				</div> -->
			</form>	
		
		</table>
		
<!-- 			<form role="form"> -->
<!-- 				<div class="form-group"> -->
					 
<!-- 					<label for="exampleInputEmail1"> -->
<!-- 						Email address -->
<!-- 					</label> -->
<!-- 					<input type="email" class="form-control" id="exampleInputEmail1" /> -->
<!-- 				</div> -->
<!-- 				<div class="form-group"> -->
					 
<!-- 					<label for="exampleInputPassword1"> -->
<!-- 						Password -->
<!-- 					</label> -->
<!-- 					<input type="password" class="form-control" id="exampleInputPassword1" /> -->
<!-- 				</div> -->
<!-- 				<div class="form-group"> -->
					 
<!-- 					<label for="exampleInputFile"> -->
<!-- 						File input -->
<!-- 					</label> -->
<!-- 					<input type="file" class="form-control-file" id="exampleInputFile" /> -->
<!-- 					<p class="help-block"> -->
<!-- 						Example block-level help text here. -->
<!-- 					</p> -->
<!-- 				</div> -->
<!-- 				<div class="checkbox"> -->
					 
<!-- 					<label> -->
<!-- 						<input type="checkbox" /> Check me out -->
<!-- 					</label> -->
<!-- 				</div>  -->
<!-- 				<button type="submit" class="btn btn-primary"> -->
<!-- 					Submit -->
<!-- 				</button> -->
<!-- 			</form> -->
			
			
		</div> <!-- col-md-12 -->
	</div>
</div>


<%@ include file="/WEB-INF/views/include/manager_footer.jsp"%>      