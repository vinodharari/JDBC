package com.vinod02;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class Manager13 {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		try {
			con=DBUtil.getConnection();
			stmt=con.createStatement();
			StringBuffer sb=new StringBuffer();
			sb.append("create procedure p7(arg1 out int,arg2 out varchar(10),arg3 out int,arg4 in int) ");
			sb.append("as ");
			sb.append("begin ");
			sb.append("select age into arg1 from emp where sno=arg4; ");
			sb.append("select name into arg2 from emp where sno=arg4; ");
			sb.append("select salary into arg3 from emp where sno=arg4; ");
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
