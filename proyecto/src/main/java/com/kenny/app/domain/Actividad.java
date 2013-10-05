/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kenny.app.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "actividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a"),
    @NamedQuery(name = "Actividad.findByActividadId", query = "SELECT a FROM Actividad a WHERE a.actividadId = :actividadId"),
    @NamedQuery(name = "Actividad.findByPadreActividadId", query = "SELECT a FROM Actividad a WHERE a.padreActividadId = :padreActividadId"),
    @NamedQuery(name = "Actividad.findByCodigo", query = "SELECT a FROM Actividad a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "Actividad.findByNombre", query = "SELECT a FROM Actividad a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Actividad.findByOrden", query = "SELECT a FROM Actividad a WHERE a.orden = :orden"),
    @NamedQuery(name = "Actividad.findByRegistradoPor", query = "SELECT a FROM Actividad a WHERE a.registradoPor = :registradoPor"),
    @NamedQuery(name = "Actividad.findByFechaRegistro", query = "SELECT a FROM Actividad a WHERE a.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Actividad.findByModificadoPor", query = "SELECT a FROM Actividad a WHERE a.modificadoPor = :modificadoPor"),
    @NamedQuery(name = "Actividad.findByFechaModificado", query = "SELECT a FROM Actividad a WHERE a.fechaModificado = :fechaModificado"),
    @NamedQuery(name = "Actividad.findByEsActividad", query = "SELECT a FROM Actividad a WHERE a.esActividad = :esActividad")})
public class Actividad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "actividad_id")
    private Integer actividadId;
    @Column(name = "padre_actividad_id")
    private Integer padreActividadId;
    @Size(max = 10)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 120)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "orden")
    private Short orden;
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
    @Column(name = "es_actividad")
    private Boolean esActividad;
    @JoinColumn(name = "resultado_id", referencedColumnName = "resultado_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Resultado resultadoId;
    @JoinColumn(name = "proyecto_id", referencedColumnName = "proyecto_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Proyecto proyectoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividad", fetch = FetchType.EAGER)
    private Set<Meta> metaSet;
    @Transient
    private JSONArray hijos = new JSONArray();
    public JSONArray getHijos() {
		return hijos;
	}

	public void setHijos(JSONArray hijos) {
		this.hijos = hijos;
	}

	public Actividad() {
    }

    public Actividad(Integer actividadId) {
        this.actividadId = actividadId;
    }

    public Integer getActividadId() {
        return actividadId;
    }

    public void setActividadId(Integer actividadId) {
        this.actividadId = actividadId;
    }

    public Integer getPadreActividadId() {
        return padreActividadId;
    }

    public void setPadreActividadId(Integer padreActividadId) {
        this.padreActividadId = padreActividadId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Short getOrden() {
        return orden;
    }

    public void setOrden(Short orden) {
        this.orden = orden;
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

    public Boolean getEsActividad() {
        return esActividad;
    }

    public void setEsActividad(Boolean esActividad) {
        this.esActividad = esActividad;
    }

    public Resultado getResultadoId() {
        return resultadoId;
    }

    public void setResultadoId(Resultado resultadoId) {
        this.resultadoId = resultadoId;
    }

    public Proyecto getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(Proyecto proyectoId) {
        this.proyectoId = proyectoId;
    }

    @XmlTransient
    public Set<Meta> getMetaSet() {
        return metaSet;
    }

    public void setMetaSet(Set<Meta> metaSet) {
        this.metaSet = metaSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actividadId != null ? actividadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.actividadId == null && other.actividadId != null) || (this.actividadId != null && !this.actividadId.equals(other.actividadId))) {
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
	@Override
    public String toString() {
    	JSONObject o = new JSONObject();
    	o.put("actividadId", this.actividadId);
    	return o.toJSONString();
    }
    
    
}
