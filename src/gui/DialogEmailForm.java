/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 05/11/2013
 * Time: 12:31
 */
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DialogEmailForm extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;

    public JTextArea getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(JTextArea emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmail() {
        if (getEmailAddress().getText() != null) {
            String address = getEmailAddress().getText();
            return address;
        }
        return "empty";
    }

    private JTextArea emailAddress;
    private JCheckBox copyToOfficeCheckBox;

    public DialogEmailForm(Window windowAncestor) {
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
        copyToOfficeCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {

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

    public static void make(DialogEmailForm D) {
        D.pack();
        D.setResizable(false);
        D.setVisible(true);
    }
}