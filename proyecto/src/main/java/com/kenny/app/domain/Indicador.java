/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kenny.app.domain;

import java.io.Serializable;
import java.util.Set;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "indicador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Indicador.findAll", query = "SELECT i FROM Indicador i"),
    @NamedQuery(name = "Indicador.findByIndicadorId", query = "SELECT i FROM Indicador i WHERE i.indicadorId = :indicadorId"),
    @NamedQuery(name = "Indicador.findByNombre", query = "SELECT i FROM Indicador i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Indicador.findByDescripcion", query = "SELECT i FROM Indicador i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "Indicador.findByFormaCalculo", query = "SELECT i FROM Indicador i WHERE i.formaCalculo = :formaCalculo"),
    @NamedQuery(name = "Indicador.findByFuente", query = "SELECT i FROM Indicador i WHERE i.fuente = :fuente"),
    @NamedQuery(name = "Indicador.findByModoPreCalculo", query = "SELECT i FROM Indicador i WHERE i.modoPreCalculo = :modoPreCalculo"),
    @NamedQuery(name = "Indicador.findByPeriodicidadId", query = "SELECT i FROM Indicador i WHERE i.periodicidadId = :periodicidadId"),
    @NamedQuery(name = "Indicador.findByValorInicial", query = "SELECT i FROM Indicador i WHERE i.valorInicial = :valorInicial"),
    @NamedQuery(name = "Indicador.findByValorFinal", query = "SELECT i FROM Indicador i WHERE i.valorFinal = :valorFinal"),
    @NamedQuery(name = "Indicador.findByDocumentoReporte", query = "SELECT i FROM Indicador i WHERE i.documentoReporte = :documentoReporte"),
    @NamedQuery(name = "Indicador.findByResponsableId", query = "SELECT i FROM Indicador i WHERE i.responsableId = :responsableId")})
public class Indicador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "indicador_id")
    private Integer indicadorId;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 255)
    @Column(name = "forma_calculo")
    private String formaCalculo;
    @Column(name = "fuente")
    private Boolean fuente;
    @Column(name = "modo_pre_calculo")
    private Boolean modoPreCalculo;
    @Lob
    @Size(max = 65535)
    @Column(name = "medio_verificacion")
    private String medioVerificacion;
    @Column(name = "periodicidad_id")
    private Integer periodicidadId;
    @Size(max = 20)
    @Column(name = "valor_inicial")
    private String valorInicial;
    @Size(max = 20)
    @Column(name = "valor_final")
    private String valorFinal;
    @Size(max = 255)
    @Column(name = "documento_reporte")
    private String documentoReporte;
    @Column(name = "responsable_id")
    private Integer responsableId;
    @JoinColumn(name = "objetivo_id", referencedColumnName = "objetivo_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Objetivo objetivoId;
    @OneToMany(mappedBy = "indicadorId", fetch = FetchType.EAGER)
    private Set<MedioVerificacion> medioVerificacionSet;

    public Indicador() {
    }

    public Indicador(Integer indicadorId) {
        this.indicadorId = indicadorId;
    }

    public Integer getIndicadorId() {
        return indicadorId;
    }

    public void setIndicadorId(Integer indicadorId) {
        this.indicadorId = indicadorId;
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

    public String getFormaCalculo() {
        return formaCalculo;
    }

    public void setFormaCalculo(String formaCalculo) {
        this.formaCalculo = formaCalculo;
    }

    public Boolean getFuente() {
        return fuente;
    }

    public void setFuente(Boolean fuente) {
        this.fuente = fuente;
    }

    public Boolean getModoPreCalculo() {
        return modoPreCalculo;
    }

    public void setModoPreCalculo(Boolean modoPreCalculo) {
        this.modoPreCalculo = modoPreCalculo;
    }

    public String getMedioVerificacion() {
        return medioVerificacion;
    }

    public void setMedioVerificacion(String medioVerificacion) {
        this.medioVerificacion = medioVerificacion;
    }

    public Integer getPeriodicidadId() {
        return periodicidadId;
    }

    public void setPeriodicidadId(Integer periodicidadId) {
        this.periodicidadId = periodicidadId;
    }

    public String getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(String valorInicial) {
        this.valorInicial = valorInicial;
    }

    public String getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(String valorFinal) {
        this.valorFinal = valorFinal;
    }

    public String getDocumentoReporte() {
        return documentoReporte;
    }

    public void setDocumentoReporte(String documentoReporte) {
        this.documentoReporte = documentoReporte;
    }

    public Integer getResponsableId() {
        return responsableId;
    }

    public void setResponsableId(Integer responsableId) {
        this.responsableId = responsableId;
    }

    public Objetivo getObjetivoId() {
        return objetivoId;
    }

    public void setObjetivoId(Objetivo objetivoId) {
        this.objetivoId = objetivoId;
    }

    @XmlTransient
    public Set<MedioVerificacion> getMedioVerificacionSet() {
        return medioVerificacionSet;
    }

    public void setMedioVerificacionSet(Set<MedioVerificacion> medioVerificacionSet) {
        this.medioVerificacionSet = medioVerificacionSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (indicadorId != null ? indicadorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Indicador)) {
            return false;
        }
        Indicador other = (Indicador) object;
        if ((this.indicadorId == null && other.indicadorId != null) || (this.indicadorId != null && !this.indicadorId.equals(other.indicadorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
    	//String json =descripcion 
        return getIndicadorJSON().toString();
    }
    @SuppressWarnings("unchecked")
	public JSONObject getIndicadorJSON(){
    	JSONObject objeto = new JSONObject();
    	objeto.put("id", this.indicadorId);
    	return objeto;
    	
    }
    
}
