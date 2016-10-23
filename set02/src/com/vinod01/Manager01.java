package com.vinod01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Manager01 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc02?"+"user=root");
		Statement stmt=con.createStatement();
		stmt.execute("create table tab3(sno int,name varchar(90))");
		System.out.println("done");
	}
}
