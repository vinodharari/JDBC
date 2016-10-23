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

public class Q2 {
	public static void main(String[] args) throws Exception {
		
		Map<Object,Object> map = null;
		Map<Object,Object> map1 = null;
		List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
		List<Map<Object,Object>> list1 = new ArrayList<Map<Object,Object>>();

		String dataPoints="";
		String dataPoints1="";
		int comConunt = 0;
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/privatefarm_v7","root","");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT avl_mem FROM ovm_farm_db.mem_usage where farm = 'swap' limit 1;");
		ResultSetMetaData rsmd = resultSet.getMetaData();
		while(resultSet.next()){
			comConunt = resultSet.getString(1).split(",").length;
		}
		for(int j=0; j<comConunt; j++){
			String xVal, yVal;
			String sqlQuery = "SELECT avg(max_mem), avg(substring(avl_mem,"+(7*j+1)+",6)) FROM ovm_farm_db.mem_usage where farm = 'swap';";
			resultSet = statement.executeQuery(sqlQuery);
			rsmd = resultSet.getMetaData();
			while(resultSet.next()){
				xVal = resultSet.getString(1);
				yVal = resultSet.getString(2);
					map = new HashMap<Object,Object>();	
					map.put("x", j);	
					map.put("y", Double.parseDouble(xVal)); 
					map1 = new HashMap<Object,Object>();	
					map1.put("x", j);	
					map1.put("y", Double.parseDouble(yVal)); 
					list.add(map);
					list1.add(map1);
				}
			System.out.println("map : "+map);
			System.out.println("map1 : "+map1);
			}
	}
}
