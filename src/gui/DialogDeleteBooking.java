/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 05/11/2013
 * Time: 12:31
 */
package gui;

import camp.Booking;
import camp.BookingList;
import camp.Client;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class DialogDeleteBooking extends JDialog {
    public Client myBooking = new Client();
    public Booking deleteThis = new Booking();
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton submitButton;
    private JButton deleteButton;
    private JTextArea ID;
    private JFormattedTextField Customer;
    private JTextArea CarReg;
    private JList CustomerBookingsList;
    private List<JFormattedTextField> fieldList = new ArrayList<JFormattedTextField>();
    private DocListener docListener = new DocListener();

    private String returnItem(String item, int at) {
        String[] tmp = item.split(" ");
        return tmp[at];
    }

    public DialogDeleteBooking(Window windowAncestor) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        docListener.setBtn(submitButton);
        docListener.setObjectList(fieldList);
        fieldList.add(Customer);
        for (JFormattedTextField F : fieldList) {
            F.getDocument().addDocumentListener(docListener);
        }


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
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        submitButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {

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
                deleteButton.setEnabled(true);
                CustomerBookingsList.setModel(CustModel);
                CustomerBookingsList.repaint();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteThis.setClientID(Integer.parseInt(returnItem(CustomerBookingsList.getSelectedValue().toString(), 0)));
                deleteThis.setPitchID(Integer.parseInt(returnItem(CustomerBookingsList.getSelectedValue().toString(), 1)));
                deleteThis.setFromDate(returnItem(CustomerBookingsList.getSelectedValue().toString(), 2));
                deleteThis.setToDate(returnItem(CustomerBookingsList.getSelectedValue().toString(), 3));
                deleteThis.deleteBooking();
            }
        });
    }

    public JTextArea getCarReg() {
        return CarReg;
    }

    public void setCarReg(JTextArea carReg) {
        CarReg = carReg;
    }

    public JTextArea getID() {
        return ID;
    }

    public void setID(JTextArea ID) {
        this.ID = ID;
    }

    public JTextField getCustomer() {
        return Customer;
    }

    public void setCustomer(String customer) {
        Customer.setText(customer);
    }

    private void onOK() {
// add your code here
        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public void make(DialogDeleteBooking D) {
        D.pack();
        D.setTitle("Delete a booking");
        D.setResizable(false);
        D.setVisible(true);
        D.setLocationRelativeTo(null);
    }

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
