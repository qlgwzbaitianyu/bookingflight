package com.servlet;

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


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String page;
		String loginmsg = null;
		String resultmsg = null;
		HttpSession session = request.getSession();
		
		/* check user valid or not */
		PassengerServiceIpm passengerservice = new PassengerServiceIpm();
		PassengerBean pb = passengerservice.verifyUser(username, password);	/* return the passenger bean pb */
		/* check user valid or not */
		if(pb != null) {
			System.out.println("valid user");
			session.setAttribute("profile", pb);
			page = "UserHome.jsp";
			loginmsg = null;
		}
		else {
			System.out.println("invalid user");
			loginmsg = "invalid user please re-input user name and password !";
			page = "index.jsp";
		}
		/* set param and forward servlet */
		request.setAttribute("loginmsg", loginmsg);
		request.setAttribute("resultmsg", resultmsg);
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
