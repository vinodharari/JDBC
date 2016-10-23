package com.vinod01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Manager02 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con=null;
		Statement stmt=null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc02?"+"user=root");
			stmt=con.createStatement();
			stmt.execute("insert into person02 values(01,'a1',20)");
			System.out.println("done");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
