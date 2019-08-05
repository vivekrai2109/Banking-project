package com.jspiders.app.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jspiders.app.dto.BankDTO;
import com.mysql.jdbc.Connection;

public class BankDAO {
	
	public String regiterStudent(BankDTO bankDTO) throws SQLException{
		String name=null;
		SingletonClass single=SingletonClass.getclass();
		Connection con=SingletonClass.getConnection();
		
		System.out.println(bankDTO.getFirstName());
		
		String query="insert into mybank.register values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(query);
		
		pstmt.setString(1, bankDTO.getAccntno());
		pstmt.setString(2, bankDTO.getFirstName());
		pstmt.setString(3, bankDTO.getLastName());
		pstmt.setString(4, bankDTO.getDateofBirth());
		pstmt.setString(5, bankDTO.getUserName());
		pstmt.setString(6, bankDTO.getAddress());
		pstmt.setString(7, bankDTO.getPhoneNo());
		pstmt.setString(8, bankDTO.getSaving());
		pstmt.setString(9, bankDTO.getCurrent());
		pstmt.setString(10, bankDTO.getFemale());
		pstmt.setString(11, bankDTO.getMale());
		pstmt.setString(12, bankDTO.getPassword());
		pstmt.setString(13, bankDTO.getConfirmPassword());
		pstmt.setDouble(14, bankDTO.getMinbalance());
		
		
		int i = pstmt.executeUpdate();
		if(i==1)
		{
			name=bankDTO.getFirstName();
		}
		
		return name;
	}
	public String number(BankDTO bankDTO) throws SQLException
	{
		String accntno1=null;
		accntno1=bankDTO.getAccntno();
		return accntno1;
	}

}

