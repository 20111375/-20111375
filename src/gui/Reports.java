/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 05/11/2013
 * Time: 12:31
 */
package gui;

import camp.*;
import com.jcalendar.event.CalendarEvent;
import com.jcalendar.pane.calendar.CalendarPane;

import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * class definition
 * gui class for the reports screen
 */
public class Reports extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTabbedPane pitchesperday;
    private JPanel buttons;
    private JPanel tabs;
    private JList list1;
    private JList list2;
    private JList list3;
    private JButton search;
    private CalendarPane pickDate;
    private String StartDate = null;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private List<Pitch> pitches = null;

    /**
     * class constructor
     */
    public Reports() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        /**
         *button listener, on event trigger call method
         */
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        /**
         *button listener, on event trigger call method
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

        pickDate.addCalendarSelectionListener(new CalListen() {
            public void selectionChanged(CalendarEvent arg0) {
                try {
                    setStartDate(dateFormat.format(arg0.getDate()));
                    System.out.println(dateFormat.format(arg0.getDate()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        /**
         *set list model with booked pitches on a specified date
         */
        search.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (StartDate != null) {
                    try {
                        pitches = new PitchList().ItemsByDate(getStartDate());
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    list3.setListData(pitches.toArray());
                }
            }
        });
    }

    /**
     * remove this window
     */
    private void onOK() {
// add your code here
        dispose();
    }

    /**
     * remove this window
     */
    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    /**
     * initialise called in parent window
     */
    public void run() {
        Reports dialog = new Reports();
        dialog.pack();
        dialog.setResizable(false);
        dialog.setVisible(true);
    }

    /**
     * custom UI component initiliser
     */
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
        list3 = new JList();
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }
}