package html;

import java.util.ArrayList;
import java.util.List;

public class HtmlForm implements HtmlThing {

	private String action;
	private String method;

	private List<String> inputs = new ArrayList<String>();

	public HtmlForm(String action, String method) {
		super();
		this.action = action;
		this.method = method;
	}

	public void addInput(String label, String name) {
		inputs.add(label + ": <input type = \"text\" name = \"" + name + "\"><br/>");
	}

	public void addInput(String label, String name, String value) {
		inputs.add(label + ": <input type = \"text\" name = \"" + name + "\" value = \"" + value + "\"><br/>");
	}

	public void addHiddenInput(String name, String value) {
		inputs.add("<input type = \"hidden\" name = \"" + name + "\" value = \"" + value + "\"><br/>");
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("<form action = \"" + action + "\" method = \"" + method + "\">\n");

		for (String string : inputs) {
			sb.append(string+"\n");
		}

		sb.append("<input type = \"submit\" value = \"Submit\" />\n");
		
		sb.append("</form>\n");

		return sb.toString();
	}

}
