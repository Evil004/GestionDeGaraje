package view.swing.eventHandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.UserController;
import controller.exceptions.EmptyLicensePlate;
import controller.exceptions.NotInGarage;

public class RegisterExit implements ActionListener {
	
	private JPanel parent;
	
	public RegisterExit(JPanel parent) {
		this.parent = parent;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String licensePlate = JOptionPane.showInputDialog(parent,"Introduce la matricula del vehiculo:");
		
		if (licensePlate == null) {
			return;
		}
		
		try {
			String exit = UserController.registerExit(licensePlate);
			
			JOptionPane.showMessageDialog(parent, "Se ha registrado la salida.\n"+ exit);
			
		} catch (NotInGarage | EmptyLicensePlate e1) {
			JOptionPane.showMessageDialog(parent,e1.getMessage());
		} 
		
	}

}
