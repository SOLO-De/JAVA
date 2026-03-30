package com.example.javafxsolo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
    VBox root = new VBox(10);
    Scene scene = new Scene(root,300,80);
    stage.setScene(scene);
    stage.setTitle("Hello JavaFX");
    stage.show();
    Label labelHello = new Label("Hello");
    root.getChildren().add(labelHello);
    Label labelHelloBis = new Label("Hello JavaFX");
    root.getChildren().add(labelHelloBis);
    File css = new File("css"+ File.separator+"premiersStyles.css");
    scene.getStylesheets().add(css.toURI().toString());

    }
}
