package com.vinod01;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Manager17 {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=Manager03.getConnection();
			pstmt=con.prepareStatement("insert into tab3 values(?,?)");
			FileReader fin=null;
			BufferedReader bin=null;
			try {
				fin=new FileReader("data.txt");
				bin=new BufferedReader(fin);
				String sno,name,line;
				int index;
				line=bin.readLine();
				while(line!=null){
					index=line.indexOf("-");
					sno=line.substring(0,index);
					name=line.substring(index+1,line.length());
					pstmt.setInt(1, Integer.parseInt(sno));
					pstmt.setString(2, name);
					pstmt.executeUpdate();
					line=bin.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Manager03.closeAll(null, pstmt, con);
		}
	}
}
