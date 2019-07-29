package servlet;

import data.User;
import data.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class StartupServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		super.init();

		System.out.println("Adding Users in-memory DB");

		Users users = new Users();
		this.getServletContext().setAttribute(ProjectConstants.USERS_DB, users);

		User fred = new User("Fred", "Bloggs");
		User bill = new User("Bill", "Bloggs");
		
		users.put(fred.getId(), fred);
		users.put(bill.getId(), bill);

		System.out.println("Added Users in-memory DB - there are " + users.size() + " users");
	}

}
