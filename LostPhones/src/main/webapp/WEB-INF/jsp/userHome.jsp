 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*" %>

<%@ page import="javax.servlet.http.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:if test="${userfullname == null }">
 
 <c:redirect url="index"></c:redirect>
 
 </c:if>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="generator" content="Mobirise v4.4.0, mobirise.com">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="shortcut icon" href="assets/images/logo-130x130.png" type="image/x-icon">
  <meta name="description" content="">
  <title>Home</title>
  <link rel="stylesheet" href="assets/web/assets/mobirise-icons/mobirise-icons.css">
  <link rel="stylesheet" href="assets/tether/tether.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-grid.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-reboot.min.css">
  <link rel="stylesheet" href="assets/socicon/css/styles.css">
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
	var x = document.getElementById('tablediv');
	x.style.display='block';
	
}

function hide()
{
	var x = document.getElementById('hide');
	x.style.display='none';
	}
</script>

<body onload="javascript: show_lightboxdev('${sessionScope.alert}')">

<section class="menu cid-qzJgtm7BZJ" once="menu" id="menu1-e" data-rv-view="223">

    

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
                <span class="navbar-caption-wrap"><a class="navbar-caption text-white display-4" href="">
                        LostPhones.org</a></span>
            </div>
        </div>
        <div class="collapse navbar-collapse" id="navbarSupportedContent" >
            <ul class="navbar-nav nav-dropdown nav-right" data-app-modern-menu="true" >
			    
			    <li class="nav-item">
                    <a class="nav-link link text-white display-4" href="">
                        <span class="mbri-user mbr-iconfont mbr-iconfont-btn"></span>
                        Welcome, ${userfullname}
                    </a>
                </li>
			    
			    <li class="nav-item">
                    <a class="nav-link link text-white display-4" href="userHome.jsp#section#header4-i">
                        <span class="mbri-home mbr-iconfont mbr-iconfont-btn"></span>
                        Home
                    </a>
                </li>
                
				<li class="nav-item">
                    <a class="nav-link link text-white display-4" href="userSavedPhones.jsp">
                        <span class="mbri-mobile2 mbr-iconfont mbr-iconfont-btn"></span>
                        Saved Phones
                    </a>
                </li>
				<li class="nav-item">
                    <a class="nav-link link text-white display-4" href="userHome.jsp#section#header6-n">
                        <span class="mbri-question mbr-iconfont mbr-iconfont-btn"></span>
                        FAQ
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link link text-white display-4" href="">
                        <span class="mbri-smile-face mbr-iconfont mbr-iconfont-btn"></span>
                        About Us
                    </a>
                </li>
                 <li class="nav-item">
                    <a class="nav-link link text-white display-4" href="logout">
                        <span class="mbri-smile-face mbr-iconfont mbr-iconfont-btn"></span>
                        Logout
                    </a>
                </li>
		    </ul>
            
        </div>
    </nav>

</section>

<section class="header2 cid-qzJhA87DbI mbr-fullscreen mbr-parallax-background" id="header4-i" data-rv-view="211" style="min-height: 50vh;">

    

    

    <div class="container">
       <!--  <div class="row justify-content-center">
            <div class="media-container-column col-lg-8" data-form-type="formoid">
                     -->
            
                   <form class="mbr-form" action="SearchImei" method="post" style="margin-top:4em;margin-left:60px">
                        <div class="row row-sm-offset">
                            <div class="col-md-10 multi-horizontal" data-for="name">
                                <div class="form-group">
                                   
                                    <input type="text" class="form-control" name="searchimei" data-form-field="Name" required="" placeholder="Search IMEI" id="name-form1-t" onclick="hide()">
                                </div>
                            </div>
                        </div>
                        
           <div style="display: none;">
	<a data-toggle="modal" href="#myModal1" id="clickon_lightboxdev"
							style="color: green">click</a>
	</div>	 
                        <span class="input-group-btn"><button href="section#header" type="submit" class="btn btn-form btn-white-outline display-7">Search</button></span>

                    </form>
                
                   <div id="hide"> <center><p style="color:red;font-size: 15px;margin-top: 10px;background-color: ;"><i><u>${wrongCred}</u></i>
          <!--   </div>
        </div> -->
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
<section class="header3 cid-qzJnvzgAkM mbr-fullscreen" id="header3-k" data-rv-view="214" style="min-height:9vh;">
 
    <div class="container">
        <div class="media-container-row">
            <div class="mbr-figure" style="width: 105%;">
                <img src="assets/images/ipad-600x440.png" alt="LandscapeMob" title="" media-simple="true">
            </div>

            <div class="media-content"  >
                <h1 class="mbr-section-title mbr-white pb-3 mbr-fonts-style display-1 ">
                    Register your phone
                </h1>
                
                <div class="mbr-section-text mbr-white pb-3 ">
                    <p class="mbr-text mbr-fonts-style display-5">
                        You can register your phone in advance or report your lost/stolen phone by entering your phone's IMEI.
                                            </p>
                </div>
                <div class="mbr-section-btn"><a class="btn btn-md btn-primary-outline display-4" href="phoneDetails.jsp">Register</a>
                    <a class="btn btn-md btn-primary-outline display-4" href="phoneDetails.jsp">Lost/Stolen</a></div>
            </div>
        </div>
    </div>

