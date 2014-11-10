package def;

import java.sql.Time;
import java.util.Date;

public class Agenda {
	
	private int codAgenda;
	private Date fecha; 
	private String lugar;
	private String proposito;
	private String[] participantes;
	private Time horaInicio;
	private Time horaFin;
	private String ccc;
	
	public String toString(){
		return "*****Agenda*****" +
				"\n* CodAgenda: "+ codAgenda +
				"\n* Fecha: "+ fecha +
				"\n* horaInicio: "+ horaInicio.toString() +
				"\n* horaFin: "+ horaFin.toString() +
				"\n* Lugar: "+ lugar +
				"\n* Propósito: "+ proposito +
				"\n* Participantes: " + participantes.toString() +
				"\n* CCC al que pertenece: " + ccc;
	}
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
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
	public String[] getParticipantes() {
		return participantes;
	}
	public void setParticipantes(String[] participantes) {
		this.participantes = participantes;
	}
	public Time getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Time getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
	}
	public int getCodAgenda() {
		return codAgenda;
	}
	public void setCodAgenda(int codAgenda) {
		this.codAgenda = codAgenda;
	}
	public String getCcc() {
		return ccc;
	}
	public void setCcc(String ccc) {
		this.ccc = ccc;
	}
}
