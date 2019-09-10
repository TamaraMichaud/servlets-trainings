package servlet;

import data.DbOracle;
import data.User;
import data.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.sql.ResultSet;

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

		//TEST ONLY - does db-connection work:  yes
		DbOracle oracleDb = new DbOracle();
		ResultSet queryResult = oracleDb.executeQuery("select sysdate from dual");

		try {

			while (queryResult.next())
			//    System.out.println(rs.getString(1)+"  "+rs.getInt(2)+"  "+rs.getString(3));
			{
				System.out.println("SQL RESULT for SYSDATE: " + queryResult.getString(1));
			}
			oracleDb.close();

		} catch (Exception e) {
			throw new RuntimeException("Database Query Error!", e);
		}


		//TEST ONLY - can we access my library.... NOP£ :'(
//		PasswordUtils fml = new PasswordUtils


	}

}
