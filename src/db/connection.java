/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 05/11/2013
 * Time: 12:31
 */
package db;

import java.sql.*;

/**
 * class definition
 * connection provides methods for database manipulation
 */
public class connection {
    private ResultSet resultset = null;

    /**
     * class constructor
     */
    public connection() {
    }

    /**
     * @return gets the path to the database as a string
     */
    String getPathToDB() {
        String pathToDB = "jdbc:derby:../~20111375/database";
        return pathToDB;
    }

    /**
     * @param SQLString accepts string of sql statement (do not include semi colon)
     * @return an sql result set collection
     *         returns an execute query collection
     */
    public ResultSet connect(String SQLString) {

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            Connection connect = DriverManager.getConnection(getPathToDB());
            PreparedStatement statement = connect.prepareStatement(SQLString);
            resultset = statement.executeQuery();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return resultset;
    }

    /**
     * @param SQL accepts string of sql statement (do not include semi colon)
     *            executes an sql update for customer update
     */
    public void ExecuteCustomerUpdate(String SQL) {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            Connection connect = DriverManager.getConnection(getPathToDB());
            PreparedStatement statement = connect.prepareStatement(SQL);
            statement.executeUpdate();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param SQL accepts string of sql statement (do not include semi colon)
     *            executes an sql update for customer insert
     */
    public void ExecuteCustomerInsert(String SQL) {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            Connection connect = DriverManager.getConnection(getPathToDB());
            PreparedStatement statement = connect.prepareStatement(SQL);
            statement.executeUpdate();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param SQLString sql statement string
     * @return a result set relating to the sql string
     */
    public ResultSet Discount(String SQLString) {

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            Connection connect = DriverManager.getConnection(getPathToDB());
            PreparedStatement statement = connect.prepareStatement(SQLString);
            resultset = statement.executeQuery();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return resultset;
    }
}
