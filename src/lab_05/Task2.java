//https://github.com/musman65/Lab_05/tree/lab_05/src/lab_05

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_05;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        
        //Info
        double[] bevPrices = {2.50, 2.00, 1.75, 2.95, 1.50, 2.50};
        double[] appPrices = {4.50, 3.75, 5.25, 3.00, 6.95};
        double[] mainPrices = {15.00, 13.50, 13.95, 11.90, 18.99, 11.75, 12.25};
        double[] desPrices = {5.95, 4.50, 4.75, 3.25, 5.98};
        
        //Labels and Buttons
        Label bev = new Label("Beverage");
        Label app = new Label("Appetizer");
        Label main = new Label("Main Course");
        Label des = new Label("Dessert");
        Label tipLabel = new Label("Tip (%):");
        Label finalTipLabel = new Label("Tip Selected (%): 0");
        Label totalWithoutTip = new Label("Total without tip: $0");
        Label totalWithTip = new Label("Total with tip: $0");
        Button calc = new Button("Calculate Total");
        Button clear = new Button("Clear");  
        Label warning = new Label("");
        
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
        
        //Events
        calc.setOnMousePressed(event -> {
            if (bevCB.getSelectionModel().getSelectedItem() == null) {
                warning.setText("Please select a beverage!");
                totalWithoutTip.setText(totalWithoutTip.getText().substring(0, 19));
                totalWithTip.setText(totalWithTip.getText().substring(0, 16));
                return;
            }
            
            if (appCB.getSelectionModel().getSelectedItem() == null) {
                warning.setText("Please select an appetizer!");
                totalWithoutTip.setText(totalWithoutTip.getText().substring(0, 19));
                totalWithTip.setText(totalWithTip.getText().substring(0, 16));
                return;
            }
            
            if (mainCB.getSelectionModel().getSelectedItem() == null) {
                warning.setText("Please select a main course!");
                totalWithoutTip.setText(totalWithoutTip.getText().substring(0, 19));
                totalWithTip.setText(totalWithTip.getText().substring(0, 16));
                return;
            }
            
            if (desCB.getSelectionModel().getSelectedItem() == null) {
                warning.setText("Please select a dessert!");
                totalWithoutTip.setText(totalWithoutTip.getText().substring(0, 19));
                totalWithTip.setText(totalWithTip.getText().substring(0, 16));
                return;
            }
            
            double total = 0;
            
            total += bevPrices[bevCB.getSelectionModel().getSelectedIndex()];
            total += appPrices[appCB.getSelectionModel().getSelectedIndex()];
            total += mainPrices[mainCB.getSelectionModel().getSelectedIndex()];
            total += desPrices[desCB.getSelectionModel().getSelectedIndex()];
            warning.setText("");
            
            totalWithoutTip.setText(totalWithoutTip.getText().substring(0, 19) + "$" + Math.round((total) * 100) / 100.0 + " is the total without tip ($" + Math.round((tip.getValue() / 100) * 100.0 * total) / 100.0 + ") and without taxes. ($" + Math.round(total * 15.0) / 100.0 + ")");
            totalWithTip.setText(totalWithTip.getText().substring(0, 16) + "$" + Math.round((total + (tip.getValue()) * total / 100) * 115.0) / 100.0 + " is the total with tip ($" + Math.round((tip.getValue() * total / 100) * 100.0) / 100.0 + ") and with taxes. ($" + Math.round(total * 15.0) / 100.0 + ")");
        });
        
        clear.setOnMousePressed(event -> {
            bevCB.getSelectionModel().clearSelection();
            appCB.getSelectionModel().clearSelection();
            mainCB.getSelectionModel().clearSelection();
            desCB.getSelectionModel().clearSelection();
            totalWithoutTip.setText(totalWithoutTip.getText().substring(0, 19));
            totalWithTip.setText(totalWithTip.getText().substring(0, 16));
            warning.setText("");
            tip.setValue(0.0);
            finalTipLabel.setText("" + finalTipLabel.getText().substring(0, 18) + " 0");
        });
        
        tip.setOnMouseReleased(event -> {
            finalTipLabel.setText("" + finalTipLabel.getText().substring(0, 18) + Math.round(tip.getValue() * 100.0) / 100.0);
        });
        
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
        
        HBox buttons = new HBox(10, calc, clear);
        VBox tipVB = new VBox(20, tipLabel, tip);
        VBox finalInfo = new VBox(20, finalTipLabel, totalWithoutTip, totalWithTip);
        VBox vb2 = new VBox(40, gp, warning, buttons, tipVB, finalInfo);
        
        root.setCenter(vb2);
        
        //Padding and other customization
        root.setPadding(new Insets(20));
        gp.setHgap(50);
        gp.setVgap(5);
        warning.getStyleClass().add("label-warning");
        
        Scene scene = new Scene(root, 500, 600);
        scene.getStylesheets().add("styles.css");
        stage.setScene(scene);
        stage.show();
    }
}
