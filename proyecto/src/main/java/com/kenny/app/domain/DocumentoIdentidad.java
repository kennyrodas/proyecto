/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kenny.app.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "documento_identidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentoIdentidad.findAll", query = "SELECT d FROM DocumentoIdentidad d"),
    @NamedQuery(name = "DocumentoIdentidad.findByDocumentoIdentidadId", query = "SELECT d FROM DocumentoIdentidad d WHERE d.documentoIdentidadId = :documentoIdentidadId"),
    @NamedQuery(name = "DocumentoIdentidad.findByNombre", query = "SELECT d FROM DocumentoIdentidad d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "DocumentoIdentidad.findByNumeroDigitos", query = "SELECT d FROM DocumentoIdentidad d WHERE d.numeroDigitos = :numeroDigitos"),
    @NamedQuery(name = "DocumentoIdentidad.findByNacional", query = "SELECT d FROM DocumentoIdentidad d WHERE d.nacional = :nacional"),
    @NamedQuery(name = "DocumentoIdentidad.findByTipoPersona", query = "SELECT d FROM DocumentoIdentidad d WHERE d.tipoPersona = :tipoPersona")})
public class DocumentoIdentidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "documento_identidad_id")
    private Integer documentoIdentidadId;
    @Size(max = 10)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "numero_digitos")
    private Integer numeroDigitos;
    @Column(name = "nacional")
    private Boolean nacional;
    @Column(name = "tipo_persona")
    private Character tipoPersona;
   /* @OneToMany(mappedBy = "documentoIdentidadId", fetch = FetchType.EAGER)
    private Set<Usuario> usuarioSet;
*/
    public DocumentoIdentidad() {
    }

    public DocumentoIdentidad(Integer documentoIdentidadId) {
        this.documentoIdentidadId = documentoIdentidadId;
    }

    public Integer getDocumentoIdentidadId() {
        return documentoIdentidadId;
    }

    public void setDocumentoIdentidadId(Integer documentoIdentidadId) {
        this.documentoIdentidadId = documentoIdentidadId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumeroDigitos() {
        return numeroDigitos;
    }

    public void setNumeroDigitos(Integer numeroDigitos) {
        this.numeroDigitos = numeroDigitos;
    }

    public Boolean getNacional() {
        return nacional;
    }

    public void setNacional(Boolean nacional) {
        this.nacional = nacional;
    }

    public Character getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(Character tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

   /* @XmlTransient
    public Set<Usuario> getUsuarioSet() {
        return usuarioSet;
    }

    public void setUsuarioSet(Set<Usuario> usuarioSet) {
        this.usuarioSet = usuarioSet;
    }
*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentoIdentidadId != null ? documentoIdentidadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentoIdentidad)) {
            return false;
        }
        DocumentoIdentidad other = (DocumentoIdentidad) object;
        if ((this.documentoIdentidadId == null && other.documentoIdentidadId != null) || (this.documentoIdentidadId != null && !this.documentoIdentidadId.equals(other.documentoIdentidadId))) {
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
	@Override
    public String toString() {
    	JSONObject o = new JSONObject();
    	o.put("documentoIdentidadId", this.documentoIdentidadId);
    	o.put("nacional", this.nacional);
    	o.put(numeroDigitos, this.numeroDigitos);
    	o.put("tipoPersona", this.tipoPersona);
    	return o.toJSONString();
    }
    
}
