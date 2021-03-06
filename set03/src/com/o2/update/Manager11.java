package com.o2.update;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Manager11 {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			con=DbUtil.getConnection();
			stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=stmt.executeQuery("select sno,name,age from employee");
			rs.moveToInsertRow();
			rs.updateInt(1, 10);
			rs.updateString(2, "raghu");
			rs.updateInt(3, 50);
			rs.insertRow();
			rs.beforeFirst();
			while(rs.next()){
				System.out.println(rs.getInt(1)+"\t");
				System.out.println(rs.getString(2)+"\t");
				System.out.println(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DbUtil.closeAll( rs, stmt, con);
		}
	}
}
