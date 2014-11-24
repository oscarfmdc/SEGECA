package ui;

import def.*;

import java.text.*;
import java.util.*;

import javax.swing.*;

public class Controller {

    private static Conector.ConectorBD bd;

    public Controller(){
    	UI.initialize();
        UI.getFrame().setVisible(true);
        bd = new Conector.ConectorBD("ortinson.no-ip.org:62000", "SEGECA", "admin", "Grupo10");
        //pruebas();
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
        // Cambiar nulls por varibales correspondientes
        ag.setCcc(ccc);
        ag.setFecha(UI.textFieldFechaAgendas.getText());
        ag.setLugar(UI.textFieldLugarAgendas.getText());
        ag.setHoraInicio(UI.textFieldHoraInicioAgendas.getText());
        ag.setHoraFin(UI.textFieldHoraFinAgendas.getText());
        ag.setProposito(UI.textFieldPropositoAgendas.getText());
        ag.setCodAgenda(0);
        ag.setParticipantes(UI.textFieldParticipantesAgendas.getText());

        // M閠odo que cree la agenda en la bbdd dado una instancia de clase agenda (enrique)
        bd.createAgenda(ag);

        JOptionPane.showMessageDialog(null, "La agenda se ha preparado correctamente", "Informaci髇n", JOptionPane.INFORMATION_MESSAGE);
        
        return 0;
    }

