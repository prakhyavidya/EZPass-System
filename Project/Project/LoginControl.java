/******************************************************************************
*	Program Author: Srividya Prakhya for Project on EZPass System             *
*																			  *
*******************************************************************************/

import java.lang.*; //including Java packages used by this program
import javax.swing.*;
import com.vidya.*;

public class LoginControl
{
    private Account Acct;

    public LoginControl(String UName, String PWord) {
		Acct = new Account(UName, PWord);
		String CustomerName = Acct.signIn();
        if (!CustomerName.equals("")) {
            //System.out.println("successful!");
            //JOptionPane.showMessageDialog(null, "Login is successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            //OpenBankAccountBO OpenAcctBO = new OpenBankAccountBO(UName, CustomerName);
        	//EZPassSystem ezpassSys = new EZPassSystem();
			CreateProfileBO createProfBO = new CreateProfileBO(CustomerName);
			PayTollBO paytollBO = new PayTollBO();
			//EZTagBO eztagBo = new EZTagBO();

        } else
            //System.out.println("fail!");
            JOptionPane.showMessageDialog(null, "Login failed because of invalid username or password.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
	}
	public static void main(String [] args)
	{
	}

}