/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 05/11/2013
 * Time: 12:31
 */
package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuCampsite {
    private JPanel MainPanel;
    private JButton bookingsButton;
    private JButton pitchesButton;
    private JButton reportsButton;

    public MenuCampsite() {
        bookingsButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                new FormBooking().run();
            }
        });
    }

    public void run() {
        JFrame frame = new JFrame("MenuCampsite");
        frame.setResizable(false);
        frame.setContentPane(new MenuCampsite().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
