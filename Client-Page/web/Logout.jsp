<%-- 
    Document   : Logout
    Created on : 30-Mar-2018, 15:34:23
    Author     : MOHAMED FATHEEM
--%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.io.IOException" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="az">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
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
        %>
        
    
    <script type="text/javascript">
         
         location='AfterLogout.jsp';
         </script>
    </body>
</html>
