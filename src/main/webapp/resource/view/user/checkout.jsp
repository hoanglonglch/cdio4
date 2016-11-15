<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<section class="header_text sub">
	<img class="pageBanner"
		src="${contextPath }/resource/themes/images/pageBanner.png"
		alt="New products">
	<h4>
		<span>Check Out</span>
	</h4>
</section>
<section class="main-content">
	<div class="row">
		<div class="span12">
			<div class="accordion" id="accordion2">
				<div class="accordion-group">
					<div class="accordion-heading">
						<a class="accordion-toggle" data-toggle="collapse"
							data-parent="#accordion2" href="#collapseOne">Account &amp;
							Billing Details</a>
					</div>
					<h2>${message}</h2>
					<div id="collapseOne" class="accordion-body in collapse">
						<div class="accordion-inner">
							<form:form commandName="invoiceEntity" autocomplete="off" id="checkout" action="comfirmCheckout" method = "POST">
								<div class="row-fluid">
									<div class="span6">
										<h4>Your Personal Details</h4>

										<div class="control-group">
											<label class="control-label">First Name</label>
											<div class="controls">
												<form:input path = "firstName" type="text" name = "firstName" placeholder="" class="input-xlarge"/>
												<br>
												<form:errors path="firstName" cssClass="error" />
											</div>
										</div>
										<div class="control-group">
											<label class="control-label">Last Name</label>
											<div class="controls">
												<form:input path = "lastName" type="text" name = "lastName" placeholder="" class="input-xlarge"/>
												<br>
												<form:errors path="lastName" cssClass="error" />
											</div>
										</div>
										<div class="control-group">
											<label class="control-label">Email Address</label>
											<div class="controls">
												<form:input path = "email" type="text" name = "email" placeholder="" class="input-xlarge"/>
												<br>
												<form:errors path="email" cssClass="error" />
											</div>
										</div>
										<div class="control-group">
											<label class="control-label">Telephone</label>
											<div class="controls">
												<form:input path = "phone" type="text" name = "phone" placeholder="" class="input-xlarge"/>
												<br>
												<form:errors path="phone" cssClass="error" />
											</div>
										</div>
									</div>
									<div class="span6">
										<h4>Your Address</h4>
										<div class="control-group">
											<label class="control-label"><span class="required">*</span>
												Address :</label>
											<div class="controls">
												<form:input path = "address" type="text" name = "address" placeholder="" class="input-xlarge"/>
												<br>
												<form:errors path="address" cssClass="error" />
											</div>
										</div>
										<div class="control-group">
											<label class="control-label"><span class="required">*</span>
												City:</label>
											<div class="controls">
												<form:input path = "city" type="text" name = "city" placeholder="" class="input-xlarge"/>
												<br>
												<form:errors path="city" cssClass="error" />
											</div>
										</div>
									</div>
								</div>
								<button type="submit" class="btn btn-inverse pull-right">Confirm
									order</button>
									<br>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>