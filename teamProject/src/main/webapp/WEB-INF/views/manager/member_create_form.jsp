<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<%@ include file="/WEB-INF/views/include/manager_header.jsp"%>      

<script>
$(document).ready(function() {
	var frmRegistApproval = $("#frmRegistApproval");
	$("#regist_btn").click(function(e){
		e.preventDefault();
		alert("회원 등록이 승인되었습니다.");
		frmRegistApproval.submit();
	});
});
</script>

<div class="container-fluid px-4">
	<div class="row">
		<div class="col-md-7">
		
		
		<h2>멤버 등록</h2>

		<form role="form" action="/manager/memberCreation" method="post" id="frmRegistApproval">

		<table class="table">
				<tr>
					<td><label for="product_id">멤버 아이디(MEMBER_ID)</label><td>
					<td><input type="text" class="form-control" id="member_id" name="member_id"
						 style="width:100%;"><td>
				</tr>
				<tr>
					<td><label>멤버 비밀번호(MEMBER_PW)</label><td>
					<td><input type="text" class="form-control" id="member_pw" name="member_pw"><td>
				</tr>
			
				<tr>
					<td><label>멤버 이름(MEMBER_NAME)</label><td>
					<td><input type="text" class="form-control" id="member_name" name="member_name"><td>
				</tr>
			
				<tr>
					<td><label>닉네임(NICKNAME)</label><td>
					<td><input type="text" class="form-control" id="nickname" name="nickname"><td>
				</tr>
		
				<tr>
					<td><label>이메일(EMAIL)</label><td>
					<td><input type="text" class="form-control" id="email" name="email"><td>
				</tr>
			
				<tr>
					<td><label>선호주류(FAVORITE)</label><td>
					<td><input type="text" class="form-control" id="favorite" name="favorite"><td>
				</tr>
		
				<tr>
					<td><label>멤버 등록일(REGDATE)</label><td>
					<td><input type="text" class="form-control" id="regdate" name="regdate"><td>
				</tr>
			
				<tr>
					<td><label>멤버 수정일(UPDATEDATE)</label><td>
					<td><input type="text" class="form-control" id="updatedate" name="updatedate"><td>
				</tr>
			
				<tr>
					<td><label>멤버 주소(ADDRESS)</label><td>
					<td><input type="text" class="form-control" id="address" name="address"><td>
				</tr>
			
				<tr>
					<td><label>멤버 전화번호(MEMBER_TEL)</label><td>
					<td><input type="text" class="form-control" id="member_tel" name="member_tel"><td>
				</tr>
			
				<tr>
					<td><label>멤버 포인트(MEMBER_POINT)</label><td>
					<td><input type="text" class="form-control" id="member_point" name="member_point"><td>
				</tr>
				<tr>
					<td><label></label></td>
					<td></td>
					<td><button type="button" class="btn btn-primary" style="float: right;" id="regist_btn"
							>등록</button></td>
				</tr>
			</table>
			</form>	
			
		</div> <!-- col-md-12 -->
		<div class="col-md-5"></div>
	</div>
</div>


<%@ include file="/WEB-INF/views/include/manager_footer.jsp"%>      