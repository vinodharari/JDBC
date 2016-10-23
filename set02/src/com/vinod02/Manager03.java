package com.vinod02;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;


public class Manager03 {
	public static void main(String[] args) {
		Connection con=null;
		CallableStatement cstmt=null;
		try {
			con=DBUtil.getConnection();
			cstmt=con.prepareCall("{call p1}");
			cstmt.execute();
			System.out.println("done");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(null, cstmt, con);
		}
	}
}
