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
							 
							<label for="exampleInputEmail1">
								Email address
							</label>
							<input type="email" class="form-control" id="exampleInputEmail1" />
						</div>
						<div class="form-group">
							 
							<label for="exampleInputPassword1">
								Password
							</label>
							<input type="password" class="form-control" id="exampleInputPassword1" />
						</div>
						<div class="form-group">
							 
							<label for="exampleInputFile">
								File input
							</label>
							<input type="file" class="form-control-file" id="exampleInputFile" />
							<p class="help-block">
								Example block-level help text here.
							</p>
						</div>
						<div class="checkbox">
							 
							<label>
								<input type="checkbox" /> Check me out
							</label>
						</div> 
						<button type="submit" class="btn btn-primary">
							Submit
						</button>
					</form>
					<form role="form">
						<div class="form-group">
							 
							<label for="exampleInputEmail1">
								Email address
							</label>
							<input type="email" class="form-control" id="exampleInputEmail1" />
						</div>
						<div class="form-group">
							 
							<label for="exampleInputPassword1">
								Password
							</label>
							<input type="password" class="form-control" id="exampleInputPassword1" />
						</div>
						<div class="form-group">
							 
							<label for="exampleInputFile">
								File input
							</label>
							<input type="file" class="form-control-file" id="exampleInputFile" />
							<p class="help-block">
								Example block-level help text here.
							</p>
						</div>
						<div class="checkbox">
							 
							<label>
								<input type="checkbox" /> Check me out
							</label>
						</div> 
						<button type="submit" class="btn btn-primary">
							Submit
						</button>
					</form><img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" />
				</div>
				<div class="col-md-2">
				</div>
			</div>
		</div>
	</div>
<!-- </div> -->
<%@ include file="/WEB-INF/views/include/footer.jsp"%>