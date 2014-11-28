/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import static ui.Controller.*;
import ui.UI;

/**
 *
 * @author Mark
 */
public class PU {
    public static void PU_requisitos() {
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
        UI.textFieldAgenda.setText("20"); /* Extraer un cÃ³digo de agenda */

        UI.textFieldAusencias.setText("Javier, Nacho");
        UI.textFieldResultados.setText("Asignacion de tareas a los participantes.");
        // Llamamos a la funcion a testear
        prepararActa();

        /* Prueba 7 */
        System.out.println("**** Prueba 7: Alta de nuevo CCC ****");
        // Establecemos jTextFields
        UI.textFieldNombreCCC.setText("CCC_SEGECA");
        UI.textFieldAdministrador.setText("Pepe");
        UI.textFieldPresidente.setText("Martin");
        UI.textFieldSecretario.setText("Oscar");	
        // Llamamos a la funcion a testear
        altaCCC();

        /* Prueba 8 */
        System.out.println("**** Prueba 8: Baja de CCC existente ****");
        bajaCCC();

        /* Prueba 9 */
        System.out.println("**** Prueba 9: ModificaciÃ³n de miembro de CCC ****");
        // Establecemos jTextFields
        UI.textField_PanelMiembro_CCC.setText("CCC_1");
        UI.textField_PanelMiembro_Email.setText("email@ejemplo.es");
        UI.textField_PanelMiembro_Nombre.setText("Oscar");
        UI.textField_PanelMiembro_Telefono.setText("666123456");
        // Llamamos a la funcion a testear
        modMiembrosCCC();

        /* Prueba 10 */
        System.out.println("**** Prueba 10: ModificaciÃ³n de miembro de CCC 2 ****");
        // Establecemos jTextFields
        UI.textField_PanelMiembro_CCC.setText("CCC_1");
        UI.textField_PanelMiembro_Email.setText("email@ejemplo.es");
        UI.textField_PanelMiembro_Nombre.setText("Oscar");
        UI.textField_PanelMiembro_Telefono.setText("666456");
        // Llamamos a la funcion a testear
        modMiembrosCCC();
        // debe devolver error, porque el numero de telefono no es valido

        /* Prueba 11 */
        System.out.println("**** Prueba 11: Alta miembro en un CCC ****");
        // Establecemos jTextFields
        UI.textField_PanelMiembro_Nick.setText("k3xr");
        UI.textField_PanelMiembro_CCC.setText("CCC_1");
        UI.textField_PanelMiembro_Email.setText("email@ejemplo.es");
        UI.textField_PanelMiembro_Nombre.setText("Oscar");
        UI.textField_PanelMiembro_Telefono.setText("666456123");
        //Llamamos a la funcion a testear
        altaPersonaCCC();

        /* Prueba 12 */
        System.out.println("**** Prueba 12: Baja miembro en un CCC ****");
        bajaPersonaCCC();

    }
    
}
