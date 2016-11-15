<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<section class="header_text sub">
	<img class="pageBanner" src="${contextPath }/resource/themes/images/pageBanner.png"
		alt="New products">
	<h4>
		<span>New products</span>
	</h4>
</section>
<section class="main-content">
	<div class="row">
		<div class="span9">
			<ul class="thumbnails listing-products">
				<c:forEach items="${products }" var="listProduct">
					<li class="span3">
						<div class="product-box">
							<span class="sale_tag"></span> <a href="${contextPath }/product_detail/${listProduct.id}"><img
								alt="" src="${contextPath }/resource/themes/images/ladies/${listProduct.image}"></a><br /> <a
								href="${contextPath }/product_detail/${listProduct.id}" class="title">${listProduct.name}</a>
								<br /> <a href="${contextPath }/productsByCategory/${listProduct.category.id}" class="category">${listProduct.category.category}</a>
							<p class="price">${listProduct.price}</p>
						</div>
					</li>
				</c:forEach>
			</ul>
			<hr>
			<div class="pagination pagination-small pagination-centered">
				<ul>
					<li><a href="#">Prev</a></li>
					<li class="active"><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">Next</a></li>
				</ul>
			</div>
		</div>
		<div class="span3 col">
			<div class="block">
				<ul class="nav nav-list">
					<li class="nav-header">SUB CATEGORIES</li>
					<c:forEach items="${parent}" var="listParent">
						<li><a
							href="${contextPath }/productsByParent/${listParent.id }"></a>
							<ul>
								<c:forEach items="${listParent.categories}" var="listCategory">
									<li><a
										href="${contextPath }/productsByCategory/${listCategory.id }">${listCategory.category }</a></li>
								</c:forEach>
							</ul></li>
					</c:forEach>
				</ul>
			</div>
			<div class="block">
				<h4 class="title">
					<strong>Best</strong> Seller
				</h4>
				<ul class="small-product">
					<li><a href="#" title="Praesent tempor sem sodales"> <img
							src="${contextPath }/resource/themes/images/ladies/3.jpg"
							alt="Praesent tempor sem sodales">
					</a> <a href="#">Praesent tempor sem</a></li>
					<li><a href="#" title="Luctus quam ultrices rutrum"> <img
							src="${contextPath }/resource/themes/images/ladies/4.jpg"
							alt="Luctus quam ultrices rutrum">
					</a> <a href="#">Luctus quam ultrices rutrum</a></li>
					<li><a href="#" title="Fusce id molestie massa"> <img
							src="${contextPath }/resource/themes/images/ladies/5.jpg" alt="Fusce id molestie massa">
					</a> <a href="#">Fusce id molestie massa</a></li>
				</ul>
			</div>
		</div>
	</div>
</section>