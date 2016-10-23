package com.o3.keys;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.o2.scroll.DbUtil;

public class Manager1 {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=DbUtil.getConnection();
			pstmt=con.prepareStatement("insert into employee1(sno,name,age) values(?,?,?)");
			ParameterMetaData pMetaData=pstmt.getParameterMetaData();
			pstmt.setInt(1, 2000);
			pstmt.setString(2, "abc");
			pstmt.setInt(3, 78);
			int count=pMetaData.getParameterCount();
			System.out.println(count);
			pstmt.executeUpdate();
			System.out.println("done");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeAll(null, pstmt, con);
		}
		
	}
}
