package com.vinod01;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class B {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		try {
			con=AUtil.getConnection();
			stmt=con.createStatement();
			String s1="insert into person03 values(1,'a1',20)";
			int i=stmt.executeUpdate(s1);
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			AUtil.closeStatement(stmt);
			AUtil.closeConnection(con);
		}
	}
}
