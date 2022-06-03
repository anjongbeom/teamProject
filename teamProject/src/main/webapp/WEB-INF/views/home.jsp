<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/include/header.jsp" %>



<div id="wrapper">
    
    		
<div id="mainVisual_wrap">
<!-- visual_wrap -->
<div class="main_visual">
    		<div id="slideshow">
				<ul id="slides">
					<li class="main1">
                    	
                  </li>
					<li class="main2">
                    	
                  </li>
                  <li class="main3">
                    	
                  </li>
				</ul>
			</div>
        	<ul id="pagination" class="pagination">
				<li onClick="slideshow.pos(0)"></li>
				<li onClick="slideshow.pos(1)"></li>
                <li onClick="slideshow.pos(2)"></li>
			</ul>
</div>
<script type="text/javascript">
var slideshow=new TINY.fader.fade('slideshow',{
	id:'slides',
	auto:4,
	resume:true,
	navid:'pagination',
	activeclass:'current',
	visible:true,
	position:0
});
</script>
</div>
<!-- //visual_wrap -->
</div>
<style>
.btn-ele{display:none;}
@media (max-width: 479px) {
.btn-ele{width:100%; background:#8e1235; padding:5px; display:inline-block}
.btn-pages { width:100%; }
 .btn-pages li  a{ width:25%;float:left; padding: 12px 5px; border: 1px solid #8e1235; font-size: 13px; text-align: center;   background:#fff; color:#000;  height:40px;  }
  
 
 .btn-pages li a:hover { background: #000;color:#fff }
}
.page-header h1 {
	margin-left: 50px;
}
</style>


<div class="lnbWrap">
				
				            
                    
</div>
			
        <div id="mainContent">
            
            <div class="container-fluid">
            <div class="page-header">
				<h1>위스키</h1>
			</div>
	<div class="row" id="g">
		<div class="col-md-12">
			<div class="row" id="gnb">
				<ul>
					<li><img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" /></li>
					<li><img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" /></li>
					<li><img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" /></li>
					<li><img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" /></li>
				</ul>
				
			</div>
		</div>
	</div>
			<h2>
				Heading
			</h2>
			<p>
				Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
			</p>
			<p>
				<a class="btn" href="#">View details »</a>
			</p>
	</div>
</div>



  

<%@ include file="/WEB-INF/views/include/footer.jsp" %>
