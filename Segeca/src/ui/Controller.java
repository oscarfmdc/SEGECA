package ui;

public class Controller {

	static Conector.ConectorBD bd;
	
	public static void main(String[] args) {
		
		UI window = new UI();
		window.getFrame().setVisible(true);
		
		bd = new Conector.ConectorBD();
	}

}
