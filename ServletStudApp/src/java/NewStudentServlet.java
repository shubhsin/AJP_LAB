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
import java.sql.*;
import java.io.*;
/**
 *
 * @author student
 */
public class NewStudentServlet extends HttpServlet {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/shubhsin";
    static final String USER = "root";
    static final String PASS = "student";
    static Connection conn = null;
    static Statement stmt =null;
  //  ResultSet rs=null;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        Class.forName("com.mysql.jdbc.Driver");
        //System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        }
        catch(ClassNotFoundException | SQLException e) { }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("Student Details!!");
            out.println("</head>");
            out.println("<body>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>NAME</th>");
            out.println("<th>ROLL NO</th>");
            out.println("<th>BRANCH</th>");
            out.println("</tr>");
        
        try {    
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT * from students";
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()) {
            String first = rs.getString("name");
            String roll = rs.getString("roll");
            String branch = rs.getString("branch");
            
                out.println("<tr>");
                out.println("<td>");
                out.println(first);
                out.println("</td>");
                out.println("<td>");
                out.println(roll);
                out.println("</td>");
                out.println("<td>");
                out.println(branch);
                out.println("</td>");
                out.println("</tr>");
            }
        
        
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e){}
        
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
