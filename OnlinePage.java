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

public class OnlinePage extends CustomerPage implements Page{
    
    private Pane pane = new Pane();
    private Scene scene = new Scene(pane, 0, 0);
    private BankAccount account;
    
    OnlinePage(BankAccount account){
        super(account);
        this.account = account;
        
        //setting scene
        Text label = new Text("Canadian Bank");
        label.setFont(Font.font ("Calibri", 50));
        label.setFill(Color.GREEN);
        label.relocate(centerX(label),0);
        pane.getChildren().add(label);
           
        //titling page
        Text message = new Text("Online Transfer");
        message.setFont(Font.font ("Calibri", 20));
        message.setFill(Color.BLUE);
        message.relocate(centerX(message),50);
        pane.getChildren().add(message);
        
        Text status = new Text("Waiting for input.");
        status.setFont(Font.font ("Calibri", 14));
        status.setFill(Color.BLACK);
        status.relocate(centerX(status),initialComonentHeight+spacer*4);
        pane.getChildren().add(status);
        
        Text feeMessage = new Text(" "); 
        status.setFont(Font.font ("Calibri", 14));
        status.setFill(Color.BLACK);
        status.relocate(centerX(status),initialComonentHeight+spacer*5);
        pane.getChildren().add(feeMessage);
        
        Text balanceMessage = new Text(" ");  
        status.setFont(Font.font ("Calibri", 14));
        status.setFill(Color.BLACK);
        status.relocate(centerX(status),initialComonentHeight+spacer*4);
        pane.getChildren().add(balanceMessage);
        
        
        TextField vendor = new TextField("Name of Vendor");    
        vendor.relocate(windowWidth/2-(vendor.getLayoutBounds().getWidth()/2)-80 ,initialComonentHeight);
        pane.getChildren().add(vendor);

        TextField cost = new TextField("Cost of Product");    
        cost.relocate(windowWidth/2-(cost.getLayoutBounds().getWidth()/2)-80 ,initialComonentHeight + spacer);
        pane.getChildren().add(cost);
        
        Button purchaseBtn = new Button();
        purchaseBtn.setText("Purchase");
        purchaseBtn.relocate(windowWidth/2-purchaseBtn.getLayoutBounds().getWidth()/2-80,initialComonentHeight+spacer*2);
        purchaseBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int passDoubleTest = 1;
                try {
                    double costAmmount = Double.parseDouble(cost.getText());
                } catch (NumberFormatException | NullPointerException nfe) {
                    status.setText("Invalid cost, try again");
                    status.relocate(centerX(status),initialComonentHeight+spacer*4);
                    passDoubleTest = 0;
                }
                double costAmmount = Double.parseDouble(cost.getText());
                if (passDoubleTest == 1 && costAmmount>=50 && costAmmount<account.getBalance()){
                    double totalCost = account.onlinePurchase(costAmmount);
                    status.setText("Successfully purchased product from " + vendor.getText() + " for: $" + cost.getText());
                    status.relocate(centerX(status),initialComonentHeight+spacer*4);
                    feeMessage.setText("Fee: $" + (totalCost-costAmmount));
                    feeMessage.relocate(centerX(status),initialComonentHeight+spacer*5);
                    balanceMessage.setText("Balance: $" + account.getBalance());
                    balanceMessage.relocate(centerX(status),initialComonentHeight+spacer*6);
                }
                else if (passDoubleTest == 1){
                    status.setText("Cost amount less than $50 or larger than balance");
                    status.relocate(centerX(status),initialComonentHeight+spacer*4);
                }
            }
        });
        pane.getChildren().add(purchaseBtn);
        
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
