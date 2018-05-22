package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.BookingBean;
import com.beans.PassengerBean;
import com.service.copy.BookingServiceIpm;

/**
 * Servlet implementation class BookingServlet
 */
@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int flightNumber = Integer.parseInt(request.getParameter("flightNumber"));
		PassengerBean passBean = (PassengerBean) session.getAttribute("profile");
		int passengerId = passBean.getPass_id();
		String classType = request.getParameter("classType");
		String baggage = request.getParameter("baggage");
		String page = "ReserveResult.jsp";
		String reserveMessage;
		String classTypeMessage = null;
		
		/*check class type*/
		
		if((classType.equals("first_class") == false && classType.equals("business_class") == false && classType.equals("economy_class") == false)) {
			classTypeMessage = "wrong class type format";
			request.setAttribute("classTypeMessage", classTypeMessage);
			RequestDispatcher classTypeErrorDp = request.getRequestDispatcher("SearchResult.jsp");
			classTypeErrorDp.forward(request, response);
		}
		else {
			/*execute booking service*/
			BookingBean reserveBean = new BookingServiceIpm().bookFlight(flightNumber, passengerId, classType, baggage);
			if(reserveBean == null) {
				/* return user no availabe */
				reserveMessage = null;
			}
			else {
				reserveMessage = "reserve success";
				session.setAttribute("reserveResult", reserveBean);
				
			}
			
			request.setAttribute("reserveMessage", reserveMessage);
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
