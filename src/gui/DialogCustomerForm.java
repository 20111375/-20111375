package gui;

import camp.Client;
import camp.ClientList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.util.List;

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
    private JPanel SaveChangePane;
    private JButton SaveButton;
    private JButton AddNewButton;
    private JButton ResetButton;
    public List<Client> customerList = null;

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
                AddNewButton.setEnabled(false);
                String tmpStr = (String) (String) CustomerList.getSelectedValue();
                String[] tmpArray = tmpStr.split(":");
                System.out.println(tmpArray[0]);
                for (Client F : customerList()) {
                    if (F.getClientID() == Integer.parseInt(tmpArray[0])) {
                        ClearText();
                        CustomerID.append(String.valueOf(F.getClientID()));
                        Forename.append(F.getFirstName());
                        Surname.append(F.getSecondName());
                        CarReg.append(F.getCarRegistration());
                        Address.append(F.getAddress());
                        County.append(F.getCounty());
                        PostCode.append(F.getPostcode());
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
                //To change body of implemented methods use File | Settings | File Templates.
                //String[] splitThis = CustomerList.getSelectedValue().toString().split(":");
                //System.out.println(Integer.parseInt(splitThis[0]));
                DeleteButton.setEnabled(true);
                System.out.println(customerList().get(CustomerList.getSelectedIndex()).getFirstName());
                System.out.println(customerList().get(CustomerList.getSelectedIndex()).getClientID());
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
                DefaultListModel CustModel = new DefaultListModel();
                for (Client M : customerList()) {
                    if (M.getDelete() == true) {
                        CustModel.addElement(M.getClientID() + ": " + M.getFirstName() + " | " + M.getSecondName() + " | " + M.getCarRegistration() + " | " + M.getPostcode() + " DELETED " + M.getDelete());
                    } else {
                        CustModel.addElement(M.getClientID() + ": " + M.getFirstName() + " | " + M.getSecondName() + " | " + M.getCarRegistration() + " | " + M.getPostcode());
                    }
                }
                CustomerList.setModel(CustModel);
                CustomerList.repaint();
                //endregion
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
                AddNewButton.setEnabled(true);
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
        //System.exit(0);
    }

    private void createUIComponents() {
        DefaultListModel CustModel = new DefaultListModel();
        for (Client M : customerList()) {
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

    private List<Client> customerList() {
        List<Client> customerlist = null;
        try {
            customerlist = new ClientList().Items();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerlist;
    }
}
