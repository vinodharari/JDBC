package com.vinod;

import java.sql.ResultSet;
import java.sql.Statement;


public class Q {
	public static void main(String[] args) throws Exception {
		String[] farms = {"swap", "FASAASQA", "FASAASQA_328", "QAFARM"};
		for(int i=0; i<farms.length; i++){
			String s1="SELECT sum(max_mem), sum(avl_mem) FROM ovm_farm_db.host_machines where farm = '"+farms[i]+"';";
			Statement stmt=EUtil.getStatement();
			ResultSet rs=stmt.executeQuery(s1);
			while(rs.next()){
				System.out.print("Farm : "+farms[i]);
				System.out.print(" Max Memory : "+rs.getString(1));
				System.out.println(" Avl Memory : "+rs.getString(2));
			}
		}
	}
}
