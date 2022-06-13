<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="/resources/js/openWin.js"></script>
<style>
  .divpop {
      position: absolute; z-index:999; top:150px; left:500px;
      width:350px; height:500px; border:1px solid black;background-color:yellow;display:none;
  }
  .title_area {font-weight:bold;text-align:center;width:100%}
  .button_area {position:absolute;bottom:0;left:10px;} 
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <form name="notice_form">
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
		<a href="/product/detail?product_id=${productVo.product_id}" 
			target="_blank">${productVo.product_name}</a>
	</div>
         <div class="button_area">
             <input type='checkbox' name='chkbox' id='todaycloseyn' value='Y'>오늘 하루 이 창을 열지 않음    
             <a href='#' onclick="javascript:closeWin(1);" onclick="window.close();"><B>[닫기]</B></a>
         </div>
    </div>
</form> --%>

</body>
</html>