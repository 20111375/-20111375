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
				String SQL = "SELECT * FROM PITCH, PITCHTYPE";
				ResultSet resultset = new connection().connect(SQL);
				while(resultset.next()){
					items.add(new Pitch(resultset.getString("PITCHNAME"),resultset.getInt("PITCHTYPEID")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return items;
	}
}