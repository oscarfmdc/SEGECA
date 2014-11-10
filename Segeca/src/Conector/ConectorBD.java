package Conector;
import java.sql.*;

public class ConectorBD {

	private Connection conexion;
	private Statement statement;

	public ConectorBD(String host,String nombreBD, String usuario, String contraseña) {
		//nombreBD = "SEGECA";
		//usuario = "admin";
		//contraseña = "Grupo10";
		String url = "jdbc:mysql://"+ host + "/";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			Class.forName(driver).newInstance();
			conexion = DriverManager.getConnection(url+nombreBD,usuario,contraseña);
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
			System.out.println("Ya no estoy conectado!!");
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
	
	/*
	 * AGENDA
	 */
	public void introducirAgenda(def.Agenda agenda){
		try{
			ResultSet resultado = statement.executeQuery("select * from Agenda where cod_agenda='"+ agenda.getCodAgenda() +"'");
			if (resultado.next()){//Si ya estaba esta agenda actualizamos sus campos
				statement.executeUpdate("update `Agenda` set lugar="+agenda.getLugar()+
						", proposito='"+agenda.getProposito()+"', fecha='"+agenda.getFecha()+"', hora_fin='"+agenda.getHoraFin()
						+"', hora_inicio='"+ agenda.getHoraInicio()+"', ccc='"+ agenda.getCcc()
						+"' where `cod_agenda`='"+agenda.getCodAgenda()+"' limit 1;");
			}else{//Si no, lo introudcimos por primera vez
				statement.executeUpdate("insert into `Agenda` set lugar="+agenda.getLugar()+", proposito='"+agenda.getProposito()
						+"', fecha='"+agenda.getFecha()+"', hora_fin='"+agenda.getHoraFin()+"', hora_inicio='"
						+ agenda.getHoraInicio() +"', `cod_agenda`='"+agenda.getCodAgenda()+"';");
			}
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("No se han podido introducir los datos de 'Agenda' con éxito");
			System.out.println("La persona a introducir era:\n"+ agenda.toString());
		}
	}
	
	public void extraerAgenda(def.Agenda agenda){
		try{
			ResultSet resultado = statement.executeQuery("select * from Agenda where cod_agenda='"+ agenda.getCodAgenda() +"'");
			if (resultado.next()){
				String participantes = resultado.getString("participantes");
				agenda.setParticipantes(participantes.split(" "));
				agenda.setCodAgenda(resultado.getInt("cod_agenda"));
				agenda.setFecha(resultado.getDate("fecha"));
				agenda.setHoraFin(resultado.getTime("hora_fin"));
				agenda.setHoraInicio(resultado.getTime("hora_inicio"));
				agenda.setLugar(resultado.getString("lugar"));
				agenda.setProposito(resultado.getString("proposito"));
				agenda.setCcc(resultado.getString("ccc"));				
			}
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Error al intentar obtener la Agenda con códig "+ agenda.getCodAgenda());
		}
	}
	
	/*
	 * ACTA: Pienso que debería de formar parte de agenda, ya que 
	 * solo se añaden dos campos más y sólo hay un acta por agenda.
	 * Estos dos objetos también irían juntos en la base de datos
	 */
}
