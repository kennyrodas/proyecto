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
@Table(name = "medio_verificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedioVerificacion.findAll", query = "SELECT m FROM MedioVerificacion m"),
    @NamedQuery(name = "MedioVerificacion.findByMedioVerificacionId", query = "SELECT m FROM MedioVerificacion m WHERE m.medioVerificacionId = :medioVerificacionId"),
    @NamedQuery(name = "MedioVerificacion.findByFicha", query = "SELECT m FROM MedioVerificacion m WHERE m.ficha = :ficha"),
    @NamedQuery(name = "MedioVerificacion.findByIndicador", query = "SELECT m FROM MedioVerificacion m WHERE m.indicador = :indicador")})
public class MedioVerificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "medio_verificacion_id")
    private Integer medioVerificacionId;
    @Size(max = 20)
    @Column(name = "ficha")
    private String ficha;
    @Size(max = 25)
    @Column(name = "indicador")
    private String indicador;
    @JoinColumn(name = "indicador_id", referencedColumnName = "indicador_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Indicador indicadorId;

    public MedioVerificacion() {
    }

    public MedioVerificacion(Integer medioVerificacionId) {
        this.medioVerificacionId = medioVerificacionId;
    }

    public Integer getMedioVerificacionId() {
        return medioVerificacionId;
    }

    public void setMedioVerificacionId(Integer medioVerificacionId) {
        this.medioVerificacionId = medioVerificacionId;
    }

    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    public Indicador getIndicadorId() {
        return indicadorId;
    }

    public void setIndicadorId(Indicador indicadorId) {
        this.indicadorId = indicadorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medioVerificacionId != null ? medioVerificacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedioVerificacion)) {
            return false;
        }
        MedioVerificacion other = (MedioVerificacion) object;
        if ((this.medioVerificacionId == null && other.medioVerificacionId != null) || (this.medioVerificacionId != null && !this.medioVerificacionId.equals(other.medioVerificacionId))) {
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
	@Override
    public String toString() {
    	JSONObject o = new JSONObject();
    	o.put("ficha", this.ficha);
    	o.put("indicador", this.indicador);
    	o.put("medioVerificacionId", this.medioVerificacionId);
        return o.toJSONString();
    }
    
}
