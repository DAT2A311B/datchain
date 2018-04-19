package main.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Login {
    public static void login(Stage primaryStage){
        var root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10, 10, 10, 10));
        var scene = new Scene(root, 600, 400);

        var ID_label = new Label("ID:");
        root.getChildren().add(ID_label);

        var ID_text = new TextField("");
        root.getChildren().add(ID_text);

        var Password_label = new Label("Password:");
        root.getChildren().add(Password_label);

        var Password_text = new TextField("");
        root.getChildren().add(Password_text);

        var Login_button = new Button("Login");
        root.getChildren().add(Login_button);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
