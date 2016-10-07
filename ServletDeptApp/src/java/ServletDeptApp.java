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
public class ServletDeptApp extends HttpServlet {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/shubhsin";
    static final String USER = "root";
    static final String PASS = "student";
    static Connection conn = null;
    static Statement stmt =null;
    PrintWriter out;
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
        response.setContentType("text/html;charset=UTF-8");
        try {
        Class.forName("com.mysql.jdbc.Driver");
        //System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        }
        catch(ClassNotFoundException | SQLException e) { }
        try {
            /* TODO output your page here. You may use following sample code. */
            out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletDeptApp</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Salary Portal</h1>");
            out.println("<form action='ServletDeptApp' method='GET'>");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * from departments";
            ResultSet rs = stmt.executeQuery(sql);
            out.println("<div>");
            out.println("<select name='depts'>");
            while(rs.next()) {
            String deptName = rs.getString("name");
            out.println("<option value=\""+deptName+"\">"+deptName+"</option>");
            }
            out.println("</select>");
            out.println("<br><br>");
            out.println("<input type='submit' value='GET DETAILS'></input>");
            out.println("</form>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
           
        }
        catch (Exception e) {}
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
        String selectedDept = request.getParameter("depts");
        
        try {
        Class.forName("com.mysql.jdbc.Driver");
        //System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        }
        catch(ClassNotFoundException | SQLException e) { }
        try {
            /* TODO output your page here. You may use following sample code. */
            out = response.getWriter();
            
            String sql;
            PreparedStatement p = null;
            sql = "select * from salary where dept=?";
            p = conn.prepareStatement(sql);
            p.setString(1, selectedDept);
            p.execute();
            ResultSet rs = p.executeQuery();
            
            out.println("<br><br>");
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<th>Name</th>");
            out.println("<th>Department</th>");
            out.println("<th>Designation</th>");
            out.println("<th>Salary</th>");
            out.println("</tr>");
            while(rs.next()) {
            String deptName = rs.getString("dept");
            String staffName = rs.getString("name");
            String desgn = rs.getString("desgn");
            String salary = rs.getString("salary");
            out.println("<tr>");
            out.println("<td>"+staffName+"</td>");
            out.println("<td>"+deptName+"</td>");
            out.println("<td>"+desgn+"</td>");
            out.println("<td>"+salary+"</td>");
            out.println("</tr>");
            }
            
            out.println("</table>");
            
        }
        catch(Exception e) {}
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
