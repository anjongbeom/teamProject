<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


<script src="/resources/js/member_script.js"></script>

<script>


$(document).ready(function() {
	var frm_join = document.getElementById("frm_join");
	
// 	var member_id_validity = "false";
	
	$("#btn_id_check").click(function() {
// 		member_id = document.getElementById("member_id").value;
// 		member_id_validity = idOverlap();
// 		console.log("member_id_validity: ", member_id_validity);
		
		var id_duplication = document.getElementById("id_duplication");
		var member_id = document.getElementById("member_id").value;
		
// 		console.log("id_duplication.value : ", id_duplication.attr("value"));
// 		id_duplication.attr("value", "id_checked");
		console.log("id_duplication : ", id_duplication); // value="id_unchecked"
		console.log("아이디 입력 값 : ", member_id);
		
		$.ajax({
			type :"post",
			url :"/member/idOverlap",
			data : {"member_id" : member_id},
//			JSON형식 안에 JSON 형식으로 표현한 데이터. 
//		    "파라미터 이름" : 폼태그에 적은 NAME 값.ID입력창의 NAME값.value 여러 개 가능 
//			dataType : "text",	/* text, xml, html, script, json, jsonp  
			success : function(rdata){	
				console.log("rdata: ", rdata);
				if(rdata == "null"){
					alert("이 아이디는 사용 가능합니다.");
					member_id_validity = "true";
				} else{	//ajax가 제대로 안됐을 때 .
					alert("이 아이디는 사용 불가능합니다.");
				}
			},
			error : function(){
				alert("아이디 중복 확인 ajax 실행 실패");
			}
		});
		
// 		console.log("member_id_validity: " , member_id_validity);
// 		console.log("document.frm_join.id_duplication.value: " , document.frm_join.id_duplication.value);
		
	});
	

	
});


</script>


<!-- 경로 action="/member/join_run"  -->
<!-- 테스트 -->
<!-- 헤더 -->
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>테이스팅 포 유</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="/resources/css/menu_styles.css" rel="stylesheet" />
    </head>
    
    
    <body>
    	
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="http://localhost">테이스팅 포 유</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="http://localhost/#portfolio">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="http://localhost/board/list">Board</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#!">주류 종류</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <c:forEach items="${sessionScope.cateList}" var="productCate">
                                	<li><a class="dropdown-item" href="/product/list?cate_code=${productCate.cate_code}">${productCate.cate_name}</a></li>
                                </c:forEach>
                            </ul>
                        </li>
                    </ul>
                    <form class="d-flex">
                    	<!-- 장바구니 -->
                        <button class="btn btn-outline-dark" type="submit">
                            <i class="bi-cart-fill me-1"></i>
                            Cart
                            <span class="badge bg-dark text-white ms-1 rounded-pill"></span>
                        </button>
                       
                        <!-- 로그인 -->
                        <button id="" 
                        
                        	<c:choose>
	                        	<c:when test="${loginVo != null || loginVo==''}">
	                        		class="btn btn-dark" 
	                        		onclick="location.href='/member/logout'"
	                        	</c:when>
	                        	<c:otherwise>
	                        		class="btn btn-outline-dark" 
	                        		onclick="location.href='/member/loginForm'"
	                        	</c:otherwise>
                        	</c:choose>
                       	 	type="button" style="margin-left: 5px;">
                        	<i class="bi bi-door-open"></i>
                        	
                        	<c:choose>
	                        	<c:when test="${loginVo != null || loginVo==''}">
	                        		Logout
	                        	</c:when>
	                        	<c:otherwise>
	                        		Login
	                        	</c:otherwise>
                        	</c:choose>
 							
                        	<span class="badge bg-dark text-white ms-1 rounded-pill"></span>
                        </button>
                        
                        <!-- 회원가입 -->
                         <button id="" class="btn btn-outline-dark" type="button" style="margin-left: 5px;">
                        	<i class="bi bi-people-fill"></i>
 							Sign Up
                        	<span class="badge bg-dark text-white ms-1 rounded-pill"></span>
                        </button>
                    </form>
                </div>
            </div>
        </nav>
        
        <!-- Header-->
        <header class="bg-dark py-5"> 
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                    <h1 class="display-4 fw-bolder">회원가입</h1>
                    <p class="lead fw-normal text-white-50 mb-0"> 테이스팅 포 유와 함께 해주세요</p>
                </div>
            </div>
        </header>
        
<!-- // 헤더 끝 -->



<!-- 수정중  -->
<!-- 콘텐츠 시작 { -->
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-2">
				</div>
				<div class="col-md-8">
					<form role="form" action="/member/join_run" method="post" enctype="multipart/form-data" id ="frm_join">
					<input type="hidden" id="id_duplication" name="id_duplication" value="id_uncheck">
						<br>
						<div class="form-group">
							<p style="color: red; float: right;">* 필수 입력</p>
						
							<label for="member_id">
								아이디
							</label>
							<span style="color: red;">*</span>
							<button class="btn btn-primary" type="button" id="btn_id_check" >중복 확인
							</button>
							<input type="text" class="form-control" id="member_id" name="member_id" value="" required/>
						</div>
						<!-- 아이디 유효성 & 중복체크 -->
						<p id="idValid"></p>
						
						<div class="form-group">
							<label for="member_pw">
								비밀번호
							</label>
							<span style="color: red;">*</span>
							<input type="password" class="form-control" id="member_pw" name="member_pw" 
								onchange="passConfirm()" required/>
						</div>
						<!-- 비밀번호 유효성 -->
						<p id="pwValid"></p>
						
						<div class="form-group">
							<label for="member_pw2">
								비밀번호 확인
							</label>
							<span style="color: red;">*</span>
							<input type="password" class="form-control" id="member_pw2" 
								onchange="passConfirm()" required/>
						</div>
						<!-- 비밀번호 일치여부 -->
						<p id="confirmMsg"></p>
						
						<div class="form-group">
							<label for="member_name">
								회원 이름
							</label>
							<span style="color: red;">*</span>
							<input type="text" class="form-control" id="member_name" name="member_name" required/>
						</div>
						<div class="form-group">
							<label for="nickname">
								닉네임
							</label>
							<span style="color: red;">*</span>
							<input type="text" class="form-control" id="nickname" name="nickname" required/>
						</div>
						
						
						<div class="form-group">
							<label for="email">
								이메일
							</label>
							<span style="color: red;">*</span>
							<input type="email" class="form-control" id="email" name="email" required/>
						</div>
						
						<div class="form-group">
							<label for="favorite">
								선호 주류
							</label>
							<input type="text" class="form-control" id="favorite" name="favorite"/>
						</div>
						
						<div class="form-group">
							<label for="address">
								주소
							</label>
							<span style="color: red;">*</span>
							<input type="text" class="form-control" id="address" name="address" required/>
						</div>
						
						<div class="form-group">
							<label for="member_tel">
								전화번호
							</label>
							<span style="color: red;">*</span>
							<input type="text" class="form-control" id="member_tel" name="member_tel" required/>
						</div>
						
						<div style="display:flex; justify-content: flex-end; align-items:center; padding-bottom: 10px">
							<button type="submit" class="btn btn-primary" id="btn_join">
								회원가입
							</button>
						</div>
						
					</form>
				</div>
				<div class="col-md-2">
				</div>
			</div>
		</div>
	</div>
</div>

<!-- } 콘텐츠 끝 -->


</body>
</html>


<%@ include file="/WEB-INF/views/include/footer.jsp"%>   


