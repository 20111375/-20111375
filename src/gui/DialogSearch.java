package gui;

import camp.Client;
import camp.ClientList;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class DialogSearch extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JList list1;
    private JRadioButton customerIDRadioButton;
    private JRadioButton postCodeRadioButton;
    private JRadioButton carRegRadioButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton searchButton;

    public DialogSearch(List<Client> D) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        list1.setListData(D.toArray());
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

    public void make(List<Client> D) {
        DialogSearch dialog;
        dialog = new DialogSearch(D);
        dialog.pack();
        dialog.setVisible(true);
        //System.exit(0);
    }

}
