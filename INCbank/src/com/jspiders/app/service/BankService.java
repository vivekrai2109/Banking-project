package com.jspiders.app.service;
import java.sql.SQLException;

import com.jspiders.app.dao.BankDAO;
import com.jspiders.app.dto.BankDTO;

public class BankService {

	public String registerStudent(BankDTO bankDTO) throws SQLException {
		BankDAO studentDao = new BankDAO();
		String name = studentDao.regiterStudent(bankDTO);
		return name;
}
	public String number(BankDTO bankDTO) throws SQLException{
		BankDAO studentDao = new BankDAO();
		String accntno1=studentDao.number(bankDTO);
		return accntno1;
	}
	
}
