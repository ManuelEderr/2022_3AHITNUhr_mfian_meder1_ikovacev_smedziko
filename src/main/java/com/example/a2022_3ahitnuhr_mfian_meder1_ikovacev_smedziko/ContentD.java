package com.example.a2022_3ahitnuhr_mfian_meder1_ikovacev_smedziko;

import Model.Uhr;
import Model.tempAndTimezone;
import View.showEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ContentD extends AnchorPane {
    public VBox WetterVBox;
    public HBox UhrzeitHBox;
    public HBox DatumHBox;
    public Button DigitaleUhrSwitch;
    public Button AnalogeUhrSwitch;
    public Button StoppuhrSwitch;
    public Button TimerSwitch;
    public Button StartUhrSwitch;
    public Button BinaereUhrSwitch;
    public Label tempLabel;
    public showEvent showEvent;
    public tempAndTimezone tempandtimezone= null;
    public Label teimzone;
    TextField cityTextField;

    Uhr uhr;

    public ContentD(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ContentD.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onButtonClickOk() throws IOException {
        String city = cityTextField.getText();
        tempandtimezone = new tempAndTimezone(city);
        showEvent = new showEvent(tempandtimezone.getTemperature(), tempandtimezone.getTimezoneOffsetInSeconds(), tempLabel, teimzone);
        showEvent.eventShow();
        uhr = new Uhr(city);
    }

}