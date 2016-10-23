package com.vinod02;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class Manager08 {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		try {
			con=DBUtil.getConnection();
			stmt=con.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("create procedure p4(arg1 int,arg2 varchar(10), arg3 int, arg4 int) ");
			sb.append("begin ");
			sb.append("insert into tab3 values(arg1,arg2); ");
			sb.append("insert into emp values(arg1,arg2,arg3,arg4); ");
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
