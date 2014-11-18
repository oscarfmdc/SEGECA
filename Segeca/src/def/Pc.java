/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package def;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author Mark
 */

public class Pc implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer codPC;
    private String email;
    private String motivo;
    private String descripcion;
    private String prioridad;
    private String fecha;
    private String estado;
    private String valoracion;
    private String documentos;
    private Ccc ccc;

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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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

    public int hashCode() {
        int hash = 0;
        hash += (codPC != null ? codPC.hashCode() : 0);
        return hash;
    }

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

    public String toString() {
        return "segeca.Pc[ codPC=" + codPC + " ]";
    }
    
}
