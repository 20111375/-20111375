/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 05/11/2013
 * Time: 12:31
 */
package camp;
import db.connection;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
This query returns only the pitches with are booked on a given date:
 select app.PITCH.PITCHID from app.PITCH
  where exists(
    select * from app.BOOKING
    where app.BOOKING.PITCHID = app.PITCH.PITCHID
   and '2013-01-01' BETWEEN App.booking.FROMDATE and APP.booking.TODATE
  );

This query returns all pitches which are not booked on a given day:
select app.PITCH.PITCHID from app.PITCH
  where not exists(
    select * from app.BOOKING
    where app.BOOKING.PITCHID = app.PITCH.PITCHID
   and '2013-01-01' BETWEEN App.booking.FROMDATE and APP.booking.TODATE
  );

This query returns available pitches of a specific type:
select app.PITCH.PITCHID from app.PITCH
where not exists(
    select * from app.BOOKING
    where (app.BOOKING.PITCHID = app.PITCH.PITCHID) and (app.PITCH.PITCHTYPEID = 1)
          and '2013-01-01' BETWEEN App.booking.FROMDATE and APP.booking.TODATE
);

This query returns booked customers who haven't paid:
SELECT * FROM APP.BOOKING
  WHERE
  APP.BOOKING.PAID = FALSE;

This query returns a list of car registrations:
select * from APP.CUSTOMER
where exists(
    select * FROM app.BOOKING, app.PITCH
    where app.BOOKING.PITCHID = app.PITCH.PITCHID
          and '2013-01-01' BETWEEN App.booking.FROMDATE and APP.booking.TODATE
)
ORDER BY APP.CUSTOMER.CARREGISTRATION  DESC;



This tests date range (StartDate1 <= EndDate2) and (StartDate2 <= EndDate1)
 */
public class Search<E> extends GenericList{
    protected List<E> results;

    public Search() {

    }
    public List<Booking> booked(String requestedDate) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(requestedDate);
        if (items == null) {
            items = new ArrayList<Booking>();
            try {
                String SQL = "SELECT * FROM Booking";
                ResultSet resultset = new connection().connect(SQL);
                while (resultset.next()) {
                    if ((resultset.getDate("FROMDATE").before(date)) && (resultset.getDate("TODATE").after(date) || resultset.getDate("TODATE").equals(date))) {
                        items.add(new Booking(resultset.getInt(1), resultset.getInt(2), resultset.getDate("FROMDATE"), resultset.getDate("TODATE"), resultset.getDouble("TOTAL"), resultset.getBoolean("PAID")));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return items;
    }
}