package main.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainScreen {
    public static void screen(Stage primaryStage) {
        var root = new GridPane();
        root.setVgap(5);
        root.setHgap(5);
        //root.setAlignment();
        var scene = new Scene(root, 600, 600);
        primaryStage.setResizable(true);


        var Search_button = new Button("Search");
        root.setConstraints(Search_button,3,0);
        root.getChildren().add(Search_button);

        var logout_button = new Button("Logout");
        root.setConstraints(logout_button,0,0);
        root.getChildren().add(logout_button);
        logout_button.setOnMouseClicked(event -> Login.login(primaryStage));

        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
