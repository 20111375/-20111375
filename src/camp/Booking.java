/**
 * Created with IntelliJ IDEA.
 * User: andrew heyworth
 * Date: 27/10/2013
 * Time: 21:02
 * Booking class extends the generic Items class
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

    /**
     * Class Con
     */
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
    @Override
    public String toString(){

        return this.getClientID().toString();
    }
}
