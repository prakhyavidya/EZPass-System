package com.vidya;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class EZTag {
  private String TagCode;
  
  private String TagType;
  
  private String IssueDate;
  
  private String CustomerID;
  
  public EZTag(String paramString1, String paramString2, String paramString3, String paramString4) {
    this.TagCode = paramString1;
    this.TagType = paramString2;
    this.IssueDate = paramString3;
    this.CustomerID = paramString4;
  }
  
  public boolean addTag(String paramString1, String paramString2, String paramString3, String paramString4) {
    boolean bool = false;
    try {
      DBConnection dBConnection = new DBConnection();
      Connection connection = dBConnection.openConn();
      Statement statement = connection.createStatement();
      String str = " INSERT INTO EZTag VALUES('" + paramString1 + "','" + paramString2 + "','" + paramString3 + "','" + paramString4 + "')";
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
  
  public boolean removeTag(String paramString) {
    boolean bool = false;
    try {
      DBConnection dBConnection = new DBConnection();
      Connection connection = dBConnection.openConn();
      Statement statement = connection.createStatement();
      String str = " DELETE FROM EZTag where tagCode='" + paramString + "'";
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
