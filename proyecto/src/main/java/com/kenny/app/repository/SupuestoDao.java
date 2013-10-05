package com.kenny.app.repository;

import java.util.List;

import com.kenny.app.domain.Supuesto;

public interface SupuestoDao {
public List<Supuesto> getSupuestosByObjetivo(int objetivo_id);
public Supuesto save(Supuesto supuesto);
public int eliminar(int supuesto_id) ;
}
