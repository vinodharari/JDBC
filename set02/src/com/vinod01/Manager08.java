package com.vinod01;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Manager08 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Connection con=null;
		Statement stmt=null;
		String sno,name,sql,decider;
		try {
			con=Manager03.getConnection();
			stmt=con.createStatement();
			do{
			System.out.println("enter sno");
			sno=sc.next();
			System.out.println("enter name");
			name=sc.next();
			String s1="insert into person03 values("+sno+",'"+name+"')";			stmt.executeUpdate(s1);
			System.out.println("one query done");
			stmt.executeUpdate(s1);
			System.out.println("insert again(y/n)?");
			decider=sc.next();
		}while("y".equals(decider));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Manager03.closeAll(null, stmt, con);
		}
	}
}
