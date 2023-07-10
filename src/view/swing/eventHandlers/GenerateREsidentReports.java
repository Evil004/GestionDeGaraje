package view.swing.eventHandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.UserController;

public class GenerateREsidentReports implements ActionListener {

	private JPanel parent;

	public GenerateREsidentReports(JPanel parent) {
		this.parent = parent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String fileName = JOptionPane.showInputDialog("Introduce el nombre que quieres darle al archivo");

		try {
			String filePath = UserController.generateMonthlyBill(fileName);
			JOptionPane.showMessageDialog(parent, "Se ha guardado el archivo en la sigueinte ruta: " + filePath);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


	}

}
