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
    public static void login(Stage primaryStage) {
        var root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10, 10, 10, 10));
        var scene = new Scene(root, 600, 150);
        primaryStage.setResizable(false);

        var ID_label = new Label("Private-ID:");
        root.getChildren().add(ID_label);

        var ID_text = new TextField();
        root.getChildren().add(ID_text);

        var Login_button = new Button("Login");
        Login_button.setMinWidth(80);
        Login_button.setMinHeight(30);
        root.getChildren().add(Login_button);
        Login_button.setOnMouseClicked(event -> MainScreen.screen(primaryStage));

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
