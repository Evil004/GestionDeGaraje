package view.swing.eventHandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.UserController;

public class StartMonth implements ActionListener {

	private JPanel parent;

	public StartMonth(JPanel parent) {
		this.parent = parent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		UserController.startNewMonth();

		JOptionPane.showMessageDialog(parent, "Se ha iniciado un nuevo mes.");

	}

}
