package my.com.bbraun.hrit.EvaluationForm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public static LoginBean login(LoginBean bean) throws SQLException {
		currentCon = ConnManager.getConnection();
		Statement stmt = null;
        
		/*** Prepare SQL query statement ***/
		String sql = "SELECT Emp_no, Emp_pass FROM TraningLogin WHERE Emp_no  = '" + bean.getEmp_no() + "' AND Emp_pass = '" + bean.getEmp_pass() + "'";
		//System.out.print(sql);
		
		try {
			/*** Open SQL connection ***/
			currentCon = ConnManager.getConnection();
			stmt = currentCon.createStatement();

			/*** Execute SQL statement ***/
			rs = stmt.executeQuery(sql);

			
			/*** Check for query result ***/
			 

			boolean more = rs.next();
			if (!more) {
				/***no record ***/
	            System.out.println("Please sign up first");
	            bean.setStatus(false);
			} else {
				/*** else, existing record ***/
		     	
	            System.out.println("Welcome" );
	            bean.setStatus(true);
			}

			/*** Set the return status ***/
//			bean.setStatus(true);

		} catch (Exception ex) {
			bean.setStatus(false);
			
			/*** Output error message for debugging purposes ***/
			System.out.println("selectQuery failed: An Exception has occurred! " + ex);
		}

		/*** IMPORTANT: Remember to close all SQL connection ***/
		if (currentCon != null) {
			try {
				currentCon.close();
			} catch (Exception ex) {
			}
			currentCon = null;
		}
		
		/*** Return status to the caller ***/
		return bean;
	}
	
}


