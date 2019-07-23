import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//TODO: find out why this doesn't appear to do anything...
// https://www.tutorialspoint.com/servlets/servlets-writing-filters.htm
// https://www.journaldev.com/1933/java-servlet-filter-example-tutorial


// Implements Filter class
public class LogFilter implements Filter {

    private static Logger LOGGER = LoggerFactory.getLogger(LogFilter.class);

    public void init(FilterConfig config) throws ServletException {

        // Get init parameter
        String testParam = config.getInitParameter("test-param");
        // ^^ TODO: wtf is this!?

        //Print the init parameter
        LOGGER.info("Test Param: " + testParam);
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws java.io.IOException, ServletException {

        // Get the IP address of client machine.
        String ipAddress = request.getRemoteAddr();

        // Log the IP address and current timestamp.
        LOGGER.info("IP " + ipAddress + ", Time " + new Date().toString());

        // Pass request back down the filter chain
        chain.doFilter(request, response);
    }

    public void destroy() {
        /* Called before the Filter instance is removed from service by the web container*/
    }
}