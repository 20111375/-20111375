/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 05/11/2013
 * Time: 12:31
 */
package gui;

import camp.*;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * class definition
 */
public class DialogExtendBooking extends JDialog {
    public Client myBooking = new Client();
    public Booking extendThis = new Booking();
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton submitButton;
    private JButton checkAvailabilityButton;
    private JRadioButton customerIDRadioButton;
    private JRadioButton carRegRadioButton;
    private JTextArea ID;
    private JFormattedTextField Customer;
    private JTextArea CarReg;
    private JComboBox extendByDays;
    private JList CustomerBookingsList;
    private JLabel Warning;
    private List<JFormattedTextField> fieldList = new ArrayList<JFormattedTextField>();
    private DocListener docListener = new DocListener();
    private List<Pitch> pitches = null;

    /**
     * @param windowAncestor class constructor
     */
    public DialogExtendBooking(Window windowAncestor) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        docListener.setBtn(submitButton);
        docListener.setObjectList(fieldList);
        fieldList.add(Customer);
        for (JFormattedTextField F : fieldList) {
            F.getDocument().addDocumentListener(docListener);
        }

        /**
         *button listener
         */
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //
                extendThis.setClientID(Integer.parseInt(returnItem(CustomerBookingsList.getSelectedValue().toString(), 0)));
                extendThis.setPitchID(Integer.parseInt(returnItem(CustomerBookingsList.getSelectedValue().toString(), 1)));
                extendThis.setFromDate(returnItem(CustomerBookingsList.getSelectedValue().toString(), 3));
                extendThis.setPaid(false);
                Pricing price = new Pricing();
                double total = price.Total(price.getFee(), price.Discount(extendThis.getFromDate()), extendByDays.getSelectedIndex());
                extendThis.setTotal(total);
                extendThis.insertNewBooking();

                onOK();
            }
        });
        /**
         *button listener
         */
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
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        /**
         *button listener
         */
        submitButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //constructor a booking list object and populate a list model
                BookingList check = new BookingList();
                try {
                    check.Items(Integer.parseInt(Customer.getText()));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                DefaultListModel CustModel = new DefaultListModel();
                try {
                    for (Booking B : check.Items(Integer.parseInt(Customer.getText()))) {

                        CustModel.addElement(B.getClientID() + " " + B.getPitchID() + " " + B.getFromDate() + " " + B.getToDate());
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                checkAvailabilityButton.setEnabled(true);
                CustomerBookingsList.setModel(CustModel);
                CustomerBookingsList.repaint();
            }
        });

        /**
         *button listener
         */
        checkAvailabilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (extendByDays != null && !CustomerBookingsList.isSelectionEmpty()) {
                    String tmpDate = new DateMaker().DateMaker(extendByDays.getSelectedIndex(), returnItem(CustomerBookingsList.getSelectedValue().toString(), 3));
                    try {
                        pitches = new PitchList().Items(returnItem(CustomerBookingsList.getSelectedValue().toString(), 3), tmpDate, Integer.parseInt(returnItem(CustomerBookingsList.getSelectedValue().toString(), 1)));
                        if (pitches.isEmpty()) {
                            System.out.println("nothing was returned");
                            Warning.setText("nothing was returned");
                        } else {
                            for (Pitch B : pitches) {
                                extendThis.setToDate(tmpDate);
                                Warning.setText("Press the OK button to extend the booking");
                                System.out.println(B.getPitchID() + " " + B.getPitchName());
                            }
                        }
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }

    /**
     * @param item space delimited string
     * @param at   index position
     * @return string array item at index
     */
    private String returnItem(String item, int at) {
        String[] tmp = item.split(" ");
        return tmp[at];
    }

    /**
     * @return gets car reg text area field
     */
    public JTextArea getCarReg() {
        return CarReg;
    }

    /**
     * @param carReg sets car reg text area field
     */
    public void setCarReg(JTextArea carReg) {
        CarReg = carReg;
    }

    /**
     * @return gets ID text area field
     */
    public JTextArea getID() {
        return ID;
    }

    /**
     * @param ID sets ID text area field
     */
    public void setID(JTextArea ID) {
        this.ID = ID;
    }

    /**
     * @return gets customer text area field
     */
    public JTextField getCustomer() {
        return Customer;
    }

    /**
     * @param customer sets customer text area field
     */
    public void setCustomer(String customer) {
        Customer.setText(customer);
    }

    /**
     * destroys window
     */
    private void onOK() {
        dispose();
    }

    /**
     * destroys window
     */
    private void onCancel() {
        dispose();
    }

    /**
     * @param D accepts type DialogExtendBooking
     */
    public void make(DialogExtendBooking D) {
        D.pack();
        D.setTitle("Extend a booking");
        D.setResizable(false);
        D.setVisible(true);
        D.setLocationRelativeTo(null);
    }

    /**
     * custom ui initiliser
     */
    private void createUIComponents() {
        MaskFormatter BookingIDFormat = null;
        try {
            BookingIDFormat = new MaskFormatter("#######");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        BookingIDFormat.setValidCharacters("0123456789");
        Customer = new JFormattedTextField(BookingIDFormat);
    }
}