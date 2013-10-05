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
@Table(name = "periodicidad_reporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeriodicidadReporte.findAll", query = "SELECT p FROM PeriodicidadReporte p"),
    @NamedQuery(name = "PeriodicidadReporte.findByPeriodicidadId", query = "SELECT p FROM PeriodicidadReporte p WHERE p.periodicidadId = :periodicidadId"),
    @NamedQuery(name = "PeriodicidadReporte.findByNombre", query = "SELECT p FROM PeriodicidadReporte p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "PeriodicidadReporte.findByDescripcion", query = "SELECT p FROM PeriodicidadReporte p WHERE p.descripcion = :descripcion")})
public class PeriodicidadReporte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "periodicidad_id")
    private Integer periodicidadId;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;

    public PeriodicidadReporte() {
    }

    public PeriodicidadReporte(Integer periodicidadId) {
        this.periodicidadId = periodicidadId;
    }

    public Integer getPeriodicidadId() {
        return periodicidadId;
    }

    public void setPeriodicidadId(Integer periodicidadId) {
        this.periodicidadId = periodicidadId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (periodicidadId != null ? periodicidadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodicidadReporte)) {
            return false;
        }
        PeriodicidadReporte other = (PeriodicidadReporte) object;
        if ((this.periodicidadId == null && other.periodicidadId != null) || (this.periodicidadId != null && !this.periodicidadId.equals(other.periodicidadId))) {
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
	@Override
    public String toString() {
    	JSONObject o = new JSONObject();
    	o.put("descripcion", this.descripcion);
    	o.put("nombre", this.nombre);
    	o.put("periodicidadId", this.periodicidadId);
    	return o.toJSONString();
    }
    
}
