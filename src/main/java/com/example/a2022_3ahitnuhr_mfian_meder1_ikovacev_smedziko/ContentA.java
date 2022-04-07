package com.example.a2022_3ahitnuhr_mfian_meder1_ikovacev_smedziko;

import Model.Uhr;
import View.ShowUhrAnalog;
import View.ShowUhrDigital;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;


/**
 * Controller für Analoge Uhr
 */
public class ContentA extends AnchorPane {

    @FXML
    private Circle clockCircle;

    @FXML
    private Line hourLine;

    @FXML
    private Line minutesLine;


    public ContentA() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ContentA.fxml"));

        fxmlLoader.setRoot(this);
        //fxmlLoader.setController(this);

        Uhr uhr = new Uhr("Leonstein");//nur zum testen, später entfernen

        ShowUhrAnalog a = new ShowUhrAnalog(uhr, clockCircle, minutesLine, hourLine);
        a.showUhr(10, 50);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

