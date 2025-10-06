// https://github.com/musman65/Lab_05/tree/lab_05
// TASK 01 -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab_05;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author 6298674
 */
public class Main extends Application {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Bag Order Form");
        
        //Label(s) and List View
        Label mainLabel = new Label("Select bag style:");
        Label finalLabel = new Label("test");
        ListView<String> lv = new ListView<>();
        lv.getItems().addAll("Full Decorative", "Beaded", "Pirate Design", "Fringed", "Leather", "Plain");
        lv.setMaxHeight(185);
        lv.setMaxWidth(300);
        
        //Buttons
        Button order = new Button("Place Order");
        Button clear = new Button("Clear Selections");
        
        
        //Combo box
        int quatityMax = 10;
        ComboBox<Integer> cb = new ComboBox<>();
        
        for (int i = 0; i < quatityMax; i++) {
            cb.getItems().add(i + 1);
        }
        
        //Radio Buttons
        ToggleGroup tg = new ToggleGroup();
        RadioButton r1 = new RadioButton("Small");
        RadioButton r2 = new RadioButton("Medium");
        RadioButton r3 = new RadioButton("Large");
        r1.setToggleGroup(tg);
        r2.setToggleGroup(tg);
        r3.setToggleGroup(tg);
        r1.setSelected(true);
        
        //Event Handling
        order.setOnMousePressed(event -> {
            //Data Validation
            String selectedStyle = lv.getSelectionModel().getSelectedItem();
            if (selectedStyle == null) { // If nothing is selected inside the list view
                finalLabel.getStyleClass().add("label-warning");
                finalLabel.setText("Please select a bag style to order!");
                return;
            }
            
            Integer selectedAmount = cb.getSelectionModel().getSelectedItem();
            if (selectedAmount == null) {
                finalLabel.getStyleClass().add("label-warning");
                finalLabel.setText("Please select a quantity to order!");
                return;
            }
            
            String selectedSize = "";
            if (r1.isSelected()) {
                selectedSize = "Small";
            } else if (r2.isSelected()) {
                selectedSize = "Medium";
            } else if (r3.isSelected()) {
                selectedSize = "Large";
            } else { // Logically, should NEVER run, but I put it here just in case there is a flaw in my code
                finalLabel.getStyleClass().add("label-warning");
                finalLabel.setText("There was an error with the size!");
                return;
            }
            
            finalLabel.setText("Your order of " + selectedAmount + " " + selectedSize + " " + selectedStyle + " bags has been successfully placed!");
            finalLabel.getStyleClass().add("label-style1");
        });
        
        clear.setOnMousePressed(event -> {
            lv.getSelectionModel().clearSelection();
            cb.getSelectionModel().clearSelection();
            finalLabel.setText("");
            finalLabel.getStyleClass().add("label-style1");
        });
        
        //Root and Branch Nodes
        VBox radioButtonVBox = new VBox(r1, r2, r3);
        HBox hb = new HBox(20, radioButtonVBox, cb);
        HBox hb2 = new HBox(10, order, clear);
        VBox vb = new VBox(50, hb, hb2, finalLabel);
        HBox root = new HBox(20, mainLabel, lv, vb);
        
        //Padding and other customization
        root.setPadding(new Insets(20));
        
        
        Scene scene = new Scene(root, 900, 300);
        stage.setScene(scene);
        scene.getStylesheets().add("styles.css");
        stage.show();
    }
    
}
