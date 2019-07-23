package html;

import java.util.ArrayList;
import java.util.List;

public class HtmlTable implements HtmlThing {

	private List<HtmlTableRow> rows = new ArrayList<HtmlTableRow>();

	public void addRow(HtmlTableRow row) {
		rows.add(row);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("<table border=1 >\n");
		
		for (HtmlTableRow row : rows) {
			sb.append(row.toString());
		}
		
		sb.append("</table>\n");
		return sb.toString();
	}

}
