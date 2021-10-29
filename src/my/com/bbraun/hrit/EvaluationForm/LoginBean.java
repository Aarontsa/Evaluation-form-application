package my.com.bbraun.hrit.EvaluationForm;

public class LoginBean {

		private int Emp_no;
		private String Emp_pass;
		private boolean status;
		
		public  int getEmp_no() {
			return Emp_no;
		}

		public void SetEmp_no(int newEmp_no) {
			Emp_no= newEmp_no;
		}
		
		public  String getEmp_pass() {
			return Emp_pass;
		}

		public void SetEmp_pass(String newEmp_pass) {
			Emp_pass= newEmp_pass;
		}

		public boolean getStatus() {
			return status;
		}

		public void setStatus(boolean newStatus) {
			status = newStatus;
		}

}
