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

<!DOCTYPE html>
<html >
<head>
  <!-- Site made with Mobirise Website Builder v4.6.6, https://mobirise.com -->
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="generator" content="Mobirise v4.6.6, mobirise.com">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
  <link rel="shortcut icon" href="assets/images/logo2.png" type="image/x-icon">
  <meta name="description" content="">
  <title>Home</title>
  <link rel="stylesheet" href="assets-Tables/web/assets/mobirise-icons/mobirise-icons.css">
  <link rel="stylesheet" href="assets-Tables/tether/tether.min.css">
  <link rel="stylesheet" href="assets-Tables/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets-Tables/bootstrap/css/bootstrap-grid.min.css">
  <link rel="stylesheet" href="assets-Tables/bootstrap/css/bootstrap-reboot.min.css">
  <link rel="stylesheet" href="assets-Tables/socicon/css/styles.css">
  <link rel="stylesheet" href="assets-Tables/datatables/data-tables.bootstrap4.min.css">
  <link rel="stylesheet" href="assets-Tables/dropdown/css/style.css">
  <link rel="stylesheet" href="assets-Tables/theme/css/style.css">
  <link rel="stylesheet" href="assets-Tables/mobirise/css/mbr-additional.css" type="text/css">
  
  
  
</head>
<body>
    
  <section class="menu cid-qMrdyoS6WO" once="menu" id="menu1-0">

    

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
                    <a href="https://mobirise.com">
                         <img src="assets/images/logo2.png" alt="Mobirise" style="height: 3.8rem;">
                    </a>
                </span>
                <span class="navbar-caption-wrap">
                    <a class="navbar-caption text-white display-4" href="https://mobirise.com">
                        MOBIRISE
                    </a>
                </span>
            </div>
        </div>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav nav-dropdown" data-app-modern-menu="true"><li class="nav-item">
                    <a class="nav-link link text-white display-4" href="https://mobirise.com">
                        
                        Services
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link link text-white display-4" href="https://mobirise.com">
                        
                        About Us
                    </a>
                </li></ul>
            <div class="navbar-buttons mbr-section-btn">
                <a class="btn btn-sm btn-primary display-4" href="https://mobirise.com">
                    <span class="mbri-save mbr-iconfont mbr-iconfont-btn "></span>
                    Try It Now!
                </a>
            </div>
        </div>
    </nav>
</section>

<section class="engine"><a href="https://mobirise.ws/p">open source web page maker</a></section><section class="section-table cid-qMrek0Bwo1" id="table1-1">

  
  
  <div class="container container-table">
      <h2 class="mbr-section-title mbr-fonts-style align-center pb-3 display-2">
          Table
      </h2>
      <h3 class="mbr-section-subtitle mbr-fonts-style align-center pb-5 mbr-light display-5">
            Click blue "Gear" icon in the top right corner to hide/show search and info, change the the table background and other parameters.  In browser click on the table head to sort the table, use search to filter the table.     
      </h3>
      <div class="table-wrapper">
        <div class="container">
          <div class="row search">
            <div class="col-md-6"></div>
            <div class="col-md-6">
                <div class="dataTables_filter">
                  <label class="searchInfo mbr-fonts-style display-7">Search:</label>
                  <input class="form-control input-sm" disabled="">
                </div>
            </div>
          </div>
        </div>

        <div class="container scroll">
          <table class="table isSearch" cellspacing="0">
            <thead>
              <tr class="table-heads ">
                  
                  
                  
                  
              <th class="head-item mbr-fonts-style display-7">
                      Idea Id</th><th class="head-item mbr-fonts-style display-7">
                      Idea Title</th><th class="head-item mbr-fonts-style display-7">
                      Submitted By</th><th class="head-item mbr-fonts-style display-7">
                      Idea Description</th><th class="head-item mbr-fonts-style display-7">
                      Tags</th></tr>
            </thead>

            <tbody>
              
              
              
              
            <tr><td class="body-item mbr-fonts-style display-7">Hello</td><td class="body-item mbr-fonts-style display-7">hi</td><td class="body-item mbr-fonts-style display-7">How are you</td><td class="body-item mbr-fonts-style display-7">$317.000</td><td class="body-item mbr-fonts-style display-7">$317.000</td></tr>
            <tr><td class="body-item mbr-fonts-style display-7">Jeanna Schmal</td><td class="body-item mbr-fonts-style display-7">44</td><td class="body-item mbr-fonts-style display-7">2016-10-17</td><td class="body-item mbr-fonts-style display-7">$317.000</td><td class="body-item mbr-fonts-style display-7">$317.000</td></tr></tbody>
          </table>
        </div>
        <div class="container table-info-container">
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
        </div>
      </div>
    </div>
</section>

<section once="" class="cid-qMrel373eI mbr-parallax-background" id="footer7-2">

    

    <div class="mbr-overlay" style="opacity: 0.5; background-color: rgb(60, 60, 60);"></div>

    <div class="container">
        <div class="media-container-row align-center mbr-white">
            <div class="row row-links">
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
            <div class="row social-row">
                <div class="social-list align-right pb-2">
                    
                    
                    
                    
                    
                    
                <div class="soc-item">
                        <a href="https://twitter.com/mobirise" target="_blank">
                            <span class="socicon-twitter socicon mbr-iconfont mbr-iconfont-social"></span>
                        </a>
                    </div><div class="soc-item">
                        <a href="https://www.facebook.com/pages/Mobirise/1616226671953247" target="_blank">
                            <span class="socicon-facebook socicon mbr-iconfont mbr-iconfont-social"></span>
                        </a>
                    </div><div class="soc-item">
                        <a href="https://www.youtube.com/c/mobirise" target="_blank">
                            <span class="socicon-youtube socicon mbr-iconfont mbr-iconfont-social"></span>
                        </a>
                    </div><div class="soc-item">
                        <a href="https://instagram.com/mobirise" target="_blank">
                            <span class="socicon-instagram socicon mbr-iconfont mbr-iconfont-social"></span>
                        </a>
                    </div><div class="soc-item">
                        <a href="https://plus.google.com/u/0/+Mobirise" target="_blank">
                            <span class="socicon-googleplus socicon mbr-iconfont mbr-iconfont-social"></span>
                        </a>
                    </div><div class="soc-item">
                        <a href="https://www.behance.net/Mobirise" target="_blank">
                            <span class="socicon-behance socicon mbr-iconfont mbr-iconfont-social"></span>
                        </a>
                    </div></div>
            </div>
            <div class="row row-copirayt">
                <p class="mbr-text mb-0 mbr-fonts-style mbr-white align-center display-7">
                    © Copyright 2017 Mobirise - All Rights Reserved
                </p>
            </div>
        </div>
    </div>
</section>


  <script src="assets-Tables/web/assets/jquery/jquery.min.js"></script>
  <script src="assets-Tables/popper/popper.min.js"></script>
  <script src="assets-Tables/tether/tether.min.js"></script>
  <script src="assets-Tables/bootstrap/js/bootstrap.min.js"></script>
  <script src="assets-Tables/smoothscroll/smooth-scroll.js"></script>
  <script src="assets-Tables/touchswipe/jquery.touch-swipe.min.js"></script>
  <script src="assets-Tables/datatables/jquery.data-tables.min.js"></script>
  <script src="assets-Tables/datatables/data-tables.bootstrap4.min.js"></script>
  <script src="assets-Tables/parallax/jarallax.min.js"></script>
  <script src="assets-Tables/dropdown/js/script.min.js"></script>
  <script src="assets-Tables/theme/js/script.js"></script>
  
  
</body>
</html>