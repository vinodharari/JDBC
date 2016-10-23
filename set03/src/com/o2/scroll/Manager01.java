package com.o2.scroll;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Manager01 {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		try {
			con=DbUtil.getConnection();
			stmt=con.createStatement();
			String s1="create table employee(sno int,name varchar(90),age int,pic blob,constraint ep1 primary key(sno))";
			stmt.execute(s1);
			String s2="insert into employee(sno,name,age) values(1,'ramu',25)";
			String s3="insert into employee(sno,name,age) values(2,'vijay',26)";
			String s4="insert into employee(sno,name,age) values(3,'pawan',27)";
			String s5="insert into employee(sno,name,age) values(4,'manu',28)";
			String s6="insert into employee(sno,name,age) values(5,'navin',29)";
			String s7="insert into employee(sno,name,age) values(6,'naik',30)";
			stmt.execute(s2);
			stmt.execute(s3);
			stmt.execute(s4);
			stmt.execute(s5);
			stmt.execute(s6);
			stmt.execute(s7);
			System.out.println("done");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			//DbUtil.closeAll(null, stmt, con);
		}
	}
}
