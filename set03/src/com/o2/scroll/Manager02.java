package com.o2.scroll;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Manager02 {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			con=DbUtil.getConnection();
			stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=stmt.executeQuery("select * from employee");
			System.out.println("In the forward direction");
			while(rs.next()){
				System.out.println(rs.getInt(1)+"\t");
				System.out.println(rs.getString(2)+"\t");
				System.out.println(rs.getString(3));
			}
			System.out.println("-----");
			System.out.println("In the reverse direction");
			while(rs.previous()){
				System.out.println(rs.getInt(1)+"\t");
				System.out.println(rs.getString(2)+"\t");
				System.out.println(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DbUtil.closeAll( rs, stmt, con);
		}
	}
}
