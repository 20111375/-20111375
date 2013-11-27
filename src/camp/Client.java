/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 05/11/2013
 * Time: 12:31
 */
package camp;

/**
 * class definitions
 * client extends items and holds collections of customer information
 */
public class Client extends Items {

    private String firstName;
    private String secondName;
    private Integer clientID;
    private String carRegistration;
    private String address;
    private String county;
    private String postcode;
    private Boolean Delete;

    /**
     * @param clientID        integer to uniquely id a customer
     * @param firstName       string of customer first name
     * @param secondName      string of customer second name
     * @param carRegistration string of customer car registration
     * @param address         string of customers address
     * @param postcode        string of customers post code
     * @param county          string of customers county address
     * @param Delete          boolean it id if customer has been deleted
     */
    public Client(int clientID, String firstName, String secondName, String carRegistration, String address, String postcode, String county, Boolean Delete) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.clientID = clientID;
        this.carRegistration = carRegistration;
        this.address = address;
        this.county = county;
        this.postcode = postcode;
        this.Delete = Delete;
    }

    /**
     * @param clientID        int client id
     * @param carRegistration string car registration
     */
    public Client(int clientID, String carRegistration) {
        this.clientID = clientID;
        this.carRegistration = carRegistration;
    }

    /**
     * @return a string of the customers first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName sets customer first name, accepts a string value
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return gets customers second name
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * @param secondName sets customer second name, accepts a string value
     */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    /**
     * @return gets customers id, returns an integer
     */
    public Integer getClientID() {
        return clientID;
    }

    /**
     * @param clientID sets customers id, accepts an integer value
     */
    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    /**
     * @return gets a customers car registration, returns a string
     */
    public String getCarRegistration() {
        return carRegistration;
    }

    /**
     * @param carRegistration sets a customers car reg, accepts a string
     */
    public void setCarRegistration(String carRegistration) {
        this.carRegistration = carRegistration;
    }

    /**
     * @return gets customer address, returns a string
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address sets customer address, accepts a string
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return gets customer county, returns a string
     */
    public String getCounty() {
        return county;
    }

    /**
     * @param county sets customer count, accepts a string
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * @return gets a customer post code, returns a string
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * @param postcode sets a customers post code, accepts a string
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * @return gets a customers status, returns a boolean
     */
    public Boolean getDelete() {
        return Delete;
    }

    /**
     * @param delete sets a customers status, accepts a boolean
     */
    public void setDelete(Boolean delete) {
        Delete = delete;
    }

    /**
     * empty class constructor
     */
    public Client() {

    }

    /**
     * @return overrides toString()
     */
    @Override
    public String toString() {

        return this.getFirstName();
    }
}
