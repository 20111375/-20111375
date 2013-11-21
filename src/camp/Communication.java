/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 19/11/2013
 * Time: 20:57
 */
package camp;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Communication {

    /**
     * @description class constructor
     */
    public Communication() {

    }

    /**
     * @param E
     */
    public void emailer(Booking E, Client F, String G) {
        final String username = "campadoodledoo@gmail.com";
        final String PassWord = "this-is-the-password";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, PassWord);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("campadoodledoo@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(G));
            message.setSubject("Booking reservation");
            message.setText("Hello" + F.getFirstName() + "\n" +
                    "Thank you for your picking Camp-a-doodle-doo, your reservation details are: " + "\n" +
                    "Start Date:" + E.getFromDate() + "\n" +
                    "Finish Date " + E.getToDate() + "\n" +
                    "Pitch number: " + E.getPitchID() + "\n" +
                    "Total Cost: £" + E.getTotal() + "\n" +
                    "Once again thank you and we hope you have a good stay.");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param E
     * @throws IOException
     */
    public void pdfer(Booking E, Client F) {

        final String OutPut = "./PDF/demo.pdf";
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(OutPut));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        document.open();
        try {
            document.add(new Paragraph("Hello " + F.getFirstName() + "\n" +
                    "Thank you for your picking Camp-a-doodle-doo, your reservation details are: " + "\n" +
                    "Start Date:" + E.getFromDate() + "\n" +
                    "Finish Date " + E.getToDate() + "\n" +
                    "Pitch number: " + E.getPitchID() + "\n" +
                    "Total Cost: £" + E.getTotal() + "\n" +
                    "Once again thank you and we hope you have a good stay."));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        document.close();
    }
}