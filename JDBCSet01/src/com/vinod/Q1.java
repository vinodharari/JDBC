package com.vinod;

import java.sql.ResultSet;
import java.sql.Statement;


public class Q1 {
	public static void main(String[] args) throws Exception {
	/*	String[] farms = {"swap", "FASAASQA", "FASAASQA_328", "QAFARM"};
		for(int i=0; i<farms.length; i++){*/
			String s1="SELECT max_mem, avl_mem FROM ovm_farm_db.mem_usage where farm = 'swap';";
			Statement stmt=EUtil.getStatement();
			ResultSet rs=stmt.executeQuery(s1);
			int count = 0;
			int avl = 0;
			int maxMem = 0;
			int avlMem = 0;
			while(rs.next()){
				maxMem += Integer.parseInt(rs.getString(1));
				System.out.print(" Max Memory : "+rs.getString(1));
				System.out.println(" Avl Memory : "+rs.getString(2));
//				avl += Integer.parseInt(rs.getString(2),);
				String[] vals = rs.getString(2).split(",");
				for(int i=0; i<vals.length; i++){
					
				}
			}
			System.out.println(maxMem);
//		}
	}
}
