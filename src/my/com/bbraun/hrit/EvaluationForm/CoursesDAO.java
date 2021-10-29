package my.com.bbraun.hrit.EvaluationForm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CoursesDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public String getOrientationDetails() {
		Statement stmt = null;
//		String sql = "SELECT Orien_id, convert(varchar(15), Orien_timeend, 100) AS Orien_endtime, CONVERT(varchar(15), Orien_timestart, 100) AS Orien_starttime, Orien_date, Orien_course, Orien_venue, Orien_trainer FROM orientation WHERE Orien_date >= DATEADD(day,-7, GETDATE()) AND Orien_date <= DATEADD(day,0, GETDATE()) ORDER BY Orien_date DESC, Orien_timestart DESC";
		String sql = "SELECT Courses_id, convert(varchar(15), Courses_timeend, 100) AS Courses_endtime, CONVERT(varchar(15), Courses_timestart, 100) AS Courses_starttime, Courses_date, Courses_title, Courses_venue, Courses_trainer FROM TrainingCourses WHERE Courses_date >= DATEADD(day,-7, GETDATE()) AND Courses_date <= DATEADD(day,0, GETDATE()) ORDER BY Courses_date DESC, Courses_timestart DESC";
		String list = "";

		try {
			currentCon = ConnManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(sql);
			int count = 0;

			while (rs.next()) {
				String Courses_timeend = rs.getString("Courses_endtime");
				String Courses_timestart = rs.getString("Courses_starttime");
				String Courses_date = rs.getString("Courses_date");
				String Courses_title = rs.getString("Courses_title");
				String Courses_venue = rs.getString("Courses_venue");
				String Courses_trainer = rs.getString("Courses_trainer");
				String Courses_id = rs.getString("Courses_id");
				int timelooping = count++;

				list += "<div class=\"bttn-container\" id=\"filter" + Courses_date + "-" + timelooping + "\" name=\"filter" + Courses_date + "\">";
				list += "<div class=\"test\">";     
//				list += "<input hidden id=\"idforfilter\" value=\"filter" + Courses_date + "-" + timelooping + "\">";
				list += "<p hidden id=\"OrienCourseID\">" + Courses_id + "</p>";
				list += "<h2 id=\"OrienCourse\">" + Courses_title + "</h2>";
				list += "<p id=\"OrienTrainer\">" + Courses_trainer + "</p>";
				list += "<img  src=\"./img/icon/icon_forward2.png\" alt=\"HTML5 Icon\" class=\"imgbtnnext\"></img>";		
				list += "<p id=\"OrienDatetime\">" + Courses_date + " " + Courses_timestart + "-" + Courses_timeend + "</p>";
				list += "<p id=\"OrienVenue\">" + Courses_venue + "</p>";	
				list += "</div>";
				list += "</div>";
//				list += "<br>";
			}
			System.out.println(list);
		} catch (Exception ex) {
			System.out.println("getOrientationDetails failed: An Exception has occurred! " + ex);
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
