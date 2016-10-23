package com.vinod01;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Manager13 {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=Manager03.getConnection();
			pstmt=con.prepareStatement("update person03 set name=? where sno=?");
			pstmt.setString(1, "james");
			pstmt.setInt(2, 007);
			pstmt.executeUpdate();
			System.out.println("done");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Manager03.closeAll(null, pstmt, con);
		}
	}
}
