package com.jspiders.app.service;

import com.jspiders.app.dao.LoginDAO;
import com.jspiders.app.dto.BankDTO;

public class LoginService {
	
	public int getService(BankDTO bank)
	{
		LoginDAO dao = new LoginDAO();
		return dao.getdao(bank);
	}
	
	public double checkbalance(BankDTO bank)
	{
		LoginDAO dao = new LoginDAO();
		return dao.viewbalance(bank);
	}
}
