package camp;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 19/11/2013
 * Time: 20:57
 */
public class Communication {

    public Communication() {

    }

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
}
