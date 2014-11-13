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
@Table(name = "Acta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acta.findAll", query = "SELECT a FROM Acta a"),
    @NamedQuery(name = "Acta.findByCodActa", query = "SELECT a FROM Acta a WHERE a.codActa = :codActa"),
    @NamedQuery(name = "Acta.findByAusencias", query = "SELECT a FROM Acta a WHERE a.ausencias = :ausencias"),
    @NamedQuery(name = "Acta.findByResultados", query = "SELECT a FROM Acta a WHERE a.resultados = :resultados")})
public class Acta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_acta")
    private Integer codActa;
    @Column(name = "ausencias")
    private String ausencias;
    @Column(name = "resultados")
    private String resultados;
    @JoinColumn(name = "agenda", referencedColumnName = "cod_agenda")
    @ManyToOne(optional = false)
    private Agenda agenda;

    public Acta() {
    }

    public Acta(Integer codActa) {
        this.codActa = codActa;
    }

    public Integer getCodActa() {
        return codActa;
    }

    public void setCodActa(Integer codActa) {
        this.codActa = codActa;
    }

    public String getAusencias() {
        return ausencias;
    }

    public void setAusencias(String ausencias) {
        this.ausencias = ausencias;
    }

    public String getResultados() {
        return resultados;
    }

    public void setResultados(String resultados) {
        this.resultados = resultados;
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
        hash += (codActa != null ? codActa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acta)) {
            return false;
        }
        Acta other = (Acta) object;
        if ((this.codActa == null && other.codActa != null) || (this.codActa != null && !this.codActa.equals(other.codActa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "segeca.Acta[ codActa=" + codActa + " ]";
    }
    
}
