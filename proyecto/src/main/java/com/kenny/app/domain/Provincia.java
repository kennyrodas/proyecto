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

import org.json.simple.JSONObject;

/**
 *
 * @author Gemelas
 */
@Entity
@Table(name = "provincia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provincia.findAll", query = "SELECT p FROM Provincia p"),
    @NamedQuery(name = "Provincia.findByProvinciaId", query = "SELECT p FROM Provincia p WHERE p.provinciaId = :provinciaId"),
    @NamedQuery(name = "Provincia.findByNombre", query = "SELECT p FROM Provincia p WHERE p.nombre = :nombre")})
public class Provincia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "provincia_id")
    private Integer provinciaId;
    @Size(max = 60)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "provinciaId", fetch = FetchType.EAGER)
    private Set<Distrito> distritoSet;
    @JoinColumn(name = "region_id", referencedColumnName = "region_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Region regionId;

    public Provincia() {
    }

    public Provincia(Integer provinciaId) {
        this.provinciaId = provinciaId;
    }

    public Integer getProvinciaId() {
        return provinciaId;
    }

    public void setProvinciaId(Integer provinciaId) {
        this.provinciaId = provinciaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Set<Distrito> getDistritoSet() {
        return distritoSet;
    }

    public void setDistritoSet(Set<Distrito> distritoSet) {
        this.distritoSet = distritoSet;
    }

    public Region getRegionId() {
        return regionId;
    }

    public void setRegionId(Region regionId) {
        this.regionId = regionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provinciaId != null ? provinciaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provincia)) {
            return false;
        }
        Provincia other = (Provincia) object;
        if ((this.provinciaId == null && other.provinciaId != null) || (this.provinciaId != null && !this.provinciaId.equals(other.provinciaId))) {
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
	@Override
    public String toString() {
    	JSONObject o = new JSONObject();
    	o.put("nombre", this.nombre);
    	o.put("provinciaId", this.provinciaId);
    	o.put("regionId", this.regionId);    	
    	return o.toJSONString();
    }
    
}
