import controller.VehicleList;
import model.vehicle.OfficialVehicle;
import utilities.Utilities;
import view.MainMenu;

public class Main {
	public static void main(String[] args) {


		VehicleList.addVehicle(new OfficialVehicle("AF2315"));
		VehicleList.addVehicle(new OfficialVehicle("AF2316"));
		VehicleList.addVehicle(new OfficialVehicle("AF2317"));
		VehicleList.addVehicle(new OfficialVehicle("AF2318"));
		VehicleList.addVehicle(new OfficialVehicle("AF2319"));
		VehicleList.addVehicle(new OfficialVehicle("AF2310"));

		MainMenu.mainMenu();
		
		Utilities.closeScanner();
	}
}
