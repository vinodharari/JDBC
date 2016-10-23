package com.vinod;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class N {
	public static void main(String[] args) throws Exception {
		int total_Cons = 0;
		String s1="show processlist";
		Statement stmt=EUtil.getStatement();
		ResultSet rs=stmt.executeQuery(s1);
		ArrayList<String> list = new ArrayList<String>();
		while(rs.next()){
			list.add(rs.getString("Host").split(":")[0]);
			total_Cons++;
		}
		Collections.sort(list);
		Set<String> uniqueSet = new HashSet<String>(list);
		for(String temp : uniqueSet){
			System.out.println(temp + " : " + Collections.frequency(list, temp));
		}
		System.out.println("Total no of Connections : "+total_Cons);
		
	}
}
