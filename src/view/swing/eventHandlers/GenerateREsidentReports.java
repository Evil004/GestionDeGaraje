package view.swing.eventHandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.UserController;

public class GenerateResidentReports implements ActionListener {

	private JPanel parent;

	public GenerateResidentReports(JPanel parent) {
		this.parent = parent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String fileName = JOptionPane.showInputDialog(parent, "Introduce el nombre que quieres darle al archivo");
		
		if (fileName == null|| fileName.trim() == "") {
			return;

		}

		if (fileName.trim().equals("")) {
			
			JOptionPane.showMessageDialog(parent, "No puedes dejar el nombre del archivo vacio", "Error al guardar", JOptionPane.WARNING_MESSAGE);

			return;

		}
		try {
			String filePath = UserController.generateMonthlyBill(fileName);
			JOptionPane.showMessageDialog(parent, "Se ha guardado el archivo en la sigueinte ruta: " + filePath);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


	}

}
