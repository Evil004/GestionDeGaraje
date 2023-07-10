import view.View;
import view.console.ConsoleMenu;
import view.swing.SwingMenu;

public class Main {
	public static void main(String[] args) {
		//View vista = new ConsoleMenu();
		View vista = new SwingMenu();
		
		vista.startView();
		
	}
}
