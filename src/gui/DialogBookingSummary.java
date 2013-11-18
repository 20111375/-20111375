package gui;

import camp.Client;
import camp.Pitch;

import javax.swing.*;
import java.awt.event.*;

public class DialogBookingSummary extends JDialog {
    private JPanel BookingSummary;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel Buttons;
    private JPanel ButtonPanel;
    private JPanel Details;
    public JTextArea BookingForeName;
    private JTextArea BookingSurname;

    public JTextArea getBookingForeName() {
        return BookingForeName;
    }

    public void setBookingForeName(String bookingForeName) {
        BookingForeName.append(bookingForeName);
    }

    public JTextArea getBookingSurname() {
        return BookingSurname;
    }

    public void setBookingSurname(String bookingSurname) {
        BookingSurname.setText(bookingSurname);
    }

    public JTextArea getBookingCustomerID() {
        return BookingCustomerID;
    }

    public void setBookingCustomerID(Integer bookingCustomerID) {
        BookingCustomerID.setText(bookingCustomerID.toString());
    }

    public JTextArea getBookingCarReg() {
        return BookingCarReg;
    }

    public void setBookingCarReg(String bookingCarReg) {
        BookingCarReg.setText(bookingCarReg);
    }

    public JTextArea getBookingCounty() {
        return BookingCounty;
    }

    public void setBookingCounty(String bookingCounty) {
        BookingCounty.setText(bookingCounty);
    }

    public JTextArea getBookingPostCode() {
        return BookingPostCode;
    }

    public void setBookingPostCode(String bookingPostCode) {
        BookingPostCode.setText(bookingPostCode);
    }

    public JTextArea getBookingPitchName() {
        return BookingPitchName;
    }

    public void setBookingPitchName(String bookingPitchName) {
        BookingPitchName.setText(bookingPitchName);
    }

    public JTextArea getBookingPitchType() {
        return BookingPitchType;
    }

    public void setBookingPitchType(Integer bookingPitchType) {
        BookingPitchType.setText(bookingPitchType.toString());
    }

    public JTextArea getBookingStartDate() {
        return BookingStartDate;
    }

    public void setBookingStartDate(String bookingStartDate) {
        BookingStartDate.setText(bookingStartDate);
    }

    public JTextArea getBookingEndDate() {
        return BookingEndDate;
    }

    public void setBookingEndDate(String bookingEndDate) {
        BookingEndDate.setText(bookingEndDate);
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

    public void setBookingAddress(String bookingAddress) {
        BookingAddress.setText(bookingAddress);
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
    private JCheckBox paidCheckBox;
    private Client ClientSummary;
    private Pitch PitchSummary;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    private int num = 1;

    public DialogBookingSummary() {
        setContentPane(BookingSummary);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        System.out.println(getNum());
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
            }
        });
        email.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        paidCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {

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

    public void make(Client A, Pitch B, String start, String end) {
        ClientSummary = A;
        PitchSummary = B;
        DialogBookingSummary D = new DialogBookingSummary();
        D.pack();

        D.setBookingForeName(ClientSummary.getFirstName());
        D.setBookingSurname(ClientSummary.getSecondName());
        D.setBookingCustomerID(ClientSummary.getClientID());
        D.setBookingCarReg(ClientSummary.getCarRegistration());
        D.setBookingAddress(ClientSummary.getAddress());
        D.setBookingCounty(ClientSummary.getCounty());
        D.setBookingPostCode(ClientSummary.getPostcode());

        D.setBookingPitchName(PitchSummary.getPitchName());
        D.setBookingPitchType(PitchSummary.getPitchType());
        D.setBookingStartDate(start);
        D.setBookingEndDate(end);

        D.setResizable(false);
        D.setVisible(true);
        //System.exit(0);
    }
}
