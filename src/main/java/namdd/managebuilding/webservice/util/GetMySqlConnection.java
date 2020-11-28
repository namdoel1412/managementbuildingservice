package namdd.managebuilding.webservice.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetMySqlConnection {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/laptrinhweb";
	static final String USER = "root";
	static final String PASS = "admin";
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
	        Class.forName(JDBC_DRIVER);
	        connection = DriverManager.getConnection(DB_URL, USER, PASS);
	    }
		catch(Exception ex) {
			ex.printStackTrace();
	    }
		return connection;
	}
}
