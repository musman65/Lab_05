//https://github.com/musman65/Lab_05/tree/lab_05/src/lab_05

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_05;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author 6298674
 */
public class Task2 extends Application {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Bill Calculator");
        
        //Labels and Buttons
        Label bev = new Label("Beverage");
        Label app = new Label("Appetizer");
        Label main = new Label("Main Course");
        Label des = new Label("Dessert");
        Label tipLabel = new Label("Tip (%):");
        
        //Slider
        Slider tip = new Slider(0.0, 20.0, 0.0);
        tip.setShowTickLabels(true);
        tip.setShowTickMarks(true);
        
        //Combo Boxes
        ComboBox<String> bevCB = new ComboBox<>();
        ComboBox<String> appCB = new ComboBox<>();
        ComboBox<String> mainCB = new ComboBox<>();
        ComboBox<String> desCB = new ComboBox<>();
        
        bevCB.getItems().addAll("Coffee", "Tea", "Soft Drink", "Water", "Milk", "Juice");
        appCB.getItems().addAll("Soup", "Salad", "Spring Rolls", "Garlic Bread", "Chips and Salsa");
        mainCB.getItems().addAll("Steak", "Grilled Chicken", "Chicken Alfredo", "Turkey Club", "Shrimp Scampi", "Pasta", "Fish and Chips");
        desCB.getItems().addAll("Apple Pie", "Carrot Cake", "Mud Pie", "Pudding", "Apple Crisp");
        
        double comboBoxWidth = 150;
        bevCB.setPrefWidth(comboBoxWidth);
        appCB.setPrefWidth(comboBoxWidth);
        mainCB.setPrefWidth(comboBoxWidth);
        desCB.setPrefWidth(comboBoxWidth);
        
        //Panes
        BorderPane root = new BorderPane();
        GridPane gp = new GridPane();
        
        gp.add(bev,         0, 0);
        gp.add(bevCB,       1, 0);
        
        gp.add(app,         0, 1);
        gp.add(appCB,       1, 1);
        
        gp.add(main,        0, 2);
        gp.add(mainCB,      1, 2);
        
        gp.add(des,         0, 3);
        gp.add(desCB,       1, 3);
        
        VBox vb = new VBox(20, tipLabel, tip);
        VBox vb2 = new VBox(40, gp, vb);
        
        root.setCenter(vb2);
        
        //Padding and other customization
        root.setPadding(new Insets(20));
        gp.setHgap(50);
        
        Scene scene = new Scene(root, 500, 300);
        stage.setScene(scene);
        stage.show();
    }
}
