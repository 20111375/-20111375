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

/**
 * class definition extends generic list
 * collection of customers, extending the generic class GenericList
 */
public class ClientList extends GenericList<Client> {
    private List<Client> items;

    /**
     * class constructor
     *
     * @return a collection of type items
     * @throws Exception
     */
    public List<Client> Items() throws Exception {
        if (items == null) {
            items = new ArrayList<>();
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

    /**
     * @return a collection of customers with an index of id and car registration
     * @throws Exception
     */
    public List<Client> CarList() throws Exception {
        if (items == null) {
            items = new ArrayList<>();
            try {
                String SQL = "select customer.CARREGISTRATION, customer.customerid \n" +
                        "from customer join booking on booking.CUSTOMERID = customer.CUSTOMERID\n" +
                        "  where  CURRENT_DATE between booking.FROMDATE and booking.TODATE";
                ResultSet resultset = new connection().connect(SQL);
                while (resultset.next()) {
                    items.add(new Client(resultset.getInt("CUSTOMERID"), resultset.getString("CARREGISTRATION")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return items;
    }

    /**
     * @param C customer object
     */
    public void insertNewCustomer(Client C) {
        String SQL = "INSERT INTO  APP.CUSTOMER (firstname,secondname,address,county,postcode,carregistration)\n" +
                "values ('" + C.getFirstName() + "','" + C.getSecondName() + "','" + C.getAddress() + "','" + C.getCounty() + "','" + C.getPostcode() + "', '" + C.getCarRegistration() + "')";
        new connection().ExecuteCustomerUpdate(SQL);
    }

    /**
     * @param C customer object
     */
    public void deleteCustomer(Client C) {
        String SQL = "UPDATE APP.CUSTOMER SET \"DELETE\" = true \n" +
                "WHERE App.CUSTOMER.CUSTOMERID = " + C.getClientID() + "";
        new connection().ExecuteCustomerUpdate(SQL);
    }

    /**
     * @param C customer object
     */
    public void editCustomer(Client C) {
        String SQL = "update app.CUSTOMER SET\n" +
                "FIRSTNAME='" + C.getFirstName() + "',\n" +
                "SECONDNAME='" + C.getSecondName() + "',\n" +
                "CARREGISTRATION='" + C.getCarRegistration() + "',\n" +
                "ADDRESS='" + C.getAddress() + "',\n" +
                "COUNTY='" + C.getCounty() + "',\n" +
                "POSTCODE='" + C.getPostcode() + "'\n" +
                "WHERE CUSTOMERID=" + C.getClientID() + "";
        new connection().ExecuteCustomerUpdate(SQL);
    }

    /**
     * @return a collection of customers
     */
    public static List<Client> customerList() {
        List<Client> customerlist = null;
        try {
            customerlist = new ClientList().Items();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerlist;
    }
}
