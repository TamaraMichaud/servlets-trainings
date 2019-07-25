package html;

public class HtmlTableCell {

	private String cellText;
	private String link;

	public HtmlTableCell(String cellText) {
		this.cellText = cellText;
	}

	public HtmlTableCell(String cellText, String link) {
		this(cellText);
		this.link = link;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		if (this.link == null) {
			sb.append(cellText);
		} else {
			sb.append("<a class=\"btn button-info\" href=\"" + link + "\">" + cellText + "<a/>");
		}

		return sb.toString();
	}

}
