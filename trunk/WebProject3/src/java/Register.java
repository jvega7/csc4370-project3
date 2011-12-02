/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adam
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {
    
    private void register(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException cnfe){
            System.out.println("com.mysql.jdbc.Driver not found");
        }
        
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String verifyPass = request.getParameter("verifypass");
            String insertString = "INSERT INTO users VALUES (";
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/critchea1","critchea1","peppep");
            Statement stmt = conn.createStatement();
            String userCheck = "SELECT username FROM users WHERE username = '" +username+ "'";
            ResultSet r = stmt.executeQuery(userCheck);
            if (!r.next()) {
                insertString += "'" +username+ "',";
            }
            else {
                out.println("Username " +username+ " already exists.");
            }
            
        } catch (SQLException s) {s.printStackTrace();}
        finally {
            
        }
    }
}
