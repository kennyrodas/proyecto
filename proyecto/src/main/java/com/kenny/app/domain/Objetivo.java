/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kenny.app.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Gemelas
 */
@Entity
@Table(name = "objetivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Objetivo.findAll", query = "SELECT o FROM Objetivo o"),
    @NamedQuery(name = "Objetivo.findByObjetivoId", query = "SELECT o FROM Objetivo o WHERE o.objetivoId = :objetivoId"),
    @NamedQuery(name = "Objetivo.findByTipoObjetivoId", query = "SELECT o FROM Objetivo o WHERE o.tipoObjetivoId = :tipoObjetivoId"),
    @NamedQuery(name = "Objetivo.findByCodigo", query = "SELECT o FROM Objetivo o WHERE o.codigo = :codigo"),
    @NamedQuery(name = "Objetivo.findByDescripcion", query = "SELECT o FROM Objetivo o WHERE o.descripcion = :descripcion"),
    @NamedQuery(name = "Objetivo.findByRegistradoPor", query = "SELECT o FROM Objetivo o WHERE o.registradoPor = :registradoPor"),
    @NamedQuery(name = "Objetivo.findByFechaRegistro", query = "SELECT o FROM Objetivo o WHERE o.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Objetivo.findByModificadoPor", query = "SELECT o FROM Objetivo o WHERE o.modificadoPor = :modificadoPor"),
    @NamedQuery(name = "Objetivo.findByFechaModificado", query = "SELECT o FROM Objetivo o WHERE o.fechaModificado = :fechaModificado")})
public class Objetivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "objetivo_id")
    private Integer objetivoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_objetivo_id")
    private int tipoObjetivoId;
    @Column(name = "codigo")
    private Integer codigo;
    @Size(max = 240)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 20)
    @Column(name = "registrado_por")
    private String registradoPor;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Size(max = 20)
    @Column(name = "modificado_por")
    private String modificadoPor;
    @Column(name = "fecha_modificado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificado;
    @JoinColumn(name = "proyecto_id", referencedColumnName = "proyecto_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Proyecto proyectoId;
    @OneToMany(mappedBy = "objetivoId", fetch = FetchType.EAGER)
    private Set<Indicador> indicadorSet;
    @OneToMany(mappedBy = "objetivoId", fetch = FetchType.EAGER)
    private Set<Supuesto> supuestoSet;
    @Transient
    private String tipoobjetivo2;
    public String getTipoobjetivo2() {
		return tipoobjetivo2;
	}

	public void setTipoobjetivo2(String tipoobjetivo2) {
		this.tipoobjetivo2 = tipoobjetivo2;
	}

	public Objetivo() {
    }

    public Objetivo(Integer objetivoId) {
        this.objetivoId = objetivoId;
    }

    public Objetivo(Integer objetivoId, int tipoObjetivoId) {
        this.objetivoId = objetivoId;
        this.tipoObjetivoId = tipoObjetivoId;
    }

    public Integer getObjetivoId() {
        return objetivoId;
    }

    public void setObjetivoId(Integer objetivoId) {
        this.objetivoId = objetivoId;
    }

    public int getTipoObjetivoId() {
        return tipoObjetivoId;
    }

    public void setTipoObjetivoId(int tipoObjetivoId) {
        this.tipoObjetivoId = tipoObjetivoId;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRegistradoPor() {
        return registradoPor;
    }

    public void setRegistradoPor(String registradoPor) {
        this.registradoPor = registradoPor;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(String modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    public Date getFechaModificado() {
        return fechaModificado;
    }

    public void setFechaModificado(Date fechaModificado) {
        this.fechaModificado = fechaModificado;
    }

    public Proyecto getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(Proyecto proyectoId) {
        this.proyectoId = proyectoId;
    }

    @XmlTransient
    public Set<Indicador> getIndicadorSet() {
        return indicadorSet;
    }

    public void setIndicadorSet(Set<Indicador> indicadorSet) {
        this.indicadorSet = indicadorSet;
    }

    @XmlTransient
    public Set<Supuesto> getSupuestoSet() {
        return supuestoSet;
    }

    public void setSupuestoSet(Set<Supuesto> supuestoSet) {
        this.supuestoSet = supuestoSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (objetivoId != null ? objetivoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Objetivo)) {
            return false;
        }
        Objetivo other = (Objetivo) object;
        if ((this.objetivoId == null && other.objetivoId != null) || (this.objetivoId != null && !this.objetivoId.equals(other.objetivoId))) {
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
	@Override
    public String toString() {
    	JSONObject o = new JSONObject();
    	o.put("codigo", this.codigo);
    	o.put("descripcion", this.descripcion);
    	o.put("fechaModificado", this.fechaModificado);
    	o.put("fechaRegistro", this.fechaRegistro);
    	o.put("tipoObjetivoId", this.tipoObjetivoId);
    	return o.toJSONString();
    }
    
}
