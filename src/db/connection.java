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
 */
public class connection {
    protected ResultSet resultset = null;
    private String PathToDB = "jdbc:derby:../~20111375/database";// set this to the relative path of the project

    /**
     * class constructor
     * connection provides methods for database manipulation
     */
    public connection() {
    }

    /**
     * @return gets the path to the database as a string
     */
    public String getPathToDB() {
        return PathToDB;
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
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
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
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
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
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param SQLString
     * @return a result set relating to the sql string
     */
    public ResultSet Discount(String SQLString) {

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            Connection connect = DriverManager.getConnection(getPathToDB());
            PreparedStatement statement = connect.prepareStatement(SQLString);
            resultset = statement.executeQuery();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultset;
    }
}
