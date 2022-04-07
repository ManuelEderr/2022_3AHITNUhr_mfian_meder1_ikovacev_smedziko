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
    public Label timezoneLabel;
    public Button timerBTN;
    public Button stoppuhrBTN;
    @FXML
    BorderPane mainPane;

    Uhr uhr;

    String city;




    @FXML
    public void onBtnAClick(){
        ContentA contentA = new ContentA();
        mainPane.setCenter(contentA);
    }

    @FXML
    public void onBtnBClick(){
        ContentB contentB = new ContentB(uhr);
        mainPane.setCenter(contentB);
    }

    @FXML
    public void onBtnCClick(){
        ContentC contentC = new ContentC();
        mainPane.setCenter(contentC);
    }

    @FXML
    public void onBtnDClick() throws IOException {
        ContentD contentD = new ContentD(tempLabel, timezoneLabel);
        mainPane.setCenter(contentD);
        city = contentD.getCity();

        uhr = new Uhr(city);


    }


}
