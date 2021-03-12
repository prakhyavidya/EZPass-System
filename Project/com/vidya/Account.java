package com.vidya;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Account {
  private String Username;

  private String Password;

  private String Password1;

  private String Name;

  private String LastLogin = "";

  private int ThreeConsecutiveFailures;

  public Account(String Username, String Password, String Password1, String Name) {
    this.Username = Username;
    this.Password = Password;
    this.Password1 = Password1;
    this.Name = Name;
  }

  public Account(String Username, String Password ){
    this.Username = Username;
    this.Password = Password;
    System.out.println("Name +" + this.Name);
  }

  public Account() {
    System.out.println("hi");
  }

  public String signIn() {
    boolean done = (!this.Username.equals("") && !this.Password.equals("")) ? true : false;
    String str = "";
    try {
      if (done) {
        DBConnection dBConnection = new DBConnection();
        Connection connection = dBConnection.openConn();
        Statement statement = connection.createStatement();
        String str1 = "SELECT Name FROM Account WHERE Username ='" + this.Username + "' AND Password= '" + this.Password + "'";
        ResultSet resultSet = statement.executeQuery(str1);
        while (resultSet.next())
          str = resultSet.getString(1);
        statement.close();
        dBConnection.closeConn();
      }
    } catch (Exception exception) {
      System.out.println("Exception: " + exception);
      exception.printStackTrace();
    }
    return str;
  }

  public boolean signUp() {
    boolean bool = (!this.Username.equals("") && !this.Password.equals("") && !this.Password1.equals("") && this.Password.equals(this.Password1)) ? true : false;
    try {
      if (bool) {
        DBConnection dBConnection = new DBConnection();
        Connection connection = dBConnection.openConn();
        Statement statement = connection.createStatement();
        String str = "SELECT Username FROM Account WHERE Username ='" + this.Username + "'";
        ResultSet resultSet = statement.executeQuery(str);
        bool = (bool && !resultSet.next()) ? true : false;
        if (bool) {
          str = "INSERT INTO Account(Username, Password, Name) VALUES ('" + this.Username + "','" + this.Password + "','" + this.Name + "')";
          statement.executeUpdate(str);
          statement.close();
          dBConnection.closeConn();
        }
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

  public boolean changePassword(String Password) {
    boolean bool = false;
    try {
      DBConnection dBConnection = new DBConnection();
      Connection connection = dBConnection.openConn();
      Statement statement = connection.createStatement();
      String str = "SELECT * FROM Account WHERE Username ='" + this.Username + "'AND Password ='" + this.Password + "'";
      ResultSet resultSet = statement.executeQuery(str);
      if (resultSet.next()) {
        str = "UPDATE Account SET Password='" + paramString + "' WHERE Username ='" + this.Username + "'";
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
}
