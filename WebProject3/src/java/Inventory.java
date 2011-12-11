

import beans.DB;
import beans.InventoryItem;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.LinkedList;
public class Inventory extends HttpServlet{ 
	@Override
 public void doGet(HttpServletRequest request, HttpServletResponse response)
   throws ServletException,IOException{
  response.setContentType("text/html");
  System.out.println("MySQL Connect Example.");
 String strQuery= ""; 
  Statement st=null;
  ResultSet rs=null;
  HttpSession session = request.getSession(true);
  DB db = new DB();
	try {
		strQuery="SELECT * FROM critchea1.inventory";

		try {
			db.connect();
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		}
		rs = db.execSQL(strQuery);
  		LinkedList<InventoryItem> inventory = new LinkedList();
			InventoryItem item = new InventoryItem();
		while(rs.next())
		{
			int quantity = (int) rs.getInt("quantity");
			if (quantity < 1) continue;
			item = new InventoryItem();
			item.setSku(Long.parseLong(rs.getString("sku")));
			item.setName(rs.getString("name"));
			item.setPrice(Double.parseDouble(rs.getString("price")));
			item.setDescription(rs.getString("description"));
			item.setAvailable(rs.getInt("quantity"));
			File f = new File(getServletContext().getRealPath("")+"/images/"+item.getSku()+".jpg");
			if(!f.exists()){
				response.setContentType("image/jpeg");
				Blob img = rs.getBlob("image");
				item.setImage(getServletContext().getRealPath(""), img.getBytes(1, (int)img.length()));
			}
			inventory.add(item);
		}
		db.setInventory(inventory);
		session.setAttribute("db", db);
		session.setAttribute("item",item);
		db.close();
		response.sendRedirect("inventory.jsp");
	} catch (SQLException ex) {
		Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
	}
  }
}