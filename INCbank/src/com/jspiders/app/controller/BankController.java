package com.jspiders.app.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspiders.app.dto.BankDTO;
import com.jspiders.app.service.BankService;

public class BankController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		String firstName = req.getParameter("fn");
		String lastName = req.getParameter("ln");
		String dateofBirth = req.getParameter("db");
		String userName = req.getParameter("un");
		String address = req.getParameter("add");
		String phoneNo = req.getParameter("ph");
		String saving = req.getParameter("ac1");
		String current = req.getParameter("ac1");
		String female = req.getParameter("g2");
		String male = req.getParameter("g2");
		String password = req.getParameter("psw");
		String ConfirmPassword = req.getParameter("psw1");

		BankDTO bankDTO = new BankDTO();
		bankDTO.setFirstName(firstName);
		bankDTO.setLastName(lastName);
		bankDTO.setDateofBirth(dateofBirth);
		bankDTO.setUserName(userName);
		bankDTO.setAddress(address);
		bankDTO.setPhoneNo(phoneNo);
		bankDTO.setSaving(saving);
		bankDTO.setCurrent(current);
		bankDTO.setFemale(female);
		bankDTO.setMale(male);
		bankDTO.setPassword(password);
		bankDTO.setConfirmPassword(ConfirmPassword);
		bankDTO.setMinbalance(1000.00);

		Random rnd = new Random();
		int accntno1 = rnd.nextInt();

		String accn = "" + accntno1;

		bankDTO.setAccntno(accn);

		BankService bankService = new BankService();
		try {
			String name1 = bankService.registerStudent(bankDTO);
			String accntno11 = bankService.number(bankDTO);

			if (name1 != null && accntno11 != null) {
				req.setAttribute("firstName", name1);
				req.setAttribute("accntno", accntno11);
				rd = req.getRequestDispatcher("/dpa");
			} else {
				req.setAttribute("msg", "Some error occured");
				rd = req.getRequestDispatcher("/bf");

			}
		} catch (SQLException e) {
			e.printStackTrace();
			req.setAttribute("msg",
					"Exception occured!!, Please Register again.");
			rd = req.getRequestDispatcher("/bf");
		}
		rd.forward(req, resp);
	}
}
