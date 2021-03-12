/******************************************************************************
*	Program Author: Srividya Prakhya for Project on EZPass System             *
*																			  *
*******************************************************************************/

package Project;

import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;


class PayTollPanel extends JPanel implements ActionListener
{
    private JButton EnterButton,CancelButton;
    private JTextField TransactionIDField,TagCodeField,TransactionDateField,TransactionTimeField,TollPlazaField,CustomerIDField,TollAmountField,TollLaneNumberField;
	private String TransactionID,TagCode,TransactionDate,TransactionTime,TollPlaza,CustomerID,TollAmount,TollLaneNumber ;

    public PayTollPanel()
    {
        EnterButton = new JButton("Enter");
        CancelButton = new JButton("Cancel");

        //CreateProfileBox.addItem("Create Profile");

        TransactionIDField = new JTextField(15);
        TransactionIDField.setText(TransactionID);
        TagCodeField = new JTextField(15);
        TagCodeField.setText(TagCode);
        TransactionDateField = new JTextField(15);
		TransactionDateField.setText(TransactionDate);
		TransactionTimeField = new JTextField(10);
		TransactionTimeField.setText(TransactionTime);
		TollPlazaField = new JTextField(15);
		TollPlazaField.setText(TollPlaza);
		TollLaneNumberField = new JTextField(15);
		TollLaneNumberField.setText(TollLaneNumber);
		TollAmountField = new JTextField(15);
		TollAmountField.setText(TollAmount);
		CustomerIDField = new JTextField(15);


		JLabel TransactionIDLabel = new JLabel("TransactionID:");
        JLabel TagCodeLabel = new JLabel("TagCode:");
        JLabel TransactionDateLabel =new JLabel("Date:");
        JLabel TransactionTimeLabel= new JLabel("Time:");
        JLabel TollPlazaLabel = new JLabel("TollPlaza:");
        JLabel TollLaneNumberLabel = new JLabel("TollLaneNumber:");
        JLabel TollAmountLabel = new JLabel("TollAmount:");
        JLabel CustomerLabel = new JLabel("CustomerID:");

		//EnterButton.setActionCommand("Enter");
		EnterButton.addActionListener(this);
		CancelButton.addActionListener(this);


        JPanel TypePanel = new JPanel();
        JPanel TransactionIDPanel = new JPanel();
        JPanel TagCodePanel = new JPanel();
        JPanel TransactionDatePanel = new JPanel();
        JPanel TransactionTimePanel = new JPanel();
        JPanel TollPlazaPanel = new JPanel();
        JPanel CustomerIDPanel = new JPanel();
        JPanel TollLaneNumberPanel = new JPanel();
        JPanel TollAmountPanel = new JPanel();


        TransactionIDPanel.add(TransactionIDLabel);
        TransactionIDPanel.add(TransactionIDField);
        TagCodePanel.add(TagCodeLabel);
        TagCodePanel.add(TagCodeField);
        TransactionDatePanel.add(TransactionDateLabel);
		TransactionDatePanel.add(TransactionDateField);
		TransactionTimePanel.add(TransactionTimeLabel);
		TransactionTimePanel.add(TransactionTimeField);
        TollPlazaPanel.add(TollPlazaLabel);
        TollPlazaPanel.add(TollPlazaField);
        CustomerIDPanel.add(CustomerLabel);
        CustomerIDPanel.add(CustomerIDField);
        TollLaneNumberPanel.add(TollLaneNumberLabel);
        TollLaneNumberPanel.add(TollLaneNumberField);
        TollAmountPanel.add(TollAmountLabel);
        TollAmountPanel.add(TollAmountField);

        //CreateButton.addActionListener(this); //event listener registration

        //JPanel TopPanel = new JPanel();
        //TopPanel.add(TypePanel);
        //TopPanel.add(NamePanel);

        JPanel CenterPanel = new JPanel();
        CenterPanel.add(TransactionIDPanel);
        CenterPanel.add(TagCodePanel);
        CenterPanel.add(TransactionDatePanel);
   		CenterPanel.add(TransactionTimePanel);
        CenterPanel.add(TollPlazaPanel);
        CenterPanel.add(CustomerIDPanel);
        CenterPanel.add(TollLaneNumberPanel);
        CenterPanel.add(TollAmountPanel);
        CenterPanel.add(EnterButton);
        CenterPanel.add(CancelButton);

        setLayout(new BorderLayout());
        //add(TopPanel, BorderLayout.NORTH);
        add(CenterPanel, BorderLayout.CENTER);
        //add(OpenButton, BorderLayout.SOUTH);//add the one button on to this panel
    }

    public void actionPerformed(ActionEvent evt)  //event handling
    {
        //Object source = evt.getSource(); //get who generates this event
        String arg = evt.getActionCommand();
        if (arg.equals("Enter")) { //determine which button is clicked

        			String TransactionID = TransactionIDField.getText();
		            String TagCode = TagCodeField.getText(); //take actions
		            String TransactionDate = TransactionDateField.getText();
		            String TransactionTime = TransactionTimeField.getText();
		            String TollPlaza = TollPlazaField.getText();
		            String CustomerID = CustomerIDField.getText();
		            String TollLaneNumber = TollLaneNumberField.getText();
		            String TollAmount = TollAmountField.getText();
		            System.out.println(TransactionID);

		            PayTollControl paytoll_Ctrl = new PayTollControl(TransactionID,TagCode,TransactionDate,TransactionTime,TollPlaza,CustomerID,TollAmount,TollLaneNumber);
		}

	}
}

public class PayTollBO extends JFrame
{
    private PayTollPanel paytoll_Panel;

    public PayTollBO()
    {
        setTitle("PayToll");
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
         paytoll_Panel = new PayTollPanel();
         contentPane.add(paytoll_Panel);
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


