package com.kenny.app.repository;

import java.util.List;

import com.kenny.app.domain.Usuario;

public interface UsuarioDao {

    public List<Usuario> getUsuarioList();
    public List<Usuario> getUsuarioListByUsuario(int usuario_id);

    public void saveUsuario(Usuario usuario);
    
    public Usuario getUsuarioAuthentication(Usuario usuario);
    
    public Usuario getUsuarioByUsername(Usuario usuario);
    
    public Usuario getUsuarioByDocnum(Usuario usuario);

}