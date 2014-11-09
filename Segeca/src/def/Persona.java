package def;

public class Persona {

	private String nombre;
	private String nick; 
	private String email;
	private String ccc;
	private int telefono;
	private String permisos;
	
	public String toString(){
		return "*****Persona*****" +
				"\n* Nick: "+ nick +
				"\n* Nombre: "+ nombre +
				"\n* CCC: "+ ccc +
				"\n* Email: " + email +
				"\n* Teléfono: " + telefono +
				"\n* Permisos: " + permisos;
	}
	public String getPermisos() {
		return permisos;
	}
	public void setPermisos(String permisos) {
		this.permisos = permisos;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getCcc() {
		return ccc;
	}
	public void setCcc(String ccc) {
		this.ccc = ccc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
