/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 05/11/2013
 * Time: 12:31
 */
package camp;

import java.util.ArrayList;
import java.util.List;

/**
 * class definition
 *
 * @param <E> a generic list collection
 */
public class GenericList<E> {
    List<E> items;

    /**
     * @return a collection of item objects
     * @throws Exception
     */
    public List<E> Items() throws Exception {
        if (items == null) {
            items = new ArrayList<>();
        }
        return items;
    }
}