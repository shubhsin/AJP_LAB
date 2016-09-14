/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appledb;

/**
 *
 * @author student
 */
import java.sql.*;
import java.io.*;

class User {
    public String username;
    public String password;
    public String role;
    User(String un, String pw,String urole){
        username = un;
        password = pw;
        role = urole;
    }
}

public class AppleDB {

    /**
     * @param args the command line arguments
     */
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/shubhsin";
    static final String USER = "root";
    static final String PASS = "student";
    static User loggedUser;
    static boolean logged = false;
    static Connection conn = null;
    static Statement stmt =null;
    AppleDB() {
        
    }
    
    public static void main(String[] args) {
    
    try {
        //
        Class.forName("com.mysql.jdbc.Driver");
        //
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
    }
    catch(ClassNotFoundException | SQLException e) { }
    
    while(true) {
    System.out.println("Select Option - ");
    System.out.println("1. Login\n2. Register\n3. Logout\n4. Quit\n");
    String ip = "";
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    try {
    ip = br.readLine();
    }
    catch(Exception e) {}
    
    finally {
        int choice = Integer.parseInt(ip);
        switch(choice) {
                case 1:loginUser();
                       break;
                case 2:registerUser();
                       break;
                case 3:logoutUser();
                       break;
                case 4:System.exit(0);
                       break;
                 
                default: System.exit(0);
                        break;
        }
    }
    }
    }
    
    
    public static void loginUser(){
        System.out.print("Username : ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String un = "";
        String pw = "";
        try {
        un = br.readLine();
        }catch(Exception e) {}
        System.out.print("Password :");
        try{
        pw = br.readLine();}
        catch(Exception e) {}
        
        try {
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT * from users";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            String first = rs.getString("uname");
            String last = rs.getString("pwd");
            String role = rs.getString("role");
            if(un.equals(first) && pw.equals(last)) {
                System.out.println(first +" logged in as "+role );
                logged =true;
                loggedUser = new User(first,last,role);
            }
            
        }
        if(!logged) {
            System.out.println("Sorry Wrong Credentials.");
        }
        
        }
        catch(Exception e){
            
        }
        
        
    }
    
    public static void registerUser() {
        System.out.println("Chose a role");
        System.out.println("1. Student\n2. Teacher\n3. ADMIN\n");
        String ip = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
        ip = br.readLine();
        }
        catch(Exception e) {}
        finally{}
        String uname = "";
        String pwd = "";
        try {
            System.out.println("Username :");
            uname = br.readLine();
            System.out.println("Password :");
            pwd = br.readLine();
        }
        catch(Exception e){}
        finally {
            String role = "";
            int ch = Integer.parseInt(ip);
            switch(ch) {
                case 1:role = "student";
                        break;
                case 2:role = "teacher";
                        break;
                case 3:role = "admin";
                        break;
                default:break;
            }
            try{
            stmt = conn.createStatement();
            String sql;
            PreparedStatement p = null;
            
            sql = "INSERT INTO users values(?,?,?)";
            p = conn.prepareStatement(sql);
            p.setString(1, uname);
            p.setString(2, pwd);
            p.setString(3, role);
            p.execute();
            p.close();

            }
            catch(Exception e) {}
            finally{
                System.out.println("Registered Successfully!");
            }
            
        }
    }
    
    public static void logoutUser() {
        if(logged) {
        loggedUser = null;
        logged = false;
        System.out.println("Logged out successfully");
        }
    }
   
    
}
