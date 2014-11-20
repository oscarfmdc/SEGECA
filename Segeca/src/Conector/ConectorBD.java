package Conector;

import java.sql.*;
import java.util.*;
import def.*;

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
			}else{//Si no, lo introuducimos por primera vez
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

	/*
	 * CCC
	 */
	public void introducirCCC(def.Ccc ccc){
		try{
			ResultSet resultado = statement.executeQuery("select * from CCC where nombre_CCC='"+ ccc.getNombreCCC() +"'");
			if (resultado.next()){//Si ya estaba este usuario actualizamos sus campos
				statement.executeUpdate("update `CCC` set secretario="+ccc.getSecretario()+
						", administrador='"+ccc.getAdministrador()+"', miembros='"+ccc.getNombreCCC()+
						"' where `nombre_CCC`='"+ccc.getNombreCCC()+"' limit 1;");
			}else{//Si no, lo introuducimos por primera vez
				statement.executeUpdate("insert into `CCC` set secretario="+ccc.getSecretario()+
						", administrador='"+ccc.getAdministrador()+"', miembros='"+ccc.getNombreCCC()+
						"', `nombre_CCC`='"+ccc.getNombreCCC()+"';");
			}
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("No se han podido introducir los datos de 'CCC' con éxito");
			System.out.println("El CCC a introducir era:\n"+ ccc.toString());
		}
	}

	public void extraerCCC(def.Ccc ccc){
		LinkedList<def.Persona> listaPersonas= new LinkedList<def.Persona>();
		LinkedList<def.Agenda> listaAgendas= new LinkedList<def.Agenda>();
		LinkedList<def.Pc> listaPc= new LinkedList<def.Pc>();
		try{
			ResultSet resultado = statement.executeQuery("select * from CCC where nombre_CCC='"+ ccc.getNombreCCC() +"'");
			if (resultado.next()){
				
				ccc.setAdministrador(resultado.getString("administrador"));
				ccc.setNombreCCC(resultado.getString("nombre_CCC"));
				ccc.setSecretario(resultado.getString("secretario"));
			}
			resultado = statement.executeQuery("select * from Personas where CCC='" + ccc.getNombreCCC() + "'");
			while(resultado.next()){
				def.Persona a = new def.Persona(resultado.getString("nick"));
				a.setCcc(ccc);
				listaPersonas.add(a);
			}			
			Iterator<Persona> personaIterator = listaPersonas.iterator();
			while(personaIterator.hasNext()){
				extraerPersona(personaIterator.next());
			}
			
			resultado = statement.executeQuery("select * from Agenda where ccc='" + ccc.getNombreCCC() + "';");
			while(resultado.next()){
				def.Agenda a = new def.Agenda(resultado.getInt("cod_agenda"));
				a.setCcc(ccc);
				listaAgendas.add(a);
			}
			Iterator<Agenda> agendaIterator = listaAgendas.iterator();
			while(agendaIterator.hasNext()){
				extraerAgenda(agendaIterator.next());
			}
			
			resultado = statement.executeQuery("select * from PC where CCC='" + ccc.getNombreCCC() + "';");
			while(resultado.next()){
				def.Pc a = new def.Pc(resultado.getInt("cod_PC"));
				a.setCcc(ccc);
				listaPc.add(a);
			}
			Iterator<Pc> pcIterator = listaPc.iterator();
			while(pcIterator.hasNext()){
				extraerPc(pcIterator.next());
			}
			ccc.setPersonasCollection(listaPersonas);
			ccc.setAgendaCollection(listaAgendas);
			ccc.setPcCollection(listaPc);
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Error al intentar obtener el CCC de nombre '"+ ccc.getNombreCCC()+"'");
		}
	}
	
	//Obtener listado de CCC
	public LinkedList<String> extraerListaCCC(){
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
	public void introducirAgenda(def.Agenda agenda){
		try{
			ResultSet resultado = statement.executeQuery("select * from Agenda where cod_agenda='"+ agenda.getCodAgenda() +"'");
			if (resultado.next()){//Si ya estaba esta agenda actualizamos sus campos
				statement.executeUpdate("update `Agenda` set lugar="+agenda.getLugar()+
						", proposito='"+agenda.getProposito()+"', fecha='"+agenda.getFecha()+"', hora_fin='"+agenda.getHoraFin()
						+"', hora_inicio='"+ agenda.getHoraInicio()+"', ccc='"+ agenda.getCcc()
						+"' where `cod_agenda`='"+agenda.getCodAgenda()+"' limit 1;");
			}else{//Si no, lo introuducimos por primera vez
				statement.executeUpdate("insert into `Agenda` set lugar="+agenda.getLugar()+", proposito='"+agenda.getProposito()
						+"', fecha='"+agenda.getFecha()+"', hora_fin='"+agenda.getHoraFin()+"', hora_inicio='"
						+ agenda.getHoraInicio() +"', `cod_agenda`='"+agenda.getCodAgenda()+"';");
			}
		}catch (Exception e){
			System.out.println("No se han podido introducir los datos de 'Agenda' con éxito");
			System.out.println("La agenda a introducir era:\n"+ agenda.toString());
		}
	}

	public void extraerAgenda(def.Agenda agenda){
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
			System.out.println("Error al intentar obtener la Agenda con código "+ agenda.getCodAgenda());
		}
	}
	
	/*
	 * PC
	 */
	public void extraerPc(def.Pc pc){
		try{
			ResultSet resultado = statement.executeQuery("select * from PC where cod_PC='"+ pc.getCodPC() +"'");
			if (resultado.next()){
				def.Agenda agenda = new def.Agenda(resultado.getInt("agenda"));
				extraerAgenda(agenda);
				pc.setAgenda(agenda);
				def.Ccc ccc = new def.Ccc(resultado.getString("CCC"));
				pc.setCcc(ccc);
				pc.setDescripcion(resultado.getString("descripcion"));
				pc.setDocumentos(resultado.getString("documentos"));
				pc.setEmail(resultado.getString("email"));
				pc.setEstado(resultado.getString("estado"));
				//set fecha hay que cambiarlo cuando cambie la base de datos
				pc.setFecha(resultado.getDate("fecha"));
				pc.setMotivo(resultado.getString("motivo"));
				pc.setPrioridad(resultado.getString("prioridad"));
				pc.setValoracion(resultado.getString("valoracion"));
			}
		}catch (Exception E){
			
		}
	}
}
