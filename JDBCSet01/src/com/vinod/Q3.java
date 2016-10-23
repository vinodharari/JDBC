package com.vinod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q3 {
	public static void main(String[] args) throws Exception {
		while(true){
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/privatefarm_v7","root","");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT hostname, max_mem, avl_mem FROM ovm_farm_db.host_machines where farm = 'swap';");
			while(resultSet.next()){
				String hostname = resultSet.getString(1);
				String max_mem = resultSet.getString(2);
				String avl_mem = resultSet.getString(3);
				if(avl_mem.length() == 3){
					avl_mem = "000"+avl_mem;
				}else if(avl_mem.length() == 4){
					avl_mem = "00"+avl_mem;
				}else if(avl_mem.length() == 5){
					avl_mem = "0"+avl_mem;
				}
				if(avl_mem.length() == 6){
					/*String sqlQuery = "update ovm_farm_db.mem_usage set avl_mem = CONCAT(avl_mem,',"+avl_mem+"') where hostname = '"+hostname+"'";
					System.out.println(sqlQuery);
					Statement statement1 = connection.createStatement();
					int i = statement1.executeUpdate(sqlQuery);
					System.out.println(i);*/
				}
			}
			Thread.sleep(1000);
	  }
	}
}
