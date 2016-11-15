<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<section class="navbar main-menu">
	<div class="navbar-inner main-menu">
		<a href="${contextPath }/home" class="logo pull-left"><img
			src="${contextPath }/resource/themes/images/logo.png" class="site_logo" alt=""></a>
		<nav id="menu" class="pull-right">
			<ul> 
				<c:forEach items="${parent}" var="listParent">
					<li><a href="${contextPath }/productsByParent/${listParent.id }">${listParent.parent }</a>
						<ul>
							<c:forEach items="${listParent.categories}" var="listCategory">
								<li><a href="${contextPath }/productsByCategory/${listCategory.id }">${listCategory.category }</a></li>
							</c:forEach>
						</ul>
					</li>
				</c:forEach>
			</ul>
		</nav>
	</div>
</section>