package com.kenny.app.service;

import java.util.List;
//import com.kenny.app.mail.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/*
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
*/
import com.kenny.app.domain.Usuario;
import com.kenny.app.repository.UsuarioDao;

@Component
public class SimpleUsuarioManager implements UsuarioManager {

    private static final long serialVersionUID = 1L;
    //private JavaMailSender mailSender;
    
    @Autowired
    private MailSender mailSender;
    @Autowired
    private SimpleMailMessage templateMessage;
    
    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setTemplateMessage(SimpleMailMessage templateMessage) {
        this.templateMessage = templateMessage;
    }
    
    @Autowired
    private UsuarioDao usuarioDao;

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public List<Usuario> getUsuarios() {
    	return usuarioDao.getUsuarioList();
    }
    
    public void registraUsuario(Usuario usuario) {
		usuarioDao.saveUsuario(usuario);
	}
    
    public Usuario getUsuarioAuthentication(Usuario usuario) {
		return usuarioDao.getUsuarioAuthentication(usuario);
	}

	public Usuario getUsuarioByUsername(Usuario usuario) {
		return usuarioDao.getUsuarioByUsername(usuario);
	}
	
	public Usuario getUsuarioByDocnum(Usuario usuario) {
		return usuarioDao.getUsuarioByDocnum(usuario);
	}

	public List<Usuario> getUsuariosByUsuario(int usuario_id) {
		return usuarioDao.getUsuarioListByUsuario(usuario_id);
	}
	
	public void sendEmailConfirmation(final Usuario usuario) {
		
		// Create a thread safe "copy" of the template message and customize it
		SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
        msg.setTo("alancitus@gmail.com");
        msg.setText(
            "Dear Alancitus"
                + ", Gracias por registrarte en GID. Tu codigo es 53442");
        try{
            this.mailSender.send(msg);
        }
        catch(MailException ex) {
        	System.err.println("NO ENVIO EL MAIL!!!!!!!!!!!!!!!!!!!!!");
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }
        
        /*
		//Get the mailer instance
        ApplicationMailer mailer = new ApplicationMailer();
 
        //Send a composed mail
        mailer.sendMail("kennyrodas@gmail.com", "Test Subject", "Testing body");
        */
        
        //Send a pre-configured mail
        //mailer.sendPreConfiguredMail("Exception occurred everywhere.. where are you ????");
        
		/*
		MimeMessagePreparator preparator = new MimeMessagePreparator() {

            public void prepare(MimeMessage mimeMessage) throws Exception {

                mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(usuario.getCorreo()));
                mimeMessage.setFrom(new InternetAddress("krodas@usil.edu.pe"));
                mimeMessage.setText(
                    "Dear " + usuario.getNombre() + " "
                        + usuario.getApellido()
                        + ", thank you for placing order. Your order number is "
                        + usuario.getUsuario());
            }
        };
        try {
            this.mailSender.send(preparator);
        } catch (MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }
        */
	}
}