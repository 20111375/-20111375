/**
 * Created with IntelliJ IDEA.
 * User: andrewheyworth
 * Date: 28/10/2013
 * Time: 20:35
 * To change this template use File | Settings | File Templates.
 */
package camp;

import db.*;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class BookingList extends GenericList<Booking> {
    protected List<Booking> items;

    public List<Booking> Items() throws Exception {
        if (items == null) {
            items = new ArrayList<Booking>();
            try {
                String SQL = "SELECT * FROM Booking";
                ResultSet resultset = new connection().connect(SQL);
                while (resultset.next()) {
                    items.add(new Booking(resultset.getInt(1), resultset.getInt(2), resultset.getDate("FROMDATE"), resultset.getDate("TODATE"), resultset.getDouble("TOTAL"), resultset.getBoolean("PAID")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return items;
    }
}