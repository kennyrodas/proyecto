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

import org.json.simple.JSONObject;

/**
 *
 * @author Gemelas
 */
@Embeddable
public class MetaPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @NotNull
    @Column(name = "actividad_id")
    private int actividadId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "periodo_id")
    private int periodoId;

    public MetaPK() {
    }

    public MetaPK(int actividadId, int periodoId) {
        this.actividadId = actividadId;
        this.periodoId = periodoId;
    }

    public int getActividadId() {
        return actividadId;
    }

    public void setActividadId(int actividadId) {
        this.actividadId = actividadId;
    }

    public int getPeriodoId() {
        return periodoId;
    }

    public void setPeriodoId(int periodoId) {
        this.periodoId = periodoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) actividadId;
        hash += (int) periodoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetaPK)) {
            return false;
        }
        MetaPK other = (MetaPK) object;
        if (this.actividadId != other.actividadId) {
            return false;
        }
        if (this.periodoId != other.periodoId) {
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
	@Override
    public String toString() {
    	JSONObject o = new JSONObject();
    	o.put("actividadId", this.actividadId);
    	o.put("periodoId", this.periodoId);
    	return o.toJSONString();
    }
    
}
