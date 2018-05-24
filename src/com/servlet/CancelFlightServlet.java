package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.copy.FlightServiceIpm;

@WebServlet("/CancelFlightServlet")
public class CancelFlightServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FlightServiceIpm flightService = new FlightServiceIpm();
		String cancelFlightMsg = null;
		
		/*pass flightNumber to service and delete the flight and its corresponding seat row*/
		if(flightService.cancelFlight(request.getParameter("flightNumber"))) {
			cancelFlightMsg = "Cancel Success";
		}
		else {
			cancelFlightMsg = "Cancel Failed";
		}
		
		request.setAttribute("cancelFlightMsg", cancelFlightMsg);
		RequestDispatcher rd = request.getRequestDispatcher("CancelFlightResult.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
