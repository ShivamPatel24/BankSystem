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

public class WithdrawPage extends CustomerPage implements Page {
    private Pane pane = new Pane();
    private Scene scene = new Scene(pane, 0, 0);
    private BankAccount account;
    
    WithdrawPage(BankAccount account){
        super(account);
        this.account = account;
        
         //setting scene
        Text label = new Text("Canadian Bank");
        label.setFont(Font.font ("Calibri", 50));
        label.setFill(Color.GREEN);
        label.relocate(centerX(label),0);
        pane.getChildren().add(label);
     
        //titling page
        Text message = new Text("Withdraw");
        message.setFont(Font.font ("Calibri", 20));
        message.setFill(Color.BLUE);
        message.relocate(centerX(message),50);
        pane.getChildren().add(message);
        
        Text status = new Text("Waiting for input.");
        status.setFont(Font.font ("Calibri", 14));
        status.setFill(Color.BLACK);
        status.relocate(centerX(status),initialComonentHeight+spacer*4);
        pane.getChildren().add(status);
         
        TextField withdrawValue = new TextField("Withdraw Value");    
        withdrawValue.relocate(windowWidth/2-(withdrawValue.getLayoutBounds().getWidth()/2)-80 ,initialComonentHeight);
        pane.getChildren().add(withdrawValue);
        
        Button withdrawBtn = new Button();
        withdrawBtn.setText("Withdraw");
        withdrawBtn.relocate(windowWidth/2-withdrawBtn.getLayoutBounds().getWidth()/2-80,initialComonentHeight+spacer);
        withdrawBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int passDoubleTest = 1;
                try {
                    double withdrawAmmount = Double.parseDouble(withdrawValue.getText());
                } catch (NumberFormatException | NullPointerException nfe) {
                    status.setText("Invalid withdraw ammount, try again");
                    status.relocate(centerX(status),initialComonentHeight+spacer*4);
                    passDoubleTest = 0;
                }
                double withdrawAmmount = Double.parseDouble(withdrawValue.getText());
                if (passDoubleTest == 1 && withdrawAmmount>0 && withdrawAmmount<account.getBalance()){
                    account.withdraw(withdrawAmmount);
                    status.setText("Successfully withdrew: $" + withdrawValue.getText() + " | New Balance: $" + account.getBalance());
                    status.relocate(centerX(status),initialComonentHeight+spacer*4);
                }
                else if (passDoubleTest == 1){
                    status.setText("Withdraw amount negative or larger than balance");
                    status.relocate(centerX(status),initialComonentHeight+spacer*4);
                }
            }
        });
        pane.getChildren().add(withdrawBtn);
        
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
                CustomerPage customerPage = new CustomerPage(account);
                setScene(customerPage);
            }
        });
        pane.getChildren().add(backBtn);
    }
    
    public Scene getScene(){
           return scene;
    }
}
