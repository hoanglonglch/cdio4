<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="navbar main-menu">
	<div class="navbar-inner main-menu">
		<a href="home" class="logo pull-left"><img
			src="resources/themes/images/logo.png" class="site_logo" alt=""></a>
		<nav id="menu" class="pull-right">
			<ul> 
				<c:choose items = "${parent}" var="listParent"></c:choose>
				<c:forEach items="${parent}" var="listParent">
					<li><a href="products">${listParent.parent }</a>
						<ul>
							<c:forEach items="${listParent.categories}" var="listCategory">
								<li><a href="products">${listCategory.category }</a></li>
							</c:forEach>
						</ul>
					</li>
				</c:forEach>
			</ul>
		</nav>
	</div>
</section>