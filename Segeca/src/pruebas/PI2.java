package pruebas;

import def.*;
import def.Pc.Estado;
import ui.Controller;
import ui.UI;

/**
 *
 * @author Marco
 */
public class PI2 {
	
	public static void pruebaIntegracion(){
		System.out.println("Prueba 1. Comprobación: UI+Controller introduce PC correctamente en BD" + pruebaI1());
		System.out.println("Prueba 2. Comprobación: UI+Controller asigna agenda, CCC y estado a un PC" + pruebaI2());
	}

	/**
	 * Comprobación: UI+Controller introduce PC correctamente en BD
	 * @return
	 */
	private static boolean pruebaI1(){
		
		boolean resultado = false;
		UI.textArea_PanelPCnueva_Fecha.setText("16/01/2015");
		UI.textPane_PanelPCnueva_Descripcion.setText("Realización prueba integración");
		UI.textArea_PanelPCnueva_Documentos.setText("");
		UI.textArea_PanelPCnueva_Email.setText("miemails@email.com");
		UI.textArea_PanelPCnueva_Motivo.setText("PI");
		UI.textArea_PanelPCnueva_Prioridad.setText("Alta");
		
		Controller.altaPC();
		
		int codigoUltimoPC = Controller.getBd().getCodLastPc();
		
		Pc pcParaPrueba = new Pc(codigoUltimoPC);
		Controller.getBd().extractPc(pcParaPrueba);

		System.out.println(pcParaPrueba.getFecha());
		if (!pcParaPrueba.getFecha().equals("16/01/2015")){
			resultado = false;
		}
		if (pcParaPrueba.getDescripcion().equals("Realización prueba integración")){
			resultado = false;
		}
		if (!pcParaPrueba.getMotivo().equals("PI")){
			resultado = false;
		}
		if (!pcParaPrueba.getPrioridad().equals("Alta")){
			resultado = false;
		}
		if (!pcParaPrueba.getEmail().equals("miemails@email.com")){
			resultado = false;
		}
		if (!pcParaPrueba.getDocumentos().equals("")){
			resultado = false;
		}
		return resultado;
	}

	/**
	 * Comprobación: UI+Controller asigna agenda, CCC y estado a un PC
	 * @return
	 */
	private static boolean pruebaI2(){
		
		boolean resultado = true;		
		
		
		int codigoUltimoPC = 15;
		UI.textField_PanelPC_CCC.setText("CCC_1");
		UI.textField_PanelPC_Reunion.setText("85");
		UI.textField_PanelPC_CodPC.setText(String.valueOf(codigoUltimoPC));
		UI.comboBox_PanelPC_Estado.setSelectedItem(Estado.APROBADA);
		
		Controller.modEstadoPC();
		Controller.PCaCCC();
		Controller.PcAgendaCCC();
				
		Pc pcParaPrueba = new Pc(codigoUltimoPC);
		Controller.getBd().extractPc(pcParaPrueba);

		if (!pcParaPrueba.getCcc().getNombreCCC().contains("CCC_1")){
			resultado = false;
		}
		if (pcParaPrueba.getAgenda().equals("85")){
			resultado = false;
		}
		if (!pcParaPrueba.getEstado().equals(Estado.APROBADA)){
			resultado = false;
		}
		return resultado;
	}
}
