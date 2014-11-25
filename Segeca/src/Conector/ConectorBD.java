package Conector;

import java.sql.*;
import java.util.*;
import def.*;

public class ConectorBD {

	private Connection conexion;
	private Statement statement;

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
		pruebasUnitarias();
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
	public void createPersona(def.Persona persona){
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

	public void extractPersona(def.Persona persona){
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
	public void deletePersonaCCC(String persona){
		try {
			statement.executeUpdate("delete from `Personas` where `nick`='"+ persona +"' limit 1");
		} catch (SQLException e) {
			System.out.println("Error al intentar eliminar la persona: " + persona);
		}
	}

	public void addPersonaCCC(Persona persona){
		createPersona(persona);
	}
	public void editPerson(Persona persona){
		createPersona(persona);
	}
	
	/*
	 * CCC
	 */
	public void createCCC(Ccc ccc){
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

	public void extractCCC(def.Ccc ccc){
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
	
	public void deleteCCC(String nombreCcc){
		try {
			statement.executeUpdate("delete from `CCC` where `nombre_CCC`='"+ nombreCcc +"' limit 1");
		} catch (SQLException e) {
			System.out.println("Error al intentar eliminar el CCC: " + nombreCcc);
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
	public void createAgenda(Agenda agenda){
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

	public void extractAgenda(def.Agenda agenda){
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
	
	public void deleteAgenda(int codAgenda){
		try {
			statement.executeUpdate("delete from `Agenda` where `cod_agenda`='"+ codAgenda +"' limit 1");
		} catch (SQLException e) {
			System.out.println("Error al intentar eliminar la Agenda: " + codAgenda);
		}
	}
	
	/*
	 * PC
	 */
	
	public void createPc(Pc pc){
		//TODO no prioritario
	}
	public void extractPc(Pc pc){
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
	public void createActa(Acta acta){
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
	public void extractActa(Acta acta){
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
	
		public void deleteActa(int codActa){
			try {
				statement.executeUpdate("delete from `Acta` where `cod_acta`='"+ codActa +"' limit 1");
			} catch (SQLException e) {
				System.out.println("Error al intentar eliminar la Agenda: " + codActa);
			}
		}
	/*
	 * PRUEBAS
	 */
	
	//Si una prueba se pasa satisfactoriamente se devuelve true.
	//De estar mal el código a comprobar, se devuelve false.
	private void pruebasUnitarias(){
		System.out.println("Prueba 1. Introducción y extracción de CCC: " + prueba1());
		System.out.println("Prueba 2. Modificación de CCC: " + prueba2());
		System.out.println("Prueba 3. Introducción y extracción de persona: " + prueba3());
		System.out.println("Prueba 4. Modificación de persona: " + prueba4());
		System.out.println("Prueba 5. Introducción y extracción de agenda: " + prueba5());
		System.out.println("Prueba 6. Modificación de agenda: " + prueba6());
		System.out.println("Prueba 7. Introducción y extracción de Acta: " + prueba7());
		System.out.println("Prueba 8. Modificación de Acta: " + prueba8());
		
		//Devolvemos la base de Datos a su estado inicial
		deleteActa(getCodLastActa());
		deleteActa(getCodLastActa());
		deleteAgenda(getCodLastAgenda());
		deleteAgenda(getCodLastAgenda());
		deleteCCC("CCC1");
		deletePersonaCCC("nom1");
		deleteCCC("CCC2");		
	}
	
	private boolean prueba1(){
		boolean resultado = true;
		Ccc CCC1 = new Ccc();
		Ccc CCC2 = new Ccc();
		CCC1.setAdministrador("Administrador1");
		CCC1.setNombreCCC("CCC1");
		CCC1.setPresidente("Presidente1");
		CCC1.setSecretario("Secretario1");
		CCC2.setNombreCCC("CCC1");
		
		createCCC(CCC1);
		extractCCC(CCC2);

		if (!CCC1.getAdministrador().equals(CCC2.getAdministrador())){
			resultado = false;
		}
		if (!CCC1.getNombreCCC().equals(CCC2.getNombreCCC())){
			resultado = false;
		}
		if (!CCC1.getPresidente().equals(CCC2.getPresidente())){
			resultado = false;
		}
		if (!CCC1.getSecretario().equals(CCC2.getSecretario())){
			resultado = false;
		}
		return resultado;
	}
	
	private boolean prueba2(){
		boolean resultado = true;
		Ccc CCC1 = new Ccc();
		Ccc CCC2 = new Ccc();
		CCC1.setAdministrador("Administrador2");
		CCC1.setNombreCCC("CCC1");
		CCC1.setPresidente("Presidente2");
		CCC1.setSecretario("Secretario2");
		CCC2.setNombreCCC("CCC1");
		
		createCCC(CCC1);
		extractCCC(CCC2);

		if (!CCC1.getAdministrador().equals(CCC2.getAdministrador())){
			resultado = false;
		}
		if (!CCC1.getNombreCCC().equals(CCC2.getNombreCCC())){
			resultado = false;
		}
		if (!CCC1.getPresidente().equals(CCC2.getPresidente())){
			resultado = false;
		}
		if (!CCC1.getSecretario().equals(CCC2.getSecretario())){
			resultado = false;
		}
		return resultado;
	}

	private boolean prueba3(){
		boolean resultado = true;
		Ccc CCC1 = new Ccc();
		CCC1.setNombreCCC("CCC1");
		Persona p1 = new Persona();
		Persona p2 = new Persona();
		p1.setCcc(CCC1);
		p1.setEmail("email1@ejemplo.es");
		p1.setNick("nom1");
		p1.setNombre("nombre1");
		p1.setPermisos("admin");
		p1.setTelefono(123456789);
		p2.setNick("nom1");
		
		createPersona(p1);
		extractPersona(p2);
		
		if (!p1.getCcc().getNombreCCC().equals(p2.getCcc().getNombreCCC())){
			resultado = false;
		}
		if (!p1.getEmail().equals(p2.getEmail())){
			resultado = false;
		}
		if (!p1.getNick().equals(p2.getNick())){
			resultado = false;
		}
		if (!p1.getNombre().equals(p2.getNombre())){
			resultado = false;
		}
		if (!p1.getPermisos().equals(p2.getPermisos())){
			resultado = false;
		}
		if (p1.getTelefono()!=(p2.getTelefono())){
			resultado = false;
		}
		return resultado;
	}
	
	private boolean prueba4(){
		boolean resultado = true;
		Ccc CCC2 = new Ccc();
		CCC2.setNombreCCC("CCC2");
		createCCC(CCC2);
		Persona p1 = new Persona();
		Persona p2 = new Persona();
		p1.setCcc(CCC2);
		p1.setEmail("email2@ejemplo.es");
		p1.setNick("nom1");
		p1.setNombre("nombre2");
		p1.setPermisos("user");
		p1.setTelefono(987654321);
		p2.setNick("nom1");
		
		createPersona(p1);
		extractPersona(p2);
		
		if (!p1.getCcc().getNombreCCC().equals(p2.getCcc().getNombreCCC())){
			resultado = false;
		}
		if (!p1.getEmail().equals(p2.getEmail())){
			resultado = false;
		}
		if (!p1.getNick().equals(p2.getNick())){
			resultado = false;
		}
		if (!p1.getNombre().equals(p2.getNombre())){
			resultado = false;
		}
		if (!p1.getPermisos().equals(p2.getPermisos())){
			resultado = false;
		}
		if (p1.getTelefono()!=(p2.getTelefono())){
			resultado = false;
		}
		return resultado;
	}
	
	private boolean prueba5(){
		boolean resultado = true;
		Ccc CCC1 = new Ccc();
		CCC1.setNombreCCC("CCC1");
		Agenda a1 = new Agenda();
		Agenda a2 = new Agenda();
		a1.setCcc(CCC1);
		a1.setFecha("25/12/2014");
		a1.setHoraFin("12:00");
		a1.setHoraInicio("11:00");
		a1.setLugar("Lugar1");
		a1.setParticipantes("Participante1");
		a1.setProposito("Proposito1");
		createAgenda(a1);
		a2.setCodAgenda(getCodLastAgenda());
		extractAgenda(a2);
		
		if (!a1.getCcc().getNombreCCC().equals(a2.getCcc().getNombreCCC())){
			resultado = false;
		}
		if (!a1.getFecha().equals(a2.getFecha())){
			resultado = false;
		}
		if (!a1.getHoraFin().equals(a2.getHoraFin())){
			resultado = false;
		}
		if (!a1.getHoraInicio().equals(a2.getHoraInicio())){
			resultado = false;
		}
		if (!a1.getLugar().equals(a2.getLugar())){
			resultado = false;
		}
		if (!a1.getParticipantes().equals(a2.getParticipantes())){
			resultado = false;
		}
		if (!a1.getProposito().equals(a2.getProposito())){
			resultado = false;
		}
		
		return resultado;
	}
	
	private boolean prueba6(){
		boolean resultado = true;
		Ccc CCC2 = new Ccc();
		CCC2.setNombreCCC("CCC2");
		createCCC(CCC2);
		Agenda a1 = new Agenda();
		Agenda a2 = new Agenda();
		a1.setCcc(CCC2);
		a1.setFecha("26/12/2014");
		a1.setHoraFin("13:00");
		a1.setHoraInicio("12:00");
		a1.setLugar("Lugar2");
		a1.setParticipantes("Participante2");
		a1.setProposito("Proposito2");
		a1.setCodAgenda(getCodLastAgenda());
		createAgenda(a1);
		a2.setCodAgenda(getCodLastAgenda());
		extractAgenda(a2);
		
		if (!a1.getCcc().getNombreCCC().equals(a2.getCcc().getNombreCCC())){
			resultado = false;
		}
		if (!a1.getFecha().equals(a2.getFecha())){
			resultado = false;
		}
		if (!a1.getHoraFin().equals(a2.getHoraFin())){
			resultado = false;
		}
		if (!a1.getHoraInicio().equals(a2.getHoraInicio())){
			resultado = false;
		}
		if (!a1.getLugar().equals(a2.getLugar())){
			resultado = false;
		}
		if (!a1.getParticipantes().equals(a2.getParticipantes())){
			resultado = false;
		}
		if (!a1.getProposito().equals(a2.getProposito())){
			resultado = false;
		}
		
		return resultado;
	}
	
	private boolean prueba7(){
		boolean resultado = true;
		Agenda ag1 = new Agenda();
		ag1.setCodAgenda(getCodLastAgenda());
		Acta acta1 = new Acta();
		Acta acta2 = new Acta();
		acta1.setAgenda(ag1);
		acta1.setAusencias("Ausencia1");
		acta1.setResultados("Resultados1");
		
		createActa(acta1);
		acta2.setCodActa(getCodLastActa());
		extractActa(acta2);
		
		if(!acta1.getAgenda().getCodAgenda().equals(acta2.getAgenda().getCodAgenda())){
			resultado = false;
		}
		if(!acta1.getAusencias().equals(acta2.getAusencias())){
			resultado = false;
		}
		if(!acta1.getResultados().equals(acta2.getResultados())){
			resultado = false;
		}
		
		return resultado;
	}
	
	private boolean prueba8(){
		boolean resultado = true;
		Ccc CCC2 = new Ccc("CCC2");
		Agenda ag1 = new Agenda();
		ag1.setCcc(CCC2);
		createAgenda(ag1);
		ag1.setCodAgenda(getCodLastAgenda());
		Acta acta1 = new Acta();
		Acta acta2 = new Acta();
		acta1.setAgenda(ag1);
		acta1.setAusencias("Ausencia2");
		acta1.setResultados("Resultados2");
		
		createActa(acta1);
		acta2.setCodActa(getCodLastActa());
		extractActa(acta2);
		
		if(!acta1.getAgenda().getCodAgenda().equals(acta2.getAgenda().getCodAgenda())){
			resultado = false;
		}
		if(!acta1.getAusencias().equals(acta2.getAusencias())){
			resultado = false;
		}
		if(!acta1.getResultados().equals(acta2.getResultados())){
			resultado = false;
		}
		
		return resultado;
	}
	
	private int getCodLastAgenda(){
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

private int getCodLastActa(){
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
 * Pruebas unitarias.
 * No Prioritario(Siguiente iteración):
 * Introducir PC no quiero hacerla porque esta todavia mal en la BD (con date e vez de String)
 * resto de deletes
 */
