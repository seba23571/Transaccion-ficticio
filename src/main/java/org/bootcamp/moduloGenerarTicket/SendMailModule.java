package org.bootcamp.moduloGenerarTicket;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMailModule {
    private String mailSender ;//= "facturaciontimbradomx@gmail.com";
    private String password = "gsewqmosqqcloway";
    private String mailReceptor ; //= "sebastian.esteban266@gmail.com";

    private String textoTicket;


    public SendMailModule(String mailSender, String mailReceptor, String textoTicket) {
        this.mailSender = mailSender;
        this.mailReceptor = mailReceptor;
        this.textoTicket = textoTicket;
    }

    public void sendMailTicket(){
    Properties prop = new Properties();
    prop.put("mail.smtp.host", "smtp.gmail.com");
    prop.put("mail.smtp.port", "587");
    prop.put("mail.smtp.auth", "true");
    prop.put("mail.smtp.starttls.enable", "true"); //TLS

    Session session = Session.getInstance(prop,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(mailSender, password);
                }
            });

    try {

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("facturaciontimbradomx@gmail.com"));
        message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(mailSender+","+mailReceptor)
        );
        //                    InternetAddress.parse(username, Boolean.parseBoolean(mailReceptor))
        message.setSubject("Practicas Ticket Bootcamp Koding ");
        //  message.setText("Dear Mail Crawler,"                    + "\n\n Please do not spam my email!");

        message.setContent(
                this.textoTicket ,
                "text/html");

        Transport.send(message);

        System.out.println("Done");

    } catch (MessagingException e) {
        e.printStackTrace();
    }

}

}
