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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mathan
 */
public class NIFIdeas extends HttpServlet {

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
    Statement stmt2;
    ResultSet rs;
    ResultSet rs2;
    ResultSet rs3;

    String[] ideaid = new String[10];
    String[] ideatitle = new String[10];
    String[] submittedby = new String[10];
    String[] ideadescr = new String[10];
    
    String[] tags = new String[10];

    int count = 0;
    int i = 0, j = 0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int success = 0;
        PrintWriter out = response.getWriter();
        try {
            Class.forName("java.sql.DriverManager");
            //Get a connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "root");
            stmt = conn.createStatement();
            stmt2 = conn.createStatement();
            success++;
        } catch (Exception except) {
            System.out.println("" + except.getMessage());
        }
        if (success == 1) {
            System.out.println("connected");
        } else {
            System.out.println("not connected");
        }

        try {
            //For count
            String sql = "SELECT COUNT(*) AS COUNT FROM idea_table WHERE Submitter_Id ='ORG6'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                count = Integer.parseInt(rs.getString("COUNT"));
                System.out.println(count);
            }

            ideaid = new String[count];
            ideatitle = new String[count];
            submittedby = new String[count];
            ideadescr = new String[count];
            tags = new String[count];
            int tagcount = 0;

            

            
            System.out.println("Completed declarations");

            sql = "SELECT * FROM idea_table WHERE Submitter_Id ='ORG6'";
            i = 0;
            rs = stmt.executeQuery(sql);
            // System.out.println("Completed First Execution");

            while (rs.next()) {
                ideaid[i] = rs.getString(1);
                ideatitle[i] = rs.getString(3);
                submittedby[i] = rs.getString(4);
                ideadescr[i] = rs.getString(5);
                tags[i] = rs.getString(6);

                
                i++;
                
            }

