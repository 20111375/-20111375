package gui;

import com.jcalendar.pane.calendar.CalendarPane;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Andrew on 07/11/13.
 */
public class FormBooking {
    private JComboBox PitchType;
    private JList SearchResultList;
    private JButton SearchButton;
    private JButton FindCustomerButton;
    private JButton NewCustomerButton;
    private JTextPane CustomerDetails;
    private JTextPane PitchDetails;
    private JButton ConfirmButton;
    private JComboBox EndDate;
    private CalendarPane FromDate;
    private JPanel ReservationPane;
    private JButton extendABookingButton;
    private JPanel ExtendBooking;

    public FormBooking() {
        extendABookingButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        ConfirmButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        NewCustomerButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        FindCustomerButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        SearchButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        PitchType.addItemListener(new ItemListener() {
            /**
             * Invoked when an item has been selected or deselected by the user.
             * The code written for this method performs the operations
             * that need to occur when an item is selected (or deselected).
             */
            @Override
            public void itemStateChanged(ItemEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        EndDate.addItemListener(new ItemListener() {
            /**
             * Invoked when an item has been selected or deselected by the user.
             * The code written for this method performs the operations
             * that need to occur when an item is selected (or deselected).
             */
            @Override
            public void itemStateChanged(ItemEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
    }
}
