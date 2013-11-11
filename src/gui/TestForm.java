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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestForm {
    private JPanel Panel;
    private JButton pitchListButton;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private CalendarPane Cal;
    private JList list1;
    private JPanel CalendarPane;
    private JButton button1;
    private SimpleDateFormat dF = new SimpleDateFormat("yyyy-MM-dd");
    public TestForm() {
        Cal.addCalendarSelectionListener(new CalListen() {
            public void selectionChanged(CalendarEvent arg0) {
                try {
                    System.out.println(arg0.getDate());
                } catch (Exception e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        });

        pitchListButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent arg0) {
                try {
                    ArrayList<String> myList = new ArrayList<String>();
                    ArrayList<String[]> myListToo = new ArrayList<String[]>();
                    List<Pitch> mac = new PitchList().Items();
                    List<Client> cac = new ClientList().Items();
                    List<Booking> tac = new BookingList().Items();

                    for (Pitch D : mac) {
                        myListToo.add(D.getTypeName());
                        if (textArea1.getLineCount() > mac.size()) {
                            textArea1.setText(null);
                        }
                        textArea1.append(Arrays.toString(D.getTypeName()) + "\n");
                    }
                    for (Client E : cac) {
                        myList.add(E.getFirstName());
                        if (textArea2.getLineCount() > cac.size()) {
                            textArea2.setText(null);
                        }
                        textArea2.append(E.getFirstName() + "\n");
                    }
                    for (Booking F : tac) {
                        myList.add(F.getFromDate().toString());
                        if (textArea3.getLineCount() > tac.size()) {
                            textArea3.setText(null);
                        }
                        textArea3.append(dF.format(F.getFromDate()) + "\n");
                    }
                    list1.setListData(cac.toArray());
                    DialogSearch tester = new DialogSearch(cac);
                    //tester.setList(cac);
                    tester.make(cac);
                } catch (Exception e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        });
        button1.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new TestCustomerForm().make();
                } catch (Exception e1) {
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        });
    }

    public void run() {
        JFrame frame = new JFrame("TestForm");
        frame.setContentPane(new TestForm().Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
