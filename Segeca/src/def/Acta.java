/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package def;

import java.io.Serializable;

/**
 *
 * @author Mark
 */
public class Acta implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer codActa;
    private String ausencias;
    private String resultados;
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

    public int hashCode() {
        int hash = 0;
        hash += (codActa != null ? codActa.hashCode() : 0);
        return hash;
    }

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

    public String toString() {
        return "segeca.Acta[ codActa=" + codActa + " ]";
    }
    
}
