package gui;

import camp.Client;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class DialogSearch extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JList SearchResultList;
    private JRadioButton customerIDRadioButton;
    private JRadioButton postCodeRadioButton;
    private JRadioButton carRegRadioButton;
    private JTextField CustomerID;
    private JTextField PostCode;

    public JTextField getCarReg() {
        return CarReg;
    }

    public void setCarReg(JTextField carReg) {
        CarReg = carReg;
    }

    public JTextField getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(JTextField customerID) {
        CustomerID = customerID;
    }

    public JTextField getPostCode() {
        return PostCode;
    }

    public void setPostCode(JTextField postCode) {
        PostCode = postCode;
    }

    private JTextField CarReg;
    private JButton searchButton;

    public DialogSearch(List<Client> D) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        SearchResultList.setListData(D.toArray());
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
        searchButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        carRegRadioButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        postCodeRadioButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        customerIDRadioButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
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

    public void make(List<Client> D) {
        DialogSearch dialog;
        dialog = new DialogSearch(D);
        dialog.pack();
        dialog.setVisible(true);
        //System.exit(0);
    }

}
