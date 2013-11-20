/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 19/11/2013
 * Time: 20:57
 */
package camp;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
    public void emailer(Booking E) {
        final String username = "campadoodledoo@gmail.com";
        final String password = "";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("campadoodledoo@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("a@b.com"));
            message.setSubject("Booking reservation");
            message.setText("Dear ,"
                    + "\n\n Your campsite pitch awaits.");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param E
     * @throws IOException
     */
    public void pdfer(Booking E) throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        PDFont font = PDType1Font.HELVETICA_BOLD;

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        contentStream.beginText();
        contentStream.setFont(font, 10);
        contentStream.moveTextPositionByAmount(100, 700);
        contentStream.drawString("Hello");
        contentStream.endText();
        contentStream.close();

        try {
            document.save("../~20111375/PDF/demo.pdf");
        } catch (COSVisitorException e) {
            e.printStackTrace();
        }
        document.close();
    }
}