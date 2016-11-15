<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<section class="header_text sub">
	<img class="pageBanner"
		src="${contextPath}/resource/themes/images/pageBanner.png"
		alt="New products">
	<h4>
		<span>Product Detail</span>
	</h4>
</section>
<section class="main-content">
	<div class="row">
		<div class="span9">
			<div class="row">
				<div class="span4">
					<a
						href="${contextPath}/resource/themes/images/ladies/${product_detail.image }"
						class="thumbnail" data-fancybox-group="group1"
						title="Description 1"><img alt=""
						src="${contextPath}/resource/themes/images/ladies/${product_detail.image }"></a>
					<ul class="thumbnails small">
						<c:forEach items="${imageEntities }" var="imageEntity">
							<li class="span1"><a
								href="${contextPath}/resource/themes/images/ladies/${imageEntity.image }"
								class="thumbnail" data-fancybox-group="group1"
								title="Description 2"><img
									src="${contextPath}/resource/themes/images/ladies/${imageEntity.image }"
									alt=""></a></li>
						</c:forEach>
					</ul>

				</div>
				<div class="span5">
					<address>
						<strong>Loại sản phẩm:</strong> <span>${product_detail.category.category }</span><br>
						<strong>Mã sản phẩm:</strong> <span>${product_detail.id}</span><br>
						<strong>Tình trạng:</strong> <span>Out Of Stock</span><br>
					</address>
					<h4>
						<strong>Giá: ${product_detail.price}</strong>
					</h4>
				</div>
				<div class="span5">
					<a
						href="${contextPath}/cart/addCart?product_id=${product_detail.id }"
						class="btn btn-inverse" type="submit">Add to cart</a>
				</div>
			</div>
			<div class="row">
				<div class="span9">
					<ul class="nav nav-tabs" id="myTab">
						<li class="active"><a href="#home">Description</a></li>
						<li class=""><a href="#profile">Additional Information</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="home">Sed ut perspiciatis
							unde omnis iste natus error sit voluptatem accusantium doloremque
							laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore
							veritatis et quasi architecto beatae vitae dicta sunt explicabo.
							Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit
							aut fugit, sed quia consequuntur magni dolores eos qui ratione
							voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem
							ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia
							non numquam eius modi tempora incidunt ut labore et dolore magnam
							aliquam quaerat voluptatem</div>
						<div class="tab-pane" id="profile">
							<table class="table table-striped shop_attributes">
								<tbody>
									<tr class="">
										<th>Size</th>
										<td>Large, Medium, Small, X-Large</td>
									</tr>
									<tr class="alt">
										<th>Colour</th>
										<td>Orange, Yellow</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="span9">
					<br>
					<h4 class="title">
						<span class="pull-left"><span class="text"><strong>Related</strong>
								Products</span></span> <span class="pull-right"> <a class="left button"
							href="#myCarousel-1" data-slide="prev"></a><a
							class="right button" href="#myCarousel-1" data-slide="next"></a>
						</span>
					</h4>
					<div id="myCarousel-1" class="carousel slide">
						<div class="carousel-inner">
							<div class="active item">
								<ul class="thumbnails listing-products">
									<c:forEach items="${products }" begin="0" end="2" var="product">
										<li class="span3">
											<div class="product-box">
												<span class="sale_tag"></span>
												<p>
													<a href="${contextPath }/product_detail/${product.id }"><img
														src="${contextPath}/resource/themes/images/ladies/${product.image }"
														alt="" /></a>
												</p>
												<a href="${contextPath }/product_detail/${product.id }"
													class="title">${product.name }</a><br /> <a
													href="${contextPath }/products" class="category">${product.description }</a>
												<p class="price">${product.price }</p>
											</div>
										</li>
									</c:forEach>
								</ul>
							</div>
							<div class="item">
								<ul class="thumbnails listing-products">
									<c:forEach items="${products }" begin="3" end="5" var="product">
										<li class="span3">
											<div class="product-box">
												<span class="sale_tag"></span>
												<p>
													<a href="${contextPath }/product_detail/${product.id }"><img
														src="${contextPath}/resource/themes/images/ladies/${product.image }"
														alt="" /></a>
												</p>
												<a href="${contextPath }/product_detail/${product.id }"
													class="title">${product.name }</a><br /> <a
													href="${contextPath }/products" class="category">${product.description }</a>
												<p class="price">${product.price }</p>
											</div>
										</li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
				</div>
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
							src="${contextPath}/resource/themes/images/ladies/1.jpg"
							alt="Praesent tempor sem sodales">
					</a> <a href="#">Praesent tempor sem</a></li>
					<li><a href="#" title="Luctus quam ultrices rutrum"> <img
							src="${contextPath}/resource/themes/images/ladies/2.jpg"
							alt="Luctus quam ultrices rutrum">
					</a> <a href="#">Luctus quam ultrices rutrum</a></li>
					<li><a href="#" title="Fusce id molestie massa"> <img
							src="${contextPath}/resource/themes/images/ladies/3.jpg"
							alt="Fusce id molestie massa">
					</a> <a href="#">Fusce id molestie massa</a></li>
				</ul>
			</div>
		</div>
	</div>
</section>