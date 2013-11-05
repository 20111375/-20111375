/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 05/11/2013
 * Time: 12:31
 */
package camp;
import java.util.ArrayList;
import java.util.List;

public class GenericList<E> {
	protected List<E> items;
	public List<E> Items() throws Exception {
		if(items == null){
			items = new ArrayList<E>();	
		}
		return items;
	}
}
