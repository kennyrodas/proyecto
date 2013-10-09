package com.kenny.app.service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

import com.kenny.app.domain.Usuario;

public class SimpleUtilEmailManager implements UtilEmailManager {
	
	private JavaMailSender mailSender;
	
	public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
	
	public void send(final Usuario usuario){
		
		MimeMessagePreparator preparator = new MimeMessagePreparator() {

            public void prepare(MimeMessage mimeMessage) throws Exception {

                mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress("kennyrodas@gmail.com"));
                mimeMessage.setFrom(new InternetAddress("mail@mycompany.com"));
                mimeMessage.setText(
                    "Dear " + usuario.getNombre() + " "
                        + usuario.getApellido()
                        + ", thank you for placing order. Your order number is "
                        + usuario.getClave());
            }
        };
        try {
            this.mailSender.send(preparator);
        }
        catch (MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }
		
	}
}
