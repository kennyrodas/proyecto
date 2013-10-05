/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kenny.app.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Gemelas
 */
@Embeddable
public class ProyectoRegionPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @NotNull
    @Column(name = "proyecto_id")
    private int proyectoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "region_id")
    private int regionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "provincia_id")
    private int provinciaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "distrito_id")
    private int distritoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "comunidades_id")
    private String comunidadesId;

    public ProyectoRegionPK() {
    }

    public ProyectoRegionPK(int proyectoId, int regionId, int provinciaId, int distritoId, String comunidadesId) {
        this.proyectoId = proyectoId;
        this.regionId = regionId;
        this.provinciaId = provinciaId;
        this.distritoId = distritoId;
        this.comunidadesId = comunidadesId;
    }

    public int getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(int proyectoId) {
        this.proyectoId = proyectoId;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public int getProvinciaId() {
        return provinciaId;
    }

    public void setProvinciaId(int provinciaId) {
        this.provinciaId = provinciaId;
    }

    public int getDistritoId() {
        return distritoId;
    }

    public void setDistritoId(int distritoId) {
        this.distritoId = distritoId;
    }

    public String getComunidadesId() {
        return comunidadesId;
    }

    public void setComunidadesId(String comunidadesId) {
        this.comunidadesId = comunidadesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) proyectoId;
        hash += (int) regionId;
        hash += (int) provinciaId;
        hash += (int) distritoId;
        hash += (comunidadesId != null ? comunidadesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectoRegionPK)) {
            return false;
        }
        ProyectoRegionPK other = (ProyectoRegionPK) object;
        if (this.proyectoId != other.proyectoId) {
            return false;
        }
        if (this.regionId != other.regionId) {
            return false;
        }
        if (this.provinciaId != other.provinciaId) {
            return false;
        }
        if (this.distritoId != other.distritoId) {
            return false;
        }
        if ((this.comunidadesId == null && other.comunidadesId != null) || (this.comunidadesId != null && !this.comunidadesId.equals(other.comunidadesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kenny.app.domain.ProyectoRegionPK[ proyectoId=" + proyectoId + ", regionId=" + regionId + ", provinciaId=" + provinciaId + ", distritoId=" + distritoId + ", comunidadesId=" + comunidadesId + " ]";
    }
    
}
