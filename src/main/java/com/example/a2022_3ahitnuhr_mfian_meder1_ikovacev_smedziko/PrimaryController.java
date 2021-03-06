package com.example.a2022_3ahitnuhr_mfian_meder1_ikovacev_smedziko;

import Model.Uhr;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


import java.io.IOException;


/**
 * Controller spezifisch für zwei äußeren Panels
 */
public class PrimaryController {

    public static  boolean ANAACTIVE = false;
    public static boolean BINACTIVE = false;
    public static boolean DIGACTIVE = false;

    public Label tempLabel;
    public Button stoppuhrBTN;
    public VBox vBoxForEvents;
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
    TimerContent timerContent;


    @FXML
    public void initialize() {
        System.out.println("second");
        uhr = new Uhr("AT");
        Thread updateTimeThread = new Thread(new calculateNewTime(uhr));
        updateTimeThread.start();


    }


    @FXML
    public void onBtnAClick() throws IOException {
        contentA = new ContentA(uhr);
        mainPane.setCenter(contentA);
        BINACTIVE=false;
        DIGACTIVE=false;
        ANAACTIVE=true;
    }

    @FXML
    public void onBtnBClick() throws IOException {
        contentB = new ContentB(uhr);
        mainPane.setCenter(contentB);
        BINACTIVE=false;
        DIGACTIVE=true;
    }

    @FXML
    public void onBtnCClick() {
        contentC = new ContentC(uhr);
        mainPane.setCenter(contentC);
        BINACTIVE=true;
        DIGACTIVE=false;
    }

    @FXML
    public void onBtnDClick() throws IOException {
         contentD = new ContentD(tempLabel);
        mainPane.setCenter(contentD);
        BINACTIVE=false;
        DIGACTIVE=false;
    }
    @FXML
    public void onTimerClick(){
        if (timerContent == null) {
            timerContent = new TimerContent();
        }
        mainPane.setCenter(timerContent);
        BINACTIVE=false;
        DIGACTIVE=false;

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
                    Thread.sleep(900);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }


}
