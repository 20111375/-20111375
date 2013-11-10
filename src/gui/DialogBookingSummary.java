package gui;

import javax.swing.*;
import java.awt.event.*;

public class DialogBookingSummary extends JDialog {
    private JPanel BookingSummary;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel Buttons;
    private JPanel ButtonPanel;
    private JPanel Details;
    private JTextArea BookingForeName;
    private JTextArea BookingSurname;

    public JTextArea getBookingForeName() {
        return BookingForeName;
    }

    public void setBookingForeName(JTextArea bookingForeName) {
        BookingForeName = bookingForeName;
    }

    public JTextArea getBookingSurname() {
        return BookingSurname;
    }

    public void setBookingSurname(JTextArea bookingSurname) {
        BookingSurname = bookingSurname;
    }

    public JTextArea getBookingCustomerID() {
        return BookingCustomerID;
    }

    public void setBookingCustomerID(JTextArea bookingCustomerID) {
        BookingCustomerID = bookingCustomerID;
    }

    public JTextArea getBookingCarReg() {
        return BookingCarReg;
    }

    public void setBookingCarReg(JTextArea bookingCarReg) {
        BookingCarReg = bookingCarReg;
    }

    public JTextArea getBookingCounty() {
        return BookingCounty;
    }

    public void setBookingCounty(JTextArea bookingCounty) {
        BookingCounty = bookingCounty;
    }

    public JTextArea getBookingPostCode() {
        return BookingPostCode;
    }

    public void setBookingPostCode(JTextArea bookingPostCode) {
        BookingPostCode = bookingPostCode;
    }

    public JTextArea getBookingPitchName() {
        return BookingPitchName;
    }

    public void setBookingPitchName(JTextArea bookingPitchName) {
        BookingPitchName = bookingPitchName;
    }

    public JTextArea getBookingPitchType() {
        return BookingPitchType;
    }

    public void setBookingPitchType(JTextArea bookingPitchType) {
        BookingPitchType = bookingPitchType;
    }

    public JTextArea getBookingStartDate() {
        return BookingStartDate;
    }

    public void setBookingStartDate(JTextArea bookingStartDate) {
        BookingStartDate = bookingStartDate;
    }

    public JTextArea getBookingEndDate() {
        return BookingEndDate;
    }

    public void setBookingEndDate(JTextArea bookingEndDate) {
        BookingEndDate = bookingEndDate;
    }

    public JTextArea getBookingCostTotal() {
        return BookingCostTotal;
    }

    public void setBookingCostTotal(JTextArea bookingCostTotal) {
        BookingCostTotal = bookingCostTotal;
    }

    public JTextArea getBookingAddress() {
        return BookingAddress;
    }

    public void setBookingAddress(JTextArea bookingAddress) {
        BookingAddress = bookingAddress;
    }

    private JTextArea BookingCustomerID;
    private JTextArea BookingCarReg;
    private JTextArea BookingCounty;
    private JTextArea BookingPostCode;
    private JTextArea BookingPitchName;
    private JTextArea BookingPitchType;
    private JTextArea BookingStartDate;
    private JTextArea BookingEndDate;
    private JTextArea BookingCostTotal;
    private JTextArea BookingAddress;
    private JCheckBox email;
    private JPanel Checkboxes;
    private JCheckBox PrintIt;
    private JLabel ForeName;
    private JLabel SurName;
    private JLabel CustomerID;
    private JLabel CarReg;
    private JLabel Address;
    private JLabel County;
    private JLabel PostCode;
    private JLabel PitchName;
    private JLabel PitchID;
    private JLabel StartDate;
    private JLabel Cost;

    public DialogBookingSummary() {
        setContentPane(BookingSummary);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        BookingSummary.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        PrintIt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        email.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
    }

    private void onOK() {
// add your code here
        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public void textReturned(){
         System.out.println("you did it");
    }

    public void make() {
        DialogBookingSummary dialog = new DialogBookingSummary();
        dialog.pack();
        dialog.setVisible(true);
        //System.exit(0);
    }

}
