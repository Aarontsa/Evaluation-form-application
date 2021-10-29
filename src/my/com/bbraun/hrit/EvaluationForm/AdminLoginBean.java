package my.com.bbraun.hrit.EvaluationForm;

public class AdminLoginBean {

		private int Admin_no;
		private String Admin_pass;
		private boolean status;
		
		public  int getAdmin_no() {
			return Admin_no;
		}

		public void SetAdmin_no(int newAdmin_no) {
			Admin_no= newAdmin_no;
		}
		
		public  String getAdmin_pass() {
			return Admin_pass;
		}

		public void SetAdmin_pass(String newAdmin_pass) {
			Admin_pass= newAdmin_pass;
		}

		public boolean getStatus() {
			return status;
		}

		public void setStatus(boolean newStatus) {
			status = newStatus;
		}

}
