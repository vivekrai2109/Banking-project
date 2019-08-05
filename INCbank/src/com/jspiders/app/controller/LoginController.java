package com.jspiders.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspiders.app.dto.BankDTO;
import com.jspiders.app.service.LoginService;

@SuppressWarnings("serial")
public class LoginController extends HttpServlet{
	
		int tr=0;
		
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 
		 String userName=req.getParameter("un");
		 String Password= req.getParameter("psw");
		 
		 
		 BankDTO bank=new BankDTO();
		 bank.setUserName(userName);
		 bank.setPassword(Password);
		 
		 
		 
		LoginService ser = new LoginService();
		tr= ser.getService(bank);
		System.out.println(bank.getFirstName()); 
		System.out.println(bank.getLastName());
		System.out.println(bank.getAccntno());
		
		if (tr==1)
		{
		HttpSession session =req.getSession(true);
		
		session.setMaxInactiveInterval(10*50);
		session.setAttribute("firstName", bank.getFirstName());
		session.setAttribute("lastName", bank.getLastName());
		session.setAttribute("acc", bank.getAccntno());
		session.setAttribute("minbalance", bank.getMinbalance());
		
		
		RequestDispatcher rd =req.getRequestDispatcher("/hom");
		rd.forward(req, resp);
		}
		else
		{
			RequestDispatcher rd =req.getRequestDispatcher("/loer");
			rd.forward(req, resp);
		}
		
	
	}
}
	