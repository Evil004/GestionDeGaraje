package view.swing.eventHandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.UserController;
import controller.exceptions.AlreadyInGarage;
import controller.exceptions.EmptyLicensePlate;

public class RegisterEntry implements ActionListener {
	
	private JPanel parent;
	
	public RegisterEntry(JPanel parent) {
		this.parent = parent;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String licensePlate = JOptionPane.showInputDialog("Introduce la matricula del vehiculo:");
		
		try {
			UserController.registerEntry(licensePlate);
		} catch (AlreadyInGarage | EmptyLicensePlate e1) {
			JOptionPane.showMessageDialog(parent,e1.getMessage());
		} 
		
	}

}
