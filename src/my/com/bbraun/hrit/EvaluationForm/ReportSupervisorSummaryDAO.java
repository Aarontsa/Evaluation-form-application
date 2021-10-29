package my.com.bbraun.hrit.EvaluationForm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReportSupervisorSummaryDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public String getReportSupervisorSummaryDetails() {
		Statement stmt = null;
		String sql ="select"
				  + "(select count(Q1) From TrainingFeedbackSupervisor where Q1='1') as 'S1',"
				  + "(select count(Q1) From TrainingFeedbackSupervisor where Q1='2') as 'S2',"
				  + "(select count(Q1) From TrainingFeedbackSupervisor where Q1='3') as 'S3',"
				  + "(select count(Q1) From TrainingFeedbackSupervisor where Q1='4') as 'S4',"
				  + "(select count(Q1) From TrainingFeedbackSupervisor where Q1='5') as 'S5',"
				  + "(select count(Q1) From TrainingFeedbackSupervisor where Q1='6') as 'S6',"
				  + "(select count(Q1) From TrainingFeedbackSupervisor where Q1='7') as 'S7',"
				  + "(select count(Q1) From TrainingFeedbackSupervisor where Q1='8') as 'S8',"
				  + "(select count(Q1) From TrainingFeedbackSupervisor where Q1='9') as 'S9',"
				  + "(select count(Q1) From TrainingFeedbackSupervisor where Q1='10') as 'S10',"
				  + "count(Feedback_S_id) as 'SQ1_No_pax',"
				  + "(select count(Q1) From TrainingFeedbackSupervisor where Q1='1')*1+(select count(Q1) From TrainingFeedbackSupervisor where Q1='2')*2+(select count(Q1) From TrainingFeedbackSupervisor where Q1='3')*3"
				  + "+(select count(Q1) From TrainingFeedbackSupervisor where Q1='4')*4+(select count(Q1) From TrainingFeedbackSupervisor where Q1='5')*5+(select count(Q1) From TrainingFeedbackSupervisor where Q1='6')*6"
				  + "+(select count(Q1) From TrainingFeedbackSupervisor where Q1='7')*7+(select count(Q1) From TrainingFeedbackSupervisor where Q1='8')*8+(select count(Q1) From TrainingFeedbackSupervisor where Q1='9')*9"
				  + "+(select count(Q1) From TrainingFeedbackSupervisor where Q1='10')*10 as 'SQ1_Total_pts',"
				  + "convert(decimal(5,2),(((select count(Q1) From TrainingFeedbackSupervisor where Q1='1')*1+(select count(Q1) From TrainingFeedbackSupervisor where Q1='2')*2+(select count(Q1) From TrainingFeedbackSupervisor where Q1='3')*3"
				  + "+(select count(Q1) From TrainingFeedbackSupervisor where Q1='4')*4+(select count(Q1) From TrainingFeedbackSupervisor where Q1='5')*5+(select count(Q1) From TrainingFeedbackSupervisor where Q1='6')*6"
				  + "+(select count(Q1) From TrainingFeedbackSupervisor where Q1='7')*7+(select count(Q1) From TrainingFeedbackSupervisor where Q1='8')*8+(select count(Q1) From TrainingFeedbackSupervisor where Q1='9')*9"
				  + "+(select count(Q1) From TrainingFeedbackSupervisor where Q1='10')*10)/convert(decimal(5,2),count(Feedback_S_id)))) as 'SQ1_Avg_pts',"
				  + "convert(decimal(5,2),(((select count(Q1) From TrainingFeedbackSupervisor where Q1='1')*1+(select count(Q1) From TrainingFeedbackSupervisor where Q1='2')*2+(select count(Q1) From TrainingFeedbackSupervisor where Q1='3')*3"
				  + "+(select count(Q1) From TrainingFeedbackSupervisor where Q1='4')*4+(select count(Q1) From TrainingFeedbackSupervisor where Q1='5')*5+(select count(Q1) From TrainingFeedbackSupervisor where Q1='6')*6"
				  + "+(select count(Q1) From TrainingFeedbackSupervisor where Q1='7')*7+(select count(Q1) From TrainingFeedbackSupervisor where Q1='8')*8+(select count(Q1) From TrainingFeedbackSupervisor where Q1='9')*9"
				  + "+(select count(Q1) From TrainingFeedbackSupervisor where Q1='10')*10)/convert(decimal(5,2),count(Feedback_S_id))))*10 as 'SQ1_Percentage',"
				  
				  + "(select count(Q1_1) From TrainingFeedbackSupervisor where Q1_1='1') as 'S1_1',"
				  + "(select count(Q1_2) From TrainingFeedbackSupervisor where Q1_2='2') as 'S1_2',"
				  + "(select count(Q1_3) From TrainingFeedbackSupervisor where Q1_3='3') as 'S1_3',"
				  + "(select count(Q1_4) From TrainingFeedbackSupervisor where Q1_4='4') as 'S1_4',"
				  + "(select count(Q1_5) From TrainingFeedbackSupervisor where Q1_5='5') as 'S1_5',"
				  + "count(Feedback_S_id) as 'SQ1_6_No_pax',"
				  + "(select count(Q1_1) From TrainingFeedbackSupervisor where Q1_1='1') +"
				  + "(select count(Q1_2) From TrainingFeedbackSupervisor where Q1_2='2') +"
				  + "(select count(Q1_3) From TrainingFeedbackSupervisor where Q1_3='3') +"
				  + "(select count(Q1_4) From TrainingFeedbackSupervisor where Q1_4='4') +"
				  + "(select count(Q1_5) From TrainingFeedbackSupervisor where Q1_5='5') as 'SQ1_7_total_check',"
				  + "convert(decimal(5,2),(((select count(Q1_1) From TrainingFeedbackSupervisor where Q1_1='1')*100.0/((select count(Q1_1) From TrainingFeedbackSupervisor where Q1_1='1') +"
				  + "(select count(Q1_2) From TrainingFeedbackSupervisor where Q1_2='2') +"
				  + "(select count(Q1_3) From TrainingFeedbackSupervisor where Q1_3='3') +"
				  + "(select count(Q1_4) From TrainingFeedbackSupervisor where Q1_4='4') +"
				  + "(select count(Q1_5) From TrainingFeedbackSupervisor where Q1_5='5'))))) as 'S1_1Percentage',"
				  + "convert(decimal(5,2),(((select count(Q1_2) From TrainingFeedbackSupervisor where Q1_2='2')*100.0/((select count(Q1_1) From TrainingFeedbackSupervisor where Q1_1='1') +"
				  + "(select count(Q1_2) From TrainingFeedbackSupervisor where Q1_2='2') +"
				  + "(select count(Q1_3) From TrainingFeedbackSupervisor where Q1_3='3') +"
				  + "(select count(Q1_4) From TrainingFeedbackSupervisor where Q1_4='4') +"
				  + "(select count(Q1_5) From TrainingFeedbackSupervisor where Q1_5='5'))))) as 'S1_2Percentage',"
				  + "convert(decimal(5,2),(((select count(Q1_3) From TrainingFeedbackSupervisor where Q1_3='3')*100.0/((select count(Q1_1) From TrainingFeedbackSupervisor where Q1_1='1') +"
				  + "(select count(Q1_2) From TrainingFeedbackSupervisor where Q1_2='2') +"
				  + "(select count(Q1_3) From TrainingFeedbackSupervisor where Q1_3='3') +"
				  + "(select count(Q1_4) From TrainingFeedbackSupervisor where Q1_4='4') +"
				  + "(select count(Q1_5) From TrainingFeedbackSupervisor where Q1_5='5'))))) as 'S1_3Percentage',"
				  + "convert(decimal(5,2),(((select count(Q1_4) From TrainingFeedbackSupervisor where Q1_4='4')*100.0/((select count(Q1_1) From TrainingFeedbackSupervisor where Q1_1='1') +"
				  + "(select count(Q1_2) From TrainingFeedbackSupervisor where Q1_2='2') +"
				  + "(select count(Q1_3) From TrainingFeedbackSupervisor where Q1_3='3') +"
				  + "(select count(Q1_4) From TrainingFeedbackSupervisor where Q1_4='4') +"
				  + "(select count(Q1_5) From TrainingFeedbackSupervisor where Q1_5='5'))))) as 'S1_4Percentage',"
				  + "convert(decimal(5,2),(((select count(Q1_5) From TrainingFeedbackSupervisor where Q1_5='5')*100.0/((select count(Q1_1) From TrainingFeedbackSupervisor where Q1_1='1') +"
				  + "(select count(Q1_2) From TrainingFeedbackSupervisor where Q1_2='2') +"
				  + "(select count(Q1_3) From TrainingFeedbackSupervisor where Q1_3='3') +"
				  + "(select count(Q1_4) From TrainingFeedbackSupervisor where Q1_4='4') +"
				  + "(select count(Q1_5) From TrainingFeedbackSupervisor where Q1_5='5'))))) as 'S1_5Percentage',"
				  
				  + "(select count(Q2_1) From TrainingFeedbackSupervisor where Q2_1='1') as 'S2_1',"
				  + "(select count(Q2_2) From TrainingFeedbackSupervisor where Q2_2='2') as 'S2_2',"
				  + "(select count(Q2_3) From TrainingFeedbackSupervisor where Q2_3='3') as 'S2_3',"
				  + "(select count(Q2_4) From TrainingFeedbackSupervisor where Q2_4='4') as 'S2_4',"
				  + "(select count(Q2_5) From TrainingFeedbackSupervisor where Q2_5='5') as 'S2_5',"
				  + "count(Feedback_S_id) as 'SQ2_6_No_pax',"
				  + "(select count(Q2_1) From TrainingFeedbackSupervisor where Q2_1='1') +"
				  + "(select count(Q2_2) From TrainingFeedbackSupervisor where Q2_2='2') +"
				  + "(select count(Q2_3) From TrainingFeedbackSupervisor where Q2_3='3') +"
				  + "(select count(Q2_4) From TrainingFeedbackSupervisor where Q2_4='4') +"
				  + "(select count(Q2_5) From TrainingFeedbackSupervisor where Q2_5='5') as 'SQ2_7_total_check',"
				  + "convert(decimal(5,2),(((select count(Q2_1) From TrainingFeedbackSupervisor where Q2_1='1')*100.0/((select count(Q2_1) From TrainingFeedbackSupervisor where Q2_1='1') +"
				  + "(select count(Q2_2) From TrainingFeedbackSupervisor where Q2_2='2') +"
				  + "(select count(Q2_3) From TrainingFeedbackSupervisor where Q2_3='3') +"
				  + "(select count(Q2_4) From TrainingFeedbackSupervisor where Q2_4='4') +"
				  + "(select count(Q2_5) From TrainingFeedbackSupervisor where Q2_5='5'))))) as 'S2_1Percentage',"
				  + "convert(decimal(5,2),(((select count(Q2_2) From TrainingFeedbackSupervisor where Q2_2='2')*100.0/((select count(Q2_1) From TrainingFeedbackSupervisor where Q2_1='1') +"
				  + "(select count(Q2_2) From TrainingFeedbackSupervisor where Q2_2='2') +"
				  + "(select count(Q2_3) From TrainingFeedbackSupervisor where Q2_3='3') +"
				  + "(select count(Q2_4) From TrainingFeedbackSupervisor where Q2_4='4') +"
				  + "(select count(Q2_5) From TrainingFeedbackSupervisor where Q2_5='5'))))) as 'S2_2Percentage',"
				  + "convert(decimal(5,2),(((select count(Q2_3) From TrainingFeedbackSupervisor where Q2_3='3')*100.0/((select count(Q2_1) From TrainingFeedbackSupervisor where Q2_1='1') +"
				  + "(select count(Q2_2) From TrainingFeedbackSupervisor where Q2_2='2') +"
				  + "(select count(Q2_3) From TrainingFeedbackSupervisor where Q2_3='3') +"
				  + "(select count(Q2_4) From TrainingFeedbackSupervisor where Q2_4='4') +"
				  + "(select count(Q2_5) From TrainingFeedbackSupervisor where Q2_5='5'))))) as 'S2_3Percentage',"
				  + "convert(decimal(5,2),(((select count(Q2_4) From TrainingFeedbackSupervisor where Q2_4='4')*100.0/((select count(Q2_1) From TrainingFeedbackSupervisor where Q2_1='1') +"
				  + "(select count(Q2_2) From TrainingFeedbackSupervisor where Q2_2='2') +"
				  + "(select count(Q2_3) From TrainingFeedbackSupervisor where Q2_3='3') +"
				  + "(select count(Q2_4) From TrainingFeedbackSupervisor where Q2_4='4') +"
				  + "(select count(Q2_5) From TrainingFeedbackSupervisor where Q2_5='5'))))) as 'S2_4Percentage',"
				  + "convert(decimal(5,2),(((select count(Q2_5) From TrainingFeedbackSupervisor where Q2_5='5')*100.0/((select count(Q2_1) From TrainingFeedbackSupervisor where Q2_1='1') +"
				  + "(select count(Q2_2) From TrainingFeedbackSupervisor where Q2_2='2') +"
				  + "(select count(Q2_3) From TrainingFeedbackSupervisor where Q2_3='3') +"
				  + "(select count(Q2_4) From TrainingFeedbackSupervisor where Q2_4='4') +"
				  + "(select count(Q2_5) From TrainingFeedbackSupervisor where Q2_5='5'))))) as 'S2_5Percentage'"
				  + "From TrainingFeedbackSupervisor;";
		String list = "";

		try {
			currentCon = ConnManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(sql);
//			int count = 1;

			while (rs.next()) {
				String Feedback_S_1 = rs.getString("S1");
				String Feedback_S_2 = rs.getString("S2");
				String Feedback_S_3 = rs.getString("S3");
				String Feedback_S_4 = rs.getString("S4");
				String Feedback_S_5 = rs.getString("S5");
				String Feedback_S_6 = rs.getString("S6");
				String Feedback_S_7 = rs.getString("S7");
				String Feedback_S_8 = rs.getString("S8");
				String Feedback_S_9 = rs.getString("S9");
				String Feedback_S_10 = rs.getString("S10");
				String Feedback_S_Q1_No_pax = rs.getString("SQ1_No_pax");
				String Feedback_S_Q1_Total_pts = rs.getString("SQ1_Total_pts");
				String Feedback_S_Q1_Avg_pts = rs.getString("SQ1_Avg_pts");
				String Feedback_S_Q1_Percentage = rs.getString("SQ1_Percentage");
				
				String Feedback_S_1_1 = rs.getString("S1_1");
				String Feedback_S_1_2 = rs.getString("S1_2");
				String Feedback_S_1_3 = rs.getString("S1_3");
				String Feedback_S_1_4 = rs.getString("S1_4");
				String Feedback_S_1_5 = rs.getString("S1_5");
				String Feedback_S_Q1_6_No_pax = rs.getString("SQ1_6_No_pax");
				String Feedback_S_Q1_7_total_check = rs.getString("SQ1_7_total_check");
				String Feedback_S_1_1Percentage = rs.getString("S1_1Percentage");
				String Feedback_S_1_2Percentage = rs.getString("S1_2Percentage");
				String Feedback_S_1_3Percentage = rs.getString("S1_3Percentage");
				String Feedback_S_1_4Percentage = rs.getString("S1_4Percentage");
				String Feedback_S_1_5Percentage = rs.getString("S1_5Percentage");
			
				String Feedback_S_2_1 = rs.getString("S2_1");
				String Feedback_S_2_2 = rs.getString("S2_2");
				String Feedback_S_2_3 = rs.getString("S2_3");
				String Feedback_S_2_4 = rs.getString("S2_4");
				String Feedback_S_2_5 = rs.getString("S2_5");
				String Feedback_S_Q2_6_No_pax = rs.getString("SQ2_6_No_pax");
				String Feedback_S_Q2_7_total_check = rs.getString("SQ2_7_total_check");
				String Feedback_S_2_1Percentage = rs.getString("S2_1Percentage");
				String Feedback_S_2_2Percentage = rs.getString("S2_2Percentage");
				String Feedback_S_2_3Percentage = rs.getString("S2_3Percentage");
				String Feedback_S_2_4Percentage = rs.getString("S2_4Percentage");
				String Feedback_S_2_5Percentage = rs.getString("S2_5Percentage");
						


				list += "<p class=\"positionSsummary\"><strong>Supervisor summary</strong></p>";
				list += "<p class=\"positionSsummary\"><strong class=\"txtblack\">Q1. On the scale from 1 to 10, what is my overall rating for my employee's improvement after completed the training.</strong></p>";
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
				list += "<tr><td class=\"size\">"+ Feedback_S_1+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_2+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_3+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_4+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_5+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_6+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_7+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_8+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_9+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_10+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_Q1_No_pax+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_Q1_Total_pts+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_Q1_Avg_pts+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_Q1_Percentage+"</td>";
				list += "	</tr>";
				list += "	</table><br><br>";

				list += "<p class=\"positionS_subtext\"><strong class=\"txtblack\">1_1. Employee improved his or her knowledge after attending training.</strong></p>";
				list += "<p class=\"positionS_subtext\"><strong class=\"txtblack\">1_2. Employee’s performance meet my expectation after attending training.</strong></p>";
				list += "<p class=\"positionS_subtext\"><strong class=\"txtblack\">1_3. Employee able to implement the knowledge learned from training to their work.</strong></p>";
				list += "<p class=\"positionS_subtext\"><strong class=\"txtblack\">1_4. Employee is committed in making a positive change after attending training.</strong></p>";
				list += "<p class=\"positionS_subtext\"><strong class=\"txtblack\">1_5. Others.</strong></p>";
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
				list += "	<td class=\"size\">"+ Feedback_S_1_1+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_1_2+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_1_3+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_1_4+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_1_5+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_Q1_6_No_pax+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_Q1_7_total_check+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_1_1Percentage+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_1_2Percentage+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_1_3Percentage+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_1_4Percentage+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_1_5Percentage+"</td>";
				list += "	</tr>";
				list += "	</table><br><br>";

				list += "<p class=\"positionSsummary\"><strong class=\"txtblack\">Q2. What is your observation after your employee attended the training.</strong></p>";
				list += "<p class=\"positionS_subtext\"><strong class=\"txtblack\">2_1. Employee is able to perform their tasks by using the tools or techniques they have learned in class.</strong></p>";
				list += "<p class=\"positionS_subtext\"><strong class=\"txtblack\">2_2. Employee has positive mindset of performing the task after attending training.</strong></p>";
				list += "<p class=\"positionS_subtext\"><strong class=\"txtblack\">2_3. Employee’s working behavior has improved after attending training.</strong></p>";
				list += "<p class=\"positionS_subtext\"><strong class=\"txtblack\">2_4. Employee’s have more ideas on how to get the task done after attending training.</strong></p>";
				list += "<p class=\"positionS_subtext\"><strong class=\"txtblack\">2_5. Others / specify specific observation.</strong></p>";
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
				list += "	<td class=\"size\">"+ Feedback_S_2_1+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_2_2+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_2_3+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_2_4+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_2_5+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_Q2_6_No_pax+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_Q2_7_total_check+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_2_1Percentage+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_2_2Percentage+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_2_3Percentage+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_2_4Percentage+"</td>";
				list += "	<td class=\"size\">"+ Feedback_S_2_5Percentage+"</td>";
				list += "	</tr>";
				list += "	</table><br><br>";


				
			}
			System.out.println(list);
		} catch (Exception ex) {
			System.out.println("getReportSupervisorSummaryDetails failed: An Exception has occurred! " + ex);
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
