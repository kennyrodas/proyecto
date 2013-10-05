package com.kenny.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kenny.app.domain.Objetivo;
@Repository (value="ObjetivoDao")
public class JPAObjetivoDao implements ObjetivoDao {
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
	public List<Objetivo> getObjetivoList(int proyecto_id) {
	    	List<Objetivo> objetivos= em.createQuery("select p from Objetivo p WHERE p.proyectoId = '"+proyecto_id+"' order by p.tipoObjetivoId, p.codigo").getResultList();
	    	for (Objetivo objetivo : objetivos) {
				switch (objetivo.getTipoObjetivoId()) {
				case 1:	
					objetivo.setTipoobjetivo2("finalidad");
					break;
				case 2:	
					objetivo.setTipoobjetivo2("proposito");
						break;
				case 3:	
					objetivo.setTipoobjetivo2("resultado");				
					break;

				default:
					break;
				}
			}
	    	return objetivos;

	}

	    @Transactional(readOnly = false)
	public Objetivo save(Objetivo objetivo) {
		return em.merge(objetivo);

	}
	@Transactional(readOnly = false)
	public int actualizarCodigos(int codigo_id, int tipo) {
		if(tipo ==1 ){
			return	em.createQuery("UPDATE Objetivo SET codigo = codigo + 1 WHERE codigo >="+codigo_id).executeUpdate();
		}else{
			return	em.createQuery("UPDATE Objetivo SET codigo = codigo - 1 WHERE codigo >"+codigo_id).executeUpdate();

		}
	}
	@Transactional(readOnly = false)
	public int eliminar(int objetivo_id){
		return em.createQuery("delete Objetivo where objetivoId = '"+objetivo_id+"'").executeUpdate();
	}
	@Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public Objetivo getById(int objetivo_id) {
		return (Objetivo) em.createQuery("select p from Objetivo p WHERE p.objetivoId = '"+objetivo_id+"'").getSingleResult();

	}

}
