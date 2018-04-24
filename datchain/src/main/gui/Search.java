package main.gui;

import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.*;

public class Search {
    public static void Search() {
        var Search_stage = new Stage();
        Search_stage.setTitle("Search");
        var root = new HBox();
        var scene = new Scene(root,500, 200);


        var splitpane1 = new SplitPane();
        splitpane1.setOrientation(Orientation.VERTICAL);
        splitpane1.setPrefSize(200,200);

        var firstname_label = new javafx.scene.control.Label("Fornavn:");
        var lastname_label = new javafx.scene.control.Label("Efternavn:");
        var ID_label = new Label("ID-nummer:");
        splitpane1.getItems().addAll(firstname_label, lastname_label, ID_label);

        root.getChildren().add(splitpane1);





        Search_stage.setScene(scene);
        Search_stage.show();




    }
}
