<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/include/manager_header.jsp"%>      


<div class="container-fluid px-4">
	<div class="row">
		<div class="col-md-7">
		
		
		<h2>제품 수정</h2>
		<form role="form" action="stockModifyRun" method="get">
		<table class="table">
				<tr>
					<td><label for="MEMBER_ID">제품 아이디(MEMBER_ID)</label><td>
					<td><input type="text" class="form-control" 
						id="product_id" name="product_id" value="${productVo.member_id}"
						 style="width:100%;"><td>
				</tr>
				<tr>
					<td><label>제품 이름(MEMBER_PW)</label><td>
					<td><input type="text" class="form-control" value="${productVo.member_pw}"
						id="product_name" name="product_name"><td>
				</tr>
			
				<tr>
					<td><label>제품 가격(MEMBER_NAME)</label><td>
					<td><input type="text" class="form-control" value="${productVo.member_name}"
						id="product_price" name="product_price"><td>
				</tr>
			
				<tr>
					<td><label>제품 수량(NICKNAME)</label><td>
					<td><input type="text" class="form-control" value="${productVo.nickname}"
						id="product_stock" name="product_stock"><td>
				</tr>
		
				<tr>
					<td><label>제품 용량(EMAIL)</label><td>
					<td><input type="text" class="form-control" value="${productVo.email}"
						id="product_capacity" name="product_capacity"><td>
				</tr>
			
				<tr>
					<td><label>제품 도수(FAVORITE)</label><td>
					<td><input type="text" class="form-control" value="${productVo.favorite}"
						id="product_alcohol_degree" name="product_alcohol_degree"><td>
				</tr>
		
				<tr>
					<td><label>제품 유효기간(REGDATE)</label><td>
					<td><input type="text" class="form-control" value="${productVo.regdate}"
						id="product_expiration_date" name="product_expiration_date"><td>
				</tr>
			
				<tr>
					<td><label>제품 원산지(UPDATEDATE)</label><td>
					<td><input type="text" class="form-control" value="${productVo.updatedate}"
						id="product_origin" name="product_origin"><td>
				</tr>
			
				<tr>
					<td><label>제품 이미지(ADDRESS)</label><td>
					<td><input type="text" class="form-control" value="${productVo.address}"
						id="product_image" name="product_image"><td>
				</tr>
			
				<tr>
					<td><label>제품 설명(MEMBER_TEL)</label><td>
					<td><input type="text" class="form-control" value="${productVo.member_tel}"
						id="product_descript" name="product_descript"><td>
				</tr>
			
				<tr>
					<td><label>제품 할인가(MEMBER_POINT)</label><td>
					<td><input type="text" class="form-control" value="${productVo.member_point}"
						id="product_discount" name="product_discount"><td>
				</tr>
			
				<tr>
					<td><label>제품 카테고리(BANDATE)</label><td>
					<td><input type="text" class="form-control" value="${productVo.bandate}"
						id="cate_code" name="cate_code"><td>
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