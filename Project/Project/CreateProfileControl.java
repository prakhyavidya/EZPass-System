/******************************************************************************
*	Program Author: Srividya Prakhya for Project on EZPass System             *
*																			  *
*******************************************************************************/
import java.lang.*; //including Java packages used by this program
import javax.swing.*;
import com.vidya.*;
import com.vidya.Customer;

public class CreateProfileControl
{
	private Account Acct;

	   	 private Customer Cus;
	   	 public String arg;


    public CreateProfileControl(String CustomerID,String  Name, String Street, String City, String State1, String Zip,String Phone, String Email, String  Balance)
    {

			Cus = new Customer(CustomerID,Name, Street, City, State1, Zip,Phone, Email, Balance);
            String Cus_ID = Cus.createProfile();

            if(!CustomerID.equals(""))

		   		{
            //System.out.println(" Created successful!");
                JOptionPane.showMessageDialog(null, "Created Profile Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            } else {
            //System.out.println("failed creating Profile!");
            JOptionPane.showMessageDialog(null, "Opening a Creating Profile failed.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
	}

}
}

