/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 05/11/2013
 * Time: 12:31
 */
package camp;

import db.connection;

/**
 * booking object which extends a generic items list
 */
public class Booking extends Items {
    private int clientID;
    private int pitchID;
    private String fromDate;
    private String toDate;
    private Double total;
    private Boolean paid;

    /**
     * class constructor
     */
    public Booking() {

    }

    /**
     * @param clientID integer of customer id
     * @param pitchID  integer of pitch id
     * @param fromDate string of start date
     * @param toDate   string of end date
     * @param total    double of reservation cost
     * @param paid     boolean of paid status
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
     * @param clientID an integer used to uniquely id a customer
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
     * @param pitchID an integer used to uniquely id a campsite pitch
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
     * @param fromDate a string (formatted to yyyy-MM-dd) to identify the start of a reservation
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
     * @param toDate a string (formatted to yyyy-MM-dd) to identify the end of a reservation
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
     * @param total a double of the total reservation cost
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
     * @param paid a boolean of whether the reservation has been paid for
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
     * pass sql statement to insert a new booking into the database
     */
    public void insertNewBooking() {
        String SQL = "insert into app.booking (CUSTOMERID,PITCHID, FROMDATE, TODATE, PAID, TOTAL) values\n" +
                "(" + this.getClientID() + "," + this.getPitchID() + ",'" + this.getFromDate() + "','" + this.getToDate() + "'," + this.getPaid() + "," + this.getTotal() + ")";
        new connection().ExecuteCustomerInsert(SQL);
    }

    /**
     * pass sql statement to insert a new payment into the database
     */
    public void insertNewPayment() {
        String SQL = "INSERT INTO APP.PAYMENT (CUSTOMERID, AMOUNT, RECEIVED)\n" +
                "VALUES (" + getClientID() + ", " + getTotal() + ",CURRENT_DATE )";
        new connection().ExecuteCustomerInsert(SQL);

    }

    public void deleteBooking() {
        String SQL = "delete from booking\n" +
                "where customerid = " + this.getClientID() + " and pitchid = " + this.getPitchID() + " and fromdate = '" + this.getFromDate() + "' and todate = '" + this.getToDate() + "'";
        new connection().ExecuteCustomerInsert(SQL);

    }
}