    /* metodo auxiliar para comprobar todos los campos de la agenda */
    // Devuelve falso si fallo
    private static boolean comprobarAgenda() {

        String ccc = UI.textFieldCCCAgendas.getText();
        
        if (ccc == null || ccc.equals("")) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ning鷑 CCC", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Comprobaci髇 Fecha
        // cambiar null por jTextField correspondiente a fecha agenda
        JTextField fechaAgenda = UI.textFieldFechaAgendas;

        if (!isFechaValida(fechaAgenda.getText())) {
            return false;
        }

        // Comprobacion lugar
        // cambiar null por jTexfield correspondiente a lugar de Agenda
        JTextField lugarAgenda = UI.textFieldLugarAgendas;

        if (lugarAgenda.getText().length() > 20) {
            JOptionPane.showMessageDialog(null, "Error al introducir el lugar de la Agenda", "Error", JOptionPane.ERROR_MESSAGE);
        }

        //Comprobamos hora inicio/fin
        //cambiar nulls por jtexfield correspondiente a las horas de inicio y fin de agenda
        JTextField horaInicio = UI.textFieldHoraInicioAgendas;
        JTextField horaFin = UI.textFieldHoraFinAgendas;
        
        if (!isHoraValida(horaInicio.getText()) || !isHoraValida(horaFin.getText())) {
            return false;
        }
        
         Date parsedHoraIn = null;
         Date parsedHoraFin = null;
         
        // Comprobamos que la hora de inicio es anterior a la hora de fin de la reuni贸n
        try {
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm", Locale.getDefault());
            formatoHora.setLenient(false);
            parsedHoraIn = formatoHora.parse(horaInicio.getText());
            parsedHoraFin = formatoHora.parse(horaFin.getText());
        } catch (java.text.ParseException ex) {
        }

        if(!parsedHoraIn.before(parsedHoraFin))
        {
            JOptionPane.showMessageDialog(null, "La hora de inicio debe ser anterior a la hora de fin.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        
        return true;

    }

    /* Requisito 1.1 */
    // Ten閕s que pasarnos un c骴igo de agenda que debereis calcular mostrando las agendas disponibles al usuario ???
    public static int prepararActa() {
        Acta acta = new Acta();

        Agenda ag = new Agenda();
        acta.setAgenda(ag);
        
        // El c骴igo se extrae desde aqui
        int codAgenda = 0;
        ag.setCodAgenda(codAgenda);

        acta.setAusencias(UI.textFieldAusencias.getText());// Jtexfield con los nombre de los ausentes
        acta.setResultados(UI.textFieldResultados.getText());// Jtexfiled con los resultados obtenidos
        
        //Cogemos el c骴igo de agenda de la interfaz gr醘ica
        Agenda newAgenda = new Agenda();
        newAgenda.setCodAgenda(Integer.parseInt((UI.textFieldAgenda.getText())));
        //Buscamos la agenda en la base de datos y obtenemos el objeto Agenda completo
        bd.extractAgenda(newAgenda);
        //Asociamos la agenda a nuestro acta
        acta.setAgenda(newAgenda);
        
        //Metodo que crea el acta en la BD
        bd.createActa(acta);

        JOptionPane.showMessageDialog(null, "El acta se ha preparado correctamente.", "Informaci贸n", JOptionPane.INFORMATION_MESSAGE);
        
        return 0;
    }

    /* Requisito 2.1 */
    // necesitamos como parametro las listas con lo que seleccione el usuario
    public static void altaCCC(ArrayList personas) {
        Ccc ccc = new Ccc();

        // cambiar los nulls por los Jtexfield correspondientes
        ccc.setNombreCCC(UI.textFieldNombreCCC.getText());
        ccc.setAdministrador(UI.textFieldAdministrador.getText());
        ccc.setPresidente(UI.textFieldPresidente.getText());
        ccc.setSecretario(UI.textFieldSecretario.getText());

        // cambiar el arrayList por las listas correspondientes que seleccione el usuario
        
        // lista de personas que integran ese CCC
        ccc.setPersonasCollection(personas);

        // Enrique, metodo para meter en la bd el ccc
        bd.createCCC(ccc);
        
        JOptionPane.showMessageDialog(null, "Se ha creado correctamente un nuevo CCC.", "Informaci贸n", JOptionPane.INFORMATION_MESSAGE);

    }

    /* Requisito 2.2 */
    public static int bajaCCC() {
        // Cambiar null por la jlist correspondiente
        JComboBox listaBorrarCCC = UI.comboBoxCCC;
        // comprobamos que el usuario ha seleccionado un CCC para borrar de la lista mostrada
        String nombreBorrarCCC = (String) listaBorrarCCC.getModel().getElementAt(listaBorrarCCC.getSelectedIndex());
        if (listaBorrarCCC.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ning煤n CCC para dar de baja", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        // Enrique, metodo que borra el ccc con el nombre pasado como parametro
        bd.deleteCCC(nombreBorrarCCC);
        
        JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente el CCC seleccionado.", "Informaci贸n", JOptionPane.INFORMATION_MESSAGE);
        return 0;
    }

    /* Requisito 2.3 */
    // Necesitamos que nos pas茅is el c贸digo de la persona para pode realizar la modificacion 
    public static int modMiembrosCCC(String codPersona) {

        Persona prsn = new Persona();
        prsn.setNick(codPersona);

        // Establecemos todos los campos que corresponden a las personas
        prsn.setCcc(null);//JtextField correspondiente al nombre del CCC
        prsn.setEmail(null);//JTextField correspondiente al email

        JTextField nombre = null;//JTextField correspondiente al nombre

        if (nombre.getText() == null) {
            JOptionPane.showMessageDialog(null, "Debe introducir un nombre para la persona", "Error", JOptionPane.ERROR_MESSAGE);
        }

        prsn.setNombre(nombre.getText());
        // Comprobaci贸n numero de telefono valido
        JTextField telefono = null;
        int telf = isTelefono(telefono.getText());
        prsn.setTelefono(telf);

        // Modificamos la persona con los par谩mtetros correspondientes, (enrique)        
        bd.editPerson(prsn);
        
        JOptionPane.showMessageDialog(null, "Los datos del Miembro del CCC se han modificado correctamente.", "Informaci贸n", JOptionPane.INFORMATION_MESSAGE);
        
        return 0;
    }

    /* Requisito 2.4 */
    public static int altaPersonaCCC() {
        Persona persona = new Persona();

        // cambiar todos los nulls por los JTextField correspondientes en cada caso
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
        int telf =isTelefono(telefono.getText());
        persona.setTelefono(telf);
        persona.setEmail(UI.textFieldEmail.getText());
        persona.setPermisos(UI.textFieldPermisos.getText());

        // Cambiar null por la jlist correspondiente
        JList CCCs = null;
        // comprobamos que el usuario ha seleccionado un CCC para asignar la persona a dicho CCC
        String ccc = (String) CCCs.getModel().getElementAt(CCCs.getSelectedIndex());
        if (CCCs.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun CCC en el que ingresar dicha persona.", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        // creamos un objeto Ccc con el nombre del CCC que ha seleccionado el usuario
        Ccc newCCC = new Ccc();
        newCCC.setNombreCCC(ccc);
        persona.setCcc(newCCC);

        // Enrique, metodo para introducir una persona en un CCC
        bd.addPersonaCCC(persona);
        
        JOptionPane.showMessageDialog(null, "Se ha dado de alta un nuevo miembro en el CCC seleccionado.", "Informaci贸n", JOptionPane.INFORMATION_MESSAGE);
        
        return 0;
    }
    
 // metodo que comprueba y pasa a entero un telefono
    public static int isTelefono(String telefono) {
        int telefonoInt = 0;
        if (telefono.length() != 9) {
            JOptionPane.showMessageDialog(null, "Tama帽o del numero de telefono invalido. Deben ser 9 digitos", "Error", JOptionPane.ERROR_MESSAGE);
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
        // Cambiar null por la jlist correspondiente
        JList listaPersonasCCC = null;
        // comprobamos que el usuario ha seleccionado una persona de un CCC para darla de baja
        String bajaPrsnCCC = (String) listaPersonasCCC.getModel().getElementAt(listaPersonasCCC.getSelectedIndex());

        if (listaPersonasCCC.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ning煤na persona para dar de baja en el CCC", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        // Enrique, metodo que da de baja a una persona de un CCC
        //bd.deletePersonaCCC(bajaPrsnCCC);
        
        JOptionPane.showMessageDialog(null, "Se ha eliminado del CCC seleccionado al correspondiente miembro.", "Informaci贸n", JOptionPane.INFORMATION_MESSAGE);
        
        return 0;
    }

    // metodo que comprueba el formato de la fecha
    private static boolean isFechaValida(String fecha) {
        Date parsedDate=null;
        
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
        if(!parsedDate.after(fechaActual.getTime())){
            JOptionPane.showMessageDialog(null, "La fecha de la reuni贸n debe ser posterior a la fecha actual.", "Error", JOptionPane.ERROR_MESSAGE);
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
    
    // Test agenda
    private static void pruebas() {
        def.Agenda a = new def.Agenda();
        a.setCodAgenda(1);
        bd.extractAgenda(a);
        System.out.println(a.toString());
        
        /* Pruebas para la preaparcion de Agendas y Actas */
        System.out.println("**** Prueba 1: Preparacion de agenda 1 ****");
        Agenda ag1 = new Agenda();
        Ccc ccc_ag1 = new Ccc();
        ccc_ag1.setNombreCCC("CCC1");
        ag1.setCcc(ccc_ag1);
        ag1.setCodAgenda();
        ag1.setFecha("25/12/2014");
        ag1.setLugar("ETSIINF");
        ag1.setHoraInicio("19:00");
        ag1.setHoraFin("19:30");
        ag1.setProposito("Planificar el proyecto");
        ag1.setParticipantes("Marcos,Oscar");
        bd.createAgenda(ag1);
        // comprobacion
        Agenda ag1_cmp = bd.extractAgenda(ag1);
        System.out.println("Lugar: " + ag1_cmp.getLugar() + "\n" + "CCC: " + ag1_cmp.getCcc().getNombreCCC() +"\n" + "Fecha: " + ag1_cmp.getFecha() + "\n" + "Hora Inicio: " + ag1_cmp.getHoraInicio() + "\n" + "Hora Fin: " + ag1_cmp.getHoraFin() + "\n" + "Proposito: " + ag1_cmp.getProposito() + "\n" + "Participantes: " + ag1_cmp.getParticipantes() + "\n");

        // Prueba 2, prueba con error
        System.out.println("**** Prueba 2: Preparacion de agenda 2 ****");
        Agenda ag2 = new Agenda();
        Ccc ccc_ag2 = new Ccc();
        ccc_ag2.setNombreCCC("CCC1");
        ag2.setCcc(ccc_ag2);
        ag2.setCodAgenda();
        ag2.setFecha("25/12/2012");
        ag2.setLugar("ETSIINF");
        ag2.setHoraInicio("19:00");
        ag2.setHoraFin("19:30");
        ag2.setProposito("Planificar el proyecto");
        ag2.setParticipantes("Marcos,Oscar");
        bd.createAgenda(ag2);
        // debe devolver error porque la fecha es posterior a la actual 2012<2014
 
        // Prueba 3, prueba con error
        System.out.println("**** Prueba 3: Preparacion de agenda 3 ****");
        Agenda ag3 = new Agenda();
        Ccc ccc_ag3 = new Ccc();
        ccc_ag3.setNombreCCC("CCC1");
        ag3.setCcc(ccc_ag3);
        ag3.setCodAgenda();
        ag3.setFecha("25/12/2014");
        ag3.setLugar("ETSIINF");
        ag3.setHoraInicio("19:00");
        ag3.setHoraFin("18:30");
        ag3.setProposito("Planificar el proyecto");
        ag3.setParticipantes("Marcos,Oscar");
        bd.createAgenda(ag3);
        // debe devolver error porque la hora de fin es anterior a la hora de inicio
        
        // Prueba 4, prueba con error
        System.out.println("**** Prueba 4: Preparacion de agenda 4 ****");
        Agenda ag4 = new Agenda();
        Ccc ccc_ag4 = new Ccc();
        ccc_ag4.setNombreCCC("CCC1");
        ag4.setCcc(ccc_ag4);
        ag4.setCodAgenda();
        ag4.setFecha("25 de diciembre");
        ag4.setLugar("ETSIINF");
        ag4.setHoraInicio("19:00");
        ag4.setHoraFin("19:30");
        ag4.setProposito("Planificar el proyecto");
        ag4.setParticipantes("Marcos,Oscar");
        bd.createAgenda(ag4);
        // debe devolver error porque la fecha no es valida
        
        // Prueba 5, prueba con error
        System.out.println("**** Prueba 5: Preparacion de agenda 5 ****");
        Agenda ag5 = new Agenda();
        Ccc ccc_ag5 = new Ccc();
        ccc_ag5.setNombreCCC("CCC1");
        ag5.setCcc(ccc_ag5);
        ag5.setCodAgenda();
        ag5.setFecha("25 de diciembre");
        ag5.setLugar("ETSIINF");
        ag5.setHoraInicio("");
        ag5.setHoraFin("19:30");
        ag5.setProposito("Planificar el proyecto");
        ag5.setParticipantes("Marcos,Oscar");
        bd.createAgenda(ag5);
        // debe devolver error porque la hora de inicio no es valida
        
        // Prueba 6
        System.out.println("**** Prueba 6: Preparacion de acta 1 ****");
        Acta ac1 = new Acta();
        ac1.setAgenda();
        ac1.setAusencias("Javier, Nacho");
        ac1.setResultados("Asignaci贸n de tareas a los participantes.");
        bd.createActa(ac1);
        // comprobacion

        // Prueba 7
        System.out.println("**** Prueba 7: Alta de nuevo CCC ****");
        Ccc cc1 = new Ccc();
        cc1.setNombreCCC("CCC_SEGECA");
        cc1.setAdministrador("Pepe");
        cc1.setPresidente("Mart铆n");
        cc1.setSecretario("脫scar");
        ArrayList personas = new ArrayList();
        personas.add("Jaime, Marco");
        cc1.setPersonasCollection(personas);
        // comprobacion

        // Prueba 8
        System.out.println("**** Prueba 8: Baja de CCC existente ****");
        bd.deleteCCC("CCC_SEGECA");

        // Prueba 9
        System.out.println("**** Prueba 9: Modificaci贸n de miembro de CCC ****");
        
    }
}
