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
 * gui class for extending a booking
 */
public class DialogExtendBooking extends JDialog {// example of inheritance as DialogExtendBooking extends JDialog
    public Client myBooking = new Client();//example of the use of objects
    private final Booking extendThis = new Booking();
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton submitButton;
    private JButton checkAvailabilityButton;
    private JFormattedTextField Customer;
    private JComboBox extendByDays;
    private JList CustomerBookingsList;
    private JLabel Warning;
    private List<Pitch> pitches = null;
    private boolean Available = false;

    /**
     * @param windowAncestor class constructor
     */
    public DialogExtendBooking(Window windowAncestor) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        DocListener docListener = new DocListener();
        docListener.setBtn(submitButton);
        List<JFormattedTextField> fieldList = new ArrayList<>();
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
                //create te new booking and insert it into the database
                if (Customer != null && extendByDays != null && !CustomerBookingsList.isSelectionEmpty() && isAvailable()) {
                    extendThis.setClientID(Integer.parseInt(returnItem(CustomerBookingsList.getSelectedValue().toString(), 0)));
                    extendThis.setPitchID(Integer.parseInt(returnItem(CustomerBookingsList.getSelectedValue().toString(), 1)));
                    extendThis.setFromDate(returnItem(CustomerBookingsList.getSelectedValue().toString(), 3));
                    extendThis.setPaid(false);
                    Pricing price = new Pricing();
                    double total = price.Total(price.getFee(), extendByDays.getSelectedIndex(), extendThis.getToDate());
                    extendThis.setTotal(total);
                    extendThis.insertNewBooking();
                }
                //clean up the UI
                CleanUp();
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
                CleanUp();
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
                            setAvailable(false);
                        } else {
                            for (Pitch B : pitches) {
                                setAvailable(true);
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
     * @return boolean value for availability of booking extension
     */
    public boolean isAvailable() {
        return Available;
    }

    /**
     * @param available boolean value
     */
    public void setAvailable(boolean available) {
        Available = available;
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
     * cleanup all the elements of the UI
     */
    private void CleanUp() {
        DefaultListModel ClearModel = new DefaultListModel();
        CustomerBookingsList.setModel(ClearModel);
        CustomerBookingsList.repaint();
        Customer.setText("");
        extendByDays.setSelectedIndex(0);
        myBooking = null;
    }

    /**
     * custom ui initialises
     * format the text input of the Customer text field
     */
    private void createUIComponents() {
        MaskFormatter BookingIDFormat = null;
        try {
            BookingIDFormat = new MaskFormatter("#######");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert BookingIDFormat != null;
        BookingIDFormat.setValidCharacters("0123456789");
        Customer = new JFormattedTextField(BookingIDFormat);
    }
}