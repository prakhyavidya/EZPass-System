package com.vidya;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckingAccount {
  private String CheckingAccountNumber;

  private String CustomerName;

  private String CustomerID;

  private float Balance = -1.0F;

  public CheckingAccount(String paramString1, String paramString2, String paramString3, String paramString4) {
    this.CheckingAccountNumber = paramString1;
    this.CustomerName = paramString2;
    this.CustomerID = paramString3;
    this.Balance = Float.parseFloat(paramString4);
  }

  public CheckingAccount(String paramString) {
    this.CheckingAccountNumber = paramString;
  }

  public boolean openAcct() {
    boolean bool = false;
    try {
      if (!bool) {
        DBConnection dBConnection = new DBConnection();
        Connection connection = dBConnection.openConn();
        Statement statement = connection.createStatement();
        String str = "SELECT CheckingAccountNumber FROM CheckingAccount WHERE CheckingAccountNumber ='" + this.CheckingAccountNumber + "'";
        ResultSet resultSet = statement.executeQuery(str);
        bool = !resultSet.next() ? true : false;
        if (bool) {
          str = "INSERT INTO CheckingAccount(CheckingAccountNumber, CustomerName, Balance, CustomerID) VALUES ('" + this.CheckingAccountNumber + "','" + this.CustomerName + "'," + this.Balance + ", '" + this.CustomerID + "')";
          statement.executeUpdate(str);
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
    return bool;
  }

  public float getBalance() {
    try {
      DBConnection dBConnection = new DBConnection();
      Connection connection = dBConnection.openConn();
      Statement statement = connection.createStatement();
      String str = "SELECT Balance FROM CheckingAccount WHERE CheckingAccountNumber ='" + this.CheckingAccountNumber + "'";
      ResultSet resultSet = statement.executeQuery(str);
      while (resultSet.next())
        this.Balance = resultSet.getFloat(1);
      statement.close();
      dBConnection.closeConn();
    } catch (SQLException sQLException) {
      System.out.println("SQLException: " + sQLException);
      while (sQLException != null) {
        System.out.println("SQLState: " + sQLException.getSQLState());
        System.out.println("Message: " + sQLException.getMessage());
        System.out.println("Vendor: " + sQLException.getErrorCode());
        sQLException = sQLException.getNextException();
        System.out.println("");
      }
    } catch (Exception exception) {
      System.out.println("Exception: " + exception);
      exception.printStackTrace();
    }
    return this.Balance;
  }

  public float getBalance(String paramString) {
    try {
      DBConnection dBConnection = new DBConnection();
      Connection connection = dBConnection.openConn();
      Statement statement = connection.createStatement();
      String str = "SELECT Balance FROM CheckingAccount WHERE CheckingAccountNumber ='" + paramString + "'";
      ResultSet resultSet = statement.executeQuery(str);
      while (resultSet.next())
        this.Balance = resultSet.getFloat(1);
      statement.close();
      dBConnection.closeConn();
    } catch (SQLException sQLException) {
      System.out.println("SQLException: " + sQLException);
      while (sQLException != null) {
        System.out.println("SQLState: " + sQLException.getSQLState());
        System.out.println("Message: " + sQLException.getMessage());
        System.out.println("Vendor: " + sQLException.getErrorCode());
        sQLException = sQLException.getNextException();
        System.out.println("");
      }
    } catch (Exception exception) {
      System.out.println("Exception: " + exception);
      exception.printStackTrace();
    }
    return this.Balance;
  }
}
