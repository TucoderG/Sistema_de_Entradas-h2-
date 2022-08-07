package base_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBManager {

	
	private static final String DB_DRIVER = "org.h2.Driver";
	private static final String DB_BASE_URL = "jdbc:h2:C:\\Users\\Educa Informatica\\Desktop\\Eclipse_work\\Sistema_de_entrada\\h2\\Base De Datos";
	private static final String DB_USERNAME = "Gian";
	private static final String DB_PASSWORD = "123323";
	
	public static Connection connect() {
		Connection c = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
		try {
			c = DriverManager.getConnection(DB_BASE_URL, DB_USERNAME, DB_PASSWORD);
			c.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}

		return c;
	}


	

}


