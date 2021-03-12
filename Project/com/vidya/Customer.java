package com.vidya;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class Customer {
  private String CustomerID;
  
  private String Name;
  
  private String Street;
  
  private String City;
  
  private String State1;
  
  private String Zip;
  
  private String Phone;
  
  private String Email;
  
  private String Balance;
  
  public Customer(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9) {
    this.CustomerID = paramString1;
    this.Name = paramString2;
    this.Street = paramString3;
    this.City = paramString4;
    this.State1 = paramString5;
    this.Zip = paramString6;
    this.Phone = paramString7;
    this.Email = paramString8;
    this.Balance = paramString9;
  }
  
  public Customer(String paramString1, String paramString2, String paramString3, String paramString4) {
    this.CustomerID = paramString1;
    this.Name = paramString2;
    this.Email = paramString3;
    this.Balance = paramString4;
  }
  
  public String createProfile() {
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
          this.CustomerID = Integer.toString(i);
          System.out.println("Customer ID is :" + this.CustomerID);
          str1 = "INSERT INTO Customer(CustomerID, Name, Street, City, State1, Zip, Phone, Email, Balance) VALUES (" + this.CustomerID + ", '" + this.Name + "','" + this.Street + "','" + this.City + "', '" + this.State1 + "', " + this.Zip + ", " + this.Phone + ", '" + this.Email + "', " + this.Balance + ")";
          statement.executeUpdate(str1);
          str1 = "UPDATE Account Set CustomerID ='" + this.CustomerID + "' WHERE Name = '" + this.Name + "'";
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
  
  public boolean updateAddress(String paramString) {
    boolean bool = false;
    try {
      DBConnection dBConnection = new DBConnection();
      Connection connection = dBConnection.openConn();
      Statement statement = connection.createStatement();
      String str = "SELECT * FROM Customer WHERE CustomerID ='" + this.CustomerID + "'";
      ResultSet resultSet = statement.executeQuery(str);
      if (resultSet.next()) {
        str = "Update Customer SET Street='" + this.Street + "', City='" + this.City + "', State1='" + this.State1 + "', Zip='" + this.Zip + "' where CustomerID='" + this.CustomerID + "'";
        statement.executeUpdate(str);
        statement.close();
        dBConnection.closeConn();
        bool = true;
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
  
  public boolean updatePhone(String paramString) {
    boolean bool = false;
    try {
      DBConnection dBConnection = new DBConnection();
      Connection connection = dBConnection.openConn();
      Statement statement = connection.createStatement();
      String str = "Update Customer SET Phone='" + paramString + "' where CustomerID='" + this.CustomerID + "'";
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
  
  public boolean updateEmail(String paramString) {
    boolean bool = false;
    try {
      DBConnection dBConnection = new DBConnection();
      Connection connection = dBConnection.openConn();
      Statement statement = connection.createStatement();
      String str = "Update Customer SET Email='" + paramString + "' where CustomerID='" + this.CustomerID + "'";
      statement.executeUpdate(str);
      statement.close();
      dBConnection.closeConn();
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
  
  public boolean recharge(float paramFloat) {
    boolean bool = false;
    try {
      DBConnection dBConnection = new DBConnection();
      Connection connection = dBConnection.openConn();
      Statement statement = connection.createStatement();
      String str = "Update Customer SET Balance='" + paramFloat + "' where CustomerID='" + this.CustomerID + "'";
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
