/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kenny.app.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.json.simple.JSONObject;

/**
 *
 * @author Gemelas
 */
@Entity
@Table(name = "proyectoregion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProyectoRegion.findAll", query = "SELECT p FROM ProyectoRegion p"),
    @NamedQuery(name = "ProyectoRegion.findByProyectoId", query = "SELECT p FROM ProyectoRegion p WHERE p.ProyectoRegionPK.proyectoId = :proyectoId"),
    @NamedQuery(name = "ProyectoRegion.findByRegionId", query = "SELECT p FROM ProyectoRegion p WHERE p.ProyectoRegionPK.regionId = :regionId"),
    @NamedQuery(name = "ProyectoRegion.findByProvinciaId", query = "SELECT p FROM ProyectoRegion p WHERE p.ProyectoRegionPK.provinciaId = :provinciaId"),
    @NamedQuery(name = "ProyectoRegion.findByDistritoId", query = "SELECT p FROM ProyectoRegion p WHERE p.ProyectoRegionPK.distritoId = :distritoId"),
    @NamedQuery(name = "ProyectoRegion.findByComunidadesId", query = "SELECT p FROM ProyectoRegion p WHERE p.ProyectoRegionPK.comunidadesId = :comunidadesId")})
public class ProyectoRegion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProyectoRegionPK ProyectoRegionPK;
    @JoinColumn(name = "proyecto_id", referencedColumnName = "proyecto_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Proyecto proyecto;

    public ProyectoRegion() {
    }

    public ProyectoRegion(ProyectoRegionPK ProyectoRegionPK) {
        this.ProyectoRegionPK = ProyectoRegionPK;
    }

    public ProyectoRegion(int proyectoId, int regionId, int provinciaId, int distritoId, String comunidadesId) {
        this.ProyectoRegionPK = new ProyectoRegionPK(proyectoId, regionId, provinciaId, distritoId, comunidadesId);
    }

    public ProyectoRegionPK getProyectoRegionPK() {
        return ProyectoRegionPK;
    }

    public void setProyectoRegionPK(ProyectoRegionPK ProyectoRegionPK) {
        this.ProyectoRegionPK = ProyectoRegionPK;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ProyectoRegionPK != null ? ProyectoRegionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectoRegion)) {
            return false;
        }
        ProyectoRegion other = (ProyectoRegion) object;
        if ((this.ProyectoRegionPK == null && other.ProyectoRegionPK != null) || (this.ProyectoRegionPK != null && !this.ProyectoRegionPK.equals(other.ProyectoRegionPK))) {
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
	@Override
    public String toString() {
    	JSONObject o = new JSONObject();
    	o.put("proyecto", this.proyecto.toString());
    	return o.toJSONString();
    	
    }
    
}