</section>
 <%
              Object ob = session.getAttribute("list");
              if(ob!=null){
             ArrayList<String> listt=(ArrayList<String>)session.getAttribute("list"); 
             Object [] tabledata = listt.toArray();
              
              %>
<section class="header7 cid-qzJr8kjesm" id="header7-l" data-rv-view="217" >

    

    
  <div class="container container-table" id="tablediv">
      <h2 class="mbr-section-title mbr-fonts-style align-center pb-3 display-2">
          Global IMEI database
      </h2>
      <h3 class="mbr-section-subtitle mbr-fonts-style align-center pb-5 mbr-light display-5">
            The results in the database are based on our global community of device owners who have registered 
            or have reported their phones as Lost or Stolen. Please hit the 'contact user' button if you have 
            found a match!      
      </h3>
      <div class="table-wrapper">
        <div class="container">
          <!-- <div class="row search">
            <div class="col-md-6"></div>
            <div class="col-md-6">
                <div class="dataTables_filter">
                  <label class="searchInfo mbr-fonts-style display-7">Search:</label>
                  <input class="form-control input-sm" disabled="">
                </div>
            </div>
          </div> -->
		 <form class="mbr-form" action="SearchImei" method="post" style="margin-top:4em;margin-left:60px">
                        <div class="row row-sm-offset">
                            <div class="col-md-10 multi-horizontal" data-for="name">
                                <div class="form-group">
                                   
                                    <input type="text" class="form-control" name="searchimei" data-form-field="Name" required="" placeholder="Search IMEI" id="name-form1-t" onclick="hide()">
                                </div>
                            </div>
                        </div>
                        
         
                        <span class="input-group-btn"><button href="section#header" type="submit" class="btn btn-md btn-primary-outline display-4">Search</button></span>

                    </form>
        
              
</div>
        <div class="container scroll">
          <table class="table isSearch" cellspacing="0">
        
            <thead>
              <tr class="table-heads ">
                  
                  
                  
                  
              <th class="head-item mbr-fonts-style display-7">
                      IMEI Number</th><th class="head-item mbr-fonts-style display-7">
                      BRAND</th><th class="head-item mbr-fonts-style display-7">
                      MODEL</th><th class="head-item mbr-fonts-style display-7">
                      COLOR</th><th class="head-item mbr-fonts-style display-7">
                      Location</th><th class="head-item mbr-fonts-style display-7">
                      Date</th><th class="head-item mbr-fonts-style display-7">
                       Status</th><th class="head-item mbr-fonts-style display-7">
                      Action </th></tr>
            </thead>

            <tbody>
             
           <tr> 
              <td class="body-item mbr-fonts-style display-7"><%=tabledata[0] %></td>
              <td class="body-item mbr-fonts-style display-7"><%=tabledata[1] %></td>
              <td class="body-item mbr-fonts-style display-7"><%=tabledata[2] %></td>
              <td class="body-item mbr-fonts-style display-7"><%=tabledata[3] %></td>
              
              <td class="body-item mbr-fonts-style display-7"><%=tabledata[4] %></td>
              <td class="body-item mbr-fonts-style display-7"><%=tabledata[5] %></td>
              <td class="body-item mbr-fonts-style display-7"><%=tabledata[6] %></td>
              <td class="body-item mbr-fonts-style display-7">contact user</td>
              
              </tr>
              <% } %> 
                 
            <!--     
            <tr>
                
              <td class="body-item mbr-fonts-style display-7">Caren Rials</td><td class="body-item mbr-fonts-style display-7">35</td><td class="body-item mbr-fonts-style display-7">2013-04-12</td><td class="body-item mbr-fonts-style display-7">$445.500</td></tr><tr>
                
                
                
                
              <td class="body-item mbr-fonts-style display-7">Leon Rogol</td><td class="body-item mbr-fonts-style display-7">66</td><td class="body-item mbr-fonts-style display-7">2016-05-22</td><td class="body-item mbr-fonts-style display-7">$152.558</td></tr><tr>
                
                
                
                
              <td class="body-item mbr-fonts-style display-7">Shala Barrera</td><td class="body-item mbr-fonts-style display-7">70</td><td class="body-item mbr-fonts-style display-7">2016-05-15</td><td class="body-item mbr-fonts-style display-7">$459.146</td></tr></tbody> -->
          </table>
        </div>
      <!--   <div class="container table-info-container">
          <div class="row info">
            <div class="col-md-6">
              <div class="dataTables_info mbr-fonts-style display-7">
                <span class="infoBefore">Showing</span>
                <span class="inactive infoRows"></span>
                <span class="infoAfter">entries</span>
                <span class="infoFilteredBefore">(filtered from</span>
                <span class="inactive infoRows"></span>
                <span class="infoFilteredAfter"> total entries)</span>
              </div>
            </div>
            <div class="col-md-6"></div>
          </div>
        </div> -->
      </div>
    </div>
