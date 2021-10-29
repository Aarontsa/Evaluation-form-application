package my.com.bbraun.hrit.EvaluationForm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import my.com.bbraun.hrit.EvaluationForm.CoursesAddDAO;
import my.com.bbraun.hrit.EvaluationForm.CoursesAddBean;
import my.com.bbraun.hrit.EvaluationForm.Sanitizer;

import com.google.gson.Gson;

public class CoursesAddServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public CoursesAddServlet() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			/*** Get variable that sent from UI ***/
			 //HttpSession request = request.getSession();
			 //String a1 = request.getParameter("a1").toString();
			 int Admin_no = Integer.parseInt(request.getParameter("AddEmployee_no"));
			 
			 String Courses_title = request.getParameter("CreateCoursesTitle");
			 String Courses_venue = request.getParameter("CreateCoursesVenue");
			 String Courses_timestart = request.getParameter("CreateCoursesStartTime");
			 String Courses_timeend = request.getParameter("CreateCoursesEndTime");
			 String Courses_date = request.getParameter("CreateCoursesDate");
			 String Courses_trainer = request.getParameter("CreateCoursesTrainer");
			 //System.out.println(d2);
			 
			/*** Sanitize special characters - String variables only ***/
			 String clean_Courses_title = new Sanitizer().sanitize(Courses_title);
			 String clean_Courses_venue = new Sanitizer().sanitize(Courses_venue);
			 String clean_Courses_timestart = new Sanitizer().sanitize(Courses_timestart);
			 String clean_Courses_timeend = new Sanitizer().sanitize(Courses_timeend);
			 String clean_Courses_date = new Sanitizer().sanitize(Courses_date);
			 String clean_Courses_trainer = new Sanitizer().sanitize(Courses_trainer);
//			 System.out.println(clean_d2);
			
			 /*** Create a bean to temporary hold the data ***/
			 CoursesAddBean bean = new CoursesAddBean();
			 bean.SetCourses_title(clean_Courses_title);
			 bean.SetCourses_venue(clean_Courses_venue);
			 bean.SetCourses_timestart(clean_Courses_timestart);
			 bean.SetCourses_timeend(clean_Courses_timeend);
			 bean.SetCourses_date(clean_Courses_date);
			 bean.SetCourses_trainer(clean_Courses_trainer);
			 bean.SetAdmin_no(Admin_no);
//			 bean.SetData14(clean_courseTitleID);
			 //System.out.println(bean.SetData1(a1));
			/*** Pass the bean to DAO for processing ***/
			 bean = CoursesAddDAO.selectQuery(bean);

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
