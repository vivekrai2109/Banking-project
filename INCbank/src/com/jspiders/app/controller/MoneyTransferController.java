package com.jspiders.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspiders.app.dto.AmountransDTO;
import com.jspiders.app.service.MoneyTransferService;

@SuppressWarnings("serial")
public class MoneyTransferController extends HttpServlet {
		

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
			
		System.out.println("Transfer Started");
	
		
		String accountid = req.getParameter("ra");
		double amount = Double.parseDouble(req.getParameter("am"));
		String receiver_name=req.getParameter("rn");
		String desc = req.getParameter("des");
		
		//----------Setting session false & fetching data from session--------
		
		HttpSession session = req.getSession(false);
		
		String acc = (String) session.getAttribute("acc");
		double bal = (double) session.getAttribute("minbalance");
		String sender_fname = (String) session.getAttribute("firstName");
		String sender_lname= (String) session.getAttribute("lastName");
		
		String full_name = sender_fname+""+sender_lname;
		
		//----------------FETCHED SENDER'S DATA FROM SESSION OBJECT----------
		
		System.out.println("----------------FETCHED SENDER'S DATA FROM SESSION OBJECT in CONTROLLER----------");
		
		System.out.println("Sender accnt no from session : "+acc);
		System.out.println("Sender balance from session : "+bal);
		System.out.println("Sender's Full_name : " + full_name);
		
		
		//-----------Populating the DTO with Sender's and Receiver's data-----------
		
		System.out.println("-------------POPULATING THE DTO-----------------");
		
		AmountransDTO sender = new AmountransDTO();
		AmountransDTO transreceiver = new AmountransDTO();
		sender.setS_accountnu(acc);
		sender.setS_amount(amount);
		sender.setS_balance(bal);
		sender.setS_name(full_name);
		
		transreceiver.setR_accountnu(accountid);
		transreceiver.setR_amount(amount);
		transreceiver.setR_name(receiver_name);
		transreceiver.setDescription(desc);
		
		//----------------SENDER'S DETAILS BEFORE TRANSACTION-------------
		
		System.out.println("----------------SENDER'S DETAILS BEFORE TRANSACTION IN CONTROLLER-------------");
		
		System.out.println("Current balance : "+sender.getS_balance()); 
		System.out.println("Sender's account no. : "+sender.getS_accountnu());
		System.out.println("Amount getting deducted from Sender's account : "+sender.getS_amount());
		
		//----------------RECEIVER'S DETAILS BEFORE TRANSACTION-----------------------------------
		
		System.out.println("----------------RECEIVER'S DETAILS BEFORE TRANSACTION IN CONTROLLER--------------");
		
		System.out.println("Current balance : "+transreceiver.getR_balance()); 
		System.out.println("Receiver's account no. : "+transreceiver.getR_accountnu());
		System.out.println("Amount getting added into Receiver's account : "+transreceiver.getR_amount());
		
		//-----------CALLING THE SERVICE-----------
		
		System.out.println("-----------CALLING THE SERVICE FROM CONTROLLER-----------");
		
		MoneyTransferService mtserv = new MoneyTransferService();
		boolean mtr=mtserv.getMtservice(sender,transreceiver);
		
		//-----------Checking Response is TRUE OR FALSE-----------------------
		
		System.out.println("------------------RECEIVED RESPONSE IN CONTROLLER--------------");
		
		if (mtr==true)
		{
		session.setMaxInactiveInterval(10*50);
		session.setAttribute("current_bal", sender.getS_balance());
		session.setAttribute("transac_id", sender.getS_transaction_id());
		session.setAttribute("racc", transreceiver.getR_accountnu());
		
		System.out.println("--------------------DISPATCHING SUCCESS PAGE------------------");
		
		RequestDispatcher rd =req.getRequestDispatcher("/tsu");
		rd.forward(req, resp);
		}
		else
		{
			System.out.println("--------------DISPATCHING UNSUCCESSFUL PAGE----------------");
			
			RequestDispatcher rd =req.getRequestDispatcher("/ter");
			rd.forward(req, resp);
		}
		
	}

}
