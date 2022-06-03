<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/include/header.jsp"%>





<!-- 콘텐츠 시작 { -->
<div id="wrapper">

	<div class="inner">
		<!-- 회원정보 입력/수정 시작 { -->
		<div class="mbskin">
			<h1>회원가입</h1>
			<script
				src="/resources/js/register_form.js"></script>

			<form id="fregisterform" name="fregisterform"
				action="http://www.liquorstore21.co.kr/bbs/register_form_update.php"
				onsubmit="return fregisterform_submit(this);" 
				method="post"
				enctype="multipart/form-data" autocomplete="off">
				<input type="hidden" name="w" value=""> 
				<input type="hidden" name="url" value="%2Fbbs%2Fregister_form.php"> 
					<input type="hidden" name="agree" value="1"> 
					<input type="hidden" name="agree2" value="1"> 
					<input type="hidden" name="cert_type" value=""> 
					<input type="hidden" name="cert_no" value=""> 
					<input type="hidden" name="mb_sex" value="">
				<div class="tbl_frm01 tbl_wrap">
					<table>
						<caption>사이트 이용정보 입력</caption>
						<tbody>
							<tr>
								<th scope="row"><label for="reg_mb_id">아이디<strong
										class="sound_only">필수</strong></label></th>
								<td>
									<p class="mobileview">아이디</p> <input type="text" name="mb_id"
									value="" id="reg_mb_id" required class="frm_input required "
									minlength="3" maxlength="20"> <span id="msg_mb_id"></span>
									<span class="frm_info">영문자, 숫자, _ 만 입력 가능. 최소 3자이상
										입력하세요.</span>
								</td>
							</tr>
							<tr>
								<th scope="row"><label for="reg_mb_password">비밀번호<strong
										class="sound_only">필수</strong></label></th>
								<td><p class="mobileview">비밀번호</p> <input type="password"
									name="mb_password" id="reg_mb_password" required
									class="frm_input required" minlength="3" maxlength="20"></td>
							</tr>
							<tr>
								<th scope="row"><label for="reg_mb_password_re">비밀번호
										확인<strong class="sound_only">필수</strong>
								</label></th>
								<td>
									<p class="mobileview">비밀번호 확인</p> <input type="password"
									name="mb_password_re" id="reg_mb_password_re" required
									class="frm_input required" minlength="3" maxlength="20">
								</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div class="tbl_frm01 tbl_wrap">
					<table>
						<caption>개인정보 입력</caption>
						<tbody>
							<tr>
								<th scope="row"><label for="reg_mb_name">이름<strong
										class="sound_only">필수</strong></label></th>
								<td><p class="mobileview">이름</p> <input type="text"
									id="reg_mb_name" name="mb_name" value="" required
									class="frm_input required " size="10"></td>
							</tr>
							<tr>
								<th scope="row"><label for="reg_mb_nick">닉네임<strong
										class="sound_only">필수</strong></label></th>
								<td><p class="mobileview">닉네임</p> <input type="hidden"
									name="mb_nick_default" value=""> <input type="text"
									name="mb_nick" value="" id="reg_mb_nick" required
									class="frm_input required nospace" size="10" maxlength="20">
									<span id="msg_mb_nick"></span> <span class="frm_info">
										공백없이 한글,영문,숫자만 입력 가능 (한글2자, 영문4자 이상)<br> 닉네임을 바꾸시면 앞으로
										60일 이내에는 변경 할 수 없습니다.
								</span></td>
							</tr>

							<tr>
								<th scope="row"><label for="reg_mb_email">E-mail<strong
										class="sound_only">필수</strong></label></th>
								<td><p class="mobileview">E-mail</p> <input type="hidden"
									name="old_email" value=""> <input type="text"
									name="mb_email" value="" id="reg_mb_email" required
									class="frm_input email required" maxlength="100"></td>
							</tr>


						</tbody>
					</table>
				</div>

				<!--  메일링 서비스 -->
				
				<!-- // 메일링 서비스 -->

				<div class="btn_confirm">
					<input type="submit" value="회원가입" id="btn_submit"
						class="btn_submit" accesskey="s"> <a
						href="http://www.liquorstore21.co.kr" class="btn_cancel">취소</a>
				</div>
			</form>

			<script>
				$(function() {
					$("#reg_zip_find").css("display", "inline-block");

				});

				// submit 최종 폼체크
				function fregisterform_submit(f) {
					// 회원아이디 검사
					if (f.w.value == "") {
						var msg = reg_mb_id_check();
						if (msg) {
							alert(msg);
							f.mb_id.select();
							return false;
						}
					}

					if (f.w.value == "") {
						if (f.mb_password.value.length < 3) {
							alert("비밀번호를 3글자 이상 입력하십시오.");
							f.mb_password.focus();
							return false;
						}
					}

					if (f.mb_password.value != f.mb_password_re.value) {
						alert("비밀번호가 같지 않습니다.");
						f.mb_password_re.focus();
						return false;
					}

					if (f.mb_password.value.length > 0) {
						if (f.mb_password_re.value.length < 3) {
							alert("비밀번호를 3글자 이상 입력하십시오.");
							f.mb_password_re.focus();
							return false;
						}
					}

					// 이름 검사
					if (f.w.value == "") {
						if (f.mb_name.value.length < 1) {
							alert("이름을 입력하십시오.");
							f.mb_name.focus();
							return false;
						}

						/*
						var pattern = /([^가-힣\x20])/i;
						if (pattern.test(f.mb_name.value)) {
						    alert("이름은 한글로 입력하십시오.");
						    f.mb_name.select();
						    return false;
						}
						 */
					}

					// 닉네임 검사
					if ((f.w.value == "")
							|| (f.w.value == "u" && f.mb_nick.defaultValue != f.mb_nick.value)) {
						var msg = reg_mb_nick_check();
						if (msg) {
							alert(msg);
							f.reg_mb_nick.select();
							return false;
						}
					}

					// E-mail 검사
					if ((f.w.value == "")
							|| (f.w.value == "u" && f.mb_email.defaultValue != f.mb_email.value)) {
						var msg = reg_mb_email_check();
						if (msg) {
							alert(msg);
							f.reg_mb_email.select();
							return false;
						}
					}

					if (typeof f.mb_icon != "undefined") {
						if (f.mb_icon.value) {
							if (!f.mb_icon.value.toLowerCase()
									.match(/.(gif)$/i)) {
								alert("회원아이콘이 gif 파일이 아닙니다.");
								f.mb_icon.focus();
								return false;
							}
						}
					}

					if (typeof (f.mb_recommend) != "undefined"
							&& f.mb_recommend.value) {
						if (f.mb_id.value == f.mb_recommend.value) {
							alert("본인을 추천할 수 없습니다.");
							f.mb_recommend.focus();
							return false;
						}

						var msg = reg_mb_recommend_check();
						if (msg) {
							alert(msg);
							f.mb_recommend.select();
							return false;
						}
					}

					if (!chk_captcha())
						return false;

					document.getElementById("btn_submit").disabled = "disabled";

					return true;
				}
			</script>
		</div>
	</div>
	<!-- } 회원정보 입력/수정 끝 -->
</div>

<!-- } 콘텐츠 끝 -->




<script>
	$(function() {
		// 폰트 리사이즈 쿠키있으면 실행
		font_resize("container", get_cookie("ck_font_resize_rmv_class"),
				get_cookie("ck_font_resize_add_class"));
	});
</script>



<!-- ie6,7에서 사이드뷰가 게시판 목록에서 아래 사이드뷰에 가려지는 현상 수정 -->
<!--[if lte IE 7]>
<script>
$(function() {
    var $sv_use = $(".sv_use");
    var count = $sv_use.length;

    $sv_use.each(function() {
        $(this).css("z-index", count);
        $(this).css("position", "relative");
        count = count - 1;
    });
});
</script>
<![endif]-->

</body>
</html>



<%@ include file="/WEB-INF/views/include/footer.jsp"%>
