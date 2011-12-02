/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author novaterata
 */
public class Menu extends HttpServlet {

	/** 
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			// set content type and other response header fields first
			response.setContentType("text/html;charset=UTF-8");

			//String username=request.getParameter("username");
			//String index=request.getParameter("index");
			int index=Integer.parseInt(request.getParameter("index"));
			//if (index==null)index="0";        
			// get the communication channel with the requesting client
			out.println(index);

			String address="";
				switch(index){
			case 0:
				address="main.jsp";
				break;
			 case 4:
				address="login.jsp";
				break;
			case 1:
				address="Inventory";
				break;
			case 2:
				address="viewcart.jsp";
				break;
			case 3:
				address="profile.jsp";
				break;
			case 5:
				address="register.jsp";
				break;
			case 6:
				address="main.jsp";
				break;
			case 7: address="logout.jsp";
				break;
			default:
				 address="main.jsp";
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);

			//out.println(address);


		} finally {			
			out.close();
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/** 
	 * Handles the HTTP <code>GET</code> method.
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		processRequest(request, response);
	}

	/** 
	 * Handles the HTTP <code>POST</code> method.
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
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>
}
