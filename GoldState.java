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
public class GoldState extends State{
    
    public void Silver(BankAccount account){
        if (account.getBalance()<10000)
            {
                account.currentState = new SilverState();
            }
    }
    
    public void Gold(BankAccount account){
    }
    
    public void Platinum(BankAccount account){
        if (account.getBalance()>=20000)
        {
        account.currentState = new PlatinumState();
        }
    }
    
    public Double onlinePurchase(BankAccount account, Double cost){
        account.setBalance(account.getBalance() - cost - 10);
        account.adjustState();
        return Double.parseDouble(df.format((cost+10)));
    }
     
    public String toString(){
        return "Gold";
    } 
}
