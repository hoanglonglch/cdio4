<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<section class="header_text sub">
	<img class="pageBanner"
		src="${contextPath }/resource/themes/images/pageBanner.png"
		alt="New products">
	<h4>
		<span>Login or Regsiter</span>
	</h4>
</section>

<section class="main-content">
	<div class="row">
		<div class="span5">
			<h4 class="title">
				<span class="text"><strong>Login</strong> Form</span>
			</h4>
			<c:url value="/j_spring_security_check" var="loginUrl" />
			<form id="login" action="${loginUrl }" method="POST">
				<input type="hidden" name="next" value="/">
				<fieldset>
					<div class="control-group">
						<label class="control-label">Username</label>
						<div class="controls">
							<input type="text" name="username"
								placeholder="Enter your username" id="username"
								class="input-xlarge"/>
							<br>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Password</label>
						<div class="controls">
							<input type="password" name="password"
								placeholder="Enter your password" id="password"
								class="input-xlarge"/>
							<br>
						</div>
					</div>
					<div class="control-group">
						<input tabindex="3" class="btn btn-inverse large" type="submit"
							value="Sign into your account">
						<hr>
						<p class="reset">
							Recover your <a tabindex="4" href="#"
								title="Recover your username or password">username or
								password</a>
						</p>
					</div>
				</fieldset>
			</form>
		</div>
		<div class="span7">
			<h4 class="title">
				<span class="text"><strong>Register</strong> Form</span>
			</h4>
			<h2>${message}</h2>
			<form:form commandName="userEntity" autocomplete="off" id="register" action="register" method="POST"
				class="form-stacked">
				<fieldset>
					<div class="control-group">
						<label class="control-label">Username</label>
						<div class="controls">
							<form:input type="text" path="username" name="username"
								placeholder="Enter your username" class="input-xlarge" />
							<br>
							<form:errors path="username" cssClass="error" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Email address:</label>
						<div class="controls">
							<form:input path="email" type="text" name="email"
								placeholder="Enter your email" class="input-xlarge" />
							<br>
							<form:errors path="email" cssClass="error" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Phone :</label>
						<div class="controls">
							<form:input type="text" path="phone" name="phone"
								placeholder="Enter your phone" class="input-xlarge" />
							<br>
							<form:errors path="phone" cssClass="error" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Address:</label>
						<div class="controls">
							<form:input path="address" type="text" name="address"
								placeholder="Enter your address" class="input-xlarge" />
							<br>
							<form:errors path="address" cssClass="error" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Password:</label>
						<div class="controls">
							<form:input type="password" path="password" name="password"
								placeholder="Enter your password" class="input-xlarge" />
							<br>
							<form:errors path="password" cssClass="error" />
						</div>
					</div>
					<hr>
					<div class="actions">
						<input tabindex="9" class="btn btn-inverse large" type="submit"
							value="Create your account">
					</div>
				</fieldset>
			</form:form>
		</div>
	</div>
</section>