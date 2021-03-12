/******************************************************************************
*	Program Author: Srividya Prakhya for Project on EZPass System             *
*																			  *
*******************************************************************************/
import java.lang.*; //including Java packages used by this program
import javax.swing.*;
import com.vidya.*;

public class EZTagControl
{
	private Account Acct;

	   	 private EZTag eztag;
	   	 public String arg;


    public void EZTagControl(String TagCode,String TagType, String IssueDate,String CustomerID)
    {

			eztag = new EZTag(TagCode, TagType, IssueDate, CustomerID);
            String Tag_Code = eztag.addTag(TagCode, TagType, IssueDate, CustomerID);

            if(!Tag_Code.equals(""))

		   		{
            //System.out.println(" Created successful!");
                JOptionPane.showMessageDialog(null, "Tag added Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            } else {
            //System.out.println("failed creating Profile!");
            JOptionPane.showMessageDialog(null, "Adding Tag failed.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
	}

}
}

