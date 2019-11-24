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

public class ManagerPage extends LoginPage implements Page{

    private Pane pane = new Pane();
    private Scene scene = new Scene(pane, 0, 0);
    
    ManagerPage(){
      //setting scene
        Text label = new Text("Canadian Bank");
        label.setFont(Font.font ("Calibri", 50));
        label.setFill(Color.GREEN);
        label.relocate(centerX(label),0);
        pane.getChildren().add(label);
        
        //titling page
        Text message = new Text("Welcome Manager");
        message.setFont(Font.font ("Calibri", 20));
        message.setFill(Color.BLUE);
        message.relocate(centerX(message),50);
        pane.getChildren().add(message);

        Button addCustomerBtn = new Button();
        addCustomerBtn.setText("Add Customer");
        addCustomerBtn.relocate(windowWidth/2-addCustomerBtn.getLayoutBounds().getWidth()/2-80,initialComonentHeight);
        addCustomerBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AddCustomerPage addCustomerPage = new AddCustomerPage();
                setScene(addCustomerPage);
            }
        });
        pane.getChildren().add(addCustomerBtn);
        
        Button deleteCustomerBtn = new Button();
        deleteCustomerBtn.setText("Delete Customer");
        deleteCustomerBtn.relocate(windowWidth/2-deleteCustomerBtn.getLayoutBounds().getWidth()/2-80,initialComonentHeight+spacer);
        deleteCustomerBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DeleteCustomerPage deleteCustomerPage = new DeleteCustomerPage();
                setScene(deleteCustomerPage);
            }
        });
        pane.getChildren().add(deleteCustomerBtn);
        
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

