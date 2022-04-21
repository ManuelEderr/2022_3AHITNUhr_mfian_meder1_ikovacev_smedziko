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
    long time;
    ShowUhrBinary showUhrBinary;
    /**
     * einzelne Kreise für die Binäre Uhr
     * werden erstellt
     */
    @FXML
    public Circle hour8;
    @FXML
    public Circle hour4;
    @FXML
    public Circle hour2;
    @FXML
    public Circle hour1;

    @FXML
    public Circle min32;
    @FXML
    public Circle min16;
    @FXML
    public Circle min8;
    @FXML
    public Circle min4;
    @FXML
    public Circle min2;
    @FXML
    public Circle min1;

    @FXML
    public Circle sec32;
    @FXML
    public Circle sec16;
    @FXML
    public Circle sec8;
    @FXML
    public Circle sec4;
    @FXML
    public Circle sec2;
    @FXML
    public Circle sec1;

    /**
     * Die FXML-Datei wird im Controller geladen und ausgegeben.
     */
    public ContentC(Uhr uhrToUse) {
        PrimaryController.BINACTIVE = true;
        uhrForC = uhrToUse;
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
    /**
     * Kreise werden initialisiert, Thread zum automatischen Updaten wird erstellt.
     */
    public void initialize() {
        Circle[] circles = {hour8, hour4, hour2, hour1, min32, min16, min8, min4, min2, min1, sec32, sec16, sec8, sec4, sec2, sec1};
        showUhrBinary = new ShowUhrBinary(circles);

        Thread threadForUpdating = new Thread(new updateBinary());
        threadForUpdating.start();


    }

    /**
     * Automatische Aktualisierung der Aktuellen Zeit
     */
    public class updateBinary implements Runnable {

        @Override
        public void run() {
            while (PrimaryController.BINACTIVE) {
                time = (uhrForC.getCurrentTime());
                showUhrBinary.upadte(time);
                try {
                    Thread.sleep(900);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}