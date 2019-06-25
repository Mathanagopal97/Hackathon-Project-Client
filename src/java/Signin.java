/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Mathan
 */
public class Signin extends HttpServlet {

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

//Database Connection
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
        String username = request.getParameter("uname");
        String password = request.getParameter("password");
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String str = sdf.format(d);

        try {
            String sql = "SELECT * FROM user_details WHERE USER_NAME = '" + username + "'";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {

                if (password.equals(rs.getString(3))) {
                    //Date d = new Date();
                    //get the generated USER_ID from user_details table
                    String userid = rs.getString(1);
                    sql = "SELECT * FROM ses_main WHERE OUT_TIME IS NULL";
                    rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        if (rs.getString(1) != null) {
                            sql = "INSERT INTO ses_main(USERID,IN_TIME) VALUES('" + userid + "','" + str + "')";
                            int i = stmt.executeUpdate(sql);
                            if (i == 1) {
                                System.out.println("Successfully Inserted");
                            } else {
                                System.out.println("Error Occured");
                            }
                            response.sendRedirect("UserSubmitIdea.jsp");
                        } else {
                            out.println("<!DOCTYPE html>");
                            out.println("<html>");
                            out.println("<head>");
                            out.println("<title>Servlet Signin</title>");
                            out.println("</head>");
                            out.println("<body>");
                            out.println("<script type=\"text/javascript\">");
                            out.println("alert('User already logged in');");
                            out.println("location='index.html';");
                            out.println("</script>");
                            out.println("</body>");
                            out.println("</html>");
                        }
                    }
                    sql = "INSERT INTO ses_main(USERID,IN_TIME) VALUES('" + userid + "','" + str + "')";
                    int i = stmt.executeUpdate(sql);
                    if (i == 1) {
                        System.out.println("Successfully Inserted");
                    } else {
                        System.out.println("Error Occured");
                    }
                    response.sendRedirect("UserSubmitIdeas.jsp");
                } else {
                    //invalid password
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet Signin</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('User or password incorrect');");
                    out.println("location='Login.jsp';");
                    out.println("</script>");
                    out.println("</body>");
                    out.println("</html>");
                }

            } else {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Signin</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<script type=\"text/javascript\">");
                out.println("alert('User or password incorrect');");
                out.println("location='Login.jsp';");
                out.println("</script>");
                out.println("</body>");
                out.println("</html>");
            }

        } catch (Exception except) {
            System.out.println("" + except.getMessage());
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
