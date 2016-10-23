package com.vinod01;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Manager09 {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=Manager03.getConnection();
			pstmt=con.prepareStatement("insert into person03 values(501,'abc',18)");
			pstmt.executeUpdate();
			System.out.println("done");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Manager03.closeAll(null, pstmt, con);
		}
	}
}
