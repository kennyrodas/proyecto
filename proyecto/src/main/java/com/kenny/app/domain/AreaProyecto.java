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
@Table(name = "area_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreaProyecto.findAll", query = "SELECT a FROM AreaProyecto a"),
    @NamedQuery(name = "AreaProyecto.findByAreaId", query = "SELECT a FROM AreaProyecto a WHERE a.areaId = :areaId"),
    @NamedQuery(name = "AreaProyecto.findByNombre", query = "SELECT a FROM AreaProyecto a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "AreaProyecto.findByDescripcion", query = "SELECT a FROM AreaProyecto a WHERE a.descripcion = :descripcion")})
public class AreaProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "area_id")
    private Integer areaId;
    @Size(max = 60)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    /*@OneToMany(mappedBy = "areaId", fetch = FetchType.EAGER)
    private Set<Proyecto> proyectoSet;*/

    public AreaProyecto() {
    }

    public AreaProyecto(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
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
        hash += (areaId != null ? areaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaProyecto)) {
            return false;
        }
        AreaProyecto other = (AreaProyecto) object;
        if ((this.areaId == null && other.areaId != null) || (this.areaId != null && !this.areaId.equals(other.areaId))) {
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
	@Override
    public String toString() {
    	JSONObject o = new JSONObject();
    	o.put("areaId", this.areaId);
    	o.put("nombre", this.nombre);
        return o.toJSONString();
    }
    
}
