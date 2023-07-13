package view.swing;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.View;

public class SwingMenu extends JFrame implements View {

	@Override
	public void startView() {
		setTitle("Gestion de Garaje");
		setSize(400,300);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel mainPanel = new MainPanel();
		add(mainPanel);
		
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
