package com.vidya;

public class Main {
  public static void main(String[] paramArrayOfString) {
    Account account = new Account("vidya", "12345678", "098765432", "Sri");
    Customer customer = new Customer("102", "vidya", "XXX", "XXXXXXX", "XX", "12335", "1234567890", "vidya@gmail.com", "50");
    Vehicle vehicle = new Vehicle("N23GT5", "Toyato", "EX", "Red", "324.098", "102", 2019);
    EZTag eZTag = new EZTag("876.234", "Standard", "05/12/2016", "102");
    CreditCard creditCard = new CreditCard("9876543210234567", "vidya", "01/2022", "555", "102");
    Transaction transaction = new Transaction("123456", "324.098", "03/12/2019", "12:40", "New York", "102", 50.0F, 3);
    account.signIn();
  }
}
