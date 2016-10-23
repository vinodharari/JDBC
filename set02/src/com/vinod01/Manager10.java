package com.vinod01;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Manager10 {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=Manager03.getConnection();
			String s1="insert into person03 values(601,'abc1',18)";
			pstmt=con.prepareStatement(s1);
			pstmt.executeUpdate();
			System.out.println("-----");
			pstmt.executeUpdate();
			System.out.println("-----");
			pstmt.executeUpdate();
			System.out.println("-----");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Manager03.closeAll(null, pstmt, con);
		}
	}
}
