 //@author Shivam Patel

package coe528.project;

public class Person {
    protected String username; 
    protected String password;
    protected String role;
    
    Person(){}
    
    Person(String username, String password, String role){
        this.username = username;
        this.password = password;
        this.role = role;
    }

}
