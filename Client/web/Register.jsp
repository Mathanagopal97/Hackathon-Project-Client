<%-- 
    Document   : Register
    Created on : 16 Mar, 2018, 10:38:40 AM
    Author     : Mathan
--%>





<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.ResultSetMetaData"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ page import="java.time.LocalDateTime"%>
<%@ page import="javax.servlet.ServletException"%>
<%@ page import="javax.servlet.http.HttpServlet"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<%@ page import="java.util.Date"%>




<html lang="sl">
<head>
  <!-- Site made with Mobirise Website Builder v4.3.5, https://mobirise.com -->
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <!-- <meta name="generator" content="Mobirise v4.3.5, mobirise.com"> -->
 <!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
 <!-- <link rel="shortcut icon" href="assets/images/logo2.png" type="image/x-icon"> -->
  
  <title>Register</title>
  <link rel="stylesheet" href="assets-Login/web/assets/mobirise-icons/mobirise-icons.css">
  <link rel="stylesheet" href="assets-Login/tether/tether.min.css">
  <link rel="stylesheet" href="assets-Login/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets-Login/bootstrap/css/bootstrap-grid.min.css">
  <link rel="stylesheet" href="assets-Login/bootstrap/css/bootstrap-reboot.min.css">
  <link rel="stylesheet" href="assets-Login/dropdown/css/style.css">
  <link rel="stylesheet" href="assets-Login/theme/css/style.css">
  <link rel="stylesheet" href="assets-Login/mobirise/css/mbr-additional.css" type="text/css">
  <link rel="stylesheet" href="assets-Login/socicon/css/styles.css">
  
  
  <!--formden.js communicates with FormDen server to validate fields and submit via AJAX -->
<script type="text/javascript" src="https://formden.com/static/cdn/formden.js"></script>

<!-- Special version of Bootstrap that is isolated to content wrapped in .bootstrap-iso -->
<link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />

<!--Font Awesome (added because you use icons in your prepend/append)-->
<link rel="stylesheet" href="https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css" />

<style>.bootstrap-iso .formden_header h2, .bootstrap-iso .formden_header p, .bootstrap-iso form{font-family: Arial, Helvetica, sans-serif; color: black}.bootstrap-iso form button, .bootstrap-iso form button:hover{color: white !important;} .asteriskField{color: red;}
/* Response */
.response{
    padding: 6px;
    display: none;
}

.not-exists{
    color: red;
}

.exists{
    color: green;
}
</style>
  

  
  

