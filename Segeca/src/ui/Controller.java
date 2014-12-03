package ui;

import def.*;

import java.text.*;
import java.util.*;

import javax.swing.*;


public class Controller {

    private static Conector.ConectorBD bd;

    public Controller() {
        bd = new Conector.ConectorBD("ortinson.no-ip.org:80", "SEGECA", "admin", "Grupo10");
        UI.comboBoxCCC = new JComboBox(bd.extraerListaCCC().toArray());
        UI.initialize();
        UI.frame.setVisible(true);
        //pruebas.PU.PU_requisitos();
        //pruebas.PI.pruebaIntegración();
        //bd.desconectar();
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
        UI.label_PanelOutput_Output.setText("Output:   Código de Agenda = "+ag.getCodAgenda());
        //Stub para simular el modulo, en la version final comentar
        //stubs.createAgenda(ag);

        JOptionPane.showMessageDialog(null, "La agenda se ha preparado correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);

        return 0;
    }

    /* MÃ©todo auxiliar para comprobar todos los campos de la agenda */
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

        // Comprobamos que la hora de inicio es anterior a la hora de fin de la reuniÃ³n
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

            // lista de miembros esta vacÃ­o
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

        Persona prsn = new Persona();
        prsn.setNick(UI.textField_PanelMiembro_Nick.getText());

        // Establecemos todos los campos que corresponden a las personas
        Ccc cccPrsn = new Ccc((String) UI.comboBoxCCC.getSelectedItem());
        prsn.setCcc(cccPrsn);
        prsn.setEmail(UI.textField_PanelMiembro_Email.getText());//JTextField correspondiente al email

        JTextField nombre = UI.textField_PanelMiembro_Nombre;//JTextField correspondiente al nombre

        if (nombre.getText() == null) {
            JOptionPane.showMessageDialog(null, "Debe introducir un nombre para la persona", "Error", JOptionPane.ERROR_MESSAGE);
        }

        prsn.setNombre(nombre.getText());
        // ComprobaciÃ³n numero de telefono valido
        JTextField telefono = UI.textField_PanelMiembro_Telefono;
        int telf = isTelefono(telefono.getText());
        prsn.setTelefono(telf);

        //permisos
        prsn.setPermisos(UI.textField_PanelMiembro_Permisos.getText());

        // Modificamos la persona con los parÃ¡mtetros correspondientes, (enrique)        
        bd.editPerson(prsn);

        JOptionPane.showMessageDialog(null, "Los datos del Miembro del CCC se han modificado correctamente.", "Informacion", JOptionPane.INFORMATION_MESSAGE);

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
        JTextField nombre = UI.textField_PanelMiembro_Nombre;
        // compruebo que el campo no esta vacio
        if (nombre.getText() == null) {
            JOptionPane.showMessageDialog(null, "Debe introducir un nombre para la persona", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        } else {
            persona.setNombre(nombre.getText());
        }

        // compruebo el telefono
        JTextField telefono = UI.textField_PanelMiembro_Telefono;
        int telf = isTelefono(telefono.getText());
        persona.setTelefono(telf);
        persona.setEmail(UI.textField_PanelMiembro_Email.getText());
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
        int c = 0;
        while (itPersonas.hasNext()) {
            nombresPersonas += "<"+itPersonas.next().getNombre()+"> ";
            c++;
        }
        Collection<Agenda> agendas = selected.getAgendaCollection();
        String nombresAgendas = "";
        Iterator<Agenda> itAgendas = agendas.iterator();
        c = 0;
        while (itAgendas.hasNext()) {
            nombresAgendas += "<"+itAgendas.next().getFecha()+"> ";
            c++;
        }
        Collection<Pc> pcs = selected.getPcCollection();
        String nombresPcs = "";
        Iterator<Pc> itPcs = pcs.iterator();
        c = 0;
        while (itPcs.hasNext()) {
            nombresPcs += "<"+itPcs.next().getFecha()+"> ";
            c++;
        }
        UI.textPane_PanelCCC_Miembros.setText(nombresPersonas);
        UI.textPane_PanelCCC_Agendas.setText(nombresAgendas);
        UI.textPane_PanelCCC_Peticiones.setText(nombresPcs);
    }
    
    //Rellenar info Miembro
    public static void memberSelected(){
    	Persona selected = new Persona(UI.textField_PanelMiembro_Nick.getText());
    	bd.extractPersona(selected);
    	UI.textField_PanelMiembro_Nick.setText(selected.getNick());
    	UI.textField_PanelMiembro_Nombre.setText(selected.getNombre());
    	UI.textField_PanelMiembro_Email.setText(selected.getEmail());
    	UI.textField_PanelMiembro_Telefono.setText(Integer.toString(selected.getTelefono()));
    	UI.textField_PanelMiembro_Permisos.setText(selected.getPermisos());
    	UI.textField_PanelMiembro_CCC.setText(selected.getCcc().getNombreCCC());
    }
    
    //Metodo que realiza comprueba el login de un usuario devuelve true si todo es correcto, false en otro caso.
    public static boolean login(){
    	String usuario = UI.textField_PanelLogin_User.getText(); //Nombre/Nick de usuario
    	String password = UI.passwordField_PanelLogin_Password.getText();//Password de usuario
    	if(false){//Si los datos no son correctos se muestra un mensaje de error
    		JOptionPane.showMessageDialog(null, "Usuario y/o password incorrectos", "Error", JOptionPane.INFORMATION_MESSAGE);
    	}
    	return false;
    }
    //Metodo que registra un usuario en la base de datos, devuelve true si todo es correcto, false en otro caso.
    public static boolean registro(){
    	boolean resultado = false;
    	String usuario = UI.textField_PanelRegistro_Usuario.getText();
    	String password = UI.passwordField_PanelRegistro_Password.getText();
    	if(!password.equals(UI.passwordField_PanelRegistro_ConfPassword.getText())){
    		JOptionPane.showMessageDialog(null, "La password no coincide", "Error", JOptionPane.INFORMATION_MESSAGE);
    	}
    	else{//Registrar usuario    	
	    	if(false){//Usuario existente en base de datos
	    		JOptionPane.showMessageDialog(null, "Usuario existente, introduzca otro nombre", "Error", JOptionPane.INFORMATION_MESSAGE);
	    	}
	    	else{
	    		resultado = true;
	    	}
    	}
    	return resultado;
    }
}
