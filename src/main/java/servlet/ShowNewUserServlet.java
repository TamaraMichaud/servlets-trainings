package servlet;

import html.HtmlForm;
import html.HtmlPage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ShowNewUserServlet extends HttpServlet {

	private String message;

	public void init() throws ServletException {
		// Do required initialization
		message = "Nothing happens...";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Set response content type
		response.setContentType("text/html");

		HtmlPage htmlPage = new HtmlPage("New User");
		HtmlForm htmlForm = new HtmlForm("users", "POST");
		
		htmlForm.addInput("First Name", "firstName");
		htmlForm.addInput("Last Name", "lastName");
		
		htmlPage.addForm(htmlForm);

		PrintWriter out = response.getWriter();
		out.print(htmlPage.toString());
	}
	
	public void destroy() {
		// do nothing.
	}
}
