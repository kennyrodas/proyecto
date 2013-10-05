/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kenny.app.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "comunidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comunidad.findAll", query = "SELECT c FROM Comunidad c"),
    @NamedQuery(name = "Comunidad.findByComunidadId", query = "SELECT c FROM Comunidad c WHERE c.comunidadId = :comunidadId"),
    @NamedQuery(name = "Comunidad.findByNombre", query = "SELECT c FROM Comunidad c WHERE c.nombre = :nombre")})
public class Comunidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "comunidad_id")
    private Integer comunidadId;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "distrito_id", referencedColumnName = "distrito_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Distrito distritoId;

    public Comunidad() {
    }

    public Comunidad(Integer comunidadId) {
        this.comunidadId = comunidadId;
    }

    public Integer getComunidadId() {
        return comunidadId;
    }

    public void setComunidadId(Integer comunidadId) {
        this.comunidadId = comunidadId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Distrito getDistritoId() {
        return distritoId;
    }

    public void setDistritoId(Distrito distritoId) {
        this.distritoId = distritoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comunidadId != null ? comunidadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comunidad)) {
            return false;
        }
        Comunidad other = (Comunidad) object;
        if ((this.comunidadId == null && other.comunidadId != null) || (this.comunidadId != null && !this.comunidadId.equals(other.comunidadId))) {
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
	@Override
    public String toString() {
    	JSONObject o = new JSONObject();
    	o.put("comunidadId", this.comunidadId);
    	o.put("distritoId", this.distritoId.toString());
    	o.put("nombre", this.nombre);
        return o.toJSONString();
    }
    
}
