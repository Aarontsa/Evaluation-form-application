package my.com.bbraun.hrit.EvaluationForm;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import my.com.bbraun.hrit.EvaluationForm.CoursesAddBean;
import my.com.bbraun.hrit.EvaluationForm.ConnManager;

public class CoursesAddDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	
	public static CoursesAddBean selectQuery(CoursesAddBean bean) throws SQLException {
		currentCon = ConnManager.getConnection();
		Statement stmt = null;
		
		System.out.println("select query");
		try {
//			String sql = "SELECT a1, a2, b1, b2, b3, c1, c2, c3, d1, d2, e1,dateCreateAns,courseTitle,courseTitleID,Emp_noCreate FROM ans8";//select statement*************
			String sql = "SELECT Courses_timestart, Courses_timeend, Courses_date, Courses_title, Courses_venue, Courses_trainer, Emp_no, DateCreateCourses FROM TrainingCourses";//select statement*************
					
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
	
	public static void insertQuery(CoursesAddBean bean) throws SQLException {
		Connection localCon = ConnManager.getConnection();
		//form
		System.out.println("insert query");
		try {
//			String sql = "INSERT INTO ans8 (a1, a2, b1, b2, b3, c1, c2, c3, d1, d2, e1,dateCreateAns,courseTitle,courseTitleID,Emp_noCreate) VALUES "
//					+ "('"+bean.getData1()+"','"+bean.getData2()+"','"+bean.getData3()+"','"+bean.getData4()+"','"+bean.getData5()+"','"+bean.getData6()+"','"+bean.getData7()+"','"+bean.getData8()+"','"+bean.getData9()+"','"+bean.getData10()+"','"+bean.getData11()+"',getdate(),'"+bean.getData12()+"','"+bean.getData14()+"','"+bean.getData13()+"')";//select statement*************
			String sql = "INSERT INTO TrainingCourses (Courses_timestart, Courses_timeend, Courses_date, Courses_title, Courses_venue, Courses_trainer, Emp_no, DateCreateCourses) VALUES "
					+ "('"+bean.getCourses_timestart()+"','"+bean.getCourses_timeend()+"','"+bean.getCourses_date()+"','"+bean.getCourses_title()+"','"+bean.getCourses_venue()+"','"+bean.getCourses_trainer()+"','"+bean.getAdmin_no()+"',getdate())";//select statement*************			
			
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
