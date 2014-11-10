package def;

public class CCC {
	private String nombre_CCC;
	private String secretario;
	private String administrador;
	private String miembros;
	
	public String toString(){
		return "*****Persona*****" +
				"\n* Nombre_CCC: "+ nombre_CCC +
				"\n* Secretario: "+ secretario +
				"\n* Administrador: "+ administrador +
				"\n* Miembros: " + miembros;
	}	
	
	public String getMiembros() {
		return miembros;
	}
	public void setMiembros(String miembros) {
		this.miembros = miembros;
	}
	public String getAdministrador() {
		return administrador;
	}
	public void setAdministrador(String administrador) {
		this.administrador = administrador;
	}
	public String getSecretario() {
		return secretario;
	}
	public void setSecretario(String secretario) {
		this.secretario = secretario;
	}
	public String getNombre_CCC() {
		return nombre_CCC;
	}
	public void setNombre_CCC(String nombre_CCC) {
		this.nombre_CCC = nombre_CCC;
	}
	
}
