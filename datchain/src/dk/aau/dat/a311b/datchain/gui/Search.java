package dk.aau.dat.a311b.datchain.gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Search {
    public static void Search() {
        var Search_stage = new Stage();
        Search_stage.setTitle("Search");
        var root = new GridPane();
        root.setVgap(7);
        root.setHgap(5);
        root.setPadding(new Insets(10, 10, 10, 10));
        var scene = new Scene(root,600, 230);


        var term_label = new Label("Input:");
        term_label.setMinWidth(150);
        root.setConstraints(term_label,0,0);
        root.getChildren().add(term_label);
        var term_text = new TextField();
        root.setConstraints(term_text,0,1);
        root.getChildren().add(term_text);

        /*var firstname_label = new Label("Fornavn:");
        firstname_label.setMinWidth(150);
        root.setConstraints(firstname_label,0,0);
        root.getChildren().add(firstname_label);
        var firstname_text = new TextField();
        root.setConstraints(firstname_text,0,1);
        root.getChildren().add(firstname_text);

        var lastname_label = new Label("Efternavn:");
        root.setConstraints(lastname_label,0,2);
        root.getChildren().add(lastname_label);
        var lastname_text = new TextField();
        root.setConstraints(lastname_text,0,3);
        root.getChildren().add(lastname_text);

        var ID_label = new Label("ID-nummer:");
        root.setConstraints(ID_label,0,4);
        root.getChildren().add(ID_label);
        var ID_text = new TextField();
        root.setConstraints(ID_text,0,5);
        root.getChildren().add(ID_text);
        */
        var Search_button = new Button("Search");
        root.setConstraints(Search_button,0,7);
        root.getChildren().add(Search_button);

        var listView = new ListView<>();
        listView.setMinWidth(420);
        listView.getItems().addAll("eks. 1", "eks. 2", "eks. 3");
        root.setConstraints(listView,1,0,1,7);
        root.getChildren().add(listView);

        Search_stage.setScene(scene);
        Search_stage.show();




    }
}
