/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import java.io.IOException;
//import java.io.InputStream;
import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;

//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Mathan
 */
@MultipartConfig(maxFileSize = 16177215)
public class SubmitIdeas extends HttpServlet {

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
    Connection conn;
    int success = 0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // PrintWriter out = response.getWriter();
        Part filePart = request.getPart("presentation");
        InputStream inputStream = null;
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();

        }
        //PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Get a connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?zeroDateTimeBehavior=convertToNull", "root", "root");
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

        /*try (PrintWriter out = response.getWriter()) {
            // TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Succss</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center><h1>You have successfully submitted your idea<br>Click <a href = 'index.html'>here</a> to go to home</center></h1>");
            out.println("</body>");
            out.println("</html>");
        }*/

        try {
            

            String sql2 = "SELECT COUNT(*) AS COUNT FROM idea_table";
            rs = stmt.executeQuery(sql2);
            int count = 0;
            while (rs.next()) {
                count = Integer.parseInt(rs.getString("COUNT"));
            }
            count++;
            String ideaid = "IDEA" + count;
            String subid = request.getParameter("subid");
            String ideatitle = request.getParameter("ideatitle");
            String ideadesc = request.getParameter("ideadesc");
            sql2 = "INSERT INTO idea_table VALUES ('" + ideaid + "','" + "FORM1" + "','" + ideatitle + "','" + subid + "','" + ideadesc + "')";
            int i = stmt.executeUpdate(sql2);
            String sql = "INSERT INTO filetable values (?,?,?)";
            String sql3 = "SELECT COUNT(*) AS COUNT FROM filetable";
            rs = stmt.executeQuery(sql3);
            int count2 = 0;
            while (rs.next()) {
                count2 = Integer.parseInt(rs.getString("COUNT"));
            }
            count2++;

            String fileid = "FILE" + count2;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, fileid);
            statement.setString(2, ideaid);
            //statement.setString(1, lastName);

            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                statement.setBlob(3, inputStream);
            }

            // sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0) {
                String message = "File uploaded and saved into database";
                System.out.println("" + message);
            }
            
            String[] tags = request.getParameterValues("tags");
            for (String value : tags) {
                System.out.println(value + " ");
            }
            for (String value : tags) {
                //System.out.println(value + " ");
                
                sql = "SELECT Tag_Id FROM tags WHERE Tag_Name = '"+value+"'";
                rs = stmt.executeQuery(sql);
                String tagid = "";
                while(rs.next())
                {
                    tagid = rs.getString("Tag_Id");
                }
                sql = "INSERT INTO idea_tag_table VALUES('"+ideaid+"','"+tagid+"')";
                i = stmt.executeUpdate(sql);
                response.sendRedirect("AfterIdeaSubmit.jsp");
                
            }
            
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());

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
