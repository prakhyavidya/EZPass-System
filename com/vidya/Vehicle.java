package com.vidya;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class Vehicle {
  private String LicensePlateNumber,Make,Model,Colour,TagCode,CustomerID,Year;
  
  public Vehicle(String LPN, String MK, String MD, String CL, String TC, String CID, String YR) {
    LicensePlateNumber = LPN;
    Make = MK;
    Model = MD;
    Colour = CL;
    TagCode = TC;
    CustomerID = CID;
    Year = YR;
  }
  
  public Vehicle(String LPN) {
	    LicensePlateNumber = LPN;
	   
	  }
  public boolean addVehicle() {
	  boolean done = false;
	    try {
	      DBConnection ToDB = new DBConnection();
	      Connection DBConn = ToDB.openConn();
	      Statement Stmt = DBConn.createStatement();
      String SQL_Command = " INSERT INTO Vehicle VALUES('" + LicensePlateNumber + "','" + Make + "','" + Model + "','" + Colour + "','" + TagCode + "','" + CustomerID + "','" + Year + "')";
      Stmt.executeUpdate(SQL_Command);
      Stmt.close();
      ToDB.closeConn();
      done = true;
    }  catch(java.sql.SQLException e)
    {         done = false;
			 System.out.println("SQLException: " + e);
			 while (e != null)
			 {   System.out.println("SQLState: " + e.getSQLState());
				 System.out.println("Message: " + e.getMessage());
				 System.out.println("Vendor: " + e.getErrorCode());
				 e = e.getNextException();
				 System.out.println("");
			 }
    }
    catch (java.lang.Exception e)
    {         done = false;
			 System.out.println("Exception: " + e);
			 e.printStackTrace ();
    } 
    return done;
  }
  
  public boolean removeVehicle() {
	  boolean done = false;
	    try {
	      DBConnection ToDB = new DBConnection();
	      Connection DBConn = ToDB.openConn();
	      Statement Stmt = DBConn.createStatement();
      String SQL_Command = " DELETE FROM Vehicle where LicensePlateNumber='" + LicensePlateNumber + "'";
      Stmt.executeUpdate(SQL_Command);
      System.out.println(SQL_Command );
      Stmt.close();
      ToDB.closeConn();
      done = true;
    }  catch(java.sql.SQLException e)
    {         done = false;
			 System.out.println("SQLException: " + e);
			 while (e != null)
			 {   System.out.println("SQLState: " + e.getSQLState());
				 System.out.println("Message: " + e.getMessage());
				 System.out.println("Vendor: " + e.getErrorCode());
				 e = e.getNextException();
				 System.out.println("");
			 }
    }
    catch (java.lang.Exception e)
    {         done = false;
			 System.out.println("Exception: " + e);
			 e.printStackTrace ();
    } 
    return done;
  }
  
  
  public boolean searchVehicle(String LicensePlateNumber, String StateName) {
	  
	    boolean done = false;
	    
	    try {
	    	DBConnection ToDB = new DBConnection();
	        Connection DBConn = ToDB.openConn();
	        Statement Stmt = DBConn.createStatement();
	      String SQL_Command = "SELECT * FROM Vehicle WHERE LicensePlateNumber='"+LicensePlateNumber+"' AND StateName='"+StateName+"'";
	      ResultSet Rslt = Stmt.executeQuery(SQL_Command);
	   // It creates and displays the table
	      JTable table = new JTable(buildTableModel(Rslt));

	      // Closes the Connection

	      JOptionPane.showMessageDialog(null, new JScrollPane(table));
	      Stmt.close();
	      ToDB.closeConn();
	      done = true;
	    }  catch(java.sql.SQLException e)
	    {         done = false;
				 System.out.println("SQLException: " + e);
				 while (e != null)
				 {   System.out.println("SQLState: " + e.getSQLState());
					 System.out.println("Message: " + e.getMessage());
					 System.out.println("Vendor: " + e.getErrorCode());
					 e = e.getNextException();
					 System.out.println("");
				 }
	    }
	    catch (java.lang.Exception e)
	    {         done = false;
				 System.out.println("Exception: " + e);
				 e.printStackTrace ();
	    } 
	    return done;
	  }

private TableModel buildTableModel(ResultSet rslt) {
	// TODO Auto-generated method stub
	return null;
}
}
