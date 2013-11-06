/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 05/11/2013
 * Time: 12:31
 */
package camp;
import java.util.Date;

public class Booking extends Items{

    private Integer clientID;
    private Integer pitchID;
    private Date fromDate;
    private Date toDate;
    private Double total;
    private Boolean paid;

    /**
     * Class Con
     */
    public Booking() {

    }

    public Booking(Integer clientID, Integer pitchID, Date fromDate, Date toDate, Double total, Boolean paid) {
        this.clientID = clientID;
        this.pitchID = pitchID;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.total = total;
        this.paid = paid;
    }

    /**
     *
     * @return
     */
    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public Integer getPitchID() {
        return pitchID;
    }

    public void setPitchID(Integer pitchID) {
        this.pitchID = pitchID;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
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

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }
    @Override
    public String toString(){

        return this.getClientID().toString();
    }
}
