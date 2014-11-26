package ui;

import def.*;

import java.text.*;
import java.util.*;

import javax.swing.*;

import pruebas.stubs;

public class Controller {

    private static Conector.ConectorBD bd;

    public Controller() {
        bd = new Conector.ConectorBD("ortinson.no-ip.org:62000", "SEGECA", "admin", "Grupo10");
        UI.comboBoxCCC = new JComboBox(bd.extraerListaCCC().toArray());
        UI.initialize();
        UI.getFrame().setVisible(true);
        pruebas();
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
        ag.setCodAgenda(0);
        ag.setParticipantes(UI.textFieldParticipantesAgendas.getText());

        // Metodo que cree la agenda en la bbdd dado una instancia de clase agenda (enrique)
        bd.createAgenda(ag);
        //Stub para simular el modulo, en la version final comentar
        stubs.createAgenda(ag);

        JOptionPane.showMessageDialog(null, "La agenda se ha preparado correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);

        return 0;
    }

    /* Método auxiliar para comprobar todos los campos de la agenda */
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

        // Comprobamos que la hora de inicio es anterior a la hora de fin de la reunión
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
            bd.extractAgenda(newAgenda);
            //Asociamos la agenda a nuestro acta
            acta.setAgenda(newAgenda);

            //Metodo que crea el acta en la BD
            bd.createActa(acta);

            JOptionPane.showMessageDialog(null, "El acta se ha preparado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);

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

            // lista de miembros esta vacío
            bd.createCCC(ccc);

            JOptionPane.showMessageDialog(null, "Se ha creado correctamente un nuevo CCC.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /* Requisito 2.2 */
    public static int bajaCCC() {
        JComboBox<?> listaBorrarCCC = UI.comboBoxCCC;
        // comprobamos que el usuario ha seleccionado un CCC para borrar de la lista mostrada
        String nombreBorrarCCC = (String) listaBorrarCCC.getModel().getElementAt(listaBorrarCCC.getSelectedIndex());
        if (listaBorrarCCC.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún CCC para dar de baja", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        bd.deleteCCC(nombreBorrarCCC);

        JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente el CCC seleccionado.", "Información", JOptionPane.INFORMATION_MESSAGE);
        return 0;
    }

    /* Requisito 2.3 */
    public static int modMiembrosCCC() {

        Persona prsn = new Persona();
        prsn.setNick(UI.textFieldNick.getText());

        // Establecemos todos los campos que corresponden a las personas
        Ccc cccPrsn = new Ccc((String) UI.comboBoxCCC.getSelectedItem());
        prsn.setCcc(cccPrsn);
        prsn.setEmail(UI.textFieldEmail.getText());//JTextField correspondiente al email

        JTextField nombre = UI.textFieldNombreMiembro;//JTextField correspondiente al nombre

        if (nombre.getText() == null) {
            JOptionPane.showMessageDialog(null, "Debe introducir un nombre para la persona", "Error", JOptionPane.ERROR_MESSAGE);
        }

        prsn.setNombre(nombre.getText());
        // Comprobación numero de telefono valido
        JTextField telefono = UI.textFieldTelefono;
        int telf = isTelefono(telefono.getText());
        prsn.setTelefono(telf);

        //permisos
        prsn.setPermisos(UI.textFieldPermisos.getText());

        // Modificamos la persona con los parámtetros correspondientes, (enrique)        
        bd.editPerson(prsn);

        JOptionPane.showMessageDialog(null, "Los datos del Miembro del CCC se han modificado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);

        return 0;
    }

    /* Requisito 2.4 */
    public static int altaPersonaCCC() {
        Persona persona = new Persona();

        JTextField nick = UI.textFieldNick;
        // compruebo que el campo no esta vacio
        if (nick.getText() == null) {
            JOptionPane.showMessageDialog(null, "Debe introducir un nick para la persona", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        } else {
            persona.setNick(nick.getText());
        }

        // JTextField con el nombre de la persona
        JTextField nombre = UI.textFieldNombreMiembro;
        // compruebo que el campo no esta vacio
        if (nombre.getText() == null) {
            JOptionPane.showMessageDialog(null, "Debe introducir un nombre para la persona", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        } else {
            persona.setNombre(nombre.getText());
        }

        // compruebo el telefono
        JTextField telefono = UI.textFieldTelefono;
        int telf = isTelefono(telefono.getText());
        persona.setTelefono(telf);
        persona.setEmail(UI.textFieldEmail.getText());
        persona.setPermisos(UI.textFieldPermisos.getText());

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

        JOptionPane.showMessageDialog(null, "Se ha dado de alta un nuevo miembro en el CCC seleccionado.", "Información", JOptionPane.INFORMATION_MESSAGE);

        return 0;
    }

    // metodo que comprueba y pasa a entero un telefono
    public static int isTelefono(String telefono) {
        int telefonoInt = 0;
        if (telefono.length() != 9) {
            JOptionPane.showMessageDialog(null, "Tamaño del numero de telefono invalido. Deben ser 9 digitos", "Error", JOptionPane.ERROR_MESSAGE);
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
        JComboBox<?> listaPersonasCCC = UI.comboBoxMiembros;
        // comprobamos que el usuario ha seleccionado una persona de un CCC para darla de baja
        String bajaPrsnCCC = (String) listaPersonasCCC.getSelectedItem();

        if (listaPersonasCCC.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningúna persona para dar de baja en el CCC", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        bd.deletePersonaCCC(bajaPrsnCCC);

        JOptionPane.showMessageDialog(null, "Se ha eliminado del CCC seleccionado al correspondiente miembro.", "Información", JOptionPane.INFORMATION_MESSAGE);

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
            JOptionPane.showMessageDialog(null, "La fecha de la reunión debe ser posterior a la fecha actual.", "Error", JOptionPane.ERROR_MESSAGE);
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

    private static void pruebas() {
        /* Pruebas para la preparacion de Agendas y Actas */
        System.out.println("**** Prueba 1: Preparacion de agenda 1 ****");
        // Establecemos jTextFields
        UI.textFieldLugarAgendas.setText("ETSIINF");
        UI.textFieldCCCAgendas.setText("CCC1");
        UI.textFieldFechaAgendas.setText("25/12/2014");
        UI.textFieldHoraInicioAgendas.setText("19:00");
        UI.textFieldHoraFinAgendas.setText("19:30");
        UI.textFieldPropositoAgendas.setText("Planificar el proyecto");
        UI.textFieldParticipantesAgendas.setText("Marcos,Oscar");
        // Llamamos a la funcion a testear
        prepararAgenda();

        /* Prueba 2, prueba con error */
        System.out.println("**** Prueba 2: Preparacion de agenda 2 ****");
        // Establecemos jTextFields
        UI.textFieldLugarAgendas.setText("ETSIINF");
        UI.textFieldCCCAgendas.setText("CCC1");
        UI.textFieldFechaAgendas.setText("25/12/2012");
        UI.textFieldHoraInicioAgendas.setText("19:00");
        UI.textFieldHoraFinAgendas.setText("19:30");
        UI.textFieldPropositoAgendas.setText("Planificar el proyecto");
        UI.textFieldParticipantesAgendas.setText("Marcos,Oscar");
        // Llamamos a la funcion a testear
        prepararAgenda();
        // debe devolver error porque la fecha es posterior a la actual 2012<2014

        /* Prueba 3, prueba con error */
        System.out.println("**** Prueba 3: Preparacion de agenda 3 ****");
        // Establecemos jTextFields
        UI.textFieldLugarAgendas.setText("ETSIINF");
        UI.textFieldCCCAgendas.setText("CCC1");
        UI.textFieldFechaAgendas.setText("25/12/2014");
        UI.textFieldHoraInicioAgendas.setText("19:00");
        UI.textFieldHoraFinAgendas.setText("18:30");
        UI.textFieldPropositoAgendas.setText("Planificar el proyecto");
        UI.textFieldParticipantesAgendas.setText("Marcos,Oscar");
        // Llamamos a la funcion a testear
        prepararAgenda();
        // debe devolver error porque la hora de fin es anterior a la hora de inicio

        /* Prueba 4, prueba con error */
        System.out.println("**** Prueba 4: Preparacion de agenda 4 ****");
        // Establecemos jTextFields
        UI.textFieldLugarAgendas.setText("ETSIINF");
        UI.textFieldCCCAgendas.setText("CCC1");
        UI.textFieldFechaAgendas.setText("25 de diciembre");
        UI.textFieldHoraInicioAgendas.setText("19:00");
        UI.textFieldHoraFinAgendas.setText("19:30");
        UI.textFieldPropositoAgendas.setText("Planificar el proyecto");
        UI.textFieldParticipantesAgendas.setText("Marcos,Oscar");
        // Llamamos a la funcion a testear
        prepararAgenda();
        // debe devolver error porque la fecha no es valida

        /* Prueba 5, prueba con error */
        System.out.println("**** Prueba 5: Preparacion de agenda 5 ****");
        // Establecemos jTextFields
        UI.textFieldLugarAgendas.setText("ETSIINF");
        UI.textFieldCCCAgendas.setText("CCC1");
        UI.textFieldFechaAgendas.setText("25/12/2015");
        UI.textFieldHoraInicioAgendas.setText("");
        UI.textFieldHoraFinAgendas.setText("19:30");
        UI.textFieldPropositoAgendas.setText("Planificar el proyecto");
        UI.textFieldParticipantesAgendas.setText("Marcos,Oscar");
        // Llamamos a la funcion a testear
        prepararAgenda();
        // debe devolver error porque la hora de inicio no es valida

        /* Prueba 6 */
        System.out.println("**** Prueba 6: Preparacion de acta 1 ****");
        // Establecemos jTextFields
        UI.textFieldAgenda.setText("20"); /* Extraer un código de agenda */

        UI.textFieldAusencias.setText("Javier, Nacho");
        UI.textFieldResultados.setText("Asignación de tareas a los participantes.");
        // Llamamos a la funcion a testear
        prepararActa();

        /* Prueba 7 */
        System.out.println("**** Prueba 7: Alta de nuevo CCC ****");
        // Establecemos jTextFields
        UI.textFieldNombreCCC.setText("CCC_SEGECA");
        UI.textFieldAdministrador.setText("Pepe");
        UI.textFieldPresidente.setText("Martín");
        UI.textFieldSecretario.setText("Óscar");

        //TODO: Añadir personas al CCC		
        // Llamamos a la funcion a testear
        altaCCC();

        /* Prueba 8 */
        System.out.println("**** Prueba 8: Baja de CCC existente ****");
        //bd.deleteCCC("CCC_SEGECA");
        bajaCCC();

        /* Prueba 9 */
        System.out.println("**** Prueba 9: Modificación de miembro de CCC ****");
        // Establecemos jTextFields
        UI.textFieldCCCMiembro.setText("CCC_1");
        UI.textFieldEmail.setText("email@ejemplo.es");
        UI.textFieldNombreMiembro.setText("Óscar");
        UI.textFieldTelefono.setText("666123456");
        // Llamamos a la funcion a testear
        modMiembrosCCC();

        /* Prueba 10 */
        System.out.println("**** Prueba 10: Modificación de miembro de CCC 2 ****");
        // Establecemos jTextFields
        UI.textFieldCCCMiembro.setText("CCC_1");
        UI.textFieldEmail.setText("email@ejemplo.es");
        UI.textFieldNombreMiembro.setText("Óscar");
        UI.textFieldTelefono.setText("666456");
        // Llamamos a la funcion a testear
        modMiembrosCCC();
        // debe devolver error, porque el numero de telefono no es valido

        /* Prueba 11 */
        System.out.println("**** Prueba 11: Alta miembro en un CCC ****");
        // Establecemos jTextFields
        UI.textFieldNick.setText("k3xr");
        UI.textFieldCCCMiembro.setText("CCC_1");
        UI.textFieldEmail.setText("email@ejemplo.es");
        UI.textFieldNombreMiembro.setText("Óscar");
        UI.textFieldTelefono.setText("666456123");
        //Llamamos a la funcion a testear
        altaPersonaCCC();

        /* Prueba 12 */
        System.out.println("**** Prueba 12: Baja miembro en un CCC ****");
        //bd.deletePersonaCCC("Marco");
        bajaPersonaCCC();

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
        String[] nombresPersonas = new String[personas.size()];
        Iterator<Persona> itPersonas = personas.iterator();
        int c = 0;
        while (itPersonas.hasNext()) {
            nombresPersonas[c] = itPersonas.next().getNombre();
            c++;
        }
        Collection<Agenda> agendas = selected.getAgendaCollection();
        String[] nombresAgendas = new String[agendas.size()];
        Iterator<Agenda> itAgendas = agendas.iterator();
        c = 0;
        while (itAgendas.hasNext()) {
            nombresAgendas[c] = itAgendas.next().getFecha();
            c++;
        }
        Collection<Pc> pcs = selected.getPcCollection();
        String[] nombresPcs = new String[pcs.size()];
        Iterator<Pc> itPcs = pcs.iterator();
        c = 0;
        while (itPcs.hasNext()) {
            nombresPcs[c] = itPcs.next().getFecha();
            c++;
        }
        UI.comboBoxMiembros = new JComboBox<String>(nombresPersonas);
        UI.comboBoxAgendas = new JComboBox<String>(nombresAgendas);
        UI.comboBoxPeticiones = new JComboBox<String>(nombresPcs);
    }
}
