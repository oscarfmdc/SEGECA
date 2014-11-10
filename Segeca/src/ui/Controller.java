package ui;

public class Controller {

	static Conector.ConectorBD bd;
	
	public static void main(String[] args) {
		
		UI window = new UI();
		window.getFrame().setVisible(true);
		
		
		bd = new Conector.ConectorBD("192.168.1.84:3306","SEGECA","admin","Grupo10");
		pruebas();
		bd.desconectar();
	}
	
	//Basurilla para comprobar el funcionamiento de ConectorBD
	private static void pruebas(){
		def.Agenda a = new def.Agenda();
		a.setCodAgenda(2);
		bd.extraerAgenda(a);
		System.out.println(a.toString());
		
	}

}
