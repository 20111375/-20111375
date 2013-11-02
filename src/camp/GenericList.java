/**
 * Created with IntelliJ IDEA.
 * User: andrewheyworth
 * Date: 28/10/2013
 * Time: 20:35
 * To change this template use File | Settings | File Templates.
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
