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

/**
 * Created by Andrew on 08/11/13.
 */
public class ReportDailyPitchList {
    private JButton printButton;

    public ReportDailyPitchList() {
        printButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
    }

    public JList getPitchSearch() {
        return PitchSearch;
    }

    public void setPitchSearch(JList pitchSearch) {
        PitchSearch = pitchSearch;
    }

    public JButton getPrintButton() {
        return printButton;
    }

    public void setPrintButton(JButton printButton) {
        this.printButton = printButton;
    }

    private JList PitchSearch;

}
