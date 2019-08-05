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
public class ViewBalanceController extends  HttpServlet{
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
		System.out.println("ViewBalanceController doPost");

		BankDTO dto = new BankDTO();
		HttpSession session = req.getSession(false);

		String acc = (String) session.getAttribute("acc");

		System.out.println("SessionObject:-->"+acc);

		dto.setAccntno(acc);

		LoginService service = new LoginService();

	double check=service.checkbalance(dto);
	System.out.println("checking balance");

		if (check != 0.0) {

			double getbal = dto.getMinbalance();
			session.setAttribute("bal", getbal);
			
			String fname=dto.getFirstName();
			String lname=dto.getLastName();
			
			String fullname=""+fname+" "+lname+"";
			
			session.setAttribute("fullname", fullname);
			System.out.println("view bal");
			System.out.println("bal:  " + getbal);

			RequestDispatcher re = req.getRequestDispatcher("/db");
			re.forward(req, resp);

		}
	}
}
