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
     * Class Con
     */
    public Booking() {

    }

    public Booking(Integer clientID, Integer pitchID, String fromDate, String toDate, Double total, Boolean paid) {
        this.clientID = clientID;
        this.pitchID = pitchID;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.total = total;
        this.paid = paid;
    }

    /**
     * @return
     */
    public int getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public int getPitchID() {
        return pitchID;
    }

    public void setPitchID(Integer pitchID) {
        this.pitchID = pitchID;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {

        return String.valueOf(this.getClientID());
    }

    public void insertNewBooking() {
        String SQL = "insert into app.booking (CUSTOMERID,PITCHID, FROMDATE, TODATE, PAID, TOTAL) values\n" +
                "(" + this.getClientID() + "," + this.getPitchID() + ",'" + this.getFromDate() + "','" + this.getToDate() + "'," + this.getPaid() + "," + this.getTotal() + ")";
        new connection().ExecuteCustomerInsert(SQL);

    }
}
