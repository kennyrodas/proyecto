package com.kenny.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kenny.app.domain.ProyectoRegion;
@Repository (value = "ProyectoRegionDao")
public class JPAProyectoRegionDao implements ProyectoRegionDao {

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
	public List<ProyectoRegion> getProyectoRegionList(int proyecto_id) {
        return em.createQuery("select p from ProyectoRegion p WHERE p.proyecto_id = '"+proyecto_id+"'").getResultList();
	}

    @Transactional(readOnly = false)
	public ProyectoRegion save(ProyectoRegion proyectoRegion) {
		// ProyectoRegion = em.merge(proyectoRegion);
    	System.err.println( proyectoRegion.toString());
    	em.persist(proyectoRegion);
		 return proyectoRegion;
	}

}
