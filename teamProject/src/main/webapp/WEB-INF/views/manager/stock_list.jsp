<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="/WEB-INF/views/include/manager_header.jsp"%>


<style>
tr.tr_list {
	cursor: pointer;
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
		var product_paging = $("#product_paging");

		var create_result = "${create_result}";
		var delete_result = "${delete_result}";
		var reply_result = "${reply_result}";

		console.log("create_result: ", create_result);
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
			var product_id = $(this).attr("data-pid");
			product_paging.find("input[name=product_id]").val(product_id);
			product_paging.attr("action", "/manager/stockModifyForm");
			product_paging.attr("method", "get");
			product_paging.submit();
		});
		
		$("#perPage").change(function() {
			var perPage = $(this).val();
			console.log(perPage);
			product_paging.find("input[name=perPage]").val(perPage);
			product_paging.find("input[name=page]").val(1);
			product_paging.attr("action", "/manager/stockList");
			product_paging.attr("method", "get");
			product_paging.submit();
		});

		$("a.page-link").click(function(e) {
			e.preventDefault();
			var page = $(this).attr("href");
			product_paging.find("input[name=page]").val(page);
			// action을 생략하면 브라우저 주소창의 현재 경로가 action값이 됨
			product_paging.attr("action", "/manager/stockList");
			// method를 생략하면 get이 기본 값이 됨
			product_paging.attr("method", "get");
			product_paging.submit();
		});

		// 검색 버튼
		$("#btnSearch").click(function() {
			var searchType = $("#searchType").val();
			var keyword = $("#keyword").val();
			console.log("searchType:", searchType);
			console.log("keyword:", keyword);
			product_paging.find("input[name=searchType]").val(searchType);
			product_paging.find("input[name=keyword]").val(keyword);
			product_paging.find("input[name=page]").val(1);
			product_paging.attr("action", "/manager/stockList");
			product_paging.attr("method", "get");
			product_paging.submit();

		});

	});
</script>

<%@ include file="/WEB-INF/views/include/product_paging.jsp"%>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>제품 목록</h2>
				<p>
					<a class="btn btn-primary btn-large" href="/manager/stockCreation">제품
						등록</a>
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
								</c:if>>${v}줄
								씩 보기</option>
						</c:forEach>
					</select>


					<!-- 검색   -->
					<select name="search" id="searchType" style="margin-left: 30px">
						<option value="pkn"
							<c:if test="${pagingDto.searchType=='pkn'}">
								selected
							</c:if>>제품
							이름</option>

						<option value="pi"
							<c:if test="${pagingDto.searchType=='pi'}">
								selected
							</c:if>>제품
							아이디</option>
						<option value="cc"
							<c:if test="${pagingDto.searchType=='cc'}">
								selected
							</c:if>>카테고리
							코드</option>

					</select> <input type="text" id="keyword" value="${pagingDto.keyword}">
					<button type="button" class="btn btn-sm btn-success" id="btnSearch">검색</button>
				</div>
			</div>


			<div class="row">
				<div class="col-md-12">
					<table class="table">
						<thead>
							<tr>
								<th>#</th>
								<th>제품 이미지</th>
								<th>제품 이름</th>
								<th>제품 가격</th>
								<th>제품 수량</th>
								<th>할인 가격</th>
								<th>카테고리 코드</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${stock_list}" var="productVo"
								varStatus="status">
								<tr class="tr_list" data-pid="${productVo.product_id}"
									style="justify-content: center;">
									<td style="vertical-align: middle;">${status.count}</td>
									<td style="vertical-align: middle;"><img
										class="card-img-top"
										src="/product/displayImage?filename=${productVo.product_image}"
										alt="..."
										style="display: block; margin: auto; width: 122px; height: 182px;" />
									</td>
									<td>${productVo.product_kor_name}</td>
									<td>${productVo.product_price}</td>
									<td>${productVo.product_stock}</td>
									<td>${productVo.product_discount}</td>
									<td>${productVo.cate_code}</td>
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
							<li class="page-item"><a class="page-link"
								href="${pagingDto.startPage - 1}">이전</a></li>
						</c:if>

						<li class="page-item"><c:forEach
								begin="${pagingDto.startPage}" end="${pagingDto.endPage}"
								var="i">
								<li
									<c:choose>
								<c:when test="${i == param.page}">
									class="page-item active"
								</c:when>
								<c:otherwise>
									class="page-item"
								</c:otherwise>
							</c:choose>>
									<a href="${i}" class="page-link">${i}</a>
								</li>
							</c:forEach> <c:if test="${pagingDto.endPage != pagingDto.totalPage}">
								<li><a class="page-link" href="${pagingDto.endPage + 1}">다음</a>
								</li>
							</c:if>
					</ul>
				</nav>
			</div>
		</div>

	</div>
</div>

<%@ include file="/WEB-INF/views/include/manager_footer.jsp"%>
