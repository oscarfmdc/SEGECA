package ui;

import def.*;
import java.text.*;
import java.util.*;

import javax.swing.*;

public class Controller {

    private static Conector.ConectorBD bd;
    private static UI window;

    public Controller(){
    	window = new UI();
        window.getFrame().setVisible(true);

        bd = new Conector.ConectorBD("192.168.1.84:3306", "SEGECA", "admin", "Grupo10");
        pruebas();
        bd.desconectar();
    }

    //Basurilla para comprobar el funcionamiento de ConectorBD
    private static void pruebas() {
        def.Agenda a = new def.Agenda();
        a.setCodAgenda(2);
        bd.extraerAgenda(a);
        System.out.println(a.toString());

    }

    /* Requisito 1.2 */
    public static int prepararAgenda() {
        // comprobamos que los datos recibidos sean correctos
        if (comprobarAgenda() == -1) {
            return -1;
        }
        Agenda ag = new Agenda();

        // CCC agenda
        // Esta Jlist se refiere a los nombres de CCC
        // HAY QUE CREAR ESTA LISTA QUE CONTENDRA TODOS LOS NOMBRES DEL CCC
        // Cambiar null por la jlist correspondiente
        JList listaCCC = null;
        String nombreCCC = (String) listaCCC.getModel().getElementAt(listaCCC.getSelectedIndex());

        Ccc ccc = new Ccc();
        ccc.setNombreCCC(nombreCCC);

        // rellenamos los campos de la agenda
        // Cambiar nulls por varibales correspondientes
        ag.setCcc(ccc);
        ag.setFecha(null);
        ag.setLugar(null);
        ag.setHoraInicio(null);
        ag.setHoraFin(null);
        ag.setProposito(null);
        ag.setCodAgenda(0);
        ag.setParticipantes(null);

        // Método que cree la agenda en la bbdd dado una instancia de clase agenda (enrique)
        createAgenda(ag);

        return 0;
    }

