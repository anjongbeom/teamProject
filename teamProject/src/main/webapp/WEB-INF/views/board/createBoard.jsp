<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<%@ include file="/WEB-INF/views/include/header.jsp"%>


<!-- <div class="container-fluid"> -->
	<style>
#fileDrop {
	width: 80%;
	height: 100px;
	background-color: aliceblue;
	margin: 20px auto;
	border: 1px dashed blue;
}
.divUploaded{
	width: 150px;
	float: left;
}
</style>
<script src="/resources/js/myscript.js"></script>
<script>
$(function(){
	$("#fileDrop").on("dragenter dragover", function(e){
		e.preventDefault();
	});
	$("#fileDrop").on("drop", function(e){
		e.preventDefault();
// 		console.log(e);
		var file = e.originalEvent.dataTransfer.files[0];
		console.log(file);
		var formData = new FormData();
		formData.append("file", file);
		var url = "/board/uploadFile"; 
		
		$.ajax({
			"processData" : false,
			"contentType" : false,
			"url"		  : url,
			"method"	  : "post",
			"data"		  : formData,
			"success"	  : function(rData) {
				var cloneDiv = $(".divUploaded").eq(0).clone();
				var filename = getFilename(rData);
				cloneDiv.find("span").text(filename);
				cloneDiv.attr("data-filename", rData);
				if (isImage(filename)){
					cloneDiv.find("img")
					.attr("src", "/member/displayImage?filename=" + rData);
					cloneDiv.find("a.a_delete").attr("data-filename", rData);
				}
				cloneDiv.appendTo($("#uploadedList")).show();
			}
		});
	});
	$("#frmCreate").submit(function(){
		var divs = $("#uploadedList > .divUploaded");
		console.log(divs);
		divs.each(function(){
			var filename = $(this).attr("data-filename");
			var inputHtml = "<input type='hidden' name='files' value='" + filename + "'>";
			$("#frmCreate").prepend(inputHtml);
		});
// 		return false;
	});
	$("#uploadedList").on("click", ".a_delete", function(e){
		e.preventDefault();
		var that = $(this);
		var filename = that.attr("data-filename");
		console.log("filename:" + filename);
		var url = "/board/deleteFile";
		var sendData = {
				"filename"		: filename
		}
		$.get(url, sendData, function(rData){
			console.log(rData);
			if (rData == "true"){
			that.parent().remove();
		}
		});
	});
});
</script>
<!-- 	<div class="content-wrapper"> -->
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>
					게시글 작성
				</h2>
				<p><a class="btn btn-primary btn-large" href="/board/list?page=1">글목록</a></p>
			</div>
			<div class="row">
				<div class="col-md-12" >
					<form role="form" action="/board/createRun" 
					method="post" id="frmCreate">
						<div class="form-group">
							<label for="title">제목</label>
							<input type="text" class="form-control" id="title" name="title"/>
						</div>
						<div class="form-group">
							<label for="content">내용</label>
							<textarea class="form-control" id="content" name="content"></textarea>
						</div>
						<div class="form-group">
							<label for="writer">작성자</label>
							<input type="text" class="form-control" id="writer" name="writer"/>
						</div>
						
						<!-- 업로드 영역 -->
<!-- 						<div> -->
<!-- 							<label>첨부할 파일을 드래그 &amp; 드롭하세요.</label> -->
<!-- 							<div id="fileDrop"></div> -->
<!-- 						</div> -->
						
						<!-- 업로드 항목 템플릿 -->
<!-- 						<div class="divUploaded" style="display: none;"> -->
<!-- 							<img src="/resources/images/defualt.png" height="100"><br> -->
<!-- 							<span>default.png</span> -->
<!-- 							<a href="#" class="a_delete">&times;</a> -->
<!-- 						</div> -->
						
						<!-- 업로드 항목 템플릿 -->
<!-- 						<div id="uploadedList" style="clear: both;"> -->
<!-- 						</div> -->
										
						<div style="height: 10px;"></div>
						<div style="clear: both; display: flex; align-items: center; justify-content: flex-end;">
						<button type="submit" class="btn btn-primary">
							작성완료
						</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- </div> -->
<%@ include file="/WEB-INF/views/include/footer.jsp"%>