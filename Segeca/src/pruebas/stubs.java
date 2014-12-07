
package pruebas;

// En esta clase se crearán los stubs necesarios para la simulación de cada uno de los módulos que se necesiten en las pruebas

import def.Agenda;
import def.Ccc;
import def.Pc;
import def.Persona;

public class stubs {

    public static void createAgenda(Agenda ag) {
        System.out.println("Está en el stub de la BBDD. A continuación se imprimirán los datos de la agenda. Verifique si los datos son correctos");
        System.out.println("\tNombre CCC: " + ag.getCcc().getNombreCCC());
        System.out.println("\tFecha: " + ag.getFecha());
        System.out.println("\tHora de inicio: " + ag.getHoraInicio());
        System.out.println("\tHora de fin: " + ag.getHoraFin());
        System.out.println("\tLugar: " + ag.getLugar());
        System.out.println("\tParticipantes: " + ag.getParticipantes());
        System.out.println("\tPropósito: " + ag.getProposito());
    }

    public static void altaCCC(Ccc ccc) {
        System.out.println("Está en el stub de la BBDD. A continuación se imprimirán los datos del CCC. Verifique si los datos son correctos");
        System.out.println("\tAdministrador CCC: " + ccc.getAdministrador());
        System.out.println("\tNombre CCC: " + ccc.getNombreCCC());
        System.out.println("\tPresidente CCC: " + ccc.getPresidente());
        System.out.println("\tSecretario CCC: " + ccc.getSecretario());
    }

    public static void editPerson(Persona prsn) {
        System.out.println("Está en el stub de la BBDD. A continuación se imprimirán los datos de la persona. Verifique si los datos son correctos");
        System.out.println("\tEmail de la persona: " + prsn.getEmail());
        System.out.println("\tNombre de la persona: " + prsn.getNombre());
        System.out.println("\tTeléfono: " + prsn.getTelefono());
        System.out.println("\tNick: " + prsn.getNick());
        System.out.println("\tCCC " + prsn.getCcc().getNombreCCC());
    }
    
    // Método que imprime los datos de la PC que se envía como parámetro
    public static void PCaCCC(Pc pc){
        System.out.println("Está en el stub de la BBDD. A continuación se imprimirán los datos de la PC. Verifique si los datos son correctos");
        System.out.println("\tCódigo de la PC: " + pc.getCodPC());
        System.out.println("\tCCC asignado a la PC: " + pc.getCcc().getNombreCCC());
    }
    
    // Método que simula el módulo de la bbdd que recibe una PC asignada a una reunión que se realizará con posterioridad
    public static void PcAgendaCCC(Pc pc){
        System.out.println("Está en el stub de la BBDD. A continuación se imprimirán los datos de la PC. Verifique si los datos son correctos");
        System.out.println("\tCódigo de la reunión: " + pc.getAgenda().getCodAgenda());
        System.out.println("\tDescripción: " + pc.getDescripcion());
        System.out.println("\tEstado: " + pc.getEstado());
        System.out.println("\tFecha: " + pc.getFecha());
        System.out.println("\tMotivo: " + pc.getMotivo());
        System.out.println("\tPrioridad: " + pc.getPrioridad());
    }
}