package com.vinod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class EUtil {
	public static Statement getStatement() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
//		Connection con=DriverManager.getConnection("jdbc:mysql://slc02oxj.us.oracle.com:3306/privatefarm_v7","aime","qafrmPass_test");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/privatefarm_v7","root","");
		Statement stmt=con.createStatement();
		return stmt;
	}
}
