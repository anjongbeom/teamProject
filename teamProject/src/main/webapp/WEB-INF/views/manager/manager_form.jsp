<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/include/manager_header.jsp"%>
<!-- 내용 부분 -->

<div class="container-fluid px-4">
	<h1 class="mt-4">관리</h1>
	<ol class="breadcrumb mb-4">
		<li class="breadcrumb-item active">주문/재고 카드</li>
	</ol>
	<div class="row">

		<!-- 재고 등록 -->
		<div class="col-xl-3 col-md-6">
			<div class="card bg-primary text-white mb-4">
				<div class="card-body">재고 등록</div>
				<div
					class="card-footer d-flex align-items-center justify-content-between">
					<a class="small text-white stretched-link"
						href="/manager/stockCreation">View Details</a>
					<div class="small text-white">
						<i class="fas fa-angle-right"></i>
					</div>
				</div>
			</div>
		</div>

		<!-- 재고 리스트 -->
		<div class="col-xl-3 col-md-6">
			<div class="card bg-warning text-white mb-4">
				<div class="card-body">재고 리스트</div>
				<div
					class="card-footer d-flex align-items-center justify-content-between">
					<a class="small text-white stretched-link"
						href="/manager/stockList">View Details</a>
					<div class="small text-white">
						<i class="fas fa-angle-right"></i>
					</div>
				</div>
			</div>
		</div>

		<!-- 주문 요청 목록(승인) -->
		<div class="col-xl-3 col-md-6">
			<div class="card bg-success text-white mb-4">
				<div class="card-body">주문 요청 목록(승인)</div>
				<div
					class="card-footer d-flex align-items-center justify-content-between">
					<a class="small text-white stretched-link"
						href="/manager/orderedList">View Details</a>
					<div class="small text-white">
						<i class="fas fa-angle-right"></i>
					</div>
				</div>
			</div>
		</div>

		<!-- 반품 요청 목록(승인) -->
		<div class="col-xl-3 col-md-6">
			<div class="card bg-danger text-white mb-4">
				<div class="card-body">반품 요청 목록(승인)</div>
				<div
					class="card-footer d-flex align-items-center justify-content-between">
					<a class="small text-white stretched-link"
						href="/manager/returnList">View Details</a>
					<div class="small text-white">
						<i class="fas fa-angle-right"></i>
					</div>
				</div>
			</div>
		</div>

	</div>
</div> <!-- // 주문/관리 카드 -->

<div class="container-fluid px-4">
<!-- 	<h1 class="mt-4">관리</h1> -->
	<ol class="breadcrumb mb-4">
		<li class="breadcrumb-item active">회원 관리 카드</li>
	</ol>
	<div class="row">


		<!-- coolSms 테스트-->
		<div class="col-xl-3 col-md-6">
			<div class="card bg-primary text-white mb-4">
				<div class="card-body">임시</div>
				<div
					class="card-footer d-flex align-items-center justify-content-between">
					<a class="small text-white stretched-link" href="#">View
						Details</a>
					<div class="small text-white">
						<i class="fas fa-angle-right"></i>
					</div>
				</div>
			</div>
		</div>
		
		
		<!-- 회원 목록 -->
		<div class="col-xl-3 col-md-6">
			<div class="card bg-warning text-white mb-4">
				<div class="card-body">회원 목록</div>
				<div
					class="card-footer d-flex align-items-center justify-content-between">
					<a class="small text-white stretched-link" 
						href="/manager/memberList">View
						Details</a>
					<div class="small text-white">
						<i class="fas fa-angle-right"></i>
					</div>
				</div>
			</div>
		</div>

	</div>


</div> <!--  // 회원 관리 카드 -->







<!-- 메인 카드 아래부분 -->


</main>
<footer class="py-4 bg-light mt-auto">
	<div class="container-fluid px-4">
		<div class="d-flex align-items-center justify-content-between small">
			<div class="text-muted">Copyright &copy; Your Website 2022</div>
			<div>
				<a href="#">Privacy Policy</a> &middot; <a href="#">Terms &amp;
					Conditions</a>
			</div>
		</div>
	</div>
</footer>
</div>
<!-- 내용 부분끝  -->


<%@ include file="/WEB-INF/views/include/manager_footer.jsp"%>

