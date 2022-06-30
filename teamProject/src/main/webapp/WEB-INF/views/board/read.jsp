<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/include/header.jsp" %>

<script>
$(document).ready(function(){
	
	var update_result = "${update_result}";
	var frmPaging = $("#frmPaging");
	console.log("update_result"+update_result);
	if(update_result == "true"){
		alert("수정되었습니다.");
	}
	
	$("#btnUpdate").click(function(){
		$("*[readonly]").attr("readonly", false);
		$(this).fadeOut("slow");
		$("#btnUpdateRun").fadeIn("slow");
	});
	
	$("#btnDelete").click(function(e){
		e.preventDefault();
		var bno = $(this).attr("href");
		frmPaging.find("input[name=bno]").val(bno);
		frmPaging.attr("action", "/board/delete");
		frmPaging.attr("method", "get");
		frmPaging.submit();
	});
	
	$("#a_list").click(function(e){
		e.preventDefualt;
		frmPaging.find("input[name=bno]").val("${boardVo.bno}");
		frmPaging.attr("action", "/board/list");
		frmPaging.attr("method", "get");
		frmPaging.submit();
	});
	
	$("#btnCommentInsert").click(function(){
		var content = $("#c_content").val(); 
		var userid = $("#c_userid").val();
		var bno = "${boardVo.bno}";
		var sData = {
				"content" : content,
				"userid"  : userid,
				"bno" 	  : bno
		};
// 		console.log("sData: ", sData);
		var url = "/comment/insertComment";
		$.post(url, sData, function(rData){
			console.log(rData);
			if (rData == "true"){
				getCommentList();
			}
		});
	});
	function getCommentList(){
		var bno = "${boardVo.bno}";
		var url = "/comment/commentList/" + bno;
		$.get(url, function(rData){
// 			console.log("rData:", rData);
			$("#table_comment_list tr:gt(0)").remove();
			$.each(rData,function(){
				var tr = $("#table_clone tr").clone();
				var tds = tr.find("td");
				tds.eq(0).text(this.cno);
				tds.eq(1).text(this.content); 
				tds.eq(2).text(this.userid);
				tds.eq(3).text(this.regdate);
				tds.find(".btnCommentDelete").attr("data-cno", this.cno);
				tds.find(".btnCommentModify").attr("data-cno", this.cno);
				$("#table_comment_list").append(tr);
			});
		});
	}
	
	$("#table_comment_list").on("click", ".btnCommentDelete", function(){
// 		console.log("댓글 삭제 버튼");
		var cno = $(this).attr("data-cno");
// 		console.log("cno ",cno);
		var url = "/comment/deleteComment/" +cno;
		$.get(url, function(rData){
			console.log(rData);
			if(rData == "true"){
				getCommentList();
			}
		});
	});
	
	$("#table_comment_list").on("click", ".btnCommentModify", function(){
		$(this).hide("fast");
		$(this).next().show("slow");
		$(this).next().attr("data-cno", $(this).attr("data-cno"));
		var tr = $(this).parents("tr");
		var td = tr.find("td").eq(1);
		var text = td.text();
		var input_tag = "<input type='text' value='"+text+"'>";
		td.html(input_tag);
		var content = text;
// 		console.log("content:",content);
		$("content").val(content);
	});
	
	$("#table_comment_list").on("click", ".btnCommentModifyFinish", function(){
		var tr = $(this).parents("tr");
		var td = tr.find("td").eq(1);
		var input = td.find("input");
		var content = input.val();
		var cno = $(this).attr("data-cno");
		console.log("content:",content);
		var sData = {
				"content" : content ,
				"cno"	  : cno
		};
		console.log("sData",sData)
		var url = "/comment/updateComment";
		$.post(url, sData, function(rData){
			console.log(rData);
			if (rData == "true"){
				getCommentList();
			}
		})
	});
	
	
	getCommentList();
	
	/*
	$("#table_comment_list").on("click", ".btnCommentModify", function(){
		$(this).hide("fast");
		$(this).next().show("slow");
		$(this).next().attr("data-cno", $(this).attr("data-cno"));
		var tr = $(this).parents("tr");
		var td = tr.find("td").eq(1);
		var text = td.text();
		var input_tag = "<input type='text' value='"+text+"'>";
		td.html(input_tag);
		
	});
	*/
	/*
	$("#table_comment_list").on("click", ".btnCommentModifyFinish", function()	{
		var tr = $(this).parents("tr");
		var td = tr.find("td").eq(1);
		var input = td.find("input");
		var content = input.val();
		var cno = $(this).attr("data-cno");
		console.log("content:" + content);
		console.log("cno:" + cno);
		

		var sData = {
				"content"	:	content,
				"cno"		: 	cno
		}
		console.log("sData :" ,  sData);
		var url = "/comment/updateComment";
		$.post(url, sData, function(rData) {
			console.log(rData);
			if(rData == "true"){
				getCommentList();
			}
		}); // $.post
	}); // $("#table_comment_list").on("click"
	*/
	
	
	
});