</head>


    
<section class="menu cid-qv1frvgcz3" once="menu" id="menu1-4r" data-rv-view="8240">

    

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
                
                <span class="navbar-caption-wrap"><a class="navbar-caption text-white display-4" href="index.html">
                        INNERPRENEUR</a></span>
            </div>
        </div>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <!--<ul class="navbar-nav nav-dropdown" data-app-modern-menu="true"><li class="nav-item dropdown"><a class="nav-link link text-white dropdown-toggle display-4" href="blog.html" data-toggle="dropdown-submenu" aria-expanded="false">
                        
                        BLOCK DEMOS 1</a><div class="dropdown-menu"><a class="text-white dropdown-item display-4" href="slider.html">Slider Header Demo</a><a class="text-white dropdown-item display-4" href="video-background.html">Video Background Demo</a><a class="text-white dropdown-item display-4" href="footer-template.html">Footer Template</a><a class="text-white dropdown-item display-4" href="table-template.html">Table Template</a><a class="text-white dropdown-item display-4" href="carousel-template.html">Carousel Template</a><a class="text-white dropdown-item display-4" href="blog.html">Gallery Template</a><a class="text-white dropdown-item display-4" href="menu-template.html">Menu Template</a><a class="text-white dropdown-item display-4" href="navigation-menu-template.html">Navigation Menu Template</a><a class="text-white dropdown-item display-4" href="navbar-template.html">Navbar Template</a><a class="text-white dropdown-item display-4" href="header-template.html">Header Template</a><a class="text-white dropdown-item display-4" href="registration-form-template.html">Registration Form Template</a><a class="text-white dropdown-item display-4" href="grid-template.html">Grid Template</a><a class="text-white dropdown-item display-4" href="social-network-template.html">Social Network Template</a><a class="text-white dropdown-item display-4" href="parallax-template.html">Parallax Template</a><a class="text-white dropdown-item display-4" href="parallax-scrolling-template.html">Parallax Scrolling Template</a></div></li>
                <li class="nav-item dropdown"><a class="nav-link link text-white dropdown-toggle display-4" href="blog.html" data-toggle="dropdown-submenu" aria-expanded="false">
                        
                        BLOCK DEMOS 2</a><div class="dropdown-menu"><a class="text-white dropdown-item display-4" href="shopping-cart-template.html">Shopping Cart Template</a><a class="text-white dropdown-item display-4" href="contact-form-template.html">Contact Form Template</a><a class="text-white dropdown-item display-4" href="list-template.html">List Template</a><a class="text-white dropdown-item display-4" href="video-template.html">Video Template</a><a class="text-white dropdown-item display-4" href="photo-gallery-template.html">Photo Gallery Template</a><a class="text-white dropdown-item display-4" href="map-template.html">Map Template</a><a class="text-white dropdown-item display-4" href="faq-template.html">FAQ Template</a><a class="text-white dropdown-item display-4" href="slider-template.html">Slider Template</a><a class="text-white dropdown-item display-4" href="background-template.html">Video Background Template</a><a class="text-white dropdown-item display-4" href="documentation-template.html">Documentation Template</a><a class="text-white dropdown-item display-4" href="article-template.html">Article Template</a><a class="text-white dropdown-item display-4" href="google-maps-template.html">Google Maps Template</a><a class="text-white dropdown-item display-4" href="form-templates.html">Form Templates </a><a class="text-white dropdown-item display-4" href="tab-template.html">Tab Template</a><a class="text-white dropdown-item display-4" href="video-gallery-template.html">Video Gallery Template</a></div></li>
                
                <li class="nav-item dropdown">
                    <a class="nav-link link text-white dropdown-toggle display-4" href="#" data-toggle="dropdown-submenu" aria-expanded="false">SITE TEMPLATES</a><div class="dropdown-menu"><a class="text-white dropdown-item display-4" href="one-page.html">One Page Template<br></a><a class="text-white dropdown-item display-4" href="blog.html">Blog Template Demo<br></a><a class="text-white dropdown-item display-4" href="real-estate-template/index.html">Real Estate Template<br></a><a class="text-white dropdown-item display-4" href="restaurant-template/index.html">Restaurant Template<br></a><a class="text-white dropdown-item display-4" href="travel-template/index.html">Travel Template<br></a><a class="text-white dropdown-item display-4" href="wedding-template/index.html">Wedding Template<br></a><a class="text-white dropdown-item display-4" href="hotel-template/index.html">Hotel Template<br></a><a class="text-white dropdown-item display-4" href="landing-page-template/index.html">Landing Page Template<br></a><a class="text-white dropdown-item display-4" href="news-template/index.html">News Template<br></a><a class="text-white dropdown-item display-4" href="profile-template/index.html">Profile Template<br></a><a class="text-white dropdown-item display-4" href="education-template/index.html">Education Template<br></a><a class="text-white dropdown-item display-4" href="coming-soon-template/index.html">Coming Soon Template<br></a><a class="text-white dropdown-item display-4" href="error-page-template/index.html">Error Page Template<br></a><a class="text-white dropdown-item display-4" href="event-template/index.html">Event Template<br></a></div>
                </li><li class="nav-item dropdown open"><a class="nav-link link text-white dropdown-toggle display-4" href="#" aria-expanded="true" data-toggle="dropdown-submenu">SITE TEMPLATES 2</a><div class="dropdown-menu"><a class="text-white dropdown-item display-4" href="about-us-page-template/index.html" aria-expanded="false">About Us Page Template</a><a class="text-white dropdown-item display-4" href="agency-template/index.html" aria-expanded="false">Agency Template</a><a class="text-white dropdown-item display-4" href="application-template/index.html" aria-expanded="false">Application Template</a><a class="text-white dropdown-item display-4" href="business-template/index.html" aria-expanded="false">Business Template</a><a class="text-white dropdown-item display-4" href="corporate-template/index.html" aria-expanded="false">Corporate Template</a><a class="text-white dropdown-item display-4" href="homepage-template/index.html" aria-expanded="false">Homepage Template</a><a class="text-white dropdown-item display-4" href="magazine-template/index.html" aria-expanded="false">Magazine Template</a><a class="text-white dropdown-item display-4" href="agency-template/multi-page-template.html" aria-expanded="false">Multi Page Template</a><a class="text-white dropdown-item display-4" href="personal-website-template/index.html" aria-expanded="false">Personal Website Template</a><a class="text-white dropdown-item display-4" href="photography-template/index.html" aria-expanded="false">Photography Template</a><a class="text-white dropdown-item display-4" href="store-template/index.html" aria-expanded="false">Store Template</a><a class="text-white dropdown-item display-4" href="web-application-template/index.html" aria-expanded="false">Web Application Template</a></div></li></ul>-->
            <div class="navbar-buttons mbr-section-btn"><a class="btn btn-sm btn-primary display-4" href="Login.jsp">LOGIN</a></div>
        </div>
    </nav>
