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
<title>게시글등록</title>
</head>
<body>
<h1>게시글 등록</h1>

<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-3">
				</div>
				<div class="col-md-6">
				
				<form action="/nonBoard/insertWrite" method="post">
            <div class="form-group">
                <label for="title">제목</label>
                <input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력하세요">
            </div>
            <div class="form-group">
                <label for="writer"> 작성자 </label>
                <input type="text" class="form-control" id="writer" name="writer" placeholder="작성자를 입력하세요">
            </div>
            <div class="form-group">
                <label for="email"> 이메일 </label>
                <input type="email" class="form-control" id="email" name="email" placeholder="이메일를을입력하세요" required>
            </div>
            <div class="form-group">
                <label for="content"> 내용 </label>
                <textarea class="form-control" id="content" name="content" placeholder="내용을 입력하세요"></textarea>
            </div>
              <div class="form-group">
                <label for="pwd"> 비밀번호 </label>
                <input type="password" class="form-control" id="pwd" name="pwd" placeholder="비밀번호를 입력하세요">
            </div>
            
<!--             <input type="hidden" name="re_level" value="0"> -->
<!--             <input type="hidden" name="readcount" value="0"> -->
            <input type="hidden" name="re_step" value="0">
            
            <input type="submit" class="btn btn-primary" id="btn-save" value="등록">
            <a href="/nonBoard/list" role="button" class="btn btn-secondary">취소</a>
        </form>
        
        
				
				</div>
				<div class="col-md-3">
				</div>
			</div>
		</div>
	</div>
</body>
</html>