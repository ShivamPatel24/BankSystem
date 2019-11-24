 //@author Shivam Patel

package coe528.project;

//Singleton class because only one manager exist
public class Manager extends Person{
    
    private final static Manager manager = new Manager();

    private Manager()
    {
        super("admin","admin","Manager");
    }
    
    public static Manager getInstance(){
        return manager;
    }
    
    public static String getUsername()
    {
        return manager.username;
    }   
    
    public static String getPassword()
    {
        return manager.password;
    }
    
}
