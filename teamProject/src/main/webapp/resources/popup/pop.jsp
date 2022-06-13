<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

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


</body>
</html>