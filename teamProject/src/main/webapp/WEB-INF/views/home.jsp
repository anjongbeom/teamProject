<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
 <style>
  /* Make the image fully responsive */
  .carousel-inner img {
    width: 100%;
    height: 100%;
  } 
  </style>
  <style>
  .divpop {
      position: relative; z-index:999; top:-60px; left:auto; margin: auto;
      width:350px; height:525px; border:20px solid #BDBDBD;background-color:#fff;display:none;
  }
  .title_area {font-weight:bold;text-align:center;width:100%}
  .button_area {position:absolute;bottom:0;left:10px;} 
</style>
  
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>KA주류 교육원에 방문하신걸 환영합니다.</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="/resources/main/images/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Simple line icons-->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.5.5/css/simple-line-icons.min.css" rel="stylesheet" />
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="/resources/css/main_styles.css" rel="stylesheet" />
		
		
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
	  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
	  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	  <script language="javascript" src="/resources/js/pop_up.js"></script>
	  
	  <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
	  <script src="/resources/js/openWin.js"></script>
    </head>
    <body id="page-top">
   
     
        <!-- Navigation-->
        <a class="menu-toggle rounded" href="#"><i class="fas fa-bars"></i></a>
        <nav id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand"><a href="#page-top">KA주류교육원</a></li>
                <li class="sidebar-nav-item"><a href="#page-top">Home</a></li>
                <li class="sidebar-nav-item"><a href="#portfolio">주류 상세 페이지</a></li>
                <li class="sidebar-nav-item"><a href="#contact">오시는길</a></li>
                <li class="sidebar-nav-item"><a href="/board/list">게시판</a></li>
                <li class="sidebar-nav-item"><a href="/member/loginForm">로그인</a></li>
                <li class="sidebar-nav-item"><a href=/member/joinForm>회원가입</a></li>
            </ul>
        </nav>
       <div id="demo" class="carousel slide" data-ride="carousel">
		  <!-- Indicators -->
		  <ul class="carousel-indicators">
		    <li data-target="#demo" data-slide-to="0" class="active"></li>
		    <li data-target="#demo" data-slide-to="1"></li>
		    <li data-target="#demo" data-slide-to="2"></li>
		  </ul>
		  
		  <!-- The slideshow -->
		  <div class="carousel-inner">
		  
	
		    <div class="carousel-item active">
		      <img src="/resources/images/main/main1.png" alt="Los Angeles" width="100%" height="auto">
		    </div>
		    <div class="carousel-item">
		      <img src="/resources/images/main/main2.png" alt="Chicago" width="100%" height="auto">
		    </div>
		    <div class="carousel-item">
		      <img src="/resources/images/main/main3.png" alt="New York" width="100%" height="auto">
		    </div>
		    
		  </div>
	
		  <!-- Left and right controls -->
		  <a class="carousel-control-prev" href="#demo" data-slide="prev">
		    <span class="carousel-control-prev-icon"></span>
		  </a>
		  <a class="carousel-control-next" href="#demo" data-slide="next">
		    <span class="carousel-control-next-icon"></span>
		  </a>
		</div>
        <!-- 헤더 수정 -->
        
        
         <!-- Portfolio-->
        <section class="content-section" id="portfolio">
        	  <!-- 팝업 -->
     <a href = "javascript:popup()" target = "blank"></a>
     <!-- <body onload="openwindow('/resources/popup/pop.jsp', 450, 600)"> -->
     
     
     
	<form name="notice_form">
	<div id="divpop1" class="divpop"> 
	<div id="link" style="text-align: center; font-size: 28px;">
		<a href="/product/detail?product_id=${productVo.product_id}" 
			target="_blank"  style="text-decoration: none; color: #E9330F;" 
			onmouseover="this.style.color='orange';" 
			onmouseout="this.style.color='#E9330F';">오늘의 추천 주류는?</a>
	</div>
	<br>
	
	<a href="/product/detail?product_id=${productVo.product_id}" 
	target="_blank">
		<img class="card-img-top" src="/product/displayImage?filename=${productVo.product_image}" alt="..." 
				style="display: block; margin: 0 auto; " width="250" height="328"/>
	</a>
	
	<br>
	<div style="text-align: center; font-size: 20px;">
		${productVo.product_name}
<%-- 		<a href="/product/detail?product_id=${productVo.product_id}"  --%>
<%-- 			target="_blank">${productVo.product_name}</a> --%>
	</div>
         <div class="button_area">
             <input type='checkbox' name='chkbox' id='todaycloseyn' value='Y'>오늘 하루 이 창을 열지 않음    
             <a href='#' onclick="javascript:closeWin(1);" onclick="window.close();"><B style="float: right; margin-left: 40px;">[닫기]</B></a>
         </div>
    </div>
