package my.com.bbraun.hrit.EvaluationForm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import my.com.bbraun.hrit.EvaluationForm.ReportSupervisorDAO;
//import my.com.bbraun.hrit.EvaluationForm.ReportSupervisorBean;
import my.com.bbraun.hrit.EvaluationForm.Sanitizer;

import com.google.gson.Gson;

public class ReportSupervisorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ReportSupervisorServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			/*** Pass the bean to DAO for processing ***/
			// bean = scheduleDAO.getOrientationDetails(Bean);
			ReportSupervisorDAO ReportSupervisorDAO = new ReportSupervisorDAO();

			/*** Convert the result to JSON format and return to the UI ***/

			String bean = ReportSupervisorDAO.getReportSupervisorDetails();
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
