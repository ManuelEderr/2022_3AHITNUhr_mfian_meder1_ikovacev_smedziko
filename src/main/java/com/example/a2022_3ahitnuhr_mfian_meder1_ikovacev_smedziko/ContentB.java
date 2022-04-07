package com.example.a2022_3ahitnuhr_mfian_meder1_ikovacev_smedziko;

import Model.Uhr;
import View.ShowUhrDigital;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Controller für digitale Uhr
 */
public class ContentB extends AnchorPane {
    @FXML
    Label digitalTime = new Label();
    Uhr uhr;

    public ContentB(Uhr uhr) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ContentB.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);


        this.uhr = uhr;

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }



        //ShowUhrDigital sud = new ShowUhrDigital(this.uhr, digitalTime);


    }
}