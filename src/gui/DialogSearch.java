/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 05/11/2013
 * Time: 12:31
 */
package gui;

import camp.Client;
import camp.ClientList;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;

/**
 * @description class definition
 */
public class DialogSearch extends JDialog {
    private JPanel dialogSearch;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JList SearchResultList;
    private JRadioButton customerIDRadioButton;
    private JRadioButton carRegRadioButton;
    private JFormattedTextField CustomerID;
    private JFormattedTextField CarReg;
    private JButton searchButton;

    /**
     * @param windowAncestor
     * @description class constructor
     */
    public DialogSearch(Window windowAncestor) {
        setContentPane(dialogSearch);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        /**
         *@description button listener
         */
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        /**
         *@description button listener
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
        dialogSearch.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        /**
         *@description search button listener
         * repopulates results list after a selection is made
         */
        searchButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (customerIDRadioButton.isSelected() == true && carRegRadioButton.isSelected() == false) {
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

                if (carRegRadioButton.isSelected() == true) {
                    for (Client C : ClientList.customerList()) {
                        if (C.getCarRegistration().equals(CarReg.getText())) {
                            DefaultListModel CustModel = new DefaultListModel();
                            for (Client M : ClientList.customerList()) {
                                if (M.getCarRegistration().equals(CarReg.getText())) {
                                    CustModel.addElement(M.getClientID() + ": " + M.getFirstName() + " | " + M.getSecondName() + " | " + M.getCarRegistration() + " | " + M.getPostcode());
                                }
                            }
                            SearchResultList.setModel(CustModel);
                            SearchResultList.repaint();
                        }
                    }
                }
            }
        });

        /**
         *@description check box listener
         */
        carRegRadioButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (carRegRadioButton.isSelected()) {
                    customerIDRadioButton.setSelected(false);
                    CustomerID.setEnabled(false);
                    CarReg.setEnabled(true);
                } else {
                    CarReg.setEnabled(false);
                }
            }
        });

        /**
         *@description check box listener
         */
        customerIDRadioButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (customerIDRadioButton.isSelected()) {
                    carRegRadioButton.setSelected(false);
                    CarReg.setEnabled(false);
                    CustomerID.setEnabled(true);
                } else {
                    CustomerID.setEnabled(false);
                }
            }
        });
    }

    /**
     * @return gets a select customer from a list
     */
    public String getPickCustomer() {
        if (!SearchResultList.isSelectionEmpty()) {
            return SearchResultList.getSelectedValue().toString();
        }
        return null;
    }

    /**
     * @return gets a client picked from a list of type client
     */
    public Client getPickedClient() {
        if (!SearchResultList.isSelectionEmpty()) {
            String[] tmp = SearchResultList.getSelectedValue().toString().split(":");
            for (Client M : ClientList.customerList()) {
                if (tmp[0].equals(M.getClientID().toString())) {
                    return M;
                }
            }
        }
        return null;
    }

    /**
     * @description destroy window
     */
    private void onOK() {
        dispose();
    }

    /**
     * @description destroy window
     */
    private void onCancel() {
        dispose();
    }

    /**
     * @param D accepts an object of type dialog search
     */
    public void make(DialogSearch D) {
        D.pack();
        D.setTitle("Find a Customer");
        D.setResizable(false);
        D.setVisible(true);
    }

    /**
     * @description initilise customer ui components
     */
    private void createUIComponents() {
        MaskFormatter CustomerIDFormat = null;
        MaskFormatter RegIDFormat = null;
        //setup formatter's
        try {
            CustomerIDFormat = new MaskFormatter("#######");
            RegIDFormat = new MaskFormatter("AAAA" + " " + "AAA");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //attach formatter's
        CustomerID = new JFormattedTextField(CustomerIDFormat);
        CarReg = new JFormattedTextField(RegIDFormat);
        //populate list model
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
