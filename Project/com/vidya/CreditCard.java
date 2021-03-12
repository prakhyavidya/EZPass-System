package com.vidya;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreditCard {
  private String CardNumber;
  
  private String Name;
  
  private String ExpDate;
  
  private String CVV;
  
  private String CustomerID;
  
  public CreditCard(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    this.CardNumber = paramString1;
    this.Name = paramString2;
    this.ExpDate = paramString3;
    paramString4 = paramString4;
    this.CustomerID = paramString5;
  }
  
  public boolean addCreditCard(String paramString1, String paramString2, String paramString3, String paramString4) {
    boolean bool = false;
    try {
      DBConnection dBConnection = new DBConnection();
      Connection connection = dBConnection.openConn();
      Statement statement = connection.createStatement();
      String str = " INSERT INTO Creditcard VALUES('" + paramString1 + "','" + paramString2 + "','" + paramString3 + "','" + paramString4 + "')";
      statement.executeUpdate(str);
      statement.close();
      dBConnection.closeConn();
      bool = true;
    } catch (SQLException sQLException) {
      bool = false;
      System.out.println("SQLException: " + sQLException);
      while (sQLException != null) {
        System.out.println("SQLState: " + sQLException.getSQLState());
        System.out.println("Message: " + sQLException.getMessage());
        System.out.println("Vendor: " + sQLException.getErrorCode());
        sQLException = sQLException.getNextException();
        System.out.println("");
      } 
    } catch (Exception exception) {
      bool = false;
      System.out.println("Exception: " + exception);
      exception.printStackTrace();
    } 
    return bool;
  }
  
  public boolean removeCreditCard(String paramString) {
    boolean bool = false;
    try {
      DBConnection dBConnection = new DBConnection();
      Connection connection = dBConnection.openConn();
      Statement statement = connection.createStatement();
      String str = " DELETE FROM CreditCard where CardNumber='" + paramString + "'";
      statement.executeUpdate(str);
      statement.close();
      dBConnection.closeConn();
      bool = true;
    } catch (SQLException sQLException) {
      bool = false;
      System.out.println("SQLException: " + sQLException);
      while (sQLException != null) {
        System.out.println("SQLState: " + sQLException.getSQLState());
        System.out.println("Message: " + sQLException.getMessage());
        System.out.println("Vendor: " + sQLException.getErrorCode());
        sQLException = sQLException.getNextException();
        System.out.println("");
      } 
    } catch (Exception exception) {
      bool = false;
      System.out.println("Exception: " + exception);
      exception.printStackTrace();
    } 
    return bool;
  }
  
  public boolean updateCreditCard(String paramString1, String paramString2, String paramString3, String paramString4) {
    boolean bool = false;
    try {
      DBConnection dBConnection = new DBConnection();
      Connection connection = dBConnection.openConn();
      Statement statement = connection.createStatement();
      String str = "Update CreditCard SET CardNumber='" + this.CardNumber + "',Name='" + paramString2 + "',ExpDate='" + paramString3 + "',CVV='" + paramString4 + "' where CardNumber='" + this.CardNumber + "'";
      statement.executeUpdate(str);
      statement.close();
      dBConnection.closeConn();
      bool = true;
    } catch (SQLException sQLException) {
      bool = false;
      System.out.println("SQLException: " + sQLException);
      while (sQLException != null) {
        System.out.println("SQLState: " + sQLException.getSQLState());
        System.out.println("Message: " + sQLException.getMessage());
        System.out.println("Vendor: " + sQLException.getErrorCode());
        sQLException = sQLException.getNextException();
        System.out.println("");
      } 
    } catch (Exception exception) {
      bool = false;
      System.out.println("Exception: " + exception);
      exception.printStackTrace();
    } 
    return bool;
  }
}
