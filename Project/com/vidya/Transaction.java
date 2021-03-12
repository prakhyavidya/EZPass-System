package com.vidya;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class Transaction {
  private String TransactionID;
  
  private String TagCode;
  
  private String TransactionDate;
  
  private String TransactionTime;
  
  private String TollPlaza;
  
  private String CustomerID;
  
  private String TollAmount;
  
  private String TollLaneNumber;
  
  public Transaction(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {
    this.TransactionID = paramString1;
    this.TagCode = paramString2;
    this.TransactionDate = paramString3;
    this.TransactionTime = paramString4;
    this.TollPlaza = paramString5;
    this.CustomerID = paramString6;
    this.TollAmount = paramString7;
    this.TollLaneNumber = paramString8;
  }
  
  public String PayToll() {
    String str = "";
    boolean bool = false;
    try {
      if (!bool) {
        DBConnection dBConnection = new DBConnection();
        Connection connection = dBConnection.openConn();
        Statement statement = connection.createStatement();
        String str1 = "SELECT CustomerID FROM Customer WHERE CustomerID ='" + this.CustomerID + "'";
        ResultSet resultSet = statement.executeQuery(str1);
        bool = !resultSet.next() ? true : false;
        if (bool = !resultSet.next() ? true : false) {
          int i = 10000 + (new Random()).nextInt(90000);
          str = Integer.toString(i);
          System.out.println("Transaction ID is :" + str);
          str1 = "INSERT INTO Transaction(TransactionID,TagCode, TransactionDate,TransactionTime,TollPlaza,CustomerID,TollAmount,TollLaneNumber) VALUES ('" + str + "', '" + this.TagCode + "','" + this.TransactionDate + "','" + this.TransactionTime + "','" + this.TollPlaza + "', '" + this.CustomerID + "','" + this.TollAmount + "','" + this.TollLaneNumber + "'";
          statement.executeUpdate(str1);
          str1 = "UPDATE Transaction Set TransactionID='" + str + "',TagCode='" + this.TagCode + "',TransactionDate'" + this.TransactionDate + "',TransactionTime'" + this.TransactionTime + "',TollPlaza='" + this.TollPlaza + "',CustomerID='" + this.CustomerID + "',TollAmount='" + this.TollAmount + "',TollLaneNumber'" + this.TollLaneNumber + "' WHERE CustomerId = '" + this.CustomerID + "'";
          statement.executeUpdate(str1);
        } 
        statement.close();
        dBConnection.closeConn();
      } 
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
    return this.CustomerID;
  }
  
  public boolean recordTransaction() {
    boolean bool = false;
    try {
      DBConnection dBConnection = new DBConnection();
      Connection connection = dBConnection.openConn();
      Statement statement = connection.createStatement();
      String str = "INSERT INTO [Transaction] VALUES('" + this.TransactionID + "','" + this.TagCode + "','" + this.TransactionDate + "','" + this.TransactionTime + "','" + this.TollPlaza + "','" + this.CustomerID + "','" + this.TollAmount + "','" + this.TollLaneNumber + "')";
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
