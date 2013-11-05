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
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
public class BookingForm {
    private JPanel Panel;
    private JButton pitchListButton;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private CalendarPane Cal;
    private JList list1;
    private JPanel CalendarPane;

    public BookingForm() {
        Cal.addCalendarSelectionListener(new CalListen(){
            public void selectionChanged(CalendarEvent arg0) {
                try {
                    System.out.println(arg0.getDate());
                } catch (Exception e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        });
        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println("selected");
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        pitchListButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent arg0) {
                try {
                    ArrayList<String> myList = new ArrayList<String>();
                    List<Pitch> mac = new PitchList().Items();
                    List<Client> cac = new ClientList().Items();
                    List<Booking> tac = new BookingList().Items();

                    for (Pitch D : mac) {
                        myList.add(D.getPitchName());
                        if (textArea1.getLineCount() > mac.size()) {
                            textArea1.setText(null);
                        }
                        textArea1.append(D.getPitchName() + "\n");
                    }
                    for (Client E : cac) {
                        myList.add(E.getFirstName());
                        if (textArea2.getLineCount() > cac.size()) {
                            textArea2.setText(null);
                        }
                        textArea2.append(E.getFirstName() + "\n");
                    }
                    for (Booking F : tac) {
                        myList.add(F.getFrom().toString());
                        if (textArea3.getLineCount() > tac.size()) {
                            textArea3.setText(null);
                        }
                        textArea3.append(F.getFrom().toString() + "\n");
                    }
                    list1.setListData(cac.toArray());
                } catch (Exception e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        });
    }

    public void run() {
        JFrame frame = new JFrame("BookingForm");
        frame.setContentPane(new BookingForm().Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
