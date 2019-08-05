package com.jspiders.app.dao;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class SingletonClass 
{
	private static SingletonClass single= new SingletonClass();
	private static Connection con;
	private SingletonClass()
	{	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306","root","tiger");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SingletonClass getclass()
	{
		return single;
	}
	
	public static Connection getConnection()
	{
		return con;
	}
	
	@Override
	protected void finalize() throws Throwable {
		if(con!=null){
			con.close();
		}
	}
}
