package my.com.bbraun.hrit.EvaluationForm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReportSupervisorDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public String getReportSupervisorDetails() {
		Statement stmt = null;
//		String sql = "SELECT Courses_id, convert(varchar(15), Courses_timeend, 100) AS Courses_endtime, CONVERT(varchar(15), Courses_timestart, 100) AS Courses_starttime, Courses_date, Courses_title, Courses_venue, Courses_trainer FROM TrainingCourses";
		String sql = "SELECT Feedback_S_id, Q1, Q1_1, Q1_2, Q1_3, Q1_4, Q1_5, Q1_5_C_g, Q1_5_C_b, Q2_1, Q2_2, Q2_3, Q2_4, Q2_5, Q2_5_C, DateCreateFeedback, courseTitle, Course_id, Emp_no_create FROM TrainingFeedbackSupervisor ORDER BY Feedback_S_id ASC";//select statement*************

		String list = "";

		try {
			currentCon = ConnManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(sql);
//			int count = 1;

			while (rs.next()) {
				String Feedback_S_id = rs.getString("Feedback_S_id");
				String Feedback_S_q1 = rs.getString("Q1");
				String Feedback_S_q1_1 = rs.getString("Q1_1");
				String Feedback_S_q1_2 = rs.getString("Q1_2");
				String Feedback_S_q1_3 = rs.getString("Q1_3");
				String Feedback_S_q1_4 = rs.getString("Q1_4");
				String Feedback_S_q1_5 = rs.getString("Q1_5");
				String Feedback_S_q1_5_C_g = rs.getString("Q1_5_C_g");
				String Feedback_S_q1_5_C_b = rs.getString("Q1_5_C_b");
				String Feedback_S_q2_1 = rs.getString("Q2_1");
				String Feedback_S_q2_2 = rs.getString("Q2_2");
				String Feedback_S_q2_3 = rs.getString("Q2_3");
				String Feedback_S_q2_4 = rs.getString("Q2_4");
				String Feedback_S_q2_5 = rs.getString("Q2_5");
				String Feedback_S_q2_5_C = rs.getString("Q2_5_C");
				String Feedback_S_DateCreateFeedback = rs.getString("DateCreateFeedback");
				String Feedback_S_courseTitle = rs.getString("courseTitle");
				String Feedback_S_Course_id = rs.getString("Course_id");
				String Feedback_S_Emp_no_create = rs.getString("Emp_no_create");
//				int timelooping = count++;


				list += "<tr><td class=\"size\">"+ Feedback_S_id+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_q1+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_q1_1+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_q1_2+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_q1_3+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_q1_4+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_q1_5+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_q1_5_C_g+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_q1_5_C_b+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_q2_1+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_q2_2+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_q2_3+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_q2_4+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_q2_5+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_q2_5_C+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_DateCreateFeedback+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_courseTitle+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_Course_id+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_Emp_no_create+"</td>";
				list += "	</tr>";


			}
			System.out.println(list);
		} catch (Exception ex) {
			System.out.println("getReportSupervisorDetails failed: An Exception has occurred! " + ex);
		}

		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception ex) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception ex) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception ex) {
				}
				currentCon = null;
			}
		}

		return list;
	}

}
