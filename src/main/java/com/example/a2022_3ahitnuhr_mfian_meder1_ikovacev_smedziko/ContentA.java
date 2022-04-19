package com.example.a2022_3ahitnuhr_mfian_meder1_ikovacev_smedziko;

import Model.Uhr;
import View.ShowUhrAnalog;
import View.ShowUhrBinary;
import View.ShowUhrDigital;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;


/**
 * Controller für Analoge Uhr
 */
public class ContentA extends AnchorPane {
    @FXML
    private StackPane stackPaneAnalog;

    @FXML
    private Circle clockCircle;

    @FXML
    private Line hourLine;

    @FXML
    private Line minutesLine;

    @FXML
    private Line secondLine;


    Uhr uhrForA;
    ShowUhrAnalog a;

    public ContentA(Uhr uhr) throws IOException {
        PrimaryController.ANAACTIVE = true;
        uhrForA = uhr;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ContentA.fxml"));

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
/*
        Circle[] circles = {hour8, hour4, hour2, hour1, min32, min16, min8, min4, min2, min1, sec32, sec16, sec8, sec4, sec2, sec1};
        showUhrBinary = new ShowUhrBinary(circles);
*//*
        stackPaneAnalog.getChildren().clear();
        stackPaneAnalog.getChildren().addAll(clockCircle, minutesLine, hourLine, secondLine);*/
        a = new ShowUhrAnalog(uhrForA, clockCircle, minutesLine, hourLine, secondLine, stackPaneAnalog);
        Thread t1 = new Thread(new updateAnalog());
        t1.start();
    }


    public class updateAnalog implements Runnable  {

        @Override
        public void run() {
            while (PrimaryController.ANAACTIVE) {
                try {
                    a.upadte(uhrForA);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(900);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

