package com.kenny.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kenny.app.domain.Pais;
@Repository (value="PaisDao")
public class JPAPaisDao implements PaisDao {
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
	public List<Pais> getListPaises() {
		return em.createQuery("select p from Pais p ").getResultList();
	}

}
