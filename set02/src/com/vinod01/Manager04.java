package com.vinod01;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class Manager04 {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		try {
			con=Manager03.getConnection();
			stmt=con.createStatement();
			String s1="insert into person1 values(2,'a2',20)";
			stmt.executeUpdate(s1);
			System.out.println("done");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Manager03.closeAll(null, stmt, con);
		}
	}
}
