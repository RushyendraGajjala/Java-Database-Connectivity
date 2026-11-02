package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		try {
			String url = "jdbc:mysql://localhost:3306/jdbc_learning";
			String username = "root";
			String password = "340618";
			Connection connection = DriverManager.getConnection(url, username, password);
			
			IO.println(connection != null);
			
			Statement statement = connection.createStatement();
			
			String query = "SELECT * FROM STUD_INFO";
			
			boolean execute = statement.execute(query);
			
			IO.println(execute);
			
			if(execute) {
				//if True - Select Statement
				ResultSet rs = statement.getResultSet();
				while(rs.next()) {
					Object[] obj = new Object[] {
							rs.getObject(1),
							rs.getObject(2),
							rs.getObject(3),
							rs.getObject(4)
					};
					IO.println(Arrays.toString(obj));
				}
				
			} else {
				//if False - Update, Delete, Insert Statement
				int updateCount = statement.getUpdateCount();
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}