package ui;

public class Controller {

	static Conector.ConectorBD bd;
	
	public static void main(String[] args) {
		
		UI window = new UI();
		window.getFrame().setVisible(true);
		
		bd = new Conector.ConectorBD();
		pruebas();
		bd.desconectar();
	}
	
	private static void pruebas(){
		def.Persona p = new def.Persona();
		p.setNick("Javier");
		bd.extraerPersona(p);
		System.out.println(p.toString());
		
	}

}
