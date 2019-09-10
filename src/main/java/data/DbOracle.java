package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbOracle {

    private static Connection con;
    private static Statement stmt;

    public DbOracle() {

        String oracle_jdbc = "oracle.jdbc.driver.OracleDriver";
        String username = "data";
        String password = "dsadm";

        String url = "jdbc:oracle:thin:@ora-test.emv2.com:1521/PODTEST";


        try {
            //step1 load the driver class
            Class.forName(oracle_jdbc);
            //step2 create  the connection object
            con = DriverManager.getConnection(url, username, password);
            //step3 create the statement object
            stmt = con.createStatement();
        } catch (Exception e) {
            throw new RuntimeException("Database Connection Error!", e);
        }

    }

    /**
     * Run a query of any size and return the results for inspection
     *
     * @param sqlQuery the full sql query; no trailing semi-colon required
     * @return the ResultSet of columns and rows
     */
    public ResultSet executeQuery(String sqlQuery) {
        try {
            //      LOGGER.info("Executing SQL Query...");
            return stmt.executeQuery(sqlQuery);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Database Query Error!", e);
        }
    }

    /**
     * Close the database connection
     */
    public void close() {
        try {
            con.close();
//            LOGGER.info("Closed Oracle DB Connection");
        } catch (Exception e) {
            throw new RuntimeException("Error closing DB_CONNECTION!", e);
        }
    }


}
