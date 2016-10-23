package com.vinod02;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class Manager11 {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		try {
			con=DBUtil.getConnection();
			stmt=con.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("create procedure p5(sno int,name varchar(10)) ");
			sb.append("begin ");
			sb.append("insert into tab3 values(sno,name); ");
			sb.append("insert into emp values(sno,name,44,8989899); ");
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
