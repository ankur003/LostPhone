 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:if test="${userfullname != null }">
 
 <c:redirect url="userHome.jsp"></c:redirect>
 
 </c:if>
  <!-- Site made with Mobirise Website Builder v4.4.0, https://mobirise.com -->
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="generator" content="Mobirise v4.4.0, mobirise.com">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="shortcut icon" href="assets/images/logo-130x130.png" type="image/x-icon">
  <meta name="description" content="SignUp ">
  <title>SignUp</title>
  <link rel="stylesheet" href="assets/web/assets/mobirise-icons/mobirise-icons.css">
  <link rel="stylesheet" href="assets/tether/tether.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-grid.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-reboot.min.css">
  <link rel="stylesheet" href="assets/animate.css/animate.min.css">
  <link rel="stylesheet" href="assets/dropdown/css/style.css">
  <link rel="stylesheet" href="assets/theme/css/style.css">
  <link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css" type="text/css">
  
  
  
</head>
<script>
function show_lightboxdev(message)
{ 
	
	if(message!='')
		{
		
	document.getElementById("clickon_lightboxdev").click();
		}
}
function move()
{
	window.location.href = "login.jsp";
	}
</script>
<body onload="javascript: show_lightboxdev('${sessionScope.alert}')">
<section class="menu cid-qzJgtm7BZJ" once="menu" id="menu1-u" data-rv-view="233">

    

    <nav class="navbar navbar-expand beta-menu navbar-dropdown align-items-center navbar-fixed-top navbar-toggleable-sm bg-color transparent">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <div class="hamburger">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
            </div>
        </button>
        <div class="menu-logo">
            <div class="navbar-brand">
                <span class="navbar-logo">
                    
                         <img src="assets/images/logo-130x130.png" alt="Mobirise" title="" media-simple="true" style="height: 3.8rem;">
                    
                </span>
                <span class="navbar-caption-wrap"><a class="navbar-caption text-white display-4" href="index.jsp">
                        LostPhones.org</a></span>
            </div>
        </div>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav nav-dropdown nav-right" data-app-modern-menu="true"><!-- <li class="nav-item">
                    <a class="nav-link link text-white display-4" href="https://mobirise.com">
                        <span class="mbri-home mbr-iconfont mbr-iconfont-btn"></span>
                        Services
                    </a>
                </li> -->
                <li class="nav-item">
                    <a class="nav-link link text-white display-4" href="">
                        <span class="mbri-search mbr-iconfont mbr-iconfont-btn"></span>
                        About Us
                    </a>
                </li></ul>
            
        </div>
    </nav>
</section>

<section class="engine"><a href=""></a></section><section class="mbr-section form1 cid-qzNClGGaoJ mbr-parallax-background" id="form1-w" data-rv-view="235">

    <div class="container">
        <div class="row justify-content-center">
            <div class="title col-12 col-lg-8">
                <h2 class="mbr-section-title align-center pb-3 mbr-fonts-style display-2">
                    SignUp<br></h2>
                <h3 class="mbr-section-subtitle align-center mbr-light pb-3 mbr-fonts-style display-5">
                    Create your New Account
                </h3>
                <h3 class="mbr-section-subtitle align-center mbr-light pb-3 mbr-fonts-style display-7">
                    It takes less than 10 seconds !
                </h3>
            </div>
        </div>
    </div>
   
    <div class="container">
        <div class="row justify-content-center">
            <div class="media-container-column col-lg-10" data-form-type="formoid">
                    
            
                    <center><form:form class="mbr-form" action="SignUp" method="post" modelAttribute="signup">
                       <div class="row row-sm-offset">
                            <div class="col-md-4 multi-horizontal" data-for="name">
                                <div class="form-group">
                                    <label class="form-control-label mbr-fonts-style mbr-white display-5" for="name-form1-w">Name</label>
									<div class="col-sm-10">
                                    <form:input type="text" class="form-control" path = "fullName" name="fullname" data-form-field="Name" required="" placeholder="Full Name" id="name-form1-w"/>
									</div>
                                </div>
                            </div>
                            <div class="col-md-4 multi-horizontal" data-for="email">
                                <div class="form-group">
                                    <label class="form-control-label mbr-fonts-style mbr-white display-5" for="email-form1-w">Email</label>
									<div class="col-sm-10">
                                    <form:input type="email" path="email" class="form-control" name="email" data-form-field="Email" required="" placeholder="Email" id="email-form1-w"/>
                                </div>
								</div>
                            </div>
                         </div>
                        <div class="row row-sm-offset">   
                            <div class="col-md-4 multi-horizontal" data-for="phone">
                                <div class="form-group">
                                    <label class="form-control-label mbr-fonts-style mbr-white display-5" for="password-form1-w">Password</label>
									<div class="col-sm-10">
                                    <form:input type="password" path = "password" class="form-control" name="password" data-form-field="password" placeholder="Password." id="password-form1-w"/>
                              </div>
							  </div>
							</div>
							<div style="display: none;">
								<a data-toggle="modal" href="#myModal1" id="clickon_lightboxdev"
								   style="color: green">click</a>
							</div>								
							<div class="col-md-4 multi-horizontal" data-for="phone">
                                 <div class="form-group">
                                    <label class="form-control-label mbr-fonts-style mbr-white display-5" for="phone-form1-w">Confirm Password</label>
									<div class="col-sm-10">
                                    <input type="password" class="form-control" name="phone" data-form-field="Phone" placeholder="Confirm-password." id="phone-form1-w">
                               </div>
							   </div>
                            </div>
						</div>
                        
            
                        <span class="input-group-btn"><button  type="submit" class="btn btn-primary btn-form display-4">SignUp</button></span>
                        <a href="login" style="color:white;">Already a member? Login</a>
                   </form:form>
				</center>
            </div>
        </div>
    </div>
</section>

<div class="modal fade form-horizontal" id="myModal1" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
		align="center">
		<div class="modal-dialog">
			<div class="modal-content" style="margin-top: 250px;">
				<div class="information_heading">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true" style="color: white;" id="closemsgbox">&times;</button>
					<h4 class="modal-title">Message</h4>
				</div>
				<div class="modal-body" class="col-lg-8">
				<label id="in_exp" style="margin-bottom: 20px;">${sessionScope.alert}</label>
					
					<br>
					<!-- <button type="reset" class="btn btn-success" class="close"
						aria-hidden="true" >ok</button> -->
					<c:remove var="alert"/> 
						<center><button type="button" onclick="move()"
						data-dismiss="modal" aria-hidden="true" ><a href="">Ok</a></button></center>

				</div>
			</div>
		</div>
	</div>
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
  <c:remove var="alert"/> 
  </body>
</html>