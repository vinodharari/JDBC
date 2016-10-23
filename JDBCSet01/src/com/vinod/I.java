package com.vinod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Statement;

public class I {
	public static void main(String[] args) throws Exception {
		Statement stmt=EUtil.getStatement();
		FileReader fin=new FileReader("test1.txt");
		BufferedReader bin=new BufferedReader(fin);
		String sql=null;
		String row=bin.readLine();
		String[] cols;
		while(row!=null){
			cols=row.split(",");
			sql="insert into employee values("+cols[0].trim()+",'"+cols[1].trim()+"','"+cols[2].trim()+"',"+cols[3].trim()+")";
			stmt.execute(sql);
			row=bin.readLine();
		}
		System.out.println("done");
	}
}
