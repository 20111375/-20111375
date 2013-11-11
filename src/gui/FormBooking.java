package gui;

import com.jcalendar.event.CalendarEvent;
import com.jcalendar.pane.calendar.CalendarPane;
import javax.swing.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Andrew on 07/11/13.
 */
public class FormBooking {
    private JComboBox PitchType;
    private JList SearchResultList;
    private JButton SearchButton;
    private JButton FindCustomerButton;
    private JButton NewCustomerButton;
    private JButton ConfirmButton;
    private JButton extendABookingButton;
    private JTextPane CustomerDetails;
    private JTextPane PitchDetails;
    private JComboBox EndDate;
    private CalendarPane FromDate;
    private JPanel ReservationPane;
    private JPanel ExtendBooking;
    private JPanel FormBooking;
    private String TypeName;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String StartDate = null;
    private int FinishDate;

    public String makeFinishDate(int day, String Start){
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(dateFormat.parse(Start));
            calendar.add(Calendar.DATE,day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFormat.format(calendar.getTime());
    }

    public int getFinishDate() {
        return FinishDate;
    }

    public void setFinishDate(int finishDate) {
        FinishDate = finishDate;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String typeName) {
        TypeName = typeName;
    }


    public JTextPane getPitchDetails() {
        return PitchDetails;
    }

    public void setPitchDetails(JTextPane pitchDetails) {
        PitchDetails = pitchDetails;
    }

    public JTextPane getCustomerDetails() {
        return CustomerDetails;
    }

    public void setCustomerDetails(JTextPane customerDetails) {
        CustomerDetails = customerDetails;
    }

    public FormBooking() {
        extendABookingButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        ConfirmButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        NewCustomerButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        FindCustomerButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        SearchButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if(StartDate != null && FinishDate != 0 && TypeName != null){
                    String tempTime = makeFinishDate(getFinishDate(), getStartDate());
                    System.out.println("This is the type: " + getTypeName());
                    System.out.println("This is the start date: " + getStartDate());
                    System.out.println("This is the end date: " + tempTime.toString());
                }
                //To change body of implemented methods use File | Settings | File Templates.
                // query db with start date, end date and pitch type
            }
        });
        PitchType.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                setTypeName((String) PitchType.getSelectedItem());
            }
        });
        FromDate.addCalendarSelectionListener(new CalListen() {
            public void selectionChanged(CalendarEvent arg0) {
                try {
                    setStartDate(dateFormat.format(arg0.getDate()));
                    //System.out.println(getStartDate());
                } catch (Exception e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        });
        EndDate.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
              setFinishDate(EndDate.getSelectedIndex());
               //System.out.println(getFinishDate());
            }
        });

    }

    public void run() {
        JFrame frame = new JFrame("FormBooking");
        frame.setContentPane(new FormBooking().FormBooking);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
