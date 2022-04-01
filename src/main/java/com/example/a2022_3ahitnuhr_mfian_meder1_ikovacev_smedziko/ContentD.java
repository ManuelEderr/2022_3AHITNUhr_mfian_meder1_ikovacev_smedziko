package com.example.a2022_3ahitnuhr_mfian_meder1_ikovacev_smedziko;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ContentD extends AnchorPane {

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

}