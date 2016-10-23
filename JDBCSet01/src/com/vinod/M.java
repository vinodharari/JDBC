package com.vinod;

import java.sql.Statement;

public class M {
	public static void main(String[] args) throws Exception {
		Statement stmt=EUtil.getStatement();
		String s1="insert into person1 values(10,'vinod10',25)";
		String s2="insert into person1 values(11,'vinod11',25)";
		String s3="insert into employee values(20,'vinod20','jain20',27)";
		String s4="update person1 set name='hello' where sno=10";
		String s5="delete from employee where id=20";
		stmt.execute(s1);
		stmt.execute(s2);
		stmt.execute(s3);
		stmt.execute(s4);
		stmt.execute(s5);
		System.out.println("done");
	}
}
