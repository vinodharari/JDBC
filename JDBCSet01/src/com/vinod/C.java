package com.vinod;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class C {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j01?"+"user=root");
		Statement stmt=con.createStatement();
		stmt.execute("insert into person1 values(2,'ramu',24)");
		stmt.execute("insert into person1 values(3,'kiran',25)");
		stmt.execute("insert into person1 values(4,'pawan',26)");
		System.out.println("done");
	}
}
