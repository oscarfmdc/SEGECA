package ui;

import def.*;
import def.Pc.Estado;

import java.io.IOException;
import java.text.*;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;
//import pruebas.stubs;


public class Controller {

	private static Conector.ConectorBD bd;
	private static String sesion;

	public Controller() {
		bd = new Conector.ConectorBD("ortinson.no-ip.org:80", "SEGECA", "admin", "Grupo10");
		UI.comboBoxCCC = new JComboBox(bd.extraerListaCCC().toArray());
		UI.initialize();
		UI.frame.setVisible(true);
		try {
			UI.frame.setIconImage(ImageIO.read(getClass().getClassLoader().getResource("resources/SegecaIcon.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//pruebas.PU.PU_requisitos();
		//pruebas.PI.pruebaIntegracion();
		//bd.desconectar();
	}


	public static Conector.ConectorBD getBd() {
		return bd;
	}

	/* Requisito 1.2 */
	public static int prepararAgenda() {
		// comprobamos que los datos recibidos sean correctos
		if (!comprobarAgenda()) {
			return -1;
		}
		Agenda ag = new Agenda();

		String nombreCCC = UI.textFieldCCCAgendas.getText();

		//Debemos de comprobar si el Ccc ya existe
		Ccc ccc = new Ccc();
		ccc.setNombreCCC(nombreCCC);

		// rellenamos los campos de la agenda
		ag.setCcc(ccc);
		ag.setFecha(UI.textFieldFechaAgendas.getText());
		ag.setLugar(UI.textFieldLugarAgendas.getText());
		ag.setHoraInicio(UI.textFieldHoraInicioAgendas.getText());
		ag.setHoraFin(UI.textFieldHoraFinAgendas.getText());
		ag.setProposito(UI.textFieldPropositoAgendas.getText());
		ag.setCodAgenda(null);
		ag.setParticipantes(UI.textFieldParticipantesAgendas.getText());

		// Metodo que cree la agenda en la bbdd dado una instancia de clase agenda (enrique)
		bd.createAgenda(ag);
		bd.extractAgendaX(ag);//ESTA BUSCANDO POR FECHA\\\\\\\\\\\\CAMBIAR////////////////
		UI.label_PanelOutput_Output.setText("Output:   CÃƒÂ³digo de Agenda = " + ag.getCodAgenda());
		//Stub para simular el modulo, en la version final comentar
		//stubs.createAgenda(ag);

		JOptionPane.showMessageDialog(null, "La agenda se ha preparado correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);

		return 0;
	}

	/* Metodo auxiliar para comprobar todos los campos de la agenda */
	// Devuelve falso si fallo
	private static boolean comprobarAgenda() {

		String ccc = UI.textFieldCCCAgendas.getText();

		if (ccc == null || ccc.equals("")) {
			JOptionPane.showMessageDialog(null, "No ha seleccionado ningun CCC", "Error", JOptionPane.ERROR_MESSAGE);
		}

		// Comprobacion Fecha
		JTextField fechaAgenda = UI.textFieldFechaAgendas;

		if (!isFechaValida(fechaAgenda.getText())) {
			return false;
		}

		// Comprobacion lugar
		JTextField lugarAgenda = UI.textFieldLugarAgendas;

		if (lugarAgenda.getText().length() > 20) {
			JOptionPane.showMessageDialog(null, "Error al introducir el lugar de la Agenda", "Error", JOptionPane.ERROR_MESSAGE);
		}

		//Comprobamos hora inicio/fin
		JTextField horaInicio = UI.textFieldHoraInicioAgendas;
		JTextField horaFin = UI.textFieldHoraFinAgendas;

		if (!isHoraValida(horaInicio.getText()) || !isHoraValida(horaFin.getText())) {
			return false;
		}

		Date parsedHoraIn = null;
		Date parsedHoraFin = null;

		// Comprobamos que la hora de inicio es anterior a la hora de fin de la reuniÃƒÆ’Ã‚Â³n
		try {
			SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm", Locale.getDefault());
			formatoHora.setLenient(false);
			parsedHoraIn = formatoHora.parse(horaInicio.getText());
			parsedHoraFin = formatoHora.parse(horaFin.getText());
		} catch (java.text.ParseException ex) {
		}

		if (!parsedHoraIn.before(parsedHoraFin)) {
			JOptionPane.showMessageDialog(null, "La hora de inicio debe ser anterior a la hora de fin.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;

	}

	/* Requisito 1.1 */
	public static int prepararActa() {
		Acta acta = new Acta();

		Agenda ag = new Agenda();
		acta.setAgenda(ag);

		// El codigo se extrae desde aqui
		int codAgenda = 0;
		ag.setCodAgenda(codAgenda);

		acta.setAusencias(UI.textFieldAusencias.getText());// Jtexfield con los nombre de los ausentes
		acta.setResultados(UI.textFieldResultados.getText());// Jtexfiled con los resultados obtenidos

		//Cogemos el codigo de agenda de la interfaz grafica
		Agenda newAgenda = new Agenda();
		if (UI.textFieldAgenda.getText() == null) {
			JOptionPane.showMessageDialog(null, "Debe introducir un nombre de una Agenda ", "Error", JOptionPane.ERROR_MESSAGE);
			return -1;
		} else {
			newAgenda.setCodAgenda(Integer.parseInt((UI.textFieldAgenda.getText())));
			//Buscamos la agenda en la base de datos y obtenemos el objeto Agenda completo
			bd.extractAgenda(ag);
			//Asociamos la agenda a nuestro acta
			acta.setAgenda(newAgenda);

			//Metodo que crea el acta en la BD
			bd.createActa(acta);

			JOptionPane.showMessageDialog(null, "El acta se ha preparado correctamente.", "Informacion", JOptionPane.INFORMATION_MESSAGE);

			return 0;
		}
	}

	/* Requisito 2.1 */
	public static void altaCCC() {

		Ccc ccc = new Ccc();

		if ((UI.textFieldNombreCCC.getText() == null) || (UI.textFieldAdministrador.getText() == null) || (UI.textFieldPresidente.getText() == null) || (UI.textFieldSecretario.getText() == null)) {
			JOptionPane.showMessageDialog(null, "Debe introducir los campos necesarios para crear el CCC", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			ccc.setNombreCCC(UI.textFieldNombreCCC.getText());
			ccc.setAdministrador(UI.textFieldAdministrador.getText());
			ccc.setPresidente(UI.textFieldPresidente.getText());
			ccc.setSecretario(UI.textFieldSecretario.getText());

			// lista de miembros esta vacÃƒÆ’Ã‚Â­o
			bd.createCCC(ccc);

			JOptionPane.showMessageDialog(null, "Se ha creado correctamente un nuevo CCC.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/* Requisito 2.2 */
	public static int bajaCCC() {
		JComboBox<?> listaBorrarCCC = UI.comboBoxCCC;
		// comprobamos que el usuario ha seleccionado un CCC para borrar de la lista mostrada
		String nombreBorrarCCC = (String) listaBorrarCCC.getModel().getElementAt(listaBorrarCCC.getSelectedIndex());
		if (listaBorrarCCC.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "No ha seleccionado ningun CCC para dar de baja", "Error", JOptionPane.ERROR_MESSAGE);
			return -1;
		}
		bd.deleteCCC(nombreBorrarCCC);

		JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente el CCC seleccionado.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
		return 0;
	}

	/* Requisito 2.3 */
	public static int modMiembrosCCC() {

		Persona persona = new Persona();
		persona.setNick(UI.textField_PanelMiembro_Nick.getText());
		bd.extractPersona(persona);

		// Establecemos todos los campos que corresponden a las personas
		Ccc cccPrsn = new Ccc((String) UI.comboBoxCCC.getSelectedItem());
		persona.setCcc(cccPrsn);

		//permisos
		persona.setPermisos(UI.textField_PanelMiembro_Permisos.getText());

		// Modificamos la persona con los parÃƒÆ’Ã‚Â¡mtetros correspondientes, (enrique)        
		bd.editPerson(persona);

		JOptionPane.showMessageDialog(null, "Se ha aÃƒÂ±adido el miembro al CCC correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);

		return 0;
	}

	/* Requisito 2.4 */
	public static int altaPersonaCCC() {
		Persona persona = new Persona();

		JTextField nick = UI.textField_PanelMiembro_Nick;
		// compruebo que el campo no esta vacio
		if (nick.getText() == null) {
			JOptionPane.showMessageDialog(null, "Debe introducir un nick para la persona", "Error", JOptionPane.ERROR_MESSAGE);
			return -1;
		} else {
			persona.setNick(nick.getText());
		}

		// JTextField con el nombre de la persona
		JTextField nombre = UI.textField_PanelPerfil_Nombre;
		// compruebo que el campo no esta vacio
		if (nombre.getText() == null) {
			JOptionPane.showMessageDialog(null, "Debe introducir un nombre para la persona", "Error", JOptionPane.ERROR_MESSAGE);
			return -1;
		} else {
			persona.setNombre(nombre.getText());
		}

		// compruebo el telefono
		JTextField telefono = UI.textField_PanelPerfil_Telefono;
		int telf = isTelefono(telefono.getText());
		persona.setTelefono(telf);
		persona.setEmail(UI.textField_PanelPerfil_Email.getText());
		persona.setPermisos(UI.textField_PanelMiembro_Permisos.getText());

		JComboBox<?> CCCs = UI.comboBoxCCC;
		// comprobamos que el usuario ha seleccionado un CCC para asignar la persona a dicho CCC
		String ccc = (String) CCCs.getSelectedItem();
		if (CCCs.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "No ha seleccionado ningun CCC en el que ingresar dicha persona.", "Error", JOptionPane.ERROR_MESSAGE);
			return -1;
		}
		// creamos un objeto Ccc con el nombre del CCC que ha seleccionado el usuario
		Ccc newCCC = new Ccc();
		newCCC.setNombreCCC(ccc);
		persona.setCcc(newCCC);

		bd.addPersonaCCC(persona);

		JOptionPane.showMessageDialog(null, "Se ha dado de alta un nuevo miembro en el CCC seleccionado.", "Informacion", JOptionPane.INFORMATION_MESSAGE);

		return 0;
	}

	// metodo que comprueba y pasa a entero un telefono
	public static int isTelefono(String telefono) {
		int telefonoInt = 0;
		if (telefono.length() != 9) {
			JOptionPane.showMessageDialog(null, "Numero de digitos del numero de telefono incorrecto. Deben ser 9 digitos", "Error", JOptionPane.ERROR_MESSAGE);
		}
		try {
			telefonoInt = Integer.parseInt(telefono); // este null es el JTextField del numero y lo convierto a int
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Inserte numero de telefono valido. Introducir solo digitos", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return telefonoInt;
	}

	/* Requisito 2.5 */
	public static int bajaPersonaCCC() {

		// comprobamos que el usuario ha seleccionado una persona de un CCC para darla de baja
		String nick = UI.textField_PanelBajaMiembro_Nick.getText();
		String ccc = UI.textField_PanelBajaMiembro_CCC.getText();

		if (nick == null) {
			JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna persona para dar de baja en el CCC", "Error", JOptionPane.ERROR_MESSAGE);
			return -1;
		}
		if (ccc == null) {
			JOptionPane.showMessageDialog(null, "No ha seleccionado ningun CCC", "Error", JOptionPane.ERROR_MESSAGE);
			return -1;
		}

		bd.deletePersonaCCC(nick);

		JOptionPane.showMessageDialog(null, "Se ha eliminado del CCC seleccionado al correspondiente miembro.", "Informacion", JOptionPane.INFORMATION_MESSAGE);

		return 0;
	}

	// metodo que comprueba el formato de la fecha
	private static boolean isFechaValida(String fecha) {
		Date parsedDate = null;

		try {
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
			formatoFecha.setLenient(false);
			parsedDate = formatoFecha.parse(fecha);
		} catch (java.text.ParseException ex) {
			JOptionPane.showMessageDialog(null, "El formato de la fecha no es correcto", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		// Fecha actual
		Calendar fechaActual = Calendar.getInstance();

		// Comprobamos que la fecha es posterior a la fecha actual.
		if (!parsedDate.after(fechaActual.getTime())) {
			JOptionPane.showMessageDialog(null, "La fecha de la reunion debe ser posterior a la fecha actual.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}

	// metodo que comprueba el formato de la hora
	public static boolean isHoraValida(String hora) {
		try {
			SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm", Locale.getDefault());
			formatoHora.setLenient(false);
			formatoHora.parse(hora);
		} catch (java.text.ParseException ex) {
			JOptionPane.showMessageDialog(null, "El formato de la hora no es correcto", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	/* Requisito 3.1 */

	// AsignaciÃ³n de PC registrada a un CCC
	public static int PCaCCC() {

		Pc pc = new Pc(Integer.valueOf(UI.textField_PanelPC_CodPC.getText()));
		// nos deben pasar el codPC para asignarle el CCC que eliga el usuario

		bd.extractPc(pc);

		String cccPC = UI.textField_PanelPC_CCC.getText();
		// comprobamos que el usuario ha seleccionado un CCC para asignar la PC        
		if ( cccPC == null) {
			JOptionPane.showMessageDialog(null, "No ha seleccionado ningun CCC para asignar dicha PC.", "Error", JOptionPane.ERROR_MESSAGE);
			return -1;
		}

		// creamos un objeto Ccc con el nombre del CCC que ha seleccionado el usuario
		Ccc newCCC = new Ccc();
		newCCC.setNombreCCC(cccPC);
		pc.setCcc(newCCC);

		// Stub de la BBDD: comentar en la version final
		//stubs.PCaCCC(pc);

		//bd.addPCaCCC(pc); // metodo que debe aÃƒÂ±adir o cambiar el cod de CCC de la PC
		JOptionPane.showMessageDialog(null, "Asignacion PC al CCC corecta.", "Informacion", JOptionPane.INFORMATION_MESSAGE);

		return 0;
	}

	/* Requisito 3.2 */
	// MÃ©todo que asignarÃ¡ una peticiÃ³n de cambio a una reuniÃ³n de un CCC que se celebre con posterioridad
	// IINTERFAZ: TENÃ‰IS QUE MOSTRAR TODAS LAS REUNIONES DEL CCC QUE NO SE HAYAN CELEBRADO Y PASARNOS EL CODIGO DE LA AGENDA
	public static int PcAgendaCCC() {

		Pc pc = new Pc(Integer.valueOf(UI.textField_PanelPC_CodPC.getText()));
		bd.extractPc(pc);

		//Establecemos el cÃ³digo de la agenda
		Agenda ag = new Agenda();
		int codAgenda = Integer.valueOf(UI.textField_PanelPC_Reunion.getText());
		if(!(codAgenda > 0)){
			JOptionPane.showMessageDialog(null, "El cÃ³digo de agenda introducido es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
		}
		ag.setCodAgenda(codAgenda);

		pc.setAgenda(ag);

		// Stub de la bbdd.C Comentar en la versiÃƒÂ³n final
		//stubs.PcAgendaCCC(pc);
		// Metodo que aÃƒÂ±adirÃƒÂ¡ una PC con los parÃƒÂ¡metros que hemos establecido
		bd.addPCagendaCCC(pc);

		JOptionPane.showMessageDialog(null, "Se ha asignado correctamente una peticiÃƒÂ³n de cambio a la reuniÃƒÂ³n correspondiente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
		return 0;
	}

	/* Requisito 3.3 */
	//Metodo que registra PC inicial
	public static int altaPC() {
		Pc pc = new Pc();

		pc.setCodPC(0);

		// Jtextfield con la descripciÃ³n de la PC
		JTextPane descripcionPC = UI.textPane_PanelPCnueva_Descripcion;
		String descripcion = descripcionPC.getText();

		if (descripcion.equals("")) {
			JOptionPane.showMessageDialog(null, "Debe introducir una descripcion para la PC", "Error", JOptionPane.ERROR_MESSAGE);
			return -1;
		} else {
			pc.setDescripcion(descripcion);
		}

		// Comprobacion Fecha
		JTextField fechaPC = UI.textArea_PanelPCnueva_Fecha; //JTextField;
		if (!isFechaValida(fechaPC.getText())) {
			return -1;
		} else {
			pc.setFecha(fechaPC.getText());
		}

		// Jtextfield con el motivo de la PC
		JTextField motivoPC = UI.textArea_PanelPCnueva_Motivo;

		String motivo = motivoPC.getText();
		if (motivo == null) {
			JOptionPane.showMessageDialog(null, "Debe introducir un motivo para la PC", "Error", JOptionPane.ERROR_MESSAGE);
			return -1;
		} else {
			pc.setMotivo(motivo);
		}

		// Si es inicial, la establecemos como abierta
		pc.setEstado(Pc.Estado.ABIERTA);

		//Prioridad PC
		JTextField priorPC = UI.textArea_PanelPCnueva_Prioridad;
		pc.setPrioridad(priorPC.getText());

		bd.addPC(pc); // metodo que crea una PC inicial
		JOptionPane.showMessageDialog(null, "Se ha dado de alta una nueva PC.", "Informacion", JOptionPane.INFORMATION_MESSAGE);

		return 0;
	}

	/* Requisito 3.4 */
	// MÃ©todo que introduce una valoraciÃ³n en una PC
	// Interfaz: ES NECESARIO QUE NOS PASÃ‰IS EL CÃ“DIGO DE LA PC QUE QUERÃ�A MODIFICAR EL USUARIO
	public static int valorarPC() {
		Pc pc = new Pc(Integer.valueOf(UI.textField_PanelPC_CodPC.getText()));
		bd.extractPc(pc);
		//JTextField correspondiente a valoracion
		JTextPane valoracionPC = UI.textPane_PanelPC_Valoracion;        
		String valoracion = valoracionPC.getText(); //JTextField correspondiente

		if (valoracion == null) {
			JOptionPane.showMessageDialog(null, "Debe introducir una valoracion para la PC.", "Error", JOptionPane.ERROR_MESSAGE);
			return -1;
		} else {
			pc.setValoracion(valoracion);
		}

		// Metodo que aÃƒÂ±ade valoracion a una PC
		bd.valorarPC(pc);
		JOptionPane.showMessageDialog(null, "Se ha introducido la valoracion de dicha PC correctamente.", "Informacion", JOptionPane.INFORMATION_MESSAGE);

		return 0;
	}

	/* Requisito 3.5 */
	// Metodo que modifica el estado de una PC
	public static int modEstadoPC() {
		//ComboBox que debe mostrar todos los estados posibles de la PC
		JComboBox<Estado> EstadosPC = UI.comboBox_PanelPC_Estado;

		// comprobamos que el usuario ha seleccionado un estado para la PC
		Estado estado = (Estado) EstadosPC.getSelectedItem();

		Pc pc = new Pc(Integer.valueOf(UI.textField_PanelPC_CodPC.getText()));
		bd.extractPc(pc);
		pc.setEstado(estado);

		// Metodo que SOLO modifica el estado de una PC
		bd.modEstadoPC(pc);
		JOptionPane.showMessageDialog(null, "Se ha modificado el estado de dicha PC correctamente.", "Informacion", JOptionPane.INFORMATION_MESSAGE);

		return 0;
	}


	//Metodo que realiza comprueba el login de un usuario devuelve true si todo es correcto, false en otro caso.
	public static boolean login(){
		boolean resultado = true;
		String nick = UI.textField_PanelLogin_User.getText(); //Nombre/Nick de usuario
		String password = new String(UI.passwordField_PanelLogin_Password.getPassword());//Password de usuario
		Persona persona = new Persona(nick);
		bd.extractPersona(persona);
		if(password.equals(persona.getPassword())){//Se inicia sesiÃƒÂ³n con el usuario correspondiente
			sesion = nick;
		}
		else{//Si los datos no son correctos se muestra un mensaje de error
			JOptionPane.showMessageDialog(null, "Usuario y/o password incorrectos", "Error", JOptionPane.INFORMATION_MESSAGE);
			resultado = false;
		}
		return resultado;
	}


	//Metodo que registra un usuario en la base de datos, devuelve true si todo es correcto, false en otro caso.
	public static boolean registro(){
		boolean resultado = false;
		String nick = UI.textField_PanelRegistro_Usuario.getText();
		String password = new String(UI.passwordField_PanelRegistro_Password.getPassword());
		String passwordConfirmation = new String(UI.passwordField_PanelRegistro_ConfPassword.getPassword());
		if(!password.equals(passwordConfirmation)){
			JOptionPane.showMessageDialog(null, "La password no coincide", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		else{//Registrar usuario    	
			Persona persona = new Persona(nick);
			bd.extractPersona(persona);
			if(persona.getPassword()!=null){//Usuario existente en base de datos
				JOptionPane.showMessageDialog(null, "Usuario existente, introduzca otro nombre", "Error", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				persona.setPassword(password);
				bd.registroPersona(persona);
				resultado = true;
			}
		}
		return resultado;
	}


	//Metodo que cierra la sesion del usuario en el cliente
	public static void logout(){
		sesion = null;
	}


	//Metodo que modifica el perfil de un usuario
	public static int modPerfil(){
		Persona persona = new Persona();
		persona.setNick(sesion);
		bd.extractPersona(persona);

		String nombre = UI.textField_PanelPerfil_Nombre.getText();
		if (nombre == null) {
			JOptionPane.showMessageDialog(null, "Debe introducir un nombre para la persona", "Error", JOptionPane.ERROR_MESSAGE);
			return -1;
		}
		persona.setNombre(nombre);

		persona.setEmail(UI.textField_PanelPerfil_Email.getText());

		// ComprobaciÃƒÂ³n numero de telefono valido
		int telf = isTelefono(UI.textField_PanelPerfil_Telefono.getText());
		persona.setTelefono(telf);

		bd.editPerson(persona);

		return 0;
	}


	//Rellenar info CCC
	public static void cccSelected() {
		Ccc selected = new Ccc((String) UI.comboBoxCCC.getSelectedItem());
		bd.extractCCC(selected);
		UI.textFieldNombreCCC.setText(selected.getNombreCCC());
		UI.textFieldPresidente.setText(selected.getPresidente());
		UI.textFieldSecretario.setText(selected.getSecretario());
		UI.textFieldAdministrador.setText(selected.getAdministrador());
		Collection<Persona> personas = selected.getPersonasCollection();
		String nombresPersonas = "";
		Iterator<Persona> itPersonas = personas.iterator();
		while (itPersonas.hasNext()) {
			nombresPersonas += "<" + itPersonas.next().getNombre() + "> ";
		}
		Collection<Agenda> agendas = selected.getAgendaCollection();
		String nombresAgendas = "";
		Iterator<Agenda> itAgendas = agendas.iterator();
		while (itAgendas.hasNext()) {
			nombresAgendas += "<" + itAgendas.next().getFecha() + "> ";
		}
		Collection<Pc> pcs = selected.getPcCollection();
		String nombresPcs = "";
		Iterator<Pc> itPcs = pcs.iterator();
		while (itPcs.hasNext()) {
			nombresPcs += "<" + itPcs.next().getFecha() + "> ";
		}
		UI.textPane_PanelCCC_Miembros.setText(nombresPersonas);
		UI.textPane_PanelCCC_Agendas.setText(nombresAgendas);
		UI.textPane_PanelCCC_Peticiones.setText(nombresPcs);
	}


	//Rellenar info Miembro
	public static void memberSelected() {
		Persona persona = new Persona(UI.textField_PanelMiembro_Nick.getText());
		bd.extractPersona(persona);
		if(persona.getPassword()==null){
			JOptionPane.showMessageDialog(null, "El nick introducido no esta registrado en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else{
			UI.textField_PanelMiembro_Permisos.setText(persona.getPermisos());
			UI.textField_PanelMiembro_CCC.setText(persona.getCcc().getNombreCCC());
		}
	}


	//Rellenar info perfil
	public static void mostrarPerfil(){
		Persona persona = new Persona(sesion);
		bd.extractPersona(persona);
		UI.textArea_PanelPerfil_Nick.setText(persona.getNick());
		UI.textField_PanelPerfil_Nombre.setText(persona.getNombre());
		UI.textField_PanelPerfil_Email.setText(persona.getEmail());
		UI.textField_PanelPerfil_Telefono.setText(Integer.toString(persona.getTelefono()));
		UI.textArea_PanelPerfil_CCC.setText(persona.getCcc().getNombreCCC());
		UI.textArea_PanelPerfil_Permisos.setText(persona.getPermisos());
	}


	//Rellenar info PC
	public static void pcSelected(){
		Pc peticion = new Pc(Integer.valueOf(UI.textField_PanelPC_CodPC.getText()));
		bd.extractPc(peticion);
		if(peticion.getDescripcion()==null){
			JOptionPane.showMessageDialog(null, "No existe ninguna peticiÃ³n asociada a ese cÃ³digo", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else{//La peticion existe
			UI.textArea_PanelPC_Fecha.setText(peticion.getFecha());//Fecha
			UI.textPane_PanelPC_Descripcion.setText(peticion.getDescripcion());//Descripcion
			UI.textArea_PanelPC_Motivo.setText(peticion.getMotivo());//Motivo
			UI.textArea_PanelPC_Email.setText(peticion.getEmail());//Email
			UI.textArea_PanelPC_Prioridad.setText(peticion.getPrioridad());//Prioridad
			UI.textArea_PanelPC_Documentos.setText(peticion.getDocumentos());//Documentos
			UI.textPane_PanelPC_Valoracion.setText(peticion.getValoracion());//Valoracion
			UI.textField_PanelPC_CCC.setText(peticion.getCcc().getNombreCCC());//CCC
			UI.textField_PanelPC_Reunion.setText(peticion.getAgenda().getFecha());//Reunion
			UI.comboBox_PanelPC_Estado.setSelectedItem(peticion.getEstado());//Estado
		}
	}



}

