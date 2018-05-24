package com.servlet;

import java.io.IOException;
import java.util.List;

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


@WebServlet("/ViewReservationServlet")
public class ViewReservationServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PassengerBean passengerBean = (PassengerBean) session.getAttribute("profile");
		
		/* base on user or adimin do the search*/
		if(passengerBean.getUsertype().equals("admin")) {
			List<BookingBean> bookBeanList = new BookingServiceIpm().viewAllReservations();
			String page = "AllReservations.jsp";	/* admin return result to allreseravtion.jsap*/
			String bookingResultMessage;
			
			if(bookBeanList.size() != 0) {
				session.setAttribute("viewBookingresult", bookBeanList);
				bookingResultMessage = "booking result: ";
			}
			else {
				bookingResultMessage = null;
			}
			/* set param forword the servlet */
			request.setAttribute("bookingResultMessage", bookingResultMessage);
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
		else {
			int passengerId = passengerBean.getPass_id();
			List<BookingBean> bookBeanList = new BookingServiceIpm().viewReservations(passengerId);
			String page = "BookingResult.jsp";			/* user retrun to bookingresult.jsp*/
			String bookingResultMessage;
			
			if(bookBeanList.size() != 0) {
				session.setAttribute("viewBookingresult", bookBeanList);
				bookingResultMessage = "booking result: ";
			}
			else {
				bookingResultMessage = null;
			}
			/* set param forword the servlet */
			request.setAttribute("bookingResultMessage", bookingResultMessage);
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
