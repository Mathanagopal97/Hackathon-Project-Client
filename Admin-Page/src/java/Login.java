/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MOHAMED FATHEEM
 */
public class Login extends HttpServlet {

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
    int success = 0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            String sql = "SELECT * FROM organisationlogin WHERE Uname = '" + username + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                if (password.equals(rs.getString(4))) {
                    Date d;
                    d = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                    String str = sdf.format(d);
                    sql = "INSERT INTO org_ses_main (ORGID,IN_TIME) VALUES ('"+rs.getString(1)+"','"+str+"')";
                    int i = stmt.executeUpdate(sql);
                    if(i==1) System.out.println("Inserted Successfully");
                    else System.out.println("Not Inserted");
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Success</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Successfully loged in');");
                    out.println("location='/WebApplication2/DashboardServlet';");
                    out.println("</script>");
                    out.println("</body>");
                    out.println("</html>");
                } else {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Failure</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Username or password incorrect');");
                    out.println("location='index.html';");
                    out.println("</script>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
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
