package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbMySql {

        private static Connection con;
        private static Statement stmt;

        public DbMySql() {

            String oracle_jdbc = "com.mysql.cj.jdbc.Driver";
            String username = "root";
            String password = "";
            String db_schema = "db_clientaddressbook";

            String url = "jdbc:mysql://localhost:3306/" + db_schema + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

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


        public String countUsers() {
            String dbRowCount = "";
            String sqlQuery = "select count(*) from clients";
            try {
                ResultSet rs = stmt.executeQuery(sqlQuery);
                while (rs.next())
                //    System.out.println(rs.getString(1)+"  "+rs.getInt(2)+"  "+rs.getString(3));
                {
                    dbRowCount = rs.getString(1);
                }

                //step5 close the connection object
                con.close();

            } catch (Exception e) {
                throw new RuntimeException("Database Query Error!", e);
            }
            return dbRowCount;
        }


    }

