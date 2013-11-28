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
    double fee = 7.95;

    /**
     * class constructor
     */
    public Pricing() {

    }

    /**
     * @return gets fee as a double
     */
    public double getFee() {
        return decimalFormat(this.fee);
    }

    /**
     * @param fee       accepts a fee value of type double
     * @param days      accepts a reservation length in days
     * @param startDate accepts a string of the reservation start date
     * @return a total reservation fee of type double
     */
    public double Total(Double fee, int days, String startDate) {
        double result;
        double lessDiscount;
        lessDiscount = (fee * days) * Discount(startDate);
        result = (fee * days) - lessDiscount;
        return decimalFormat(result);
    }

    /**
     * @param StartDate accepts string (format yyy-MM-dd) as a reservation start date
     * @return an int discount value for a reservation
     */
    public double Discount(String StartDate) {
        double discount = 0.0;
        String SQL = "SELECT app.SEASON.DISCOUNT from app.SEASON\n" +
                "where '" + StartDate + "' >= app.SEASON.STARTDATE and '" + StartDate + "' < app.season.ENDDATE";
        ResultSet resultset = new connection().Discount(SQL);
        try {
            while (resultset.next()) {
                discount = resultset.getDouble("DISCOUNT");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return decimalFormat(discount);
    }

    /**
     * @param figure of type double
     * @return a formatted decimal currency number
     */
    private double decimalFormat(double figure) {
        DecimalFormat figureChange = new DecimalFormat("#.##");
        return Double.parseDouble(figureChange.format(figure));
    }
}