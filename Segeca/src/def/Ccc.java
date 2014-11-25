package def;

import java.io.Serializable;
import java.util.Collection;

public class Ccc implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombreCCC;
	private String presidente;
	private String secretario;
	private String administrador;
	private Collection<Agenda> agendaCollection;
	private Collection<Persona> personasCollection;
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

	public Collection<Agenda> getAgendaCollection() {
		return agendaCollection;
	}

	public void setAgendaCollection(Collection<Agenda> agendaCollection) {
		this.agendaCollection = agendaCollection;
	}

	public Collection<Persona> getPersonasCollection() {
		return personasCollection;
	}

	public void setPersonasCollection(Collection<Persona> personasCollection) {
		this.personasCollection = personasCollection;
	}

	public Collection<Pc> getPcCollection() {
		return pcCollection;
	}

	public void setPcCollection(Collection<Pc> pcCollection) {
		this.pcCollection = pcCollection;
	}
}
