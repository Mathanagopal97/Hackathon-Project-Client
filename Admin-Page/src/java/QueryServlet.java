
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author prithvi
 */
@WebServlet(urlPatterns = {"/QueryServlet"})
public class QueryServlet extends HttpServlet {

    Statement stmt;
    ResultSet rs;
    String sql;

    String[] UserName = new String[10];
    String[] UserEmail = new String[30];
    String[] Query = new String[100];

    int count = 0;
    int i = 0;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ResultSet rs2;
    Statement stmt2;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int success = 0;
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            try {
                Class.forName("com.mysql.jdbc.Driver");
                //Get a connection
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?zeroDateTimeBehavior=convertToNull", "root", "root");
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
            /* TODO output your page here. You may use following sample code. */
            try {
                //For count
                String sql = "SELECT COUNT(*) AS COUNT FROM user_query";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    count = Integer.parseInt(rs.getString("COUNT"));
                    //System.out.println(count);
                }

                UserName = new String[count];
                UserEmail = new String[count];
                Query = new String[count];
                String UserId = new String();

                sql = "SELECT * FROM user_query";
                i = 0;
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    UserId = rs.getString(4);
                   // String sql2 = "SELECT * FROM user_details WHERE USER_ID = '" + UserId + "'";
                   // System.out.println(sql2);
                   // rs2 = stmt2.executeQuery(sql2);
                    
                        UserName[i] = rs.getString(2);
                        UserEmail[i] = rs.getString(3);
                    
                    //UserName[i] = rs.getString(1);
                    //UserEmail[i] = rs.getString(2);
                    Query[i] = rs.getString(5);
                    i++;
                }

