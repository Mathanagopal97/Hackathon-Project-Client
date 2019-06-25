<%-- 
    Document   : UserSubmitIdeas
    Created on : 30 Mar, 2018, 9:32:25 AM
    Author     : Mathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="az">
    <head>

        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="generator" content="Mobirise v4.6.6, mobirise.com">
        <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">

        <meta name="description" content="">
        <title>Home</title>
        <link rel="stylesheet" href="assets-UserSubmitIdeas/web/assets/mobirise-icons/mobirise-icons.css">
        <link rel="stylesheet" href="assets-UserSubmitIdeas/tether/tether.min.css">
        <link rel="stylesheet" href="assets-UserSubmitIdeas/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets-UserSubmitIdeas/bootstrap/css/bootstrap-grid.min.css">
        <link rel="stylesheet" href="assets-UserSubmitIdeas/bootstrap/css/bootstrap-reboot.min.css">
        <link rel="stylesheet" href="assets-UserSubmitIdeas/animatecss/animate.min.css">
        <link rel="stylesheet" href="assets-UserSubmitIdeas/dropdown/css/style.css">
        <link rel="stylesheet" href="assets-UserSubmitIdeas/theme/css/style.css">
        <link rel="stylesheet" href="assets-UserSubmitIdeas/mobirise/css/mbr-additional.css" type="text/css">





    </head>
    <body>
        <section class="menu cid-qNHKkLoJ6c" once="menu" id="menu2-0">



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
                                INNERPRENEUR
                            </a></span>
                    </div>
                </div>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <!--  <ul class="navbar-nav nav-dropdown" data-app-modern-menu="true"><li class="nav-item">
                              <a class="nav-link link text-white display-4" href="#">
                                  Services
                              </a>
                          </li>
                          <li class="nav-item">
                              <a class="nav-link link text-white display-4" href="#">
                                  About Us
                              </a>
                          </li></ul>-->
                    <div class="navbar-buttons mbr-section-btn">
                        <a class="btn btn-sm btn-primary display-4" href="Logout.jsp">
                            <!--<span class="btn-icon mbri-mobile mbr-iconfont mbr-iconfont-btn">-->
                            </span>
                            Logout
                        </a>
                    </div>
                </div>
            </nav>
        </section>

        <section class="mbr-section form1 cid-qNHKq14Nx2" id="form1-1">




            <div class="container">
                <div class="row justify-content-center">
                    <div class="title col-12 col-lg-8">
                        <h2 class="mbr-section-title align-center pb-3 mbr-fonts-style display-2">
                            GIVE YOUR PROPOSALS HERE</h2>

                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="media-container-column col-lg-8" >


                        <form class="mbr-form" action="GiveProposal" method="post" enctype="multipart/form-data">
                            <div class="row row-sm-offset">
                                <div class="col-md-4 multi-horizontal" data-for="name">
                                    <div class="form-group">
                                        <label class="form-control-label mbr-fonts-style display-7" for="subid">Submitter Id</label>
                                        <input type="text" class="form-control" name="subid" required="" id="subid">
                                    </div>
                                </div></div>
                            <div class="row row-sm-offset">
                                <div class="col-md-4 multi-horizontal" data-for="name">
                                    <div class="form-group">
                                        <label class="form-control-label mbr-fonts-style display-7" for="ideaid">Idea Id</label>
                                        <input type="text" class="form-control" name="ideaid" required="" id="ideaid">
                                    </div>
                                </div></div>
                            <div class="row row-sm-offset">
                                <div class="col-md-4 multi-horizontal" data-for="name">
                                    <div class="form-group">
                                        <label class="form-control-label mbr-fonts-style display-7" for="orgid">Organisation Id</label>
                                        <input type="text" class="form-control" name="orgid" required="" id="orgid">
                                    </div>
                                </div></div>
                            <div class="row row-sm-offset">
                                <div class="col-md-4 multi-horizontal" data-for="ideatitle">
                                    <div class="form-group">
                                        <label class="form-control-label mbr-fonts-style display-7" for="ideatitle">Idea Title</label>
                                        <input type="text" class="form-control" name="ideatitle" data-form-field="ideatitle" required="" id="ideatitle">
                                    </div>
                                </div></div>
                            <br>
                            <div class="row row-sm-offset">
                                <div class="col-md-4 multi-horizontal" data-for="phone">
                                    <label class="form-control-label mbr-fonts-style display-7" for="ideadesc">Select State</label>
                                    <input type="hidden" name="country" id="countryId" value="IN"/>
                                    <select name="state" class="states order-alpha" id="stateId">
                                        <option value="">State</option>
                                    </select>&emsp;&emsp;
                                    <label class="form-control-label mbr-fonts-style display-7" for="ideadesc">Select City</label>
                                    <select name="city" class="cities order-alpha" id="cityId">
                                        <option value="">Select City</option>
                                    </select>
                                    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> 
                                    <script src="//geodata.solutions/includes/statecity.js"></script>
                                </div></div>
                            <br>
                            <div class="row row-sm-offset">
                                <div class="col-md-4 multi-horizontal" data-for="phone">
                                    <label class="form-control-label mbr-fonts-style display-7" for="ideadesc">Upload your presentation:</label>&emsp;
                                    <input type="file" name="presentation" size="50"/>
                                </div></div>



                            <span class="input-group-btn">
                                <button href="" type="submit" class="btn btn-primary btn-form display-4">SUBMIT</button>
                            </span>
                        </form>
                    </div>
                </div>
            </div>
        </section>

        <section once="" class="cid-qNHKBnA7Mo" id="footer6-2">





            <div class="container">
                <div class="media-container-row align-center mbr-white">
                    <div class="col-12">
                        <p class="mbr-text mb-0 mbr-fonts-style display-7">
                            © Copyright 2018 Incognitoos - All Rights Reserved
                        </p>
                    </div>
                </div>
            </div>
        </section>


        <script src="assets-UserSubmitIdeas/web/assets/jquery/jquery.min.js"></script>
        <script src="assets-UserSubmitIdeas/popper/popper.min.js"></script>
        <script src="assets-UserSubmitIdeas/tether/tether.min.js"></script>
        <script src="assets-UserSubmitIdeas/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets-UserSubmitIdeas/smoothscroll/smooth-scroll.js"></script>
        <script src="assets-UserSubmitIdeas/touchswipe/jquery.touch-swipe.min.js"></script>
        <script src="assets-UserSubmitIdeas/viewportchecker/jquery.viewportchecker.js"></script>
        <script src="assets-UserSubmitIdeas/dropdown/js/script.min.js"></script>
        <script src="assets-UserSubmitIdeas/theme/js/script.js"></script>
        <script src="assets-UserSubmitIdeas/formoid/formoid.min.js"></script>


        <div id="scrollToTop" class="scrollToTop mbr-arrow-up"><a style="text-align: center;"><i></i></a></div>
        <input name="animation" type="hidden">
    </body>
</html>
