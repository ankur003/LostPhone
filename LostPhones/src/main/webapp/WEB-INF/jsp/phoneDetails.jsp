 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:if test="${userfullname == null }">
 
 <c:redirect url="index.jsp"></c:redirect>
 
 </c:if>
 
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="generator" content="Mobirise v4.4.0, mobirise.com">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="shortcut icon" href="assets/images/logo-130x130.png" type="image/x-icon">
  <meta name="description" content="SignUp ">
  <title>PhoneDetails</title>
  <link rel="stylesheet" href="assets/web/assets/mobirise-icons/mobirise-icons.css">
  <link rel="stylesheet" href="assets/tether/tether.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-grid.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-reboot.min.css">
  <link rel="stylesheet" href="assets/animate.css/animate.min.css">
  <link rel="stylesheet" href="assets/dropdown/css/style.css">
  <link rel="stylesheet" href="assets/theme/css/style.css">
  <link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css" type="text/css">
    <script type="text/javascript"  src="<%=request.getContextPath()%>/assets/js_dev/formvalidation.js"></script>
    <script type="text/javascript"  src="<%=request.getContextPath()%>/assets/js_dev/generic.js"></script>
  
</head>
<body>
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
                <span class="navbar-caption-wrap"><a class="navbar-caption text-white display-4" href="https://mobirise.com">
                        LostPhones.org</a></span>
                        
                       
            </div>
        </div>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav nav-dropdown nav-right" data-app-modern-menu="true"><li class="nav-item">
                    <a class="nav-link link text-white display-4" href="https://mobirise.com">
                        <span class="mbri-home mbr-iconfont mbr-iconfont-btn"></span>
                        Home
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link link text-white display-4" href="https://mobirise.com">
                        <span class="mbri-search mbr-iconfont mbr-iconfont-btn"></span>
                        About Us
                    </a>
                </li></ul>
         
        </div>
    </nav>
</section>

<section class="engine"><a href="https://mobirise.co/b">free web site creator</a></section><section class="mbr-section form1 cid-qzNClGGaoJ mbr-parallax-background" id="form1-w" data-rv-view="235">
    
	<div class="container">
        <div class="row justify-content-center">
            <div class="title col-12 col-lg-8">
                <h2 class="mbr-section-title align-center pb-3 mbr-fonts-style display-2">
                    Add your phone<br></h2>
                <h3 class="mbr-section-subtitle align-center mbr-light pb-3 mbr-fonts-style display-5">
                    Enter your phone details below to add it to our global database. <br><center>We will notify you!</center>
                </h3>
            </div>
        </div>
    </div>
   
    <div class="container">
        <div class="row justify-content-center" style="margin-top:-10px;">
            <div class="media-container-column col-lg-10" data-form-type="formoid">
                    
            
                    <center> <form action="PhoneDetails" method="post" onsubmit="javascript:return phonedetailsvalid();"> 
                    
                    
                    
                       <div class="row row-sm-offset">
                           <div class="col-md-4 multi-horizontal" data-for="name">
                                <div class="form-group">
                                    <label class="form-control-label mbr-fonts-style display-7" for="name-form1-w" style="color:white">IMEI</label>
									<div class="col-sm-8">
                                    <input type="text" onkeypress="javascript: return onlyNumbers(event);" class="form-control" name="imei" data-form-field="Name"  placeholder="IMEI" id="name-form1-w"
                                    onfocus="javascript: hideMessage('imei_error')"/>
                                    <label id="imei_error" style="display: none; color:red;"></label>
									</div>
									
                                </div>
                             </div> 
                             
                             
                            
                             
                             
                        <div class="col-md-4 multi-horizontal" data-for="name"> 
                                <div class="form-group">
                                    <label class="form-control-label mbr-fonts-style display-7" for="name-form1-w" style="color:white">Brand</label>
									<div class="col-sm-8">
                                    <input type="text" class="form-control" onkeypress="javascript: return onlyChars(event);" name="brand" data-form-field="Name"  placeholder="Brand" id="name-form1-w">
                                </div>
								</div>
                        </div>
						
						<!-- <div class="col-lg-12">
						<div class="col-lg-5"><input type="text" class="form-control" name="brand" ></div>
						<div class="col-lg-5"><input type="text" class="form-control" name="brand" ></div>
						</div> -->
						</div>
						
						<div class="row row-sm-offset">
						
							<div class="col-md-4 multi-horizontal" data-for="name">
                                <div class="form-group">
                                    <label class="form-control-label mbr-fonts-style display-7" for="name-form1-w" style="color:white;">Model</label>
									<div class="col-sm-8">
                                    <input type="text" class="form-control" onkeypress="javascript: return onlyChars(event);" name="model" data-form-field="Name" placeholder="Model" id="name-form1-w">
                                </div>
								</div>
                            </div>
                            <div class="col-md-4 multi-horizontal" data-for="name">
                                <div class="form-group">
                                    <label class="form-control-label mbr-fonts-style display-7" for="name-form1-w" style="color:white">Color</label>
									<div class="col-sm-8">
                                    <input type="text" class="form-control" name="color" onkeypress="javascript: return onlyChars(event);" data-form-field="Name" placeholder="Color" id="name-form1-w">
                              </div>
							  </div>
							</div>
							
						</div>
						
						<div class="row row-sm-offset">
						
						
							<div class="col-md-4 multi-horizontal" data-for="phone">
                                 <div class="form-group">
                                    <label class="form-control-label mbr-fonts-style display-7" for="phone-form1-w" style="color:white">Status</label>
									<div class="col-sm-8">
                                   
									<select name ="status" class="form-control-label form-control">
									    <option value=""></option>
										<option value="Registered">Registered</option>
										<option value="Lost">Lost</option>
										<option value="Stolen">Stolen</option>										
									</select>
                               </div>
							   </div>
                            </div>
							
							<div class="col-md-4 multi-horizontal" data-for="name">
                                <div class="form-group">
                                    <label class="form-control-label mbr-fonts-style display-7" for="name-form1-w" style="color:white">Your Location</label>
									<div class="col-sm-8">
                                    <input type="text" class="form-control" name="location" onkeypress="javascript: return onlyChars(event);" data-form-field="Name" placeholder="City,Country" id="name-form1-w">
                              </div>
							  </div>
							</div>
						</div>

						<div class="row row-sm-offset">
							<div class="col-md-4 multi-horizontal" data-for="phone">
                                <div class="form-group">
                                    <label class="form-control-label mbr-fonts-style display-7" for="name-form1-w" style="color:white">Contact Number</label>
									<div class="col-sm-8">
                                    <input type="text" onkeypress="javascript: return onlyNumbers(event);" class="form-control" maxlength="5" name="contactnumber" data-form-field="Name" placeholder="+CC-XXXXXXXXXX" id="name-form1-w">
                              </div>
							  </div>
							</div>
							
							<div class="col-md-4 multi-horizontal" data-for="phone">
                                <div class="form-group">
                                    <label class="form-control-label mbr-fonts-style display-7" for="name-form1-w" style="color:white">Date Lost/Stolen</label>
									<div class="col-sm-8">
                                   <input type="text" class="form-control" name="lsdate" data-form-field="Name" placeholder="DD-MM-YYYY" id="name-form1-w"> 									
								    </div>
							    </div>
							</div>
                        </div>
                        
            
                        <span class="input-group-btn"><button type="submit" class="btn btn-primary btn-form display-4">Save</button></span>
                </form> 
				</center>
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
  
  </body>
</html>