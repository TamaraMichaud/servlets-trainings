// Import required java libraries

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

// Extend HttpServlet class
public class AllFormValues extends HttpServlet {

    private static Logger LOGGER = LoggerFactory.getLogger(AllFormValues.class);

    // Method to handle GET method request.
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set error code and reason.
//        response.sendError(407, "Need authentication!!!" );
//        ^^ to send an error response to the client

        // Set refresh, autoload time as 5 seconds
//        response.setIntHeader("Refresh", 5);   //TODO: how to persist the form infos etc?? this resets everything every 5 seconds!
//        ^^ this is for the clock to update

        LOGGER.info("Doing GET");
        // TODO: find out why this is only ever creating a new session every time...
        // Create a session object if it is already not  created.
        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(2);  // in minutes, default in TomCat is 30 - getMaxIn.... however is returned in seconds...
        // can also be set in the web.xml

        // Get session creation time.
        Date createTime = new Date(session.getCreationTime());

        // Get last access time of this web page.
        Date lastAccessTime = new Date(session.getLastAccessedTime());

        String greeting = "Welcome Back to my java servlets exercise";
        int visitCount = 0;
        String visitCountKey = "visitCount";
        String userIDKey = "userID";
        String userID = "ABCD";

        // Check if this is new comer on your web page.
        if (session.isNew()) {
            greeting = "Welcome to my java servlets exercise";
            session.setAttribute(userIDKey, userID);
        } else {
            visitCount = (Integer) session.getAttribute(visitCountKey);
            visitCount = visitCount + 1;
            userID = (String) session.getAttribute(userIDKey);
        }
        session.setAttribute(visitCountKey, visitCount);


        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String title = "Java Servlet Trainings";

        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        String docHeaderBodyOpen = "<html>\n" +
                "<head><meta charset=\"utf-8\"><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n";

        out.println(docType + docHeaderBodyOpen);

        // show the current time
        out.print("<p>The Time Now Is: " + getCurrentTime()
                + "</p>");


        // show session info
        out.println("<h2>" + title + "</h2>"); // welcome (back)


        out.println("<table border = \"1\" align = \"center\">\n" +
                "<tr bgcolor = \"#949494\">\n" +
                "  <th>Session info</th><th>value</th>" +
                "</tr>\n");

        out.println(
                printRow("id", session.getId()) +
                        printRow("Creation Time", createTime.toString()) +
                        printRow("Time of Last Access", lastAccessTime.toString()) +
                        printRow("User ID", userID) +
                        printRow("Visit Count", String.valueOf(visitCount))
        );

        out.println("</table>");

        // get form POST params
        Enumeration parameterNames = request.getParameterNames();

        // get HHTP Headers
        Enumeration headerNames = request.getHeaderNames();

        printAllValues("param", parameterNames, out, request);

        out.println("<br><hr><h1>Reading All HHTP Headers</h1>");

        printAllValues("header", headerNames, out, request);

        out.println("</body></html>");

        LOGGER.info("Page Loaded");
    }

    // Method to handle POST method request.
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LOGGER.info("Doing POST");
        doGet(request, response);
    }


    private void printAllValues(String valueType, Enumeration paramNames, PrintWriter out, HttpServletRequest request) {

        //TODO: incorporate the Html* classes for this...

        out.println("<table width = \"100%\" border = \"1\" align = \"center\">\n" +
                "<tr bgcolor = \"#949494\">\n" +
                "<th>Param Name</th>" +
                "<th>Param Value(s)</th>\n" +
                "</tr>\n");

        while (paramNames.hasMoreElements()) {

            String paramName = (String) paramNames.nextElement();
            out.print("<tr><td>" + paramName + "</td>\n<td>");

            if (valueType.equals("header")) {

                String headerValue = request.getHeader(paramName);
                out.print(headerValue);
            } else {
                String[] paramValues = request.getParameterValues(paramName);
                // Read single valued data
                if (paramValues.length == 1) {
                    String paramValue = paramValues[0];
                    if (paramValue.length() == 0)
                        out.println("<i>No Value</i>");
                    else
                        out.println(paramValue);
                } else if (paramValues.length > 0) {
                    // Read multiple valued data
                    out.println("<ul>");

                    for (int i = 0; i < paramValues.length; i++) {
                        out.println("<li>" + paramValues[i] + "</li>");
                    }
                    out.println("</ul>");
                }
            }
            out.println("</td></tr>");
        }
        out.println("</table>");
    }

    private String getCurrentTime() {

        Calendar calendar = new GregorianCalendar();
        String am_pm;
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        if (calendar.get(Calendar.AM_PM) == 0)
            am_pm = "AM";
        else
            am_pm = "PM";

        return ((hour < 10) ? "0" : "") + hour + ":" +
                ((minute < 10) ? "0" : "") + minute + ":" +
                ((second < 10) ? "0" : "") + second + " " + am_pm;
    }

    private String printRow(String sessionItem, String itemValue) {
        return "<tr>\n" +
                "  <td>" + sessionItem + "</td>\n" +
                "  <td>" + itemValue + "</td>" +
                "</tr>\n";
    }


}