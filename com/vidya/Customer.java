package com.vidya;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class Customer {
  private String CustomerID, Name,Street,City,State1, Zip,Phone,Email,Balance;
  private String CreditCardNumber;
  
  public Customer (String CID,String NM, String STR, String CT, String ST, String ZP, String PH, String EM, String BAL){
	  		CustomerID = CID;
			Name = NM;
			Street = STR;
			City = CT;
			State1 = ST;
			Zip = ZP;
			Phone = PH;
			Email = EM;
			Balance = BAL;
  }
  
  public Customer(String CID,String NM,String EM,String BAL) {
	  	CustomerID = CID;
		Name = NM;
		Email = EM;
		Balance = BAL;
  }
  
  public Customer(String CC,String BAL, String CID) {
	  CreditCardNumber = CC;
		Balance = BAL;
		CustomerID = CID;
}
  
  public String createProfile() {
	  System.out.println("Request for Customer " + CustomerID );
    String CustomerID = "";
    boolean done = false;
    try {
    	 if (!done) {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT Name FROM Customer WHERE Name ='"+Name+"'"; //SQL query command
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command);
		        done = !Rslt.next();
					//
					//String SQL_Command = "SELECT CustomerID FROM Customer WHERE CustomerID ='"+CustomerID+"'"; //SQL query command
		     if (done) {

				 int Cust_ID = (10000 + new Random().nextInt(90000));
				 CustomerID = Integer.toString(Cust_ID);
			     System.out.println("CustomerID is " +CustomerID);
			     SQL_Command = "INSERT INTO Customer(CustomerID, Name, Street, City, State1, Zip, Phone, Email, Balance) VALUES ('"+CustomerID+"', '"+Name+ "','"+Street+"','"+City+"', '"+State1+"', '"+Zip+"', '"+Phone+"', '"+Email+"', '"+Balance+"')"; //Save the values
              Stmt.executeUpdate(SQL_Command);
              SQL_Command = "UPDATE Account Set CustomerID ='"+CustomerID+"' WHERE Name = '"+Name+"'";
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
return CustomerID;
  }
  
  public boolean UpdateAddress(String UpdateAddress){
		boolean done = false;
		try {
			        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
			        Connection DBConn = ToDB.openConn();
			        Statement Stmt = DBConn.createStatement();
			        String SQL_Command = "SELECT * FROM Customer WHERE CustomerID ='"+CustomerID+"'"; //SQL query command
			        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
			        if (Rslt.next()) {

					    SQL_Command = "UPDATE Customer SET Street='"+Street+"', City='"+City+"', State='"+State1+"', Zip='"+Zip+"' WHERE CustomerID ='"+CustomerID+"'";
					    Stmt.executeUpdate(SQL_Command);
				        Stmt.close();
				        ToDB.closeConn();
	                    done=true;
					}
			}
		    catch(java.sql.SQLException e){
				done = false;
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
  
  public boolean UpdatePhone(String UpdatePhone){
		boolean done = false;
		try {
			        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
			        Connection DBConn = ToDB.openConn();
			        Statement Stmt = DBConn.createStatement();
			        String SQL_Command = "SELECT * FROM Customer WHERE CustomerID ='"+CustomerID+"'"; //SQL query command
			        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
			        if (Rslt.next()) {

					    SQL_Command = "UPDATE Customer SET Phone='"+Phone+"' WHERE CustomerID ='"+CustomerID+"'";
					    Stmt.executeUpdate(SQL_Command);
				        Stmt.close();
				        ToDB.closeConn();
	                    done=true;
					}
			}
		    catch(java.sql.SQLException e){
				done = false;
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
  
  public boolean UpdateEmail(String UpdateEmail){
		boolean done = false;
		try {
			        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
			        Connection DBConn = ToDB.openConn();
			        Statement Stmt = DBConn.createStatement();
			        String SQL_Command = "SELECT * FROM Customer WHERE Email ='"+UpdateEmail+"'"; //SQL query command
			        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
			        if (Rslt.next()) {

					    SQL_Command = "UPDATE Customer SET Email='"+Email+"' WHERE CustomerID ='"+CustomerID+"'";
					    Stmt.executeUpdate(SQL_Command);
				        Stmt.close();
				        ToDB.closeConn();
	                    done=true;
					}
			}
		    catch(java.sql.SQLException e){
				done = false;
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

  
  public boolean recharge(){
		boolean done = false;
		try {
			        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
			        Connection DBConn = ToDB.openConn();
			        Statement Stmt = DBConn.createStatement();
			        String SQL_Command = "SELECT * FROM CreditCard WHERE CardNumber  ='"+CreditCardNumber+"'"; //SQL query command
			        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits
			        System.out.println(SQL_Command );
			        if (Rslt.next()) {

					    SQL_Command = "UPDATE Customer SET Balance='"+Balance+"' WHERE CustomerID ='"+CustomerID+"'";
					    Stmt.executeUpdate(SQL_Command);
					    System.out.println(SQL_Command );
				        Stmt.close();
				        ToDB.closeConn();
	                    done=true;
					}
			}
		    catch(java.sql.SQLException e){
				done = false;
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
