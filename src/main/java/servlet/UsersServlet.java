package servlet;

import data.User;
import data.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class UsersServlet extends HttpServlet {


	public void init() throws ServletException {
		// Do required initialization

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET /users");
		String contextPath = request.getContextPath();
//		^^ this is for your main directory; all my links here currently use relative referencing but this will get ugly if i had more packages
		String action = request.getParameter("action");

		if ("delete".equals(action)) {
			doDelete(request, response);
		} else {
	
			// Set response content type
			response.setContentType("text/html");
	
			response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
			response.setHeader("location", contextPath + "/jsp/Users.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST /users");

        String contextPath = request.getContextPath();

		String id = request.getParameter("id");

		if (id != null) {
			doPut(request, response);
		} else {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			
			Users users = (Users) this.getServletContext().getAttribute(ProjectConstants.USERS_DB);
			User user = new User(firstName, lastName);
			
			users.put(user.getId(), user);

            response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
            response.setHeader("location", contextPath + "/jsp/Users.jsp");
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

		response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
		response.setHeader("location", request.getContextPath() + "/jsp/Users.jsp");
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

		response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
		response.setHeader("location", request.getContextPath() + "/jsp/Users.jsp");
	}

	public void destroy() {
		// do nothing.
	}
}
