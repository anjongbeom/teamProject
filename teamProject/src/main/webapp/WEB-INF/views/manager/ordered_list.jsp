<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="/WEB-INF/views/include/manager_header.jsp"%>


<style>
tr.tr_list {
	cursor:pointer;
}
tr.tr_list:hover {
	background-color: aliceblue;
}
</style>

<!-- jquery 인식 안돼서 따로 가져옴 -->
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>

	
<script>
$(document).ready(function() {
	var frmManagerPaging = $("#frmManagerPaging");
	
	
	$(".tr_list").click(function() {
		console.log("$(this):", $(this));
		var order_no = $(this).attr("data-order_no");
		console.log("order_no:", order_no);
		frmManagerPaging.find("input[name=order_no]").val(order_no);

		frmManagerPaging.attr("action", "/manager/orderedDetailList");
		frmManagerPaging.attr("method", "get");
		frmManagerPaging.submit();
		
	});
	
});


</script>

<%@ include file="/WEB-INF/views/include/manager_paging.jsp" %>
	
<%-- ${sessionScope.orderVo} --%>
	
	<!-- Page content-->
	<div class="container">
		<div class="row">

			<!-- Side widgets-->
			<div class="col-lg-12">
				<!-- Side widget-->
				<div class="mb-4">
				
					<h2 class="card-title">요청 주문 목록</h2>
					<div style="margin-left: 10px;" class="small text-muted"></div>
					<a href="/manager/managerForm" class="btn btn-success">관리자 메인으로</a>
					
					<table class="table table-sm">
						<thead>
							<tr>
								<th scope="row" colspan="1" width="10%" style="text-align: center">주문 번호</th>
								<th scope="row" colspan="1" width="30%" style="text-align: center">주문 날짜</th>
								<th scope="row"  width="30%" style="text-align: center">주문자 아이디</th>
								<th scope="row"  width="30%" style="text-align: center">주문 상태</th>
							</tr>
						</thead>
						
						<tbody class="table-group-divider">
						<c:forEach items="${sessionScope.orderVo}" var="orderVo">
							<tr class="tr_list" data-order_no="${orderVo.order_no}">
								<td style="vertical-align:middle; text-align: center;">${orderVo.order_no}</td>
								<td style="vertical-align:middle; text-align: center;">${orderVo.order_date}</td>
								<td style="vertical-align:middle; text-align: center;">${orderVo.member_id}</td>
								<td style="vertical-align:middle; text-align: center;">${orderVo.order_status_code}</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
<!-- 					<a style="float: right; margin-right: 10px;" class="btn btn-primary" href="/product/purchase"></a> -->
				</div>
			</div>
		

		</div> <!-- <div class="row">  -->
	</div> <!-- // Container -->


<%@ include file="/WEB-INF/views/include/manager_footer.jsp"%>
