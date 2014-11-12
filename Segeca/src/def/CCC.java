/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package def;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mark
 */
@Entity
@Table(name = "CCC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ccc.findAll", query = "SELECT c FROM Ccc c"),
    @NamedQuery(name = "Ccc.findByNombreCCC", query = "SELECT c FROM Ccc c WHERE c.nombreCCC = :nombreCCC"),
    @NamedQuery(name = "Ccc.findByPresidente", query = "SELECT c FROM Ccc c WHERE c.presidente = :presidente"),
    @NamedQuery(name = "Ccc.findBySecretario", query = "SELECT c FROM Ccc c WHERE c.secretario = :secretario"),
    @NamedQuery(name = "Ccc.findByAdministrador", query = "SELECT c FROM Ccc c WHERE c.administrador = :administrador")})
public class Ccc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nombre_CCC")
    private String nombreCCC;
    @Column(name = "presidente")
    private String presidente;
    @Column(name = "secretario")
    private String secretario;
    @Column(name = "administrador")
    private String administrador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ccc")
    private Collection<Agenda> agendaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ccc")
    private Collection<Persona> personasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ccc")
    private Collection<Pc> pcCollection;

    public Ccc() {
    }

    public Ccc(String nombreCCC) {
        this.nombreCCC = nombreCCC;
    }

    public String getNombreCCC() {
        return nombreCCC;
    }

    public void setNombreCCC(String nombreCCC) {
        this.nombreCCC = nombreCCC;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public String getSecretario() {
        return secretario;
    }

    public void setSecretario(String secretario) {
        this.secretario = secretario;
    }

    public String getAdministrador() {
        return administrador;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }

    @XmlTransient
    public Collection<Agenda> getAgendaCollection() {
        return agendaCollection;
    }

    public void setAgendaCollection(Collection<Agenda> agendaCollection) {
        this.agendaCollection = agendaCollection;
    }

    @XmlTransient
    public Collection<Persona> getPersonasCollection() {
        return personasCollection;
    }

    public void setPersonasCollection(Collection<Persona> personasCollection) {
        this.personasCollection = personasCollection;
    }

    @XmlTransient
    public Collection<Pc> getPcCollection() {
        return pcCollection;
    }

    public void setPcCollection(Collection<Pc> pcCollection) {
        this.pcCollection = pcCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombreCCC != null ? nombreCCC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ccc)) {
            return false;
        }
        Ccc other = (Ccc) object;
        if ((this.nombreCCC == null && other.nombreCCC != null) || (this.nombreCCC != null && !this.nombreCCC.equals(other.nombreCCC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "segeca.Ccc[ nombreCCC=" + nombreCCC + " ]";
    }
    
}
