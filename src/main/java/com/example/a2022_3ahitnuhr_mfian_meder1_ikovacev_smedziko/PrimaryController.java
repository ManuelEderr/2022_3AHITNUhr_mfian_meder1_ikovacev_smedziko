package com.example.a2022_3ahitnuhr_mfian_meder1_ikovacev_smedziko;

import Model.Uhr;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

import java.io.IOException;
import java.util.Optional;


/**
 * Controller spezifisch für zwei äußeren Panels
 */
public class PrimaryController {

    public static boolean BINACTIVE = false;
    public static boolean DIGACTIVE = false;
    public static boolean ANAACTIVE = false;

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
        ANAACTIVE=false;
    }

    @FXML
    public void onBtnCClick() {
        contentC = new ContentC(uhr);
        mainPane.setCenter(contentC);
        BINACTIVE=true;
        DIGACTIVE=false;
        ANAACTIVE=false;
    }

    @FXML
    public void onBtnDClick() throws IOException {
        contentD = new ContentD(tempLabel);
        mainPane.setCenter(contentD);
        BINACTIVE=false;
        DIGACTIVE=false;
        ANAACTIVE=false;
    }

    public void onTimerBTNclick(ActionEvent actionEvent) {
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Timer");

        VBox vBox = new VBox();

        Label timer = new Label(Long.toString(uhr.getCurrentTime()));


        vBox.getChildren().addAll(new Label("Timer"), timer, new Button());


        dialog.getDialogPane().setContent(vBox);
        dialog.showAndWait();
        System.out.println(dialog.isShowing());
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
