package gui;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 07/11/13
 * Time: 10:00
 * To change this template use File | Settings | File Templates.
 */
public class callWindow {

    private JPanel MainWindow;

    public void make() {
        JFrame frame = new JFrame("callWindow");
        frame.setContentPane(new callWindow().MainWindow);
        frame.pack();
        frame.setVisible(true);
    }
}
