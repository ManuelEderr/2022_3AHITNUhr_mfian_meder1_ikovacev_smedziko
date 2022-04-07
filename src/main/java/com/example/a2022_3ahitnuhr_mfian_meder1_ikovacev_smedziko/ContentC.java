package com.example.a2022_3ahitnuhr_mfian_meder1_ikovacev_smedziko;

import Model.Uhr;
import View.ShowUhrBinary;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * Controller für Binaere Uhr
 */
public class ContentC extends AnchorPane {
Uhr uhrForC;
String time;
ShowUhrBinary showUhrBinary;
@FXML
    Circle hour8;

    public ContentC(Uhr uhrToUse){
        uhrForC=uhrToUse;
        showUhrBinary=new ShowUhrBinary();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ContentC.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void initialize() {
        //hour8.setFill(javafx.scene.paint.Color.RED);
        time = (uhrForC.getCurrentTime().toString().split(" ")[1]);
        String[] timeinHourMinSec=time.split(":");
        showUhrBinary.upadte(timeinHourMinSec);



    }
}