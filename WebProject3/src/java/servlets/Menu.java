package servlets;



import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;


public class Menu extends HttpServlet {


	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
    public void service (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        // set content type and other response header fields first
        response.setContentType("text/html");

	//String username=request.getParameter("username");
	//String index=request.getParameter("index");
	int index=Integer.parseInt(request.getParameter("index"));
	//if (index==null)index="0";        
// get the communication channel with the requesting client
        PrintWriter out = response.getWriter();
out.println(index);

String address="";
	switch(index){
case 0:
	address="../main.jsp";
	break;
 case 4:
	address="../login.jsp";
	break;
case 1:
	address="../inventory.jsp";
	break;
case 2:
	address="../viewcart.jsp";
	break;
case 3:
	address="../profile.jsp";
	break;
case 5:
	address="../register.jsp";
	break;
case 6:
	address="../main.jsp";
	break;
default:
	 address="../main.jsp";
}
RequestDispatcher dispatcher = request.getRequestDispatcher(address);
dispatcher.forward(request, response);

//out.println(address);

	}

}

