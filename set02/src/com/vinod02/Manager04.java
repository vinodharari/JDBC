package com.vinod02;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class Manager04 {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		try {
			con=DBUtil.getConnection();
			stmt=con.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("create procedure p2() ");
			sb.append("begin ");
			sb.append("insert into emp values(5,'ramu',22,55000); ");
			sb.append("update emp set name='aaaa' where sno=2; ");
			sb.append("delete from emp where sno=3; ");
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
