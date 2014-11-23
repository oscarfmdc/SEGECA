
package def;

import java.io.Serializable;

public class Agenda implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer codAgenda;
    private String fecha;
    private String lugar;
    private String proposito;
    private String participantes;
    private String horaInicio;
    private String horaFin;
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
}
