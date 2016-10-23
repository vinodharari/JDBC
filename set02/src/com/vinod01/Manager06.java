package com.vinod01;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Manager06 {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		try {
			con=Manager03.getConnection();
			stmt=con.createStatement();
			String s1="insert into person03 values(4,'ramu',22)";
			String s2="insert into person03 values(5,'raju',22)";
			stmt.executeUpdate(s1);
			System.out.println("one query done");
			stmt.executeUpdate(s2);
			System.out.println("2nd one also done");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Manager03.closeAll(null, stmt, con);
		}
	}
}
