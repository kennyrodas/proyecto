package com.kenny.app.service;

import java.io.Serializable;
import java.util.List;

import com.kenny.app.domain.PerfilUsuario;

public interface PerfilUsuarioManager extends Serializable{
public List<PerfilUsuario> getPerfiles();
}