</section>
<section class="mbr-section form1 cid-qv7s7YQkMT" id="form1-73" data-rv-view="11165"   style = "background: linear-gradient(lightblue, white);">
    <div class="container">
        <div class="row justify-content-center">
            <div class="title col-12 col-lg-8">
                <h2 class="mbr-section-title align-center pb-3 mbr-fonts-style display-2">
                    REGISTER</h2>
                <h3 class="mbr-section-subtitle align-center mbr-light pb-3 mbr-fonts-style display-5">
                    Register yourself to submit and propose to ideas.
                </h3>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row justify-content-center">
            <div class="media-container-column col-lg-8">
                    
            
                    <form class="mbr-form" action="Signup" method="post" data-form-title="Mobirise Form">
			<div class="row row-sm-offset">
                            <div class="col-md-4 multi-horizontal" data-for="name">
                                <div class="form-group">
                                    <label class="form-control-label mbr-fonts-style display-7" for="name-form1-73">First Name*</label>
                                    <input type="text" class="form-control" name="fname" data-form-field="FName" required="" id="fname"/>
                                         <div id="uname_response" class="response"></div>
                                </div>
                            </div></div>
							
			<div class="row row-sm-offset">
                            <div class="col-md-4 multi-horizontal" data-for="name">
                                <div class="form-group">
                                    <label class="form-control-label mbr-fonts-style display-7" for="name-form1-73">Last Name*</label>
                                    <input type="text" class="form-control" name="lname" data-form-field="LName" required="" id="name-form1-73">
                                </div>
                            </div></div>
							
                        <div class="row row-sm-offset">
                            <div class="col-md-4 multi-horizontal" data-for="name">
                                <div class="form-group">
                                    <label class="form-control-label mbr-fonts-style display-7" for="name-form1-73">User Name*</label>
                                    <input type="text" class="form-control" name="uname" data-form-field="UName" required="" id="name-form1-73">
                                </div>
                            </div></div>
							
			<div class="row row-sm-offset">
                            <div class="col-md-4 multi-horizontal" data-for="name">
                                <div class="form-group">
                                    <label class="form-control-label mbr-fonts-style display-7" for="name-form1-73">Password*</label>
                                    <input type="password" class="form-control" name="password" data-form-field="Password" required="" id="name-form1-73">
                                </div>
                            </div></div>
							

							
			<div class="row row-sm-offset">
                            <div class="col-md-4 multi-horizontal" data-for="email">
                                <div class="form-group">
                                    <label class="form-control-label mbr-fonts-style display-7" for="email-form1-73">Email*</label>
                                    <input type="email" class="form-control" name="email" data-form-field="Email" required="" id="email-form1-73">
                                </div>
                            </div>
                        </div>
						
			<div class="row row-sm-offset">
                            <div class="col-md-4 multi-horizontal" data-for="name">
                                <div class="form-group">
                                    <label class="form-control-label mbr-fonts-style display-7" for="name-form1-73">Aadhar Number(Optional)</label>
                                    <input type="text" class="form-control" name="aadhar" data-form-field="Aadhar" required="" id="name-form1-73">
                                </div>
                            </div></div>
							
			<div class="row row-sm-offset">
                            <div class="col-md-4 multi-horizontal" data-for="name">
                                <div class="form-group">
                                    <label class="form-control-label mbr-fonts-style display-7" for="name-form1-73">Phone Number*</label>
                                    <input type="text" class="form-control" name="phone" data-form-field="Phone" required="" id="name-form1-73">
                                </div>
                            </div></div>
							
			<div class="row row-sm-offset">
                            <div class="col-md-4 multi-horizontal" data-for="name">
                                <div class="form-group">
                                    <label class="form-control-label mbr-fonts-style display-7" for="name-form1-73">Date Of Birth*</label>
                                    <div class="input-group">
                                        <div class="input-group-addon">
                                                <i class="fa fa-calendar"></i>
                                        </div>
                                        <input class="form-control" id="date" name="dateofbirth" placeholder="DD/MM/YYYY" type="text" required=""/>
                                    </div>
                                </div>
                                <div class="col-sm-10"></div>
                            </div></div>
                     
                     
                        <span class="input-group-btn"><input type="submit" class="btn btn-primary btn-form display-4" value ="REGISTER"/></span>
                    </form>
            </div>
        </div>
    </div>
