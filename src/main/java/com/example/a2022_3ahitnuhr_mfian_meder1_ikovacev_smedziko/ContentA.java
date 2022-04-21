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

    /**
     * Die FXML-Datei wird im Controller geladen und ausgegeben.
     */
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

    /**
     * Uhr wird initialisiert, Thread zum automatischen Updaten wird erstellt.
     */
    @FXML
    public void initialize() {
         a = new ShowUhrAnalog(uhrForA, clockCircle, minutesLine, hourLine, secondLine, stackPaneAnalog);
        Thread t1 = new Thread(new updateAnalog());
        t1.start();
    }

    /**
     * Automatische Aktualisierung der Aktuellen Zeit
     */
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

