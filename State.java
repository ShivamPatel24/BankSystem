 //@author Shivam Patel

package coe528.project;

import java.text.DecimalFormat;

public abstract class State {
    
    public static DecimalFormat df = new DecimalFormat("0.00");
    
    public abstract void Silver(BankAccount account);
    
    public abstract void Gold(BankAccount account);
    
    public abstract void Platinum(BankAccount account);
    
    public abstract Double onlinePurchase(BankAccount account, Double cost);
    
    public abstract String toString();
    
}