</section>

    
    <div id ="demo"></div>
    
    <section once="" class="cid-qv5ALL8e7H" id="footer7-3k" data-rv-view="8796">

    

    <div class="mbr-overlay" style="opacity: 0.4; background-color: rgb(51, 42, 104);"></div>

    <div class="container">
        <div class="media-container-row align-center mbr-white">
            <div class="row">
                <ul class="foot-menu">
                    
                    
                    
                    
                    
                <li class="foot-menu-item mbr-fonts-style display-7">
                        <a class="text-white mbr-bold" href="#" target="_blank">About us</a>
                    </li><li class="foot-menu-item mbr-fonts-style display-7">
                        <a class="text-white mbr-bold" href="#" target="_blank">Services</a>
                    </li><li class="foot-menu-item mbr-fonts-style display-7">
                        <a class="text-white mbr-bold" href="#" target="_blank">Get In Touch</a>
                    </li><li class="foot-menu-item mbr-fonts-style display-7">
                        <a class="text-white mbr-bold" href="#" target="_blank">Careers</a>
                    </li><li class="foot-menu-item mbr-fonts-style display-7">
                        <a class="text-white mbr-bold" href="#" target="_blank">Work</a>
                    </li></ul>
            </div>
            <div class="row">
                <div class="social-list align-right pb-2">
                    
                    
                    
                    
                    
                    
                <div class="soc-item">
                        <a href="https://twitter.com/mobirise" target="_blank">
                            <span class="socicon-twitter socicon mbr-iconfont mbr-iconfont-social" media-simple="true"></span>
                        </a>
                    </div><div class="soc-item">
                        <a href="https://www.facebook.com/pages/Mobirise/1616226671953247" target="_blank">
                            <span class="socicon-facebook socicon mbr-iconfont mbr-iconfont-social" media-simple="true"></span>
                        </a>
                    </div><div class="soc-item">
                        <a href="https://www.youtube.com/c/mobirise" target="_blank">
                            <span class="socicon-youtube socicon mbr-iconfont mbr-iconfont-social" media-simple="true"></span>
                        </a>
                    </div><div class="soc-item">
                        <a href="https://instagram.com/mobirise" target="_blank">
                            <span class="socicon-instagram socicon mbr-iconfont mbr-iconfont-social" media-simple="true"></span>
                        </a>
                    </div><div class="soc-item">
                        <a href="https://plus.google.com/u/0/+Mobirise" target="_blank">
                            <span class="socicon-googleplus socicon mbr-iconfont mbr-iconfont-social" media-simple="true"></span>
                        </a>
                    </div><div class="soc-item">
                        <a href="https://www.behance.net/Mobirise" target="_blank">
                            <span class="socicon-behance socicon mbr-iconfont mbr-iconfont-social" media-simple="true"></span>
                        </a>
                    </div></div>
            </div>
            <div class="row row-copirayt">
                <p class="mbr-text mb-0 mbr-fonts-style mbr-white display-7">
                    © Copyright 2018 <a href="index.html" class="text-white">Incognitoos</a>
                </p>
            </div>
        </div>
    </div>
</section>
    
    
    
  <script src="assets-Login/web/assets/jquery/jquery.min.js"></script>
  <script src="assets-Login/popper/popper.min.js"></script>
  <script src="assets-Login/tether/tether.min.js"></script>
  <script src="assets-Login/bootstrap/js/bootstrap.min.js"></script>
  <script src="assets-Login/dropdown/js/script.min.js"></script>
  <script src="assets-Login/touch-swipe/jquery.touch-swipe.min.js"></script>
  <script src="assets-Login/jarallax/jarallax.min.js"></script>
  <script src="assets-Login/smooth-scroll/smooth-scroll.js"></script>
  <script src="assets-Login/theme/js/script.js"></script>
  <script src="assets-Login/formoid/formoid.min.js"></script>
  
  
  <!-- Extra JavaScript/CSS added manually in "Settings" tab -->
<!-- Include jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- Include Date Range Picker -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

<script>
	$(document).ready(function(){
		var date_input=$('input[name="dateofbirth"]'); //our date input has the name "date"
		var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
		date_input.datepicker({
			format: 'yyyy/mm/dd',
			container: container,
			todayHighlight: true,
			autoclose: true,
                        startDate: '1959/01/01',
                        endDate: '2001/12/31'
		})
	})
</script>





<script>
$(document).ready(function(){

   $("#fname").keyup(function(){

      var uname = $("#fname").val().trim();

      if(uname != ''){

         $("#uname_response").show();
         

         $.ajax({
            url: 'uname_check.php',
            type: 'post',
            data: {uname:uname},
            success: function(response){

                if(response > 0){
                    $("#uname_response").html("<span class='not-exists'>* Username Already in use.</span>");
                }else{
                    $("#uname_response").html("<span class='exists'>Available.</span>");
                }

             }
          });
      }else{
         $("#uname_response").hide();
      }

    });

 });
</script>
</html>


    

    




        

      









