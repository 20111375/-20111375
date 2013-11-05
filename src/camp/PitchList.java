/**
 * Created with IntelliJ IDEA.
 * User: andrewheyworth
 * Date: 28/10/2013
 * Time: 20:35
 * To change this template use File | Settings | File Templates.
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
				String SQL = "SELECT * FROM Pitch";
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