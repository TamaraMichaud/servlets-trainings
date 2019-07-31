package html;

import java.util.ArrayList;
import java.util.List;

public class HtmlPage {
    private String title;
    private List<HtmlThing> things = new ArrayList<>();

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

        String htmlHeaderString =
             "<html>\n" +
                  "<head>\n" +
                       "<meta charset='utf-8'>" +
                       "<meta name='viewport' content='width=device-width, " +
                       "initial-scale=1, shrink-to-fit=no'>\n" +
                       "<title>" + title + "</title>\n" +
                       "<link rel='stylesheet' " +
                       "href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' " +
                       "integrity='sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T' " +
                       "crossorigin='anonymous'>\n" +
                       "<link rel=\"stylesheet\" href=\"styles.css\">\n" +
                       "<link href=\"js/jquery-ui-1.12.1/jquery-ui.min.css\" rel=\"stylesheet\">" +
                     "<link href=\"bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">" +
        "</head>\n";

        String htmlTitleString = "<p class=\"h1 text-center\">" + title + "</p>\n";

        sb.append(htmlHeaderString);
        sb.append("<body bgcolor = \"#f0f0f0\">\n");
//        sb.append("<div class=\"container\">");
        sb.append("<div id=\"main-page\" class=\"container-fluid col-md-8\">");
        sb.append(htmlTitleString);

        for (HtmlThing htmlThing : things) {
            sb.append(htmlThing.toString());
        }

        sb.append("</div>\n");

        sb.append(new HtmlFooter().toString());

//        sb.append("</div>");

        sb.append("\n<script src=\"//code.jquery.com/jquery-3.4.1.min.js\"></script>");
        sb.append("<script src=\"js/jquery-3.4.1.js\">window.jQuery || document.write('<script src=\"js/jquery-3.4.1.js\"><\\/script>');</script>");
        sb.append("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>");
        sb.append("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>");

        sb.append("<script src=\"bootstrap/js/bootstrap.bundle.min.js\"></script>");
        sb.append("<script src=\"js/script.js\"></script>");

        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }

}
