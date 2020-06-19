package com.tek.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.tek.dao.LoginDao;

@WebServlet(name = "login", urlPatterns = { "/auth", "/login" })
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = -8374891445343394987L;
	private static Logger log = Logger.getLogger(LoginController.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info(">> LoginController doGet() navigating to Login Page >> ");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
		requestDispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info(" >> LoginController doPost() >> ");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username != null && password != null) {
			boolean isValidUser = LoginDao.loginAuth(username, password);

			if (isValidUser) {
				log.info(" >> User is Valid >> ");
				response.sendRedirect("dashboard");
			} else {
				log.info(" >> User is InValid >> ");
				response.setStatus(HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION);
				response.sendRedirect("register");
			}
		}
	}
}
