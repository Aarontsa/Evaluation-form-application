package my.com.bbraun.hrit.EvaluationForm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import my.com.bbraun.hrit.EvaluationForm.ReportSupervisorSummaryDAO;
//import my.com.bbraun.hrit.EvaluationForm.ReportSupervisorSummaryBean;
import my.com.bbraun.hrit.EvaluationForm.Sanitizer;

import com.google.gson.Gson;

public class ReportSupervisorSummaryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ReportSupervisorSummaryServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			/*** Pass the bean to DAO for processing ***/
			// bean = scheduleDAO.getOrientationDetails(Bean);
			ReportSupervisorSummaryDAO ReportSupervisorSummaryDAO = new ReportSupervisorSummaryDAO();

			/*** Convert the result to JSON format and return to the UI ***/

			String bean = ReportSupervisorSummaryDAO.getReportSupervisorSummaryDetails();
			 System.out.println(bean);

			String json = new Gson().toJson(bean);
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
			System.out.println(json);

		} catch (

		Throwable theException) {
			System.out.println(theException);
		}
	}

}
