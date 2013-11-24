/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 05/11/2013
 * Time: 12:31
 */
package camp;

import gui.MenuCampsite;

import java.awt.*;

public class camper {
    /**
     * @param args
     * @throws Exception
     * @description main function to execute application
     */
    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MenuCampsite().run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
