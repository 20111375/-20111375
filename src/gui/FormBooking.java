package gui;

import com.jcalendar.event.CalendarEvent;
import com.jcalendar.pane.calendar.CalendarPane;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import camp.*;

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
    private JTextArea CustomerDetails;
    private JTextArea PitchDetails;
    private JComboBox EndDate;
    private CalendarPane FromDate;
    private JPanel ReservationPane;
    private JPanel ExtendBooking;
    private JPanel FormBooking;
    private JPanel BookForm;
    private String TypeName;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String StartDate = null;
    private int FinishDate;
    private String PitchSelected;
    private List<Pitch> mac = null;
    public String getPitchSelected() {
        return PitchSelected;
    }

    public void setPitchSelected(String pitchSelected) {
        PitchSelected = pitchSelected;
    }

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

                    /*
                    System.out.println("This is the type: " + getTypeName());
                    System.out.println("This is the start date: " + getStartDate());
                    System.out.println("This is the end date: " + tempTime.toString());
                    */

                    try {
                        mac = new PitchList().Items(getStartDate(),tempTime.toString(),getTypeName());
                    } catch (Exception e1) {
                        e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                    SearchResultList.setListData(mac.toArray());

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

        SearchResultList.addListSelectionListener(new ListSelectionListener() {
            /**
             * Called whenever the value of the selection changes.
             *
             * @param e the event that characterizes the change.
             */
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
                if (e.getValueIsAdjusting() == true) {
                    setPitchSelected(SearchResultList.getSelectedValue().toString());
                    PitchDetails.append("Pitch name: " + mac.get(SearchResultList.getSelectedIndex()).getPitchName() + "\n");
                    PitchDetails.append("Pitch type: ");
                    String[] array = mac.get(SearchResultList.getSelectedIndex()).getTypeName();
                    for(String E : array)  {
                        if (E != null) {
                            PitchDetails.append(E + ", ");
                            System.out.println(E + "\n");
                        }
                    }
                    PitchDetails.append("\n");
                    PitchDetails.append("Start date: "+ getStartDate() + "\n");
                    PitchDetails.append("Finish date: "+ makeFinishDate(getFinishDate(), getStartDate()).toString() + "\n");
                }
            }
        });
    }

    public void run() {
        JFrame frame = new JFrame("FormBooking");
        frame.setResizable(false);
        frame.setContentPane(new FormBooking().FormBooking);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