</section>

<section class="header6 cid-qzJwujnDa1 mbr-fullscreen mbr-parallax-background" id="header6-n" data-rv-view="220">

    

    <div class="mbr-overlay" style="opacity: 0.2; background-color: rgb(0, 0, 0);">
    </div>

    <!-- <div class="container">
        <div class="row justify-content-md-center">
            <div class="mbr-white col-md-10">
                <h1 class="mbr-section-title align-center mbr-bold pb-3 mbr-fonts-style display-1">
                    INTRO WITH BACKGROUND VIDEO
                </h1>
                <p class="mbr-text align-center pb-3 mbr-fonts-style display-5">
                    Intro with background video and color overlay. Mobirise helps you cut down development time by providing you with a flexible website editor with a drag and drop interface.
                </p>
                <div class="mbr-section-btn align-center"><a class="btn btn-md btn-white-outline display-4" href="https://mobirise.com">LEARN MORE</a></div>
            </div>
        </div>
    </div> -->

	
	<div class="container">
        <div class="row justify-content-md-center" style="margin-top:-100px;" >
            <div class="mbr-white col-md-10">
                <h1 class="mbr-section-title mbr-white align-center mbr-bold pb-3 mbr-fonts-style display-1" style="margin-top:-10px;" >
                    Frequently Asked Questions
                </h1>
                </div>
                <div class="clearfix"></div>
                <div id="bootstrap-accordion_6" class="panel-group accordionStyles accordion" role="tablist" aria-multiselectable="true">
                    <div class="card">
                        <div class="card-header" role="tab" id="headingOne">
                            <a role="button" class="panel-title collapsed text-black" data-toggle="collapse" data-parent="#bootstrap-accordion_6" data-core="" href="#collapse1_6" aria-expanded="false" aria-controls="collapse1">
                                <h4 class="mbr-fonts-style mbr-white display-5">
                                    <span class="sign mbr-iconfont mbri-arrow-down inactive"></span>
                                    Your mobile phone is lost or stolen; what should you do?
                                </h4>
                            </a>
                        </div>
                        <div id="collapse1_6" class="panel-collapse noScroll collapse " role="tabpanel" aria-labelledby="headingOne">
                            <div class="panel-body p-4">
                                <p class="mbr-fonts-style mbr-white panel-text display-7">
                                   a. Report your phone to the police.
                               <br>b. Tell your Network provider.
                               <br>c. Use tracking softwares.
                               <br>d. Report your phone at Lostphones.org
                               <br><br>Using the first three steps, you can lock away you phone contents,erase its contents and also get it blacklisted by 
                                       getting in touch with your Network provider and the police,<strong>but did you know that that only restricts it from being used in your country?</strong>
                                       Many mobile phones end up being shipped across the world where you country's blacklist becomes irrelevant and so the phone can be sold on and used perfectly well.
                                       And its a booming market! Some versions of Android and iOS offer tracking software built-in so you might be
                                       able to track you phone that way. Check your phone documentation for more info.</p>
                            </div>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-header" role="tab" id="headingTwo">
                            <a role="button" class="collapsed panel-title text-black" data-toggle="collapse" data-parent="#bootstrap-accordion_6" data-core="" href="#collapse2_6" aria-expanded="false" aria-controls="collapse2">
                                <h4 class="mbr-fonts-style mbr-white display-5">
                                    <span class="sign mbr-iconfont mbri-arrow-down inactive"></span> How can <strong>WE</strong> help?
                               </h4>
                            </a>
                            
                        </div>
                        <div id="collapse2_6" class="panel-collapse noScroll collapse" role="tabpanel" aria-labelledby="headingTwo">
                            <div class="panel-body p-4">
                                <p class="mbr-fonts-style mbr-white panel-text display-7">
                                   <strong>Once you register/report your phone's IMEI at Lostphones.org,</strong> it gets added to our <strong>Global database</strong> which can be searched 
                                   by anyone directly or via google.It in turn, multifolds your chances of finding your phone as someone somewhere buying
                                   a <strong>Used Phone</strong> would want to check if the phone he/she is buying is not a stolen one! There are high 
                                   chances of this behaviour intuitively! <strong>And with enough awareness and word of mouth, we can make this a norm for 
                                   anyone buying a Used/2nd hand phone!</strong></p>
                            </div>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-header" role="tab" id="headingThree">
                            <a role="button" class="collapsed text-black panel-title" data-toggle="collapse" data-parent="#bootstrap-accordion_6" data-core="" href="#collapse3_6" aria-expanded="false" aria-controls="collapse3">
                                <h4 class="mbr-fonts-style mbr-white display-5">
                                    <span class="sign mbr-iconfont mbri-arrow-down inactive"></span> How can I find my phone's IMEI?
                                </h4>
                            </a>
                        </div>
                        <div id="collapse3_6" class="panel-collapse noScroll collapse" role="tabpanel" aria-labelledby="headingThree">
                            <div class="panel-body p-4">
                                <p class="mbr-fonts-style mbr-white panel-text display-7">
                                   a. If you phone is lost/stolen<br>i) Look for the IMEI detail in your phone bill or phone-box
                                   <br>ii) Contact the dealer for duplicate bill.<br>iii) Contact customer care of the manufacturer.<br>iv) Contact your Network provider<br><br>b.If its not <br>i) Simply dial *#06# on your handset
                               <br>ii) Or Check the back of your phone or battery or the bill box. 
                                 </p>
                            </div>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-header" role="tab" id="headingThree">
                            <a role="button" class="collapsed text-black panel-title" data-toggle="collapse" data-parent="#bootstrap-accordion_6" data-core="" href="#collapse3_6" aria-expanded="false" aria-controls="collapse3">
                                <h4 class="mbr-fonts-style mbr-white display-5">
                                    <span class="sign mbr-iconfont mbri-arrow-down inactive"></span> How can YOU help?
                                </h4>
                            </a>
                        </div>
                        <div id="collapse3_6" class="panel-collapse noScroll collapse" role="tabpanel" aria-labelledby="headingThree">
                            <div class="panel-body p-4">
                                <p class="mbr-fonts-style mbr-white panel-text display-7">
                                   In 2 ways,<br>If you find a phone that has been reported, contact the user via Lostphones.org and help the owner 
                                   get back their device.<br>
                                   
                                 </p>
                            </div>
                        </div>
                    </div>
                    
                    
                    
                </div>
            </div>
        </div>
    </div>
    
