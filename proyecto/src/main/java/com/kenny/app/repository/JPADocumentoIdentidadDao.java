package com.kenny.app.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kenny.app.domain.DocumentoIdentidad;
import com.kenny.app.domain.Usuario;

@Repository(value = "documentoIdentidadDao")
public class JPADocumentoIdentidadDao implements DocumentoIdentidadDao {
	
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
	public List<DocumentoIdentidad> getDocumentoIdentidadList() {
    	return em.createQuery("select d from DocumentoIdentidad d order by d.id").getResultList();
	}
    
    @Transactional(readOnly = false)
    public void saveDocumentoIdentidad(DocumentoIdentidad documentoIdentidad) {
    	em.persist(documentoIdentidad);
	}
    
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public DocumentoIdentidad getDocumentoIdentidadById(DocumentoIdentidad documentoIdentidad) {
    	List<DocumentoIdentidad> documentoIdentidadList = new ArrayList<DocumentoIdentidad>();
        Query query = em.createQuery("select d from DocumentoIdentidad d where d.documento_identidad_id=:id order by d.documento_identidad_id");
        query.setParameter("id", documentoIdentidad.getDocumentoIdentidadId());
        documentoIdentidadList = query.getResultList();
        if(documentoIdentidadList.size() > 0)
        	return documentoIdentidadList.get(0);
        else
        	return null;
    }
}
