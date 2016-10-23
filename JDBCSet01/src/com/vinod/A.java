package com.vinod;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class A {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j01?user=root");
		Statement stmt=con.createStatement();
//		stmt.execute("create table person1(sno int,name varchar(90),age int)");
		stmt.executeUpdate("insert into person1(sno, name, age) values('1','abc','20')");
		System.out.println("done");
		
	}
}
