package com.o2.batch;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class Manager12 {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			con=DbUtil.getConnection();
			stmt=con.createStatement();
			String s1="insert into employee(sno, name, age) values(13,'praveen',44)";
			String s2="insert into employee(sno, name, age) values(14,'prabav',45)";
			String s3="update employee set name='some thing' where sno=2";
			String s4="delete from employee where sno=7";
			stmt.addBatch(s1);
			stmt.addBatch(s2);
			stmt.addBatch(s3);
			stmt.addBatch(s4);
			int[] results=stmt.executeBatch();
			System.out.println(Arrays.toString(results));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DbUtil.closeAll( rs, stmt, con);
		}
	}
}
