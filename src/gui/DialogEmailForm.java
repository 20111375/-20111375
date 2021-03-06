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

/**
 * class definition
 * gui class for emailing
 */
public class DialogEmailForm extends JDialog { //inheritance example
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextArea emailAddress;

    /**
     * @param windowAncestor class constructor
     */
    public DialogEmailForm(Window windowAncestor) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        /**
         *button listener
         */
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
        /**
         *button listener
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
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    /**
     * @param D initialises a instance of type DialogEmailForm
     */
    public static void make(DialogEmailForm D) {
        D.pack();
        D.setTitle("email a receipt to the customer");
        D.setResizable(false);
        D.setVisible(true);
    }

    /**
     * @return gets a text area which represents an email address
     */
    JTextArea getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress sets a string value representing an email address
     */
    public void setEmailAddress(JTextArea emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @return gets a string value representing an email address
     */
    public String getEmail() {
        if (getEmailAddress().getText().length() != 0) {
            String address = getEmailAddress().getText();
            return address;
        }
        return null;
    }

    /**
     * destroy window
     */
    private void onOK() {
        dispose();
    }

    /**
     * destroy window
     */
    private void onCancel() {
        dispose();
    }
}