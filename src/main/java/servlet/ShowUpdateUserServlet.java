package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ShowUpdateUserServlet extends HttpServlet {

	public void init() throws ServletException {
		// Do required initialization...
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Set response content type
		response.setContentType("text/html");

		String contextPath = request.getContextPath();
		request.setAttribute("userId", request.getParameter("id"));
		request.getRequestDispatcher(contextPath + "/../jsp/UpdateUser.jsp").forward(request, response);
		//TODO: ^^ understand what is happening here!
	}

	public void destroy() {
		// do nothing.
	}
}
