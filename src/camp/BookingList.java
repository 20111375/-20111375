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
    protected List<Booking> items;

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
}
