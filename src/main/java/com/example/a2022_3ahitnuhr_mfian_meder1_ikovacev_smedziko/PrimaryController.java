package com.example.a2022_3ahitnuhr_mfian_meder1_ikovacev_smedziko;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class PrimaryController {

    public Label tempLabel;
    public Label timezoneLabel;
    public Button timerBTN;
    public Button stoppuhrBTN;
    @FXML
    BorderPane mainPane;


    @FXML
    public void onBtnAClick(){
        ContentA contentA = new ContentA();
        mainPane.setCenter(contentA);
    }

    @FXML
    public void onBtnBClick(){
        ContentB contentB = new ContentB();
        mainPane.setCenter(contentB);
    }

    @FXML
    public void onBtnCClick(){
        ContentC contentC = new ContentC();
        mainPane.setCenter(contentC);
    }

    @FXML
    public void onBtnDClick() {
        ContentD contentD = new ContentD();
        mainPane.setCenter(contentD);
    }
}
