package com.example.a2022_3ahitnuhr_mfian_meder1_ikovacev_smedziko;

import Model.Uhr;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.Timestamp;

public class HelloController {
    @FXML
    private Label welcomeText;

    Uhr uhr = new Uhr();

    @FXML
    protected void onHelloButtonClick() {
        System.out.println(uhr.getCurrentTime());
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}