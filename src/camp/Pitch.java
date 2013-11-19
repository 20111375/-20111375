/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 05/11/2013
 * Time: 12:31
 */

package camp;

public class Pitch extends Items {

    private String pitchName;
    private Integer pitchType;
    private int[] TypeID;
    private String TypeName[] = {"CARAVAN", "MOTORHOME", "TENT"};
    private int PitchID;
    private double total;

    public int getPitchID() {
        return PitchID;
    }

    public void setPitchID(int pitchID) {
        PitchID = pitchID;
    }

    public Pitch() {

    }

    public Pitch(String pitchName) {
        this.pitchName = pitchName;
    }

    public Pitch(String pitchName, int pitchType, int[] typeID, int pitchID) {
        this.pitchName = pitchName;
        this.pitchType = pitchType;
        this.TypeID = typeID;
        this.PitchID = pitchID;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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

    public int[] getTypeID() {
        return TypeID;
    }

    public String[] getTypeName() {
        for (int i = 0; i < this.TypeID.length; i++) {
            if (this.TypeID[i] != 1) {
                this.TypeName[i] = null;
            }
        }
        return TypeName;
    }

    @Override
    public String toString() {

        return this.getPitchName();
    }
}
