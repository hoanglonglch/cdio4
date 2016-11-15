<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Bootstrap E-commerce Templates</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<!--[if ie]><meta content='IE=8' http-equiv='X-UA-Compatible'/><![endif]-->
<!-- bootstrap -->
<link href="${contextPath}/resource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resource/bootstrap/css/bootstrap-responsive.min.css"
	rel="stylesheet">

<link href="${contextPath}/resource/themes/css/bootstrappage.css" rel="stylesheet" />

<!-- global styles -->
<link href="${contextPath}/resource/themes/css/flexslider.css" rel="stylesheet" />
<link href="${contextPath}/resource/themes/css/jquery.fancybox.css" rel="stylesheet" />
<link href="${contextPath}/resource/themes/css/main.css" rel="stylesheet" />

<!-- scripts -->
<script src="${contextPath}/resource/themes/js/jquery-1.7.2.min.js"></script>
<script src="${contextPath}/resource/bootstrap/js/bootstrap.min.js"></script>
<script src="${contextPath}/resource/themes/js/jquery.fancybox.js"></script>
<script src="${contextPath}/resource/themes/js/superfish.js"></script>
<script src="${contextPath}/resource/themes/js/jquery.scrolltotop.js"></script>

</head>
<body>
	<tiles:insertAttribute name="topbar" />
	<div id="wrapper" class="container">
		<tiles:insertAttribute name="mainmenu" />
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />
	</div>
	<script src="${contextPath}/resource/themes/js/common.js"></script>
	<script src="${contextPath}/resource/themes/js/jquery.flexslider-min.js"></script>
	<script type="text/javascript">
		$(function() {
			$(document).ready(function() {
				$('.flexslider').flexslider({
					animation : "fade",
					slideshowSpeed : 4000,
					animationSpeed : 600,
					controlNav : false,
					directionNav : true,
					controlsContainer : ".flex-container" // the container that holds the flexslider
				});
			});
		});
	</script>
	<script>
		$(function() {
			$('#myTab a:first').tab('show');
			$('#myTab a').click(function(e) {
				e.preventDefault();
				$(this).tab('show');
			})
		})
		$(document).ready(function() {
			$('.thumbnail').fancybox({
				openEffect : 'none',
				closeEffect : 'none'
			});

			$('#myCarousel-2').carousel({
				interval : 2500
			});
		});
	</script>
</body>
</html>