</section>

<section class="cid-qzJgtnA66W" id="footer1-g" data-rv-view="225">

    

    

    <div class="container">
        <div class="media-container-row content text-white">
            <div class="col-12 col-md-3">
                <div class="media-wrap">
                    <a href="https://mobirise.com/">
                        <img src="assets/images/logo-130x130.png" alt="Mobirise" title="" media-simple="true">
                    </a>
                </div>
            </div>
            <div class="col-12 col-md-3 mbr-fonts-style display-7">
                <h5 class="pb-3"><strong>
                    Address
                </strong></h5>
                <p class="mbr-text">
                    1234 Street Name
                    <br>City, AA 99999
                </p>
            </div>
            <div class="col-12 col-md-3 mbr-fonts-style display-7">
                <h5 class="pb-3">
                    Contacts
                </h5>
                <p class="mbr-text">
                    Email: support@mobirise.com
                    <br>Phone: +1 (0) 000 0000 001
                    <br>Fax: +1 (0) 000 0000 002
                </p>
            </div>
            <div class="col-12 col-md-3 mbr-fonts-style display-7">
                <h5 class="pb-3">
                    Links
                </h5>
                <p class="mbr-text">
                    <a class="text-primary" href="https://mobirise.com/">Website builder</a>
                    <br><a class="text-primary" href="https://mobirise.com/mobirise-free-win.zip">Download for Windows</a>
                    <br><a class="text-primary" href="https://mobirise.com/mobirise-free-mac.zip">Download for Mac</a>
                </p>
            </div>
        </div>
        <div class="footer-lower">
            <div class="media-container-row">
                <div class="col-sm-12">
                    <hr>
                </div>
            </div>
            <div class="media-container-row mbr-white">
                <div class="col-sm-6 copyright">
                    <p class="mbr-text mbr-fonts-style display-7">
                        © Copyright 2017 LostPhones.org - All Rights Reserved
                    </p>
                </div>
                <div class="col-md-6">
                    <div class="social-list align-right" style="background-color:gray;width:43%">
                        <div class="soc-item">
                            <a href="https://twitter.com/mobirise" target="_blank">
                                <span class="socicon-twitter socicon mbr-iconfont mbr-iconfont-social " media-simple="true"></span>
                            </a>
                        </div>
                        <div class="soc-item">
                            <a href="https://www.facebook.com/pages/Mobirise/1616226671953247" target="_blank">
                                <span class="socicon-facebook socicon mbr-iconfont mbr-iconfont-social" media-simple="true"></span>
                            </a>
                        </div>
                        <div class="soc-item">
                            <a href="https://www.youtube.com/c/mobirise" target="_blank">
                                <span class="socicon-youtube socicon mbr-iconfont mbr-iconfont-social" media-simple="true"></span>
                            </a>
                        </div>
                        <div class="soc-item">
                            <a href="https://instagram.com/mobirise" target="_blank">
                                <span class="socicon-instagram socicon mbr-iconfont mbr-iconfont-social" media-simple="true"></span>
                            </a>
                        </div>
                        <div class="soc-item">
                            <a href="https://plus.google.com/u/0/+Mobirise" target="_blank">
                                <span class="socicon-googleplus socicon mbr-iconfont mbr-iconfont-social" media-simple="true"></span>
                            </a>
                        </div>
                        <div class="soc-item">
                            <a href="https://www.behance.net/Mobirise" target="_blank">
                                <span class="socicon-behance socicon mbr-iconfont mbr-iconfont-social" media-simple="true"></span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


  <script src="assets/web/assets/jquery/jquery.min.js"></script>
  <script src="assets/popper/popper.min.js"></script>
  <script src="assets/tether/tether.min.js"></script>
  <script src="assets/bootstrap/js/bootstrap.min.js"></script>
  <script src="assets/smooth-scroll/smooth-scroll.js"></script>
  <script src="assets/viewport-checker/jquery.viewportchecker.js"></script>
  <script src="assets/dropdown/js/script.min.js"></script>
  <script src="assets/touch-swipe/jquery.touch-swipe.min.js"></script>
  <script src="assets/jarallax/jarallax.min.js"></script>
  <script src="assets/theme/js/script.js"></script>
  
  
  <input name="animation" type="hidden">
  <c:remove var="alert"/>
  <c:remove var="wrongCred"/>
  </body>
</html>