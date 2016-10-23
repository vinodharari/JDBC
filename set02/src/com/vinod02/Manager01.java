package com.vinod02;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class Manager01 {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		try {
			con=DBUtil.getConnection();
			stmt=con.createStatement();
			String s1="create table emp(sno int,name varchar(10),age int,salary int)";
			stmt.executeUpdate(s1);
			System.out.println("done");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(null, stmt, con);
		}
	}
}
