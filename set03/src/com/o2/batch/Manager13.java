package com.o2.batch;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class Manager13 {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		try {
			con=DbUtil.getConnection();
			stmt=con.createStatement();
			stmt.addBatch("insert into employee(sno, name, age) values(15,'praveen1',46)");
			stmt.addBatch("insert into employee(sno, name, age) values(16,'prabav1',47)");
			stmt.addBatch("update employee set name='some thing' where sno=2");
			stmt.addBatch("delete from employee where sno=7");
			int[] results=stmt.executeBatch();
			System.out.println(Arrays.toString(results));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DbUtil.closeAll( null, stmt, con);
		}
	}
}
