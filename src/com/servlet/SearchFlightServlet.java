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

import com.beans.FlightBean;
import com.service.copy.FlightServiceIpm;


@WebServlet("/SearchFlightServlet")
public class SearchFlightServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String depart = request.getParameter("depart");
		String destination = request.getParameter("destination");
		String depdate = request.getParameter("depdate");
		String page;
		String resultmsg;
		HttpSession session = request.getSession();
		FlightServiceIpm flightservice = new FlightServiceIpm();
		
		/*search the flight base on depart, destination and depdate, return a list of flightbean*/
		List<FlightBean> flightlist = flightservice.searchFlight(depart, destination, depdate);
		if(flightlist.size() != 0) {		/*find results save the list for displaying by jsp*/
			session.setAttribute("searchresult", flightlist);
			page = "SearchResult.jsp";
			resultmsg = "search result: ";
		}
		else {
			page = "UserHome.jsp";		/* no matching flights*/
			resultmsg = "no available result";
		}
		
		/* set param forword the servlet */
		request.setAttribute("resultmsg", resultmsg);
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
