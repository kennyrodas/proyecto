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

/**
 *
 * @author Gemelas
 */
@Embeddable
public class ProyectoUsuarioPK implements Serializable {
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
    @Column(name = "usuario_id")
    private int usuarioId;

    public ProyectoUsuarioPK() {
    }

    public ProyectoUsuarioPK(int proyectoId, int usuarioId) {
        this.proyectoId = proyectoId;
        this.usuarioId = usuarioId;
    }

    public int getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(int proyectoId) {
        this.proyectoId = proyectoId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) proyectoId;
        hash += (int) usuarioId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectoUsuarioPK)) {
            return false;
        }
        ProyectoUsuarioPK other = (ProyectoUsuarioPK) object;
        if (this.proyectoId != other.proyectoId) {
            return false;
        }
        if (this.usuarioId != other.usuarioId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kenny.app.domain.ProyectoUsuarioPK[ proyectoId=" + proyectoId + ", usuarioId=" + usuarioId + " ]";
    }
    
}
