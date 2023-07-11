package view.swing;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.swing.eventHandlers.GenerateResidentReports;
import view.swing.eventHandlers.NewOfficialVehicle;
import view.swing.eventHandlers.NewResidentVehicle;
import view.swing.eventHandlers.RegisterEntry;
import view.swing.eventHandlers.RegisterExit;
import view.swing.eventHandlers.StartMonth;

public class MainPanel extends JPanel {
	
	public MainPanel() {
		
		setLayout(new GridLayout(6,1));
		
		JButton registerEntry = new JButton("Registrar entrada");
		registerEntry.addActionListener(new RegisterEntry(this));
		add(registerEntry);
		
		JButton registerExit = new JButton("Registrar salida");
		registerExit.addActionListener(new RegisterExit(this));
		add(registerExit);
		
		JButton newOfficialVehicle = new JButton("Dar de alta vehículo oficial");
		newOfficialVehicle.addActionListener(new NewOfficialVehicle(this));
		add(newOfficialVehicle);
		
		JButton newResidentVehicle = new JButton("Dar de alta vehículo de residente");
		newResidentVehicle.addActionListener(new NewResidentVehicle(this));
		add(newResidentVehicle);
		
		JButton startMonth = new JButton("Iniciar mes");
		startMonth.addActionListener(new StartMonth(this));
		add(startMonth);
		
		JButton generateMonthlyReport = new JButton("Generar informe de los pagos de los residentes");
		generateMonthlyReport.addActionListener(new GenerateResidentReports(this));
		add(generateMonthlyReport);
		
		
		
		
	}

}
