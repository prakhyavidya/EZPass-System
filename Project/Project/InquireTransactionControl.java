/******************************************************************************
*	Program Author: Srividya Prakhya for Project on EZPass System             *
*																			  *
*******************************************************************************/
import java.lang.*; //including Java packages used by this program
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import com.model.TransactionModel;
import com.vidya.*;
import com.vidya.Transaction;

public class InquireTransactionControl
{

    public InquireTransactionControl( String TransactionDate,String CustomerID)
    {
		 {
			 Transaction transObject = new Transaction(TransactionDate,CustomerID);
             //transObject.recordTransaction();
            //System.out.println(" Created successful!");
			 List<TransactionModel> list=new ArrayList<TransactionModel>();
				list = transObject.inquireTransactions(TransactionDate);
                JOptionPane.showMessageDialog(null, "Created Profile Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            //} else
            //System.out.println("failed creating Profile!");
            //JOptionPane.showMessageDialog(null, "Opening a Creating Profile failed.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
