package com.kenny.app.service;

import java.security.MessageDigest;
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
	
	public void sendEmailConfirmation(final Usuario usuario, String dominio) {
		
		String id = String.valueOf(usuario.getId());
		SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
		String mensaje = "";
		String idencriptado = "";
		try {
			idencriptado = md5(id);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		mensaje = "Estimado "+ usuario.getNombre() + ", \n"
			    + "gracias por registrarte en GID."
			    + "Para poder activar su cuenta ingrese al siguiente enlace:"
			    + "http://" + dominio + "/proyecto/activarcuenta/" + usuario.getUsuario() + "/" + idencriptado;
		
		// Create a thread safe "copy" of the template message and customize it
		msg.setTo(usuario.getCorreo());
		msg.setText( mensaje );
		
		
		try{
			System.out.println(mensaje);
            //this.mailSender.send(msg);
        }
        catch(MailException ex) {
        	System.err.println("NO ENVIO EL MAIL!!!!!!!!!!!!!!!!!!!!!");
            System.err.println(ex.getMessage());
        }
        
	}
	
	public Boolean validEmailConfirmation(Usuario usuario, String idencriptado) {
		
		String id = String.valueOf(usuario.getId());
		String idencriptadobd = "";
		try {
			idencriptadobd = md5(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idencriptado.equals(idencriptadobd);
	}
	
	private static String md5(String clear) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] b = md.digest(clear.getBytes());

		int size = b.length;
		StringBuffer h = new StringBuffer(size);
		for (int i = 0; i < size; i++) {
			int u = b[i] & 255;
			if (u < 16) {
				h.append("0" + Integer.toHexString(u));
			} else {
				h.append(Integer.toHexString(u));
			}
		}
		return h.toString();
	}
	
}