package Conector;
import java.sql.*;

public class ConectorBD {

	private String url;
	private String dbName;
	private String driver;
	private String userName;
	private String password;
	private Connection conexion;
	private Statement statement;

	public ConectorBD() {
		//crear conexión a BD con los parámetros pasados
		url = "jdbc:mysql://192.168.1.84:3306/";
		dbName = "SEGECA";
		driver = "com.mysql.jdbc.Driver";
		userName = "admin";
		password = "Grupo10";

		try {
			Class.forName(driver).newInstance();
			conexion = DriverManager.getConnection(url+dbName,userName,password);
			System.out.println("Estoy conectado!!!");
			statement = conexion.createStatement();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void desconectar(){
		try{
			conexion.close();
			System.out.println("Ya no!!");
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	/*
	 * PERSONA
	 */
	public void introducirPersona(def.Persona persona){
		try{
			ResultSet resultado = statement.executeQuery("select * from Personas where nick='"+ persona.getNick() +"'");
			if (resultado.next()){//Si ya estaba este usuario actualizamos sus campos
				statement.executeUpdate("update `Personas` set telefono="+persona.getTelefono()+
						", email='"+persona.getEmail()+"', CCC='"+persona.getCcc()+"', nombre='"+
						persona.getNombre()+"', permisos='"+ persona.getPermisos() +"' where `nick`='"+persona.getNick()+"' limit 1;");
			}else{//Si no, lo introudcimos por primera vez
				statement.executeUpdate("insert into `Personas` set telefono="+persona.getTelefono()+
						", email='"+persona.getEmail()+"', CCC='"+persona.getCcc()+"', nombre='"+
						persona.getNombre()+"', permisos='"+ persona.getPermisos() +"', `nick`='"+persona.getNick()+"';");
			}
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("No se han podido introducir los datos de 'Persona' con éxito");
			System.out.println("La persona a introducir era:\n"+ persona.toString());
		}
	}

	public void extraerPersona(def.Persona persona){
		try{
			ResultSet resultado = statement.executeQuery("select * from Personas where nick='"+ persona.getNick() +"'");
			if (resultado.next()){
				persona.setCcc(resultado.getString("CCC"));
				persona.setEmail(resultado.getString("email"));
				persona.setNick(resultado.getString("nick"));
				persona.setNombre(resultado.getString("nombre"));
				persona.setPermisos(resultado.getString("permisos"));
				persona.setTelefono(resultado.getInt("telefono"));
			}
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Error al intentar obtener la persona con nick "+ persona.getNick());
		}
	}
	
	/*
	 * CCC
	 */
	public void introducirCCC(def.CCC ccc){
		try{
			ResultSet resultado = statement.executeQuery("select * from CCC where nombre_CCC='"+ ccc.getNombre_CCC() +"'");
			if (resultado.next()){//Si ya estaba este usuario actualizamos sus campos
				statement.executeUpdate("update `CCC` set secretario="+ccc.getSecretario()+
						", administrador='"+ccc.getAdministrador()+"', miembros='"+ccc.getMiembros()+
						"' where `nombre_CCC`='"+ccc.getNombre_CCC()+"' limit 1;");
			}else{//Si no, lo introudcimos por primera vez
				statement.executeUpdate("insert into `CCC` set secretario="+ccc.getSecretario()+
						", administrador='"+ccc.getAdministrador()+"', miembros='"+ccc.getMiembros()+
						"', `nombre_CCC`='"+ccc.getNombre_CCC()+"';");
			}
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("No se han podido introducir los datos de 'CCC' con éxito");
			System.out.println("El CCC a introducir era:\n"+ ccc.toString());
		}
	}

	public void extraerCCC(def.CCC ccc){
		try{
			ResultSet resultado = statement.executeQuery("select * from CCC where nombre_CCC='"+ ccc.getNombre_CCC() +"'");
			if (resultado.next()){
				ccc.setAdministrador(resultado.getString("administrador"));
				ccc.setMiembros(resultado.getString("miembros"));
				ccc.setNombre_CCC(resultado.getString("nombre_CCC"));
				ccc.setSecretario(resultado.getString("secretario"));
			}
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Error al intentar obtener el CCC de nombre "+ ccc.getNombre_CCC());
		}
	}
}
