package com.jspiders.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jspiders.app.dto.BankDTO;
import com.mysql.jdbc.Connection;

public class LoginDAO {
	
	Connection con=null;
	PreparedStatement pstmnt;
	ResultSet rs=null;
	BankDTO bank;
	
	//--------------------login-----------------------
	
	public int getdao(BankDTO bank)
	{
		String query="select * from mybank.register where userName=? and Password=?";
		try{
			con=SingletonClass.getConnection();
			pstmnt=con.prepareStatement(query);
			System.out.println("-----------------");
		}
		catch (Exception e)
		{
			System.out.println("Exception");
			e.printStackTrace();
		}
		
		try{
			System.out.println(bank.getUserName());
			System.out.println(bank.getPassword());
			
			pstmnt.setString(1,bank.getUserName());
			pstmnt.setString(2,bank.getPassword());
			pstmnt.execute();
			
			rs = pstmnt.getResultSet();
			if(rs.next())
			{
				String acc=rs.getString(1);
				String firstName=rs.getString(2);
				String lastName=rs.getString(3);
				double minbalance = rs.getDouble(14);
				
				System.out.println("db_fn : " + firstName);
				System.out.println("db_ln : " + lastName);
				System.out.println("db_acc : " + acc);
				System.out.println("db_bal" + minbalance);
				
				bank.setFirstName(firstName);
				bank.setLastName(lastName);
				bank.setAccntno(acc);
				bank.setMinbalance(minbalance);
				
				return 1;
		}
			else{
				return 0;
			    }
		}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		return 0;
		
}
	//---------------viewbal------------------

	public double viewbalance(BankDTO dto1) {
		
		double bal = 0.0;

		String accid = dto1.getAccntno();
		
		
		
		System.out.println("ass:-->"+accid);
		
		String qry = "select * from mybank.register where accntno='" + accid
				+ "'";
		try {
			con = SingletonClass.getConnection();
			pstmnt = con.prepareStatement(qry);
			System.out.println("-----------------------");

			pstmnt.execute();
			rs = pstmnt.getResultSet();
			if (rs.next()) {

				 bal = rs.getDouble(14);
				dto1.setMinbalance(bal);

			} else {

				dto1 = null;

			}

		} catch (Exception e) {
			System.out.println("exception");
			e.printStackTrace();
		}
		
		System.out.println("DataBase:-->"+bal);

		return bal;
	}
}