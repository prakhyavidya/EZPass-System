/******************************************************************************
*	Program Author: Srividya Prakhya for Project on EZPass System             *
*																			  *
*******************************************************************************/

package Project;

import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;


class InquireTransactionPanel extends JPanel implements ActionListener
{
    private JButton SearchButton;
    private JTextField TransactionDateField,CustomerIDField;
	private String TransactionDate,CustomerID ;

    public InquireTransactionPanel()
    {
        SearchButton = new JButton("Search");
        //CancelButton = new JButton("cancel");

        //CreateProfileBox.addItem("Create Profile");

      
		TransactionDateField = new JTextField(15);
		TransactionDateField.setText(TransactionDate);
        CustomerIDField = new JTextField(15);


		//JLabel TransactionID = new JLabel("TransactionID:");
      
        JLabel TransactionDateLabel =new JLabel("Date:");
      
        JLabel CustomerLabel = new JLabel("CustomerID:");

		//SearchButton.setActionCommand("Search");
		SearchButton.addActionListener(this);
		//CancelButton.addActionListener(this);


        //JPanel TypePanel = new JPanel();
        
        //JPanel TransactionPanel = new JPanel
       
        JPanel TransactionDatePanel = new JPanel();
        JPanel CustomerIDPanel = new JPanel();
       
       
        TransactionDatePanel.add(TransactionDateLabel);
        TransactionDatePanel.add(TransactionDateField);
        CustomerIDPanel.add(CustomerLabel);
        CustomerIDPanel.add(CustomerIDField);
       
       
        //SearchButton.addActionListener(this); //event listener registration

        //JPanel TopPanel = new JPanel();
        //TopPanel.add(TypePanel);
        //TopPanel.add(NamePanel);

        JPanel CenterPanel = new JPanel();
        CenterPanel.add(TransactionDatePanel);
        CenterPanel.add(CustomerIDPanel);
        CenterPanel.add(SearchButton);

        setLayout(new BorderLayout());
        //add(TopPanel, BorderLayout.NORTH);
        add(CenterPanel, BorderLayout.CENTER);
        //add(OpenButton, BorderLayout.SOUTH);//add the one button on to this panel
    }

    public void actionPerformed(ActionEvent evt)  //event handling
    {
        //Object source = evt.getSource(); //get who generates this event
        String arg = evt.getActionCommand();
        if (arg.equals("Search")) { //determine which button is clicked
		            String TransactionDate = TransactionDateField.getText();
		            String CustomerID = CustomerIDField.getText();
		            //System.out.println(CustomerID);

		            InquireTransactionControl IT_Ctrl = new InquireTransactionControl(TransactionDate,CustomerID);
		}

	}
}

public class InquireTransactionBO extends JFrame
{
    private InquireTransactionPanel IT_Panel;

    public InquireTransactionBO()
    {
        setTitle("Inquire Transaction");
        setSize(450, 200);

         //get screen size and set the location of the frame
         Toolkit tk = Toolkit.getDefaultToolkit();
         Dimension d = tk.getScreenSize();
         int screenHeight = d.height;
         int screenWidth = d.width;
         //setLocation( screenWidth / 3, screenHeight / 4);

         addWindowListener (new WindowAdapter()  //handle window event
            {
		       public void windowClosing (WindowEvent e)
			                  { System.exit(0);
               }
            });

         Container contentPane = getContentPane(); //add a panel to a frame
         IT_Panel = new InquireTransactionPanel();
         contentPane.add(IT_Panel);
         show();
    }

    public static void main(String [] args)
    {
		JFrame frame = new LoginBO(); //initialize a JFrame object
      	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 	frame.setVisible(true);
      	frame.show(); //display the frame
    }
}


