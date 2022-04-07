package com.example.a2022_3ahitnuhr_mfian_meder1_ikovacev_smedziko;

import Model.Uhr;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class PrimaryController {

    public Label tempLabel;
    public Button timerBTN;
    public Button stoppuhrBTN;
    @FXML
    BorderPane mainPane;

    Uhr uhr;

    String city;
    ContentA contentA;
    ContentB contentB;
    ContentC contentC;
    ContentD contentD;



    @FXML
    public void onBtnAClick(){
        contentA = new ContentA();
        mainPane.setCenter(contentA);
    }

    @FXML
    public void onBtnBClick() throws IOException {
        contentB = new ContentB(uhr);
        mainPane.setCenter(contentB);
    }

    @FXML
    public void onBtnCClick(){
        contentC = new ContentC();
        mainPane.setCenter(contentC);
    }

    @FXML
    public void onBtnDClick() throws IOException {
        contentD = new ContentD(tempLabel);
        mainPane.setCenter(contentD);
    }








}
