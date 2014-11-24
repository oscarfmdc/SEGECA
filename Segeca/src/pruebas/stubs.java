
package pruebas;

// En esta clase se crearán los tubs necesarios para la simulación de cada uno de los módulos que se necesiten en las pruebas

import def.Agenda;

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
    
}
