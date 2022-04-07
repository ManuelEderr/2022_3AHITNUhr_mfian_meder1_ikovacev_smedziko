package com.example.a2022_3ahitnuhr_mfian_meder1_ikovacev_smedziko;

import Model.Uhr;
import View.ShowUhrDigital;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ContentB extends AnchorPane {
    Label digitalTime = new Label();
    Uhr uhr;

    public ContentB(Uhr uhr){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ContentB.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }



        this.uhr = uhr;

        ShowUhrDigital sud = new ShowUhrDigital(this.uhr, digitalTime);


    }
}