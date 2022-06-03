<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 콘텐츠 시작 { -->
<div id="wrapper">

	<div class="sub-visual01"></div>
	<!-- lnb -->
	
	<!-- LNB -->
	<div class="lnbWrap"></div>
	<!-- LNB //-->
	<!-- lnb //-->
	<div id="subContent">

		<!-- Contents -->
		<div class="contents">
			<div class="tit-sec">
				<h3>오시는길</h3>
				<div class="nav">
					Home > <span>오시는길</span>
				</div>
			</div>

			<article id="ctt" class="ctt_about_2">
				
				<div id="ctt_con">
					<!--         <iframe width="100%" height="450"  frameborder="0" allowfullscreen="" style="border: 0px currentColor; margin-bottom: 30px;"> -->
					<!-- 콘텐츠 지도 -->
					<div id="map" style="width: 100%; height: 450px;"></div>
					<script type="text/javascript"
						src="//dapi.kakao.com/v2/maps/sdk.js?appkey=92bf8ba0dec714bbb3b60c82fc679630"></script>

					<script>
						var container = document.getElementById('map');
						var options = {
							center : new kakao.maps.LatLng(35.53503864112339,
									129.31083878437238),
							level : 3
						};

						var map = new kakao.maps.Map(container, options);

						// 마커가 표시될 위치입니다 
						var markerPosition = new kakao.maps.LatLng(
								35.53503864112339, 129.31083878437238);

						// 마커를 생성합니다
						var marker = new kakao.maps.Marker({
							position : markerPosition,
							text : 'KA 주류교육원'
						});

						// 마커가 지도 위에 표시되도록 설정합니다
						marker.setMap(map);

						// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
						// marker.setMap(null);
					</script>
					<script type="text/javascript"
						src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services,clusterer,drawing"></script>
					<!-- // 콘텐츠 지도 -->

					<!-- </iframe><br> -->
					<div style="line-height: 22px;">
						<h3>최고의 명주를 찾고싶으시다면 KA주류교육원을 찾아주세요.</h3>
						주소 : 울산광역시 남구 삼산로35번길 19 KA주류교육원 <br> 전화번호 : 052-257-7600<br>
						이메일 : ajb5209@naver.com
					</div>
				</div>

			</article>
		</div>

	</div>
	<!-- } 콘텐츠 끝 -->
