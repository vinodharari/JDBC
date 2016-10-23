package com.vinod;

import java.sql.Statement;
import java.util.Scanner;

public class H {
	public static void main(String[] args) throws Exception {
		Statement stmt=EUtil.getStatement();
		Scanner sc=new Scanner(System.in);
		int id,age;
		String fName,lName,sql;
		do{
			System.out.println("enter id");
			id=sc.nextInt();
			System.out.println("enter FirstName");
			fName=sc.next();
			System.out.println("enter LastName");
			lName=sc.next();
			System.out.println("enter age");
			age=sc.nextInt();
			sql="insert into employee values("+id+",'"+fName+"','"+lName+"',"+age+")";
			stmt.execute(sql);
			System.out.println("do you want to insert one more(y/n)?");
			}
		while("y".equals(sc.next()));
		System.out.println("done");
	}
}
