package com.kenny.app.service;

import java.io.Serializable;
import java.util.List;

import com.kenny.app.domain.Proyecto;

public interface ProyectoManager extends Serializable{
	public List<Proyecto> getProyectosList();
	public Proyecto save(Proyecto proyecto);
	public Proyecto getById(int id);
}
