package com.example.a2022_3ahitnuhr_mfian_meder1_ikovacev_smedziko;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * JavaFX App
 */public class App extends Application {
    Parent root;
    Stage stage;

    @Override
    public void start(Stage primaryStage) {
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("primary.fxml")));
            stage = primaryStage;
            stage.setTitle("Stage");

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}