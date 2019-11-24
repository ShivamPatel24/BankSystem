 //@author Shivam Patel

package coe528.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BankAccount extends Customer {
    // Overview: BankAccount is mutable. BankAccount is responsible for handling
    // all data changes for each customer.     
    //
    // The abstraction function is:
    // a) AF(c) = An array of type BankAccount, c, representing a customer account,
    //            Abstraction Function: c.get(i) for all i between 0 and c.Size()
    //
    //            c.adjustState() adjust the status of c according
    //            to the current balance, c.deposit(double amount) deposits the
    //            value of amount from c, c.withdraw(double amount) withdraws
    //            the amount from c, c.onlinePurchase(double cost)
    //            purchases an online product and deducts the appropriate cost+fee
    //            from c, c(String username, String password) initilizies the 
    //            customer account information, c.getState() returns the 
    //            string representation of the currentState
    //
    //
    // The rep invariant is: 
    // b)The balance of Customer must be greater than 0 and all username 
    //   in the array must be unique

    //the rep    
    public static ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
      
    protected static DecimalFormat df = new DecimalFormat("0.00");
    private Double balance = 0.0;
    public State currentState;
    
    //constructor 
    BankAccount(String username, String password, Double balance){
        super(username, password);
        this.balance = balance;
        currentState = new SilverState();
        writeBankFile(username,password,balance);
    }
                   
    public static void initlizeArrayList(){
        // MODIFIES: this
        // EFFECTS:  initlizes accounts to be used throughout program
        //REQUIRES: N/A
        File folder = new File("C:\\Users\\Shivam Patel\\Documents\\University Files\\Semester 1.Year 3\\Object Oriented Eng Analysis and Design\\project\\project");
        File[] listOfFiles = folder.listFiles();
        String content = null;
        for (int i = 0; i < listOfFiles.length; i++) {
            File fileName = listOfFiles[i];
            if (fileName.isFile() && fileName.getName().endsWith(".txt")) {
                 try {
                     content = new String(Files.readAllBytes(Paths.get(fileName.getName())));
                     String[] lines = content.split("\\r?\\n");
                      BankAccount readAccount = new BankAccount(lines[0],lines[1],Double.parseDouble(lines[2]));
                      accounts.add(readAccount);
                    } 
                    catch (IOException e) {}
            } 
        }  
    }
    
    public void writeBankFile(String username, String password, Double balance)
    {
        // MODIFIES: N/A
        // EFFECTS:  creats a customer text file to save their information 
        //REQUIRES: N/A   
        String fileName = username + ".txt";
        try (PrintWriter writer = new PrintWriter(fileName, "UTF-8")) {
            writer.println(username);
            writer.println(password);
            writer.println(Double.toString(balance));
        }  
        catch (UnsupportedEncodingException | FileNotFoundException e){}
    }
            
    
    public Double onlinePurchase(double cost){
        // MODIFIES: this
        // EFFECTS: deducts the appropriate cost and fee from the customer's 
        // account for an online purchase
        //REQUIRES: N/A
        return currentState.onlinePurchase(this, cost);
    }
      
    protected void adjustState(){
        // MODIFIES: this
        // EFFECTS: changes the currentState to appropriate state
        //REQUIRES: N/A
         currentState.Silver(this);
         currentState.Gold(this);
         currentState.Platinum(this);
    }
    
    public String getState(){
        // MODIFIES: N/A
        // EFFECTS: returns String of currentState
        //REQUIRES: N/A
        return currentState.toString();
    }
    
  public void deposit(double amount){
        // MODIFIES: this
        // EFFECTS: deposits the amount to the customer's account 
        //REQUIRES: N/A
        this.balance = this.balance + amount;
        writeBankFile(this.username, this.password,this.balance);
        adjustState();
    }
    
    public void withdraw(double amount){
        // MODIFIES: this
        // EFFECTS: withdraws the amount from the customer's account
        //REQUIRES: N/A
        this.balance = this.balance - amount;
        writeBankFile(this.username, this.password,this.balance);
        adjustState();
    }
    
    public double getBalance(){
        // MODIFIES: N/A
        // EFFECTS: returns the balance of the customer's account
        //REQUIRES: N/A
        return Double.parseDouble(df.format(this.balance));
    }
    
    public void setBalance(Double ammount){
        // MODIFIES: this
        // EFFECTS: sets the balance and overrwites the customer file
        //REQUIRES: N/A
        this.balance = ammount;
        writeBankFile(this.username, this.password,this.balance);
    }
    
    public boolean repOk(){
        // MODIFIES: N/A
        // EFFECTS: returns true if the rep invarient holds true;
        //REQUIRES: N/A
        int x = 0;
        for(x=0;x<this.accounts.size();x++){
            if (this.accounts.get(x).getUsername().equals(this.getUsername())){
                return false;
            }   
        }
        if (this.getBalance()<0){
            return false;
        }
        return true;
    }
    
    //@Override
    public String toString(){
        // MODIFIES: N/A
        // EFFECTS: Implements the abstraction function by returning all usernames and balances 
        //REQUIRES: N/A
        int x = 0;
        String output = "";
        for(x=0;x<this.accounts.size();x++){
        output = output + "Username: " + this.getUsername() + " ; Balance: $" + this.getBalance() + " | ";
        }
        return output;
    }
}
