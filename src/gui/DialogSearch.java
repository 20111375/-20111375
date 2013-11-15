package gui;

import camp.Client;
import camp.ClientList;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.*;
import java.text.ParseException;
import java.util.List;


public class DialogSearch extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JList SearchResultList;
    private JRadioButton customerIDRadioButton;
    private JRadioButton postCodeRadioButton;
    private JRadioButton carRegRadioButton;
    private JFormattedTextField CustomerID;
    private JFormattedTextField PostCode;
    private JFormattedTextField CarReg;
    private JButton searchButton;

    public DialogSearch() {

        List<Client> customerList = null;
        try {
            customerList = new ClientList().Items();
        } catch (Exception e) {
            e.printStackTrace();
        }
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        SearchResultList.setListData(customerList.toArray());
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

        final List<Client> finalCustomerList = customerList;

        searchButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Client C : finalCustomerList) {
                    if (customerIDRadioButton.isSelected() == true && C.getClientID() == Integer.parseInt(CustomerID.getText())) {
                        System.out.println("Beam me up!!!");
                    }
                }
            }
        });

        carRegRadioButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
                if (carRegRadioButton.isSelected()) {
                    postCodeRadioButton.setSelected(false);
                    PostCode.setEnabled(false);
                    customerIDRadioButton.setSelected(false);
                    CustomerID.setEnabled(false);
                    CarReg.setEnabled(true);
                } else {
                    CarReg.setEnabled(false);
                }
            }
        });
        postCodeRadioButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
                if (postCodeRadioButton.isSelected()) {
                    carRegRadioButton.setSelected(false);
                    CarReg.setEnabled(false);
                    customerIDRadioButton.setSelected(false);
                    CustomerID.setEnabled(false);
                    PostCode.setEnabled(true);
                } else {
                    PostCode.setEnabled(false);
                }
            }
        });
        customerIDRadioButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
                if (customerIDRadioButton.isSelected()) {
                    carRegRadioButton.setSelected(false);
                    CarReg.setEnabled(false);
                    postCodeRadioButton.setSelected(false);
                    PostCode.setEnabled(false);
                    CustomerID.setEnabled(true);
                } else {
                    CustomerID.setEnabled(false);
                }
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

    public void make() {
        DialogSearch dialog;
        dialog = new DialogSearch();
        dialog.pack();
        dialog.setVisible(true);
        //System.exit(0);
    }

    private void createUIComponents() {
        MaskFormatter CustomerIDFormat = null;
        try {
            CustomerIDFormat = new MaskFormatter("#######");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        CustomerIDFormat.setValidCharacters("0123456789");
        CustomerID = new JFormattedTextField(CustomerIDFormat);
    }
}
