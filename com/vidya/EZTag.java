package com.vidya;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class EZTag {
  private String TagCode,TagType,IssueDate,CustomerID;
  
  public EZTag(String TC, String TT, String ID, String CID) {
    TagCode = TC;
    TagType = TT;
    IssueDate = ID;
    CustomerID = CID;
  }
  public EZTag(String TC) {
	    TagCode = TC;
	   
	  }
	  
  
  public String addTag() {
	  String customerID="";
	  boolean done = false;
    try {
    	 DBConnection ToDB = new DBConnection(); //Have a connection to the DB
	        Connection DBConn = ToDB.openConn();
	        Statement Stmt = DBConn.createStatement();
      String SQL_Command = " INSERT INTO EZTag(TagCode,TagType,IssueDate,CustomerID) VALUES('"+TagCode+"','"+TagType+"','"+IssueDate+"','"+CustomerID+"')";
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
    return CustomerID;
  }
  
  public boolean removeTag() {
    boolean done = false;
    try {
    	DBConnection ToDB = new DBConnection();
        Connection DBConn = ToDB.openConn();
        Statement Stmt = DBConn.createStatement();
      String SQL_Command = " DELETE FROM EZTag where TagCode='" + TagCode + "'";
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
}
