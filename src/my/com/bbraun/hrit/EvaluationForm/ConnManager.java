package my.com.bbraun.hrit.EvaluationForm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnManager {
	static final String DB_SERVER = "localhost";
	static final String DB_NAME = "TrainingEvaluation";
	static final String DB_UID = "survey_db";
	static final String DB_PWD = "abcd1234";

	static Connection con;
	static String url;

	public static Connection getConnection() {
		
		System.out.println("test to connect");
		try {
			String url = "jdbc:jtds:sqlserver://" + DB_SERVER + ":1433/" + DB_NAME;
			Class.forName("net.sourceforge.jtds.jdbc.Driver");

			try {
				con = DriverManager.getConnection(url, DB_UID, DB_PWD);
				
				
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return con;
	}

}
