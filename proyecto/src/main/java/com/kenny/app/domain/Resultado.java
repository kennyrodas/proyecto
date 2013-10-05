/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kenny.app.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Gemelas
 */
@Entity
@Table(name = "resultado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resultado.findAll", query = "SELECT r FROM Resultado r"),
    @NamedQuery(name = "Resultado.findByResultadoId", query = "SELECT r FROM Resultado r WHERE r.resultadoId = :resultadoId"),
    @NamedQuery(name = "Resultado.findByObjetivoId", query = "SELECT r FROM Resultado r WHERE r.objetivoId = :objetivoId"),
    @NamedQuery(name = "Resultado.findByNombre", query = "SELECT r FROM Resultado r WHERE r.nombre = :nombre")})
public class Resultado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "resultado_id")
    private Integer resultadoId;
    @Column(name = "objetivo_id")
    private Integer objetivoId;
    @Size(max = 10)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "resultadoId", fetch = FetchType.EAGER)
    @OrderBy("padreActividadId")
   private Set<Actividad> actividadSet;

    public Resultado() {
    }

    public Resultado(Integer resultadoId) {
        this.resultadoId = resultadoId;
    }

    public Integer getResultadoId() {
        return resultadoId;
    }

    public void setResultadoId(Integer resultadoId) {
        this.resultadoId = resultadoId;
    }

    public Integer getObjetivoId() {
        return objetivoId;
    }

    public void setObjetivoId(Integer objetivoId) {
        this.objetivoId = objetivoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Set<Actividad> getActividadSet() {
        return actividadSet;
    }

    public void setActividadSet(Set<Actividad> actividadSet) {
        this.actividadSet = actividadSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resultadoId != null ? resultadoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resultado)) {
            return false;
        }
        Resultado other = (Resultado) object;
        if ((this.resultadoId == null && other.resultadoId != null) || (this.resultadoId != null && !this.resultadoId.equals(other.resultadoId))) {
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
	@Override
    public String toString() {
    	JSONObject o = new JSONObject();
    	o.put("nombre", this.nombre);
    	o.put("objetivoId", this.objetivoId);
    	o.put("resultadoId", this.resultadoId);
    	o.put("actividadSet", this.getActividadesJson());
    	return o.toJSONString();
    }
    @SuppressWarnings("unchecked")
	public JSONArray getActividadesJson(){
    	JSONArray actividades = new JSONArray();
    	for (Actividad actividad : ordenar()) {
    		System.err.println(actividad);
			//if(actividad.getPadreActividadId() == 0){
    		JSONObject object = new JSONObject();
    		String nombre = actividad.getNombre();
    		object.put("title",nombre );
			object.put("key", actividad.getActividadId());
			object.put("isFolder", !actividad.getEsActividad());
			
			//if (!actividad.getHijos().isEmpty()) {
				object.put("children", getHijos(actividad.getActividadId()));
			//}			
			actividades.add(object);
			//}
		}
    	return actividades;
    }
    @SuppressWarnings("unchecked")
	public Set<Actividad> ordenar(){
    	Set<Actividad> nuevo = new HashSet<Actividad>();
    	Set<Actividad> temp =  new HashSet<Actividad>();
    	for (Actividad actividad : this.actividadSet) {
			if (actividad.getPadreActividadId() != 0) {
				for (Actividad padre : nuevo) {
					JSONObject object = new JSONObject();
					object.put("title", actividad.getNombre());
					object.put("key", actividad.getActividadId());
					object.put("isFolder", !actividad.getEsActividad());
					if(actividad.getPadreActividadId() == padre.getActividadId()){
						
						if(!padre.getHijos().contains(object))
							padre.getHijos().add(object);
						//padre.setHijos(padre.getHijos());
						//actividad.setHijos(hijos);
						//encontrado = true;
						temp.add(actividad);
						//nuevo.remove(padre)
						break;
					}
				}
			}else{
				nuevo.add(actividad);
			}
		}    	
    	return nuevo;
    }
    @SuppressWarnings("unchecked")
	public JSONArray getHijos(int id){
    	JSONArray array = new JSONArray();
    	for (Actividad hijo : this.actividadSet) {
    		if(hijo.getPadreActividadId() == id){
    			JSONObject object = new JSONObject();
    			String nombre = hijo.getNombre();
        		if (hijo.getEsActividad()) {
        			nombre = nombre + "<a href=\"metas.htm?id="+hijo.getActividadId()+"\" class=\"metas\">metas</a>";
    				nombre = nombre + "<a href=\"#\" onClick=\"alert('dssdsd');\">metas</a>";
    			}
    			object.put("title",nombre );
				object.put("key", hijo.getActividadId());
				object.put("isFolder", !hijo.getEsActividad());
				object.put("children", getHijos(hijo.getActividadId()));
				array.add(object);
    		}
    	}
    	return array;
    }
}
