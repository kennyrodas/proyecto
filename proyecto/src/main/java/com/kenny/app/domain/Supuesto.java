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
import javax.persistence.Lob;
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
@Table(name = "supuesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Supuesto.findAll", query = "SELECT s FROM Supuesto s"),
    @NamedQuery(name = "Supuesto.findBySupuestoId", query = "SELECT s FROM Supuesto s WHERE s.supuestoId = :supuestoId")})
public class Supuesto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "supuesto_id")
    private Integer supuestoId;
    @Lob
    @Size(max = 65535)
    @Column(name = "supuesto")
    private String supuesto;
    @JoinColumn(name = "objetivo_id", referencedColumnName = "objetivo_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Objetivo objetivoId;

    public Supuesto() {
    }

    public Supuesto(Integer supuestoId) {
        this.supuestoId = supuestoId;
    }

    public Integer getSupuestoId() {
        return supuestoId;
    }

    public void setSupuestoId(Integer supuestoId) {
        this.supuestoId = supuestoId;
    }

    public String getSupuesto() {
        return supuesto;
    }

    public void setSupuesto(String supuesto) {
        this.supuesto = supuesto;
    }

    public Objetivo getObjetivoId() {
        return objetivoId;
    }

    public void setObjetivoId(Objetivo objetivoId) {
        this.objetivoId = objetivoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supuestoId != null ? supuestoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Supuesto)) {
            return false;
        }
        Supuesto other = (Supuesto) object;
        if ((this.supuestoId == null && other.supuestoId != null) || (this.supuestoId != null && !this.supuestoId.equals(other.supuestoId))) {
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
	@Override
    public String toString() {
    	JSONObject o = new JSONObject();
    	o.put("supuesto", this.supuesto);
    	o.put("supuestoId", this.supuestoId);
    	return o.toJSONString();
    }
    
}
