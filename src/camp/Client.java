/**
 * Created with IntelliJ IDEA.
 * User: andrewheyworth
 * Date: 27/10/2013
 * Time: 20:23
 * To change this template use File | Settings | File Templates.
 */
package camp;

public class Client extends Items{

    private String firstName;
    private String secondName;
    private Integer clientID;
    private String carRegistration;
    private String address;
    private String postcode;
    private Integer telephoneNumber;

    public Client() {

    }

    public Client(String firstName, String secondName, Integer clientID, String carRegistration, String address, String postcode, Integer telephoneNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.clientID = clientID;
        this.carRegistration = carRegistration;
        this.address = address;
        this.postcode = postcode;
        this.telephoneNumber = telephoneNumber;
    }


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

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Integer getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(Integer telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

}
