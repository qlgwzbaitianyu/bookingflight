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
import com.service.copy.PassengerServiceIpm;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loginmsg = null;
		String resultmsg = null;
		PassengerBean pb = (PassengerBean) session.getAttribute("profile");
		int pass_id = pb.getPass_id();			/* get the user passid from session profile*/
		int zipCode = Integer.parseInt(request.getParameter("zipCode"));
		
		PassengerServiceIpm passengerService = new PassengerServiceIpm();
		PassengerBean updateBean = new PassengerBean(pass_id, pb.getUsername(), pb.getUsertype(), request.getParameter("firstName"), request.getParameter("lastName"), 
				request.getParameter("street"), request.getParameter("city"), 
				request.getParameter("state"), zipCode, 
				request.getParameter("email"));
		
		/* ******* parse int may have problem .... should pass a bean*/
	
	
		passengerService.updateProfile(pass_id, request.getParameter("firstName"), request.getParameter("lastName"), 
									request.getParameter("street"), request.getParameter("city"), 
									request.getParameter("state"), zipCode, request.getParameter("email"));
		
		/* set updatedbean to session and forward request to userhome*/
		request.setAttribute("loginmsg", loginmsg);
		request.setAttribute("resultmsg", resultmsg);
		session.setAttribute("profile", updateBean);
		RequestDispatcher rd = request.getRequestDispatcher("UserHome.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
