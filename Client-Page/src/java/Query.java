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
public class Query extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        int success = 0;
    PrintWriter out = response.getWriter();
    try{Class.forName("com.mysql.jdbc.Driver");
            //Get a connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?zeroDateTimeBehavior=convertToNull","root","root"); 
            stmt = conn.createStatement();
            success++;}
    catch (Exception except){
            System.out.println(""+except.getMessage());}    
    if (success == 1){System.out.println("connected");}
    else{System.out.println("not connected");}
        
    try{
        int qid=0;
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone =  request.getParameter("phone");
        String message = request.getParameter("message");
        
        String sql = "SELECT COUNT(*) AS COUNT FROM user_query";
        rs = stmt.executeQuery(sql);
        while(rs.next())
        {
            qid = 1+Integer.parseInt(rs.getString("COUNT"));
        }
        String id = "QUERY"+qid;
        sql = "INSERT INTO user_query VALUES('"+id+"','"+name+"','"+email+"','"+phone+"','"+message+"')";
        int i = stmt.executeUpdate(sql);
        
        if(i==1){System.out.println("SSuccessfully inserted");
        out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet Signin</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<script type=\"text/javascript\">");
                    out.println("");
                    out.println("location='AfterQuery.jsp';");
                    out.println("</script>");
                    out.println("</body>");
                    out.println("</html>");
        
        }
        else System.out.println("Error in inserting");
        
        //System.out.println(name+email+phone+message+"Qid = "+qid);
        
    }
    catch(Exception e)
    {
        System.out.print(""+e.getMessage());
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
