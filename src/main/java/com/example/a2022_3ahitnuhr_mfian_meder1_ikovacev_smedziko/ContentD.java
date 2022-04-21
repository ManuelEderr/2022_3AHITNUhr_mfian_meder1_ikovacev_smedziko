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


/**
 * Controller für die Settings
 */
public class ContentD extends AnchorPane {
    public Label tempLabel;
    public showEvent showEvent;
    public tempAndTimezone tempandtimezone= null;

    @FXML
    TextField cityTextField;

    String city;
    Uhr uhr;

    public ContentD(Label tempLabel){

        this.tempLabel = tempLabel;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ContentD.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *Eingegebene Stadt wird gesucht und mit einem getter gespeichert.
     */
    public String getCity() {
        return city;
    }

    @FXML
    /**
     * Eingegebene Stadt wird eingelesen und die aktuelle Temperatur wird ausgegeben
     */
    public void onButtonClickOk() throws IOException {
        city = cityTextField.getText();
        city.replaceAll("\\s*", "+");
        tempandtimezone = new tempAndTimezone(city);
        showEvent = new showEvent(tempandtimezone.getTemperature(), tempLabel);
        showEvent.eventShow();
    }

}