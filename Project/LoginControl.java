/******************************************************************************
*	Program Author: Srividya Prakhya for Project on EZPass System             *
*																			  *
*******************************************************************************/
package Project;

import java.lang.*; //including Java packages used by this program
import javax.swing.*;
import com.vidya.*;

public class LoginControl {
	private static final String CustomerID = null;
	private Account Acct;

	public LoginControl(String UName, String PWord) {
		Acct = new Account(UName, PWord);
		String CustomerName = Acct.SignIn();
		System.out.println("CustomerName is" + CustomerName);
		if (!CustomerName.equals("")) {
			// System.out.println("successful!");
			// JOptionPane.showMessageDialog(null, "Login is successful!", "Confirmation",
			// JOptionPane.INFORMATION_MESSAGE);
			// OpenBankAccountBO OpenAcctBO = new OpenBankAccountBO(UName, CustomerName);
			// EZPassSystem ezpassSys = new EZPassSystem();
			//System.out.println("Namepwd: 1");
			
			JFrame frame = new MainBO("CustomerID", "CustomerName"); //initialize a JFrame object
			frame.setVisible(true);
			frame.show(); //display the frame
//			System.out.println("Namepwd: 2");
			//CreateProfileBO createProfBO = new CreateProfileBO(UName, PWord);
//			System.out.println("Namepwd: 3");
//			PayTollBO paytollBO = new PayTollBO();
//			EZTagBO eztagBO = new EZTagBO();
//			VehicleBO vehBO = new VehicleBO();
//			InquireTransactionBO inqtransBO = new InquireTransactionBO();
		} else
			// System.out.println("fail!");
			JOptionPane.showMessageDialog(null, "Login failed because of invalid username or password.", "Confirmation",
					JOptionPane.INFORMATION_MESSAGE);
	}

	public static void main(String[] args) {
	}

}