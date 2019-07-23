package html;

public class HtmlElement implements HtmlThing {

	private String elementText;

	public HtmlElement(String elementText) {
		super();
		this.elementText = elementText;
	};
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(elementText);

		return sb.toString();
	}
}
