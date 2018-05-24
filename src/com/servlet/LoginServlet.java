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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		String page;
		String loginmsg = null;
		String resultmsg = null;
		HttpSession session = request.getSession();
		
		/* check user valid or not by calling serfice */
		PassengerServiceIpm passengerservice = new PassengerServiceIpm();
		PassengerBean passengerBean = passengerservice.verifyUser(userName, passWord);	/* return the passenger bean pb */
		if(passengerBean != null) {
			/* check its user or admin, set passengerben to the session */
			if(passengerBean.getUsertype().equals("admin")) {
				session.setAttribute("profile", passengerBean);
				page = "AdminHome.jsp";		/* redirect to admin's home*/
				loginmsg = null;
			}
			else {
				session.setAttribute("profile", passengerBean);
				page = "UserHome.jsp";		/* redirect to user's home*/
				loginmsg = null;
			}
		}
		else {
			loginmsg = "invalid user please re-input user name and password !";
			page = "index.jsp";
		}
		
		request.setAttribute("loginmsg", loginmsg);		/* set param and forward request */
		request.setAttribute("resultmsg", resultmsg);
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
