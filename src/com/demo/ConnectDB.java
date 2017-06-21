package com.demo;

import java.sql.*;

public class ConnectDB {
	
	Connection con;
	PreparedStatement ps;
	
	public ConnectDB() {
		// TODO Auto-generated constructor stub
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mydata","root","password");
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}

	public void create(String title, String author, double price) {
		// TODO Auto-generated method stub
		try
		{
			ps = con.prepareStatement("Insert into Books(title,author,price) values (?,?,?);");
			float p = (float)price;
			ps.setString(1, title);
			ps.setString(2, author);
			ps.setFloat(3, p);
			
			ps.execute();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

	public ResultSet fetch(int id) {
		// TODO Auto-generated method stub
	ResultSet rs = null;
		try
	{
		ps = con.prepareStatement("Select * from Books where id = ?");
		ps.setInt(1, id);
		rs = ps.executeQuery();
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		//System.out.println("Invalid Book id");
	}
	return rs;
		
	}

	public ResultSet displayAll() {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		try
		{
			ps = con.prepareStatement("Select * from Books");
			rs = ps.executeQuery();
			
			
			
			/*while(rs.next())
			{
				System.out.println("Book id: " + rs.getInt("id") + " Title: " + rs.getString("title")
				+ " Author: "+ rs.getString("author")+ " Price: " + rs.getFloat("price"));
			}
			System.out.println("");
			System.out.println("------------------------------------------");*/
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//System.out.println("Invalid Book id");
		}
		
		return rs;
		
	}

	public void exit() {
		// TODO Auto-generated method stub
		try
		{
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

	public void remove(int id) {
		// TODO Auto-generated method stub
		try
		{
			ps = con.prepareStatement("delete from books where id = ?;");
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public void updatePrice(int id, double price) {
		// TODO Auto-generated method stub
		try
		{
			ps = con.prepareStatement("update books set price = ? where id = ?;");
			float p = (float)price;
			
			ps.setFloat(1, p);
			ps.setInt(2, id);
			
			ps.executeUpdate();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
}
