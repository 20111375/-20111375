/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 05/11/2013
 * Time: 12:31
 */

package camp;

/**
 * class definition
 * pitch extends items and holds collections of pitch information
 */
public class Pitch extends Items {
    private String pitchName;
    private Integer pitchType;
    private int[] TypeID;
    private final String[] TypeName = {"CARAVAN", "MOTORHOME", "TENT"};
    private int PitchID;
    private double total;

    //three over loaded constructors

    /**
     * class constructor
     */
    public Pitch() {

    }

    /**
     * class constructor
     *
     * @param pitchName accepts pitch name of type string
     */
    public Pitch(String pitchName) {
        this.pitchName = pitchName;
    }

    /**
     * class constructor
     *
     * @param pitchName string pitch name
     * @param pitchType int pitch type
     * @param typeID    int array pitch type
     * @param pitchID   int pitch id
     */
    public Pitch(String pitchName, int pitchType, int[] typeID, int pitchID) {
        this.pitchName = pitchName;
        this.pitchType = pitchType;
        this.TypeID = typeID;
        this.PitchID = pitchID;
    }

    /**
     * @return gets pitch id of type int
     */
    public int getPitchID() {
        return PitchID;
    }

    /**
     * @param pitchID sets pitch id of type int
     */
    public void setPitchID(int pitchID) {
        PitchID = pitchID;
    }

    /**
     * @return gets total of type double
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total sets total of type double
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return gets pitch type of type integer
     */
    public Integer getPitchType() {
        return pitchType;
    }

    /**
     * @param pitchType sets pitch type of type integer
     */
    public void setPitchType(Integer pitchType) {
        this.pitchType = pitchType;
    }

    /**
     * @return gets pitch name of type string
     */
    public String getPitchName() {
        return pitchName;
    }

    /**
     * @param pitchName pitch name of type string
     */
    public void setPitchName(String pitchName) {
        this.pitchName = pitchName;
    }

    /**
     * @return pitch type id index of type int array
     */
    public int[] getTypeID() {
        return TypeID;
    }

    /**
     * @return string of pitch type name (e.g. CARAVAN, TENT, MOTORHOME)
     */
    public String[] getTypeName() {
        for (int i = 0; i < this.TypeID.length; i++) {
            if (this.TypeID[i] != 1) {
                this.TypeName[i] = null;
            }
        }
        return TypeName;
    }

    /**
     * @return string of pitch name
     */
    @Override
    public String toString() {

        return this.getPitchName();
    }
}
