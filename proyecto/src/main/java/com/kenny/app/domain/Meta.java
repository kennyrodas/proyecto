/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kenny.app.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.json.simple.JSONObject;

/**
 *
 * @author Gemelas
 */
@Entity
@Table(name = "meta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Meta.findAll", query = "SELECT m FROM Meta m"),
    @NamedQuery(name = "Meta.findByActividadId", query = "SELECT m FROM Meta m WHERE m.metaPK.actividadId = :actividadId"),
    @NamedQuery(name = "Meta.findByPeriodoId", query = "SELECT m FROM Meta m WHERE m.metaPK.periodoId = :periodoId"),
    @NamedQuery(name = "Meta.findByCantidad", query = "SELECT m FROM Meta m WHERE m.cantidad = :cantidad"),
    @NamedQuery(name = "Meta.findByRegistradoPor", query = "SELECT m FROM Meta m WHERE m.registradoPor = :registradoPor"),
    @NamedQuery(name = "Meta.findByFechaRegistro", query = "SELECT m FROM Meta m WHERE m.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Meta.findByModificadoPor", query = "SELECT m FROM Meta m WHERE m.modificadoPor = :modificadoPor"),
    @NamedQuery(name = "Meta.findByFechaModificado", query = "SELECT m FROM Meta m WHERE m.fechaModificado = :fechaModificado")})
public class Meta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MetaPK metaPK;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "registrado_por")
    private Integer registradoPor;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Column(name = "modificado_por")
    private Integer modificadoPor;
    @Column(name = "fecha_modificado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificado;
    @JoinColumn(name = "actividad_id", referencedColumnName = "actividad_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Actividad actividad;

    public Meta() {
    }

    public Meta(MetaPK metaPK) {
        this.metaPK = metaPK;
    }

    public Meta(int actividadId, int periodoId) {
        this.metaPK = new MetaPK(actividadId, periodoId);
    }

    public MetaPK getMetaPK() {
        return metaPK;
    }

    public void setMetaPK(MetaPK metaPK) {
        this.metaPK = metaPK;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getRegistradoPor() {
        return registradoPor;
    }

    public void setRegistradoPor(Integer registradoPor) {
        this.registradoPor = registradoPor;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(Integer modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    public Date getFechaModificado() {
        return fechaModificado;
    }

    public void setFechaModificado(Date fechaModificado) {
        this.fechaModificado = fechaModificado;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (metaPK != null ? metaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meta)) {
            return false;
        }
        Meta other = (Meta) object;
        if ((this.metaPK == null && other.metaPK != null) || (this.metaPK != null && !this.metaPK.equals(other.metaPK))) {
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
	@Override
    public String toString() {
    	JSONObject o = new JSONObject();
    	o.put("actividad", this.actividad.toString());
    	o.put("cantidad", this.cantidad);
    	o.put("fechaModificado", this.fechaModificado);
    	o.put("fechaRegistro", this.fechaRegistro);
    	o.put("modificadoPor", this.modificadoPor);
    	o.put("registradoPor", this.registradoPor);
    	
        return o.toJSONString();
    }
    
}
