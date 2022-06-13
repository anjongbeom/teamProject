<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script>
$(document).ready(function() {
	
	
	
	
	
});
	

function passConfirm() {
/* 비밀번호, 비밀번호 확인 입력창에 입력된 값을 비교해서 같다면 비밀번호 일치, 그렇지 않으면 불일치 라는 텍스트 출력.*/
	var member_pw = document.getElementById('member_pw');					//비밀번호 
	var member_pw2 = document.getElementById('member_pw2');	//비밀번호 확인 값
	var confrimMsg = document.getElementById('confirmMsg');				//확인 메세지
	var correctColor = "#00ff00";	//맞았을 때 출력되는 색깔.
	var wrongColor ="#ff0000";	//틀렸을 때 출력되는 색깔
	
	if(password.value == passwordConfirm.value){//password 변수의 값과 passwordConfirm 변수의 값과 동일하다.
		confirmMsg.style.color = correctColor;/* span 태그의 ID(confirmMsg) 사용  */
		confirmMsg.innerHTML ="비밀번호 일치";/* innerHTML : HTML 내부에 추가적인 내용을 넣을 때 사용하는 것. */
	}else{
		confirmMsg.style.color = wrongColor;
		confirmMsg.innerHTML ="비밀번호 불일치";
	}
}


</script>


<!-- 경로 action="/member/join_run"  -->

<!-- 헤더 -->
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>KA주류교육원</title>
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
                <a class="navbar-brand" href="http://localhost">KA 주류교육원</a>
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
                                <li><a class="dropdown-item" href="/product/brandyList">Brandy</a></li>
                                <li><a class="dropdown-item" href="/product/whiskyList">Scotch Whisky</a></li>
                                <li><a class="dropdown-item" href="/product/beerList">Beer</a></li>
                                <li><a class="dropdown-item" href="/product/traditionalList">Traditional liquor</a></li>
                            </ul>
                        </li>
                    </ul>
                    <form class="d-flex">
                    	<!-- 장바구니 -->
                        <button class="btn btn-outline-dark" type="submit">
                            <i class="bi-cart-fill me-1"></i>
                            Cart
                            <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
                        </button>
                        <!-- 알림 기능 예약 메세지 -->
                        <button id="m" class="btn btn-outline-dark" type="submit" style="margin-left: 5px;">
                        	<i class="bi bi-clock"></i>
 							Alert
                        	<span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
                        </button>
                        <!-- 로그인 -->
                        <button id="" class="btn btn-outline-dark" type="submit" style="margin-left: 5px;">
                        	<i class="bi bi-door-open"></i>
 							Login
                        	<span class="badge bg-dark text-white ms-1 rounded-pill"></span>
                        </button>
                        
                        <!-- 회원가입 -->
                         <button id="" class="btn btn-outline-dark" type="submit" style="margin-left: 5px;">
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
                    <p class="lead fw-normal text-white-50 mb-0"> KA와 함께 해주세요</p>
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
					<form role="form" action="/member/join_run" method="post">
					
						<div class="form-group">
							<label for="member_id">
								아이디
							</label>
							<input type="text" class="form-control" id="member_id" />
						</div>
						
						<div class="form-group">
							<label for="member_pw">
								비밀번호
							</label>
							<input type="password" class="form-control" id="member_pw" onchange="passConfirm()"/>
						</div>
						
						<div class="form-group">
							<label for="member_pw2">
								비밀번호 확인
							</label>
							<input type="password" class="form-control" id="member_pw2" onchange="passConfirm()"/>
						</div>
						
						
						<p id="confirmMsg">비번 확인</p>
						
						
						<div class="form-group">
							<label for="member_name">
								회원 이름
							</label>
							<input type="text" class="form-control" id="member_name" />
						</div>
						
						<div class="form-group">
							<label for="nickname">
								닉네임
							</label>
							<input type="text" class="form-control" id="nickname" />
						</div>
						
						
						<div class="form-group">
							<label for="email">
								이메일
							</label>
							<input type="email" class="form-control" id="email" />
						</div>
						
						<div class="form-group">
							<label for="favorite">
								선호 주류
							</label>
							<input type="text" class="form-control" id="favorite" />
						</div>
						
						<div class="form-group">
							<label for="address">
								주소
							</label>
							<input type="text" class="form-control" id="address" />
						</div>
						
						<div class="form-group">
							<label for="member_tel">
								전화번호
							</label>
							<input type="text" class="form-control" id="member_tel" />
						</div>
						
						
<!-- 						<div class="form-group"> -->
<!-- 							<label for="exampleInputFile"> -->
<!-- 								File input -->
<!-- 							</label> -->
<!-- 							<input type="file" class="form-control-file" id="exampleInputFile" /> -->
<!-- 							<p class="help-block"> -->
<!-- 								Example block-level help text here. -->
<!-- 							</p> -->
<!-- 						</div> -->
<!-- 						<div class="checkbox"> -->
<!-- 							<label> -->
<!-- 								<input type="checkbox" /> Check me out -->
<!-- 							</label> -->
<!-- 						</div>  -->
						
						
						<button type="submit" class="btn btn-primary">
							회원가입
						</button>
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


