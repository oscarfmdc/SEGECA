package pruebas;

import static Conector.ConectorBD.*;
import def.*;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import static ui.Controller.*;
import ui.UI;
import def.Pc.Estado;
import ui.Controller;
import ui.UI;

public class PU2 {

//	//Introducción y extracción de PC
//	private static boolean pruebaBD9(){
//		boolean resultado = true;
//		Pc pc1 = new Pc();
//		Pc pc2 = new Pc();
//		pc1.setDescripcion("Descripción 1");
//		pc1.setFecha("29/08/2015");
//		pc1.setMotivo("Motivo1");
//		pc1.setEstado(Pc.Estado.ABIERTA);
//		pc1.setPrioridad("Alta");
//
//		addPC(pc1);
//		pc2.setCodPC(getCodLastPc());
//		extractPc(pc2);
//
//		if(!pc1.getDescripcion().equals(pc2.getDescripcion())){
//			resultado = false;
//		}
//		if(!pc1.getFecha().equals(pc2.getFecha())){
//			resultado = false;
//		}
//		if(!pc1.getMotivo().equals(pc2.getMotivo())){
//			resultado = false;
//		}
//		if(!pc1.getEstado().toString().equals(pc2.getEstado().toString())){
//			resultado = false;
//		}
//		if(!pc1.getPrioridad().equals(pc2.getPrioridad())){
//			resultado = false;
//		}
//		return resultado;
//	}
//
//	//Asignación de CCC a PC
//	private static boolean pruebaBD10(){
//		boolean resultado = true;
//		Pc pc1 = new Pc(getCodLastPc());
//		Pc pc2 = new Pc(getCodLastPc());
//		Ccc CCC2 = new Ccc("CCC2");
//
//		extractPc(pc1);
//		pc1.setCcc(CCC2);
//		addPCaCCC(pc1);
//		extractPc(pc2);
//
//		if(!pc1.getCcc().getNombreCCC().equals(pc2.getCcc().getNombreCCC())){
//			resultado = false;
//		}            
//		return resultado;
//	}
//
//	private static boolean pruebaBD11(){
//		boolean resultado = true;
//		Pc pc1 = new Pc(getCodLastPc());
//		Pc pc2 = new Pc(getCodLastPc());
//		Agenda a1 = new Agenda(getCodLastAgenda());
//
//		extractPc(pc1);
//		pc1.setAgenda(a1);
//		addPCagendaCCC(pc1);
//		extractPc(pc2);
//
//		if(!pc1.getAgenda().getCodAgenda().equals(pc2.getAgenda().getCodAgenda())){
//			resultado = false;
//		}            
//		return resultado;
//	}
//
//	//Modificación de campo valoración
//	private static boolean pruebaBD12(){
//		boolean resultado = true;
//		Pc pc1 = new Pc(getCodLastPc());
//		Pc pc2 = new Pc(getCodLastPc());
//		pc1.setValoracion("Valoracion1");
//
//		valorarPC(pc1);
//		extractPc(pc2);
//
//		if(!pc1.getValoracion().equals(pc2.getValoracion())){
//			resultado = false;
//		} 
//		return resultado;
//	}
	
	
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
