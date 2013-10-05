/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kenny.app.domain;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gemelas
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
    @NamedQuery(name = "Usuario.findByUsuario", query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario"),
    @NamedQuery(name = "Usuario.findByClave", query = "SELECT u FROM Usuario u WHERE u.clave = :clave"),
    @NamedQuery(name = "Usuario.findByUsuariotipo", query = "SELECT u FROM Usuario u WHERE u.usuariotipo = :usuariotipo"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByApellido", query = "SELECT u FROM Usuario u WHERE u.apellido = :apellido"),
    @NamedQuery(name = "Usuario.findByRazonsoc", query = "SELECT u FROM Usuario u WHERE u.razonsoc = :razonsoc"),
    @NamedQuery(name = "Usuario.findByEmptipo", query = "SELECT u FROM Usuario u WHERE u.emptipo = :emptipo"),
    @NamedQuery(name = "Usuario.findByEmpsector", query = "SELECT u FROM Usuario u WHERE u.empsector = :empsector"),
    @NamedQuery(name = "Usuario.findByEmprepresent", query = "SELECT u FROM Usuario u WHERE u.emprepresent = :emprepresent"),
    @NamedQuery(name = "Usuario.findByDocnum", query = "SELECT u FROM Usuario u WHERE u.docnum = :docnum"),
    @NamedQuery(name = "Usuario.findByTelefono", query = "SELECT u FROM Usuario u WHERE u.telefono = :telefono"),
    @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo"),
    @NamedQuery(name = "Usuario.findByTrabdir", query = "SELECT u FROM Usuario u WHERE u.trabdir = :trabdir"),
    @NamedQuery(name = "Usuario.findByTrabcargo", query = "SELECT u FROM Usuario u WHERE u.trabcargo = :trabcargo"),
    @NamedQuery(name = "Usuario.findByPadreId", query = "SELECT u FROM Usuario u WHERE u.padreId = :padreId")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 25)
    @Column(name = "usuario")
    private String usuario;
    @Size(max = 50)
    @Column(name = "clave")
    private String clave;
    @Size(max = 6)
    @Column(name = "usuariotipo")
    private String usuariotipo;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 250)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 250)
    @Column(name = "razonsoc")
    private String razonsoc;
    @Size(max = 6)
    @Column(name = "emptipo")
    private String emptipo;
    @Size(max = 25)
    @Column(name = "empsector")
    private String empsector;
    @Size(max = 250)
    @Column(name = "emprepresent")
    private String emprepresent;
    @Size(max = 25)
    @Column(name = "docnum")
    private String docnum;
    @Size(max = 25)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 100)
    @Column(name = "correo")
    private String correo;
    @Size(max = 250)
    @Column(name = "trabdir")
    private String trabdir;
    @Size(max = 250)
    @Column(name = "trabcargo")
    private String trabcargo;
    @Column(name = "padre_id")
    private Integer padreId;
    @JoinColumn(name = "pais_id", referencedColumnName = "pais_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Pais paisId;
    @JoinColumn(name = "documento_identidad_id", referencedColumnName = "documento_identidad_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private DocumentoIdentidad documentoIdentidadId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.EAGER)
    private Set<ProyectoUsuario> proyectoUsuarioSet;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.EAGER)
    private Admin admin;

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getUsuariotipo() {
        return usuariotipo;
    }

    public void setUsuariotipo(String usuariotipo) {
        this.usuariotipo = usuariotipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRazonsoc() {
        return razonsoc;
    }

    public void setRazonsoc(String razonsoc) {
        this.razonsoc = razonsoc;
    }

    public String getEmptipo() {
        return emptipo;
    }

    public void setEmptipo(String emptipo) {
        this.emptipo = emptipo;
    }

    public String getEmpsector() {
        return empsector;
    }

    public void setEmpsector(String empsector) {
        this.empsector = empsector;
    }

    public String getEmprepresent() {
        return emprepresent;
    }

    public void setEmprepresent(String emprepresent) {
        this.emprepresent = emprepresent;
    }

    public String getDocnum() {
        return docnum;
    }

    public void setDocnum(String docnum) {
        this.docnum = docnum;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTrabdir() {
        return trabdir;
    }

    public void setTrabdir(String trabdir) {
        this.trabdir = trabdir;
    }

    public String getTrabcargo() {
        return trabcargo;
    }

    public void setTrabcargo(String trabcargo) {
        this.trabcargo = trabcargo;
    }

    public Integer getPadreId() {
        return padreId;
    }

    public void setPadreId(Integer padreId) {
        this.padreId = padreId;
    }

    public Pais getPaisId() {
        return paisId;
    }

    public void setPaisId(Pais paisId) {
        this.paisId = paisId;
    }

    public DocumentoIdentidad getDocumentoIdentidadId() {
        return documentoIdentidadId;
    }

    public void setDocumentoIdentidadId(DocumentoIdentidad documentoIdentidadId) {
        this.documentoIdentidadId = documentoIdentidadId;
    }

    @XmlTransient
    public Set<ProyectoUsuario> getProyectoUsuarioSet() {
        return proyectoUsuarioSet;
    }

    public void setProyectoUsuarioSet(Set<ProyectoUsuario> proyectoUsuarioSet) {
        this.proyectoUsuarioSet = proyectoUsuarioSet;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kenny.app.domain.Usuario[ id=" + id + " ]"+proyectoUsuarioSet.size();
    }
    
}
