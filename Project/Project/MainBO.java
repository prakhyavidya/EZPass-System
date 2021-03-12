/******************************************************************************
*	Program Author: Srividya Prakhya for Project on EZPass System             *
*																			  *
*******************************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MainBOPanel extends JPanel
{
private String CustomerID, UName, CName, StartDate, EndDate;
public MainBOPanel()
{
tabbedPane = new JTabbedPane();
//TabPanel1 = new CreateprofilePanel(CName);
//TabPanel2 = new AddVehiclePanel(CustomerID);

tabbedPane.addTab("Create Profile", TabPanel1);
tabbedPane.addTab("Add Vehicle", TabPanel2);

add(tabbedPane);
}
private JTabbedPane tabbedPane;
private JPanel TabPanel1, TabPanel2;
}

class MainBO extends JFrame
{
public MainBO()
{
setTitle("EzPass System");
setSize(550, 350);
//get screen size and set the location of the frame
Toolkit tk = Toolkit.getDefaultToolkit();
Dimension d = tk.getScreenSize();
int screenHeight = d.height;
int screenWidth = d.width;
setLocation( screenWidth / 2, screenHeight / 3);

addWindowListener (new WindowAdapter() //handle window closing event
{ public void windowClosing (WindowEvent e)
{ System.exit(0);
}
});
/*
 * JPanel TabPanel = new TabPanel(); Container contentPane = getContentPane();
 * //add a panel to a frame contentPane.add(TabPanel);
 */}

public static void main(String [] args)
{ JFrame frame = new MainBO(); //initialize a JFrame object
frame.setVisible(true);
frame.show(); //display the frame
}
}