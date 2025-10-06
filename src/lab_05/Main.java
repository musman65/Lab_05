// https://github.com/musman65/Lab_05/tree/lab_05

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
        Label orderPlaced = new Label("test");
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
        
        
        //Root and Branch Nodes
        VBox radioButtonVBox = new VBox(r1, r2, r3);
        HBox hb = new HBox(20, radioButtonVBox, cb);
        HBox hb2 = new HBox(10, order, clear);
        VBox vb = new VBox(50, hb, hb2, orderPlaced);
        HBox root = new HBox(20, mainLabel, lv, vb);
        
        //Padding and other customization
        root.setPadding(new Insets(20));
        
        
        Scene scene = new Scene(root, 700, 300);
        stage.setScene(scene);
        stage.show();
    }
    
}
