package com.kenny.app.service;

import java.io.Serializable;
import java.util.List;

import com.kenny.app.domain.Usuario;

public interface UsuarioManager extends Serializable {
	
	public void registraUsuario(Usuario usuario);
    
    public List<Usuario> getUsuarios();
    public List<Usuario> getUsuariosByUsuario(int usuario_id);
    
    public Usuario getUsuarioAuthentication(Usuario usuario);
    
    public Usuario getUsuarioByUsername(Usuario usuario);
    
    public Usuario getUsuarioByDocnum(Usuario usuario);
    
    public void sendEmailConfirmation(Usuario usuario);

}
