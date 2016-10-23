package com.vinod;

import java.sql.Statement;

public class G {
	public static void main(String[] args) throws Exception {
		Statement stmt=EUtil.getStatement();
		String s1="create table employee(id int,first_name varchar(90),last_name varchar(90),age int)";
		stmt.execute(s1);
		String s2="insert into employee values(1,'praveen','b',22)";
		stmt.execute(s2);
		System.out.println("done");
	}
}
