<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/include/header.jsp"%>

<%-- ${memberVo} --%>

<div class="row">
	<div class="col-md-12">
		<table class="table">
			<tbody>
				<tr>
					<th>아이디</th>
					<th>${memberVo.userid}</th>
				</tr>
				<tr>
					<th>이름</th>
					<th>${memberVo.username}</th>
				</tr>
				<tr>
					<th>이메일</th>
					<th>${memberVo.email}</th>
				</tr>
				<tr>
					<th>가입일</th>
					<th>${memberVo.regdate}</th>
				</tr>
				<tr>
					<th>포인트</th>
					<th>${memberVo.m_point}</th>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<%@ include file="/WEB-INF/views/include/footer.jsp"%>