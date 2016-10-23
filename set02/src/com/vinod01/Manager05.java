package com.vinod01;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Manager05 {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			con=Manager03.getConnection();
			stmt=con.createStatement();
			String s1="select * from person03";
			rs=stmt.executeQuery(s1);
			while(rs.next()){
				System.out.println(rs.getString(1)+" ");
				System.out.println(rs.getString(2)+" ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Manager03.closeAll(null, stmt, con);
		}
	}
}
