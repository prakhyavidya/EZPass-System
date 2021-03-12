package com.vidya;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Account {
  private String CustomerID,Username,Password,Password1,Name;
  private String LastLogin = "";
  private int ThreeConsecutiveFailures;

  public Account(String UN, String Pass, String Pass1, String NM) {
    this.Username = UN;
    this.Password = Pass;
    this.Password1 = Pass1;
    this.Name = NM;
  }

  public Account(String UN, String Pass ){
    this.Username = UN;
    this.Password = Pass;
    System.out.println("Name +" + Name);
  }
  public Account(String UN, String Pass, String Npswd ){
	    this.Username = UN;
	    this.Password = Pass;
	    this.Password1=Npswd;
	  }

  public String SignIn() {
	  System.out.println("User Name is +" + Username);
	   System.out.println("Password is +" + Password);
   String UName="";

      boolean done = !Username.equals("") && !Password.equals("");
      
           try{
				 if(done){
			       DBConnection ToDB = new DBConnection();
			       Connection DBConn = ToDB.openConn();
			       Statement Stmt = DBConn.createStatement();
			       String SQL_Query = "SELECT top 1 * FROM Account WHERE Username ='"+Username+"' AND Password= '"+Password+"'";

				   ResultSet Rslt = Stmt.executeQuery(SQL_Query);
				   while (Rslt.next()) 
				    UName=Rslt.getString("Name");
				   System.out.println("Name +" + UName);
				   Stmt.close();
                 ToDB.closeConn();
			   }
      }
catch (java.lang.Exception e)
	    {
				 System.out.println("Exception: " + e);
				 e.printStackTrace ();
	    }


    return UName;

}

  public boolean signUp() {
	  System.out.println("Request for Customer test Ashok");
		boolean done = !Username.equals("") && !Password.equals("") && !Password1.equals("") && Password.equals(Password1);
		try {
		    if (done) {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT Username FROM Account WHERE Username ='"+Username+"'"; //SQL query command
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		        done = done && !Rslt.next();
		        if (done) {
				    SQL_Command = "INSERT INTO Account(Username, Password, Name) VALUES ('"+Username+ "','"+Password+"','"+Name+"')"; //Save the username, password and Name
				    Stmt.executeUpdate(SQL_Command);
			    }
			    Stmt.close();
			    ToDB.closeConn();
			}
		}
	    catch(java.sql.SQLException e)
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

  public boolean changePassword() {	//5
		boolean done = false;
		try {		//20
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT * FROM Account WHERE Username ='"+Username+ "'AND Password ='"+Password+"'";
		        System.out.println(SQL_Command );//SQL query command
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		        if (Rslt.next()) {
				    SQL_Command = "UPDATE Account SET Password='"+Password1+"' WHERE Username ='"+Username+"'"; //Save the username, password and Name
				    Stmt.executeUpdate(SQL_Command);
				    System.out.println(SQL_Command );
			        Stmt.close();
			        ToDB.closeConn();
                  done=true;
				}
		}
	    catch(java.sql.SQLException e)		//5
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
