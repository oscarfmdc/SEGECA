/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package def;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mark
 */
@Entity
@Table(name = "Agenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agenda.findAll", query = "SELECT a FROM Agenda a"),
    @NamedQuery(name = "Agenda.findByCodAgenda", query = "SELECT a FROM Agenda a WHERE a.codAgenda = :codAgenda"),
    @NamedQuery(name = "Agenda.findByFecha", query = "SELECT a FROM Agenda a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "Agenda.findByLugar", query = "SELECT a FROM Agenda a WHERE a.lugar = :lugar"),
    @NamedQuery(name = "Agenda.findByProposito", query = "SELECT a FROM Agenda a WHERE a.proposito = :proposito"),
    @NamedQuery(name = "Agenda.findByParticipantes", query = "SELECT a FROM Agenda a WHERE a.participantes = :participantes"),
    @NamedQuery(name = "Agenda.findByHoraInicio", query = "SELECT a FROM Agenda a WHERE a.horaInicio = :horaInicio"),
    @NamedQuery(name = "Agenda.findByHoraFin", query = "SELECT a FROM Agenda a WHERE a.horaFin = :horaFin")})
public class Agenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_agenda")
    private Integer codAgenda;
    @Basic(optional = false)
    @Column(name = "fecha")
    private String fecha;
    @Column(name = "lugar")
    private String lugar;
    @Column(name = "proposito")
    private String proposito;
    @Column(name = "participantes")
    private String participantes;
    @Column(name = "hora_inicio")
    private String horaInicio;
    @Column(name = "hora_fin")
    private String horaFin;
    @JoinColumn(name = "ccc", referencedColumnName = "nombre_CCC")
    @ManyToOne(optional = false)
    private Ccc ccc;

    public Agenda() {
    }

    public Agenda(Integer codAgenda) {
        this.codAgenda = codAgenda;
    }

    public Agenda(Integer codAgenda, String fecha) {
        this.codAgenda = codAgenda;
        this.fecha = fecha;
    }

    public Integer getCodAgenda() {
        return codAgenda;
    }

    public void setCodAgenda(Integer codAgenda) {
        this.codAgenda = codAgenda;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getProposito() {
        return proposito;
    }

    public void setProposito(String proposito) {
        this.proposito = proposito;
    }

    public String getParticipantes() {
        return participantes;
    }

    public void setParticipantes(String participantes) {
        this.participantes = participantes;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public Ccc getCcc() {
        return ccc;
    }

    public void setCcc(Ccc ccc) {
        this.ccc = ccc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAgenda != null ? codAgenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agenda)) {
            return false;
        }
        Agenda other = (Agenda) object;
        if ((this.codAgenda == null && other.codAgenda != null) || (this.codAgenda != null && !this.codAgenda.equals(other.codAgenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pruebas.Agenda[ codAgenda=" + codAgenda + " ]";
    }
    
}
