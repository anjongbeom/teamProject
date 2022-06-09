<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/include/header.jsp"%>
	
	
	
        
        <!-- Section-->
         <!-- Side widgets-->
                <div class="col-lg-4 text-center center">
                    <!-- Search widget-->
                    <div class="card mb-4">
                        <div class="card-header">Search</div>
                        <div class="card-body">
                            <div class="input-group">
                                <input class="form-control" type="text" placeholder="Enter search term..." aria-label="Enter search term..." aria-describedby="button-search" />
                                <button class="btn btn-primary" id="button-search" type="button">Go!</button>
                            </div>
                        </div>
                    </div>  
                     <!--Search widget-->                  
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

	                                	<a class="btn btn-outline-dark mt-auto" href="/product/detail">제품 상세보기</a>
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
        
        