/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: February, 2014													  *
*******************************************************************************/

import java.lang.*; //including Java packages used by this program
import javax.swing.*;
import com.vidya.*;

public class OpenBankAccountControl
{

    public OpenBankAccountControl(String AcountType, String  AcountNumber, String  Name, String  UName, String  Balance) {
		//Use CheckingAccount object to invoke method openAcct()
		if (AcountType.equals("Checking")) {
			CheckingAccount CA = new CheckingAccount(AcountNumber, Name, UName, Balance);
            if (CA.openAcct()) {
            //System.out.println("successful!");
                JOptionPane.showMessageDialog(null, "Opening a Checking Account is Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            } else
            //System.out.println("fail!");
            JOptionPane.showMessageDialog(null, "Opening a Checking Account failed.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}