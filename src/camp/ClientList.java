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

public class ClientList extends GenericList<Client> {
    protected List<Client> items;

    public List<Client> Items() throws Exception {
        if (items == null) {
            items = new ArrayList<Client>();
            try {
                String SQL = "SELECT * FROM Customer";
                ResultSet resultset = new connection().connect(SQL);
                while (resultset.next()) {
                    items.add(new Client(resultset.getInt("CUSTOMERID"), resultset.getString("FIRSTNAME"), resultset.getString("SECONDNAME"), resultset.getString("CARREGISTRATION"), resultset.getString("ADDRESS"), resultset.getString("POSTCODE"), resultset.getString("COUNTY"), resultset.getBoolean("DELETE")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return items;
    }

    public void insertNewCustomer(Client C) {

        String SQL = "INSERT INTO  APP.CUSTOMER (firstname,secondname,address,county,postcode,carregistration)\n" +
                "values ('" + C.getFirstName() + "','" + C.getSecondName() + "','" + C.getAddress() + "','" + C.getCounty() + "','" + C.getPostcode() + "', '" + C.getCarRegistration() + "')";
        new connection().ExecuteCustomerUpdate(SQL);
    }

    public void deleteCustomer(Client C) {

        String SQL = "ALTER  APP.CUSTOMER (delte)\n" +
                "values ('" + C.getDelete() + "')";
        new connection().ExecuteCustomerUpdate(SQL);
    }

    public static final List<Client> customerList() {
        List<Client> customerlist = null;
        try {
            customerlist = new ClientList().Items();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerlist;
    }
}
