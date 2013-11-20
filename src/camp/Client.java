/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 05/11/2013
 * Time: 12:31
 */
package camp;

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
     * @param clientID
     * @param firstName
     * @param secondName
     * @param carRegistration
     * @param address
     * @param postcode
     * @param county
     * @param Delete
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
     * @return a string of the customers first name
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public String getCarRegistration() {
        return carRegistration;
    }

    public void setCarRegistration(String carRegistration) {
        this.carRegistration = carRegistration;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Boolean getDelete() {
        return Delete;
    }

    public void setDelete(Boolean delete) {
        Delete = delete;
    }

    public Client() {

    }

    @Override
    public String toString() {

        return this.getFirstName();
    }
}
