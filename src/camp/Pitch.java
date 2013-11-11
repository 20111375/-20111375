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

    public Pitch() {

    }

    public Pitch(String pitchName) {
        this.pitchName = pitchName;
    }

    public Pitch(String pitchName, int pitchType, int[] typeID) {
        this.pitchName = pitchName;
        this.pitchType = pitchType;
        this.TypeID = typeID;
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
        for(int i = 0; i < this.TypeID.length; i++){
            if(this.TypeID[i] != 1){
                this.TypeName[i] = " ";
            }
        }
      return TypeName;
    }

    @Override
    public String toString() {

        return this.getPitchName();
    }

}