</form>
     
     <!-- 팝업 -->
        
            <div class="container px-4 px-lg-5">
                <div class="content-section-heading text-center">
                    <h3 class="text-secondary mb-0">주류를 더보시려면</h3>
                    <h2 class="mb-5"><a href="/product/list" style="color: #F2CB11;">모든 주류 보기</a></h2>
                </div>
                <div class="row gx-0">
                <c:forEach items="${sessionScope.cateList}" var="productCate">
                	<div class="col-lg-6">
                        <a class="portfolio-item" href="/product/list?cate_code=${productCate.cate_code}">
                            <div class="caption">
                                <div class="caption-content">
                                    <div class="h1">${productCate.cate_type}</div>
                                    <p class="mb-0 h2">${productCate.cate_desc}</p>
                                </div>
                            </div>
                            <img class="img-fluid" src="/resources/images/main/${productCate.cate_image}" alt="..." />
                        </a>
                    </div>
                 </c:forEach>
<!--                     <div class="col-lg-6"> -->
<!--                         <a class="portfolio-item" href="/product/list?cate_code=a"> -->
<!--                             <div class="caption"> -->
<!--                                 <div class="caption-content"> -->
<!--                                     <div class="h1">브랜디</div> -->
<!--                                     <p class="mb-0 h2">과일의 발효액을 증류시켜 숙성시킨 것입니다!</p> -->
<!--                                 </div> -->
<!--                             </div> -->
<!--                             <img class="img-fluid" src="/resources/images/main/brandy.jpg" alt="..." /> -->
<!--                         </a> -->
<!--                     </div> -->
<!--                     <div class="col-lg-6"> -->
<!--                         <a class="portfolio-item" href="/product/list?cate_code=b"> -->
<!--                             <div class="caption"> -->
<!--                                 <div class="caption-content"> -->
<!--                                     <div class="h1">스카치 위스키</div> -->
<!--                                     <p class="mb-0 h2">스코틀랜드에서 증류되고 숙성된 위스키입니다!</p> -->
<!--                                 </div> -->
<!--                             </div> -->
<!--                             <img class="img-fluid" src="/resources/images/main/scotch_whisky.jpg" alt="..." /> -->
<!--                         </a> -->
<!--                     </div> -->
<!--                     <div class="col-lg-6"> -->
<!--                         <a class="portfolio-item" href="/product/list?cate_code=c"> -->
<!--                             <div class="caption"> -->
<!--                                 <div class="caption-content"> -->
<!--                                     <div class="h1">맥 주</div> -->
<!--                                     <p class="mb-0 h2">보리를 가공한 맥아를 발효시키고 이를 주재료로 향신료인 홉을 첨가하여 맛을 낸 술입니다!</p> -->
<!--                                 </div> -->
<!--                             </div> -->
<!--                             <img class="img-fluid" src="/resources/images/main/beer.jpg" alt="..." /> -->
<!--                         </a> -->
<!--                     </div> -->
<!--                     <div class="col-lg-6"> -->
<!--                         <a class="portfolio-item" href="/product/list?cate_code=d"> -->
<!--                             <div class="caption"> -->
<!--                                 <div class="caption-content"> -->
<!--                                     <div class="h1">전통주</div> -->
<!--                                     <p class="mb-0 h2">한국의 전통 주류 문화에 속하는 술입니다!</p> -->
<!--                                 </div> -->
<!--                             </div> -->
<!--                             <img class="img-fluid" src="/resources/images/main/makgeolli.jpg" alt="..." /> -->
<!--                         </a> -->
<!--                     </div> -->
                </div>
            </div>
        </section> 
        
        <!-- Map 살릴시 사이드 바 이용 안됨 추후 수정 요망-->
        <div class="map" id="contact">
        <div class="tit-sec text-center">
				<h2>오시는길</h2><br>
				
			</div>
        <iframe src="/resources/map_test.jsp" width="100%" height="450px"></iframe>
        </div> 
        <!-- Footer-->
        <footer class="footer text-center">
        	<div class="text-center" style="line-height: 22px;">
						<br><h3>KA주류교육원을 찾아주세요.</h3>
						<p>주소 : 울산광역시 남구 삼산로35번길 19 KA주류교육원 </p>
						<p>전화번호 : 052-257-7600</p>
						<p>이메일 : ajb5209@naver.com</p>
			</div>
            <div class="container px-4 px-lg-5">
                <ul class="list-inline mb-5">
                    <li class="list-inline-item">
                        <a class="social-link rounded-circle text-white mr-3" href="https://www.facebook.com/"><i class="icon-social-facebook"></i></a>
                    </li>
                    <li class="list-inline-item">
                        <a class="social-link rounded-circle text-white mr-3" href="https://twitter.com/"><i class="icon-social-twitter"></i></a>
                    </li>
                    <li class="list-inline-item">
                        <a class="social-link rounded-circle text-white" href="https://github.com/anjongbeom"><i class="icon-social-github"></i></a>
                    </li>
                </ul>
                <p class="text-muted small mb-0">Copyright &copy; Alcohol & Liquor Website 2022</p>
            </div>
            
        </footer>
        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top"><i class="fas fa-angle-up"></i></a>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->

        <script src="/resources/js/main_scripts.js"></script>
    </body>
</html>
