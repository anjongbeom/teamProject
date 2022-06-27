<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<%@ include file="/WEB-INF/views/include/header.jsp"%>


<!-- <div class="container-fluid"> -->
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-2">
				</div>
				<div class="col-md-8">
					<form role="form" class="form-inline">
						<div class="form-group">
							 
							<label for="review_title">
								제목
							</label>
							<input type="text" class="form-control" id="review_title" />
						</div>
						<div class="form-group">
							 
							<label for="review_content">
								CONTENT
							</label>
							<input type="text" class="form-control" id="review_content" />
						</div>
						<div class="form-group">
							 
							<label for="InputFile">
								파일 선택
							</label>
							<input type="file" class="form-control-file" id="InputFile" />
						</div>
					</form>
					<form role="form">
						<div class="form-group">
							 
							<label for="exampleInputEmail1">
								Email address
							</label>
							<input type="email" class="form-control" id="exampleInputEmail1" />
						</div>
						
						
						
						<button type="submit" class="btn btn-primary">
							Submit
						</button>
					</form>
				</div>
				<div class="col-md-2">
				</div>
			</div>
		</div>
	</div>
<!-- </div> -->
<%@ include file="/WEB-INF/views/include/footer.jsp"%>