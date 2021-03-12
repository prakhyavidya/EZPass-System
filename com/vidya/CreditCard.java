package com.vidya;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreditCard {
  private String CardNumber,Name,ExpDate,CVV,CustomerID;
  
  public CreditCard(String CN, String NM, String ED, String CVV, String CID) {
    CardNumber = CN;
    Name = NM;
    ExpDate = ED;
    CVV = CVV;
    CustomerID = CID;
  }
  
  public boolean addCreditCard(String CardNumber, String Name, String Expdate, String CVV) {
    boolean done = false;
    try {
      DBConnection ToDB = new DBConnection();
      Connection DBConn = ToDB.openConn();
      Statement Stmt = DBConn.createStatement();
      String SQL_Command = " INSERT INTO Creditcard(CardNumber,Name,Expdate,CVV) VALUES('"+CardNumber+"','"+Name+"','" +ExpDate+ "','"+CVV+"')";
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
  
  public boolean removeCreditCard() {
    boolean done = false;
    try {
    	DBConnection ToDB = new DBConnection();
        Connection DBConn = ToDB.openConn();
        Statement Stmt = DBConn.createStatement();
      String SQL_Command = " DELETE FROM CreditCard where CardNumber='" + CardNumber + "'";
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
  
  public boolean updateCreditCard(String CardNumber, String Name, String ExpDate, String CVV) {
    boolean done = false;
    try {
    	DBConnection ToDB = new DBConnection();
        Connection DBConn = ToDB.openConn();
        Statement Stmt = DBConn.createStatement();
      String SQL_Command = "Update CreditCard SET CardNumber='"+CardNumber+"',Name='"+Name+"',ExpDate='"+ExpDate+"',CVV='"+CVV+"' where CardNumber='"+CardNumber+"'";
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
