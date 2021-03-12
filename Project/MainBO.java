/******************************************************************************
*	Program Author: Srividya Prakhya for Project on EZPass System             *
*																			  *
*******************************************************************************/
package Project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.vidya.*;

class TabPanel extends JPanel {
	private String CustomerID, CustomerName;

	public TabPanel(String CustomerID, String CustomerName) {
		JFrame f = new JFrame();
		// MainBOPanel(){
//		f = new JFrame();
		f.setTitle("EZPass System");

		tabPanel_1 = new CreateProfilePanel(CustomerID, CustomerName);
		tabPanel_2 = new PayTollPanel();
		tabPanel_3 = new EZTagPanel();
		tabPanel_4 = new VehiclePanel();
		tabPanel_5 = new InquireTransactionPanel();
		tabbedPane = new JTabbedPane(); // initialize a JTabbedPane object
		tabbedPane.setBounds(50, 50, 500, 500);
		tabbedPane.add("Create Profile", tabPanel_1); // add GUI components to Tabbed Pane
		// tabbedPane.setSelectedIndex(0);
		tabbedPane.add("Pay Toll", tabPanel_2);
		tabbedPane.add(" EZTag", tabPanel_3);
		tabbedPane.add("Vehicle", tabPanel_4);
		tabbedPane.add("Transactions", tabPanel_5);
		f.add(tabbedPane);
		f.setSize(750, 750);
		f.setLayout(null);
		f.setVisible(true);

//      add(tabbedPane);
	}

	private JTabbedPane tabbedPane;
	private JPanel tabPanel_1, tabPanel_2, tabPanel_3, tabPanel_4, tabPanel_5;

}

public class MainBO extends JFrame {
	private TabPanel EZTabPanel;

	public MainBO(String CustomerID, String CustomerName) {
//				setTitle("EZPass System");
//		        setSize(1000, 768);

		// get screen size and set the location of the frame
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int screenHeight = d.height;
		int screenWidth = d.width;
		setLocation(screenWidth / 4, screenHeight / 4);

		addWindowListener(new WindowAdapter() // handle window event
		{
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		Container contentPane = getContentPane(); // add a panel to a frame
		JPanel EZTabPanel = new TabPanel(CustomerID, CustomerName);
		contentPane.add(EZTabPanel);
		show();
	}

	public static void main(String[] args) {

//		JFrame frame = new MainBO("CustomerID", "CustomerName"); // initialize a JFrame object
		JFrame frame = new LoginBO(); //initialize a JFrame object
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			 	frame.setVisible(true);
//        frame.show(); //display the frame
	}

}