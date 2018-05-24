package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.FlightBean;
import com.service.copy.BookingServiceIpm;
import com.service.copy.FlightServiceIpm;


@WebServlet("/AddFlightServlet")
public class AddFlightServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* get ready the parameters for flightbean and seatbean*/
		String arrTime = request.getParameter("arrTime");
		String arrDate = request.getParameter("arrDate");
		String depTime = request.getParameter("depTime");
		String depDate = request.getParameter("depDate");
		String depart = request.getParameter("depart");
		String destination = request.getParameter("destination");
		String airport = request.getParameter("airport");
		String airplane_producer = request.getParameter("airplane_producer");
		String addResult = null;
		int seat = 0;
		
		/******* check arritme, date.....to be valid...*/
		
		/* handle invalid number input, forward to error page*/
		if((request.getParameter("seat").matches("[0-9]+")) == false) {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			addResult = "wrong input for seat should be a positive number";
			request.setAttribute("addReuslt", addResult);
			rd.forward(request, response);
		}
		else {
			seat = Integer.parseInt(request.getParameter("seat"));
			int first_class = Integer.parseInt(request.getParameter("first_class"));
			int business_class = Integer.parseInt(request.getParameter("business_class"));
			int economy_class = Integer.parseInt(request.getParameter("economy_class"));
			FlightBean flightBean = new FlightBean(0, seat, arrTime, arrDate, depTime, depDate, 
									airport, depart, destination, airplane_producer);
			
			/*Add the flight and check the result*/
			if(new FlightServiceIpm().addFlight(flightBean, first_class, business_class, economy_class)) {
				addResult = "add flight sucess";
			}
			else {
				addResult = "add flight failed";
			}
			/* set parameter and forward the request*/
			request.setAttribute("addReuslt", addResult);
			RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
			rd.forward(request, response);
		}
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
