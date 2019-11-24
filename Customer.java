 //@author Shivam Patel

package coe528.project;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class Customer extends Person{
    Customer(){
        super();
    }
    
    Customer(String username, String password){
        super(username, password, "Customer");     
    }

    public String getPassword()
    {
        return password;
    }
    
    public String getUsername()
    {
        return username;
    }  
}
