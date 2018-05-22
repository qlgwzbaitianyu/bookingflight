package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.PassengerBean;
import com.service.copy.PassengerServiceIpm;



@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int zipCode = Integer.parseInt(request.getParameter("zipCode"));
		
		PassengerServiceIpm passengerService = new PassengerServiceIpm();
		PassengerBean registerBean = new PassengerBean(0, request.getParameter("uerName"), "user", request.getParameter("firstName"), request.getParameter("lastName"), 
				request.getParameter("street"), request.getParameter("city"), 
				request.getParameter("state"), zipCode, 
				request.getParameter("email"));
		passengerService.register(registerBean, request.getParameter("uerName"), request.getParameter("passWord"));
		
		session.setAttribute("profile", registerBean);
		RequestDispatcher rd = request.getRequestDispatcher("UserHome.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
