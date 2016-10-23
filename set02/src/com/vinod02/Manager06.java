package com.vinod02;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class Manager06 {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		try {
			con=DBUtil.getConnection();
			stmt=con.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("create procedure p3() ");
			sb.append("begin ");
			sb.append("insert into tab3 values(202,'abc'); ");
			sb.append("delete from emp; ");
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
