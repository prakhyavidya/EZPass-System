package com.vidya;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Vehicle {
  private String LicensePlateNumber;
  
  private String Make;
  
  private String Model;
  
  private String Colour;
  
  private String TagCode;
  
  private String CustomerID;
  
  private String Year;
  
  public Vehicle(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
    this.LicensePlateNumber = paramString1;
    this.Make = paramString2;
    this.Model = paramString3;
    this.Colour = paramString4;
    this.TagCode = paramString5;
    this.CustomerID = paramString6;
    this.Year = paramString7;
  }
  
  public boolean addVehicle(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt) {
    boolean bool = false;
    try {
      DBConnection dBConnection = new DBConnection();
      Connection connection = dBConnection.openConn();
      Statement statement = connection.createStatement();
      String str = " INSERT INTO Vehicle VALUES('" + paramString1 + "','" + paramString2 + "','" + paramString3 + "','" + paramString4 + "','" + paramString5 + "','" + paramString6 + "','" + paramInt + "')";
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
  
  public boolean removeVehicle(String paramString) {
    boolean bool = false;
    try {
      DBConnection dBConnection = new DBConnection();
      Connection connection = dBConnection.openConn();
      Statement statement = connection.createStatement();
      String str = " DELETE FROM Vehicle where LicensePlateNumber='" + paramString + "'";
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
