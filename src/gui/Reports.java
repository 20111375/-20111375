package gui;

import camp.Booking;
import camp.BookingList;
import camp.Client;
import camp.ClientList;

import javax.swing.*;
import java.awt.event.*;

public class Reports extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTabbedPane pitchesperday;
    private JPanel buttons;
    private JPanel tabs;
    private JList list1;
    private JList list2;

    public Reports() {
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
        Reports dialog = new Reports();
        dialog.pack();
        dialog.setResizable(false);
        dialog.setVisible(true);
    }

    private void createUIComponents() {
        DefaultListModel CustModel = new DefaultListModel();
        try {
            for (Client M : new ClientList().CarList()) {
                CustModel.addElement(M.getClientID() + ": " + M.getCarRegistration());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        list1 = new JList(CustModel);

        DefaultListModel PaidModel = new DefaultListModel();
        try {
            for (Booking N : new BookingList().WhoHasntPaid()) {
                PaidModel.addElement(N.getClientID() + " " + N.getPitchID() + " " + N.getFromDate() + " " + N.getToDate() + " " + N.getTotal());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        list2 = new JList(PaidModel);


    }
}
