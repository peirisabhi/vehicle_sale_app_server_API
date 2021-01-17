/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mail;

import java.util.Properties;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author abhi
 */
public class Mail {

    public static void sendMail(String to, String subject, String msg) {

        final String username = "your email addrees";
        final String password = "your password";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new javax.mail.PasswordAuthentication(username, password);
                    }
                });

        try {

            javax.mail.Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("info.cms.sl@gmail.com"));
            message.setRecipients(
                    javax.mail.Message.RecipientType.TO,
                    InternetAddress.parse(to)
            );
            message.setSubject(subject);
            message.setText(msg);
            message.setContent(msg,"text/html");

            javax.mail.Transport.send(message);

            System.out.println("Done");

        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }

    }
    
    
    public static void main(String[] args) {
        sendMail("aasas9@gmail.com", "test", "test");
    }
    
}
