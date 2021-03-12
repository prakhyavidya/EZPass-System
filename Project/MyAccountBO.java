package Project;
/******************************************************************************
	Program Author: Srividya Prakhya for Project on EZPass System             *
*																			  *
*******************************************************************************/

import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;


class MyAccountPanel extends JPanel implements ActionListener
{
    private JButton CreateButton,CancelButton;
    private JTextField UsernameField, PasswordField, Password1Field, NameField;
	private String Username, Password, Password1, Name;

    public MyAccountPanel(String CustomerName)
    {
        CreateButton = new JButton("Create");
        //CancelButton = new JButton("cancel");

        //CreateProfileBox.addItem("Create Profile");

        NameField = new JTextField(15);
        NameField.setText(Name);
		UsernameField = new JTextField(15);
		UsernameField.setText(Username);
		PasswordField = new JTextField(15);
		PasswordField.setText(Password);
		Password1Field = new JTextField(15);
		Password1Field.setText(Password1);
        //CustomerIDField = new JTextField(15);



        JLabel NameLabel = new JLabel("Name:");
        JLabel UsernameLabel = new JLabel("Username:");
        JLabel PasswordLabel = new JLabel("Password:");
        JLabel Password1Label = new JLabel("Password1:");
        //JLabel CustomerLabel = new JLabel("CustomerID:");

		CreateButton.setActionCommand("Create");
		CreateButton.addActionListener(this);
		//CancelButton.addActionListener(this);


        JPanel TypePanel = new JPanel();
        //JPanel CustomerIDPanel = new JPanel();
        JPanel NamePanel = new JPanel();
        JPanel UsernamePanel = new JPanel();
        JPanel PasswordPanel = new JPanel();
        JPanel Password1Panel = new JPanel();


        //CustomerIDPanel.add(CustomerLabel);
        //CustomerIDPanel.add(CustomerIDField);
        NamePanel.add(NameLabel);
        NamePanel.add(NameField);
        UsernamePanel.add(UsernameLabel);
        UsernamePanel.add(UsernameField);
        PasswordPanel.add(PasswordLabel);
        PasswordPanel.add(PasswordField);
        Password1Panel.add(Password1Label);
        Password1Panel.add(Password1Field);

        //CreateButton.addActionListener(this); //event listener registration

        //JPanel TopPanel = new JPanel();
        //TopPanel.add(TypePanel);
        //TopPanel.add(NamePanel);

        JPanel CenterPanel = new JPanel();
        //CenterPanel.add(CustomerIDPanel);
        CenterPanel.add(NamePanel);
        CenterPanel.add(UsernamePanel);
        CenterPanel.add(PasswordPanel);
        CenterPanel.add(Password1Panel);
        CenterPanel.add(CreateButton);

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
        			//String CustomerID = CustomerIDField.getText();
		            String Name = NameField.getText(); //take actions
		            String Username = UsernameField.getText();
		            String Password = PasswordField.getText();
		            String Password1 = Password1Field.getText();
		            System.out.println(Name);

		            MyAccountControl MA_Ctrl = new MyAccountControl(Username, Password, Password1, Name);
		}

	}
}

public class MyAccountBO extends JFrame
{
    private MyAccountPanel MA_Panel;

    public MyAccountBO( String CustomerName)
    {
	setTitle("My Account");
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
         MA_Panel = new MyAccountPanel(CustomerName);
         contentPane.add(MA_Panel);
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