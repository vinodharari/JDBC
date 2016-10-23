package com.vinod;

import java.sql.Statement;

public class F {
	public static void main(String[] args) throws Exception {
		Statement stmt=EUtil.getStatement();
		String s1="insert into person1 values(7,'babu',33)";
		stmt.execute(s1);
		System.out.println("done");
	}
}
