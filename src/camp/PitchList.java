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

public class PitchList  extends GenericList<Pitch>{
	protected List<Pitch> items;
	public List<Pitch> Items() throws Exception {
		if(items == null){
			items = new ArrayList<Pitch>();
			try {
				String SQL = "SELECT * FROM PITCH join PITCHTYPE on app.pitch.pitchtypeid  = app.PITCHTYPE.pitchtypeid";
				ResultSet resultset = new connection().connect(SQL);
				while(resultset.next()){
                    int[] type = {resultset.getInt("CARAVAN"),resultset.getInt("MOTORHOME"),resultset.getInt("TENT")};
					items.add(new Pitch(resultset.getString("PITCHNAME"),resultset.getInt("PITCHTYPEID"), type));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return items;
	}

    public List<Pitch> Items(String Start, String End, String Name) throws Exception {
        if(items == null){
            items = new ArrayList<Pitch>();
            try {
                String SQL = "select app.PITCH.PITCHID, app.PITCH.PITCHNAME, app.pitchtype.PITCHTYPEID, app.PITCHTYPE.TENT,\n" +
                        "app.PITCHTYPE.CARAVAN, app.PITCHTYPE.MOTORHOME from app.PITCH join PITCHTYPE on app.pitch.pitchtypeid  = app.PITCHTYPE.pitchtypeid\n" +
                        "and ("+ Name +" = TRUE)\n" +
                        "where not exists(\n" +
                        "    select * from app.BOOKING\n" +
                        "    where app.BOOKING.PITCHID = app.PITCH.PITCHID\n" +
                        "          and '"+Start+"' <= App.booking.FROMDATE and '"+End+"' <= APP.booking.TODATE\n" +
                        ")";
                ResultSet resultset = new connection().connect(SQL);
                while(resultset.next()){
                    int[] type = {resultset.getInt("CARAVAN"),resultset.getInt("MOTORHOME"),resultset.getInt("TENT")};
                    items.add(new Pitch(resultset.getString("PITCHNAME"),resultset.getInt("PITCHTYPEID"), type));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return items;
    }
}