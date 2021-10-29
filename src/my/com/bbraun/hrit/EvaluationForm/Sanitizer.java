package my.com.bbraun.hrit.EvaluationForm;

public class Sanitizer {

	public String sanitize(String rawinput) {
		if (rawinput == null) {
			return null;
		}

		String tmp = rawinput;
		// Clean up line format chars
		tmp = tmp.replaceAll("\n", " ").replaceAll("\r", " ").replaceAll("\t", " ");
		// Remove SGML markup
		tmp = tmp.replaceAll("<[^>]*>", " ");
		// Remove any remaining meta characters &;`'\|"*?~<>^()[]{}$ and null
		// (00h)
		tmp = tmp.replaceAll("[;\\`\\\\|\"*?~<>^\\(\\)\\[\\]\\{\\}\\$%\\x00]", "");
		// Clean up whitespace
		tmp = tmp.replaceAll("\\s+", " ").trim();
		return tmp;
	}

}
