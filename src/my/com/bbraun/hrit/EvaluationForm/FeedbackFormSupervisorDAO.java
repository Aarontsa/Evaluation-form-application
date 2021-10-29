package my.com.bbraun.hrit.EvaluationForm;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import my.com.bbraun.hrit.EvaluationForm.FeedbackFormSupervisorBean;
import my.com.bbraun.hrit.EvaluationForm.ConnManager;

public class FeedbackFormSupervisorDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	
	public static FeedbackFormSupervisorBean selectQuery(FeedbackFormSupervisorBean bean) throws SQLException {
		currentCon = ConnManager.getConnection();
		Statement stmt = null;
		
		System.out.println("select query");
		try {
//			String sql = "SELECT a1, a2, b1, b2, b3, c1, c2, c3, d1, d2, e1,dateCreateAns,courseTitle,courseTitleID,Emp_noCreate FROM ans8";//select statement*************
			String sql = "SELECT Q1, Q1_1, Q1_2, Q1_3, Q1_4, Q1_5, Q1_5_C_g, Q1_5_C_b, Q2_1, Q2_2, Q2_3, Q2_4, Q2_5, Q2_5_C, DateCreateFeedback, courseTitle, Course_id, Emp_no_create FROM TrainingFeedbackSupervisor";//select statement*************
					
				currentCon = ConnManager.getConnection();
				stmt = currentCon.createStatement();
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {}
				
			boolean more = rs.next();
			if(!more) {
				insertQuery(bean);
			}
			bean.setStatus(true);
		}catch (Exception ex) {
			bean.setStatus(false);
			System.out.println("selectQuery failed: " + ex);
		}
		
	finally {		
	if (currentCon != null) {
		try{currentCon.close();
		} catch (Exception ex) {}
		}
		currentCon = null;
	}
	return bean;
	}
	
	public static void insertQuery(FeedbackFormSupervisorBean bean) throws SQLException {
		Connection localCon = ConnManager.getConnection();
		//form
		System.out.println("insert query");
		try {
//			String sql = "INSERT INTO ans8 (a1, a2, b1, b2, b3, c1, c2, c3, d1, d2, e1,dateCreateAns,courseTitle,courseTitleID,Emp_noCreate) VALUES "
//					+ "('"+bean.getData1()+"','"+bean.getData2()+"','"+bean.getData3()+"','"+bean.getData4()+"','"+bean.getData5()+"','"+bean.getData6()+"','"+bean.getData7()+"','"+bean.getData8()+"','"+bean.getData9()+"','"+bean.getData10()+"','"+bean.getData11()+"',getdate(),'"+bean.getData12()+"','"+bean.getData14()+"','"+bean.getData13()+"')";//select statement*************
			String sql = "INSERT INTO TrainingFeedbackSupervisor (Q1, Q1_1, Q1_2, Q1_3, Q1_4, Q1_5, Q1_5_C_g, Q1_5_C_b, Q2_1, Q2_2, Q2_3, Q2_4, Q2_5, Q2_5_C, DateCreateFeedback, courseTitle, Course_id, Emp_no_create) VALUES "
					+ "('"+bean.getQ1()+"','"+bean.getQ1_1()+"','"+bean.getQ1_2()+"','"+bean.getQ1_3()+"','"+bean.getQ1_4()+"','"+bean.getQ1_5()+"','"+bean.getQ1_5_C_g()+"','"+bean.getQ1_5_C_b()+"','"+bean.getQ2_1()+"','"+bean.getQ2_2()+"','"+bean.getQ2_3()+"','"+bean.getQ2_4()+"','"+bean.getQ2_5()+"','"+bean.getQ2_5_C()+"',getdate(),'"+bean.getcourseTitle()+"','"+bean.getCourse_id()+"','"+bean.getEmp_no_create()+"')";//select statement*************			
			
			localCon.createStatement().executeUpdate(sql);
			//int prs = pstatem.createStatement().executeUpdate();//execute statement
			

		} catch (Exception ex) {
			System.out.println("Insert record failed:" + ex);
		}
		finally{
		if (localCon != null) {
			try {
				localCon.close();
			} catch (Exception ex) {
			}
		}
			localCon = null;
		}
	}
	

}
