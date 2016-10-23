package com.o3.keys;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import com.o2.scroll.DbUtil;

public class Manager3 {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		Savepoint p1=null;
		try {
			con=DbUtil.getConnection();
			stmt=con.createStatement();
			con.setAutoCommit(false);
			String s1="insert into employee(sno,name,age) values(40,'abc',22)";
			String s2="insert into employee(sno,name,age) values(50,'pqr',23)";
			String s3="insert into employee(sno,name,age) values(60,'xyz',24)";
			stmt.executeUpdate(s1);
			p1=con.setSavepoint("p1");
			stmt.executeUpdate(s2);
			stmt.executeUpdate(s3);
			con.commit();
			System.out.println("done");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.rollback(p1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		finally {
			DbUtil.closeAll(null, stmt, con);
		}
		
	}
}
