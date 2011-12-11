

import beans.DB;
import beans.InventoryItem;
import beans.ShoppingCart;
import beans.User;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.LinkedList;
public class Login extends HttpServlet{ 
	@Override
 public void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException,IOException{
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  System.out.println("MySQL Connect Example.");
  Connection conn = null;
 String username="";
 String userpass="";
 String strQuery= ""; 
  Statement st=null;
  ResultSet rs=null;
  HttpSession session = request.getSession(true);
  DB db = (DB) session.getAttribute("db");
  User user = (User) session.getAttribute("user");
  if(request.getParameter("username")!=null &&
     		!"".equals(request.getParameter("username")) && request.getParameter("password")!=null &&
     		!"".equals(request.getParameter("password")))
  {
	try {
		username = request.getParameter("username").toString();
		userpass = request.getParameter("password").toString();
		strQuery="select * from critchea1.customers where username='"+username+"' and  password='"+userpass+"'";
		try {
			db.connect();
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		}

	       System.out.println(strQuery);
		rs = db.execSQL(strQuery);
		if(rs.next())
		{
			user.setUsername(rs.getString(1));
			user.setLastName(rs.getString(2));
			user.setFirstName(rs.getString(3));
			user.setAddress(rs.getString(4));
			user.setCity(rs.getString(5));
			user.setState(rs.getString(6));
			user.setZipcode(rs.getInt(7));
			user.setPhone(rs.getLong(8));
			user.setEmail(rs.getString(9));
			user.setPassword(rs.getString(10));
			user.setAdmin(rs.getInt(11) != 0);
			user.setValid(true);
			strQuery = "select * from orders where userid='"+username+"'";
			ResultSet rs2 = db.execSQL(strQuery);
			LinkedList<LinkedList<InventoryItem>> orders = new LinkedList();
			while(rs2.next()){
				ByteArrayInputStream bais;
				ObjectInputStream in;
				LinkedList<InventoryItem> cartList = new LinkedList();
				try {
					in = new ObjectInputStream(rs2.getBinaryStream("cart"));
					LinkedList<InventoryItem> cart = (LinkedList<InventoryItem>) in.readObject();
					in.close();
					orders.add(cart);
					System.out.println("orders size ="+orders.size());
				} catch (IOException ex) {
				ex.printStackTrace();
				} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
				}
			user.setOrders(orders);
			for(int i = 0; i < orders.size(); i++){
				for(int j = 0; j < orders.get(i).size(); j++){
					System.out.println(orders.get(i).get(j).getName());
				}
			}
			}
			session.setAttribute("user",user);
			session.setAttribute("db", db);
			session.setAttribute("cart", new ShoppingCart());
			response.sendRedirect("welcome.jsp");
		}
	} catch (SQLException ex) {
		Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
	}
  }
  else
  {
 response.sendRedirect("login.jsp");
  }
		try {
			db.close();
		} catch (SQLException ex) {
			Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		}
  System.out.println("Disconnected from database");
  }
}