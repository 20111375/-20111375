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

public class PitchList extends GenericList<Pitch> {
    protected List<Pitch> items;

    /**
     * @return an array list of items
     * @throws Exception
     */
    public List<Pitch> Items() throws Exception {
        if (items == null) {
            items = new ArrayList<Pitch>();
            try {
                String SQL = "SELECT * FROM PITCH join PITCHTYPE on app.pitch.pitchtypeid  = app.PITCHTYPE.pitchtypeid";
                ResultSet resultset = new connection().connect(SQL);
                while (resultset.next()) {
                    int[] type = {resultset.getInt("CARAVAN"), resultset.getInt("MOTORHOME"), resultset.getInt("TENT")};
                    items.add(new Pitch(resultset.getString("PITCHNAME"), resultset.getInt("PITCHTYPEID"), type, resultset.getInt("PITCHID")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return items;
    }

    /**
     * @param Start string (format yyyy-MM-dd) start date
     * @param End   string (format yyyy-MM-dd) end date
     * @param Name  string of pitch type name (e.g. CARAVAN, TENT, MOTORHOME)
     * @return collection of items
     * @throws Exception algorithm uses is Martin Fowler's range pattern
     */
    public List<Pitch> Items(String Start, String End, String Name) throws Exception {
        if (items == null) {
            items = new ArrayList<Pitch>();
            try {
                String SQL = "select app.PITCH.PITCHID, app.PITCH.PITCHNAME, app.pitchtype.PITCHTYPEID, app.PITCHTYPE.TENT,\n" +
                        "app.PITCHTYPE.CARAVAN, app.PITCHTYPE.MOTORHOME from app.PITCH join PITCHTYPE on app.pitch.pitchtypeid  = app.PITCHTYPE.pitchtypeid\n" +
                        "and (" + Name + " = TRUE)\n" +
                        "where not exists(\n" +
                        "    select * from app.BOOKING\n" +
                        "    where app.BOOKING.PITCHID = app.PITCH.PITCHID\n" +
                        "          and ('" + Start + "' < App.booking.TODATE and APP.booking.FROMDATE < '" + End + "')\n" +
                        ")";
                ResultSet resultset = new connection().connect(SQL);
                while (resultset.next()) {
                    int[] type = {resultset.getInt("CARAVAN"), resultset.getInt("MOTORHOME"), resultset.getInt("TENT")};
                    items.add(new Pitch(resultset.getString("PITCHNAME"), resultset.getInt("PITCHTYPEID"), type, resultset.getInt("PITCHID")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return items;
    }

    /**
     * @param Start string (format yyyy-MM-dd) start date
     * @param End   string (format yyyy-MM-dd) end date
     * @return collection of items
     * @throws Exception
     */
    public List<Pitch> Items(String Start, String End) throws Exception {
        if (items == null) {
            items = new ArrayList<Pitch>();
            try {
                String SQL = "select app.PITCH.PITCHID, app.PITCH.PITCHNAME, app.pitchtype.PITCHTYPEID, app.PITCHTYPE.TENT,\n" +
                        "app.PITCHTYPE.CARAVAN, app.PITCHTYPE.MOTORHOME from app.PITCH join PITCHTYPE on app.pitch.pitchtypeid  = app.PITCHTYPE.pitchtypeid\n" +
                        "where not exists(\n" +
                        "    select * from app.BOOKING\n" +
                        "    where app.BOOKING.PITCHID = app.PITCH.PITCHID\n" +
                        "          and ('" + Start + "' < App.booking.TODATE and APP.booking.FROMDATE < '" + End + "')\n" +
                        ")";
                ResultSet resultset = new connection().connect(SQL);
                while (resultset.next()) {
                    int[] type = {resultset.getInt("CARAVAN"), resultset.getInt("MOTORHOME"), resultset.getInt("TENT")};
                    items.add(new Pitch(resultset.getString("PITCHNAME"), resultset.getInt("PITCHTYPEID"), type, resultset.getInt("PITCHID")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return items;
    }

    /**
     * @param Name string of pitch type name (e.g. CARAVAN, TENT, MOTORHOME)
     * @return collection of items
     * @throws Exception
     */
    public List<Pitch> Items(String Name) throws Exception {
        if (items == null) {
            items = new ArrayList<Pitch>();
            try {
                String SQL = "SELECT * FROM PITCH,PITCHTYPE WHERE PITCHNAME = '" + Name + "'";
                ResultSet resultset = new connection().connect(SQL);
                while (resultset.next()) {
                    int[] type = {resultset.getInt("CARAVAN"), resultset.getInt("MOTORHOME"), resultset.getInt("TENT")};
                    items.add(new Pitch(resultset.getString("PITCHNAME"), resultset.getInt("PITCHTYPEID"), type, resultset.getInt("PITCHID")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return items;
    }

    /**
     * @param Start string (format yyyy-MM-dd) start date
     * @param End   string (format yyyy-MM-dd) end date
     * @param pitch int of pitch type name (e.g. 1 = CARAVAN, 2 = MOTORHOME, 3 = TENT)
     * @return collection of items
     * @throws Exception
     */
    public List<Pitch> Items(String Start, String End, int pitch) throws Exception {
        if (items == null) {
            items = new ArrayList<Pitch>();
            try {
                String SQL = "select app.PITCH.PITCHID, app.PITCH.PITCHNAME, app.pitchtype.PITCHTYPEID, app.PITCHTYPE.TENT,\n" +
                        "app.PITCHTYPE.CARAVAN, app.PITCHTYPE.MOTORHOME from app.PITCH join PITCHTYPE on app.pitch.pitchtypeid  = app.PITCHTYPE.pitchtypeid\n" +
                        "and (" + pitch + " = app.PITCH.PITCHID)\n" +
                        "where not exists(\n" +
                        "    select * from app.BOOKING\n" +
                        "    where app.BOOKING.PITCHID = app.PITCH.PITCHID\n" +
                        "          and ('" + Start + "' < App.booking.TODATE and APP.booking.FROMDATE < '" + End + "')\n" +
                        ")";
                ResultSet resultset = new connection().connect(SQL);
                while (resultset.next()) {
                    int[] type = {resultset.getInt("CARAVAN"), resultset.getInt("MOTORHOME"), resultset.getInt("TENT")};
                    items.add(new Pitch(resultset.getString("PITCHNAME"), resultset.getInt("PITCHTYPEID"), type, resultset.getInt("PITCHID")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return items;
    }
}