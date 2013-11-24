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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class DialogCustomerForm extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton EditButton;
    private JButton DeleteButton;
    private JFormattedTextField Forename;
    private JFormattedTextField Surname;
    private JFormattedTextField CustomerID;
    private JFormattedTextField CarReg;
    private JFormattedTextField Address;
    private JFormattedTextField County;
    private JFormattedTextField PostCode;
    private JPanel DialogButtons;
    private JPanel CustomerInfoPane;
    private JPanel ListCustomersPane;
    private JPanel CustomerButtons;
    private JPanel ListPane;
    private JPanel DetailsPane;
    private JList CustomerList;
    private JPanel SaveChangePane;
    private JButton SaveButton;
    private JButton AddNewButton;
    private JButton ResetButton;
    private List<JFormattedTextField> fieldList = new ArrayList<JFormattedTextField>();
    private DocListener docListener = new DocListener();

    public DialogCustomerForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        docListener.setBtn(AddNewButton);
        docListener.setObjectList(fieldList);
        fieldList.add(Forename);
        fieldList.add(Surname);
        fieldList.add(CarReg);
        fieldList.add(Address);
        fieldList.add(County);
        fieldList.add(PostCode);
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
        DeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!CustomerList.isSelectionEmpty()) {
                    String tmpStr = (String) (String) CustomerList.getSelectedValue();
                    String[] tmpArray = tmpStr.split(":");
                    System.out.println(tmpArray[0]);
                    for (Client F : ClientList.customerList()) {
                        if (F.getClientID() == Integer.parseInt(tmpArray[0])) {
                            F.setDelete(true);
                            new ClientList().deleteCustomer(F);
                        }
                    }
                }
                ClearText();
                textList();
                DeleteButton.setEnabled(false);
            }
        });
        /**
         *
         */
        EditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!CustomerList.isSelectionEmpty()) {
                    SaveButton.setEnabled(true);
                    String tmpStr = (String) (String) CustomerList.getSelectedValue();
                    String[] tmpArray = tmpStr.split(":");
                    System.out.println(tmpArray[0]);
                    for (Client F : ClientList.customerList()) {
                        if (F.getClientID() == Integer.parseInt(tmpArray[0])) {
                            ClearText();
                            CustomerID.setText(String.valueOf(F.getClientID()));
                            Forename.setText(F.getFirstName());
                            Surname.setText(F.getSecondName());
                            CarReg.setText(F.getCarRegistration());
                            Address.setText(F.getAddress());
                            County.setText(F.getCounty());
                            PostCode.setText(F.getPostcode());
                        }
                    }
                }
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
                DeleteButton.setEnabled(true);
            }
        });

        SaveButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!getForename().getText().trim().isEmpty() && !getSurname().getText().trim().isEmpty() &&
                        !getAddress().getText().trim().isEmpty() && !getCounty().getText().trim().isEmpty()
                        && !getPostCode().getText().trim().isEmpty() && !getCarReg().getText().trim().isEmpty()) {
                    Client tmp = new Client();
                    tmp.setFirstName(Forename.getText());
                    tmp.setSecondName(Surname.getText());
                    tmp.setAddress(Address.getText());
                    tmp.setCounty(County.getText());
                    tmp.setPostcode(PostCode.getText());
                    tmp.setCarRegistration(CarReg.getText());
                    tmp.setClientID(Integer.valueOf(CustomerID.getText()));
                    new ClientList().editCustomer(tmp);
                    ClearText();
                    textList();
                }
            }
        });

        AddNewButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            //firstname,secondname,address,county,postcode,carregistration
            public void actionPerformed(ActionEvent e) {
                if (!getForename().getText().trim().isEmpty() && !getSurname().getText().trim().isEmpty() &&
                        !getAddress().getText().trim().isEmpty() && !getCounty().getText().trim().isEmpty()
                        && !getPostCode().getText().trim().isEmpty() && !getCarReg().getText().trim().isEmpty()) {
                    Client tmp = new Client();
                    tmp.setFirstName(Forename.getText());
                    tmp.setSecondName(Surname.getText());
                    tmp.setAddress(Address.getText());
                    tmp.setCounty(County.getText());
                    tmp.setPostcode(PostCode.getText());
                    tmp.setCarRegistration(CarReg.getText());
                    new ClientList().insertNewCustomer(tmp);
                    ClearText();
                    //Refresh Customer List JList with new customer
                    textList();
                    //endregion
                }

            }
        });
        ResetButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                ClearText();
                SaveButton.setEnabled(false);
                CustomerList.setSelectedIndex(0);
                //AddNewButton.setEnabled(true);
            }
        });
    }

    public static void make() {
        DialogCustomerForm dialog = new DialogCustomerForm();
        dialog.pack();
        dialog.setVisible(true);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
    }

    public JFormattedTextField getPostCode() {
        return PostCode;
    }

    public void setPostCode(JFormattedTextField postCode) {
        PostCode = postCode;
    }

    public JFormattedTextField getForename() {
        return Forename;
    }

    public void setForename(JFormattedTextField forename) {
        Forename = forename;
    }

    public JFormattedTextField getSurname() {
        return Surname;
    }

    public void setSurname(JFormattedTextField surname) {
        Surname = surname;
    }

    public JFormattedTextField getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(JFormattedTextField customerID) {
        CustomerID = customerID;
    }

    public JFormattedTextField getCarReg() {
        return CarReg;
    }

    public void setCarReg(JFormattedTextField carReg) {
        CarReg = carReg;
    }

    public JFormattedTextField getAddress() {
        return Address;
    }

    public void setAddress(JFormattedTextField address) {
        Address = address;
    }

    public JFormattedTextField getCounty() {
        return County;
    }

    public void setCounty(JFormattedTextField county) {
        County = county;
    }

    private void onOK() {
// add your code here
        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    private void createUIComponents() {
        DefaultListModel CustModel = new DefaultListModel();
        for (Client M : ClientList.customerList()) {
            if (M.getDelete() == true) {
                CustModel.addElement(M.getClientID() + ": " + M.getFirstName() + " | " + M.getSecondName() + " | " + M.getCarRegistration() + " | " + M.getPostcode() + " DELETED " + M.getDelete());
            } else {
                CustModel.addElement(M.getClientID() + ": " + M.getFirstName() + " | " + M.getSecondName() + " | " + M.getCarRegistration() + " | " + M.getPostcode());
            }
        }
        CustomerList = new JList(CustModel);
    }

    private void ClearText() {
        CustomerID.setText(null);
        Forename.setText(null);
        Surname.setText(null);
        Address.setText(null);
        County.setText(null);
        PostCode.setText(null);
        CarReg.setText(null);
    }

    private void textList() {
        DefaultListModel CustModel = new DefaultListModel();
        for (Client M : ClientList.customerList()) {
            if (M.getDelete() == true) {
                CustModel.addElement(M.getClientID() + ": " + M.getFirstName() + " | " + M.getSecondName() + " | " + M.getCarRegistration() + " | " + M.getPostcode() + " DELETED " + M.getDelete());
            } else {
                CustModel.addElement(M.getClientID() + ": " + M.getFirstName() + " | " + M.getSecondName() + " | " + M.getCarRegistration() + " | " + M.getPostcode());
            }
        }
        CustomerList.setModel(CustModel);
        CustomerList.repaint();
    }

}
