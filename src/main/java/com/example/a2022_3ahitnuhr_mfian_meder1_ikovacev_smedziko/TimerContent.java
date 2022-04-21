package com.example.a2022_3ahitnuhr_mfian_meder1_ikovacev_smedziko;


import Model.MusicPlayer;
import View.ShowTimer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.io.SerializablePermission;


public class TimerContent extends AnchorPane {
    Thread t1;
    boolean stop;
    boolean abbruch;
    MusicPlayer musicPlayer;
    ShowTimer showTimer;
    @FXML
    VBox VboxForTimer;
    @FXML
    VBox VboxForSetting;
    @FXML
    ProgressBar ProgressBar;
    @FXML
    TextField fieldHour;
    @FXML
    TextField fieldMin;
    @FXML
    TextField fieldSec;
    @FXML
    Label LabelForH;
    @FXML
    Label LabelForM;
    @FXML
    Label LabelForS;




    public TimerContent(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TimerContent.fxml"));

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
        musicPlayer=new MusicPlayer();
        VboxForTimer.setVisible(false);
        showTimer=new ShowTimer(new Label[]{LabelForH, LabelForM, LabelForS},ProgressBar);

    }
@FXML
    public void StartStop(){
    stop=!stop;
    }
    @FXML
    public void StartNewTimer(){
        abbruch=true;
    VboxForTimer.setVisible(false);
    VboxForSetting.setVisible(true);
    }
    @FXML
    public void StartTimer(){
        int secs = Integer.parseInt(fieldHour.getText())*3600+Integer.parseInt(fieldMin.getText())*60+Integer.parseInt(fieldSec.getText());
        stop=false;
        abbruch = false;
        VboxForSetting.setVisible(false);
        VboxForTimer.setVisible(true);
        t1 = new Thread(new threadTimer(secs));
        t1.start();
    }
    public class threadTimer implements Runnable{
        int length;


        threadTimer(int length){
            this.length=length;
        }

        @Override
        public void run() {
            showTimer.initzializeValues(length);
            while (!abbruch && length > 0){
                if (!stop){
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            showTimer.updateTime(length);
                        }
                    });
                    length--;

                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Succesfully ended");
            musicPlayer.playFile("com/example/a2022_3ahitnuhr_mfian_meder1_ikovacev_smedziko/HE.mp3");
        }
    }
}