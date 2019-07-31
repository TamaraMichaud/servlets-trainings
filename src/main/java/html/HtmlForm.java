package html;

import java.util.ArrayList;
import java.util.List;

public class HtmlForm implements HtmlThing {

    private String action;
    private String method;

    private List<String> inputs = new ArrayList<>();

    public HtmlForm(String action, String method) {
        super();
        this.action = action;
        this.method = method;
    }

    public void addInput(String label, String name) {

        String labelTag = "<label for=\"" + name + "\">" + label + "</label>";
        String inputTag = "<input type=\"text\" class=\"form-control input-md\" id=\"" + name
                + "\" name=\"" + name + "\" required>";

        inputs.add(labelTag + "\n" + inputTag + "<br>\n");
    }

    public void addInput(String label, String name, String value) {

        String labelTag = "<label for=\"" + name + "\">" + label + "</label>";
        String inputTag = "<input type=\"text\" class=\"form-control input-md\" id=\"" + name
                + "\" name=\"" + name + "\" value=\"" + value + "\" required>";

        inputs.add(labelTag + "\n" + inputTag + "<br>\n");
    }

    public void addHiddenInput(String name, String value) {
        inputs.add("<input type = \"hidden\" name = \"" + name + "\" value = \"" + value + "\"><br/>");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("<form action = \"%s\" method = \"%s\">\n", action, method));
        sb.append("<div class=\"form-group\">");

        for (String string : inputs) {
            sb.append(string);
            sb.append("\n");
        }

        sb.append("<input class=\"btn btn-primary\" type = \"submit\" value = \"Submit\" />\n");
        sb.append("<a class=\"btn btn-dark\" style=\"color:white\" href=\"users\" >Cancel</a>\n");
        sb.append("</div>\n");
        sb.append("</form>\n");

        return sb.toString();
    }

}
