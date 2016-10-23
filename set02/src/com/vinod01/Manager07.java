package com.vinod01;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Manager07 {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		try {
			con=Manager03.getConnection();
			stmt=con.createStatement();
			String s1="insert into person03 values(6,'kamu',23)";
			String s2="insert into person03 values(7,'vijay',24)";
			con.setAutoCommit(false);
			stmt.executeUpdate(s1);
			System.out.println("one query done");
			stmt.executeUpdate(s2);
			System.out.println("2nd one also done");
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Manager03.closeAll(null, stmt, con);
		}
	}
}
