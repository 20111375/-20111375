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
import java.util.Properties;

/**
 * class definition
 * communication provides methods for printing and email
 */
public class Communication {

    /**
     * class constructor
     */
    public Communication() {

    }

    /**
     * @param E booking object
     * @param F client object
     * @param G string value of email address
     *          accepts booking details, customer details and customer email address
     */
    public void emailer(Booking E, Client F, String G) {
        final String username = "campadoodledoo@gmail.com";
        final String PassWord = "";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        //if the password variable isn't passed don't try to make a message
        if (!PassWord.isEmpty()) {
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, PassWord);
                }
            });
            //try to setup email message and send it.
            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("campadoodledoo@gmail.com"));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(G));
                message.setSubject("Booking reservation");
                message.setText("Hello" + F.getFirstName() + "\n" +
                        "Thank you for picking High farm, your reservation details are: " + "\n" +
                        "Customer ID: " + E.getClientID() + "\n" +
                        "Pitch ID: " + E.getPitchID() + "\n" +
                        "Start Date:" + E.getFromDate() + "\n" +
                        "Finish Date " + E.getToDate() + "\n" +
                        "Pitch number: " + E.getPitchID() + "\n" +
                        "Total Cost: " + E.getTotal() + "\n" +
                        "Once again thank you and we hope you have a good stay.");
                Transport.send(message);
            } catch (MessagingException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * @param E accepts a booking object
     * @param F accepts a client object
     */
    public void pdfer(Booking E, Client F) {
        final String OutPut = "./PDF/demo.pdf";// define a static location for all pdf files
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
                    "Thank you for picking High farm, your reservation details are: " + "\n" +
                    "Customer ID: " + E.getClientID() + "\n" +
                    "Pitch ID: " + E.getPitchID() + "\n" +
                    "Start Date:" + E.getFromDate() + "\n" +
                    "Finish Date " + E.getToDate() + "\n" +
                    "Pitch number: " + E.getPitchID() + "\n" +
                    "Total Cost: " + E.getTotal() + "\n" +
                    "Once again thank you and we hope you have a good stay."));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        document.close();
    }
}