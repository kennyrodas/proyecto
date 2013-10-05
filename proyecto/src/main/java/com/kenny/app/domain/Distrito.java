/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kenny.app.domain;

import java.io.Serializable;
import java.util.Set;

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
import javax.persistence.OneToMany;
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
@Table(name = "distrito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Distrito.findAll", query = "SELECT d FROM Distrito d"),
    @NamedQuery(name = "Distrito.findByDistritoId", query = "SELECT d FROM Distrito d WHERE d.distritoId = :distritoId"),
    @NamedQuery(name = "Distrito.findByNombre", query = "SELECT d FROM Distrito d WHERE d.nombre = :nombre")})
public class Distrito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "distrito_id")
    private Integer distritoId;
    @Size(max = 60)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "provincia_id", referencedColumnName = "provincia_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Provincia provinciaId;
    @OneToMany(mappedBy = "distritoId", fetch = FetchType.EAGER)
    private Set<Comunidad> comunidadSet;

    public Distrito() {
    }

    public Distrito(Integer distritoId) {
        this.distritoId = distritoId;
    }

    public Integer getDistritoId() {
        return distritoId;
    }

    public void setDistritoId(Integer distritoId) {
        this.distritoId = distritoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Provincia getProvinciaId() {
        return provinciaId;
    }

    public void setProvinciaId(Provincia provinciaId) {
        this.provinciaId = provinciaId;
    }

    @XmlTransient
    public Set<Comunidad> getComunidadSet() {
        return comunidadSet;
    }

    public void setComunidadSet(Set<Comunidad> comunidadSet) {
        this.comunidadSet = comunidadSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (distritoId != null ? distritoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Distrito)) {
            return false;
        }
        Distrito other = (Distrito) object;
        if ((this.distritoId == null && other.distritoId != null) || (this.distritoId != null && !this.distritoId.equals(other.distritoId))) {
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
	@Override
    public String toString() {
    	JSONObject o = new JSONObject();
    	o.put("distritoId", this.distritoId);
    	o.put("nombre", this.nombre);
        return o.toJSONString();
    }
    
}
