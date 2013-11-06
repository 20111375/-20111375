/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 05/11/2013
 * Time: 12:31
 */
package camp;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import db.connection;

public class ClientList  extends GenericList<Client>{
	protected List<Client> items;
	public List<Client> Items() throws Exception {
		if(items == null){
			items = new ArrayList<Client>();
			try {
				String SQL = "SELECT * FROM Customer";
				ResultSet resultset = new connection().connect(SQL);
				while(resultset.next()){
					items.add(new Client(resultset.getString("FIRSTNAME"),resultset.getString("SECONDNAME"), resultset.getInt(1), resultset.getString("CARREGISTRATION"), resultset.getString("ADDRESS"), resultset.getString("POSTCODE"), null,null));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return items;
	}
}