package com.bank.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DB_Connectors {
	static Connection con=null;
	static String url="jdbc:mysql://localhost/bankapplication";
	static String u="root";
	static String p="tiger";
   public static Connection reqConnection() throws ClassNotFoundException, SQLException  {
	   Class.forName("com.mysql.cj.jdbc.Driver");
	    con=DriverManager.getConnection(url,u,p);
	return con;
}
}