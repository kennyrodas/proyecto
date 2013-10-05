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

/**
 *
 * @author Gemelas
 */
@Entity
@Table(name = "proyecto_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProyectoUsuario.findAll", query = "SELECT p FROM ProyectoUsuario p"),
    @NamedQuery(name = "ProyectoUsuario.findByProyectoId", query = "SELECT p FROM ProyectoUsuario p WHERE p.proyectoUsuarioPK.proyectoId = :proyectoId"),
    @NamedQuery(name = "ProyectoUsuario.findByUsuarioId", query = "SELECT p FROM ProyectoUsuario p WHERE p.proyectoUsuarioPK.usuarioId = :usuarioId")})
public class ProyectoUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProyectoUsuarioPK proyectoUsuarioPK;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuario;
    @JoinColumn(name = "proyecto_id", referencedColumnName = "proyecto_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Proyecto proyecto;
    @JoinColumn(name = "perfil_id", referencedColumnName = "perfil_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private PerfilUsuario perfilId;

    public ProyectoUsuario() {
    }

    public ProyectoUsuario(ProyectoUsuarioPK proyectoUsuarioPK) {
        this.proyectoUsuarioPK = proyectoUsuarioPK;
    }

    public ProyectoUsuario(int proyectoId, int usuarioId) {
        this.proyectoUsuarioPK = new ProyectoUsuarioPK(proyectoId, usuarioId);
    }

    public ProyectoUsuarioPK getProyectoUsuarioPK() {
        return proyectoUsuarioPK;
    }

    public void setProyectoUsuarioPK(ProyectoUsuarioPK proyectoUsuarioPK) {
        this.proyectoUsuarioPK = proyectoUsuarioPK;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public PerfilUsuario getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(PerfilUsuario perfilId) {
        this.perfilId = perfilId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyectoUsuarioPK != null ? proyectoUsuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectoUsuario)) {
            return false;
        }
        ProyectoUsuario other = (ProyectoUsuario) object;
        if ((this.proyectoUsuarioPK == null && other.proyectoUsuarioPK != null) || (this.proyectoUsuarioPK != null && !this.proyectoUsuarioPK.equals(other.proyectoUsuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kenny.app.domain.ProyectoUsuario[ proyectoUsuarioPK=" + proyectoUsuarioPK + " ]";
    }
    
}
