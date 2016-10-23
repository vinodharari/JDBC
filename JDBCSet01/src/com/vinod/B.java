package com.vinod;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class B {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j01?"+"user=root");
		Statement stmt=con.createStatement();
		stmt.execute("insert into person1 values(1,'vinod',108)");
		System.out.println("done");
	}
}
