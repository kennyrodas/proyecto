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
@Table(name = "perfil_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerfilUsuario.findAll", query = "SELECT p FROM PerfilUsuario p"),
    @NamedQuery(name = "PerfilUsuario.findByPerfilId", query = "SELECT p FROM PerfilUsuario p WHERE p.perfilId = :perfilId"),
    @NamedQuery(name = "PerfilUsuario.findByNombre", query = "SELECT p FROM PerfilUsuario p WHERE p.nombre = :nombre")})
public class PerfilUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "perfil_id")
    private Integer perfilId;
    @Size(max = 30)
    @Column(name = "nombre")
    private String nombre;
   /* @OneToMany(mappedBy = "perfilId", fetch = FetchType.EAGER)
    private Set<ProyectoUsuario> proyectoUsuarioSet;*/

    public PerfilUsuario() {
    }

    public PerfilUsuario(Integer perfilId) {
        this.perfilId = perfilId;
    }

    public Integer getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(Integer perfilId) {
        this.perfilId = perfilId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   /* @XmlTransient
    public Set<ProyectoUsuario> getProyectoUsuarioSet() {
        return proyectoUsuarioSet;
    }

    public void setProyectoUsuarioSet(Set<ProyectoUsuario> proyectoUsuarioSet) {
        this.proyectoUsuarioSet = proyectoUsuarioSet;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perfilId != null ? perfilId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilUsuario)) {
            return false;
        }
        PerfilUsuario other = (PerfilUsuario) object;
        if ((this.perfilId == null && other.perfilId != null) || (this.perfilId != null && !this.perfilId.equals(other.perfilId))) {
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
	@Override
    public String toString() {
    	JSONObject o = new JSONObject();
    	o.put("nombre", this.nombre);
    	o.put("perfilId", this.perfilId);
    	return o.toJSONString();
    }
    
}
