/**
 * Created with IntelliJ IDEA.
 * User: andrewheyworth
 * Date: 27/10/2013
 * Time: 21:22
 * To change this template use File | Settings | File Templates.
 */

package camp;

public class Pitch extends Items{

    private String pitchName;
    private Integer pitchType;

    public Pitch() {

    }
    
    public Pitch(String pitchName) {
        this.pitchName = pitchName;
    }

    public Pitch(String pitchName, int pitchType) {
        this.pitchName = pitchName;
        this.pitchType = pitchType;
    }

    public Integer getPitchType() {
        return pitchType;
    }

    public void setPitchType(Integer pitchType) {
        this.pitchType = pitchType;
    }

    public String getPitchName() {
        return pitchName;
    }

    public void setPitchName(String pitchName) {
        this.pitchName = pitchName;
    }
    @Override
    public String toString(){

        return this.getPitchName();
    }
}
