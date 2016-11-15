<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<section id="footer-bar">
	<div class="row">
		<div class="span3">
			<h4>Navigation</h4>
			<ul class="nav">
				<li><a href="${contextPath }/home">Homepage</a></li>
				<li><a href="${contextPath }/about">About Us</a></li>
				<li><a href="${contextPath }/contact">Contac Us</a></li>
				<li><a href="${contextPath }/cart">Your Cart</a></li>
				<li><a href="${contextPath }/login">Login</a></li>
			</ul>
		</div>
		<div class="span4">
			<h4>My Account</h4>
			<ul class="nav">
				<li><a href="#">My Account</a></li>
				<li><a href="#">Order History</a></li>
				<li><a href="#">Wish List</a></li>
				<li><a href="#">Newsletter</a></li>
			</ul>
		</div>
		<div class="span5">
			<p class="logo">
				<img src="${contextPath }/resource/themes/images/logo.png" class="site_logo"
					alt="">
			</p>
			<p>Lorem Ipsum is simply dummy text of the printing and
				typesetting industry. the Lorem Ipsum has been the industry's
				standard dummy text ever since the you.</p>
			<br /> <span class="social_icons"> <a class="facebook"
				href="https://www.facebook.com/toannxm.it">Facebook</a> <a class="twitter" href="#">Twitter</a> <a
				class="skype" href="#">Skype</a> <a class="vimeo" href="#">Vimeo</a>
			</span>
		</div>
	</div>
</section>