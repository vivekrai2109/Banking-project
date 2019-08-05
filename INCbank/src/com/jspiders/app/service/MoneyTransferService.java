package com.jspiders.app.service;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jspiders.app.dao.MoneyTransferDAO;
import com.jspiders.app.dto.AmountransDTO;

public class MoneyTransferService {
	
	public boolean getMtservice(AmountransDTO senderdto, AmountransDTO receiverdto)
	{
		MoneyTransferDAO mtdao = new MoneyTransferDAO();
		
		boolean flag=false;
		
		System.out.println("sender acc:-" + senderdto.getS_accountnu());
		System.out.println("recv acc:-" + receiverdto.getR_accountnu());
		System.out.println("Amount to be operated :-" + senderdto.getS_amount());
		
		double recBal = mtdao.getReceiverBal(receiverdto);
		System.out.println("Receiving's balance in service Rs : "+ recBal);
		
				// sender Transaction ID
				int minimum = 9999999;
				int maximum = 10000000;
				double randomNum = minimum + (int) (Math.random() * maximum);
				int t_id = (int) randomNum;
				String trans_id = "" + t_id;
				senderdto.setS_transaction_id(trans_id);

				// Receiver Transaction ID
				double randomNumR = minimum + (int) (Math.random() * maximum);
				int t_id1 = (int) randomNumR;
				String trans_id1 = "" + t_id1;
				receiverdto.setR_transaction_id(trans_id1);

				// Date --------------------------
				DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				Date date1 = new Date();
				//String date = df.format(date1);
				senderdto.setDate(df.format(date1));
				receiverdto.setDate(df.format(date1));
				
				double SenderBalance = senderdto.getS_balance();
				double ReceiverAmt = receiverdto.getR_amount();
				
				if (SenderBalance > ReceiverAmt) {
					double currentBal = SenderBalance - ReceiverAmt;

					recBal = recBal + ReceiverAmt;

					senderdto.setS_balance(currentBal);
					receiverdto.setR_balance(recBal);

					try {
						flag = mtdao.getmtDao(senderdto, receiverdto);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {

					return flag;
				}
				return flag;

			}
	}
