/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import static Conector.ConectorBD.*;
import def.*;
import static ui.Controller.*;
import ui.UI;

/**
 *
 * @author Mark
 */
public class PI {
    public static void pruebaIntegración(){
        System.out.println("Prueba 1. Manejando CCC's: " + pruebaI1());
	System.out.println("Prueba 2. Manejando Usuarios: " + pruebaI2());
    }
    
    /*
    En la prueba 1 le pasamos los datos necesarios a Controller
    para que llame al conectorBD y realmente se introduzca el CCC
    en la base de datos.
    Después comprobamos que el CCC está almacenado en la base de Datos.
    */
    private static boolean pruebaI1(){
        boolean resultado = true;
        UI.textFieldNombreCCC.setText("CCC_SEGECA");
        UI.textFieldAdministrador.setText("Pepe");
        UI.textFieldPresidente.setText("Martin");
        UI.textFieldSecretario.setText("Oscar");	
        
        altaCCC();
        Ccc CCC1 = new Ccc();
        CCC1.setNombreCCC("CCC_SEGECA");
        extractCCC(CCC1);
        
        if (!CCC1.getAdministrador().equals("Pepe")){
			resultado = false;
            }
            if (!CCC1.getNombreCCC().equals("CCC_SEGECA")){
                    resultado = false;
            }
            if (!CCC1.getPresidente().equals("Martin")){
                    resultado = false;
            }
            if (!CCC1.getSecretario().equals("Oscar")){
                    resultado = false;
            }
       return resultado;
    }
    
    private static boolean pruebaI2(){
       boolean resultado = true;
        UI.textFieldLugarAgendas.setText("ETSIINF");
        UI.textFieldCCCAgendas.setText("CCC_SEGECA");
        UI.textFieldFechaAgendas.setText("25/12/2014");
        UI.textFieldHoraInicioAgendas.setText("19:00");
        UI.textFieldHoraFinAgendas.setText("19:30");
        UI.textFieldPropositoAgendas.setText("Planificar el proyecto");
        UI.textFieldParticipantesAgendas.setText("Marcos,Oscar");
        prepararAgenda();
        Agenda a1 = new Agenda();
        a1.setCodAgenda(getCodLastAgenda());
	extractAgenda(a1);
        
        if (!a1.getCcc().getNombreCCC().equals("CCC_SEGECA")){
			resultado = false;
        }
        if (!a1.getFecha().equals("25/12/2014")){
                resultado = false;
        }
        if (!a1.getHoraFin().equals("19:30")){
                resultado = false;
        }
        if (!a1.getHoraInicio().equals("19:00")){
                resultado = false;
        }
        if (!a1.getLugar().equals("ETSIINF")){
                resultado = false;
        }
        if (!a1.getParticipantes().equals("Marcos,Oscar")){
                resultado = false;
        }
        if (!a1.getProposito().equals("Planificar el proyecto")){
                resultado = false;
        }
       
       return resultado; 
    }
}
