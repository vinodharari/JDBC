package com.o2.blob;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.o2.update.DbUtil;
public class Manager16 {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			con=DbUtil.getConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery("select pic from employee1 where sno=101");
			if(rs.next()){
				Blob b1=rs.getBlob("pic");
				System.out.println("b1 = "+b1);
				byte[] bytes=b1.getBytes(1, (int)b1.length());
				System.out.println("bytes ="+bytes);
				writeInToFile(bytes);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DbUtil.closeAll(null, stmt, con);
		}
	}
	private static void writeInToFile(byte[] bytes){
		File f1=new File("mall_copy.jpg");
		System.out.println(f1.getAbsolutePath());
		FileOutputStream fout=null;
		BufferedOutputStream bout=null;		
		try {
			fout=new FileOutputStream(f1);
			bout=new BufferedOutputStream(fout);
			bout.write(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bout != null){
					bout.close();
					bout=null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(fout != null){
					fout.close();
					fout=null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			}
		}
	}


