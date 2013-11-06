/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 05/11/2013
 * Time: 12:31
 */

package camp;

public class Pitch extends Items{

    private String pitchName;
    private Integer pitchType;
    private String[] TypeID = {"CARAVAN", "TENT", "MOTORHOME"};

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
