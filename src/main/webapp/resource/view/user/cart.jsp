<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="cart" value="${sessionScope.cart}" />
<section class="header_text sub">
	<img class="pageBanner"
		src="${contextPath }/resource/themes/images/pageBanner.png"
		alt="New products">
	<h4>
		<span>Shopping Cart</span>
	</h4>
</section>
<section class="main-content">
	<div class="row">
		<div class="span9">
			<h4 class="title">
				<span class="text"><strong>Your</strong> Cart</span>
			</h4>
			<form action="${contextPath }/cart/update" method="POST">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Remove</th>
							<th>Image</th>
							<th>Product Name</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Total</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="listCart" items="${sessionScope.cartSession}">
							<tr>
								<td><a class="button"
									href="${contextPath }/cart/remove?product_id=${listCart.productEntity.id}">Xoá</a>
								<td><a
									href="${contextPath }/product_detail?${listCart.productEntity.id}"><img
										alt=""
										src="${contextPath }/resource/themes/images/ladies/${listCart.productEntity.image}"></a></td>
								<td>${listCart.productEntity.name }</td>
								<td><input name="quantity" type="text"
									value="${listCart.quantity}" class="input-mini"></td>
								<td>${listCart.productEntity.price}</td>
								<td>${listCart.productEntity.price * listCart.quantity}</td>
							</tr>
						</c:forEach>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td><strong>${sessionScope.total}</strong></td>
						</tr>
					</tbody>
				</table>
				<p class="buttons center">
					<input value="Update" class="btn" type="submit" /> <a
						href="${contextPath }/home" class="btn" type="button">Continue</a>
					<a href="${contextPath }/checkout" class="btn btn-inverse"
						type="submit" id="checkout">Checkout</a>
				</p>
			</form>
			<hr>
			<p class="cart-total right">
				<strong>Sub-Total</strong>: $100.00<br> <strong>Eco
					Tax (-2.00)</strong>: $2.00<br> <strong>VAT (17.5%)</strong>: $17.50<br>
				<strong>Total</strong>: $119.50<br>
			</p>
			<hr />
		</div>
		<div class="span3 col">
			<div class="block">
				<ul class="nav nav-list">
					<li class="nav-header">SUB CATEGORIES</li>
					<li><a href="${contextPath }/products">Nullam semper
							elementum</a></li>
					<li class="active"><a href="products">Phasellus ultricies</a></li>
					<li><a href="${contextPath }/products">Donec laoreet dui</a></li>
					<li><a href="${contextPath }/products">Nullam semper
							elementum</a></li>
					<li><a href="${contextPath }/products">Phasellus ultricies</a></li>
					<li><a href="${contextPath }/products">Donec laoreet dui</a></li>
				</ul>
				<br />
				<ul class="nav nav-list below">
					<li class="nav-header">MANUFACTURES</li>
					<li><a href="${contextPath }/products">Adidas</a></li>
					<li><a href="${contextPath }/products">Nike</a></li>
					<li><a href="${contextPath }/products">Dunlop</a></li>
					<li><a href="${contextPath }/products">Yamaha</a></li>
				</ul>
			</div>
			<div class="block">
				<h4 class="title">
					<span class="pull-left"><span class="text">Randomize</span></span>
					<span class="pull-right"> <a class="left button"
						href="#myCarousel" data-slide="prev"></a><a class="right button"
						href="#myCarousel" data-slide="next"></a>
					</span>
				</h4>
				<div id="myCarousel" class="carousel slide">
					<div class="carousel-inner">
						<div class="active item">
							<ul class="thumbnails listing-products">
								<li class="span3">
									<div class="product-box">
										<span class="sale_tag"></span> <a href="product_detail"><img
											alt=""
											src="${contextPath }/resource/themes/images/ladies/2.jpg"></a><br />
										<a href="${contextPath }/product_detail" class="title">Fusce
											id molestie massa</a><br /> <a href="#" class="category">Suspendisse
											aliquet</a>
										<p class="price">$261</p>
									</div>
								</li>
							</ul>
						</div>
						<div class="item">
							<ul class="thumbnails listing-products">
								<li class="span3">
									<div class="product-box">
										<a href="${contextPath }/product_detail"><img alt=""
											src="${contextPath }/resource/themes/images/ladies/4.jpg"></a><br />
										<a href="${contextPath }/product_detail" class="title">Tempor
											sem sodales</a><br /> <a href="#" class="category">Urna nec
											lectus mollis</a>
										<p class="price">$134</p>
									</div>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>