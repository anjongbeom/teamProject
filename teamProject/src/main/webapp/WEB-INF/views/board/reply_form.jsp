<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/include/header.jsp" %>
<!-- 	<div class="content-wrapper"> -->
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>답글 쓰기</h2>
				<p><a class="btn btn-primary btn-large" href="#">글목록</a></p>
			</div>
			<div class="row">
				<div class="col-md-12" >
					<form role="form" action="/board/replyRun" method="post">
					<input type="hidden" name="re_group" value="${boardVo.re_group}">
					<input type="hidden" name="re_level" value="${boardVo.re_level}">
					<input type="hidden" name="re_seq" value="${boardVo.re_seq}">
						<div class="form-group">
							<label for="title">제목</label>
							<input type="text" class="form-control" 
							id="title" name="title" value="re: ${boardVo.title}"/>
						</div>
						<div class="form-group">
							<label for="content">내용</label>
							<textarea class="form-control" 
							id="content" name="content" >
-----------------------------
${boardVo.content}</textarea>
						</div>
						<div class="form-group">
							<label for="writer">작성자</label>
							<input type="text" class="form-control" value="${boardVo.writer}"
							 id="writer" name="writer" readonly="readonly"/>
						</div>
						<div style="height: 50px; margin-top: 10px;">
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
<!-- 	</div> -->
<%@ include file="/WEB-INF/views/include/footer.jsp" %>