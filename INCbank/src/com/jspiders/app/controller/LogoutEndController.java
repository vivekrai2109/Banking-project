package com.jspiders.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class LogoutEndController extends HttpServlet {
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
		System.out.println("-------Logout controller started---------");
		
		
		HttpSession session = req.getSession(false);
		session.invalidate();
		System.out.println("Your are successfully logged out");
		
		RequestDispatcher rd = req.getRequestDispatcher("/logo");
		rd.forward(req, resp);

		}
		
	}
	
