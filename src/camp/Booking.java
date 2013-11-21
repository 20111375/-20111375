/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 05/11/2013
 * Time: 12:31
 */
package camp;

import db.connection;

public class Booking extends Items {

    private int clientID;
    private int pitchID;
    private String fromDate;
    private String toDate;
    private Double total;
    private Boolean paid;

    /**
     * @description class constructor
     */
    public Booking() {

    }

    /**
     * @param clientID
     * @param pitchID
     * @param fromDate
     * @param toDate
     * @param total
     * @param paid
     */
    public Booking(Integer clientID, Integer pitchID, String fromDate, String toDate, Double total, Boolean paid) {
        this.clientID = clientID;
        this.pitchID = pitchID;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.total = total;
        this.paid = paid;
    }

    /**
     * @return an int of the customer ID
     */
    public int getClientID() {
        return clientID;
    }

    /**
     * @param clientID
     */
    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    /**
     * @return an int of the pitch ID
     */
    public int getPitchID() {
        return pitchID;
    }

    /**
     * @param pitchID
     */
    public void setPitchID(Integer pitchID) {
        this.pitchID = pitchID;
    }

    /**
     * @return the string from date of a booking
     */
    public String getFromDate() {
        return fromDate;
    }

    /**
     * @param fromDate
     */
    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    /**
     * @return a string of the to date of a booking
     */
    public String getToDate() {
        return toDate;
    }

    /**
     * @param toDate
     */
    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    /**
     * @return total booking amount is returned
     */
    public Double getTotal() {
        return total;
    }

    /**
     * @param total
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * @return a boolean value for the paid status of a booking
     */
    public Boolean getPaid() {
        return paid;
    }

    /**
     * @param paid
     */
    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    /**
     * @return a string value of the customer ID
     */
    @Override
    public String toString() {

        return String.valueOf(this.getClientID());
    }

    /**
     * @description pass sql statement to insert a new booking into the database
     */
    public void insertNewBooking() {
        String SQL = "insert into app.booking (CUSTOMERID,PITCHID, FROMDATE, TODATE, PAID, TOTAL) values\n" +
                "(" + this.getClientID() + "," + this.getPitchID() + ",'" + this.getFromDate() + "','" + this.getToDate() + "'," + this.getPaid() + "," + this.getTotal() + ")";
        new connection().ExecuteCustomerInsert(SQL);

    }

    public void insertNewPayment() {
        String SQL = "INSERT INTO APP.PAYMENT (CUSTOMERID, AMOUNT, RECEIVED)\n" +
                "VALUES (" + getClientID() + ", " + getTotal() + ",CURRENT_DATE )";
        new connection().ExecuteCustomerInsert(SQL);

    }
}
