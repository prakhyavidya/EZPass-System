/******************************************************************************
*	Program Author: Srividya Prakhya for Project on EZPass System             *
*																			  *
*******************************************************************************/

package Project;

import java.lang.*; //including Java packages used by this program
import javax.swing.*;
import com.vidya.*;

public class PayTollControl
{
	private Account Acct;

	   	 private Transaction Trans;
	   	 public String arg;


    public PayTollControl(String TransactionID,String TagCode,String TransactionDate,String TransactionTime,String TollPlaza,String CustomerID,String TollAmount,String TollLaneNumber)
    {

			Trans = new Transaction(TransactionID,TagCode,TransactionDate,TransactionTime,TollPlaza,CustomerID,TollAmount,TollLaneNumber);
            String Trans_ID = Trans.PayToll();

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

