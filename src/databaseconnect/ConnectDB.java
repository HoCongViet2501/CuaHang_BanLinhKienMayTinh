package databaseconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	public static Connection getConnection() throws ClassNotFoundException {
		try {
			String url = "jdbc:sqlserver://localhost:1433;databasename=muabanlinhkien";
			String username="sa";
			String password = "sapassword";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String[] args) throws ClassNotFoundException {
		Connection con = getConnection();
		if( con != null) {
			System.out.println("Connect Success");
		}else
			System.out.println("Connect Error!");
	}
}
