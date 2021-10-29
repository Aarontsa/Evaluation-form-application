package my.com.bbraun.hrit.EvaluationForm;

public class CoursesAddBean {
	//form//
	private String Courses_timestart;
	private String Courses_timeend;
	private String Courses_date;
	private String Courses_title;
	private String Courses_venue;
	private String Courses_trainer;
	private int Admin_no;
//	private String DateCreateFeedback;
//	private int Emp_no_create;
	private boolean status;
	
	public  String getCourses_timestart() {
		return Courses_timestart;
	}

	public void SetCourses_timestart(String newCourses_timestart) {
		Courses_timestart= newCourses_timestart;
	}
	
	public  String getCourses_timeend() {
		return Courses_timeend;
	}

	public void SetCourses_timeend(String newCourses_timeend) {
		Courses_timeend= newCourses_timeend;
	}

	public  String getCourses_date() {
		return Courses_date;
	}

	public void SetCourses_date(String newCourses_date) {
		Courses_date= newCourses_date;
	}

	public  String getCourses_title() {
		return Courses_title;
	}

	public void SetCourses_title(String newCourses_title) {
		Courses_title= newCourses_title;
	}

	public  String getCourses_venue() {
		return Courses_venue;
	}

	public void SetCourses_venue(String newCourses_venue) {
		Courses_venue= newCourses_venue;
	}

	public  String getCourses_trainer() {
		return Courses_trainer;
	}

	public void SetCourses_trainer(String newCourses_trainer) {
		Courses_trainer= newCourses_trainer;
	}

	public  int getAdmin_no() {
		return Admin_no;
	}

	public void SetAdmin_no(int newAdmin_no) {
		Admin_no= newAdmin_no;
	}
	
//	public  int getEmp_no_create() {
//		return Emp_no_create;
//	}
//
//	public void SetEmp_no_create(int newEmp_no_create) {
//		Emp_no_create= newEmp_no_create;
//	}
	
	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean newStatus) {
		status = newStatus;
	}

}

