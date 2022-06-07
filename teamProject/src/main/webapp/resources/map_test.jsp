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
					
					
						<!-- Footer-->
        
					
				</div>

			</article>
		</div>

	</div>
	<footer class="footer text-center">
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
	<!-- } 콘텐츠 끝 -->
