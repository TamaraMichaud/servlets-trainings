package html;

import java.util.ArrayList;
import java.util.List;

public class HtmlPage {
	private String title;
	private List<HtmlThing> things = new ArrayList<HtmlThing>();
	
	public HtmlPage(String title) {
		this.title = title;
	}

	public void addTable(HtmlTable table) {
		things.add(table);
	}
	
	public void addForm(HtmlForm form) {
		things.add(form);
	}

	public void addElement(HtmlElement element) {
		things.add(element);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("<html>\n");
		sb.append("<head>\n");
		sb.append("<title>" + title + "</title>\n");
		sb.append("<link rel=\"stylesheet\" href=\"styles.css\">\n");
		sb.append("</head>\n");
		sb.append("<body bgcolor = \"#f0f0f0\">\n");
		sb.append("<h1 align = \"center\">" + title + "</h1>\n");
		
		for (HtmlThing htmlThing : things) {
			sb.append(htmlThing.toString());
		}

		sb.append("<p>Yo!</p>");
		
		sb.append("</body>");
		sb.append("</html>");

		return sb.toString();
	}

}
