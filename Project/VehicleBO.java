/******************************************************************************
*	Program Author: Srividya Prakhya for Project on EZPass System             *
*																			  *
*******************************************************************************/

package Project;

import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;


class VehiclePanel extends JPanel implements ActionListener
{
    private JButton AddButton,CancelButton;
    private JTextField LicensePlateNumberField, MakeField, ModelField, ColourField, TagCodeField, CustomerIDField, YearField;
	private String LicensePlateNumber, Make, Model, Colour, TagCode, CustomerID, Year;

    public VehiclePanel()
    {
        AddButton = new JButton("Add");
        CancelButton = new JButton("cancel");

        //CreateProfileBox.addItem("Create Profile");

        LicensePlateNumberField = new JTextField(15);
        LicensePlateNumberField.setText(LicensePlateNumber);
		MakeField = new JTextField(15);
		MakeField.setText(Make);
		ModelField = new JTextField(15);
		ModelField.setText(Model);
		ColourField = new JTextField(15);
		ColourField.setText(Colour);
		TagCodeField = new JTextField(15);
		TagCodeField.setText(TagCode);
		YearField = new JTextField(10);
		YearField.setText(Year);
        CustomerIDField = new JTextField(15);



        JLabel LicensePlateNumberLabel = new JLabel("LicensePlateNumber:");
        JLabel MakeLabel = new JLabel("Make:");
        JLabel ModelLabel = new JLabel("Model:");
        JLabel ColourLabel = new JLabel("Colour:");
        JLabel TagCodeLabel =new JLabel("TagCode:");
        JLabel YearLabel= new JLabel("Year:");
        JLabel CustomerLabel = new JLabel("CustomerID:");

		//CreateButton.setActionCommand("Create");
		AddButton.addActionListener(this);
		CancelButton.addActionListener(this);


        JPanel TypePanel = new JPanel();
        JPanel CustomerIDPanel = new JPanel();
        JPanel LicensePlateNumberPanel = new JPanel();
        JPanel MakePanel = new JPanel();
        JPanel ModelPanel = new JPanel();
        JPanel ColourPanel = new JPanel();
        JPanel TagCodePanel = new JPanel();
        JPanel YearPanel = new JPanel();

        CustomerIDPanel.add(CustomerLabel);
        CustomerIDPanel.add(CustomerIDField);
        LicensePlateNumberPanel.add(LicensePlateNumberLabel);
        LicensePlateNumberPanel.add(LicensePlateNumberField);
        MakePanel.add(MakeLabel);
        MakePanel.add(MakeField);
        ModelPanel.add(ModelLabel);
        ModelPanel.add(ModelField);
        ColourPanel.add(ColourLabel);
        ColourPanel.add(ColourField);
        TagCodePanel.add(TagCodeLabel);
        TagCodePanel.add(TagCodeField);
        YearPanel.add(YearLabel);
        YearPanel.add(YearField);

        //CreateButton.addActionListener(this); //event listener registration

        //JPanel TopPanel = new JPanel();
        //TopPanel.add(TypePanel);
        //TopPanel.add(NamePanel);

        JPanel CenterPanel = new JPanel();
        CenterPanel.add(CustomerIDPanel);
        CenterPanel.add(LicensePlateNumberPanel);
        CenterPanel.add(MakePanel);
        CenterPanel.add(ModelPanel);
        CenterPanel.add(ColourPanel);
        CenterPanel.add(TagCodePanel);
   		CenterPanel.add(YearPanel);
        CenterPanel.add(AddButton);
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
        if (arg.equals("Add")) { //determine which button is clicked
        			String CustomerID = CustomerIDField.getText();
		            String LicensePlateNumber = LicensePlateNumberField.getText(); //take actions
		            String Make = MakeField.getText();
		            String Model = ModelField.getText();
		            String Colour = ColourField.getText();
		            String TagCode = TagCodeField.getText();
		            String Year = YearField.getText();
		            System.out.println(LicensePlateNumber);

		            VehicleControl veh_Ctrl = new VehicleControl(LicensePlateNumber, Make, Model, Colour, TagCode, CustomerID, Year);
		}

	}
}

public class VehicleBO extends JFrame
{
    private VehiclePanel veh_Panel;

    public VehicleBO()
    {
	setTitle("Vehicle creation");
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
         veh_Panel = new VehiclePanel();
         contentPane.add(veh_Panel);
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


