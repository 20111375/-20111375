package gui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;

public class DialogCustomerForm extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton EditButton;
    private JButton DeleteButton;
    private JTextArea Forename;
    private JTextArea Surname;

    public JTextArea getPostCode() {
        return PostCode;
    }

    public void setPostCode(JTextArea postCode) {
        PostCode = postCode;
    }

    public JTextArea getForename() {
        return Forename;
    }

    public void setForename(JTextArea forename) {
        Forename = forename;
    }

    public JTextArea getSurname() {
        return Surname;
    }

    public void setSurname(JTextArea surname) {
        Surname = surname;
    }

    public JTextArea getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(JTextArea customerID) {
        CustomerID = customerID;
    }

    public JTextArea getCarReg() {
        return CarReg;
    }

    public void setCarReg(JTextArea carReg) {
        CarReg = carReg;
    }

    public JTextArea getAddress() {
        return Address;
    }

    public void setAddress(JTextArea address) {
        Address = address;
    }

    public JTextArea getCounty() {
        return County;
    }

    public void setCounty(JTextArea county) {
        County = county;
    }

    private JTextArea CustomerID;
    private JTextArea CarReg;
    private JTextArea Address;
    private JTextArea County;
    private JTextArea PostCode;
    private JPanel DialogButtons;
    private JPanel CustomerInfoPane;
    private JPanel ListCustomersPane;
    private JPanel CustomerButtons;
    private JPanel ListPane;
    private JPanel DetailsPane;
    private JList CustomerList;

    public DialogCustomerForm() {
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
        DeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        EditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        CustomerList.addListSelectionListener(new ListSelectionListener() {
            /**
             * Called whenever the value of the selection changes.
             *
             * @param e the event that characterizes the change.
             */
            @Override
            public void valueChanged(ListSelectionEvent e) {
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

    public static void make() {
        DialogCustomerForm dialog = new DialogCustomerForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
