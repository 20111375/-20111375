package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: andrewheyworth
 * Date: 02/11/2013
 * Time: 11:01
 * To change this template use File | Settings | File Templates.
 */
public class BookingForm {
    private JPanel Panel;
    private JButton pitchListButton;
    private JList list1;

    public BookingForm() {

    }

    public void run() {
        JFrame frame = new JFrame("BookingForm");
        frame.setContentPane(new BookingForm().Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
