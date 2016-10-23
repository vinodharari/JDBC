package com.vinod01;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Manager16 {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=Manager03.getConnection();
			pstmt=con.prepareStatement("select * from person03 where sno < ?");
			pstmt.setInt(1, 5);
			rs=pstmt.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt(1)+" ");
				System.out.println(rs.getString(2)+" ");
				System.out.println(rs.getInt(3)+" ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Manager03.closeAll(null, pstmt, con);
		}
	}
}
