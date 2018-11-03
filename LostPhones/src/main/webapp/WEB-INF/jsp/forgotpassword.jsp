
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Site made with Mobirise Website Builder v4.4.0, https://mobirise.com -->
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="generator" content="Mobirise v4.4.0, mobirise.com">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="assets/images/logo-130x130.png"
	type="image/x-icon">
<meta name="description" content="Login To LostPhones.org">
<title>Login</title>
<link rel="stylesheet"
	href="assets/web/assets/mobirise-icons/mobirise-icons.css">
<link rel="stylesheet" href="assets/tether/tether.min.css">
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="assets/bootstrap/css/bootstrap-grid.min.css">
<link rel="stylesheet"
	href="assets/bootstrap/css/bootstrap-reboot.min.css">
<link rel="stylesheet" href="assets/animate.css/animate.min.css">
<link rel="stylesheet" href="assets/dropdown/css/style.css">
<link rel="stylesheet" href="assets/theme/css/style.css">
<link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css"
	type="text/css">
<link rel="stylesheet" href="assets/js_dev/formvalidation.js">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/utils/generic.js"></script>

</head>
<body>
	<c:remove var="alert" />
	<section class="menu cid-qzJgtm7BZJ" once="menu" id="menu1-r"
		data-rv-view="228"> <nav
		class="navbar navbar-expand beta-menu navbar-dropdown align-items-center navbar-fixed-top navbar-toggleable-sm bg-color transparent">
	<button class="navbar-toggler navbar-toggler-right" type="button"
		data-toggle="collapse" data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<div class="hamburger">
			<span></span> <span></span> <span></span> <span></span>
		</div>
	</button>
	<div class="menu-logo">
		<div class="navbar-brand">
			<span class="navbar-logo"> <img
				src="assets/images/logo-130x130.png" alt="Mobirise" title=""
				media-simple="true" style="height: 3.8rem;">

			</span> <span class="navbar-caption-wrap"><a
				class="navbar-caption text-white display-4" href="">
					LostPhones.org</a></span>
		</div>
	</div>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav nav-dropdown nav-right"
			data-app-modern-menu="true">
			<!-- <li class="nav-item">
                    <a class="nav-link link text-white display-4" href="https://mobirise.com">
                        <span class="mbri-home mbr-iconfont mbr-iconfont-btn"></span>
                        Services
                    </a>
                </li> -->
			<li class="nav-item"><a
				class="nav-link link text-white display-4" href=""> <span
					class="mbri-search mbr-iconfont mbr-iconfont-btn"></span> About Us
			</a></li>
		</ul>

	</div>
	</nav> </section>

	<section class="engine"> <a href=""></a></section>
	<section
		class="mbr-section form1 cid-qzNySKkfgj mbr-parallax-background"
		id="form1-t" data-rv-view="230">




	<div class="container">
		<div class="row justify-content-center">
			<div class="title col-12 col-lg-8">
				<h2
					class="mbr-section-title align-center pb-3 mbr-fonts-style display-2">
					Verify Your Email<br>
				</h2>
				<h3
					class="mbr-section-subtitle align-center mbr-light pb-3 mbr-fonts-style display-5">
					Enter the one-time password received in your verification e-mail</h3>

			</div>
		</div>
	</div>
	<div class="container">
		<div class="row justify-content-center">
			<div class="media-container-column col-lg-8" data-form-type="formoid">


				<form:form class="mbr-form" action="VerifyOtpForForgotPass"
					method="post" modelAttribute="forgotPassOtp">
					<div class="row row-sm-offset">
						<div class="col-md-4 multi-horizontal" data-for="email">
							<div class="form-group">
								<label class="form-control-label mbr-fonts-style display-5"
									for="email-form1-t" style="color: white;">OTP</label>
								<form:input type="text" path="otp" class="form-control"
									name="otp" data-form-field="Email" required=""
									placeholder="Enter OTP" id="name-form1-t" />
							</div>
							<center
								class="mbr-section-subtitle align-center mbr-light pb-3 mbr-fonts-style display-5">${userSaved}</center>
						</div>
					</div>
					<div class="row row-sm-offset">
						<div class="col-md-4 multi-horizontal" data-for="name">
							<div class="form-group">
								<label class="form-control-label mbr-fonts-style display-5"
									for="name-form1-t" style="color: white;"> Password</label> <input
									type="password" class="form-control" name="passwordd"
									data-form-field="Email" required=""
									placeholder="Enter Password" id="name-form1-t" />
							</div>
						</div>
						<div class="col-md-4 multi-horizontal" data-for="name">
							<div class="form-group">
								<label class="form-control-label mbr-fonts-style display-5"
									for="name-form1-t" style="color: white;">Confirm
									Password</label>

								<form:input path="password" type="password" class="form-control"
									name="password" data-form-field="Name" required=""
									placeholder="Confirm Password" id="name-form1-t" />
							</div>
						</div>

					</div>


					<span class="input-group-btn"><button type="submit"
							class="btn btn-form btn-white-outline display-7">Submit</button></span>

				</form:form>
				<div id="hide">
					<center>
						<p
							style="color: red; font-size: 15px; margin-top: 10px; background-color:;">
							<i><u>${wrongCred}</u></i>
				</div>
			</div>
		</div>
	</section>


	<script src="assets/web/assets/jquery/jquery.min.js"></script>
	<script src="assets/popper/popper.min.js"></script>
	<script src="assets/tether/tether.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/smooth-scroll/smooth-scroll.js"></script>
	<script src="assets/touch-swipe/jquery.touch-swipe.min.js"></script>
	<script src="assets/viewport-checker/jquery.viewportchecker.js"></script>
	<script src="assets/jarallax/jarallax.min.js"></script>
	<script src="assets/dropdown/js/script.min.js"></script>
	<script src="assets/theme/js/script.js"></script>


	<input name="animation" type="hidden">

	<c:remove var="wrongCred" />

</body>
</html>