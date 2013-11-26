/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 05/11/2013
 * Time: 12:31
 */
package gui;

import camp.Client;
import camp.Pitch;
import camp.PitchList;
import camp.Pricing;
import com.jcalendar.event.CalendarEvent;
import com.jcalendar.pane.calendar.CalendarPane;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @description class definition
 */
public class FormBooking extends JDialog {
    private JComboBox PitchType;
    private JList SearchResultList;
    private JButton SearchButton;
    private JButton FindCustomerButton;
    private JButton NewCustomerButton;
    private JButton ConfirmButton;
    private JButton extendABookingButton;
    private JTextArea CustomerDetails;
    private JTextArea PitchDetails;
    private JComboBox EndDate;
    private CalendarPane FromDate;
    private JPanel ReservationPane;
    private JPanel ExtendBooking;
    private JPanel FormBooking;
    private JPanel BookForm;
    private JButton buttonCancel;
    private JButton buttonOK;
    private JButton cancelABookingButton;
    private String TypeName;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String StartDate = null;
    private int FinishDate;
    private String PitchSelected;
    private List<Pitch> pitches = null;
    private Client BookingClient;
    private Pitch BookingPitch;
    private DialogSearch search = new DialogSearch(SwingUtilities.getWindowAncestor(this));
    private DialogExtendBooking bookingCheck = new DialogExtendBooking(SwingUtilities.getWindowAncestor(this));
    private DialogDeleteBooking bookingDelete = new DialogDeleteBooking(SwingUtilities.getWindowAncestor(this));

