/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 05/11/2013
 * Time: 12:31
 */
package camp;
import java.awt.*;
import java.util.List;
import gui.*;


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
                    new FormBooking().run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

	}
}
