<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/include/manager_header.jsp"%>      


<!-- 데이트피커 -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">


<script>

$(document).ready(function() {
	
	$("#bandate").datepicker({
		dateFormat: 'yy/mm/dd', //날짜 표시 형식 설정                
		showOtherMonths: true, //이전 달과 다음 달 날짜를 표시              
		showMonthAfterYear:true, //연도 표시 후 달 표시               
		changeYear: true, //연도 선택 콤보박스               
		changeMonth: true, //월 선택 콤보박스                               
		showOn: "both", //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시                 
		yearSuffix: "년", //연도 뒤에 나오는 텍스트 지정                
		monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],                 
		monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],                
		dayNamesMin: ['일','월','화','수','목','금','토'],                 
		dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'],                
		minDate: "-1M", // -1D:하루전, -1M:한달전, -1Y:일년전                
		maxDate: "+1M", // +1D:하루후, -1M:한달후, -1Y:일년후                
// 		buttonImage: "image/calendar.gif", //버튼에 띄워줄 이미지 경로                
// 		buttonImageOnly: true, //디폴트 버튼 대신 이미지 띄워줌                
// 		buttonText: "선택", //버튼 마우스오버 시 보이는 텍스트               
	});
	
});
</script>


<div class="container-fluid px-4">
	<div class="row">
		<div class="col-md-7">
		
		
		<h2>멤버 정보(member_info_form)</h2>
		<form action="/manager/memberModifyRun" method="get">
			<table class="table">
				<tr>
					<td><label for="MEMBER_ID">멤버 아이디(MEMBER_ID)</label><td>
					<td><input type="text" class="form-control" 
						id="member_id" name="member_id" value="${memberVo.member_id}"
						 style="width:100%;"><td>
				</tr>
				<tr>
					<td><label>멤버 비밀번호(MEMBER_PW)</label><td>
					<td><input type="text" class="form-control" value="${memberVo.member_pw}"
						id="member_pw" name="member_pw"><td>
				</tr>
			
				<tr>
					<td><label>멤버 이름(MEMBER_NAME)</label><td>
					<td><input type="text" class="form-control" value="${memberVo.member_name}"
						id="member_name" name="member_name"><td>
				</tr>
			
				<tr>
					<td><label>닉네임(NICKNAME)</label><td>
					<td><input type="text" class="form-control" value="${memberVo.nickname}"
						id="nickname" name="nickname"><td>
				</tr>
		
				<tr>
					<td><label>이메일(EMAIL)</label><td>
					<td><input type="text" class="form-control" value="${memberVo.email}"
						id="email" name="email"><td>
				</tr>
			
				<tr>
					<td><label>선호주류(FAVORITE)</label><td>
					<td><input type="text" class="form-control" value="${memberVo.favorite}"
						id="favorite" name="favorite"><td>
				</tr>
		
				<tr>
					<td><label>등록일(REGDATE)</label><td>
					<td><input type="text" class="form-control" value="${memberVo.regdate}"
						id="regdate" ><td>
				</tr>
			
				<tr>
					<td><label>수정일(UPDATEDATE)</label><td>
					<td><input type="text" class="form-control" value="${memberVo.updatedate}"
						id="updatedate" ><td>
				</tr>
			
				<tr>
					<td><label>주소(ADDRESS)</label><td>
					<td><input type="text" class="form-control" value="${memberVo.address}"
						id="address" name="address"><td>
				</tr>
			
				<tr>
					<td><label>전화번호(MEMBER_TEL)</label><td>
					<td><input type="text" class="form-control" value="${memberVo.member_tel}"
						id="member_tel" name="member_tel"><td>
				</tr>
			
				<tr>
					<td><label>보유 포인트(MEMBER_POINT)</label><td>
					<td><input type="text" class="form-control" value="${memberVo.member_point}"
						id="member_point" name="member_point"><td>
				</tr>
			
				<tr>
					<td><label>정지기간(BANDATE)</label><td>
					<td>
						<input type="text" id="bandate" class="form-control col-xs-12" />
					<td>
				</tr>
			
				<tr>
					<td colspan="2"><button type="submit" class="btn btn-primary"
							>수정</button></td>
				</tr>
			</table>
		</form>	
			
		</div> <!-- col-md-12 -->
		<div class="col-md-5"></div>
	</div>
</div>


<%@ include file="/WEB-INF/views/include/manager_footer.jsp"%>      