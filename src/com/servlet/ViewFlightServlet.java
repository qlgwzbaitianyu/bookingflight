package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.FlightBean;
import com.service.copy.FlightServiceIpm;

@WebServlet("/ViewFlightServlet")
public class ViewFlightServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FlightServiceIpm flightService = new FlightServiceIpm();
		List<FlightBean> flightList = flightService.viewFlight();
		String page = "ViewFlight.jsp";
		String viewFlightMsg;
		
		if(flightList.size() != 0) {		/* available fligts not empty save to request attribute for jsp display*/
			request.setAttribute("flightList", flightList);
			viewFlightMsg = "Available Flights: ";
		}
		else {		/* no flights return msg*/
			viewFlightMsg = "No Available Flights";
		}
		
		/* set param forword the servlet */
		request.setAttribute("viewFlightMsg", viewFlightMsg);
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
