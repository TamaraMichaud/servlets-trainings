package html;

public class HtmlFooter {

    private String footerString;

    public HtmlFooter() {

        footerString = "<footer id=\"footer\" class=\"footer\">" +
                "<div class=\"container\">" +
                "<span class=\"text-muted\"><a href=\"pageinfo\">Page Information</a></span>" +
                "</div></footer>";
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(footerString);
        return sb.toString();
    }
}
