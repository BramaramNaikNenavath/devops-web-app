package com.tek.controllers;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.tek.beans.Register;
import com.tek.dao.RegisterDao;

@WebServlet(name = "register", urlPatterns = { "/register" })
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 3351672454545978750L;
	private static Logger log = Logger.getLogger(RegisterController.class);

	public RegisterController() {
		log.info(">> RegisterController Initiated >> ");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info(" >> Forwarding to Register.jsp >> ");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("register.jsp");
		requestDispatcher.forward(request, response);

		/*
		 * int status = response.getStatus(); String servletPath =
		 * request.log.info(">> status >> " + status + " " + servletPath); if (status ==
		 * HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION || status == 200) {
		 * response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); RequestDispatcher
		 * requestDispatcher = request.getRequestDispatcher("register.jsp");
		 * requestDispatcher.forward(request, response); } else { RequestDispatcher
		 * requestDispatcher = request.getRequestDispatcher("login.jsp");
		 * requestDispatcher.forward(request, response); }
		 */

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info(">> RegisterController doPost() invoked >> ");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String empid = request.getParameter("empid");
		String mobile = request.getParameter("mobile");

		Register register = new Register(userName, email, password, empid, mobile);
		RegisterDao dao = new RegisterDao();
		dao.register(register);
		response.sendRedirect("login");
	}
}
