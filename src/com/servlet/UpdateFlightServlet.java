package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.FlightBean;
import com.service.copy.FlightServiceIpm;

@WebServlet("/UpdateFlightServlet")
public class UpdateFlightServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String updateFlightMsg = null;
		int flightNumber = Integer.parseInt(request.getParameter("flightNumber"));
		int seat = Integer.parseInt(request.getParameter("seat"));
		String arrtime = request.getParameter("arrtime");
		String arrdate = request.getParameter("arrdate");
		String deptime = request.getParameter("deptime");
		String depdate = request.getParameter("depdate");
		String airport = request.getParameter("airport");
		String depart = request.getParameter("depart");
		String destination = request.getParameter("destination");
		String airplane_producer = request.getParameter("airplane_producer");
		FlightServiceIpm flightService = new FlightServiceIpm();
		FlightBean updateFlightBean = new FlightBean(flightNumber, seat, arrtime, 
									arrdate, deptime, depdate, airport, depart, destination, airplane_producer);
		/* call the service to update the flight bean*/
		if(flightService.updateFlight(updateFlightBean)) {
			updateFlightMsg = "Update Flight Success";
		}
		else {
			updateFlightMsg = "Update Flight Failed";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("UpdateFlight.jsp");	/* set paramter and forward request*/
		request.setAttribute("updateFlightMsg", updateFlightMsg);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
