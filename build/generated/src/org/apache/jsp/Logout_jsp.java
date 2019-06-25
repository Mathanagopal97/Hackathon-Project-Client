package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public final class Logout_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"az\">\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");

            Statement stmt = null;
            ResultSet rs;
            int success = 0;
            // PrintWriter out = response.getWriter();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                //Get a connection
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?zeroDateTimeBehavior=convertToNull", "root", "root");
                stmt = conn.createStatement();
                success++;
            } catch (Exception except) {
                System.out.println("Error: " + except.getMessage());
            }
            if (success == 1) {
                System.out.println("connected");
            } else {
                System.out.println("not connected");
            }
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            String str = sdf.format(d);
            try {
                String sql = "UPDATE ses_main SET OUT_TIME = '" + str + "' WHERE OUT_TIME IS NULL";
                System.out.println(sql);
                int i = stmt.executeUpdate(sql);
                if (i == 1) {
                    System.out.println("Successfully Inserted");
                    //response.sendRedirect("index.html");
                } 
                else
                {
                            out.println("<!DOCTYPE html>");
                            out.println("<html>");
                            out.println("<head>");
                            out.println("<title>Error</title>");
                            out.println("</head>");
                            out.println("<body>");
                            out.println("<script type=\"text/javascript\">");
                            out.println("alert('No User Logged In');");
                            out.println("location='index.html';");
                            out.println("</script>");
                            out.println("</body>");
                            out.println("</html>");
                }
            } catch (Exception e) {
                System.out.println("Error occured"+e.getMessage());

            }
        
      out.write("\n");
      out.write("        \n");
      out.write("    <center> <h2>Successfully logged out</h2>\n");
      out.write("        <h3>Click <a href = \"Login.jsp\">Here</a> To Login Again</h3></center>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("         \n");
      out.write("         location='AfterLogout.jsp';\n");
      out.write("         </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
