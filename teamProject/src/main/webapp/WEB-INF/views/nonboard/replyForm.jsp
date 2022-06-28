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
<title>replyForm</title>
</head>
<body>
replyForm
${nonMemVo}


<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-3">
				</div>
				<div class="col-md-6">
				
				<form action="/nonBoard/replyRun" method="post">
            <div class="form-group">
                <label for="title">제목</label>
                <input type="text" class="form-control" id="title" name="title" value="re:${nonMemVo.title}">
            </div>
            <div class="form-group">
                <label for="writer"> 작성자 </label>
                <input type="text" class="form-control" id="writer" name="writer" placeholder="작성자를 입력하세요">
            </div>
            <div class="form-group">
                <label for="content"> 내용 </label>
                <textarea class="form-control" id="content" name="content" placeholder="내용을 입력하세요">re:${nonMemVo.content}--------------</textarea>
            </div>
     
            <input type="hidden" name="re_step" value="${nonMemVo.re_step}">
            <input type="hidden" name="re_level" value="${nonMemVo.re_level}">
            <input type="hidden" name="re_group" value="${nonMemVo.re_group}">
          
            
            
            <input type="submit" class="btn btn-primary" id="btn-modify" value="답글쓰기">
            
            <a href="/nonBoard/list" role="button" class="btn btn-secondary">취소</a>
            <a href="/nonBoard/delete?bno=${nonMemVo.bno}" role="button" class="btn btn-danger">삭제</a>
            <a href="/nonBoard/replyForm?bno=${nonMemVo.bno}" role="button" class="btn btn-dark">수정</a>
        </form>
        
        
				
				</div>
				<div class="col-md-3">
				</div>
			</div>
		</div>
	</div>


</body>
</html>