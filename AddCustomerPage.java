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

public class AddCustomerPage extends ManagerPage implements Page{

    private Pane pane = new Pane();
    private Scene scene = new Scene(pane, 0, 0);
    
    AddCustomerPage(){
          //setting scene
        Text label = new Text("Canadian Bank");
        label.setFont(Font.font ("Calibri", 50));
        label.setFill(Color.GREEN);
        label.relocate(centerX(label),0);
        pane.getChildren().add(label);
           
        //titling page
        Text message = new Text("Add Customer");
        message.setFont(Font.font ("Calibri", 20));
        message.setFill(Color.BLUE);
        message.relocate(centerX(message),50);
        pane.getChildren().add(message);
      
        Text status = new Text("Waiting for input.");
        status.setFont(Font.font ("Calibri", 14));
        status.setFill(Color.BLACK);
        status.relocate(centerX(status),initialComonentHeight+spacer*4);
        pane.getChildren().add(status);
        
        TextField username = new TextField("Customer Username");    
        username.relocate(windowWidth/2-(username.getLayoutBounds().getWidth()/2)-80 ,initialComonentHeight);
        pane.getChildren().add(username);
        
        TextField password = new TextField("Customer Password");    
        password.relocate(windowWidth/2-(password.getLayoutBounds().getWidth()/2)-80,initialComonentHeight+spacer);
        pane.getChildren().add(password);
        
        Button addBtn = new Button();
        addBtn.setText("Add Customer");
        addBtn.relocate(windowWidth/2-(addBtn.getLayoutBounds().getWidth()/2)-80,initialComonentHeight+spacer*2);
        addBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int x=0;
                int createCustomer = 1;
                
                for(x=0;x<BankAccount.accounts.size();x++){
                    if (BankAccount.accounts.get(x).getUsername().equals(username.getText().toLowerCase())){
                        status.setText("Username taken!");
                        status.relocate(centerX(status),initialComonentHeight+spacer*4);
                        createCustomer = 0;     
                    }
                }
                if (createCustomer == 1){
                    BankAccount account = new BankAccount(username.getText().toLowerCase(),password.getText(),100.0);
                    BankAccount.accounts.add(account);
                    status.setText("Customer account created!");
                    status.relocate(centerX(status),initialComonentHeight+spacer*4);
                }
            }
        });
        pane.getChildren().add(addBtn);
       
        Button logoutBtn = new Button();
        logoutBtn.setText("Logout");
        logoutBtn.relocate(windowWidth-80,windowHeight-80);
        logoutBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LoginPage loginPage = new LoginPage();
                setScene(loginPage);
            }
        });
        pane.getChildren().add(logoutBtn);
        
        Button backBtn = new Button();
        backBtn.setText("Back");
        backBtn.relocate(20,windowHeight-80);
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ManagerPage managerPage = new ManagerPage();
                setScene(managerPage);
            }
        });
        pane.getChildren().add(backBtn);
    }
    
    public Scene getScene(){
           return scene;
    }
}
