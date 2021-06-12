package com.company;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

class Mail {
    //Variablen
    private final Properties prop = new Properties();
    private String email;

    void TerminGefunden(String url){
        try {
            //Mail Server Properties Google
            prop.put("mail.transport.protocol", "smtps");
            prop.put("mail.smtps.host", "smtp.gmail.com");
            prop.put("mail.smtps.auth", "true");
            //Einstellungen vornehmen
            Session mailSession = Session.getDefaultInstance(prop);
            mailSession.setDebug(true);
            Transport transport = mailSession.getTransport();
            //Email verfassen
            MimeMessage message = new MimeMessage(mailSession);
            message.setSubject("EIN MÖGLICHER IMPFTERMIN WURDE GEFUNDEN");
            message.setContent("Es wurde ein möglicher Impftermin gefunden. Schau hierzu auf den Browser auf deinem Computer. Hier nochmals der Link: " + url, "text/plain");
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email)); //Empfänger
            //Anmelden
            transport.connect
                    ("smtp.gmail.com", 465, "Sender@gmail.com", "password");    //letzten beide Attribute "email", "password"
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));                  //Benutzerinformationen des sendenden Kontos
            transport.close();

            Thread.sleep(300000);

        } catch(Exception EmailNichtGeschickt){
            System.out.println("\u001b[31m" + "Error: " + "Email konnte nicht verschickt werden" + "\u001b[0m");
        }
    }

    //Konstruktor
    Mail() {
        //Mail Server Properties Google
        prop.put("mail.transport.protocol", "smtps");
        prop.put("mail.smtps.host", "smtp.gmail.com");
        prop.put("mail.smtps.auth", "true");
        email = "";
    }

    //Getters und Setters
    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }
}
