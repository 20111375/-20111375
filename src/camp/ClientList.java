/**
 * Created with IntelliJ IDEA.
 * User: andrewheyworth
 * Date: 28/10/2013
 * Time: 20:35
 * To change this template use File | Settings | File Templates.
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
					items.add(new Client(resultset.getString("FIRSTNAME"),resultset.getString("SECONDNAME"), resultset.getInt(1), resultset.getString("CARREGISTRATION"), resultset.getString("ADDRESS"), resultset.getString("POSTCODE"), null));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return items;
	}
}