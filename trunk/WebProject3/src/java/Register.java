/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adam
 */
import beans.DB;
import beans.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends HttpServlet {
    
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
			response.setContentType("text/html;charset=UTF-8");
			HttpSession session = request.getSession();
			User user = new User();
			user.setUsername((String) request.getParameter("username"));
			user.setLastName((String) request.getParameter("last"));
			user.setFirstName((String) request.getParameter("first"));
			user.setAddress((String) request.getParameter("address"));
			user.setCity((String) request.getParameter("city"));
			user.setState((String) request.getParameter("state"));
			user.setZipcode(Integer.parseInt((String) request.getParameter("zipcode")));
			user.setPhone(Long.parseLong(request.getParameter("phone")));
			user.setEmail((String) request.getParameter("email"));
			user.setPassword((String) request.getParameter("password"));
			user.setAdmin(false);
			user.setValid(true);
			DB db = (DB) session.getAttribute("db");
		try {
			db.connect();
			DB.addUser(user);
			db.close();
			session.setAttribute("user", user);
			try {
				response.sendRedirect("welcome.jsp");
			} catch (IOException ex) {
				Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
		}
	
    }
}
