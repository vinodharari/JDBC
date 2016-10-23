package com.vinod;

import java.io.FileReader;
import java.sql.Statement;
import java.util.*;

public class J {
	public static void main(String[] args) throws Exception {
		Statement stmt=EUtil.getStatement();
		Properties pr=new Properties();
		FileReader fin=new FileReader("test2.properties");
		pr.load(fin);
		Set<Object> keys=pr.keySet();
		String value;
		for(Object key:keys){
			value=pr.getProperty((String) key);
			stmt.execute(value);
		}
		System.out.println("done");
	}
}
