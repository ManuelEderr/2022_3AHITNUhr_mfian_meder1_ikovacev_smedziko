package com.example.a2022_3ahitnuhr_mfian_meder1_ikovacev_smedziko;

import Model.Uhr;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContentB extends AnchorPane {
    Uhr uhr;

    @FXML
    private Label digitalTime;

    @FXML
    private Label digitalDate;


    public ContentB(Uhr uhr) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ContentB.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }



        this.uhr = uhr;


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH : mm : ss");
        digitalTime.setText(dtf.format(LocalDateTime.now()));
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd / MM / yyyy");
        digitalDate.setText(dtf2.format(LocalDateTime.now()));


    }

}


