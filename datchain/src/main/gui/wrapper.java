package main.gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class wrapper extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Datchain");
        Login.login(primaryStage);
    }

}


