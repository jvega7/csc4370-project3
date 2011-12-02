import beans.DB;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Login extends HttpServlet{ 
	@Override
 public void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException,IOException{
		DB db = new DB();
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
  if(request.getParameter("username")!=null &&
     		!"".equals(request.getParameter("username")) && request.getParameter("password")!=null &&
     		!"".equals(request.getParameter("password")))
  {
	try {
		username = request.getParameter("username").toString();
		userpass = request.getParameter("password").toString();
		strQuery="select * from customers where username='"+username+"' and  password='"+userpass+"'";
		try {
			db.connect();
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		}

	       System.out.println(strQuery);
		rs = db.execSQL(strQuery);
		int count=0;
		while(rs.next())
		{
		session.setAttribute("username",rs.getString(1));
		count++;
		}
		if(count>0)
		{
		response.sendRedirect("welcome.jsp");
		}
		else
		{
	       response.sendRedirect("login.jsp");
		}
	} catch (SQLException ex) {
		Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
	}
  }
  else
  {
 response.sendRedirect("login.jsp");
  }
  System.out.println("Connected to the database"); 
		try {
			db.close();
		} catch (SQLException ex) {
			Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		}
  System.out.println("Disconnected from database");
  }
}