                /* for( i=0;i<count;i++)
       {
           System.out.println(newsTitle[i]);
           System.out.println(newsDescription[i]);
           System.out.println(submittedby[i]);
           System.out.println(newsImage[i]);
           System.out.println(newsTag[i]);
       }*/
            } catch (Exception e) {
                System.out.println("Error = "+e.getMessage());

            }
            out.println("<!DOCTYPE html>\n"
                    + "<html lang=\"en\">\n"
                    + "  <head>\n"
                    + "    <meta charset=\"utf-8\">\n"
                    + "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                    + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                    + "    <title>Admin Area | Users</title>\n"
                    + "    <!-- Bootstrap core CSS -->\n"
                    + "    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n"
                    + "    <link href=\"css/style.css\" rel=\"stylesheet\">\n"
                    + "    <script src=\"http://cdn.ckeditor.com/4.6.1/standard/ckeditor.js\"></script>\n"
                    + "  </head>\n"
                    + "  <body>\n"
                    + "\n"
                    + "       <nav class=\"navbar navbar-default\">\n"
                    + "      <div class=\"container\">\n"
                    + "        <div class=\"navbar-header\">\n"
                    + "          <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\">\n"
                    + "            <span class=\"sr-only\">Toggle navigation</span>\n"
                    + "            <span class=\"icon-bar\"></span>\n"
                    + "            <span class=\"icon-bar\"></span>\n"
                    + "            <span class=\"icon-bar\"></span>\n"
                    + "          </button>\n"
                    + "          <a class=\"navbar-brand\" href=\"#\">IP</a>\n"
                    + "        </div>\n"
                    + "        <div id=\"navbar\" class=\"collapse navbar-collapse\">\n"
                    + "          <ul class=\"nav navbar-nav\">\n"
                    + "            <li><a href=\"DashboardServlet\">Dashboard</a></li>\n"
                    + "            <li><a href=\"EventServlet\">Events</a></li>\n"
                    + "            <li><a href=\"NewsServlet\">News</a></li>\n"
                    + "            <li class=\"active\"><a href=\"QueryServlet\">Queries</a></li>\n"
                    + "            <li><a href=\"IdeaServlet\">Ideas</a></li>\n"
                    + "            <li><a href=\"UserServlet\">Users</a></li>\n"
                    + "          </ul>\n"
                    + "          <ul class=\"nav navbar-nav navbar-right\">\n"
                    + "            <li><a href=\"#\">Welcome,CSIR </a></li>\n"
                    + "            <li><a href=\"Logout.jsp\">Logout</a></li>\n"
                    + "          </ul>\n"
                    + "        </div><!--/.nav-collapse -->\n"
                    + "      </div>\n"
                    + "    </nav>\n"
                    + "\n"
                    + "    <header id=\"header\">\n"
                    + "      <div class=\"container\">\n"
                    + "        <div class=\"row\">\n"
                    + "          <div class=\"col-md-10\">\n"
                    + "            <h1><span class=\"glyphicon glyphicon-cog\" aria-hidden=\"true\"></span> Dashboard <small>Manage Your Site</small></h1>\n"
                    + "          </div>\n"
                    + "          <div class=\"col-md-2\">\n"
                    + "            <div class=\"dropdown create\">\n"
                    + "              <button class=\"btn btn-default dropdown-toggle\" type=\"button\" id=\"dropdownMenu1\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"true\">\n"
                    + "                Create Content\n"
                    + "                <span class=\"caret\"></span>\n"
                    + "              </button>\n"
                    + "              <ul class=\"dropdown-menu\" aria-labelledby=\"dropdownMenu1\">\n"
                    + "                <li><a type=\"button\" data-toggle=\"modal\" data-target=\"#addEvent\">Add Event</a></li>\n"
                    + "                <li><a type=\"button\" data-toggle=\"modal\" data-target=\"#addNews\">Add News</a></li>\n"
                    + "                <li><a type=\"button\" data-toggle=\"modal\" data-target=\"#addIdea\">Add Idea</a></li>\n"
                    + "                <!--<li><a href=\"#\">Add User</a></li>-->\n"
                    + "              </ul>\n"
                    + "            </div>\n"
                    + "          </div>			\n"
                    + "        </div>\n"
                    + "      </div>\n"
                    + "    </header>\n"
                    + "\n"
                    + "    <section id=\"breadcrumb\">\n"
                    + "      <div class=\"container\">\n"
                    + "        <ol class=\"breadcrumb\">\n"
                    + "          <li class=\"active\">Dashboard</li>\n"
                    + "        </ol>\n"
                    + "      </div>\n"
                    + "    </section>\n"
                    + "\n"
                    + "    <section id=\"main\">\n"
                    + "      <div class=\"container\">\n"
                    + "        <div class=\"row\">\n"
                    + "          <div class=\"col-md-3\">\n"
                    + "            <div class=\"list-group\">\n"
                    + "              <a href=\"DashboardServlet\" class=\"list-group-item active main-color-bg\">\n"
                    + "                <span class=\"glyphicon glyphicon-cog\" aria-hidden=\"true\"></span> Dashboard\n"
                    + "              </a>\n"
                    + "              <a href=\"EventServlet\" class=\"list-group-item\"><span class=\"glyphicon glyphicon-list-alt\" aria-hidden=\"true\"></span> Events </a>\n"
                    + "              <a href=\"NewsServlet\" class=\"list-group-item\"><span class=\"glyphicon glyphicon-pencil\" aria-hidden=\"true\"></span> News </a>\n"
                    + "              <a href=\"QueryServlet\" class=\"list-group-item\"><span class=\"glyphicon glyphicon-pencil\" aria-hidden=\"true\"></span> Queries </a>\n"
                    + "              <a href=\"IdeaServlet\" class=\"list-group-item\"><span class=\"glyphicon glyphicon-pencil\" aria-hidden=\"true\"></span> Idea </a>\n"
                    + "              <a href=\"UserServlet\" class=\"list-group-item\"><span class=\"glyphicon glyphicon-user\" aria-hidden=\"true\"></span> Users </a>\n"
                    + "              <a href=\"ProposalServlet\" class=\"list-group-item\"><span class=\"glyphicon glyphicon-pencil\" aria-hidden=\"true\"></span> Proposals </a>\n"
                    + "            </div>\n"
                    + "\n"
                    + "            <div class=\"well\">\n"
                    + "              <h4>New Users Per Month</h4>\n"
                    + "              <div class=\"progress\">\n"
                    + "                  <div class=\"progress-bar\" role=\"progressbar\" aria-valuenow=\"60\" aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width: 60%;\">\n"
                    + "                      60%\n"
                    + "              </div>\n"
                    + "            </div>\n"
                    + "            <h4>Active Users </h4>\n"
                    + "            <div class=\"progress\">\n"
                    + "                <div class=\"progress-bar\" role=\"progressbar\" aria-valuenow=\"20\" aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width: 20%;\">\n"
                    + "                    20%\n"
                    + "            </div>\n"
                    + "          </div>\n"
                    + "            </div>\n"
                    + "          </div>\n"
                    + "          <div class=\"col-md-9\">\n"
                    + "            <!-- Website Overview -->\n"
                    + "            <div class=\"panel panel-default\">\n"
                    + "              <div class=\"panel-heading main-color-bg\">\n"
                    + "                <h3 class=\"panel-title\">Queries</h3>\n"
                    + "              </div>\n"
                    + "              <div class=\"panel-body\">\n"
                    + "                <div class=\"row\">\n"
                    + "                      <div class=\"col-md-12\">\n"
                    + "                          <input class=\"form-control\" type=\"text\" placeholder=\"Filter Queries...\">\n"
                    + "                      </div>\n"
                    + "                </div>\n"
                    + "                <br>\n"
                    + "                <table class=\"table table-striped table-hover\">\n"
                    + "                      <tr>\n"
                    + "                        <th>Name</th>\n"
                    + "                        <th>Email</th>\n"
                    + "                        <th>Query</th>\n"
                    + "                         <th></th>"
                    + "                        </tr>");
            i = 0;
            while (i < count) {
                out.println("<tr><td class=\"body-item mbr-fonts-style display-7\">" + UserName[i] + "</td><td class=\"body-item mbr-fonts-style display-7\">" + UserEmail[i] + "</td><td class=\"body-item mbr-fonts-style display-7\">" + Query[i] + "</td><td><a class=\"btn btn-default\" href='mailto:"+UserEmail[i]+"'>Reply</a></td></tr>");
                i++;
            }

            out.println("                    </table>\n"
                    + "              </div>\n"
                    + "              </div>\n"
                    + "\n"
                    + "          </div>\n"
                    + "        </div>\n"
                    + "      </div>\n"
                    + "    </section>\n"
                    + "\n"
                    + "    <footer id=\"footer\">\n"
                    + "      <p>Copyright IP, &copy; 2017</p>\n"
                    + "    </footer>\n"
                    + "\n"
                    + "    <!-- Modals -->\n"
                    + "\n"
                    + "  <!-- Add Event -->\n"
                    + "    <div class=\"modal fade\" id=\"addEvent\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">\n"
                    + "  <div class=\"modal-dialog\" role=\"document\">\n"
                    + "    <div class=\"modal-content\">\n"
                    + "      <form action=\"#\" method=\"post\">\n"
                    + "      <div class=\"modal-header\">\n"
                    + "        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n"
                    + "        <h4 class=\"modal-title\" id=\"myModalLabel\">Add Event</h4>\n"
                    + "      </div>\n"
                    + "      <div class=\"modal-body\">\n"
                    + "        <div class=\"form-group\">\n"
                    + "          <label>Event Title</label>\n"
                    + "          <input type=\"text\" name=\"title\" class=\"form-control\" placeholder=\"Event Title\">\n"
                    + "        </div>\n"
                    + "        <div class=\"form-group\">\n"
                    + "          <label>Event Description</label>\n"
                    + "          <textarea name=\"editor1\" name=\"description\" class=\"form-control\" placeholder=\"Event Description\"></textarea>\n"
                    + "        </div>\n"
                    + "		<div class=\"form-group\">\n"
                    + "          <label>Event Date</label>\n"
                    + "          <input type=\"text\" name=\"date\"class=\"form-control\" placeholder=\"Event Date\">\n"
                    + "        </div>\n"
                    + "		<div class=\"form-group\">\n"
                    + "          <label>Event Link</label>\n"
                    + "          <input type=\"text\" name=\"link\" class=\"form-control\" placeholder=\"Event Link\">\n"
                    + "        </div>\n"
                    + "        <!--<div class=\"checkbox\">\n"
                    + "          <label>\n"
                    + "            <input type=\"checkbox\"> Published\n"
                    + "          </label>\n"
                    + "        </div>-->\n"
                    + "        <div class=\"form-group\">\n"
                    + "          <label>Tags</label>\n"
                    + "          <input type=\"text\" name=\"tags\" class=\"form-control\" placeholder=\"Add Some Tags...\">\n"
                    + "        </div>\n"
                    + "       <!-- <div class=\"form-group\">\n"
                    + "          <label>Meta Description</label>\n"
                    + "          <input type=\"text\" class=\"form-control\" placeholder=\"Add Meta Description...\">\n"
                    + "        </div>-->\n"
                    + "      </div>\n"
                    + "      <div class=\"modal-footer\">\n"
                    + "        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n"
                    + "        <button type=\"submit\" class=\"btn btn-primary\">Save changes</button>\n"
                    + "      </div>\n"
                    + "    </form>\n"
                    + "    </div>\n"
                    + "  </div>\n"
                    + "</div>\n"
                    + "    <!-- Add News -->\n"
                    + "    <div class=\"modal fade\" id=\"addNews\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">\n"
                    + "  <div class=\"modal-dialog\" role=\"document\">\n"
                    + "    <div class=\"modal-content\">\n"
                    + "      <form action=\"#\" method=\"post\">\n"
                    + "      <div class=\"modal-header\">\n"
                    + "        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n"
                    + "        <h4 class=\"modal-title\" id=\"myModalLabel\">Add News</h4>\n"
                    + "      </div>\n"
                    + "      <div class=\"modal-body\">\n"
                    + "        <div class=\"form-group\">\n"
                    + "          <label>News Title</label>\n"
                    + "          <input type=\"text\" name =\"title\" class=\"form-control\" placeholder=\"News Title\">\n"
                    + "        </div>\n"
                    + "        <div class=\"form-group\">\n"
                    + "          <label>News Description</label>\n"
                    + "          <textarea name=\"editor1\" name=\"description\" class=\"form-control\" placeholder=\"News Description\"></textarea>\n"
                    + "        </div>\n"
                    + "		<div class=\"form-group\">\n"
                    + "          <label>Upload Image</label>\n"
                    + "          <input type=\"file\" name=\"pic\" accept=\"image/*\">\n"
                    + "        </div>\n"
                    + "        <!--<div class=\"checkbox\">\n"
                    + "          <label>\n"
                    + "            <input type=\"checkbox\"> Published\n"
                    + "          </label>\n"
                    + "        </div>-->\n"
                    + "        <div class=\"form-group\">\n"
                    + "          <label>Tags</label>\n"
                    + "          <input type=\"text\" name=\"tags\" class=\"form-control\" placeholder=\"Add Some Tags...\">\n"
                    + "        </div>\n"
                    + "        <!--<div class=\"form-group\">\n"
                    + "          <label>Meta Description</label>\n"
                    + "          <input type=\"text\" class=\"form-control\" placeholder=\"Add Meta Description...\">\n"
                    + "        </div>-->\n"
                    + "      </div>\n"
                    + "      <div class=\"modal-footer\">\n"
                    + "        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n"
                    + "        <button type=\"submit\" class=\"btn btn-primary\">Save changes</button>\n"
                    + "      </div>\n"
                    + "    </form>\n"
                    + "    </div>\n"
                    + "  </div>\n"
                    + "</div>\n"
                    + "  <script>\n"
                    + "     CKEDITOR.replace( 'editor1' );\n"
                    + " </script>\n"
                    + "\n"
                    + "    <!-- Bootstrap core JavaScript\n"
                    + "    ================================================== -->\n"
                    + "    <!-- Placed at the end of the document so the pages load faster -->\n"
                    + "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n"
                    + "    <script src=\"js/bootstrap.min.js\"></script>\n"
                    + "  </body>\n"
                    + "</html>");
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
