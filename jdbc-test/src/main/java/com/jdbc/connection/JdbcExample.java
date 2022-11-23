package com.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcExample {
	public static void main(String args[]) {
		try {
			String query = "Select * from student";
			String driver = "org.postgresql.Driver";
			String url = "jdbc:postgresql://localhost:5432/postgres";
			String username = "postgres";
			String password = "ajay@4321";

			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("databse connection" + con);
		//	String query = "Select * from student";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String name = resultSet.getString("name");

				String email = resultSet.getString("email");
				long phoneno = resultSet.getLong("phone_no");

				System.out.println("name:" + name);

				System.out.println("email:" + email);
				System.out.println("phoneno:" + phoneno);

			}
		} catch (SQLException e) {
			System.out.println("databse not connection");
			e.printStackTrace();
		}
	}
}
