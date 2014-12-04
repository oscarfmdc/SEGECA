
package def;

import java.io.Serializable;

public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nick;
	private String password;
	private String nombre;
	private String email;
	private int telefono;
	private String permisos;
	private Ccc ccc;

	public Persona() {
	}

	public Persona(String nick) {
		this.nick = nick;
	}

	public Persona(String nick, int telefono) {
		this.nick = nick;
		this.telefono = telefono;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getPermisos() {
		return permisos;
	}

	public void setPermisos(String permisos) {
		this.permisos = permisos;
	}

	public Ccc getCcc() {
		return ccc;
	}

	public void setCcc(Ccc ccc) {
		this.ccc = ccc;
	} 
}
