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

public class Pricing {
    final double Fee = 5.00;

    public Pricing() {

    }

    public double getFee() {
        return Fee;
    }

    public double Total(Double fee, int discount, int days) {
        double result = 0.00;
        double lessDiscount = 0.00;
        lessDiscount = (fee * days) / 100.00;
        return result = (fee * days) - lessDiscount;
    }

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