            for (i = 0; i < count; i++) {
                System.out.println(ideaid[i]);
                System.out.println(ideatitle[i]);
                System.out.println(submittedby[i]);
                System.out.println(ideadescr[i]);
            }
            
        } catch (Exception e) {
            System.out.println("Error "  + e.getMessage());
        }

        response.setContentType("text/html;charset=UTF-8");
        out.println("<html >\n"
                + "<head>\n"
                + "  <!-- Site made with Mobirise Website Builder v4.6.6, # -->\n"
                + "  <meta charset=\"UTF-8\">\n"
                + "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                + "  <meta name=\"generator\" content=\"Mobirise v4.6.6, mobirise.com\">\n"
                + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, minimum-scale=1\">\n"
                + "  <link rel=\"shortcut icon\" href=\"assets/images/logo2.png\" type=\"image/x-icon\">\n"
                + "  <meta name=\"description\" content=\"\">\n"
                + "  <title>Ideas</title>\n"
                + "  <link rel=\"stylesheet\" href=\"assets-Tables/web/assets/mobirise-icons/mobirise-icons.css\">\n"
                + "  <link rel=\"stylesheet\" href=\"assets-Tables/tether/tether.min.css\">\n"
                + "  <link rel=\"stylesheet\" href=\"assets-Tables/bootstrap/css/bootstrap.min.css\">\n"
                + "  <link rel=\"stylesheet\" href=\"assets-Tables/bootstrap/css/bootstrap-grid.min.css\">\n"
                + "  <link rel=\"stylesheet\" href=\"assets-Tables/bootstrap/css/bootstrap-reboot.min.css\">\n"
                + "  <link rel=\"stylesheet\" href=\"assets-Tables/socicon/css/styles.css\">\n"
                + "  <link rel=\"stylesheet\" href=\"assets-Tables/datatables/data-tables.bootstrap4.min.css\">\n"
                + "  <link rel=\"stylesheet\" href=\"assets-Tables/dropdown/css/style.css\">\n"
                + "  <link rel=\"stylesheet\" href=\"assets-Tables/theme/css/style.css\">\n"
                + "  <link rel=\"stylesheet\" href=\"assets-Tables/mobirise/css/mbr-additional.css\" type=\"text/css\">\n"
                + "  \n"
                + "  \n"
                + "  \n"
                + "</head>");
        //Nav Bar Begin
        out.println("<body>\n"
                + "    \n"
                + "  <section class=\"menu cid-qMrdyoS6WO\" once=\"menu\" id=\"menu1-0\">\n"
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
                + "                <span class=\"navbar-caption-wrap\">\n"
                + "                    <a class=\"navbar-caption text-white display-4\" href=\"index.html\">\n"
                + "                        INNERPRENUER\n"
                + "                    </a>\n"
                + "                </span>\n"
                + "            </div>\n"
                + "        </div>\n"
                
                + "<div class=\"navbar-buttons mbr-section-btn\">\n" +
"                        <a class=\"btn btn-sm btn-primary display-4\" href=\"/Project_Final/Ideas\">\n" +
"                            <!--<span class=\"btn-icon mbri-mobile mbr-iconfont mbr-iconfont-btn\">-->\n" +
"                            </span>\n" +
"                            See All Ideas\n" +
"                        </a>\n" +
"                    </div>\n"
                + "        </div>\n"
                + "    </nav>\n"
                + "</section>");
        //Nav Bar end
        //Table Begin

        out.println("<section class=\"engine\"><a href=\"#\">open source web page maker</a></section><section class=\"section-table cid-qMrek0Bwo1\" id=\"table1-1\">\n"
                + "\n"
                + "  \n"
                + "  \n"
                + "  <div class=\"container container-table\">\n"
                + "      <h2 class=\"mbr-section-title mbr-fonts-style align-center pb-3 display-2\">\n"
                + "         NIF Ideas\n"
                + "      </h2>\n"
                + "      <h3 class=\"mbr-section-subtitle mbr-fonts-style align-center pb-5 mbr-light display-5\">\n"
                + "            All the ideas from the NIF are dispalyed here.<br>Click On the Idea Id to submit a proposal.     \n"
                + "      </h3>\n"
                + "      <div class=\"table-wrapper\">\n"
                + "        <div class=\"container\">\n"
                + "          <div class=\"row search\">\n"
                + "            <div class=\"col-md-6\"></div>\n"
                + "            <div class=\"col-md-6\">\n"
                + "                <div class=\"dataTables_filter\">\n"
                + "                  <label class=\"searchInfo mbr-fonts-style display-7\">Search:</label>\n"
                + "                  <input class=\"form-control input-sm\" disabled=\"\">\n"
                + "                </div>\n"
                + "            </div>\n"
                + "          </div>\n"
                + "        </div>\n"
                + "\n"
                + "        <div class=\"container scroll\">\n"
                + "          <table class=\"table isSearch\" cellspacing=\"0\">\n"
                + "            <thead>\n"
                + "              <tr class=\"table-heads \">\n"
                + "                  \n"
                + "                  \n"
                + "                  \n"
                + "                  \n"
                + "              <th class=\"head-item mbr-fonts-style display-7\">\n"
                + "                      Idea Id</th><th class=\"head-item mbr-fonts-style display-7\">\n"
                + "                      Idea Title</th><th class=\"head-item mbr-fonts-style display-7\">\n"
                + "                      Submitted By</th><th class=\"head-item mbr-fonts-style display-7\">\n"
                + "                      Idea Description</th><th class=\"head-item mbr-fonts-style display-7\">\n"
                + "                      Tags</th></tr>\n"
                + "            </thead>\n"
                + "\n"
                + "            <tbody>\n"
                + "              \n"
                + "              \n"
                + "              \n"
                + "              \n");

        i = 0;
        j = 0;
        while (i < count) {
            out.println(" <tr><td class=\"body-item mbr-fonts-style display-7\"><a href =\"ProposalForm.jsp\" class=\"text-black\">" + ideaid[i] + "</td><td class=\"body-item mbr-fonts-style display-7\">" + ideatitle[i] + "</td><td class=\"body-item mbr-fonts-style display-7\">" + submittedby[i] + "</td><td class=\"body-item mbr-fonts-style display-7\">" + ideadescr[i] + "</td><td class=\"body-item mbr-fonts-style display-7\">" + tags[j] + "</a></td></tr>");
            i++;
            j++;
        }

        out.println("</tbody>\n" + "</table>\n");

        out.println("</div>\n"
                + "        <div class=\"container table-info-container\">\n"
                + "          <div class=\"row info\">\n"
                + "            <div class=\"col-md-6\">\n"
                + "              <div class=\"dataTables_info mbr-fonts-style display-7\">\n"
                + "                <span class=\"infoBefore\">Showing</span>\n"
                + "                <span class=\"inactive infoRows\"></span>\n"
                + "                <span class=\"infoAfter\">entries</span>\n"
                + "                <span class=\"infoFilteredBefore\">(filtered from</span>\n"
                + "                <span class=\"inactive infoRows\"></span>\n"
                + "                <span class=\"infoFilteredAfter\"> total entries)</span>\n"
                + "              </div>\n"
                + "            </div>\n"
                + "            <div class=\"col-md-6\"></div>\n"
                + "          </div>\n"
                + "        </div>\n"
                + "      </div>\n"
                + "    </div>\n"
                + "</section>");
        //Footer
        out.println("<section once=\"\" class=\"cid-qMrel373eI mbr-parallax-background\" id=\"footer7-2\">\n"
                + "\n"
                + "    \n"
                + "\n"
                + "    <div class=\"mbr-overlay\" style=\"opacity: 0.5; background-color: rgb(60, 60, 60);\"></div>\n"
                + "\n"
                + "    <div class=\"container\">\n"
                + "        <div class=\"media-container-row align-center mbr-white\">\n"
                + "            <div class=\"row row-links\">\n"
                + "                <ul class=\"foot-menu\">\n"
                + "                    \n"
                + "                    \n"
                + "                    \n"
                + "                    \n"
                + "                    \n"
                + "                <li class=\"foot-menu-item mbr-fonts-style display-7\">\n"
                + "                        <a class=\"text-white mbr-bold\" href=\"#\" target=\"_blank\">About us</a>\n"
                + "                    </li><li class=\"foot-menu-item mbr-fonts-style display-7\">\n"
                + "                        <a class=\"text-white mbr-bold\" href=\"#\" target=\"_blank\">Services</a>\n"
                + "                    </li><li class=\"foot-menu-item mbr-fonts-style display-7\">\n"
                + "                        <a class=\"text-white mbr-bold\" href=\"#\" target=\"_blank\">Get In Touch</a>\n"
                + "                    </li><li class=\"foot-menu-item mbr-fonts-style display-7\">\n"
                + "                        <a class=\"text-white mbr-bold\" href=\"#\" target=\"_blank\">Careers</a>\n"
                + "                    </li><li class=\"foot-menu-item mbr-fonts-style display-7\">\n"
                + "                        <a class=\"text-white mbr-bold\" href=\"#\" target=\"_blank\">Work</a>\n"
                + "                    </li></ul>\n"
                + "            </div>\n"
                + "            <div class=\"row social-row\">\n"
                + "                <div class=\"social-list align-right pb-2\">\n"
                + "                    \n"
                + "                    \n"
                + "                    \n"
                + "                    \n"
                + "                    \n"
                + "                    \n"
                + "                <div class=\"soc-item\">\n"
                + "                        <a href=\"https://twitter.com/mobirise\" target=\"_blank\">\n"
                + "                            <span class=\"socicon-twitter socicon mbr-iconfont mbr-iconfont-social\"></span>\n"
                + "                        </a>\n"
                + "                    </div><div class=\"soc-item\">\n"
                + "                        <a href=\"https://www.facebook.com/pages/Mobirise/1616226671953247\" target=\"_blank\">\n"
                + "                            <span class=\"socicon-facebook socicon mbr-iconfont mbr-iconfont-social\"></span>\n"
                + "                        </a>\n"
                + "                    </div><div class=\"soc-item\">\n"
                + "                        <a href=\"https://www.youtube.com/c/mobirise\" target=\"_blank\">\n"
                + "                            <span class=\"socicon-youtube socicon mbr-iconfont mbr-iconfont-social\"></span>\n"
                + "                        </a>\n"
                + "                    </div><div class=\"soc-item\">\n"
                + "                        <a href=\"https://instagram.com/mobirise\" target=\"_blank\">\n"
                + "                            <span class=\"socicon-instagram socicon mbr-iconfont mbr-iconfont-social\"></span>\n"
                + "                        </a>\n"
                + "                    </div><div class=\"soc-item\">\n"
                + "                        <a href=\"https://plus.google.com/u/0/+Mobirise\" target=\"_blank\">\n"
                + "                            <span class=\"socicon-googleplus socicon mbr-iconfont mbr-iconfont-social\"></span>\n"
                + "                        </a>\n"
                + "                    </div><div class=\"soc-item\">\n"
                + "                        <a href=\"https://www.behance.net/Mobirise\" target=\"_blank\">\n"
                + "                            <span class=\"socicon-behance socicon mbr-iconfont mbr-iconfont-social\"></span>\n"
                + "                        </a>\n"
                + "                    </div></div>\n"
                + "            </div>\n"
                + "            <div class=\"row row-copirayt\">\n"
                + "                <p class=\"mbr-text mb-0 mbr-fonts-style mbr-white align-center display-7\">\n"
                + "                    © Copyright 2017 Mobirise - All Rights Reserved\n"
                + "                </p>\n"
                + "            </div>\n"
                + "        </div>\n"
                + "    </div>\n"
                + "</section>");
        //Script Files
        out.println("<script src=\"assets-Tables/web/assets/jquery/jquery.min.js\"></script>\n"
                + "  <script src=\"assets-Tables/popper/popper.min.js\"></script>\n"
                + "  <script src=\"assets-Tables/tether/tether.min.js\"></script>\n"
                + "  <script src=\"assets-Tables/bootstrap/js/bootstrap.min.js\"></script>\n"
                + "  <script src=\"assets-Tables/smoothscroll/smooth-scroll.js\"></script>\n"
                + "  <script src=\"assets-Tables/touchswipe/jquery.touch-swipe.min.js\"></script>\n"
                + "  <script src=\"assets-Tables/datatables/jquery.data-tables.min.js\"></script>\n"
                + "  <script src=\"assets-Tables/datatables/data-tables.bootstrap4.min.js\"></script>\n"
                + "  <script src=\"assets-Tables/parallax/jarallax.min.js\"></script>\n"
                + "  <script src=\"assets-Tables/dropdown/js/script.min.js\"></script>\n"
                + "  <script src=\"assets-Tables/theme/js/script.js\"></script>\n"
                + "  \n"
                + "  \n"
                + "</body>\n"
                + "</html>");
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
