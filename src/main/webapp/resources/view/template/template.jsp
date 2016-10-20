<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Bootstrap E-commerce Templates</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<!--[if ie]><meta content='IE=8' http-equiv='X-UA-Compatible'/><![endif]-->
<!-- bootstrap -->
<link href="resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="resources/bootstrap/css/bootstrap-responsive.min.css"
	rel="stylesheet">

<link href="resources/themes/css/bootstrappage.css" rel="stylesheet" />

<!-- global styles -->
<link href="resources/themes/css/flexslider.css" rel="stylesheet" />
<link href="resources/themes/css/main.css" rel="stylesheet" />

<!-- scripts -->
<script src="resources/themes/js/jquery-1.7.2.min.js"></script>
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<script src="resources/themes/js/superfish.js"></script>
<script src="resources/themes/js/jquery.scrolltotop.js"></script>

</head>
<body>
	<tiles:insertAttribute name="topbar" />
	<div id="wrapper" class="container">
		<tiles:insertAttribute name="mainmenu" />
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />
	</div>
	<script src="resources/themes/js/common.js"></script>
	<script src="resources/themes/js/jquery.flexslider-min.js"></script>
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
</body>
</html>

