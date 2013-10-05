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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p"),
    @NamedQuery(name = "Proyecto.findByProyectoId", query = "SELECT p FROM Proyecto p WHERE p.proyectoId = :proyectoId"),
    @NamedQuery(name = "Proyecto.findByNombre", query = "SELECT p FROM Proyecto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Proyecto.findByRegistradoPor", query = "SELECT p FROM Proyecto p WHERE p.registradoPor = :registradoPor"),
    @NamedQuery(name = "Proyecto.findByFechaRegistro", query = "SELECT p FROM Proyecto p WHERE p.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Proyecto.findByModificadoPor", query = "SELECT p FROM Proyecto p WHERE p.modificadoPor = :modificadoPor"),
    @NamedQuery(name = "Proyecto.findByFechaModificado", query = "SELECT p FROM Proyecto p WHERE p.fechaModificado = :fechaModificado"),
    @NamedQuery(name = "Proyecto.findByFechaInicio", query = "SELECT p FROM Proyecto p WHERE p.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Proyecto.findByDuracionMeses", query = "SELECT p FROM Proyecto p WHERE p.duracionMeses = :duracionMeses"),
    @NamedQuery(name = "Proyecto.findByFechaFin", query = "SELECT p FROM Proyecto p WHERE p.fechaFin = :fechaFin")})
public class Proyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "proyecto_id")
    private Integer proyectoId;
    @Size(max = 240)
    @Column(name = "nombre")
    private String nombre;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
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
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "duracion_meses")
    private Short duracionMeses;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyecto", fetch = FetchType.EAGER)
    private Set<ProyectoRegion> ProyectoRegionSet;
    @OneToMany(mappedBy = "proyectoId", fetch = FetchType.EAGER)
    private Set<Objetivo> objetivoSet;
    @OneToMany(mappedBy = "proyectoId", fetch = FetchType.EAGER)
    private Set<Actividad> actividadSet;
    @JoinColumn(name = "pais_id", referencedColumnName = "pais_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Pais paisId;
    @JoinColumn(name = "area_id", referencedColumnName = "area_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private AreaProyecto areaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyecto", fetch = FetchType.EAGER)
    private Set<ProyectoUsuario> proyectoUsuarioSet;
    
	public Proyecto() {
    }
    public Proyecto(Integer proyectoId) {
        this.proyectoId = proyectoId;
    }

    public Integer getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(Integer proyectoId) {
        this.proyectoId = proyectoId;
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Short getDuracionMeses() {
        return duracionMeses;
    }

    public void setDuracionMeses(Short duracionMeses) {
        this.duracionMeses = duracionMeses;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @XmlTransient
    public Set<ProyectoRegion> getProyectoRegionSet() {
        return ProyectoRegionSet;
    }

    public void setProyectoRegionSet(Set<ProyectoRegion> ProyectoRegionSet) {
        this.ProyectoRegionSet = ProyectoRegionSet;
    }

    @XmlTransient
    public Set<Objetivo> getObjetivoSet() {
        return objetivoSet;
    }

    public void setObjetivoSet(Set<Objetivo> objetivoSet) {
        this.objetivoSet = objetivoSet;
    }

    @XmlTransient
    public Set<Actividad> getActividadSet() {
        return actividadSet;
    }

    public void setActividadSet(Set<Actividad> actividadSet) {
        this.actividadSet = actividadSet;
    }

    public Pais getPaisId() {
        return paisId;
    }

    public void setPaisId(Pais paisId) {
        this.paisId = paisId;
    }

    public AreaProyecto getAreaId() {
        return areaId;
    }

    public void setAreaId(AreaProyecto areaId) {
        this.areaId = areaId;
    }

    @XmlTransient
    public Set<ProyectoUsuario> getProyectoUsuarioSet() {
        return proyectoUsuarioSet;
    }

    public void setProyectoUsuarioSet(Set<ProyectoUsuario> proyectoUsuarioSet) {
        this.proyectoUsuarioSet = proyectoUsuarioSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyectoId != null ? proyectoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.proyectoId == null && other.proyectoId != null) || (this.proyectoId != null && !this.proyectoId.equals(other.proyectoId))) {
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
	@Override
    public String toString() {
    	JSONObject o = new JSONObject();
    	o.put("areaId", this.areaId.toString());
    	o.put("descripcion", this.descripcion);
    	o.put("duracionMeses", this.duracionMeses);
    	o.put("fechaFin", this.fechaFin);
    	o.put("fechaInicio", this.fechaInicio);
    	o.put("fechaModificado", this.fechaModificado);
    	o.put("fechaRegistro", this.fechaRegistro);
    	o.put("modificadoPor", this.modificadoPor);
    	o.put("nombre", this.nombre);
    	o.put("proyectoId", this.proyectoId);
    	o.put("registradoPor", this.registradoPor);
    	return o.toJSONString();
    }
    
}
