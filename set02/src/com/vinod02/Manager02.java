package com.vinod02;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class Manager02 {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		try {
			con=DBUtil.getConnection();
			stmt=con.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("create procedure p1() ");
			sb.append("begin ");
			sb.append("insert into emp values(1,'abc',22,80000); ");
			sb.append("insert into emp values(2,'xyz',32,10000); ");
			sb.append("insert into emp values(3,'hello',23,30000); ");
			sb.append("insert into emp values(4,'test',42,60000); ");
			sb.append("end; ");
			System.out.println(sb.toString());
			stmt.execute(sb.toString());
			System.out.println(sb);
			System.out.println("done");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(null, stmt, con);
		}
	}
}
