package com.vinod01;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class Manager12 {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=Manager03.getConnection();
			pstmt=con.prepareStatement("insert into person03 values(?,?,?)");
			Scanner sc=new Scanner(System.in);
			String sno,name,age,decider;
			do{
			System.out.println("enter sno");
			sno=sc.next();
			pstmt.setInt(1, Integer.parseInt(sno));
			System.out.println("enter name");
			name=sc.next();
			pstmt.setString(2, name);
			System.out.println("enter age");
			age=sc.next();
			pstmt.setInt(3, Integer.parseInt(age));
			pstmt.executeUpdate();
			System.out.println("insert again(y/n)?");
			decider=sc.next();
		}while("y".equals(decider));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Manager03.closeAll(null, pstmt, con);
		}
	}
}
