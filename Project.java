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


public class Project extends Application {
    public static Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
    public final static Stage primaryStage = new Stage();
    public int windowWidth = 800;
    public int windowHeight = 500;
    int initialComonentHeight = 100;
    int spacer = 30;
    
    @Override
    public void start(Stage primaryStage) {
        //setting stage
        BankAccount.initlizeArrayList();
        primaryStage = this.primaryStage;
        primaryStage.setX(100);
        primaryStage.setY(100);
        primaryStage.setWidth(windowWidth);
        primaryStage.setHeight(windowHeight);
 
        LoginPage loginPage = new LoginPage();
        setScene(loginPage);
    } 
   
    public void setScene(Page page){
        primaryStage.setScene(page.getScene());
        primaryStage.show();
    }
    
    public double centerX(Text text){ 
       return windowWidth/2-text.getLayoutBounds().getWidth()/2;
    } 
    
     public static void main(String[] args) {
        launch(args);
        }
    }
   
