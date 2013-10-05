/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kenny.app.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.json.simple.JSONObject;

/**
 *
 * @author Gemelas
 */
@Entity
@Table(name = "pais")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pais p"),
    @NamedQuery(name = "Pais.findByPaisId", query = "SELECT p FROM Pais p WHERE p.paisId = :paisId"),
    @NamedQuery(name = "Pais.findByNombre", query = "SELECT p FROM Pais p WHERE p.nombre = :nombre")})
public class Pais implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pais_id")
    private Integer paisId;
    @Size(max = 30)
    @Column(name = "nombre")
    private String nombre;
    /*@OneToMany(mappedBy = "paisId", fetch = FetchType.EAGER)
    private Set<Usuario> usuarioSet;
    @OneToMany(mappedBy = "paisId", fetch = FetchType.EAGER)
    private Set<Proyecto> proyectoSet;*/

    public Pais() {
    }

    public Pais(Integer paisId) {
        this.paisId = paisId;
    }

    public Integer getPaisId() {
        return paisId;
    }

    public void setPaisId(Integer paisId) {
        this.paisId = paisId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   /* @XmlTransient
    public Set<Usuario> getUsuarioSet() {
        return usuarioSet;
    }

    public void setUsuarioSet(Set<Usuario> usuarioSet) {
        this.usuarioSet = usuarioSet;
    }

    @XmlTransient
    public Set<Proyecto> getProyectoSet() {
        return proyectoSet;
    }

    public void setProyectoSet(Set<Proyecto> proyectoSet) {
        this.proyectoSet = proyectoSet;
    }
*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paisId != null ? paisId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) object;
        if ((this.paisId == null && other.paisId != null) || (this.paisId != null && !this.paisId.equals(other.paisId))) {
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
	@Override
    public String toString() {
    	JSONObject o = new JSONObject();
    	o.put("nombre", this.nombre);
    	o.put("paisId", this.paisId);
    	return o.toJSONString();
    }
    
}
