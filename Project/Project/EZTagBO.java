/******************************************************************************
*	Program Author: Srividya Prakhya for Project on EZPass System             *
*																			  *
*******************************************************************************/

import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;


class EZTagPanel extends JPanel implements ActionListener
{
    private JButton CreateButton,CancelButton;
    private JTextField TagCodeField, TagTypeField, IssueDateField, CustomerIDField;
	private String TagCode, TagType, IssueDate, CustomerID;


    public EZTagPanel()
    {
        CreateButton = new JButton("Create");
        //CancelButton = new JButton("cancel");

        //CreateProfileBox.addItem("Create Profile");

        TagCodeField = new JTextField(15);
        TagCodeField.setText(TagCode);
		TagTypeField = new JTextField(15);
		TagTypeField.setText(TagType);
		IssueDateField = new JTextField(15);
		IssueDateField.setText(IssueDate);
        CustomerIDField = new JTextField(15);



        JLabel TagCodeLabel = new JLabel("TagCode:");
        JLabel TagTypeLabel = new JLabel("TagType:");
        JLabel IssueDateLabel = new JLabel("IssueDate:");
        JLabel CustomerLabel = new JLabel("CustomerID:");

		CreateButton.setActionCommand("Create");
		CreateButton.addActionListener(this);
		//CancelButton.addActionListener(this);


        JPanel TypePanel = new JPanel();
        JPanel CustomerIDPanel = new JPanel();
        JPanel TagCodePanel = new JPanel();
        JPanel TagTypePanel = new JPanel();
        JPanel IssueDatePanel = new JPanel();

        CustomerIDPanel.add(CustomerLabel);
        CustomerIDPanel.add(CustomerIDField);
        TagCodePanel.add(TagCodeLabel);
        TagCodePanel.add(TagCodeField);
        TagTypePanel.add(TagTypeLabel);
        TagTypePanel.add(TagTypeField);
        IssueDatePanel.add(IssueDateLabel);
        IssueDatePanel.add(IssueDateField);


        //CreateButton.addActionListener(this); //event listener registration

        //JPanel TopPanel = new JPanel();
        //TopPanel.add(TypePanel);
        //TopPanel.add(NamePanel);

        JPanel CenterPanel = new JPanel();
        CenterPanel.add(CustomerIDPanel);
        CenterPanel.add(TagCodePanel);
        CenterPanel.add(TagTypePanel);
        CenterPanel.add(IssueDatePanel);
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
        			String CustomerID = CustomerIDField.getText();
		            String TagCode = TagCodeField.getText(); //take actions
		            String TagType = TagTypeField.getText();
		            String IssueDate = IssueDateField.getText();
		            //System.out.println(Name);

		            EZTagControl ET_Ctrl = new EZTagControl(TagCode, TagType, IssueDate, CustomerID);
		}

	}
}

public class EZTagBO extends JFrame
{
    private EZTagPanel ET_Panel;

    public EZTagBO()
    {
        setTitle("EZTag");
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
         ET_Panel = new EZTagPanel();
         contentPane.add(ET_Panel);
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