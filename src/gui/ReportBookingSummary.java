package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Andrew on 07/11/13.
 */
public class ReportBookingSummary {
    private JTextPane Surname;
    private JTextPane County;
    private JTextPane PostCode;
    private JTextPane CarReg;
    private JTextPane CustomerID;
    private JTextPane PitchID;
    private JTextPane StartDate;
    private JTextPane EndDate;
    private JTextPane Paid;
    private JTextPane Cost;
    private JButton ConfirmBooking;
    private JTextPane BookingSummary;
    private JButton emailButton;
    private JButton printButton;
    private JPanel Summary;
    private JTextPane Address;
    private JTextPane Forename;

    public ReportBookingSummary() {
        emailButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
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
}
