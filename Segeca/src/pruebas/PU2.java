package pruebas;

import def.Pc.Estado;
import ui.Controller;
import ui.UI;

public class PU2 {

	public static void pruebasUnitarias2() {
			
		System.out.println("------------------------------------------------");
		System.out.println("INICIO PRUEBAS UNITARIAS CICLO 2");
		System.out.println("------------------------------------------------");
		
		/* Crear PC inicial */
		System.out.println("PRUEBA 1:");
		System.out.println("Creando PC inicial...");
		//Datos<
		UI.textArea_PanelPCnueva_Fecha.setText("15/6/2015");
		UI.textPane_PanelPCnueva_Descripcion.setText("Peticion de prueba para las pruebas unitarias del ciclo 2");
		UI.textArea_PanelPCnueva_Motivo.setText("Prueba");
		UI.textArea_PanelPCnueva_Prioridad.setText("Baja");
		UI.textArea_PanelPCnueva_Email.setText("pruebas@unitarias.com");
		UI.textArea_PanelPCnueva_Documentos.setText("PruebasUnitarias.txt");
		//>Datos
		System.out.println("La función ha devuelto el valor de: " + Controller.altaPC());
		System.out.println("------------------------------------------------");
		
		
		/* Asignar PC a CCC */
		System.out.println("PRUEBA 2:");
		System.out.println("Asignando PC a CCC...");
		//Datos<
		UI.textField_PanelPC_CodPC.setText("15");
		Controller.pcSelected();
		UI.textField_PanelPC_CCC.setText("Admin");
		//>Datos
		System.out.println("La función ha devuelto el valor de: " + Controller.PCaCCC());
		System.out.println("------------------------------------------------");
		
		
		/* Asignar reunion a PC */
		System.out.println("PRUEBA 3:");
		System.out.println("Asignando reunión del CCC a PC...");
		//Datos<
		UI.textField_PanelPC_CodPC.setText("15");
		Controller.pcSelected();
		UI.textField_PanelPC_Reunion.setText("85");
		//>Datos
		System.out.println("La función ha devuelto el valor de: " + Controller.PcAgendaCCC());
		System.out.println("------------------------------------------------");
		
		
		/* Valorar PC */
		System.out.println("PRUEBA 4:");
		System.out.println("Añadiendo valoración a PC...");
		//Datos<
		UI.textField_PanelPC_CodPC.setText("15");
		Controller.pcSelected();
		UI.textPane_PanelPC_Valoracion.setText("Se valora correctamente la petición de prueba");
		//>Datos
		System.out.println("La función ha devuelto el valor de: " + Controller.valorarPC());
		System.out.println("------------------------------------------------");
		
		
		/* Modificar estado PC */
		System.out.println("PRUEBA 5:");
		System.out.println("Modificando estado de la PC...");
		//Datos<
		UI.textField_PanelPC_CodPC.setText("15");
		Controller.pcSelected();
		UI.comboBox_PanelPC_Estado.setSelectedItem(Estado.APROBADA);
		//>Datos
		System.out.println("La función ha devuelto el valor de: " + Controller.modEstadoPC());
		System.out.println("------------------------------------------------");
		
		
		System.out.println("FIN PRUEBAS UNITARIAS CICLO 2");
		System.out.println("------------------------------------------------");
	}

}
