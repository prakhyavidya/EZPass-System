package com.vidya;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Transaction {
  private String TransactionID,TagCode,TransactionDate,TransactionTime,TollPlaza,CustomerID,TollAmount,TollLaneNumber;
  
  public Transaction(String TID, String TC, String TRD, String TRT, String TP, String CID, String TA, String TLN) {
    TransactionID = TID;
    TagCode = TC;
    TransactionDate = TRD;
    TransactionTime = TRT;
    TollPlaza = TP;
    CustomerID = CID;
    TollAmount = TA;
    TollLaneNumber = TLN;
  }
  
  public Transaction(String TRD,String CID) {
	  TransactionDate = TRD;
	 CustomerID = CID;
	
  }
  
  
  public String PayToll() {
	  System.out.println("Request for Customer " + CustomerID );
	  String TransactionID = "";
	    boolean done = false;
	    try {
	    	 if (!done) {
			        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
			        Connection DBConn = ToDB.openConn();
			        Statement Stmt = DBConn.createStatement();
        String SQL_Command = "SELECT CustomerID FROM Customer WHERE CustomerID ='" +CustomerID + "'";
        ResultSet Rslt = Stmt.executeQuery(SQL_Command);
       
       // done = !Rslt.next();
        done=true;
			//
			//String SQL_Command = "SELECT CustomerID FROM Customer WHERE CustomerID ='"+CustomerID+"'"; //SQL query command
     if (done) {
    	 System.out.println("entered if loop of done" );
		 int Trans_ID = (10000 + new Random().nextInt(90000));
		 TransactionID = Integer.toString(Trans_ID);
          System.out.println("Transaction ID is :" +TransactionID);
          SQL_Command = "INSERT INTO [Transaction](TransactionID,TagCode, TransactionDate,TransactionTime,TollPlaza,CustomerID,TollAmount,TollLaneNumber) VALUES ('" + TransactionID + "', '" +TagCode + "','" +TransactionDate + "','" +TransactionTime + "','" +TollPlaza + "', '" +CustomerID + "','" +TollAmount + "','" +TollLaneNumber + "')";
          Stmt.executeUpdate(SQL_Command);
          System.out.println(SQL_Command );
          System.out.println("after insert" + TransactionID );
          SQL_Command = "UPDATE [Transaction] Set TransactionID='" + TransactionID + "',TagCode='" +TagCode + "',TransactionDate'" +TransactionDate + "',TransactionTime'" +TransactionTime + "',TollPlaza='" +TollPlaza + "',CustomerID='" +CustomerID + "',TollAmount='" +TollAmount + "',TollLaneNumber'" +TollLaneNumber + "' WHERE CustomerId = '" +CustomerID + "'";
          Stmt.executeUpdate(SQL_Command);
        } 
     Stmt.close();
	    ToDB.closeConn();

	}
}
catch(java.sql.SQLException e)
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
return TransactionID;
  }
  
  public boolean inquireTransaction(String TransactionDate) {
	  
	    boolean done = false;
	    
	    try {
	    	DBConnection ToDB = new DBConnection();
	        Connection DBConn = ToDB.openConn();
	        Statement Stmt = DBConn.createStatement();
	      String SQL_Command = "SELECT * FROM [Transaction] WHERE CustomerID='"+CustomerID+"' AND TransactionDate='"+TransactionDate+"'";
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
  
  private TableModel buildTableModel(ResultSet rslt) throws SQLException {
	
	  ResultSetMetaData metaData = rslt.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rslt.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rslt.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

}

public boolean recordTransaction() {
    boolean done = false;
    try {
    	DBConnection ToDB = new DBConnection();
        Connection DBConn = ToDB.openConn();
        Statement Stmt = DBConn.createStatement();
      String SQL_Command = "INSERT INTO [Transaction] VALUES('" +TransactionID + "','" +TagCode + "','" + TransactionDate + "','"+TransactionTime + "','" +TollPlaza + "','" +CustomerID + "','" +TollAmount + "','" + TollLaneNumber + "')";
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
}
