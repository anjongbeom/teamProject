<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
   
        <!-- Responsive navbar-->
        
        <!-- Page header with logo and tagline-->
        <header class="py-5 bg-light border-bottom mb-4">
            <div class="container">
                <div class="text-center my-5">
                    <h1 class="fw-bolder">TITLE</h1>
                    
                </div>
            </div>
        </header>
        <!-- Page content-->
        <div class="container">
            <div class="row">
                <!-- Blog entries-->
                <div class="col-lg-6">
                    <!-- Featured blog post-->
                    <div class="card mb-4">
                        <a href="#!"><img class="card-img-top" src="/resources/images/main/beer.jpg" alt="..." width="482" height="382"/></a>
                        
                    </div>
                </div>
                <!-- Side widgets-->
                <div class="col-lg-6">
                    <!-- Side widget-->
                    <div class="mb-4">
                    
                       <!--  <div class="card-header">Side Widget</div> -->
                        <h2 class="card-title">Featured Post Title</h2>
                        <div style="margin-left: 10px;" class="small text-muted">VAT 별도</div>
                            
                            
                            
                            <table class="table table-sm">
                            	<colgroup>
                            		<col style="width:35%">
                            		<col style="width:65%">
                            	</colgroup>
 							  <thead>
							  </thead>
							  <tbody class="table-group-divider">							  
							    <tr>
							      <th scope="row">원산지</th>
							      <td>영국</td>
							    </tr>
							    <tr>
							      <th scope="row" >용량</th>
							      <td>700ml</td>
							    </tr>
							    <tr>
							      <th scope="row" >알콜도수</th>
							      <td>40%</td>
							    </tr>
							    <tr>
							      <th scope="row" >소비자가격</th>
							      <td>.-Point</td>
							    </tr>
							    <tr>
							      <th scope="row" style="vertical-align: middle;">판매가격</th>
							      <td style="font-size: 40px; color: #CF492C;">159 Point</td>
							    </tr>
							  </tbody>
							</table>
                            <br><br>
                            <a  style="float: right;" class="btn btn-danger" href="#!">상품 문의</a>
                    </div>
                </div>
            </div>
             <div class="content">
		       	아잉 용현아~~~
		       	내용 넣어줘~~~
		        <!--${content}-->
		     </div>
        </div>
       
       

   
       
<%@ include file="/WEB-INF/views/include/footer.jsp"%>        