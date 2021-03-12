/******************************************************************************
*	Program Author: Srividya Prakhya for Project on EZPass System             *
*																			  *
*******************************************************************************/
package Project;

import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;


class CreateProfilePanel extends JPanel implements ActionListener
{
    private JButton CreateButton,CancelButton;
    private JTextField CustomerIDField, NameField, StreetField, CityField, StateField, ZipField,PhoneField, EmailField, BalanceField;
	private String Name, Street, City, State1, Zip, Phone, Email, CustomerID, Balance;

    public CreateProfilePanel(String Username,String CustomerID)
    {
        CreateButton = new JButton("Create");
        CancelButton = new JButton("Cancel");

        //CreateProfileBox.addItem("Create Profile");

        NameField = new JTextField(15);
        NameField.setText(Name);
		StreetField = new JTextField(15);
		StreetField.setText(Street);
		CityField = new JTextField(15);
		CityField.setText(City);
		StateField = new JTextField(15);
		StateField.setText(State1);
		ZipField = new JTextField(15);
		ZipField.setText(Zip);
		PhoneField = new JTextField(10);
		PhoneField.setText(Phone);
		EmailField = new JTextField(20);
        EmailField.setText(Email);
        BalanceField = new JTextField(15);
        BalanceField.setText("0.0");
        CustomerIDField = new JTextField(15);



        JLabel NameLabel = new JLabel("Name:");
        JLabel StreetLabel = new JLabel("Street:");
        JLabel CityLabel = new JLabel("City:");
        JLabel StateLabel = new JLabel("state:");
        JLabel ZipLabel =new JLabel("Zip:");
        JLabel PhoneLabel= new JLabel("Phone number:");
        JLabel EmailLabel= new JLabel("Email:");
        JLabel BalanceLabel = new JLabel("Deposit:");
        JLabel CustomerIDLabel = new JLabel("CustomerID:");

		//CreateButton.setActionCommand("Create");
		CreateButton.addActionListener(this);
		CancelButton.addActionListener(this);


        JPanel TypePanel = new JPanel();
        JPanel CustomerIDPanel = new JPanel();
        JPanel NamePanel = new JPanel();
        JPanel StreetPanel = new JPanel();
        JPanel CityPanel = new JPanel();
        JPanel StatePanel = new JPanel();
        JPanel ZipPanel = new JPanel();
        JPanel PhonePanel = new JPanel();
        JPanel EmailPanel = new JPanel();
        JPanel BalancePanel = new JPanel();


        CustomerIDPanel.add(CustomerIDLabel);
        CustomerIDPanel.add(CustomerIDField);
        NamePanel.add(NameLabel);
        NamePanel.add(NameField);
        StreetPanel.add(StreetLabel);
        StreetPanel.add(StreetField);
        CityPanel.add(CityLabel);
        CityPanel.add(CityField);
        StatePanel.add(StateLabel);
        StatePanel.add(StateField);
        ZipPanel.add(ZipLabel);
        ZipPanel.add(ZipField);
        PhonePanel.add(PhoneLabel);
        PhonePanel.add(PhoneField);
        EmailPanel.add(EmailLabel);
        EmailPanel.add(EmailField);
        BalancePanel.add(BalanceLabel);
        BalancePanel.add(BalanceField);

        //CreateButton.addActionListener(this); //event listener registration

        //JPanel TopPanel = new JPanel();
        //TopPanel.add(TypePanel);
        //TopPanel.add(NamePanel);

        JPanel CenterPanel = new JPanel();
        CenterPanel.add(CustomerIDPanel);
        CenterPanel.add(NamePanel);
        CenterPanel.add(StreetPanel);
        CenterPanel.add(CityPanel);
        CenterPanel.add(StatePanel);
        CenterPanel.add(ZipPanel);
   		CenterPanel.add(PhonePanel);
   		CenterPanel.add(EmailPanel);
        CenterPanel.add(BalancePanel);
        CenterPanel.add(CreateButton);
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
        if (arg.equals("Create")) { //determine which button is clicked
        			String CustomerID = CustomerIDField.getText();
		            String Name = NameField.getText(); //take actions
		            String Street = StreetField.getText();
		            String City = CityField.getText();
		            String State1 = StateField.getText();
		            String Zip = ZipField.getText();
		            String Phone = PhoneField.getText();
		            String Email = EmailField.getText();
		            String Balance = BalanceField.getText();
		            //System.out.println(Name);

		            CreateProfileControl CP_Ctrl = new CreateProfileControl(CustomerID,Name,Street,City,State1,Zip,Phone,Email, Balance);
		}else {


			System.out.println("Cancel");

		}

	}
}

public class CreateProfileBO extends JFrame
{
    private CreateProfilePanel CP_Panel;
    private JMenu MyAccountMenu;
	private JMenuBar MyAccountMenuBar;
	private JMenuItem UpdatecustomerprofileMenuItem, changepasswordMenuItem, logoutMenuItem;
	private String Name;

    public CreateProfileBO( String Name,String CustomerID)
    {
	setTitle("Create Profile");
        setSize(450, 200);
        
        String name = Name;
		String CUS_ID = CustomerID;
		
		System.out.println("Cname: "+name);
		System.out.println("CusID: "+CUS_ID);
		

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

  /*       MyAccountMenuBar = new JMenuBar();
		   MyAccountMenu = new JMenu("My Account"); // initializing menus
		   MyAccountMenu.setMnemonic('M');
		   UpdatecustomerprofileMenuItem = new JMenuItem("Update Customer Profile", 'U');
		   changepasswordMenuItem = new JMenuItem("change password", 'C');
         logoutMenuItem = new JMenuItem("Logout", 'L');

                   MyAccountMenu.add(UpdatecustomerprofileMenuItem);
		   	         MyAccountMenu.addSeparator();
		   	         MyAccountMenu.add(changepasswordMenuItem);
		   			 MyAccountMenu.addSeparator();
		   	         MyAccountMenu.add(logoutMenuItem);
		   			 MyAccountMenu.addSeparator();

		   			 setJMenuBar(MyAccountMenuBar);*/



		       CP_Panel =  new CreateProfilePanel(name,CustomerID);
		       Container contentPane = getContentPane(); //add a panel to a frame
		       contentPane.add(CP_Panel);

				show();
    }

    public static void main(String [] args)
    {
		//JFrame frame = new LoginBO(); //initialize a JFrame object
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 	frame.setVisible(true);
      	frame.show(); //display the frame
    }
}


