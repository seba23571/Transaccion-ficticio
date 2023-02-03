package org.bootcamp.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmailTLS {

    public static void main(String[] args) {

        final String username = "facturaciontimbradomx@gmail.com";
        final String password = "gsewqmosqqcloway";
        final String mailReceptor ="sebastian.esteban266@gmail.com";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("facturaciontimbradomx@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(username+","+mailReceptor)
            );
            //                    InternetAddress.parse(username, Boolean.parseBoolean(mailReceptor))
            message.setSubject("Practicas Bootcamp Koding");
          //  message.setText("Dear Mail Crawler,"                    + "\n\n Please do not spam my email!");

            message.setContent(
                    "<h1>This is actual message embedded in HTML tags</h1>",
                    "text/html");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}