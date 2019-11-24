 //@author Shivam Patel

package coe528.project;

import javafx.application.Application;
import javafx.scene.control.Label;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import java.util.ArrayList;

public class LoginPage extends Project implements Page{
    
       private Pane pane = new Pane();
       private Scene scene = new Scene(pane, 0, 0);
               
       LoginPage()
       {
         //setting scene
        Text label = new Text("Canadian Bank");
        label.setFont(Font.font ("Calibri", 50));
        label.setFill(Color.GREEN);
        label.relocate(centerX(label),0);
        pane.getChildren().add(label);
        
        TextField username = new TextField("Username");    
        username.relocate(windowWidth/2-(username.getLayoutBounds().getWidth()/2)-80 ,initialComonentHeight);
        pane.getChildren().add(username);
        
        TextField password = new TextField("Password");    
        password.relocate(windowWidth/2-(password.getLayoutBounds().getWidth()/2)-80,initialComonentHeight+spacer);
        pane.getChildren().add(password);
       
        Text status = new Text("Waiting for input.");
        status.setFont(Font.font ("Calibri", 14));
        status.setFill(Color.BLACK);
        status.relocate(centerX(status),initialComonentHeight+spacer*4);
        pane.getChildren().add(status);
        
        Button loginBtn = new Button();
        loginBtn.setText("Login");
        loginBtn.relocate(windowWidth/2-(loginBtn.getLayoutBounds().getWidth()/2)-80,initialComonentHeight+spacer*2);
        
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (username.getText().equals(Manager.getUsername()) && password.getText().equals(Manager.getPassword())){
                    ManagerPage managerPage = new ManagerPage();
                    setScene(managerPage);
                }
                else{
                    int x = 0;
                    for(x=0;x<BankAccount.accounts.size();x++){
                        if (BankAccount.accounts.get(x).getUsername().equals(username.getText()) && BankAccount.accounts.get(x).getPassword().equals(password.getText())){
                            CustomerPage customerPage = new CustomerPage(BankAccount.accounts.get(x));
                            setScene(customerPage);
                        } 
                    }
                }
                status.setText("Incorrect username/password");
                status.relocate(centerX(status),initialComonentHeight+spacer*4);
            }
        });
        pane.getChildren().add(loginBtn);
       }
     
    public Scene getScene(){
        return scene;
    }

}