    /* metodo auxiliar para comprobar todos los campos de la agenda */
    private static int comprobarAgenda() {

        // Esta Jlist se refiere a los nombres de CCC
        // HAY QUE CREAR ESTA LISTA QUE CONTENDRA TODOS LOS NOMBRES DEL CCC
        // Cambiar null por la jlist correspondiente
        JList listaCCC = null;

        // Si no hay seleccionado ningun CCC
        if (listaCCC.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún CCC", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Comprobación Fecha
        // cambiar null por jTextField correspondiente a fecha agenda
        JTextField fechaAgenda = null;

        if (!isFechaValida(fechaAgenda.getText())) {
            return -1;
        }

        // Comprobacion lugar
        // cambiar null por jTexfield correspondiente a lugar de Agenda
        JTextField lugarAgenda = null;

        if (lugarAgenda.getText().length() > 20) {
            JOptionPane.showMessageDialog(null, "Error al introducir el lugar de la Agenda", "Error", JOptionPane.ERROR_MESSAGE);
        }

        //Comprobamos hora inicio/fin
        //cambiar nulls por jtexfield correspondiente a las horas de inicio y fin de agenda
        JTextField horaInicio = null;
        JTextField horaFin = null;

        if (!isHoraValida(horaInicio.getText()) || !isHoraValida(horaFin.getText())) {
            return -1;
        }

        return 0;

    }

    /* Requisito 1.1 */
    // Tenéis que pasarnos un código de agenda que debereis calcular mostrando las agendas disponibles al usuario    
    public static int prepararActa(int codAgenda) {
        Acta acta = new Acta();

        Agenda ag = new Agenda();
        acta.setAgenda(ag);
        ag.setCodAgenda(codAgenda);

        acta.setAgenda(ag);// se cambia por el Jtexfield que contenga la agenda correspondiente a ese acts
        acta.setCodActa(0);
        acta.setAusencias(null);// Jtexfield con los nombre de los ausentes
        acta.setResultados(null);// Jtexfiled con los resultados obtenidos

        return 0;
    }

    /* Requisito 2.1 */
    // necesitamos como parametro las listas con lo que seleccione el usuario
    public static void altaCCC(ArrayList agendas, ArrayList PCs, ArrayList personas) {
        Ccc ccc = new Ccc();

        // cambiar los nulls por los Jtexfield correspondientes
        ccc.setNombreCCC(null);
        ccc.setAdministrador(null);
        ccc.setPresidente(null);
        ccc.setSecretario(null);

        // cambiar todos los ArrayList por las listas correspondientes que seleccione el usuario
        // lista de agendas que trata ese CCC
        ccc.setAgendaCollection(agendas);
        // lista de PC que trata ese CCC
        ccc.setPcCollection(PCs);
        // lista de personas que integran ese CCC
        ccc.setPersonasCollection(personas);

        // Enrique, metodo para meter en la bd el ccc
        createCCC(ccc);

    }

    /* Requisito 2.2 */
    public static int bajaCCC() {
        // Cambiar null por la jlist correspondiente
        JList listaBorrarCCC = null;
        // comprobamos que el usuario ha seleccionado un CCC para borrar de la lista mostrada
        String nombreBorrarCCC = (String) listaBorrarCCC.getModel().getElementAt(listaBorrarCCC.getSelectedIndex());
        if (listaBorrarCCC.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún CCC para dar de baja", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        // Enrique, metodo que borra el ccc con el nombre pasado como parametro
        deleteCCC(nombreBorrarCCC);
        return 0;
    }

    /* Requisito 2.3 */
    // Necesitamos que nos paséis el código de la persona para pode realizar la modificacion 
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
        // Comprobación numero de telefono valido  Marcos
        prsn.setTelefono(0);
        return 0;
    }

    /* Requisito 2.4 */
    public static int altaPersonaCCC() {
        Persona persona = new Persona();

        // cambiar todos los nulls por los JTextField correspondientes en cada caso
        JTextField nick = null;
        // compruebo que el campo no esta vacio
        if (nick.getText() == null) {
            JOptionPane.showMessageDialog(null, "Debe introducir un nick para la persona", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        persona.setNick(null);

        // JTextField con el nombre de la persona
        JTextField nombre = null;
        // compruebo que el campo no esta vacio
        if (nombre.getText() == null) {
            JOptionPane.showMessageDialog(null, "Debe introducir un nombre para la persona", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        persona.setNombre(null);

        // compruebo el telefono
        JTextField telefono = null;
        telf = isTelefono(telefono.getText());
        persona.setTelefono(telef);
        persona.setEmail(null);
        persona.setPermisos(null);
        // Cambiar null por la jlist correspondiente
        JList CCCs = null;
        // comprobamos que el usuario ha seleccionado un CCC para asignar la persona a dicho CCC
        String ccc = (String) CCCs.getModel().getElementAt(CCCs.getSelectedIndex());
        Ccc newCCC = new Ccc();
        newCCC.setNombreCCC(ccc);
        persona.setCcc(newCCC);

        // Enrique, metodo para introducir una persona en un CCC
        addPersonaCCC(persona);
        return 0;
    }

    /* Requisito 2.5 */
    public static int bajaPersonaCCC() {
        // Cambiar null por la jlist correspondiente
        JList listaPersonasCCC = null;
        // comprobamos que el usuario ha seleccionado una persona de un CCC para darla de baja
        String bajaPersonaCCC = (String) listaPersonasCCC.getModel().getElementAt(listaPersonasCCC.getSelectedIndex());
        if (listaPersonasCCC.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningúna persona para dar de baja en el CCC", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        // Enrique, metodo que da de baja a una persona de un CCC
        deletePersonaCCC(bajaPersonaCCC);
        return 0;
    }

    // metodo que comprueba el formato de la fecha
    private static boolean isFechaValida(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (java.text.ParseException ex) {
            JOptionPane.showMessageDialog(null, "El formato de la fecha no es correcto", "Error", JOptionPane.ERROR_MESSAGE);
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
}
