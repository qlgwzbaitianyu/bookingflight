package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.PassengerBean;
import com.service.copy.BookingServiceIpm;

@WebServlet("/CancelServlet")
public class CancelServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int bookingId = Integer.parseInt(request.getParameter("bookingId"));	/* pass by hidden field not user input*/
		int flightNumber = Integer.parseInt(request.getParameter("flightNumber"));
		String classType = request.getParameter("classType");
		BookingServiceIpm bookingService = new BookingServiceIpm();
		String cancelMessage;
		
		/* pass bookingId to service to cancel the booking*/
		System.out.println("booking id: " + bookingId + " flight numer: " + flightNumber + "classType: " + classType);
		if(bookingService.cancelReservation(bookingId, flightNumber, classType)) {
			cancelMessage = "cancelation succuss";
		}
		else {
			cancelMessage = "cancelation failed";
		}
		
		request.setAttribute("cancelMessage", cancelMessage);
		RequestDispatcher rd = request.getRequestDispatcher("UserHome.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
