/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 05/11/2013
 * Time: 12:31
 */
package gui;

import camp.Booking;
import camp.Client;
import camp.Communication;
import camp.Pitch;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DialogBookingSummary extends JDialog {
    public JTextArea BookingForeName;
    public Client ClientSummary = new Client();
    public Pitch PitchSummary = new Pitch();
    public Booking submit = new Booking();
    public String Start;
    public String End;
    private JPanel BookingSummary;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel Buttons;
    private JPanel ButtonPanel;
    private JPanel Details;
    private JTextArea BookingSurname;
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
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private DialogEmailForm emailConfirm = new DialogEmailForm(SwingUtilities.getWindowAncestor(this));
    private int BookingPitchID;

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

            }
        });
        email.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (email.isSelected()) {
                    getEmailConfirm().make(emailConfirm);
                }

            }
        });
        paidCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (paidCheckBox.isSelected()) {
                    submit.setPaid(true);
                }
            }
        });
    }

    public DialogEmailForm getEmailConfirm() {
        return emailConfirm;
    }

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

    private void setBookingPitchID(int bookingPitchID) {
        BookingPitchID = bookingPitchID;
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

    public void setBookingCostTotal(Double bookingCostTotal) {
        BookingCostTotal.setText(bookingCostTotal.toString());
    }

    public JTextArea getBookingAddress() {
        return BookingAddress;
    }

    public void setBookingAddress(String bookingAddress) {
        BookingAddress.setText(bookingAddress);
    }

    public String makeDate(String Start) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(dateFormat.parse(Start));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFormat.format(calendar.getTime());
    }

    private void onOK() {
// add your code here

        submit.setClientID(Integer.valueOf(getBookingCustomerID().getText()));
        submit.setPitchID(BookingPitchID);
        submit.setFromDate(getBookingStartDate().getText());
        submit.setToDate(getBookingEndDate().getText());
        submit.setTotal(Double.valueOf(getBookingCostTotal().getText()));
        if (!paidCheckBox.isSelected()) {
            submit.setPaid(false);
        }
        submit.insertNewBooking();
        submit.insertNewPayment();
        ClientSummary.setFirstName(getBookingForeName().getText());

        if (PrintIt.isSelected()) {
            try {
                new Communication().pdfer(submit, ClientSummary);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        new Communication().emailer(submit, ClientSummary, emailConfirm.getEmail());
        javax.swing.SwingUtilities.getWindowAncestor(DialogBookingSummary.this).dispose();
        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public void make(Client A, Pitch B, String start, String end) {
        ClientSummary = A;
        PitchSummary = B;
        Start = start;
        End = end;

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
        D.setBookingPitchID(PitchSummary.getPitchID());
        D.setBookingStartDate(start);
        D.setBookingEndDate(end);
        D.setBookingCostTotal(PitchSummary.getTotal());
        D.setResizable(false);
        D.setVisible(true);
    }
}
