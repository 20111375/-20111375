/**
 * 
 */
package camp;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import gui.*;


/**
 * @author Andrew
 */

public class camper{
	public static void main(String[] args) throws Exception {
		try {
            /*
			List<Client> max = new ArrayList<Client>();
			max = new ClientList().Items();
			for(Client C : max){
				System.out.println(C.getFirstName() + " " + C.getSecondName());
			}
			*/
			List<Pitch> mac = new ArrayList<Pitch>();
			mac = new PitchList().Items();
			for(Pitch D : mac){
				System.out.println(D.getPitchName() + " " + D.getPitchType());
			}
            /*
			List<Booking> mat = new ArrayList<Booking>();
			mat = new BookingList().Items();
			for(Booking E : mat){
				System.out.println(E.getClientID() + " " + E.getPitchID() + " " + E.getFrom().toString()  + " " + E.getTo().toString()  + " Total: £" + E.getPrice().toString()  + " Paid:" + E.getPaid().toString());
			}
			if(mat.get(0).getClientID() == max.get(1).getClientID()){
				System.out.println("oh yeh");
			}
            */
		} catch (Exception e) {
			e.printStackTrace();
		}

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        new BookingForm().run();
	}
}
