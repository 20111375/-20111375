/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 05/11/2013
 * Time: 12:31
 */
package camp;

import db.connection;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookingList extends GenericList<Booking> {
    protected List<Booking> items;// define a list object to pass items objects into

    /**
     * @return a items list containing item objects (of type list)
     * @throws Exception
     */
    public List<Booking> Items() throws Exception {
        if (items == null) {
            items = new ArrayList<Booking>();
            try {
                String SQL = "SELECT * FROM Booking";
                ResultSet resultset = new connection().connect(SQL);
                while (resultset.next()) {
                    items.add(new Booking(resultset.getInt(1), resultset.getInt(2), resultset.getString("FROMDATE"), resultset.getString("TODATE"), resultset.getDouble("TOTAL"), resultset.getBoolean("PAID")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return items;
    }

    public List<Booking> Items(int CustID) throws Exception {
        if (items == null) {
            items = new ArrayList<Booking>();
            try {
                String SQL = "select  * from booking\n" +
                        "where customerid = " + CustID + " and\n" +
                        "CURRENT_DATE between fromdate and todate";
                ResultSet resultset = new connection().connect(SQL);
                while (resultset.next()) {
                    items.add(new Booking(resultset.getInt(1), resultset.getInt(2), resultset.getString("FROMDATE"), resultset.getString("TODATE"), resultset.getDouble("TOTAL"), resultset.getBoolean("PAID")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return items;
    }

    public static final List<Booking> customerList() {
        List<Booking> bookinglist = null;
        try {
            bookinglist = new BookingList().Items();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookinglist;
    }

    public List<Booking> WhoHasntPaid() throws Exception {
        if (items == null) {
            items = new ArrayList<Booking>();
            try {
                String SQL = "SELECT * FROM APP.BOOKING\n" +
                        "WHERE\n" +
                        "  APP.BOOKING.PAID = FALSE\n" +
                        "ORDER BY CURRENT_DATE  DESC";
                ResultSet resultset = new connection().connect(SQL);
                while (resultset.next()) {
                    items.add(new Booking(resultset.getInt(1), resultset.getInt(2), resultset.getString("FROMDATE"), resultset.getString("TODATE"), resultset.getDouble("TOTAL"), resultset.getBoolean("PAID")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return items;
    }
}
