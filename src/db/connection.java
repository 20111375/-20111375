/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 05/11/2013
 * Time: 12:31
 */
package db;

import java.sql.*;

public class connection {
    protected ResultSet resultset = null;
    private String PathToDB = "jdbc:derby:../~20111375/database";

    public connection() {
    }

    public String getPathToDB() {
        return PathToDB;
    }

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
