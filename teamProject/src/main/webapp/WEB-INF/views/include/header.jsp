<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 
<!doctype html>
<html lang="ko">
<head>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/common.css" type="text/css" />
<link rel="stylesheet" href="/resources/css/style.css" type="text/css" />
<link rel="stylesheet" href="/resources/css/style2.css">
<script src="/resources/js/tinyfader.js"></script>
<script type="text/javascript" src="/resources/js/tinyfader.js"></script>
<title>공지사항 1 페이지 | KA주류교육원</title>
<link rel="stylesheet" href="/resources/css/default.css">
<link rel="stylesheet" href="/resources/css/style3.css">
<!--[if lte IE 8]>
<script src="http://www.liquorstore21.co.kr/js/html5.js"></script>
<![endif]-->
<script>
// 자바스크립트에서 사용하는 전역변수 선언
var g5_url       = "/"; //추후 "/"
// var g5_bbs_url   = "http://www.liquorstore21.co.kr/bbs"; // 관리자 페이지 수정요함
var g5_is_member = "";
var g5_is_admin  = "";
var g5_is_mobile = "";
var g5_bo_table  = "community1";
var g5_sca       = "";
var g5_editor    = "smarteditor2";
var g5_cookie_domain = "";
</script>

<script src="/resources/js/jquery.menu.js"></script>
<script src="/resources/js/jquery.common.js"></script>
<script src="/resources/js/jquery.wrest.js"></script>
</head>
<body>

<!-- 상단 시작 { -->

<div id="hd">
    <h1 id="hd_h1">공지사항 1 페이지</h1>

    <div id="skip_to_container"><a href="#container">본문 바로가기</a></div>

    
    <div id="hd_wrapper">
	
       
    
	<div id="logo">
            <a href="/"><img src="/resources/images/kh_black.png" alt="KA주류교육원" width="358px" height="103px"></a>
    </div>
     <fieldset id="hd_sch">
            <legend>사이트 내 전체검색</legend>
       <form name="fsearchbox" method="get" action="http://www.liquorstore21.co.kr/bbs/search.php" onsubmit="return fsearchbox_submit(this);">
            <input type="hidden" name="sfl" value="wr_subject||wr_content">
            <input type="hidden" name="sop" value="and">
            <label for="sch_stx" class="sound_only">검색어<strong class="sound_only"> 필수</strong></label>
            <input type="text" name="stx" id="sch_stx" maxlength="20">
         <input type="image" id="sch_submit" value="검색" src="/resources/images/btn_search.png">
         </form>

            <script>
            function fsearchbox_submit(f)
            {
                if (f.stx.value.length < 2) {
                    alert("검색어는 두글자 이상 입력하십시오.");
                    f.stx.select();
                    f.stx.focus();
                    return false;
                }

                // 검색에 많은 부하가 걸리는 경우 이 주석을 제거하세요.
                var cnt = 0;
                for (var i=0; i<f.stx.value.length; i++) {
                    if (f.stx.value.charAt(i) == ' ')
                        cnt++;
                }

                if (cnt > 1) {
                    alert("빠른 검색을 위하여 검색어에 공백은 한개만 입력할 수 있습니다.");
                    f.stx.select();
                    f.stx.focus();
                    return false;
                }

                return true;
            }
            </script>
        </fieldset>
        
         <div id="tnb">
            <a href="#">로그인</a><a href="/member/joinPrev">회원가입</a><a href="#">즐겨찾기</a><a href="#">고객센터</a>
                    </div>
        
        </div>
    <div class="header">
	
    <nav id="gnb">
        <ul>
                        <li>
                <a href="#" target="_self" class="gnb_1da">위스키</a>
                            </li>
                        <li>
                <a href="#" target="_self" class="gnb_1da">소주</a>
                            </li>
                        <li>
                <a href="#" target="_self" class="gnb_1da">맥주</a>
                            </li>
                        <li>
                <a href="#" target="_self" class="gnb_1da">전통주</a>
                			</li>
                		 <li>
                <a href="#" target="_self" class="gnb_1da">음료</a>
                			</li>
            	
                        <li>
                <a href="#" target="_self" class="gnb_1da">선물세트</a>
                            </li>
                        <li>
                <a href="#" target="_self" class="gnb_1da">자유게시판</a>
            </li>
                    </ul>
    </nav>
    
    </div>
    <div id="mlogo">
            <a href="/"><img src="/resources/images/kh_black.png" alt="KA주류교육원" height="103px"></a>
    </div>
     
     
     <!-- mobile menu -->
     
    <!-- mobile menu -->
</div>

<!-- 콘텐츠 시작 { -->

   
    
            
        <!-- lnb -->
<!-- } 상단 끝 -->