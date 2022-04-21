package com.example.a2022_3ahitnuhr_mfian_meder1_ikovacev_smedziko;

import Model.Uhr;
import View.ShowUhrBinary;
import View.ShowUhrDigital;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * Controller für Digitale Uhr
 */
public class ContentB extends AnchorPane {
    Uhr uhr;
    long time;
    ShowUhrDigital showUhrDigital;
    String inputDate= "20221224";
    String inputFormat = "yyyyMMdd";
    /**
     * Labels für digitale Uhrzeit und digitales Datum
     */
    @FXML
    private Label digitalTime;

    @FXML
    private Label digitalDate;

    @FXML
    private Label calendarWeek;

    /**
     * Die FXML-Datei wird im Controller geladen und ausgegeben.
     */
    public ContentB(Uhr uhr) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ContentB.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * Thread zum automatischen Aktualisieren der Uhrzeit
         * DateTimeFormatter = aktuelle Uhrzeit und Datum werden eingelesen
         * SimpleDateFormat = akutelle Kalenderwoche
         *
         */
        Thread thread = new Thread(new Runnable() {
         @Override
         public void run() {
             Runnable updater = new Runnable() {
                 @Override
                 public void run() {
                     DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH : mm : ss");
                     digitalTime.setText(dtf.format(LocalDateTime.now()));
                     DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd / MMM / yyyy");
                     digitalDate.setText(dtf2.format(LocalDateTime.now()));

                     SimpleDateFormat dateFormat = new SimpleDateFormat(inputFormat);
                     Date date = new Date();

                     Calendar calendar = Calendar.getInstance();
                     calendar.setTime(date);
                     int weekNumber = calendar.get(Calendar.WEEK_OF_YEAR);
                     calendarWeek.setText("Kalenderwoche: " + weekNumber);
                 }
             };
             while (true){
                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 Platform.runLater(updater);
             }
         }
     });
        thread.setDaemon(true);
        thread.start();



    }

}


