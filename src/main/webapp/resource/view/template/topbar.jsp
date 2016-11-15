<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div id="top-bar" class="container">
	<div class="row">
		<div class="span4">
			<form method="POST" class="search_form">
				<input type="text" class="input-block-level search-query"
					Placeholder="eg. T-sirt">
			</form>
		</div>
		<div class="span8">
			<div class="account pull-right">
				<ul class="user-menu">
					<li><a href="${contextPath }/cart">Your Cart</a></li>
					<li><a href="${contextPath }/checkout">Checkout</a></li>
					<c:if test="${pageContext.request.userPrincipal.name == null}">
						<li><a href="${contextPath }/login">Login/Register</a></li>
					</c:if>
					<c:if test="${pageContext.request.userPrincipal.name != null}">
						<span>Hello, ${pageContext.request.userPrincipal.name}</span>
						<li><a href="${contextPath }/logout">Logout</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</div>