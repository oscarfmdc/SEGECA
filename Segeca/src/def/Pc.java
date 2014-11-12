/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package def;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mark
 */
@Entity
@Table(name = "PC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pc.findAll", query = "SELECT p FROM Pc p"),
    @NamedQuery(name = "Pc.findByCodPC", query = "SELECT p FROM Pc p WHERE p.codPC = :codPC"),
    @NamedQuery(name = "Pc.findByEmail", query = "SELECT p FROM Pc p WHERE p.email = :email"),
    @NamedQuery(name = "Pc.findByMotivo", query = "SELECT p FROM Pc p WHERE p.motivo = :motivo"),
    @NamedQuery(name = "Pc.findByDescripcion", query = "SELECT p FROM Pc p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Pc.findByPrioridad", query = "SELECT p FROM Pc p WHERE p.prioridad = :prioridad"),
    @NamedQuery(name = "Pc.findByFecha", query = "SELECT p FROM Pc p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "Pc.findByEstado", query = "SELECT p FROM Pc p WHERE p.estado = :estado"),
    @NamedQuery(name = "Pc.findByValoracion", query = "SELECT p FROM Pc p WHERE p.valoracion = :valoracion"),
    @NamedQuery(name = "Pc.findByDocumentos", query = "SELECT p FROM Pc p WHERE p.documentos = :documentos")})
public class Pc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_PC")
    private Integer codPC;
    @Column(name = "email")
    private String email;
    @Column(name = "motivo")
    private String motivo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "prioridad")
    private String prioridad;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "estado")
    private String estado;
    @Column(name = "valoracion")
    private String valoracion;
    @Column(name = "documentos")
    private String documentos;
    @JoinColumn(name = "CCC", referencedColumnName = "nombre_CCC")
    @ManyToOne(optional = false)
    private Ccc ccc;
    @JoinColumn(name = "agenda", referencedColumnName = "cod_agenda")
    @ManyToOne(optional = false)
    private Agenda agenda;

    public Pc() {
    }

    public Pc(Integer codPC) {
        this.codPC = codPC;
    }

    public Integer getCodPC() {
        return codPC;
    }

    public void setCodPC(Integer codPC) {
        this.codPC = codPC;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public String getDocumentos() {
        return documentos;
    }

    public void setDocumentos(String documentos) {
        this.documentos = documentos;
    }

    public Ccc getCcc() {
        return ccc;
    }

    public void setCcc(Ccc ccc) {
        this.ccc = ccc;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPC != null ? codPC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pc)) {
            return false;
        }
        Pc other = (Pc) object;
        if ((this.codPC == null && other.codPC != null) || (this.codPC != null && !this.codPC.equals(other.codPC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "segeca.Pc[ codPC=" + codPC + " ]";
    }
    
}
