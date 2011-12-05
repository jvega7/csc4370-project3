package servlets;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import beans.DB;
import beans.InventoryItem;
import beans.ShoppingCart;
import beans.User;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author novaterata
 */
public class Checkout extends HttpServlet {

	/** 
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 * @throws SQLException
	 * @throws ClassNotFoundException  
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		try {
			response.setContentType("text/html;charset=UTF-8");
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			DB db = (DB) session.getAttribute("db");
			ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
			String userid = user.getUsername();
			LinkedList<InventoryItem> cartList = cart.getCartList();
			db.connect();
			try {
							DB.writeCartList(userid, cartList);
			} catch (Exception ex) {
				Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
			}
			db.close();
			cart = new ShoppingCart();
			session.setAttribute("cart", cart);
			response.sendRedirect("inventory.jsp");
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}