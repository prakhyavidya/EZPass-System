/******************************************************************************
*	Program Author: Srividya Prakhya for Project on EZPass System             *
*																			  *
*******************************************************************************/
import java.lang.*; //including Java packages used by this program
import javax.swing.*;
import com.vidya.*;
import com.vidya.Vehicle;

public class VehicleControl {

	private Vehicle Veh;

	public VehicleControl(String LicensePlateNumber, String Make, String Model, String Colour, String TagCode,String CustomerID, String Year)
		{
			Veh = new Vehicle(LicensePlateNumber, Make, Model, Colour, TagCode, CustomerID, Year);
			boolean isAdded = Veh.addVehicle(LicensePlateNumber, Make, Model, Colour, TagCode, CustomerID, Year);

			if (isAdded) {
				System.out.println(" Add Vehicle successful!");
				JOptionPane.showMessageDialog(null, "Add Vehicle successful!", "Confirmation",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				System.out.println("Add Vehicle failed!");
				JOptionPane.showMessageDialog(null, "Add Vehicle failed.", "Confirmation",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}

}