package my.com.bbraun.hrit.EvaluationForm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReportSummaryDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public String getReportSummaryDetails() {
		Statement stmt = null;
		String sql ="select"
				  + "(select count(Q1) From TrainingFeedbackParticipant where Q1='1') as '1',"
				  + "(select count(Q1) From TrainingFeedbackParticipant where Q1='2') as '2',"
				  + "(select count(Q1) From TrainingFeedbackParticipant where Q1='3') as '3',"
				  + "(select count(Q1) From TrainingFeedbackParticipant where Q1='4') as '4',"
				  + "(select count(Q1) From TrainingFeedbackParticipant where Q1='5') as '5',"
				  + "(select count(Q1) From TrainingFeedbackParticipant where Q1='6') as '6',"
				  + "(select count(Q1) From TrainingFeedbackParticipant where Q1='7') as '7',"
				  + "(select count(Q1) From TrainingFeedbackParticipant where Q1='8') as '8',"
				  + "(select count(Q1) From TrainingFeedbackParticipant where Q1='9') as '9',"
				  + "(select count(Q1) From TrainingFeedbackParticipant where Q1='10') as '10',"
				  + "count(Feedback_P_id) as 'Q1_No_pax',"
				  + "(select count(Q1) From TrainingFeedbackParticipant where Q1='1')*1+(select count(Q1) From TrainingFeedbackParticipant where Q1='2')*2+(select count(Q1) From TrainingFeedbackParticipant where Q1='3')*3"
				  + "+(select count(Q1) From TrainingFeedbackParticipant where Q1='4')*4+(select count(Q1) From TrainingFeedbackParticipant where Q1='5')*5+(select count(Q1) From TrainingFeedbackParticipant where Q1='6')*6"
				  + "+(select count(Q1) From TrainingFeedbackParticipant where Q1='7')*7+(select count(Q1) From TrainingFeedbackParticipant where Q1='8')*8+(select count(Q1) From TrainingFeedbackParticipant where Q1='9')*9"
				  + "+(select count(Q1) From TrainingFeedbackParticipant where Q1='10')*10 as 'Q1_Total_pts',"
				  + "convert(decimal(5,2),(((select count(Q1) From TrainingFeedbackParticipant where Q1='1')*1+(select count(Q1) From TrainingFeedbackParticipant where Q1='2')*2+(select count(Q1) From TrainingFeedbackParticipant where Q1='3')*3"
				  + "+(select count(Q1) From TrainingFeedbackParticipant where Q1='4')*4+(select count(Q1) From TrainingFeedbackParticipant where Q1='5')*5+(select count(Q1) From TrainingFeedbackParticipant where Q1='6')*6"
				  + "+(select count(Q1) From TrainingFeedbackParticipant where Q1='7')*7+(select count(Q1) From TrainingFeedbackParticipant where Q1='8')*8+(select count(Q1) From TrainingFeedbackParticipant where Q1='9')*9"
				  + "+(select count(Q1) From TrainingFeedbackParticipant where Q1='10')*10)/convert(decimal(5,2),count(Feedback_P_id)))) as 'Q1_Avg_pts',"
				  + "convert(decimal(5,2),(((select count(Q1) From TrainingFeedbackParticipant where Q1='1')*1+(select count(Q1) From TrainingFeedbackParticipant where Q1='2')*2+(select count(Q1) From TrainingFeedbackParticipant where Q1='3')*3"
				  + "+(select count(Q1) From TrainingFeedbackParticipant where Q1='4')*4+(select count(Q1) From TrainingFeedbackParticipant where Q1='5')*5+(select count(Q1) From TrainingFeedbackParticipant where Q1='6')*6"
				  + "+(select count(Q1) From TrainingFeedbackParticipant where Q1='7')*7+(select count(Q1) From TrainingFeedbackParticipant where Q1='8')*8+(select count(Q1) From TrainingFeedbackParticipant where Q1='9')*9"
				  + "+(select count(Q1) From TrainingFeedbackParticipant where Q1='10')*10)/convert(decimal(5,2),count(Feedback_P_id))))*10 as 'Q1_Percentage',"
				  
				  + "(select count(Q1_1) From TrainingFeedbackParticipant where Q1_1='1') as '1_1',"
				  + "(select count(Q1_2) From TrainingFeedbackParticipant where Q1_2='2') as '1_2',"
				  + "(select count(Q1_3) From TrainingFeedbackParticipant where Q1_3='3') as '1_3',"
				  + "(select count(Q1_4) From TrainingFeedbackParticipant where Q1_4='4') as '1_4',"
				  + "(select count(Q1_5) From TrainingFeedbackParticipant where Q1_5='5') as '1_5',"
				  + "count(Feedback_P_id) as 'Q1_6_No_pax',"
				  + "(select count(Q1_1) From TrainingFeedbackParticipant where Q1_1='1') +"
				  + "(select count(Q1_2) From TrainingFeedbackParticipant where Q1_2='2') +"
				  + "(select count(Q1_3) From TrainingFeedbackParticipant where Q1_3='3') +"
				  + "(select count(Q1_4) From TrainingFeedbackParticipant where Q1_4='4') +"
				  + "(select count(Q1_5) From TrainingFeedbackParticipant where Q1_5='5') as 'Q1_7_total_check',"
				  + "convert(decimal(5,2),(((select count(Q1_1) From TrainingFeedbackParticipant where Q1_1='1')*100.0/((select count(Q1_1) From TrainingFeedbackParticipant where Q1_1='1') +"
				  + "(select count(Q1_2) From TrainingFeedbackParticipant where Q1_2='2') +"
				  + "(select count(Q1_3) From TrainingFeedbackParticipant where Q1_3='3') +"
				  + "(select count(Q1_4) From TrainingFeedbackParticipant where Q1_4='4') +"
				  + "(select count(Q1_5) From TrainingFeedbackParticipant where Q1_5='5'))))) as '1_1Percentage',"
				  + "convert(decimal(5,2),(((select count(Q1_2) From TrainingFeedbackParticipant where Q1_2='2')*100.0/((select count(Q1_1) From TrainingFeedbackParticipant where Q1_1='1') +"
				  + "(select count(Q1_2) From TrainingFeedbackParticipant where Q1_2='2') +"
				  + "(select count(Q1_3) From TrainingFeedbackParticipant where Q1_3='3') +"
				  + "(select count(Q1_4) From TrainingFeedbackParticipant where Q1_4='4') +"
				  + "(select count(Q1_5) From TrainingFeedbackParticipant where Q1_5='5'))))) as '1_2Percentage',"
				  + "convert(decimal(5,2),(((select count(Q1_3) From TrainingFeedbackParticipant where Q1_3='3')*100.0/((select count(Q1_1) From TrainingFeedbackParticipant where Q1_1='1') +"
				  + "(select count(Q1_2) From TrainingFeedbackParticipant where Q1_2='2') +"
				  + "(select count(Q1_3) From TrainingFeedbackParticipant where Q1_3='3') +"
				  + "(select count(Q1_4) From TrainingFeedbackParticipant where Q1_4='4') +"
				  + "(select count(Q1_5) From TrainingFeedbackParticipant where Q1_5='5'))))) as '1_3Percentage',"
				  + "convert(decimal(5,2),(((select count(Q1_4) From TrainingFeedbackParticipant where Q1_4='4')*100.0/((select count(Q1_1) From TrainingFeedbackParticipant where Q1_1='1') +"
				  + "(select count(Q1_2) From TrainingFeedbackParticipant where Q1_2='2') +"
				  + "(select count(Q1_3) From TrainingFeedbackParticipant where Q1_3='3') +"
				  + "(select count(Q1_4) From TrainingFeedbackParticipant where Q1_4='4') +"
				  + "(select count(Q1_5) From TrainingFeedbackParticipant where Q1_5='5'))))) as '1_4Percentage',"
				  + "convert(decimal(5,2),(((select count(Q1_5) From TrainingFeedbackParticipant where Q1_5='5')*100.0/((select count(Q1_1) From TrainingFeedbackParticipant where Q1_1='1') +"
				  + "(select count(Q1_2) From TrainingFeedbackParticipant where Q1_2='2') +"
				  + "(select count(Q1_3) From TrainingFeedbackParticipant where Q1_3='3') +"
				  + "(select count(Q1_4) From TrainingFeedbackParticipant where Q1_4='4') +"
				  + "(select count(Q1_5) From TrainingFeedbackParticipant where Q1_5='5'))))) as '1_5Percentage',"
				  
				  + "(select count(Q2_1) From TrainingFeedbackParticipant where Q2_1='1') as '2_1',"
				  + "(select count(Q2_2) From TrainingFeedbackParticipant where Q2_2='2') as '2_2',"
				  + "(select count(Q2_3) From TrainingFeedbackParticipant where Q2_3='3') as '2_3',"
				  + "(select count(Q2_4) From TrainingFeedbackParticipant where Q2_4='4') as '2_4',"
				  + "(select count(Q2_5) From TrainingFeedbackParticipant where Q2_5='5') as '2_5',"
				  + "count(Feedback_P_id) as 'Q2_6_No_pax',"
				  + "(select count(Q2_1) From TrainingFeedbackParticipant where Q2_1='1') +"
				  + "(select count(Q2_2) From TrainingFeedbackParticipant where Q2_2='2') +"
				  + "(select count(Q2_3) From TrainingFeedbackParticipant where Q2_3='3') +"
				  + "(select count(Q2_4) From TrainingFeedbackParticipant where Q2_4='4') +"
				  + "(select count(Q2_5) From TrainingFeedbackParticipant where Q2_5='5') as 'Q2_7_total_check',"
				  + "convert(decimal(5,2),(((select count(Q2_1) From TrainingFeedbackParticipant where Q2_1='1')*100.0/((select count(Q2_1) From TrainingFeedbackParticipant where Q2_1='1') +"
				  + "(select count(Q2_2) From TrainingFeedbackParticipant where Q2_2='2') +"
				  + "(select count(Q2_3) From TrainingFeedbackParticipant where Q2_3='3') +"
				  + "(select count(Q2_4) From TrainingFeedbackParticipant where Q2_4='4') +"
				  + "(select count(Q2_5) From TrainingFeedbackParticipant where Q2_5='5'))))) as '2_1Percentage',"
				  + "convert(decimal(5,2),(((select count(Q2_2) From TrainingFeedbackParticipant where Q2_2='2')*100.0/((select count(Q2_1) From TrainingFeedbackParticipant where Q2_1='1') +"
				  + "(select count(Q2_2) From TrainingFeedbackParticipant where Q2_2='2') +"
				  + "(select count(Q2_3) From TrainingFeedbackParticipant where Q2_3='3') +"
				  + "(select count(Q2_4) From TrainingFeedbackParticipant where Q2_4='4') +"
				  + "(select count(Q2_5) From TrainingFeedbackParticipant where Q2_5='5'))))) as '2_2Percentage',"
				  + "convert(decimal(5,2),(((select count(Q2_3) From TrainingFeedbackParticipant where Q2_3='3')*100.0/((select count(Q2_1) From TrainingFeedbackParticipant where Q2_1='1') +"
				  + "(select count(Q2_2) From TrainingFeedbackParticipant where Q2_2='2') +"
				  + "(select count(Q2_3) From TrainingFeedbackParticipant where Q2_3='3') +"
				  + "(select count(Q2_4) From TrainingFeedbackParticipant where Q2_4='4') +"
				  + "(select count(Q2_5) From TrainingFeedbackParticipant where Q2_5='5'))))) as '2_3Percentage',"
				  + "convert(decimal(5,2),(((select count(Q2_4) From TrainingFeedbackParticipant where Q2_4='4')*100.0/((select count(Q2_1) From TrainingFeedbackParticipant where Q2_1='1') +"
				  + "(select count(Q2_2) From TrainingFeedbackParticipant where Q2_2='2') +"
				  + "(select count(Q2_3) From TrainingFeedbackParticipant where Q2_3='3') +"
				  + "(select count(Q2_4) From TrainingFeedbackParticipant where Q2_4='4') +"
				  + "(select count(Q2_5) From TrainingFeedbackParticipant where Q2_5='5'))))) as '2_4Percentage',"
				  + "convert(decimal(5,2),(((select count(Q2_5) From TrainingFeedbackParticipant where Q2_5='5')*100.0/((select count(Q2_1) From TrainingFeedbackParticipant where Q2_1='1') +"
				  + "(select count(Q2_2) From TrainingFeedbackParticipant where Q2_2='2') +"
				  + "(select count(Q2_3) From TrainingFeedbackParticipant where Q2_3='3') +"
				  + "(select count(Q2_4) From TrainingFeedbackParticipant where Q2_4='4') +"
				  + "(select count(Q2_5) From TrainingFeedbackParticipant where Q2_5='5'))))) as '2_5Percentage',"
				  
				  + "(select count(Q3) From TrainingFeedbackParticipant where Q3='3') as '3mth',"
				  + "(select count(Q3) From TrainingFeedbackParticipant where Q3='6') as '6mth',"
				  + "(select count(Q3) From TrainingFeedbackParticipant where Q3='12') as '12mth',"
				  + "count(Feedback_P_id) as 'Q3_No_pax',"
				  + "(select count(Q3) From TrainingFeedbackParticipant where Q3='3')*1 + (select count(Q3) From TrainingFeedbackParticipant where Q3='6')*2 +"
				  + "(select count(Q3) From TrainingFeedbackParticipant where Q3='12')*3  as 'Q3_Total_pts',"
				  + "convert(decimal(5,2),(((select count(Q3) From TrainingFeedbackParticipant where Q3='3')*1 + (select count(Q3) From TrainingFeedbackParticipant where Q3='6')*2 +"
				  + "(select count(Q3) From TrainingFeedbackParticipant where Q3='12')*3)/convert(decimal(5,2),count(Feedback_P_id)))) as 'Q3_Avg_pts',"
				  + "convert(decimal(5,2),(((select count(Q3) From TrainingFeedbackParticipant where Q3='3')*1 + (select count(Q3) From TrainingFeedbackParticipant where Q3='6')*2 +"
				  + "(select count(Q3) From TrainingFeedbackParticipant where Q3='12')*3)/convert(decimal(5,2),count(Feedback_P_id))))*10 as 'Q3_Percentage'"
				  + "From TrainingFeedbackParticipant ;";
		String list = "";

		try {
			currentCon = ConnManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(sql);
//			int count = 1;

			while (rs.next()) {
				String Feedback_P_1 = rs.getString("1");
				String Feedback_P_2 = rs.getString("2");
				String Feedback_P_3 = rs.getString("3");
				String Feedback_P_4 = rs.getString("4");
				String Feedback_P_5 = rs.getString("5");
				String Feedback_P_6 = rs.getString("6");
				String Feedback_P_7 = rs.getString("7");
				String Feedback_P_8 = rs.getString("8");
				String Feedback_P_9 = rs.getString("9");
				String Feedback_P_10 = rs.getString("10");
				String Feedback_P_Q1_No_pax = rs.getString("Q1_No_pax");
				String Feedback_P_Q1_Total_pts = rs.getString("Q1_Total_pts");
				String Feedback_P_Q1_Avg_pts = rs.getString("Q1_Avg_pts");
				String Feedback_P_Q1_Percentage = rs.getString("Q1_Percentage");
				
				String Feedback_P_1_1 = rs.getString("1_1");
				String Feedback_P_1_2 = rs.getString("1_2");
				String Feedback_P_1_3 = rs.getString("1_3");
				String Feedback_P_1_4 = rs.getString("1_4");
				String Feedback_P_1_5 = rs.getString("1_5");
				String Feedback_P_Q1_6_No_pax = rs.getString("Q1_6_No_pax");
				String Feedback_P_Q1_7_total_check = rs.getString("Q1_7_total_check");
				String Feedback_P_1_1Percentage = rs.getString("1_1Percentage");
				String Feedback_P_1_2Percentage = rs.getString("1_2Percentage");
				String Feedback_P_1_3Percentage = rs.getString("1_3Percentage");
				String Feedback_P_1_4Percentage = rs.getString("1_4Percentage");
				String Feedback_P_1_5Percentage = rs.getString("1_5Percentage");
				
				String Feedback_P_2_1 = rs.getString("2_1");
				String Feedback_P_2_2 = rs.getString("2_2");
				String Feedback_P_2_3 = rs.getString("2_3");
				String Feedback_P_2_4 = rs.getString("2_4");
				String Feedback_P_2_5 = rs.getString("2_5");
				String Feedback_P_Q2_6_No_pax = rs.getString("Q2_6_No_pax");
				String Feedback_P_Q2_7_total_check = rs.getString("Q2_7_total_check");
				String Feedback_P_2_1Percentage = rs.getString("2_1Percentage");
				String Feedback_P_2_2Percentage = rs.getString("2_2Percentage");
				String Feedback_P_2_3Percentage = rs.getString("2_3Percentage");
				String Feedback_P_2_4Percentage = rs.getString("2_4Percentage");
				String Feedback_P_2_5Percentage = rs.getString("2_5Percentage");
				
				String Feedback_P_3mth = rs.getString("3mth");
				String Feedback_P_6mth =rs.getString("6mth");
				String Feedback_P_12mth = rs.getString("12mth");
				String Feedback_P_Q3_No_pax = rs.getString("Q3_No_pax");
				String Feedback_P_Q3_Total_pts = rs.getString("Q3_Total_pts");
				String Feedback_P_Q3_Avg_pts = rs.getString("Q3_Avg_pts");
				String Feedback_P_Q3_Percentage = rs.getString("Q3_Percentage");
				


				list += "<p class=\"positionPsummary\"><strong>Participant summary</strong></p>";
				list += "<p class=\"positionPsummary\"><strong class=\"txtblack\">Q1. On a scale from 1-10, what is your overall rating for this program?</strong></p>";
				list += "<table rules=\"all\" id=\"reporttablesummary\" class=\"reporttablesize\">";
				list += "<tr class=\"reporttitlecolor\">";
				list += "	<td class=\"size\"><strong class=\"txtblack\">1</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">2</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">3</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">4</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">5</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">6</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">7</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">8</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">9</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">10</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">No_pax</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">Total_pts</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">Avg_pts</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">Percentage</strong></td>";
				list += "	</tr>";
				list += "<tr><td class=\"size\">"+ Feedback_P_1+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_2+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_3+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_4+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_5+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_6+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_7+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_8+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_9+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_10+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_Q1_No_pax+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_Q1_Total_pts+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_Q1_Avg_pts+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_Q1_Percentage+"</td>";
				list += "	</tr>";
				list += "	</table><br><br>";

				list += "<p class=\"positionP_subtext\"><strong class=\"txtblack\">1_1. The course content matched the learning objectives.</strong></p>";
				list += "<p class=\"positionP_subtext\"><strong class=\"txtblack\">1_2. Instructor was engaging and manage the dynamics of the participant well.</strong></p>";
				list += "<p class=\"positionP_subtext\"><strong class=\"txtblack\">1_3. Instructor able to make complex topics easy to understand.</strong></p>";
				list += "<p class=\"positionP_subtext\"><strong class=\"txtblack\">1_4. There were sufficient activities provided to enhance the learning.</strong></p>";
				list += "<p class=\"positionP_subtext\"><strong class=\"txtblack\">1_5. Others.</strong></p>";
				list += "<table rules=\"all\" id=\"reporttablesummary\" class=\"reporttablesize\">";
				list += "<tr class=\"reporttitlecolor\">";
				list += "	<td class=\"size\"><strong class=\"txtblack\">1_1</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">1_2</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">1_3</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">1_4</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">1_5</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">No_pax</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">Total_check</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">1_1%</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">1_2%</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">1_3%</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">1_4%</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">1_5%</strong></td>";
				list += "	</tr>";
				list += "	<tr>";
				list += "	<td class=\"size\">"+ Feedback_P_1_1+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_1_2+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_1_3+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_1_4+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_1_5+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_Q1_6_No_pax+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_Q1_7_total_check+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_1_1Percentage+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_1_2Percentage+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_1_3Percentage+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_1_4Percentage+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_1_5Percentage+"</td>";
				list += "	</tr>";
				list += "	</table><br><br>";

				list += "<p class=\"positionPsummary\"><strong class=\"txtblack\">Q2. What is my improvement plan after training?</strong></p>";
				list += "<p class=\"positionP_subtext\"><strong class=\"txtblack\">2_1. I am able to perform my tasks by using the tools and techniques I have learned in class.</strong></p>";
				list += "<p class=\"positionP_subtext\"><strong class=\"txtblack\">2_2. I have positive mindset of performing my task after training.</strong></p>";
				list += "<p class=\"positionP_subtext\"><strong class=\"txtblack\">2_3. I have more ideas on how to improve my task after training.</strong></p>";
				list += "<p class=\"positionP_subtext\"><strong class=\"txtblack\">2_4. I am committed in putting learning into application after the training.</strong></p>";
				list += "<p class=\"positionP_subtext\"><strong class=\"txtblack\">2_5. Others / specify specific plans.</strong></p>";
				list += "<table rules=\"all\" id=\"reporttablesummary\" class=\"reporttablesize\">";
				list += "<tr class=\"reporttitlecolor\">";
				list += "	<td class=\"size\"><strong class=\"txtblack\">2_1</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">2_2</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">2_3</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">2_4</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">2_5</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">No_pax</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">Total_check</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">2_1%</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">2_2%</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">2_3%</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">2_4%</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">2_5%</strong></td>";
				list += "</tr>";
				list += "	<tr>";
				list += "	<td class=\"size\">"+ Feedback_P_2_1+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_2_2+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_2_3+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_2_4+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_2_5+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_Q2_6_No_pax+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_Q2_7_total_check+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_2_1Percentage+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_2_2Percentage+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_2_3Percentage+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_2_4Percentage+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_2_5Percentage+"</td>";
				list += "	</tr>";
				list += "	</table><br><br>";

				list += "<p class=\"positionPsummary\"><strong class=\"txtblack\">Q3. When do i start the improvement plan?</strong></p>";
				list += "<table rules=\"all\" id=\"reporttablesummary\" class=\"reporttablesize\">";
				list += "<tr class=\"reporttitlecolor\">";
				list += "	<td class=\"size\"><strong class=\"txtblack\">3mth</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">6mth</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">12mth</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">No_pax</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">Total_pts</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">Avg_pts</strong></td>";
				list += "	<td class=\"size\"><strong class=\"txtblack\">Percentage</strong></td>";
				list += "</tr>";
				list += "	<tr>";
				list += "	<td class=\"size\">"+ Feedback_P_3mth+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_6mth+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_12mth+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_Q3_No_pax+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_Q3_Total_pts+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_Q3_Avg_pts+"</td>";
				list += "	<td class=\"size\">"+ Feedback_P_Q3_Percentage+"</td>";
				list += "	</tr>";
				list += "	</table><br><br>";


				
			}
			System.out.println(list);
		} catch (Exception ex) {
			System.out.println("getReportSummaryDetails failed: An Exception has occurred! " + ex);
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
