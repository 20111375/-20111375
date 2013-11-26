/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 05/11/2013
 * Time: 12:31
 */
package camp;

import db.connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

/**
 * class definition
 * pricing provides methods for calculating cost
 */
public class Pricing {
    final double Fee = 5.00; // hard coded value for flat rate pitch cost per night

    /**
     * class constructor
     */
    public Pricing() {

    }

    /**
     * @return gets fee as a double
     */
    public double getFee() {
        return Fee;
    }

    /**
     * @param fee      accepts a fee value of type double
     * @param discount accepts a discount of type int
     * @param days     accepts a reservation length in days
     * @return a total reservation fee of type double
     */
    public double Total(Double fee, int discount, int days) {
        DecimalFormat doubleFormat = new DecimalFormat("##.##");
        double result = 0.00;
        double lessDiscount = 0.00;
        lessDiscount = (fee * days) / 100.00;
        result = (fee * days) - lessDiscount;
        doubleFormat.format(result);
        return result;
    }

    /**
     * @param StartDate accepts string (format yyy-MM-dd) as a reservation start date
     * @return an int discount value for a reservation
     */
    public int Discount(String StartDate) {
        int discount = 0;
        String SQL = "SELECT app.SEASON.DISCOUNT from app.SEASON\n" +
                "where '" + StartDate + "' >= app.SEASON.STARTDATE and '" + StartDate + "' < app.season.ENDDATE";
        ResultSet resultset = new connection().Discount(SQL);
        try {
            while (resultset.next()) {
                discount = resultset.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return discount;
    }
}