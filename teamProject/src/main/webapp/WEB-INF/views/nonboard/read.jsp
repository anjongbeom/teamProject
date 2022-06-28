<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">														
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">														
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>														
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>														
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>				
	<meta charset="UTF-8">
<meta charset="UTF-8">
<title>수정폼</title>
<script>
$(document).ready(function(){
	$("#btnCommentInsert").click(function(){
		var content = $("#c_content").val();
		var adminId = $("#c_adminId").val();
		var bno =  "${list.bno}";
		var url="/comment/insertComment";
		var sData={
				"content":content,
				"adminId":adminId,
				"bno":bno
		};
		console.log("sData:", sData);
		$.post(url,sData,function(rData){
			console.log("rData:", rData);
			if(rData=="true"){
				getCommentList();
			}
		});
	});
	
	function getCommentList(){
		var bno = "${list.bno}";
		var url = "/comment/selectComment/" + bno;
		$.get(url, function(rData) {
			console.log(rData);
			$("#table_comment_list tr:gt(0)").remove();
			
			$.each(rData, function() {
				var tr = $("#table_clone tr").clone();
				var tds = tr.find("td");
				tds.eq(0).text(this.cno);
				tds.eq(1).text(this.content);
				tds.eq(2).text(this.adminId);
				tds.eq(3).text(this.regdate);
				tds.find(".btnCommentDelete").attr("data-cno", this.cno);
				tds.find(".btnCommentModify").attr("data-cno", this.cno);
				$("#table_comment_list").append(tr);
			});
		});
	}

	// 댓글 삭제 버튼
	$("#table_comment_list").on("click", ".btnCommentDelete", function() {
		console.log("댓글 삭제 버튼");
		var cno = $(this).attr("data-cno");
		var url = "/comment/deleteComment/" + cno;
		$.get(url, function(rData) {
			console.log(rData);
			if (rData == "true") {
				getCommentList();
			}
		});
	});
	
	
	
	
	// 댓글 수정 버튼
	$("#table_comment_list").on("click", ".btnCommentModify", function() {
		$("#modal-538959").trigger("click");
		var tr = $(this).parents("tr");
		console.log(tr);
		var content = tr.find("td").eq(1).text();
		console.log(content);
		$("#modalContent").val(content);
		$("#btnModalSave").attr("data-cno", $(this).attr("data-cno"));
		console.log("data-cno"+$(this).attr("data-cno"));
	});
	
	// 모달창 저장 버튼
	$("#btnModalSave").click(function() {
		var content = $("#modalContent").val();
		var cno = $(this).attr("data-cno");
		var sData = {
				"content" : content,
				"cno"	  : cno
		};
		var url = "/comment/updateComment";
		$.post(url, sData, function(rData) {
			console.log(rData);
			if (rData == "true") {
				getCommentList();
				$("#btnModalClose").trigger("click");
			}
		});
	
	});
	getCommentList();
	
});
</script>
</head>
<body>
수정폼
${list}
<!-- 모달창 -->
<div class="row">
		<div class="col-md-12">
			 <a id="modal-538959" href="#modal-container-538959" role="button" class="btn" data-toggle="modal" style="display:none;">Launch demo modal</a>
			
			<div class="modal fade" id="modal-container-538959" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="myModalLabel">
								댓글
							</h5> 
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">×</span>
							</button>
						</div>
						<div class="modal-body">
							<input type="text" id="modalContent">
						</div>
						<div class="modal-footer">
							 
							<button type="button" class="btn btn-primary" id="btnModalSave">
								저장
							</button> 
							<button type="button" class="btn btn-secondary" data-dismiss="modal" id="btnModalClose">
								닫기
							</button>
						</div>
					</div>
					
				</div>
				
			</div>
			
		</div>
	</div>
	
	<!-- 모달창 -->

<c:set var="vo" value="${list}"/>
<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-3">
				</div>
				<div class="col-md-6">
				
				<form action="/nonBoard/modifyRun" method="post">
            <div class="form-group">
                <label for="title">제목</label>
                <input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력하세요" value="${vo.title}">
            </div>
            <div class="form-group">
                <label for="writer"> 작성자 </label>
                <input type="text" class="form-control" id="writer" name="writer" placeholder="작성자를 입력하세요" value="${vo.writer}">
            </div>
            <div class="form-group">
                <label for="email"> 이메일 </label>
                <input type="email" class="form-control" id="email" name="email" placeholder="이메일를을입력하세요"  value="${vo.email}">
            </div>
            <div class="form-group">
                <label for="content"> 내용 </label>
                <textarea class="form-control" id="content" name="content" placeholder="내용을 입력하세요">${vo.content}</textarea>
            </div>
            <input type="hidden" name="bno" value="${vo.bno}">
            <input type="submit" class="btn btn-primary" id="btn-modify" value="수정">
            
            <a href="/nonBoard/list" role="button" class="btn btn-secondary">취소</a>
            <a href="/nonBoard/delete?bno=${vo.bno}" role="button" class="btn btn-danger">삭제</a>
            <a href="/nonBoard/replyForm?bno=${vo.bno}" role="button" class="btn btn-dark">답글쓰기</a>
        </form>
        
        
				
				</div>
				<div class="col-md-3">
				</div>
			</div>
		</div>
	</div>
	
	
	
	
	<!-- 댓글(comment) -->
	<div class="row" style="margin-top:30px">
		
		<div class="col-md-9">
			<input type="text" class="form-control"
				placeholder="댓글을 입력해주세요." id="c_content">
		</div>
		<div class="col-md-2">
			<input type="text" class="form-control"
				placeholder="아이디를 입력하세요" id="c_adminId">
		</div>
		<div class="col-md-1">
			<button type="button" class="btn btn-sm btn-primary"
				id="btnCommentInsert">완료</button>
		</div>
		
	</div>
	
	<div class="row" style="margin-top:30px;">
		<div class="col-md-12">
			<table style="display:none;" id="table_clone">
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>
						<button type="button"
							class="btn btn-sm btn-warning btnCommentModify">수정</button>
					</td>
					<td>
						<button type="button"
							class="btn btn-sm btn-danger btnCommentDelete">삭제</button>
					</td>
				</tr>
			</table>
			<table class="table" id="table_comment_list">
				<tr>
					<td>#</td>
					<td>내용</td>
					<td>작성자</td>
					<td>날짜</td>
					<td>수정</td>
					<td>삭제</td>
				</tr>
			</table>
		</div>
	</div>


</body>
</html>