    /**
     * @description class constructor
     */
    public FormBooking() {
        setContentPane(FormBooking);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        /**
         *@description button event listener
         */
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        /**
         *@description button event listener
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
        FormBooking.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        /**
         *@description button event listener
         */
        extendABookingButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                getBookingCheck().make(bookingCheck);
            }
        });

        /**
         *@description button event listener
         */
        ConfirmButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogBookingSummary booked = new DialogBookingSummary();
                Pricing price = new Pricing();
                double tot = price.Total(price.getFee(), price.Discount(getStartDate()), getFinishDate());
                BookingPitch.setTotal(tot);
                booked.make(BookingClient, BookingPitch, getStartDate(), makeFinishDate(getFinishDate(), getStartDate()));
            }
        });

        /**
         *@description button event listener
         */
        NewCustomerButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                new DialogCustomerForm().make();
            }
        });

        /**
         *@description button event listener
         */
        FindCustomerButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                getSearch().make(search);
                setBookingClient(search.getPickedClient());
                if (BookingClient != null) {
                    CustomerDetails.setText("");
                    CustomerDetails.append("Customer ID: " + BookingClient.getClientID() + "\n");
                    CustomerDetails.append("Customer name: " + BookingClient.getFirstName() + " " + BookingClient.getSecondName() + "\n");
                    CustomerDetails.append("Customer car Reg: " + BookingClient.getCarRegistration() + "\n");
                }
            }
        });

        /**
         *@description button event listener
         */
        SearchButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (StartDate != null && FinishDate != 0 && TypeName != null) {
                    String tempTime = makeFinishDate(getFinishDate(), getStartDate());
                    try {
                        pitches = new PitchList().Items(getStartDate(), tempTime.toString(), getTypeName());
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    SearchResultList.setListData(pitches.toArray());
                }
            }
        });

        /**
         *@description pitch type listener
         */
        PitchType.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e action event
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                setTypeName((String) PitchType.getSelectedItem());
            }
        });

        /**
         *@description calendar event listener
         */
        FromDate.addCalendarSelectionListener(new CalListen() {
            public void selectionChanged(CalendarEvent arg0) {
                try {
                    setStartDate(dateFormat.format(arg0.getDate()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        /**
         *@description combo box listener
         */
        EndDate.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e action event
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                setFinishDate(EndDate.getSelectedIndex());
            }
        });

        /**
         *@description list listener
         */
        SearchResultList.addListSelectionListener(new ListSelectionListener() {
            /**
             * Called whenever the value of the selection changes.
             *
             * @param e the event that characterizes the change.
             */
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting() == true) {
                    if (isEmpty()) {
                        PitchDetails.setText(null);
                    }
                    setPitchSelected(SearchResultList.getSelectedValue().toString());
                    PitchDetails.append("Pitch name: " + pitches.get(SearchResultList.getSelectedIndex()).getPitchName() + "\n");
                    PitchDetails.append("Pitch type: ");
                    String[] array = pitches.get(SearchResultList.getSelectedIndex()).getTypeName();
                    setBookingPitch(pitches.get(SearchResultList.getSelectedIndex()));
                    for (String E : array) {
                        if (E != null) {
                            PitchDetails.append(E + ", ");
                        }
                    }
                    PitchDetails.append("\n");
                    PitchDetails.append("Start date: " + getStartDate() + "\n");
                    PitchDetails.append("Finish date: " + makeFinishDate(getFinishDate(), getStartDate()).toString() + "\n");
                }
            }
        });

        /**
         *@description button listener
         */
        cancelABookingButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                getBookingDelete().make(bookingDelete);
            }
        });
    }

    /**
     * @description intilise in the parent window
     */
    public static void run() {
        FormBooking dialog = new FormBooking();
        dialog.pack();
        dialog.setTitle("Booking form");
        dialog.setResizable(false);
        dialog.setVisible(true);
        dialog.setLocationRelativeTo(null);
    }

    /**
     * @return gets a booking pitch of type booking pitch
     */
    public Pitch getBookingPitch() {
        return BookingPitch;
    }

    /**
     * @param bookingPitch sets a booking pitch of type pitch
     */
    public void setBookingPitch(Pitch bookingPitch) {
        BookingPitch = bookingPitch;
    }

    /**
     * @return gets a booking customer of type booking client
     */
    public Client getBookingClient() {
        return BookingClient;
    }

    /**
     * @param bookingClient sets a booking customer of type client
     */
    public void setBookingClient(Client bookingClient) {
        BookingClient = bookingClient;
    }

    /**
     * @return gets a search of type dialog search
     */
    public DialogSearch getSearch() {
        return search;
    }

    /**
     * @return gets a string of type pitch selected
     */
    public String getPitchSelected() {
        return PitchSelected;
    }

    /**
     * @param pitchSelected sets a string of type pitch selected
     */
    public void setPitchSelected(String pitchSelected) {
        PitchSelected = pitchSelected;
    }

    /**
     * @param day   int day
     * @param Start string date (format yyyy-MM-dd)
     * @return a date of type Date is returned
     */
    public String makeFinishDate(int day, String Start) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(dateFormat.parse(Start));
            calendar.add(Calendar.DATE, day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFormat.format(calendar.getTime());
    }

    /**
     * @param Start string date (format yyyy-MM-dd)
     * @return a date of type Date is returned
     */
    public Date makeStartDate(String Start) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(dateFormat.parse(Start));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar.getTime();
    }

    /**
     * @return gets an int of type finish date (e.g. 1)
     */
    public int getFinishDate() {
        return FinishDate;
    }

    /**
     * @param finishDate sets an int of type finish date (e.g. 1 day)
     */
    public void setFinishDate(int finishDate) {
        FinishDate = finishDate;
    }

    /**
     * @return gets a string of type start date (format yyy-MM-dd)
     */
    public String getStartDate() {
        return StartDate;
    }

    /**
     * @param startDate sets a string of type start date
     */
    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    /**
     * @return gets a string of type name
     */
    public String getTypeName() {
        return TypeName;
    }

    /**
     * @param typeName sets a string of type name
     */
    public void setTypeName(String typeName) {
        TypeName = typeName;
    }

    /**
     * @return gets a text area field of pitch details
     */
    public JTextArea getPitchDetails() {
        return PitchDetails;
    }

    /**
     * @param pitchDetails sets a text area field of pitch details
     */
    public void setPitchDetails(JTextArea pitchDetails) {
        PitchDetails = pitchDetails;
    }

    /**
     * @return gets the status of a booking extend window
     */
    public DialogExtendBooking getBookingCheck() {
        return bookingCheck;
    }

    /**
     * @param bookingCheck sets a booking extending window of type DialogExtendingBooking
     */
    public void setBookingCheck(DialogExtendBooking bookingCheck) {
        this.bookingCheck = bookingCheck;
    }

    /**
     * @return gets the status of a booking delete window
     */
    public DialogDeleteBooking getBookingDelete() {
        return bookingDelete;
    }

    /**
     * @param bookingDelete sets a booking delete window status of type DialogDeleteBooking
     */
    public void setBookingDelete(DialogDeleteBooking bookingDelete) {
        this.bookingDelete = bookingDelete;
    }

    /**
     * @description remove this window
     */
    private void onOK() {
// add your code here
        dispose();
    }

    /**
     * @description remove this window
     */
    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    /**
     * @return boolean value returned to test a pitches details
     */
    private boolean isEmpty() {
        String tmp = PitchDetails.getText().trim();
        if ((tmp != null) && (tmp.trim().length() > 0)) {
            return true;
        }
        return false;
    }
}
