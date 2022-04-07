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
    public Label timezoneLabel;
    @FXML
    public Label teimzone;
    @FXML
    TextField cityTextField;

    String city;

    Uhr uhr;

    public ContentD(Label timezoneLabel, Label tempLabel){

        this.tempLabel = tempLabel;
        this.timezoneLabel = timezoneLabel;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ContentD.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getCity() {
        return city;
    }

    @FXML
    public void onButtonClickOk() throws IOException {
        city = cityTextField.getText();
        city.replaceAll("\\s*", "+");
        tempandtimezone = new tempAndTimezone(city);
        showEvent = new showEvent(tempandtimezone.getTemperature(), tempandtimezone.getTimezoneOffsetInSeconds(), timezoneLabel, tempLabel);
        showEvent.eventShow();
        uhr = new Uhr(city);
        System.out.println(uhr.getCurrentTime());
    }



}