/**
 * Created with IntelliJ IDEA.
 * User: andrewheyworth
 * Date: 27/10/2013
 * Time: 21:02
 * To change this template use File | Settings | File Templates.
 */
package camp;
import java.util.Date;

public class Booking extends Items{

    private Integer clientID;
    private Integer pitchID;
    private Date from;
    private Date to;
    private Double price;
    private Boolean paid;

    public Booking() {

    }

    public Booking(Integer clientID, Integer pitchID, Date from, Date to, Double price, Boolean paid) {
        this.clientID = clientID;
        this.pitchID = pitchID;
        this.from = from;
        this.to = to;
        this.price = price;
        this.paid = paid;
    }

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

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }
}
