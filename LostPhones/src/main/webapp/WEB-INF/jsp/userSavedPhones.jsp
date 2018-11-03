<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ page import="javax.servlet.http.*" %>
    <%@ page import="java.text.*" %>
    <%@ page import="java.io.*" %>
    <%@ page import="javax.servlet.*" %>
    <%@ page import="java.util.Date" %>
    <%@ page import="java.sql.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

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
                <span class="navbar-caption-wrap"><a class="navbar-caption text-white display-4" href="userHome.jsp">
                        LostPhones.org</a></span>
            </div>
        </div>
        <div class="collapse navbar-collapse" id="navbarSupportedContent" >
            <ul class="navbar-nav nav-dropdown nav-right" data-app-modern-menu="true" >
			    <li class="nav-item">
                    <a class="nav-link link text-white display-4" href="">
                        <span class="mbri-user mbr-iconfont mbr-iconfont-btn"></span>
                        Welcome, ${displayusername}
                    </a>
                </li>
                
			    <li class="nav-item">
                    <a class="nav-link link text-white display-4" href="userHome.jsp">
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
                    <a class="nav-link link text-white display-4" href="">
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
                    <a class="nav-link link text-white display-4" href="logout.jsp">
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
       <div class="media-container-row">
            
            <div class="media-content">
                <center><h1 class="mbr-section-title mbr-white pb-3 mbr-fonts-style display-2"><strong>Your Saved Phones</strong></h1></center>
                <h3 class="mbr-section-subtitle align-left mbr-white mbr-light pb-3 mbr-fonts-style display-5"><center>You can View,Edit or Update your phone information in the section below.</center> </h3>
                <div class="mbr-section-text mbr-white pb-3 ">
                    <p class="mbr-text mbr-fonts-style display-5"></p>
                </div>
                
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
 
              
<section class="header7 cid-qzJr8kjesm" id="header7-l" data-rv-view="217" >

    

    
  <div class="container container-table" id="tablediv">
  
  <sql:setDataSource
        var="myDSS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/lostphones"
        user="root" password="toor"
        
    />
    
     <c:choose>
    <c:when test="${userid != null }"> 
       <sql:query var="listphonesdetails"   dataSource="${myDSS}">
        SELECT * FROM userphonedetails where userid="${userid}";
    </sql:query>
    </c:when> 
    </c:choose>
               
           
      <h2 class="mbr-section-title mbr-fonts-style align-center pb-3 display-2">
          Device Detail
      </h2>
      
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
                      Contact Number</th><th class="head-item mbr-fonts-style display-7">
                      Update </th></tr>
            </thead>

            <tbody>
                <c:forEach var="listphones" items="${listphonesdetails.rows}">
           <tr> 
               <td class="body-item mbr-fonts-style display-7" style="display:block;"><c:out value="${listphones.id}" /></td>
              <td class="body-item mbr-fonts-style display-7"><c:out value="${listphones.imei}" /></td>
              <td class="body-item mbr-fonts-style display-7"><c:out value="${listphones.brand}" /></td>
              <td class="body-item mbr-fonts-style display-7"><c:out value="${listphones.model}" /></td>
              <td class="body-item mbr-fonts-style display-7"><c:out value="${listphones.color}" /></td>
              <td class="body-item mbr-fonts-style display-7"><c:out value="${listphones.location}" /></td>
              <td class="body-item mbr-fonts-style display-7"><c:out value="${listphones.lsdate}" /></td>
              <td class="body-item mbr-fonts-style display-7"><c:out value="${listphones.phonestatus}" /></td>
              <td class="body-item mbr-fonts-style display-7"><c:out value="${listphones.contactnumber}" /></td>
              <td class="body-item mbr-fonts-style display-7">
              
              
              <a class="nav-link link text-blue display-4" href="${pageContext.request.contextPath}/PhoneDetailsEdit?Id=${listphones.id}">
                        <span class="mbri-edit mbr-iconfont mbr-iconfont-btn"></span>
                       Edit
                    </a>
              
              
              
              </td>
              
              </tr>
           
                  </c:forEach>  
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