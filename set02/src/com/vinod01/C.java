package com.vinod01;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class C {
	public static void main(String[] args) {
		String s1="select * from person1";
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			con=AUtil.getConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery(s1);
			ResultSetMetaData rsmd=rs.getMetaData();
			int cols=rsmd.getColumnCount();
			while(rs.next()){
				for(int i=1; i<=cols; i++){
					System.out.println(rs.getString(i)+", ");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			AUtil.closeResultSet(rs);
			AUtil.closeStatement(stmt);
			AUtil.closeConnection(con);
		}
	}
}
