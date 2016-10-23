package com.vinod;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class D {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j01?"+"user=root");
		Statement stmt=con.createStatement();
		String s1="insert into person1 values(5,'ramana',45)";
		String s2="insert into person1 values(6,'praveen',48)";
		stmt.execute(s1);
		stmt.execute(s2);
		System.out.println("done");  
	}
}
