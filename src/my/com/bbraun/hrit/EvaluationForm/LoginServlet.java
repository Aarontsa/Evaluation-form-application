package my.com.bbraun.hrit.EvaluationForm;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			/*** Get variable that sent from UI ***/
			int Emp_no = Integer.parseInt(request.getParameter("Emp_no"));
			String Emp_pass = request.getParameter("Emp_pass");
			System.out.println(Emp_no + Emp_pass);

			/*** Sanitize special characters - String variables only ***/
			String clean_Emp_pass = new Sanitizer().sanitize(Emp_pass);

			// System.out.println(clean_password);

			/*** Create a bean to temporary hold the data ***/
			LoginBean bean = new LoginBean();
			bean.SetEmp_no(Emp_no);
			bean.SetEmp_pass(clean_Emp_pass);
			// bean.setStatus(newStatus);

			/*** Pass the bean to DAO for processing ***/
			// bean.getStatus()
			bean = LoginDAO.login(bean);
			// String valid = Boolean.toString(bean.getStatus());

			// if (valid =="true")
			if (bean.getStatus()) {
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", bean);
				// System.out.println(valid);
				System.out.println(bean.getStatus());
				return;

			}

			else {

				System.out.println(bean.getStatus());

			}

			/*** Convert the result to JSON format and return to the UI ***/
			String json = new Gson().toJson(bean);
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);

		} catch (

		Throwable theException) {
			System.out.println(theException);
		}

	}

}
