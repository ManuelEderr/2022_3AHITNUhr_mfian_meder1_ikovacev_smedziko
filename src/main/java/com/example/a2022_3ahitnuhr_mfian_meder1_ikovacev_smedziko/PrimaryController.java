package com.example.a2022_3ahitnuhr_mfian_meder1_ikovacev_smedziko;

import Model.Uhr;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.io.IOException;


/**
 * Controller spezifisch für zwei äußeren Panels
 */
public class PrimaryController {

    public static boolean BINACTIVE = false;

    public Label tempLabel;
    public Button timerBTN;
    public Button stoppuhrBTN;
    @FXML
    BorderPane mainPane;
    @FXML
    Label LabelForTesting;

    Uhr uhr;

    String city;
    ContentA contentA;
    ContentB contentB;
    ContentC contentC;
    ContentD contentD;


    @FXML
    public void initialize() {
        System.out.println("second");
        uhr = new Uhr("AT");
        Thread updateTimeThread = new Thread(new calculateNewTime(uhr));
        updateTimeThread.start();

    }


    @FXML
    public void onBtnAClick() throws IOException {
        contentA = new ContentA();
        mainPane.setCenter(contentA);
    }

    @FXML
    public void onBtnBClick() throws IOException {
        contentB = new ContentB(uhr);
        mainPane.setCenter(contentB);
    }

    @FXML
    public void onBtnCClick() {
        contentC = new ContentC(uhr);
        mainPane.setCenter(contentC);
    }

    @FXML
    public void onBtnDClick() throws IOException {
        contentD = new ContentD(tempLabel);
        mainPane.setCenter(contentD);
    }

    public static class calculateNewTime implements Runnable {
        Uhr uhr;
        boolean abbruch;

        calculateNewTime(Uhr uhrToUpdate) {
            uhr = uhrToUpdate;
            abbruch = false;
        }

        @Override
        public void run() {
            while (!abbruch) {
                uhr.NewTime();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }


}
