package com.kenny.app.repository;
import java.util.List;

import com.kenny.app.domain.Proyecto;
public interface ProyectoDao {

    public List<Proyecto> getProyectoList();
    public List<Proyecto> getProyectoListByUsuario(int usuario_id);
    public Proyecto saveProyecto(Proyecto proyecto);
    public Proyecto getProyectoById(int id);

}
