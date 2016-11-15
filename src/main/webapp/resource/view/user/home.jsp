<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<section class="main-content">
	<div class="row">
		<div class="span12">
			<div class="row">
				<div class="span12">
					<h4 class="title">
						<span class="pull-left"><span class="text"><span
								class="line">Feature <strong>Products</strong></span></span></span> <span
							class="pull-right"> <a class="left button"
							href="#myCarousel" data-slide="prev"></a><a class="right button"
							href="#myCarousel" data-slide="next"></a>
						</span>
					</h4>
					<div id="myCarousel" class="myCarousel carousel slide">
						<div class="carousel-inner">
							<div class="active item">
								<ul class="thumbnails">
									<c:forEach items="${productFeatures }" begin = "0" end = "3" var="productFeature">
										<li class="span3">
											<div class="product-box">
												<span class="sale_tag"></span>
												<p>
													<a href="${contextPath }/product_detail/${productFeature.id }"><img
														src="${contextPath}/resource/themes/images/ladies/${productFeature.image }" alt="" /></a>
												</p>
												<a href="${contextPath }/product_detail/${productFeature.id }" class="title">${productFeature.name }</a><br />
												<a href="${contextPath }/productsByCategory/${productFeature.category.id}" class="category">${productFeature.category.category }</a>
												<p class="price">${productFeature.price }</p>
											</div>
										</li>
									</c:forEach>
								</ul>
							</div>
							<div class="item">
								<ul class="thumbnails">
									<c:forEach items="${productFeatures }" begin = "4" end = "7" var="productFeature">
										<li class="span3">
											<div class="product-box">
												<span class="sale_tag"></span>
												<p>
													<a href="${contextPath }/product_detail/${productLatest.id }"><img
														src="${contextPath}/resource/themes/images/ladies/${productFeature.image }" alt="" /></a>
												</p>
												<a href="${contextPath }/product_detail/${productFeature.id }" class="title">${productFeature.name }</a><br />
												<a href="${contextPath }/productsByCategory/${productFeature.category.id}" class="category">${productFeature.category.category }</a>
												<p class="price">${productFeature.price }</p>
											</div>
										</li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="span12">
					<h4 class="title">
						<span class="pull-left"><span class="text"><span
								class="line">Latest <strong>Products</strong></span></span></span> <span
							class="pull-right"> <a class="left button"
							href="#myCarousel-2" data-slide="prev"></a><a
							class="right button" href="#myCarousel-2" data-slide="next"></a>
						</span>
					</h4>
					<div id="myCarousel-2" class="myCarousel carousel slide">
						<div class="carousel-inner">
							<div class="active item">
								<ul class="thumbnails">
									<c:forEach items="${productLatests }" begin = "0" end = "3" var="productLatest">
										<li class="span3">
											<div class="product-box">
												<span class="sale_tag"></span>
												<p>
													<a href="${contextPath }/product_detail/${productLatest.id }"><img
														src="${contextPath}/resource/themes/images/ladies/${productLatest.image }" alt="" /></a>
												</p>
												<a href="${contextPath }/product_detail/${productLatest.id }" class="title">${productLatest.name }</a><br />
												<a href="${contextPath }/productsByCategory/${productLatest.category.id}" class="category">${productLatest.category.category }</a>
												<p class="price">${productLatest.price }</p>
											</div>
										</li>
									</c:forEach>
								</ul>
							</div>
							<div class="item">
								<ul class="thumbnails">
									<c:forEach items="${productLatests }" begin = "4" end = "7" var="productLatest">
										<li class="span3">
											<div class="product-box">
												<span class="sale_tag"></span>
												<p>
													<a href="${contextPath }/product_detail/${productLatest.id }"><img
														src="${contextPath}/resource/themes/images/ladies/${productLatest.image }" alt="" /></a>
												</p>
												<a href="${contextPath }/product_detail/${productLatest.id }" class="title">${productLatest.name }</a><br />
												<a href="${contextPath }/productsByCategory/${productLatest.category.id}" class="category">${productLatest.category.category }</a>
												<p class="price">${productLatest.price }</p>
											</div>
										</li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row feature_box">
				<div class="span4">
					<div class="service">
						<div class="responsive">
							<img src="${contextPath}/resource/themes/images/feature_img_2.png" alt="" />
							<h4>
								MODERN <strong>DESIGN</strong>
							</h4>
							<p>Lorem Ipsum is simply dummy text of the printing and
								printing industry unknown printer.</p>
						</div>
					</div>
				</div>
				<div class="span4">
					<div class="service">
						<div class="customize">
							<img src="${contextPath}/resource/themes/images/feature_img_1.png" alt="" />
							<h4>
								FREE <strong>SHIPPING</strong>
							</h4>
							<p>Lorem Ipsum is simply dummy text of the printing and
								printing industry unknown printer.</p>
						</div>
					</div>
				</div>
				<div class="span4">
					<div class="service">
						<div class="support">
							<img src="${contextPath}/resource/themes/images/feature_img_3.png" alt="" />
							<h4>
								24/7 LIVE <strong>SUPPORT</strong>
							</h4>
							<p>Lorem Ipsum is simply dummy text of the printing and
								printing industry unknown printer.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>