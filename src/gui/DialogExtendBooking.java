/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 05/11/2013
 * Time: 12:31
 */
package gui;

import camp.BookingList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DialogExtendBooking extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JRadioButton customerIDRadioButton;
    private JRadioButton carRegRadioButton;
    private JTextArea ID;
    private JTextArea Customer;
    private JButton submitButton;
    private JList list1;
    private JButton checkAvailabilityButton;
    private JComboBox comboBox1;
    private JTextArea CarReg;

    public DialogExtendBooking(Window windowAncestor) {
        setContentPane(contentPane);
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
                if (getCustomer().getText().length() != 0) {
                    BookingList check = new BookingList();
                    try {
                        check.Items(Integer.parseInt(getCustomer().getText()));
                        list1.setListData(check.Items(Integer.parseInt(getCustomer().getText())).toArray());
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        list1.addListSelectionListener(new ListSelectionListener() {
            /**
             * Called whenever the value of the selection changes.
             *
             * @param e the event that characterizes the change.
             */
            @Override
            public void valueChanged(ListSelectionEvent e) {

            }
        });
        Customer.addPropertyChangeListener(new PropertyChangeListener() {
            /**
             * This method gets called when a bound property is changed.
             *
             * @param evt A PropertyChangeEvent object describing the event source
             *            and the property that has changed.
             */
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (getCustomer().getText().length() > 0) {
                    submitButton.setEnabled(true);
                }
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

    public JTextArea getCustomer() {
        return Customer;
    }

    public void setCustomer(JTextArea customer) {
        Customer = customer;
    }

    private void onOK() {
// add your code here
        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public void make(DialogExtendBooking D) {
        D.pack();
        D.setResizable(false);
        D.setVisible(true);
        D.setLocationRelativeTo(null);
    }
}
