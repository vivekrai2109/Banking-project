package com.jspiders.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jspiders.app.dto.AmountransDTO;
import com.mysql.jdbc.Connection;

public class MoneyTransferDAO {
	
	Connection con=null;
	PreparedStatement pstmnt;
	ResultSet rs=null;
	
	public boolean getmtDao(AmountransDTO senderdto, AmountransDTO receiverdto) throws SQLException 
	{	
		//---------------------------SENDER'S DETAILS-----------------
		
		System.out.println("------------SENDER'S DETAILS-------------");
		
		System.out.println("Sender's accno :"+ senderdto.getS_accountnu());
		System.out.println("sender's amount deducted :"+ senderdto.getS_amount());
		System.out.println("Sender's t_id :"+ senderdto.getS_transaction_id());
		
		//---------------------------RECEIVER'S DETAILS-----------------
		
		System.out.println("------------RECEIVER'S DETAILS-------------");
		
		System.out.println("Receivers's accno :"+ receiverdto.getR_accountnu());
		System.out.println("Receiver's amount added :"+ receiverdto.getR_amount());
		System.out.println("Receiver's name : "+ receiverdto.getR_name());
		System.out.println("Receiver's t_id :"+ receiverdto.getR_transaction_id());
		
		//---------CURRENT BALANCE IN SENDER'S AND RECEIVER'S ACCOUNT-------------
		
		System.out.println("---------CURRENT BALANCE IN SENDER'S AND RECEIVER'S ACCOUNT-------------");
		
		System.out.println("current balance of sender's : "+senderdto.getS_balance());
		System.out.println("current balance of receiver's : "+receiverdto.getR_balance());
		
		//--------UPADTE OPERATION STARTS HERE-------------
		
		System.out.println("--------UPADTE OPERATION STARTS HERE-------------");
		boolean flag1=false;
		String updatequery="update mybank.register set minbalance=? where accntno=?";
		
		try{
			con=SingletonClass.getConnection();
			pstmnt=con.prepareStatement(updatequery);
			con.setAutoCommit(false);
			System.out.println("---------------------------");
	
			pstmnt.setDouble(1,senderdto.getS_balance());
			pstmnt.setString(2,senderdto.getS_accountnu());
			
			pstmnt.executeUpdate();
			
			//-----------------CALLING INSERT OPERATION-------------
			
			MoneyTransferDAO dao = new MoneyTransferDAO();
			flag1 = dao.getinsertDao(senderdto, receiverdto);
		}
			
		catch(Exception e)
		{
			e.printStackTrace();
			con.rollback();
			con.commit();
			System.out.println("Data rolled backed and commited due to transaction error");
		}
		return flag1;
	}
	
	public boolean getinsertDao(AmountransDTO senderdto, AmountransDTO receiverdto) throws SQLException
	{
		String insertquery="insert into mybank.transac values(?,?,?,?,?,?,?,?,?,?,?)";
		try{
			con=SingletonClass.getConnection();
			pstmnt=con.prepareStatement(insertquery);
			
			System.out.println("---------------------------");
		
			pstmnt.setString(1, receiverdto.getR_accountnu());
			pstmnt.setDouble(2, receiverdto.getR_amount());
			pstmnt.setDouble(3, receiverdto.getR_balance());
			pstmnt.setString(4, receiverdto.getR_name());
			pstmnt.setString(5, receiverdto.getR_transaction_id());
			pstmnt.setString(6, receiverdto.getDate());
			
			pstmnt.setString(7, senderdto.getS_accountnu());
			pstmnt.setDouble(8, senderdto.getS_amount());
			pstmnt.setDouble(9, senderdto.getS_balance());
			pstmnt.setString(10, senderdto.getS_name());
			pstmnt.setString(11, senderdto.getS_transaction_id());
			
			pstmnt.executeUpdate();
			con.commit();
			
			System.out.println("Database Updated & Inserted");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			con.rollback();
			con.commit();
			System.out.println("Amount not received so data rolledback and commited due to transaction error");
		}
		
		return true;

}

	public double getReceiverBal(AmountransDTO receiverdto){
		
		String select_query = "select * from mybank.transac where r_accountnu=?";
		double balan = 0.0;
		try {
			con = SingletonClass.getConnection();
			pstmnt = con.prepareStatement(select_query);
			
			System.out.println("-----------------------");
			
			pstmnt.setString(1, receiverdto.getR_accountnu());
			rs = pstmnt.executeQuery();
				if (rs.next()) 
				{
					balan = rs.getDouble("r_balance");
				}
			}
			catch (Exception e) 
			{
				e.printStackTrace();
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					con.commit();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Data not fetched from DB so rolled_back and commited due to transaction error");
			}
		System.out.println("Receiving balance from dao layer");
		System.out.println("get_Receiver_Balance Rs :--" + balan);
		return balan;

	}
}
