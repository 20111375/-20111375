package gui;

import javax.swing.*;
import java.awt.event.*;

public class DialogExtendBooking extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JRadioButton customerIDRadioButton;
    private JRadioButton postCodeRadioButton;
    private JRadioButton carRegRadioButton;
    private JTextArea ID;

    public JTextArea getCarReg() {
        return CarReg;
    }

    public void setCarReg(JTextArea carReg) {
        CarReg = carReg;
    }

    public JTextArea getID() {
        return ID;
    }

    public void setID(JTextArea ID) {
        this.ID = ID;
    }

    public JTextArea getPostCode() {
        return PostCode;
    }

    public void setPostCode(JTextArea postCode) {
        PostCode = postCode;
    }

    private JTextArea PostCode;
    private JTextArea CarReg;

    public DialogExtendBooking() {
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

    public static void main(String[] args) {
        DialogExtendBooking dialog = new DialogExtendBooking();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
