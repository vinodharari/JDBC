package com.vinod01;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Manager11 {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=Manager03.getConnection();
			pstmt=con.prepareStatement("insert into person03 values(?,?,?)");
			pstmt.setInt(1, 701);
			pstmt.setString(2, "hello");
			pstmt.setInt(3, 15);
			pstmt.executeUpdate();
			System.out.println("-----");
			pstmt.setInt(1, 801);
			pstmt.setString(2, "hi");
			pstmt.setInt(3, 16);
			pstmt.executeUpdate();
			System.out.println("-----");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Manager03.closeAll(null, pstmt, con);
		}
	}
}
