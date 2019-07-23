package html;

import java.util.ArrayList;
import java.util.List;

public class HtmlTableRow {

	private List<HtmlTableCell> cells = new ArrayList<HtmlTableCell>();

	public void addCell(HtmlTableCell cell) {
		cells.add(cell);
	}

	public void addCells(List<HtmlTableCell> cells) {
		for (HtmlTableCell cell : cells) {
			addCell(cell);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("<tr>\n");

		for (HtmlTableCell cell : cells) {
			sb.append("<td>" + cell.toString() + "<td/>\n");
		}

		sb.append("<tr/>\n");
		return sb.toString();
	}

}
