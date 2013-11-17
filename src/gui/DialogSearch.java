package gui;

import camp.Client;
import camp.ClientList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;


public class DialogSearch extends JDialog {
    private JPanel dialogSearch;
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
    private String pickCustomer;

    public String getPickCustomer() {
        return SearchResultList.getSelectedValue().toString();
    }

    public DialogSearch(Window windowAncestor) {

        setContentPane(dialogSearch);
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
        dialogSearch.registerKeyboardAction(new ActionListener() {
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
                for (Client C : ClientList.customerList()) {
                    if (customerIDRadioButton.isSelected() == true && C.getClientID() == Integer.parseInt(CustomerID.getText())) {
                        DefaultListModel CustModel = new DefaultListModel();
                        for (Client M : ClientList.customerList()) {
                            if (M.getClientID() == Integer.parseInt(CustomerID.getText())) {
                                CustModel.addElement(M.getClientID() + ": " + M.getFirstName() + " | " + M.getSecondName() + " | " + M.getCarRegistration() + " | " + M.getPostcode());
                            }
                        }
                        SearchResultList.setModel(CustModel);
                        SearchResultList.repaint();
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
        SearchResultList.addListSelectionListener(new ListSelectionListener() {
            /**
             * Called whenever the value of the selection changes.
             *
             * @param e the event that characterizes the change.
             */
            @Override
            public void valueChanged(ListSelectionEvent e) {

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

    public void make(DialogSearch D) {
        D.pack();
        D.setVisible(true);
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

        DefaultListModel CustModel = new DefaultListModel();
        for (Client M : ClientList.customerList()) {
            if (M.getDelete() == true) {
                CustModel.addElement(M.getClientID() + ": " + M.getFirstName() + " | " + M.getSecondName() + " | " + M.getCarRegistration() + " | " + M.getPostcode() + " DELETED " + M.getDelete());
            } else {
                CustModel.addElement(M.getClientID() + ": " + M.getFirstName() + " | " + M.getSecondName() + " | " + M.getCarRegistration() + " | " + M.getPostcode());
            }
        }
        SearchResultList = new JList(CustModel);
    }

}
