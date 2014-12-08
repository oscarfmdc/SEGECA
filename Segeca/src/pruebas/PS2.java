/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import def.Pc;
import def.Pc.Estado;
import ui.Controller;
import ui.UI;

/**
 *
 * @author Marco
 */
public class PS2 {
	
	/**
	 * Realiza la simulación de interacción del usuario con el programa para la creación de una PC y modificación de 
	 * la misma. Se tienen en cuenta TODOS los procesos que debería ejecutar el usuario para alcanzar el objetivo.
	 * @param bd : Conexión a base de datos para simular la interacción por la que se pide mostrar la información
	 * en la interfaz gráfica de un PC antes de modificar sus campos.
	 */
	public static void PS2_Sistemas(Conector.ConectorBD bd) {
		
		/* Pruebas de sistema para el ciclo 2*/
		System.out.println("**** Prueba: Se lleva a cabo la creación y modificación de un PC ****");
		System.out.println("\n**** Paso 1: Creación a partir de los elementos UI de un PC ****");
		UI.textArea_PanelPCnueva_Fecha.setText("15/01/2015");
		UI.textPane_PanelPCnueva_Descripcion.setText("Realización prueba sistema");
		UI.textArea_PanelPCnueva_Documentos.setText("");
		UI.textArea_PanelPCnueva_Email.setText("miemail@email.com");
		UI.textArea_PanelPCnueva_Motivo.setText("PS");
		UI.textArea_PanelPCnueva_Prioridad.setText("Alta");
		
		Controller.altaPC();
		
		//Obtenemos el código de la última petición creada
		int codigoUltimoPC = bd.getCodLastPc();
		
		System.out.println("\n**** Paso 2: Simulamos el click en mostrar del la interfaz gráfica obteniendo el PC según su código****");
		//Primero obtenemos el objeto
		Pc pcParaPrueba = new Pc();
		pcParaPrueba.setCodPC(codigoUltimoPC);
		
		//Rellenamos el objeto
		bd.extractPc(pcParaPrueba);
		
		System.out.println("\n**** Paso 3: Comprobamos que efectivamente se ha obtenido la"
				+ "informacion del PC pedido****");
		
		System.out.println("\nComprobamos información obtenida:");
		System.out.println("Fecha: " + pcParaPrueba.getFecha());
		System.out.println("Descripción: " + pcParaPrueba.getDescripcion());
		System.out.println("Motivos: " + pcParaPrueba.getMotivo());
		System.out.println("Prioridad: " + pcParaPrueba.getPrioridad());
		System.out.println("Email: " + pcParaPrueba.getEmail());
		System.out.println("Documentos: " + pcParaPrueba.getDocumentos());
		
		System.out.println("\n**** Paso 5: Rellenamos los campos a actualizar ****");
		
		//Deben de existir el CCC y la agenda para poder relacionarlos, en caso contrario obtenemos un error
		UI.textField_PanelPC_CCC.setText("CCC_1");
		UI.textField_PanelPC_Reunion.setText("85");
		UI.textField_PanelPC_CodPC.setText(String.valueOf(codigoUltimoPC));
		UI.comboBox_PanelPC_Estado.setSelectedItem(Estado.APROBADA);
		
		System.out.println("\n**** Paso 5:  Asignamos el CCC, agenda y modificamos el estado a APROBADA****");
		
		//Mod Estado
		Controller.modEstadoPC();
		//Mod CCC
		Controller.PCaCCC();
		//Mod Agenda
		Controller.PcAgendaCCC();
		
	}
    
}