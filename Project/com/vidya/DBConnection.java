package com.vidya;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class DBConnection {
  private String URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=JavaClass;integratedSecurity=true;";
  
  private Connection connection = null;
  
  public Connection openConn() {
    try {
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      this.connection = DriverManager.getConnection(this.URL);
    } catch (Exception exception) {
      exception.printStackTrace();
      this.connection = null;
    } 
    return this.connection;
  }
  
  public void closeConn() {
    try {
      this.connection.close();
    } catch (Exception exception) {
      System.err.println("Can't close the database connection.");
    } 
  }
  
  public Vector getNextRow(ResultSet paramResultSet, ResultSetMetaData paramResultSetMetaData) throws SQLException {
    Vector<String> vector = new Vector();
    for (byte b = 1; b <= paramResultSetMetaData.getColumnCount(); b++) {
      switch (paramResultSetMetaData.getColumnType(b)) {
        case -9:
        case -1:
        case 12:
          vector.addElement(paramResultSet.getString(b));
          break;
        case 4:
          vector.addElement(new Long(paramResultSet.getLong(b)));
          break;
        case 8:
          vector.addElement(new Double(paramResultSet.getDouble(b)));
          break;
        case 6:
          vector.addElement(new Float(paramResultSet.getFloat(b)));
          break;
        default:
          System.out.println("Type was: " + paramResultSetMetaData.getColumnTypeName(b));
          break;
      } 
    } 
    return vector;
  }
}
