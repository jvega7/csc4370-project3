package servlets;

import beans.DB;
import beans.InventoryItem;
import beans.ShoppingCart;
import beans.User;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cody
 */
public class Removefromcart extends HttpServlet{
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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		response.setContentType("text/html");
		int index=Integer.parseInt(request.getParameter("index"));
		Statement st=null;
		ResultSet rs=null;
		HttpSession session = request.getSession(true);
		DB db = (DB) session.getAttribute("db");
		LinkedList<InventoryItem> inventory = db.getInventory();
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		InventoryItem item = inventory.get(index);
		LinkedList<InventoryItem> cartList;
		double total;
                cartList = cart.getCartList();
                total = cart.getTotal() - item.getPrice();
		cartList.remove(index);
		cart.setTotal(total);
		cart.setCartList(cartList);
		session.setAttribute("cart", cart);
		response.sendRedirect("inventory.jsp");
    }
    
}
