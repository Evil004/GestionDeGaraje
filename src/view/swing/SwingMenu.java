package view.swing;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.View;

public class SwingMenu extends JFrame implements View {

	@Override
	public void startView() {
		setTitle("Gestion de Garage");
		setSize(300,300);
		
		JPanel mainPanel = new MainPanel();
		add(mainPanel);
		
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
