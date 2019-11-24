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

public class CustomerPage extends LoginPage implements Page{
    
    private Pane pane = new Pane();
    private Scene scene = new Scene(pane, 0, 0);
    private BankAccount account;
    
    CustomerPage(BankAccount account){
        this.account = account;
        //setting scene
        Text bankName = new Text("Canadian Bank");
        bankName.setFont(Font.font ("Calibri", 50));
        bankName.setFill(Color.GREEN);
        bankName.relocate(centerX(bankName),0);
        pane.getChildren().add(bankName);
        
        //titling page
        Text message = new Text("Welcome Customer | Your Status: "+ account.getState());
        message.setFont(Font.font ("Calibri", 20));
        message.setFill(Color.BLUE);
        message.relocate(centerX(message),50);
        pane.getChildren().add(message);
        
        Button getBalanceBtn = new Button();
        getBalanceBtn.setText("Get Balance");
        getBalanceBtn.relocate(windowWidth/2-getBalanceBtn.getLayoutBounds().getWidth()/2-80,initialComonentHeight);
        
        getBalanceBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                BalancePage balancePage = new BalancePage(account);
                setScene(balancePage);
            }
        });
        pane.getChildren().add(getBalanceBtn);
        
        Button withdrawBtn = new Button();
        withdrawBtn.setText("Withdraw");
        withdrawBtn.relocate(windowWidth/2-withdrawBtn.getLayoutBounds().getWidth()/2-80,initialComonentHeight+spacer);
        
        withdrawBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                WithdrawPage withdrawPage = new WithdrawPage(account);
                setScene(withdrawPage);
            }
        });
        pane.getChildren().add(withdrawBtn);
        
        Button depositBtn = new Button();
        depositBtn.setText("Deposit");
        depositBtn.relocate(windowWidth/2-depositBtn.getLayoutBounds().getWidth()/2-80,initialComonentHeight+spacer*2);
        
        depositBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DepositPage depositPage = new DepositPage(account);
                setScene(depositPage);
            }
        });
        pane.getChildren().add(depositBtn);
        
        Button onlineBtn = new Button();
        onlineBtn.setText("Online Purchase");
        onlineBtn.relocate(windowWidth/2-onlineBtn.getLayoutBounds().getWidth()/2-80,initialComonentHeight+spacer*3);
        onlineBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                OnlinePage onlinePage = new OnlinePage(account);
                setScene(onlinePage);
            }
        });
        pane.getChildren().add(onlineBtn);
        
        
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
        
        
        
    }
    
    public Scene getScene(){
        return scene;
    }

}
