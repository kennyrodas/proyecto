package com.kenny.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kenny.app.domain.ProyectoUsuario;
@Repository (value = "ProyectoUsuarioDao")
public class JPAProyectoUsuario implements ProyectoUsuarioDao {

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
	public List<ProyectoUsuario> getProyectoUsuarioList(int proyecto_id) {
        return em.createQuery("select p from ProyectoUsuario p WHERE p.proyecto_id = '"+proyecto_id+"'").getResultList();
	}

    @Transactional(readOnly = false)
	public ProyectoUsuario save(ProyectoUsuario proyectousuario) {
		// proyectousuario = em.merge(proyectousuario);
    	System.err.println( proyectousuario.toString());
    	em.persist(proyectousuario);
		 return proyectousuario;
	}

}
