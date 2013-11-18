package camp;

/**
 * Created by Andrew on 18/11/13.
 */

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
        result = fee * days / 100 / discount;
        return result;
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
