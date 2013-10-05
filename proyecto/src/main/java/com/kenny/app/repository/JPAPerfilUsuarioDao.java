package com.kenny.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kenny.app.domain.PerfilUsuario;
@Repository(value="PerfilUsuarioDao")
public class JPAPerfilUsuarioDao implements PerfilUsuarioDao{

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
	public List<PerfilUsuario> getPerfilesList() {
    	return em.createQuery("select p from PerfilUsuario p ").getResultList();

	}

}
