package com.example.a2022_3ahitnuhr_mfian_meder1_ikovacev_smedziko;

import Model.Uhr;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ContentC extends AnchorPane {
Uhr uhrForC;

    public ContentC(Uhr uhrToUse){
        uhrForC=uhrToUse;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ContentC.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}