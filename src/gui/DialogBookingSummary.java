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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * class definition
 * gui class for booking summary
 */
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

    /**
     * class constructor
     */
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

        /**
         *combo box listener
         */
        PrintIt.addActionListener(new ActionListener() {
            /**
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        /**
         *combo box listener
         */
        email.addActionListener(new ActionListener() {
            /**
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                if (email.isSelected()) {
                    getEmailConfirm().make(emailConfirm);
                }
            }
        });

        /**
         *combo box listener
         */
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

    /**
     * @return gets an email confirmation on type dialog email form
     */
    public DialogEmailForm getEmailConfirm() {
        return emailConfirm;
    }

    /**
     * @return gets a booking forename of type text area
     */
    public JTextArea getBookingForeName() {
        return BookingForeName;
    }

    /**
     * @param bookingForeName sets a booking forename of type text area
     */
    public void setBookingForeName(String bookingForeName) {
        BookingForeName.append(bookingForeName);
    }

    /**
     * @return gets a booking surname of type text area
     */
    public JTextArea getBookingSurname() {
        return BookingSurname;
    }

    /**
     * @param bookingSurname sets a booking surname of type string
     */
    public void setBookingSurname(String bookingSurname) {
        BookingSurname.setText(bookingSurname);
    }

    /**
     * @return gets a booking customer id of type text area
     */
    public JTextArea getBookingCustomerID() {
        return BookingCustomerID;
    }

    /**
     * @param bookingCustomerID sets a booking customer id of type int
     */
    public void setBookingCustomerID(Integer bookingCustomerID) {
        BookingCustomerID.setText(bookingCustomerID.toString());
    }

    /**
     * @return gets a booking car reg of type text area
     */
    public JTextArea getBookingCarReg() {
        return BookingCarReg;
    }

    /**
     * @param bookingCarReg sets a booking car reg of type string
     */
    public void setBookingCarReg(String bookingCarReg) {
        BookingCarReg.setText(bookingCarReg);
    }

    /**
     * @param bookingPitchID sets a booking pitch id of type int
     */
    private void setBookingPitchID(int bookingPitchID) {
        BookingPitchID = bookingPitchID;
    }

    /**
     * @return gets a booking county of type text area
     */
    public JTextArea getBookingCounty() {
        return BookingCounty;
    }

    /**
     * @param bookingCounty sets a booking county of type text area
     */
    public void setBookingCounty(String bookingCounty) {
        BookingCounty.setText(bookingCounty);
    }

    /**
     * @return gets a booking post code of type text area
     */
    public JTextArea getBookingPostCode() {
        return BookingPostCode;
    }

    /**
     * @param bookingPostCode sets a booking post code of type text area
     */
    public void setBookingPostCode(String bookingPostCode) {
        BookingPostCode.setText(bookingPostCode);
    }

    /**
     * @return gets a booking pitch name of type text area
     */
    public JTextArea getBookingPitchName() {
        return BookingPitchName;
    }

    /**
     * @param bookingPitchName sets a booking forename of type string
     */
    public void setBookingPitchName(String bookingPitchName) {
        BookingPitchName.setText(bookingPitchName);
    }

    /**
     * @return gets a booking pitch type of type text area
     */
    public JTextArea getBookingPitchType() {
        return BookingPitchType;
    }

    /**
     * @param bookingPitchType sets a booking pitch type of type integer
     */
    public void setBookingPitchType(Integer bookingPitchType) {
        BookingPitchType.setText(bookingPitchType.toString());
    }

    /**
     * @return gets a booking start date of type text area
     */
    public JTextArea getBookingStartDate() {
        return BookingStartDate;
    }

    /**
     * @param bookingStartDate sets a booking start date of type string
     */
    public void setBookingStartDate(String bookingStartDate) {
        BookingStartDate.setText(bookingStartDate);
    }

    /**
     * @return gets a booking end date of type text area
     */
    public JTextArea getBookingEndDate() {
        return BookingEndDate;
    }

    /**
     * @param bookingEndDate sets a booking end date of type string
     */
    public void setBookingEndDate(String bookingEndDate) {
        BookingEndDate.setText(bookingEndDate);
    }

    /**
     * @return gets a booking total of type text area
     */
    public JTextArea getBookingCostTotal() {
        return BookingCostTotal;
    }

    /**
     * @param bookingCostTotal sets a booking forename of type double
     */
    public void setBookingCostTotal(Double bookingCostTotal) {
        BookingCostTotal.setText(bookingCostTotal.toString());
    }

    /**
     * @return gets a booking address of type text area
     */
    public JTextArea getBookingAddress() {
        return BookingAddress;
    }

    /**
     * @param bookingAddress sets a booking address of type string
     */
    public void setBookingAddress(String bookingAddress) {
        BookingAddress.setText(bookingAddress);
    }

    /**
     * @param Start date as type string (format yy-MM-dd)
     * @return date as type date format
     */
    public String makeDate(String Start) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(dateFormat.parse(Start));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFormat.format(calendar.getTime());
    }

    /**
     * pass booking details to booking object, insert to db and class this + parent
     */
    private void onOK() {
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
            new Communication().pdfer(submit, ClientSummary);
        }
        new Communication().emailer(submit, ClientSummary, emailConfirm.getEmail());
        javax.swing.SwingUtilities.getWindowAncestor(DialogBookingSummary.this).dispose();
        dispose();
    }

    /**
     * destroy window
     */
    private void onCancel() {
        dispose();
    }

    /**
     * @param A     as type client (who is the booking for)
     * @param B     as type pitch (which pitch is the booking for)
     * @param start as type string (what is the booking start date)
     * @param end   as type string (what is the booking end date)
     */
    public void make(Client A, Pitch B, String start, String end) {
        ClientSummary = A;
        PitchSummary = B;
        Start = start;
        End = end;

        DialogBookingSummary D = new DialogBookingSummary();
        D.pack();

        //define the the customer of the booking
        D.setBookingForeName(ClientSummary.getFirstName());
        D.setBookingSurname(ClientSummary.getSecondName());
        D.setBookingCustomerID(ClientSummary.getClientID());
        D.setBookingCarReg(ClientSummary.getCarRegistration());
        D.setBookingAddress(ClientSummary.getAddress());
        D.setBookingCounty(ClientSummary.getCounty());
        D.setBookingPostCode(ClientSummary.getPostcode());

        // define the pitch of the booking
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
