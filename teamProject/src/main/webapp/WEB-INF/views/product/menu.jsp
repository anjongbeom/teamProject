<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/WEB-INF/views/include/header.jsp"%>


<!-- jquery 인식 안돼서 따로 가져옴 -->
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>

<%@ include file="/WEB-INF/views/include/paging.jsp" %>

<script>
$(document).ready(function() {
	var frmPaging = $("#frmPaging");
	

	$(".detail_list").click(function(e) {
		e.preventDefault();
		var product_id = $(this).attr("data-id");
// 		alert(product_id);
		location.href="/product/detail?product_id=" + product_id;
		frmPaging.find("input[name=product_id]").val(product_id);

		frmPaging.attr("action", "/product/detail");
		frmPaging.attr("method", "get");
		frmPaging.submit();
	});



	// 검색 버튼 클릭
	$("#button-search").click(function() {
		var keyword = $("#keyword").val();
		console.log("keyword:", keyword);
		frmPaging.find("input[name=keyword]").val(keyword);	
		frmPaging.attr("action", "/product/list");
		frmPaging.attr("method", "get");
		frmPaging.submit();
	});
});
</script>
        	
        ${loginVo}
        <!-- Section-->
         <!-- Side widgets-->
         <div style="text-align: center;">
                <div class="col-lg-4" style="display: inline-block;">
                    <!-- Search widget-->
                    <div class="card mb-4 text-center center"">
                        <div class="card-header">Search</div>
                        <div class="card-body">
                            <div class="input-group">
                                <input class="form-control" type="text" id="keyword" placeholder="이름을 검색해주세요" value="${pagingDto.keyword}"/>
                                <button class="btn btn-primary" id="button-search" type="button">Go!</button>
                            </div>
                        </div>
                    </div>  
                     <!--Search widget-->                  
                    </div>
         </div>
                <!-- Side widgets--> 
                
                
<%--         ${productVo} --%>
                    
        <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                
                	<!--  프로덕트 -->
                	
                	<c:forEach items="${productVo}" var="productVo">
                	
	                    <div class="col mb-5">
	                        <div class="card h-100">
	                        
	                            <!-- Product image-->
	                            <img class="card-img-top" src="/product/displayImage?filename=${productVo.product_image}" alt="..." 
	                            	height="328"/>
	                            
	                            <!-- Product details-->
	                            <div class="card-body p-4">
	                                <div class="text-center">
	                                    <!-- Product name-->
	                                    <h5 class="fw-bolder">${productVo.product_name}</h5>
	                                    <!-- Product price-->
	                                    ${productVo.product_price} point
	                                </div>
	                            </div>
	                            
	                            <!-- Product actions-->
	                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
	                                <div class="text-center">

	                                	<a class="btn btn-outline-dark mt-auto detail_list" id="detail_list" data-id="${productVo.product_id}" href="#">제품 상세보기</a>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                     
                   </c:forEach>
                    <!--  // 프로덕트 -->
                    

                </div>
            </div>
        </section>
        
        
<%@ include file="/WEB-INF/views/include/footer.jsp"%>        
        
        