package my.com.bbraun.hrit.EvaluationForm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import my.com.bbraun.hrit.EvaluationForm.FeedbackFormDAO;
import my.com.bbraun.hrit.EvaluationForm.FeedbackFormBean;
import my.com.bbraun.hrit.EvaluationForm.Sanitizer;

import com.google.gson.Gson;

public class FeedbackFormServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public FeedbackFormServlet() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			/*** Get variable that sent from UI ***/
			 //HttpSession request = request.getSession();
			 //String a1 = request.getParameter("a1").toString();
			 int Q1 = Integer.parseInt(request.getParameter("Q1"));
			 int Q1_1 = Integer.parseInt(request.getParameter("Q1_1"));
			 int Q1_2 = Integer.parseInt(request.getParameter("Q1_2"));
			 int Q1_3 = Integer.parseInt(request.getParameter("Q1_3"));
			 int Q1_4 = Integer.parseInt(request.getParameter("Q1_4"));
			 int Q1_5 = Integer.parseInt(request.getParameter("Q1_5"));
			 int Q2_1 = Integer.parseInt(request.getParameter("Q2_1"));
			 int Q2_2 = Integer.parseInt(request.getParameter("Q2_2"));
			 int Q2_3 = Integer.parseInt(request.getParameter("Q2_3"));
			 int Q2_4 = Integer.parseInt(request.getParameter("Q2_4"));
			 int Q2_5 = Integer.parseInt(request.getParameter("Q2_5"));
			 int Q3 = Integer.parseInt(request.getParameter("Q3"));

			 
			 String Q1_5_C_g = request.getParameter("Q1_5_C_g");
			 String Q1_5_C_b = request.getParameter("Q1_5_C_b");
			 String Q2_5_C = request.getParameter("Q2_5_C");
			 String courseTitle = request.getParameter("courseTitle");
			 int Emp_no_create = Integer.parseInt(request.getParameter("Emp_no_create"));
			 int Course_id = Integer.parseInt(request.getParameter("Course_id"));
//			 String courseTitleID = request.getParameter("courseTitleID");
//			 String Emp_noCreate = request.getParameter("Emp_noCreate");
			 //System.out.println(d2);
			 
			/*** Sanitize special characters - String variables only ***/
			 String clean_Q1_5_C_g = new Sanitizer().sanitize(Q1_5_C_g);
			 String clean_Q1_5_C_b = new Sanitizer().sanitize(Q1_5_C_b);
			 String clean_Q2_5_C = new Sanitizer().sanitize(Q2_5_C);
			 String clean_courseTitle = new Sanitizer().sanitize(courseTitle);
//			 String clean_Emp_noCreate = new Sanitizer().sanitize(Emp_noCreate);
//			 System.out.println(clean_d2);
			
			 /*** Create a bean to temporary hold the data ***/
			 FeedbackFormBean bean = new FeedbackFormBean();
			 bean.SetQ1(Q1);
			 bean.SetQ1_1(Q1_1);
			 bean.SetQ1_2(Q1_2);
			 bean.SetQ1_3(Q1_3);
			 bean.SetQ1_4(Q1_4);
			 bean.SetQ1_5(Q1_5);
			 bean.SetQ2_1(Q2_1);
			 bean.SetQ2_2(Q2_2);
			 bean.SetQ2_3(Q2_3);
			 bean.SetQ2_4(Q2_4);
			 bean.SetQ2_5(Q2_5);
			 bean.SetQ3(Q3);
			 bean.SetQ1_5_C_g(clean_Q1_5_C_g);
			 bean.SetQ1_5_C_b(clean_Q1_5_C_b);
			 bean.SetQ2_5_C(clean_Q2_5_C);
			 bean.SetcourseTitle(clean_courseTitle);
			 bean.SetCourse_id(Course_id);
//			 bean.SetData13(clean_Emp_noCreate);
			 bean.SetEmp_no_create(Emp_no_create);
//			 bean.SetData14(clean_courseTitleID);
			 //System.out.println(bean.SetData1(a1));
			/*** Pass the bean to DAO for processing ***/
			 bean = FeedbackFormDAO.selectQuery(bean);

			/*** Convert the result to JSON format and return to the UI ***/
 
			 String json = new Gson().toJson(bean);
			 response.setContentType("application/json");
			 response.setCharacterEncoding("utf-8");
			 response.getWriter().write(json);
			 System.out.println(bean);
			 
		 
		} catch (

		Throwable theException) {
			System.out.println(theException);
		}
	}

}
