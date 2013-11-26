/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 23/11/2013
 * Time: 09:51
 * Project: OOP Campsite
 */
package camp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * datemaker class
 */
public class DateMaker {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * @param day   accepts an integer of days
     * @param Start accepts a string (formatted tp yyyy-MM-dd) representing a start date
     * @return a string (formatted tp yyyy-MM-dd)
     */
    public String DateMaker(int day, String Start) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(dateFormat.parse(Start));
            calendar.add(Calendar.DATE, day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFormat.format(calendar.getTime());
    }
}
