/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 *
 * @author Shivam Patel
 */
public class PlatinumState extends State{
    
    public void Silver(BankAccount account){
        if (account.getBalance()<10000)
            {
                account.currentState = new SilverState();
            }
    }
    
    public void Gold(BankAccount account){
        if (account.getBalance()>=10000 && account.getBalance()<20000)
        {
            account.currentState = new GoldState();
        }
    }
    
    public void Platinum(BankAccount account){
        
    }
    
    public Double onlinePurchase(BankAccount account, Double cost){
        account.setBalance(account.getBalance() - cost);
        account.adjustState();
        return Double.parseDouble(df.format(cost));
    }
     
    public String toString(){
        return "Platinum";
    }
}
