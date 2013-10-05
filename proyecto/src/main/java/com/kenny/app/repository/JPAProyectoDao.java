package com.kenny.app.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kenny.app.domain.Proyecto;
@Repository (value = "ProyectoDao")
public class JPAProyectoDao implements ProyectoDao {

	private EntityManager em = null;

    /*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public List<Proyecto> getProyectoList() {
		// TODO Auto-generated method stub
		return em.createQuery("select p from Proyecto p").getResultList();
	}

    @Transactional(readOnly = false)
	public Proyecto saveProyecto(Proyecto proyecto) {
		proyecto = em.merge(proyecto);
		return proyecto;	    

	}

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public Proyecto getProyectoById(int id) {
		List<Proyecto> proyectoList = new ArrayList<Proyecto>();
        Query query = em.createQuery("select p from Proyecto p where p.proyectoId='"+id+"'");
        proyectoList = query.getResultList();
        if(proyectoList.size() > 0)
        	return proyectoList.get(0);
        else
        	return null;
    
	}

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public List<Proyecto> getProyectoListByUsuario(int usuario_id) {
		// TODO Auto-generated method stub
		return em.createQuery("select p from Proyecto p, ProyectoUsuario pu WHERE pu.proyectoId = p.proyectoId AND pu.usuario_id = '"+usuario_id+"'").getResultList();

	}

}
