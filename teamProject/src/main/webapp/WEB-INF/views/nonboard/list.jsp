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
<title>Insert title here</title>
</head>
<body>

${list}
<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-2">
				</div>
				<div class="col-md-8">
					<table class="table">
						<thead>
							<tr>
								<th></th>
								<th>글번호</th>
								<th>작성자</th>
								<th>글제목</th>
								<th>작성일</th>
								<th><a href="/nonBoard/writeForm" role="button" class="btn btn-primary">글쓰기</a></th>
							</tr>
							 
						</thead>
						
						<tbody>
								
							
								<c:forEach var="vo" items="${list}">
								<tr>
<!-- 								 bno,writer,title,reg_date,readcount -->
									<td></td>
									<td><a href="/nonBoard/modifyForm?bno=${vo.bno}">${vo.bno}</a></td>
									<td>${vo.writer}</td>
									<td style="padding-left:${vo.re_level * 20}px">
									<c:if test="${vo.re_level > 0}">
									ㄴ
									</c:if>
									${vo.title}
									
									</td>
									<td>${vo.reg_date}</td>
								</tr>
								
								</c:forEach>
							
						</tbody>
						
					</table>
				</div>
				<div class="col-md-2">
				</div>
			</div>
		</div>
	</div>
</body>
</html>