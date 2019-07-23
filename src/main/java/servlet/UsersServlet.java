package servlet;

import data.User;
import data.Users;
import html.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class UsersServlet extends HttpServlet {

	private String message;

	public void init() throws ServletException {
		// Do required initialization
		message = "Nothing happens...";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET /users");
		String action = request.getParameter("action");

		if (action != null && "delete".equals(action)) {
			doDelete(request, response);
		} else {
	
			// Set response content type
			response.setContentType("text/html");
	
			PrintWriter out = response.getWriter();
			out.print(getUsersHtmlPage());
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST /users");

		String id = request.getParameter("id");

		if (id != null) {
			doPut(request, response);
		} else {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			
			Users users = (Users) this.getServletContext().getAttribute(ProjectConstants.USERS_DB);
			User user = new User(firstName, lastName);
			
			users.put(user.getId(), user);

			PrintWriter out = response.getWriter();
			out.print(getUsersHtmlPage());
		}
	}

	public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PUT /users");

		String id = request.getParameter("id");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		System.out.println("id="+id);
		System.out.println("firstName="+firstName);
		System.out.println("lastName="+lastName);
		Users users = (Users) this.getServletContext().getAttribute(ProjectConstants.USERS_DB);
		User user = users.get(id);
		user.setFirstName(firstName);
		user.setLastName(lastName);

		PrintWriter out = response.getWriter();
		out.print(getUsersHtmlPage());
	}

	public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DELETE /users");

		String id = request.getParameter("id");
		
		System.out.println("id="+id);

		Users users = (Users) this.getServletContext().getAttribute(ProjectConstants.USERS_DB);
		User user = users.get(id);

		if (user != null) {
			users.remove(id);
		}
		
		PrintWriter out = response.getWriter();
		out.print(getUsersHtmlPage());
	}

	private String getUsersHtmlPage() {
		HtmlPage htmlPage = new HtmlPage("List of Users");
		HtmlTable htmlTable = new HtmlTable();

		Users users = (Users) this.getServletContext().getAttribute(ProjectConstants.USERS_DB);

		System.out.println("there are " + users.size() + " users");

		for (User user : users.values()) {
			HtmlTableRow row = new HtmlTableRow();
			HtmlTableCell id = new HtmlTableCell(user.getId());
			HtmlTableCell firstName = new HtmlTableCell(user.getFirstName(), "/updateuser?id=" + user.getId());
			HtmlTableCell lastName = new HtmlTableCell(user.getLastName());
			HtmlTableCell deleteLink = new HtmlTableCell("<a href=\"/users?action=delete&id="+user.getId()+"\">delete<a/>");

			List<HtmlTableCell> cells = new ArrayList<HtmlTableCell>();
			cells.add(id);
			cells.add(firstName);
			cells.add(lastName);
			cells.add(deleteLink);

			row.addCells(cells);
			htmlTable.addRow(row);
		}

		htmlPage.addTable(htmlTable);

		HtmlElement htmlElement = new HtmlElement("<a href=\"newuser\"> Add New User </a>");
		htmlPage.addElement(htmlElement);

		return htmlPage.toString();
	}
	
	
	public void destroy() {
		// do nothing.
	}
}
