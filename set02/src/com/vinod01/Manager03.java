package com.vinod01;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class Manager03 {
	private static String driverClass;
	private static String url;
	private static String username;
	private static String password;
	static{
		FileReader fin=null;
		Properties pr=new Properties();
		try {
			fin=new FileReader("constants.properties");
			pr.load(fin);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try{
				if(fin!=null){
					fin.close();
					fin=null;
				}
			} catch(IOException ex){
				ex.printStackTrace();
			}
		}
		driverClass = pr.getProperty("driverClass");
		System.out.println(driverClass);
		url=pr.getProperty("url");
		username=pr.getProperty("username");
	}
	static{
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url,username,password);
	}
	public static void closeAll(ResultSet rs,Statement stmt,Connection con){
		try {
			if(rs!=null){
				rs.close();
				rs=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(stmt!=null){
				stmt.close();
				stmt=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(con!=null){
				con.close();
				con=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
