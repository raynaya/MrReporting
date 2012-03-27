/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DatabaseConnection;

/**
 *
 * @author shamik
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
       static String username = "scott", password = "tiger";
    private static String Query ;

    public Connection createConnection() {

        Connection connection = null;
        try {
        // Load the JDBC driver
                        Class.forName("oracle.jdbc.driver.OracleDriver");

           // Class.forName("com.mysql.jdbc.Driver");
        // Create a connection to the database
           // connection = DriverManager.getConnection("jdbc:mysql:http://mysql-shamik.jelastic.servint.net/test2", username, password);
            connection = DriverManager.getConnection("jdbc:oracle:thin:@ayan_pc.:1521:ORACLE",username,password);
       

        } catch (SQLException ex) {
        } catch (ClassNotFoundException e) {}

        return connection;
    }

    public void runSqlStatement(String a){
        try {
            Statement statement = createConnection().createStatement();
            Query=a;
          //  statement.executeQuery(createTableQuery);
         statement.execute(Query);

        } catch (SQLException ex) {
        }
    }
}

