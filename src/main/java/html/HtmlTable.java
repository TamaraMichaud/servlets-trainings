package html;

import java.util.ArrayList;
import java.util.List;

public class HtmlTable implements HtmlThing {

	private List<HtmlTableRow> rows = new ArrayList<>();

	public void addRow(HtmlTableRow row) {
		rows.add(row);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("<table class=\"table table-striped table-hover\" >\n");
		
		for (HtmlTableRow row : rows) {
			sb.append(row.toString());
		}
		
		sb.append("</table>\n");
		return sb.toString();
	}

}
