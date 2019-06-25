/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mathan
 */
public class Signup extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Statement stmt;
    ResultSet rs;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int success = 0;
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Get a connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?zeroDateTimeBehavior=convertToNull", "root", "root");
            stmt = conn.createStatement();

            success++;
        } catch (Exception except) {
            System.out.println("" + except.getMessage());
        }
        if (success == 1) {
            System.out.println("connected");
        } else {
            System.out.println("not connected");
        }

        //Data Retrieval
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String uname = request.getParameter("uname");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String aadhar = request.getParameter("aadhar");
        String phone = request.getParameter("phone");
        String dateofbirth = request.getParameter("dateofbirth");
        String userid = "";
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String str = sdf.format(d);
        int count = 0;
        try {
            String sql = "SELECT * FROM user_details WHERE EMAIL = '" + email + "'";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                response.setContentType("text/html;charset=UTF-8");
                out.println("\n"
                        + "<!DOCTYPE html>\n"
                        + "<!DOCTYPE html>\n"
                        + "\n"
                        + "\n"
                        + "\n"
                        + "\n"
                        + "\n"
                        + "<head>\n"
                        + "  \n"
                        + "  <meta charset=\"UTF-8\">\n"
                        + "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                        + "  <!-- <meta name=\"generator\" content=\"Mobirise v4.3.5, mobirise.com\"> -->\n"
                        + " <!-- <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> -->\n"
                        + " <!-- <link rel=\"shortcut icon\" href=\"assets/images/logo2.png\" type=\"image/x-icon\"> -->\n"
                        + "  \n"
                        + "  <title>Register</title>\n"
                        + "  <link rel=\"stylesheet\" href=\"assets-Login/web/assets/mobirise-icons/mobirise-icons.css\">\n"
                        + "  <link rel=\"stylesheet\" href=\"assets-Login/tether/tether.min.css\">\n"
                        + "  <link rel=\"stylesheet\" href=\"assets-Login/bootstrap/css/bootstrap.min.css\">\n"
                        + "  <link rel=\"stylesheet\" href=\"assets-Login/bootstrap/css/bootstrap-grid.min.css\">\n"
                        + "  <link rel=\"stylesheet\" href=\"assets-Login/bootstrap/css/bootstrap-reboot.min.css\">\n"
                        + "  <link rel=\"stylesheet\" href=\"assets-Login/dropdown/css/style.css\">\n"
                        + "  <link rel=\"stylesheet\" href=\"assets-Login/theme/css/style.css\">\n"
                        + "  <link rel=\"stylesheet\" href=\"assets-Login/mobirise/css/mbr-additional.css\" type=\"text/css\">\n"
                        + "  <link rel=\"stylesheet\" href=\"assets-Login/socicon/css/styles.css\">\n"
                        + "  \n"
                        + "  \n"
                        + "  <!--formden.js communicates with FormDen server to validate fields and submit via AJAX -->\n"
                        + "<script type=\"text/javascript\" src=\"https://formden.com/static/cdn/formden.js\"></script>\n"
                        + "\n"
                        + "<!-- Special version of Bootstrap that is isolated to content wrapped in .bootstrap-iso -->\n"
                        + "<link rel=\"stylesheet\" href=\"https://formden.com/static/cdn/bootstrap-iso.css\" />\n"
                        + "\n"
                        + "<!--Font Awesome (added because you use icons in your prepend/append)-->\n"
                        + "<link rel=\"stylesheet\" href=\"https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css\" />\n"
                        + "\n"
                        + "<style>.bootstrap-iso .formden_header h2, .bootstrap-iso .formden_header p, .bootstrap-iso form{font-family: Arial, Helvetica, sans-serif; color: black}.bootstrap-iso form button, .bootstrap-iso form button:hover{color: white !important;} .asteriskField{color: red;}\n"
                        + "/* Response */\n"
                        + ".response{\n"
                        + "    padding: 6px;\n"
                        + "    display: none;\n"
                        + "}\n"
                        + "\n"
                        + ".not-exists{\n"
                        + "    color: red;\n"
                        + "}\n"
                        + "\n"
                        + ".exists{\n"
                        + "    color: green;\n"
                        + "}\n"
                        + "</style>\n"
                        + "  \n"
                        + "\n"
                        + "  \n"
                        + "  \n"
                        + "\n"
                        + "</head>\n"
                        + "\n"
                        + "\n"
                        + "    \n"
                        + "<section class=\"menu cid-qv1frvgcz3\" once=\"menu\" id=\"menu1-4r\" data-rv-view=\"8240\">\n"
                        + "\n"
                        + "    \n"
                        + "\n"
                        + "    <nav class=\"navbar navbar-expand beta-menu navbar-dropdown align-items-center navbar-fixed-top navbar-toggleable-sm bg-color transparent\">\n"
                        + "        <button class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
                        + "            <div class=\"hamburger\">\n"
                        + "                <span></span>\n"
                        + "                <span></span>\n"
                        + "                <span></span>\n"
                        + "                <span></span>\n"
                        + "            </div>\n"
                        + "        </button>\n"
                        + "        <div class=\"menu-logo\">\n"
                        + "            <div class=\"navbar-brand\">\n"
                        + "                \n"
                        + "                <span class=\"navbar-caption-wrap\"><a class=\"navbar-caption text-white display-4\" href=\"index.html\">\n"
                        + "                        BOOTSTRAP TEMPLATE</a></span>\n"
                        + "            </div>\n"
                        + "        </div>\n"
                        + "        <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n"
                        + "            <!--<ul class=\"navbar-nav nav-dropdown\" data-app-modern-menu=\"true\"><li class=\"nav-item dropdown\"><a class=\"nav-link link text-white dropdown-toggle display-4\" href=\"blog.html\" data-toggle=\"dropdown-submenu\" aria-expanded=\"false\">\n"
                        + "                        \n"
                        + "                        BLOCK DEMOS 1</a><div class=\"dropdown-menu\"><a class=\"text-white dropdown-item display-4\" href=\"slider.html\">Slider Header Demo</a><a class=\"text-white dropdown-item display-4\" href=\"video-background.html\">Video Background Demo</a><a class=\"text-white dropdown-item display-4\" href=\"footer-template.html\">Footer Template</a><a class=\"text-white dropdown-item display-4\" href=\"table-template.html\">Table Template</a><a class=\"text-white dropdown-item display-4\" href=\"carousel-template.html\">Carousel Template</a><a class=\"text-white dropdown-item display-4\" href=\"blog.html\">Gallery Template</a><a class=\"text-white dropdown-item display-4\" href=\"menu-template.html\">Menu Template</a><a class=\"text-white dropdown-item display-4\" href=\"navigation-menu-template.html\">Navigation Menu Template</a><a class=\"text-white dropdown-item display-4\" href=\"navbar-template.html\">Navbar Template</a><a class=\"text-white dropdown-item display-4\" href=\"header-template.html\">Header Template</a><a class=\"text-white dropdown-item display-4\" href=\"registration-form-template.html\">Registration Form Template</a><a class=\"text-white dropdown-item display-4\" href=\"grid-template.html\">Grid Template</a><a class=\"text-white dropdown-item display-4\" href=\"social-network-template.html\">Social Network Template</a><a class=\"text-white dropdown-item display-4\" href=\"parallax-template.html\">Parallax Template</a><a class=\"text-white dropdown-item display-4\" href=\"parallax-scrolling-template.html\">Parallax Scrolling Template</a></div></li>\n"
                        + "                <li class=\"nav-item dropdown\"><a class=\"nav-link link text-white dropdown-toggle display-4\" href=\"blog.html\" data-toggle=\"dropdown-submenu\" aria-expanded=\"false\">\n"
                        + "                        \n"
                        + "                        BLOCK DEMOS 2</a><div class=\"dropdown-menu\"><a class=\"text-white dropdown-item display-4\" href=\"shopping-cart-template.html\">Shopping Cart Template</a><a class=\"text-white dropdown-item display-4\" href=\"contact-form-template.html\">Contact Form Template</a><a class=\"text-white dropdown-item display-4\" href=\"list-template.html\">List Template</a><a class=\"text-white dropdown-item display-4\" href=\"video-template.html\">Video Template</a><a class=\"text-white dropdown-item display-4\" href=\"photo-gallery-template.html\">Photo Gallery Template</a><a class=\"text-white dropdown-item display-4\" href=\"map-template.html\">Map Template</a><a class=\"text-white dropdown-item display-4\" href=\"faq-template.html\">FAQ Template</a><a class=\"text-white dropdown-item display-4\" href=\"slider-template.html\">Slider Template</a><a class=\"text-white dropdown-item display-4\" href=\"background-template.html\">Video Background Template</a><a class=\"text-white dropdown-item display-4\" href=\"documentation-template.html\">Documentation Template</a><a class=\"text-white dropdown-item display-4\" href=\"article-template.html\">Article Template</a><a class=\"text-white dropdown-item display-4\" href=\"google-maps-template.html\">Google Maps Template</a><a class=\"text-white dropdown-item display-4\" href=\"form-templates.html\">Form Templates </a><a class=\"text-white dropdown-item display-4\" href=\"tab-template.html\">Tab Template</a><a class=\"text-white dropdown-item display-4\" href=\"video-gallery-template.html\">Video Gallery Template</a></div></li>\n"
                        + "                \n"
                        + "                <li class=\"nav-item dropdown\">\n"
                        + "                    <a class=\"nav-link link text-white dropdown-toggle display-4\" href=\"#\" data-toggle=\"dropdown-submenu\" aria-expanded=\"false\">SITE TEMPLATES</a><div class=\"dropdown-menu\"><a class=\"text-white dropdown-item display-4\" href=\"one-page.html\">One Page Template<br></a><a class=\"text-white dropdown-item display-4\" href=\"blog.html\">Blog Template Demo<br></a><a class=\"text-white dropdown-item display-4\" href=\"real-estate-template/index.html\">Real Estate Template<br></a><a class=\"text-white dropdown-item display-4\" href=\"restaurant-template/index.html\">Restaurant Template<br></a><a class=\"text-white dropdown-item display-4\" href=\"travel-template/index.html\">Travel Template<br></a><a class=\"text-white dropdown-item display-4\" href=\"wedding-template/index.html\">Wedding Template<br></a><a class=\"text-white dropdown-item display-4\" href=\"hotel-template/index.html\">Hotel Template<br></a><a class=\"text-white dropdown-item display-4\" href=\"landing-page-template/index.html\">Landing Page Template<br></a><a class=\"text-white dropdown-item display-4\" href=\"news-template/index.html\">News Template<br></a><a class=\"text-white dropdown-item display-4\" href=\"profile-template/index.html\">Profile Template<br></a><a class=\"text-white dropdown-item display-4\" href=\"education-template/index.html\">Education Template<br></a><a class=\"text-white dropdown-item display-4\" href=\"coming-soon-template/index.html\">Coming Soon Template<br></a><a class=\"text-white dropdown-item display-4\" href=\"error-page-template/index.html\">Error Page Template<br></a><a class=\"text-white dropdown-item display-4\" href=\"event-template/index.html\">Event Template<br></a></div>\n"
                        + "                </li><li class=\"nav-item dropdown open\"><a class=\"nav-link link text-white dropdown-toggle display-4\" href=\"#\" aria-expanded=\"true\" data-toggle=\"dropdown-submenu\">SITE TEMPLATES 2</a><div class=\"dropdown-menu\"><a class=\"text-white dropdown-item display-4\" href=\"about-us-page-template/index.html\" aria-expanded=\"false\">About Us Page Template</a><a class=\"text-white dropdown-item display-4\" href=\"agency-template/index.html\" aria-expanded=\"false\">Agency Template</a><a class=\"text-white dropdown-item display-4\" href=\"application-template/index.html\" aria-expanded=\"false\">Application Template</a><a class=\"text-white dropdown-item display-4\" href=\"business-template/index.html\" aria-expanded=\"false\">Business Template</a><a class=\"text-white dropdown-item display-4\" href=\"corporate-template/index.html\" aria-expanded=\"false\">Corporate Template</a><a class=\"text-white dropdown-item display-4\" href=\"homepage-template/index.html\" aria-expanded=\"false\">Homepage Template</a><a class=\"text-white dropdown-item display-4\" href=\"magazine-template/index.html\" aria-expanded=\"false\">Magazine Template</a><a class=\"text-white dropdown-item display-4\" href=\"agency-template/multi-page-template.html\" aria-expanded=\"false\">Multi Page Template</a><a class=\"text-white dropdown-item display-4\" href=\"personal-website-template/index.html\" aria-expanded=\"false\">Personal Website Template</a><a class=\"text-white dropdown-item display-4\" href=\"photography-template/index.html\" aria-expanded=\"false\">Photography Template</a><a class=\"text-white dropdown-item display-4\" href=\"store-template/index.html\" aria-expanded=\"false\">Store Template</a><a class=\"text-white dropdown-item display-4\" href=\"web-application-template/index.html\" aria-expanded=\"false\">Web Application Template</a></div></li></ul>-->\n"
                        + "            <div class=\"navbar-buttons mbr-section-btn\"><a class=\"btn btn-sm btn-primary display-4\" href=\"Login.jsp\">LOGIN</a></div>\n"
                        + "        </div>\n"
                        + "    </nav>\n"
                        + "</section>\n"
                        + "<section class=\"mbr-section form1 cid-qv7s7YQkMT\" id=\"form1-73\" data-rv-view=\"11165\"   style = \"background: linear-gradient(lightblue, white);\">\n"
                        + "    <div class=\"container\">\n"
                        + "        <div class=\"row justify-content-center\">\n"
                        + "            <div class=\"title col-12 col-lg-8\">\n"
                        + "                <h2 class=\"mbr-section-title align-center pb-3 mbr-fonts-style display-2\">\n"
                        + "                    REGISTER</h2>\n"
                        + "                <h3 class=\"mbr-section-subtitle align-center mbr-light pb-3 mbr-fonts-style display-5\">\n"
                        + "                    Register yourself to submit and propose to ideas.\n"
                        + "                </h3>\n"
                        + "            </div>\n"
                        + "        </div>\n"
                        + "    </div>");

                out.println("<div class=\"container\">\n"
                        + "        <div class=\"row justify-content-center\">\n"
                        + "            <div class=\"media-container-column col-lg-8\">");

                out.println("<form class=\"mbr-form\" action=\"Signup\" method=\"post\" data-form-title=\"Mobirise Form\">\n"
                        + "			<div class=\"row row-sm-offset\">\n"
                        + "                            <div class=\"col-md-4 multi-horizontal\" data-for=\"name\">\n"
                        + "                                <div class=\"form-group\">\n"
                        + "                                    <label class=\"form-control-label mbr-fonts-style display-7\" for=\"name-form1-73\">First Name*</label>\n"
                        + "                                    <input type=\"text\" class=\"form-control\" name=\"fname\" data-form-field=\"FName\" required=\"\" id=\"fname\" value = \"" + fname + "\"/>\n"
                        + "                                         <div id=\"uname_response\" class=\"response\"></div>\n"
                        + "                                </div>\n"
                        + "                            </div></div>");

                out.println("<div class=\"row row-sm-offset\">\n"
                        + "                            <div class=\"col-md-4 multi-horizontal\" data-for=\"name\">\n"
                        + "                                <div class=\"form-group\">\n"
                        + "                                    <label class=\"form-control-label mbr-fonts-style display-7\" for=\"name-form1-73\">Last Name*</label>\n"
                        + "                                    <input type=\"text\" class=\"form-control\" name=\"lname\" data-form-field=\"LName\" required=\"\" id=\"lname\" value = \"" + lname + "\">\n"
                        + "                                </div>\n"
                        + "                            </div></div>");

                out.println("<div class=\"row row-sm-offset\">\n"
                        + "                            <div class=\"col-md-4 multi-horizontal\" data-for=\"name\">\n"
                        + "                                <div class=\"form-group\">\n"
                        + "                                    <label class=\"form-control-label mbr-fonts-style display-7\" for=\"name-form1-73\">User Name*</label>\n"
                        + "                                    <input type=\"text\" class=\"form-control\" name=\"uname\" data-form-field=\"UName\" required=\"\" id=\"uname\" value = \"" + uname + "\">\n"
                        + "                                </div>\n"
                        + "                            </div></div>");

                out.println("<div class=\"row row-sm-offset\">\n"
                        + "                            <div class=\"col-md-4 multi-horizontal\" data-for=\"name\">\n"
                        + "                                <div class=\"form-group\">\n"
                        + "                                    <label class=\"form-control-label mbr-fonts-style display-7\" for=\"name-form1-73\">Password*</label>\n"
                        + "                                    <input type=\"password\" class=\"form-control\" name=\"password\" data-form-field=\"Password\" required=\"\" id=\"password\" value = \"" + password + "\">\n"
                        + "                                </div>\n"
                        + "                            </div></div>");

                out.println("<div class=\"row row-sm-offset\">\n"
                        + "                            <div class=\"col-md-4 multi-horizontal\" data-for=\"email\">\n"
                        + "                                <div class=\"form-group\">\n"
                        + "                                    <label class=\"form-control-label mbr-fonts-style display-7\" for=\"email-form1-73\">Email*</label>\n"
                        + "                                    <input type=\"email\" class=\"form-control\" name=\"email\" data-form-field=\"Email\" required=\"\" id=\"email\">\n"
                        + "                                </div>\n"
                        + "                            </div>\n"
                        + "                        </div>");

                out.println("<div id=\"demo\" class=\"demo\"><font color = \"red\">Email already exist</font></div>");

                out.println("<div class=\"row row-sm-offset\">\n"
                        + "                            <div class=\"col-md-4 multi-horizontal\" data-for=\"name\">\n"
                        + "                                <div class=\"form-group\">\n"
                        + "                                    <label class=\"form-control-label mbr-fonts-style display-7\" for=\"name-form1-73\">Aadhar Number*</label>\n"
                        + "                                    <input type=\"text\" class=\"form-control\" name=\"aadhar\" data-form-field=\"Aadhar\" required=\"\" id=\"aadhar\" value = \"" + aadhar + "\">\n"
                        + "                                </div>\n"
                        + "                            </div></div>");

                out.println("<div class=\"row row-sm-offset\">\n"
                        + "                            <div class=\"col-md-4 multi-horizontal\" data-for=\"name\">\n"
                        + "                                <div class=\"form-group\">\n"
                        + "                                    <label class=\"form-control-label mbr-fonts-style display-7\" for=\"name-form1-73\">Phone Number*</label>\n"
                        + "                                    <input type=\"text\" class=\"form-control\" name=\"phone\" data-form-field=\"Phone\" required=\"\" id=\"phone\" value = \"" + phone + "\">\n"
                        + "                                </div>\n"
                        + "                            </div></div>");

                out.println("<div class=\"row row-sm-offset\">\n"
                        + "                            <div class=\"col-md-4 multi-horizontal\" data-for=\"name\">\n"
                        + "                                <div class=\"form-group\">\n"
                        + "                                    <label class=\"form-control-label mbr-fonts-style display-7\" for=\"name-form1-73\">Date Of Birth*</label>\n"
                        + "                                    <div class=\"input-group\">\n"
                        + "                                        <div class=\"input-group-addon\">\n"
                        + "                                                <i class=\"fa fa-calendar\"></i>\n"
                        + "                                        </div>\n"
                        + "                                        <input class=\"form-control\" id=\"date\" name=\"dateofbirth\" placeholder=\"YYYY/MM/DD\" type=\"text\" required=\"\" value = \"" + dateofbirth + "\"/>\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "                                <div class=\"col-sm-10\"></div>\n"
                        + "                            </div></div>\n"
                        + "                     \n"
                        + "                     \n"
                        + "                        <span class=\"input-group-btn\"><input type=\"submit\" class=\"btn btn-primary btn-form display-4\" value =\"REGISTER\"/></span>");

                out.println("</form>\n"
                        + "            </div>\n"
                        + "        </div>\n"
                        + "    </div>\n"
                        + "</section>");

                out.println("<script src=\"assets-Login/web/assets/jquery/jquery.min.js\"></script>\n"
                        + "  <script src=\"assets-Login/popper/popper.min.js\"></script>\n"
                        + "  <script src=\"assets-Login/tether/tether.min.js\"></script>\n"
                        + "  <script src=\"assets-Login/bootstrap/js/bootstrap.min.js\"></script>\n"
                        + "  <script src=\"assets-Login/dropdown/js/script.min.js\"></script>\n"
                        + "  <script src=\"assets-Login/touch-swipe/jquery.touch-swipe.min.js\"></script>\n"
                        + "  <script src=\"assets-Login/jarallax/jarallax.min.js\"></script>\n"
                        + "  <script src=\"assets-Login/smooth-scroll/smooth-scroll.js\"></script>\n"
                        + "  <script src=\"assets-Login/theme/js/script.js\"></script>\n"
                        + "  <script src=\"assets-Login/formoid/formoid.min.js\"></script>\n"
                        + "  \n"
                        + "  \n"
                        + "  <!-- Extra JavaScript/CSS added manually in \"Settings\" tab -->\n"
                        + "<!-- Include jQuery -->\n"
                        + "<script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-1.11.3.min.js\"></script>\n"
                        + "\n"
                        + "<!-- Include Date Range Picker -->\n"
                        + "<script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js\"></script>\n"
                        + "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css\"/>\n"
                        + "\n"
                        + "<script>\n"
                        + "	$(document).ready(function(){\n"
                        + "		var date_input=$('input[name=\"dateofbirth\"]'); //our date input has the name \"date\"\n"
                        + "		var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : \"body\";\n"
                        + "		date_input.datepicker({\n"
                        + "			format: 'yyyy/mm/dd',\n"
                        + "			container: container,\n"
                        + "			todayHighlight: true,\n"
                        + "			autoclose: true,\n"
                        + "                        startDate: '1959/01/01',\n"
                        + "                        endDate: '2001/12/31'\n"
                        + "		})\n"
                        + "	})\n"
                        + "</script>");

            } else {
                sql = "SELECT count(*) AS count FROM user_details";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    count = Integer.parseInt(rs.getString("count"));
                }
                count++;
                userid = "USER" + count;
                System.out.println(userid);
                sql = "INSERT INTO user_details VALUES('" + userid + "','" + uname + "','" + password + "','" + email + "','" + aadhar + "','" + fname + "','" + lname + "','" + phone + "','" + dateofbirth + "','" + str + "')";
                System.out.println(sql);
                int i = stmt.executeUpdate(sql);
                if (i == 1) {
                    System.out.println("Successfully Inserted");
                    response.sendRedirect("Login.jsp");
                } else {
                    System.out.println("Error Occured");
                }
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
