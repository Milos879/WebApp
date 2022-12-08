package com.project.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

private static Connection conn =null;	

private static final String URL="jdbc:mysql://localhost:3306/ketering555";	
private static final String USER_NAME="root";
private static final String PASSWORD="1996";




public static Connection getConnection() throws ClassNotFoundException, SQLException{
	
	if(conn==null){
		Class.forName("com.mysql.cj.jdbc.Driver");
	return	conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
	}else
		return conn;
}

}
