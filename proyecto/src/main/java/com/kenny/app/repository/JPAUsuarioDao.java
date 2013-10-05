package com.kenny.app.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kenny.app.domain.Usuario;

@Repository(value = "usuarioDao")
public class JPAUsuarioDao implements UsuarioDao {

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
    public List<Usuario> getUsuarioList() {
        return em.createQuery("select p from Usuario p order by p.id").getResultList();
    }

    @Transactional(readOnly = false)
    public void saveUsuario(Usuario user) {
        em.persist(user);
    }
    
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public Usuario getUsuarioAuthentication(Usuario usuario) {
    	List<Usuario> userList = new ArrayList<Usuario>();
        Query query = em.createQuery("select p from Usuario p where p.usuario=:usuario and p.clave=:clave order by p.id");
        query.setParameter("usuario", usuario.getUsuario()).setParameter("clave", usuario.getClave());
        userList = query.getResultList();
        if(userList.size() > 0)
        	return userList.get(0);
        else
        	return null;
    }
    
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public Usuario getUsuarioByUsername(Usuario usuario) {
    	List<Usuario> userList = new ArrayList<Usuario>();
        Query query = em.createQuery("select p from Usuario p where p.usuario=:usuario order by p.id");
        query.setParameter("usuario", usuario.getUsuario());
        userList = query.getResultList();
        if(userList.size() > 0)
        	return userList.get(0);
        else
        	return null;
    }
    
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public Usuario getUsuarioByDocnum(Usuario usuario) {
    	List<Usuario> userList = new ArrayList<Usuario>();
        Query query = em.createQuery("select p from Usuario p where p.docnum=:docnum order by p.id");
        query.setParameter("docnum", usuario.getDocnum());
        userList = query.getResultList();
        if(userList.size() > 0)
        	return userList.get(0);
        else
        	return null;
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public List<Usuario> getUsuarioListByUsuario(int usuario_id) {
    	System.err.println("select p from Usuario p order by p.id WHERE p.padreId = '"+usuario_id+"'");
        return em.createQuery("select p from Usuario p  WHERE p.padreId = '"+usuario_id+"'").getResultList();

	}

}