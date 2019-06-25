/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class InsertImage extends HttpServlet {

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
           Blob blob;
           byte b[];
           
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int success = 0;
    PrintWriter out = response.getWriter();
    try{Class.forName("java.sql.DriverManager");
            //Get a connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost/dummy","root","root"); 
            stmt = conn.createStatement();
            success++;}
    catch (Exception except){
            System.out.println(""+except.getMessage());}    
    if (success == 1){System.out.println("connected");}
    else{System.out.println("not connected");}
    
    try
    {
        String filepath="C:/Mathan/Confirmation.JPG";
        InputStream is = new FileInputStream(new File(filepath));
        String sql = "INSERT INTO insimg values (?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setBlob(1, is);
       int i= ps.executeUpdate();
       if (i == 1){System.out.println("Inserted");}
    else{System.out.println("not Inserted");}
       
       sql = "select * from insimg";
       PreparedStatement ps2 = conn.prepareStatement(sql);
       rs = ps.executeQuery();
       
       while(rs.next())
       {
           File file = new File("C:/Mathan/Confirmation2.JPG");
           FileOutputStream fos = new FileOutputStream(file);
           blob = rs.getBlob("photo");
           b = blob.getBytes(1, (int)blob.length());
           fos.write(b);
       }
       
    }
    catch(Exception e)
    {
        System.out.println("Error in inserting image"+e.getMessage());
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
