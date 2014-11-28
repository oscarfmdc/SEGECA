package Conector;

import java.sql.*;
import java.util.*;
import def.*;

public class ConectorBD {

	private static Connection conexion;
	private static Statement statement;

	public ConectorBD(String host,String nombreBD, String usuario, String password) {
		//nombreBD = "SEGECA";
		//usuario = "admin";
		//password = "Grupo10";
		String url = "jdbc:mysql://"+ host + "/";
		String driver = "com.mysql.jdbc.Driver";

		try {
			Class.forName(driver).newInstance();
			conexion = DriverManager.getConnection(url+nombreBD,usuario,password);
			System.out.println("Estoy conectado!!!");
			statement = conexion.createStatement();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		//Este método sólo se le llama cuando se desean hacer las pruebas unitarias
		//pruebas.PU.PU_ConectorBD();
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
	public static void createPersona(def.Persona persona){
		try{
			ResultSet resultado = statement.executeQuery("select * from Personas where nick='"+ persona.getNick() +"'");
			if (resultado.next()){//Si ya estaba este usuario actualizamos sus campos
				statement.executeUpdate("update `Personas` set telefono="+persona.getTelefono()+
						", email='"+persona.getEmail()+"', CCC='"+persona.getCcc().getNombreCCC()+"', nombre='"+
						persona.getNombre()+"', permisos='"+ persona.getPermisos() +"' where `nick`='"+persona.getNick()+"' limit 1;");
			}else{//Si no, lo introuducimos por primera vez
				statement.executeUpdate("insert into `Personas` set telefono='"+persona.getTelefono()+
						"', email='"+persona.getEmail()+"', CCC='"+persona.getCcc().getNombreCCC()+"', nombre='"+
						persona.getNombre()+"', permisos='"+ persona.getPermisos() +"', `nick`='"+persona.getNick()+"';");
			}
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("No se han podido introducir los datos de 'Persona' con éxito");
			System.out.println("La persona a introducir era:\n"+ persona.toString());
		}
	}

	public static void extractPersona(def.Persona persona){
		try{
			ResultSet resultadoPersona = statement.executeQuery("select * from Personas where nick='"+ persona.getNick() +"'");
			if (resultadoPersona.next()){
				def.Ccc ccc = new def.Ccc(resultadoPersona.getString("CCC"));
				persona.setCcc(ccc);
				persona.setEmail(resultadoPersona.getString("email"));
				persona.setNick(resultadoPersona.getString("nick"));
				persona.setNombre(resultadoPersona.getString("nombre"));
				persona.setPermisos(resultadoPersona.getString("permisos"));
				persona.setTelefono(resultadoPersona.getInt("telefono"));
			}
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Error al intentar obtener la persona con nick "+ persona.getNick());
		}
	}
	public static void deletePersonaCCC(String persona){
		try {
			statement.executeUpdate("delete from `Personas` where `nick`='"+ persona +"' limit 1");
		} catch (SQLException e) {
			System.out.println("Error al intentar eliminar la persona: " + persona);
		}
	}

	public static void addPersonaCCC(Persona persona){
		createPersona(persona);
	}
	public static void editPerson(Persona persona){
		createPersona(persona);
	}

	/*
	 * CCC
	 */
	public static void createCCC(Ccc ccc){
		try{
			ResultSet resultado = statement.executeQuery("select * from CCC where nombre_CCC='"+ ccc.getNombreCCC() +"'");
			if (resultado.next()){//Si ya estaba este usuario actualizamos sus campos
				statement.executeUpdate("update `CCC` set secretario='"+ccc.getSecretario()+
						"', administrador='"+ccc.getAdministrador()+"', presidente='"+ccc.getPresidente()+
						"' where `nombre_CCC`='"+ccc.getNombreCCC()+"' limit 1;");
			}else{//Si no, lo introuducimos por primera vez
				statement.executeUpdate("insert into `CCC` set secretario='"+ccc.getSecretario()+
						"', administrador='"+ccc.getAdministrador()+"', presidente='"+ccc.getPresidente()+
						"', `nombre_CCC`='"+ccc.getNombreCCC()+"';");
			}
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("No se han podido introducir los datos de 'CCC' con éxito");
			System.out.println("El CCC a introducir era:\n"+ ccc.getNombreCCC());
		}
	}

	public static void extractCCC(def.Ccc ccc){
		LinkedList<def.Persona> listaPersonas= new LinkedList<def.Persona>();
		LinkedList<def.Agenda> listaAgendas= new LinkedList<def.Agenda>();
		LinkedList<def.Pc> listaPc= new LinkedList<def.Pc>();
		try{
			ResultSet resultado = statement.executeQuery("select * from CCC where nombre_CCC='"+ ccc.getNombreCCC() +"'");
			if (resultado.next()){

				ccc.setAdministrador(resultado.getString("administrador"));
				ccc.setNombreCCC(resultado.getString("nombre_CCC"));
				ccc.setSecretario(resultado.getString("secretario"));
				ccc.setPresidente(resultado.getString("presidente"));
			}
			resultado = statement.executeQuery("select * from Personas where CCC='" + ccc.getNombreCCC() + "'");
			while(resultado.next()){
				def.Persona a = new def.Persona(resultado.getString("nick"));
				a.setCcc(ccc);
				listaPersonas.add(a);
			}			
			Iterator<Persona> personaIterator = listaPersonas.iterator();
			while(personaIterator.hasNext()){
				extractPersona(personaIterator.next());
			}

			resultado = statement.executeQuery("select * from Agenda where ccc='" + ccc.getNombreCCC() + "';");
			while(resultado.next()){
				def.Agenda a = new def.Agenda(resultado.getInt("cod_agenda"));
				a.setCcc(ccc);
				listaAgendas.add(a);
			}
			Iterator<Agenda> agendaIterator = listaAgendas.iterator();
			while(agendaIterator.hasNext()){
				extractAgenda(agendaIterator.next());
			}

			resultado = statement.executeQuery("select * from PC where CCC='" + ccc.getNombreCCC() + "';");
			while(resultado.next()){
				def.Pc a = new def.Pc(resultado.getInt("cod_PC"));
				a.setCcc(ccc);
				listaPc.add(a);
			}
			Iterator<Pc> pcIterator = listaPc.iterator();
			while(pcIterator.hasNext()){
				extractPc(pcIterator.next());
			}
			ccc.setPersonasCollection(listaPersonas);
			ccc.setAgendaCollection(listaAgendas);
			ccc.setPcCollection(listaPc);
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Error al intentar obtener el CCC de nombre: "+ ccc.getNombreCCC());
		}
	}

	public static void deleteCCC(String nombreCcc){
		try {
			statement.executeUpdate("delete from `CCC` where `nombre_CCC`='"+ nombreCcc +"' limit 1");
		} catch (SQLException e) {
			System.out.println("Error al intentar eliminar el CCC: " + nombreCcc);
		}
	}

	//Obtener listado de CCC
	public static LinkedList<String> extraerListaCCC(){
		LinkedList<String> lista = new LinkedList<String>();
		try{
			ResultSet resultado = statement.executeQuery("select * from CCC");
			while(resultado.next()){
				lista.add(resultado.getString("nombre_CCC"));
			}
		}catch (Exception e){
			System.out.println("Error al intentar obtener el listado de CCC disponibles");
		}
		return lista;
	}

	/*
	 * AGENDA
	 */
	public static void createAgenda(Agenda agenda){
		try{
			if (agenda.getCodAgenda() == null){
				statement.executeUpdate("insert into `Agenda` set lugar='"+agenda.getLugar()+"', proposito='"+agenda.getProposito()
						+"', fecha='"+agenda.getFecha()+"', participantes='"+agenda.getParticipantes()+"', hora_fin='"+agenda.getHoraFin()+"', hora_inicio='"
						+ agenda.getHoraInicio() +"', ccc='"+ agenda.getCcc().getNombreCCC()+"'");
			}else{
				ResultSet resultado = statement.executeQuery("select * from Agenda where cod_agenda='"+ agenda.getCodAgenda() +"'");
				if (resultado.next()){//Si ya estaba esta agenda actualizamos sus campos
					statement.executeUpdate("update `Agenda` set lugar='"+agenda.getLugar()+"', participantes='"+agenda.getParticipantes()+
							"', proposito='"+agenda.getProposito()+"', fecha='"+agenda.getFecha()+"', hora_fin='"+agenda.getHoraFin()
							+"', hora_inicio='"+ agenda.getHoraInicio()+"', ccc='"+ agenda.getCcc().getNombreCCC()
							+"' where `cod_agenda`='"+agenda.getCodAgenda()+"' limit 1;");
				}else{
					System.out.println("El código de Agenda todavía no existe en la base de Datos." +
							"\n Para crear una agenda nueva codAgenda debe de ser null.");
				}
			}
		}catch (Exception e){
			System.out.println("No se han podido introducir los datos de 'Agenda' con éxito");
			System.out.println("La agenda a introducir era: "+ agenda.toString());
		}
	}

	public static void extractAgenda(def.Agenda agenda){
		try{
			ResultSet resultado = statement.executeQuery("select * from Agenda where cod_agenda='"+ agenda.getCodAgenda() +"'");
			if (resultado.next()){
				def.Ccc ccc = new def.Ccc(resultado.getString("ccc"));
				agenda.setCcc(ccc);
				agenda.setParticipantes(resultado.getString("participantes"));
				agenda.setCodAgenda(resultado.getInt("cod_agenda"));
				agenda.setFecha(resultado.getString("fecha"));
				agenda.setHoraFin(resultado.getString("hora_fin"));
				agenda.setHoraInicio(resultado.getString("hora_inicio"));
				agenda.setLugar(resultado.getString("lugar"));
				agenda.setProposito(resultado.getString("proposito"));		
			}
		}catch (Exception e){
			System.out.println("Error al intentar obtener la Agenda con código: "+ agenda.getCodAgenda());
		}
	}
	
	//ESTA BUSCANDO POR FECHA PARA QUE FUNCIONE LA PRESENTACION
	public static void extractAgendaX(def.Agenda agenda){
		try{
			ResultSet resultado = statement.executeQuery("select * from Agenda where fecha='"+ agenda.getFecha() +"'");
			if (resultado.next()){
				def.Ccc ccc = new def.Ccc(resultado.getString("ccc"));
				agenda.setCcc(ccc);
				agenda.setParticipantes(resultado.getString("participantes"));
				agenda.setCodAgenda(resultado.getInt("cod_agenda"));
				agenda.setFecha(resultado.getString("fecha"));
				agenda.setHoraFin(resultado.getString("hora_fin"));
				agenda.setHoraInicio(resultado.getString("hora_inicio"));
				agenda.setLugar(resultado.getString("lugar"));
				agenda.setProposito(resultado.getString("proposito"));		
			}
		}catch (Exception e){
			System.out.println("Error al intentar obtener la Agenda con código: "+ agenda.getCodAgenda());
		}
	}

	public static void deleteAgenda(int codAgenda){
		try {
			statement.executeUpdate("delete from `Agenda` where `cod_agenda`='"+ codAgenda +"' limit 1");
		} catch (SQLException e) {
			System.out.println("Error al intentar eliminar la Agenda: " + codAgenda);
		}
	}

	/*
	 * PC
	 */

	public static void createPc(Pc pc){
		//TODO no prioritario
	}
	public static void extractPc(Pc pc){
		try{
			ResultSet resultado = statement.executeQuery("select * from PC where cod_PC='"+ pc.getCodPC() +"'");
			if (resultado.next()){
				def.Ccc ccc = new def.Ccc(resultado.getString("CCC"));
				pc.setCcc(ccc);
				pc.setDescripcion(resultado.getString("descripcion"));
				pc.setDocumentos(resultado.getString("documentos"));
				pc.setEmail(resultado.getString("email"));
				pc.setEstado(resultado.getString("estado"));
				pc.setFecha(resultado.getString("fecha"));
				pc.setMotivo(resultado.getString("motivo"));
				pc.setPrioridad(resultado.getString("prioridad"));
				pc.setValoracion(resultado.getString("valoracion"));
				def.Agenda agenda = new def.Agenda(resultado.getInt("agenda"));
				extractAgenda(agenda);
				pc.setAgenda(agenda);
			}
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Error al intentar obtener la PC con código: "+ pc.getCodPC());
		}
	}

	/*
	 * ACTA
	 */
	public static void createActa(Acta acta){
		try{
			if(acta.getCodActa() == null){
				statement.executeUpdate("insert into `Acta` set agenda='"+acta.getAgenda().getCodAgenda()+
						"', ausencias='"+acta.getAusencias()+"', resultados='"+acta.getResultados()
						+"'");
			}else{
				ResultSet resultado = statement.executeQuery("select * from Acta where cod_acta='"+ acta.getCodActa() +"'");
				if (resultado.next()){//Si ya estaba este acta actualizamos sus campos
					statement.executeUpdate("update `Acta` set agenda='"+acta.getAgenda().getCodAgenda()+
							"', ausencias='"+acta.getAusencias()+"', resultados='"+acta.getResultados()
							+"' where `cod_acta`='"+acta.getCodActa()+"' limit 1;");
				}else{
					System.out.println("El código de Acta todavía no existe en la base de Datos." +
							"\n Para crear un acta nueva codActa debe de ser null.");
				}
			}
		}catch (Exception e){
			System.out.println("No se han podido introducir los datos del Acta con éxito");
			System.out.println("El acta a introducir era: "+ acta.toString());
		}
	}
	public static void extractActa(Acta acta){
		try{
			ResultSet resultado = statement.executeQuery("select * from Acta where cod_acta='"+ acta.getCodActa() +"'");
			if (resultado.next()){
				acta.setAusencias(resultado.getString("ausencias"));
				acta.setResultados(resultado.getString("resultados"));
				def.Agenda agenda = new def.Agenda(resultado.getInt("agenda"));
				acta.setAgenda(agenda);
				extractAgenda(agenda);
			}
		}catch (Exception E){
			System.out.println("Error al intentar obtener el Acta con código: "+ acta.getCodActa());
		}
	}

	public static void deleteActa(int codActa){
		try {
			statement.executeUpdate("delete from `Acta` where `cod_acta`='"+ codActa +"' limit 1");
		} catch (SQLException e) {
			System.out.println("Error al intentar eliminar la Agenda: " + codActa);
		}
	}

	public static int getCodLastAgenda(){
		ResultSet resultado;
		try {
			resultado = statement.executeQuery("select * from Agenda order by cod_agenda desc limit 1");
			if (resultado.next()){
				return resultado.getInt("cod_agenda");
			}
		} catch (SQLException e) {
			return 0;
		}

		return 0;
	}

	public static int getCodLastActa(){
		ResultSet resultado;
		try {
			resultado = statement.executeQuery("select * from Acta order by cod_acta desc limit 1");
			if (resultado.next()){
				return resultado.getInt("cod_acta");
			}
		} catch (SQLException e) {
			return 0;
		}

		return 0;
	}
}
/*
 * Prioritario:
 * No Prioritario(Siguiente iteración):
 * Introducir PC 
 * resto de deletes
 */
