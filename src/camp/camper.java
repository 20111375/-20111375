/**
 * 
 */
package camp;
import java.awt.*;
import java.util.List;
import gui.*;


/**
 * @author Andrew
 */

public class camper{
	public static void main(String[] args) throws Exception {
		try {

            List<Pitch> mac = new PitchList().Items();
			for(Pitch D : mac){
				System.out.println(D.getPitchName() + " " + D.getPitchType());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new BookingForm().run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

	}
}
