package com.vinod02;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;


public class Manager10 {
	public static void main(String[] args) {
		Connection con=null;
		CallableStatement cstmt=null;
		try {
			con=DBUtil.getConnection();
			cstmt=con.prepareCall("{call p4(?,?,?,?)}");
			cstmt.setInt(1, 1120);
			cstmt.setString(2, "hello");
			cstmt.setInt(3, 90);
			cstmt.setInt(4, 45455);
			cstmt.execute();
			
			cstmt.setInt(1, 1120);
			cstmt.setString(2, "hello");
			cstmt.setInt(3, 90);
			cstmt.setInt(4, 45455);
			cstmt.execute();
			System.out.println("done");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(null, cstmt, con);
		}
	}
}
