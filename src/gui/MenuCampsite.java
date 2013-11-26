/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 05/11/2013
 * Time: 12:31
 */
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * class definition
 * gui class for the initial menu screen
 */
public class MenuCampsite {
    private JPanel MainPanel;
    private JButton bookingsButton;
    private JButton reportsButton;

    /**
     * class constructor
     */
    public MenuCampsite() {

        /**
         *book event listener
         */
        bookingsButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e action event
             */
            @Override
            public void actionPerformed(ActionEvent e) {
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
        });

        /**
         *book event listener
         */
        reportsButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            new Reports().run();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    /**
     * initilise in the parent window
     */
    public void run() {
        JFrame frame = new JFrame("Campsite System");
        frame.setResizable(false);
        frame.setContentPane(new MenuCampsite().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
