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

    	public static void PU_ConectorBD(){
		System.out.println("Prueba 1. Introducción y extracción de CCC: " + pruebaBD1());
		System.out.println("Prueba 2. Modificación de CCC: " + pruebaBD2());
		System.out.println("Prueba 3. Introducción y extracción de persona: " + pruebaBD3());
		System.out.println("Prueba 4. Modificación de persona: " + pruebaBD4());
		System.out.println("Prueba 5. Introducción y extracción de agenda: " + pruebaBD5());
		System.out.println("Prueba 6. Modificación de agenda: " + pruebaBD6());
		System.out.println("Prueba 7. Introducción y extracción de Acta: " + pruebaBD7());
		System.out.println("Prueba 8. Modificación de Acta: " + pruebaBD8());

		//Devolvemos la base de Datos a su estado inicial
		deleteActa(getCodLastActa());
		deleteActa(getCodLastActa());
		deleteAgenda(getCodLastAgenda());
		deleteAgenda(getCodLastAgenda());
		deleteCCC("CCC1");
		deletePersonaCCC("nom1");
		deleteCCC("CCC2");		
	}

	private static boolean pruebaBD1(){
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

	private static boolean pruebaBD2(){
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

	private static boolean pruebaBD3(){
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

	private static boolean pruebaBD4(){
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

	private static boolean pruebaBD5(){
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

	private static boolean pruebaBD6(){
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

	private static boolean pruebaBD7(){
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

	private static boolean pruebaBD8(){
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
}
