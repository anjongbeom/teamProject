<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ include file="/WEB-INF/views/include/manager_header.jsp"%>


<style>
tr.tr_list {
	cursor:pointer;
}
tr.tr_list:hover {
	background-color: aliceblue;
}

/* 검색 데이터 하이라이트 */
.k_span {
 	background-color: yellow;
}

td {
	vertical-align: middle;
}

</style>

<script>
$(document).ready(function() {
	var frmPaging = $("#frmPaging");
	
	var create_result = "${create_result}";
	var delete_result = "${delete_result}";
	var reply_result = "${reply_result}";
	
	console.log("create_result: " , create_result);
	if (create_result == "true") {
		alert("글 쓰기 완료");
	}
	if (delete_result == "true") {
		alert("글 삭제 완료");
	}
	if (reply_result == "true") {
		alert("글 작성 완료");
	}
	
	
	$(".tr_list").click(function() {
		var member_id = $(this).attr("data-mid");
// 		location.href="/board/read?bno=" + bno;
// 		var frmPaging = $("#frmPaging"); 위쪽 정의
		frmPaging.find("input[name=member_id]").val(product_id);
// 		$("#frmPaging > input[name=bno]").val(bno);
		frmPaging.attr("action", "/manager/memberInfoForm"); // 생성 필요
		frmPaging.attr("method", "get");
		frmPaging.submit();
	});
	
	
	$("#perPage").change(function() {
		var perPage = $(this).val();
		console.log(perPage);
// 		var frmPaging = $("#frmPaging"); 위쪽 정의
		frmPaging.find("input[name=perPage]").val(perPage);
		frmPaging.find("input[name=page]").val(1);
		frmPaging.attr("action", "/manager/memberList");
		frmPaging.attr("method", "get");
		frmPaging.submit();
	});
	
	$("a.page-link").click(function(e) {
		e.preventDefault();
		var page = $(this).attr("href");
// 		var frmPaging = $("#frmPaging"); 위쪽 정의
		frmPaging.find("input[name=page]").val(page);
		// action을 생략하면 브라우저 주소창의 현재 경로가 action값이 됨
		frmPaging.attr("action", "/manager/memberList");
		// method를 생략하면 get이 기본 값이 됨
		frmPaging.attr("method", "get");
		frmPaging.submit();
	});
	
	
	// 검색 버튼
	$("#btnSearch").click(function() {
		var searchType = $("#searchType").val();
		var keyword = $("#keyword").val();
		console.log("searchType:", searchType);
		console.log("keyword:", keyword);
		frmPaging.find("input[name=searchType]").val(searchType);
		frmPaging.find("input[name=keyword]").val(keyword);
		frmPaging.find("input[name=page]").val(1);
		frmPaging.attr("action", "/manager/memberList");
		frmPaging.attr("method", "get");
		frmPaging.submit();
		
	});
	
});

</script>

<%@ include file="/WEB-INF/views/include/paging.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>멤버 목록</h2>
				<p>
					<a class="btn btn-primary btn-large" href="/manager/memberCreation">멤버 등록</a>
				</p>
			</div>
			
			<!-- n줄 씩 보기-->
			<div class="row">
				<div class="col-md-12">
					<select name="perPage" id="perPage">
						<c:forEach var="v" begin="5" end="30" step="5">
							<option value="${v}"
								<c:if test="${v == pagingDto.perPage}">
									selected
								</c:if>
							>${v}줄 씩 보기</option>
						</c:forEach>
					</select>
					
					
					<!--  검색 -->
					<select name="search" id="searchType" style="margin-left:30px">
						<option value="mn"
							<c:if test="${pagingDto.searchType=='mn'}">
								selected
							</c:if>
						>멤버 이름</option>
						<option value="ad"
							<c:if test="${pagingDto.searchType=='ad'}">
								selected
							</c:if>
						>주소</option>
						<option value="mt"
							<c:if test="${pagingDto.searchType=='mt'}">
								selected
							</c:if>
						>전화번호</option>
					
					</select>
					<input type="text" id="keyword" value="${pagingDto.keyword}">
					<button type="button" class="btn btn-sm btn-success" id="btnSearch">검색</button>
				</div>
			</div>
			
			
			<div class="row">
				<div class="col-md-12">
					<table class="table">
						<thead>
							<tr>
								<th>#</th>
								<td>아이디</td>
								<td>패스워드</td>
								<td>이름</td>
								<td>닉네임</td>
								<td>이메일</td>
<!-- 								<td>선호 주류</td> -->
<!-- 								<td>등록일</td> -->
<!-- 								<td>업데이트일</td> -->
<!-- 								<td>주소</td> -->
<!-- 								<td>전화번호</td> -->
								<td>포인트</td>
							</tr>
						</thead>
						<tbody>

						
						<c:forEach items="${member_list}" var="memberVo">
							<tr class="tr_list" data-mid="${memberVo.member_id}" style=" justify-content:center;">
								<td style= "vertical-align:middle;">#</td>

								<td>${memberVo.member_id}</td>
								<td>${memberVo.member_pw}</td>
								<td>${memberVo.member_name}</td>
								<td>${memberVo.nickname}</td>
								<td>${memberVo.email}</td>
<%-- 								<td>${memberVo.favorite}</td> --%>
<%-- 								<td>${memberVo.regdate}</td> --%>
<%-- 								<td>${memberVo.updatedate}</td> --%>
<%-- 								<td>${memberVo.address}</td> --%>
<%-- 								<td>${memberVo.member_tel}</td> --%>
								<td>${memberVo.member_point}</td>
								
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
		</div>
	</div>
	
	<!-- 페이징 -->
	<div class="row">
		<div class="col-md-12">
			<nav>
				<ul class="pagination justify-content-center">
					<c:if test="${pagingDto.startPage != 1}">
						<li class="page-item">
							<a class="page-link" 
								href="${pagingDto.startPage - 1}">이전</a>
						</li>
					</c:if>	
						
					<li class="page-item">
					<c:forEach begin="${pagingDto.startPage}" end="${pagingDto.endPage}" var="i">
						
						<li 
							<c:choose>
								<c:when test="${i == param.page}">
									class="page-item active"
								</c:when>
								<c:otherwise>
									class="page-item"
								</c:otherwise>
							</c:choose>	
						>
							<a href="${i}"
								class="page-link">${i}</a>
						</li>
					
					</c:forEach>
					<c:if test="${pagingDto.endPage != pagingDto.totalPage}">
					<li>
						<a class="page-link" 
						href="${pagingDto.endPage + 1}">다음</a>
					</li>
					</c:if>
				</ul>
			</nav>
		</div>
	</div>
	
	
</div>


<%@ include file="/WEB-INF/views/include/manager_footer.jsp"%>