</script>
<%@ include file="/WEB-INF/views/include/paging.jsp" %>
<!-- 	<div class="content-wrapper"> -->
<div class="container-fluid">

		<div class="row">
			<div class="col-md-12" >
			<form class="role-form" action="/board/updateRun" method="post">
			<input type="hidden" name="bno" value="${boardVo.bno}">
			<input type="hidden" name="page" value="${pagingDto.page}">
			<input type="hidden" name="perPage" value="${pagingDto.perPage}">
			<input type="hidden" name="searchType" value="${pagingDto.searchType}">
			<input type="hidden" name="keyword" value="${pagingDto.keyword}">
			
			<div class="jumbotron">
				<h2>글 내용 보기</h2>
				<p><a class="btn btn-primary btn-large" id="a_list" 
				href="/board/list">글목록</a></p>
			</div>
						<div class="form-group">
							<label for="title">제목</label>
							<input type="text" class="form-control" id="title" 
							name="title" value="${boardVo.title}" readonly="readonly"/>
						</div>
						<div class="form-group">
							<label for="content">내용</label>
							<textarea class="form-control" id="content" 
							name="content" readonly="readonly">${boardVo.content}</textarea>
						</div>
						<div class="form-group">
							<label for="writer">작성자</label>
							<input type="text" class="form-control" id="writer" 
							name="writer" value="${boardVo.writer}" readonly="readonly"/>
						</div>
						<div style="height: 10px;"></div>
						<button type="button" class="btn btn-primary"
						id="btnUpdate">수정</button>
						<button type="submit" class="btn btn-success"
						id="btnUpdateRun" style="display: none;">수정완료</button>
						<a class="btn btn-danger"  id="btnDelete"
						href="${boardVo.bno}">삭제</a>
						<a class="btn btn-warning" href="/board/replyForm?bno=${boardVo.bno}">답글</a>
						
						</form>
					</div>
				</div>
					<!-- 댓글 달기 -->
					
				<div class="row" style="margin-top: 30px;">
					<div class="col-md-9" >
					<input type="text" class="form-control"
					id="c_content" placeholder="댓글을 입력해주세요">
					</div>
					<div class="col-md-2" >
					<input type="text" class="form-control"
					id="c_userid" placeholder="아이디를 입력해주세요">
					</div>
					<div class="col-md-1" >
					<button type="button" class="btn btn-sm btn-primary"
					id="btnCommentInsert">완료</button>
					</div>
				</div>
				<div class="row" style="margin-top: 30px;">
					<div class="col-md-12" >
						<table style="display: none;" id="table_clone">
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>
									<button type="button" 
									class="btn btn-sm btn-warning btnCommentModify">수정</button>
									<button type="button" class="btn btn-sm btn-success btnCommentModifyFinish"
										 style="display: none;">수정완료</button>
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
		
	</div>
</div>
<!-- 	</div> -->
<%@ include file="/WEB-INF/views/include/footer.jsp" %>