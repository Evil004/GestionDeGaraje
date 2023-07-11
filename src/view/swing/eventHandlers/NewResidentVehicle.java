package view.swing.eventHandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.UserController;
import controller.exceptions.AlreadyRegistered;
import controller.exceptions.EmptyLicensePlate;

public class NewResidentVehicle implements ActionListener {
	
	private JPanel parent;
	
	public NewResidentVehicle(JPanel parent) {
		this.parent = parent;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String licensePlate = JOptionPane.showInputDialog(parent, "Introduce la matricula del vehiculo:");
		
		if (licensePlate == null) {
			return;
		}
		
		try {
			UserController.registerResidentVehicle(licensePlate);
		
			JOptionPane.showMessageDialog(parent, "Se ha registrado el vehiculo de residente");
		} catch (AlreadyRegistered | EmptyLicensePlate e1) {
			JOptionPane.showMessageDialog(parent,e1.getMessage());
		} 
		
	}

}
