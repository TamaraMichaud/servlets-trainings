package servlet;

import data.User;
import data.Users;
import html.HtmlForm;
import html.HtmlPage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ShowUpdateUserServlet extends HttpServlet {

	private String message;

	public void init() throws ServletException {
		// Do required initialization
		message = "Nothing happens...";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Set response content type
		response.setContentType("text/html");
		Users users = (Users) this.getServletContext().getAttribute(ProjectConstants.USERS_DB);
		
		String userId = request.getParameter("id");
		User user = users.get(userId);
		
		HtmlPage htmlPage = new HtmlPage("Update User");
		HtmlForm htmlForm = new HtmlForm("/users", "POST");
		
		htmlForm.addHiddenInput("id", user.getId());
		htmlForm.addInput("First Name", "firstName", user.getFirstName());
		htmlForm.addInput("Last Name", "lastName", user.getLastName());
		
		htmlPage.addForm(htmlForm);

		PrintWriter out = response.getWriter();
		out.print(htmlPage.toString());
	}
	
	public void destroy() {
		// do nothing.
	}
}
